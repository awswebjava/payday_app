package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class antiguedad_anios extends GXProcedure
{
   public antiguedad_anios( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( antiguedad_anios.class ), "" );
   }

   public antiguedad_anios( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             String aP4 ,
                             short[] aP5 )
   {
      antiguedad_anios.this.aP6 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        String aP4 ,
                        short[] aP5 ,
                        String[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             String aP4 ,
                             short[] aP5 ,
                             String[] aP6 )
   {
      antiguedad_anios.this.AV8CliCod = aP0;
      antiguedad_anios.this.AV12EmpCod = aP1;
      antiguedad_anios.this.AV9LegNumero = aP2;
      antiguedad_anios.this.AV14LiqPeriodo = aP3;
      antiguedad_anios.this.AV26ParamPalabra = aP4;
      antiguedad_anios.this.aP5 = aP5;
      antiguedad_anios.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_date1[0] = AV11LegFecIngreso ;
      GXv_date2[0] = AV10LegFecEgreso ;
      new web.getfecingresoyegreso(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV9LegNumero, GXv_date1, GXv_date2) ;
      antiguedad_anios.this.AV11LegFecIngreso = GXv_date1[0] ;
      antiguedad_anios.this.AV10LegFecEgreso = GXv_date2[0] ;
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV10LegFecEgreso)) )
      {
         AV13FecHasta = AV10LegFecEgreso ;
      }
      else
      {
         AV13FecHasta = AV14LiqPeriodo ;
      }
      AV15fecDesde = AV11LegFecIngreso ;
      while ( (( GXutil.resetTime(AV15fecDesde).before( GXutil.resetTime( AV13FecHasta )) ) || ( GXutil.dateCompare(GXutil.resetTime(AV15fecDesde), GXutil.resetTime(AV13FecHasta)) )) )
      {
         AV15fecDesde = GXutil.addmth( AV15fecDesde, (short)(1)) ;
         if ( (( GXutil.resetTime(AV15fecDesde).before( GXutil.resetTime( AV13FecHasta )) ) || ( GXutil.dateCompare(GXutil.resetTime(AV15fecDesde), GXutil.resetTime(AV13FecHasta)) )) )
         {
            AV16meses = (short)(AV16meses+1) ;
            AV21diasDiferencia = (short)(GXutil.ddiff(AV13FecHasta,AV15fecDesde)) ;
         }
         if ( AV16meses == 12 )
         {
            AV18anios = AV18anios.add(DecimalUtil.doubleToDec(1)) ;
            AV16meses = (short)(0) ;
         }
      }
      if ( AV21diasDiferencia > 0 )
      {
         AV29mesesOriginales = AV16meses ;
         AV16meses = (short)(AV16meses+1) ;
      }
      AV25antiguedadIndemnizacionPalabra = "[antiguedad_indemnizacion]" ;
      if ( GXutil.strcmp(AV26ParamPalabra, AV25antiguedadIndemnizacionPalabra) == 0 )
      {
         GXv_char3[0] = AV28ParmValue ;
         new web.getparametro(remoteHandle, context).execute( AV8CliCod, new web.antiguedad_fraccion_aniomes_codigoparam(remoteHandle, context).executeUdp( ), GXv_char3) ;
         antiguedad_anios.this.AV28ParmValue = GXv_char3[0] ;
         AV19mesesParametro = (short)(GXutil.lval( AV28ParmValue)) ;
         if ( AV16meses > AV19mesesParametro )
         {
            AV18anios = AV18anios.add(DecimalUtil.doubleToDec(1)) ;
            AV24extra = true ;
         }
      }
      else
      {
         if ( AV16meses > 0 )
         {
            AV20fraccion = DecimalUtil.doubleToDec(AV16meses/ (double) (12)) ;
            AV18anios = AV18anios.add(AV20fraccion) ;
         }
      }
      AV30intAnios = (short)(DecimalUtil.decToDouble(AV18anios)) ;
      AV23LiqDLog = GXutil.trim( GXutil.str( AV30intAnios, 4, 0)) + httpContext.getMessage( " años de antiguedad desde el ", "") + GXutil.trim( localUtil.dtoc( AV11LegFecIngreso, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) + httpContext.getMessage( " hasta el ", "") + GXutil.trim( localUtil.dtoc( AV13FecHasta, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) ;
      if ( AV24extra )
      {
         AV23LiqDLog += httpContext.getMessage( " (se agrega un año más por fracción mayor a ", "") + GXutil.trim( GXutil.str( AV19mesesParametro, 4, 0)) + httpContext.getMessage( " meses)", "") ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = antiguedad_anios.this.AV30intAnios;
      this.aP6[0] = antiguedad_anios.this.AV23LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV23LiqDLog = "" ;
      AV11LegFecIngreso = GXutil.nullDate() ;
      GXv_date1 = new java.util.Date[1] ;
      AV10LegFecEgreso = GXutil.nullDate() ;
      GXv_date2 = new java.util.Date[1] ;
      AV13FecHasta = GXutil.nullDate() ;
      AV15fecDesde = GXutil.nullDate() ;
      AV18anios = DecimalUtil.ZERO ;
      AV25antiguedadIndemnizacionPalabra = "" ;
      AV28ParmValue = "" ;
      GXv_char3 = new String[1] ;
      AV20fraccion = DecimalUtil.ZERO ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12EmpCod ;
   private short AV30intAnios ;
   private short AV16meses ;
   private short AV21diasDiferencia ;
   private short AV29mesesOriginales ;
   private short AV19mesesParametro ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV9LegNumero ;
   private java.math.BigDecimal AV18anios ;
   private java.math.BigDecimal AV20fraccion ;
   private String AV26ParamPalabra ;
   private String AV25antiguedadIndemnizacionPalabra ;
   private String GXv_char3[] ;
   private java.util.Date AV14LiqPeriodo ;
   private java.util.Date AV11LegFecIngreso ;
   private java.util.Date GXv_date1[] ;
   private java.util.Date AV10LegFecEgreso ;
   private java.util.Date GXv_date2[] ;
   private java.util.Date AV13FecHasta ;
   private java.util.Date AV15fecDesde ;
   private boolean AV24extra ;
   private String AV23LiqDLog ;
   private String AV28ParmValue ;
   private String[] aP6 ;
   private short[] aP5 ;
}

