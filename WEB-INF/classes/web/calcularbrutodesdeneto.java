package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class calcularbrutodesdeneto extends GXProcedure
{
   public calcularbrutodesdeneto( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( calcularbrutodesdeneto.class ), "" );
   }

   public calcularbrutodesdeneto( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.math.BigDecimal aP3 ,
                             java.math.BigDecimal aP4 ,
                             java.math.BigDecimal aP5 ,
                             boolean aP6 ,
                             java.util.Date aP7 ,
                             boolean aP8 ,
                             boolean aP9 ,
                             String aP10 ,
                             java.math.BigDecimal[] aP11 )
   {
      calcularbrutodesdeneto.this.aP12 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
      return aP12[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.math.BigDecimal aP3 ,
                        java.math.BigDecimal aP4 ,
                        java.math.BigDecimal aP5 ,
                        boolean aP6 ,
                        java.util.Date aP7 ,
                        boolean aP8 ,
                        boolean aP9 ,
                        String aP10 ,
                        java.math.BigDecimal[] aP11 ,
                        String[] aP12 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.math.BigDecimal aP3 ,
                             java.math.BigDecimal aP4 ,
                             java.math.BigDecimal aP5 ,
                             boolean aP6 ,
                             java.util.Date aP7 ,
                             boolean aP8 ,
                             boolean aP9 ,
                             String aP10 ,
                             java.math.BigDecimal[] aP11 ,
                             String[] aP12 )
   {
      calcularbrutodesdeneto.this.AV9CliCod = aP0;
      calcularbrutodesdeneto.this.AV10EmpCod = aP1;
      calcularbrutodesdeneto.this.AV11LegNumero = aP2;
      calcularbrutodesdeneto.this.AV25netoImportes = aP3;
      calcularbrutodesdeneto.this.AV20base_imp_min = aP4;
      calcularbrutodesdeneto.this.AV21base_imp_max = aP5;
      calcularbrutodesdeneto.this.AV26calcularConTope = aP6;
      calcularbrutodesdeneto.this.AV12LegSuelFecha = aP7;
      calcularbrutodesdeneto.this.AV13parmLegLiqApo = aP8;
      calcularbrutodesdeneto.this.AV14parmLegJubilado = aP9;
      calcularbrutodesdeneto.this.AV15parmSinCod = aP10;
      calcularbrutodesdeneto.this.aP11 = aP11;
      calcularbrutodesdeneto.this.aP12 = aP12;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_decimal1[0] = AV16auxPorUnaje ;
      GXv_decimal2[0] = AV17auxSinTopePorUnaje ;
      GXv_char3[0] = AV18auxError ;
      GXv_char4[0] = "" ;
      new web.getporcentajedesculey(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LegNumero, AV12LegSuelFecha, AV13parmLegLiqApo, AV14parmLegJubilado, AV15parmSinCod, GXv_decimal1, GXv_decimal2, GXv_char3, GXv_char4) ;
      calcularbrutodesdeneto.this.AV16auxPorUnaje = GXv_decimal1[0] ;
      calcularbrutodesdeneto.this.AV17auxSinTopePorUnaje = GXv_decimal2[0] ;
      calcularbrutodesdeneto.this.AV18auxError = GXv_char3[0] ;
      /* Execute user subroutine: 'DEVOLVER ERROR' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV29Pgmname, httpContext.getMessage( " &base_imp_min ", "")+GXutil.trim( GXutil.str( AV20base_imp_min, 14, 2))+httpContext.getMessage( " &base_imp_max ", "")+GXutil.trim( GXutil.str( AV21base_imp_max, 14, 2))+httpContext.getMessage( " &auxPorUnaje ", "")+GXutil.trim( GXutil.str( AV16auxPorUnaje, 6, 4))+httpContext.getMessage( " &auxSinTopePorUnaje ", "")+GXutil.trim( GXutil.str( AV17auxSinTopePorUnaje, 6, 4))+httpContext.getMessage( " &netoImportes", "")+GXutil.trim( GXutil.str( AV25netoImportes, 14, 2))+httpContext.getMessage( " &calcularConTope ", "")+GXutil.trim( GXutil.booltostr( AV26calcularConTope))) ;
      if ( ( DecimalUtil.compareTo(AV25netoImportes, AV20base_imp_min) > 0 ) && ( DecimalUtil.compareTo(AV25netoImportes, AV21base_imp_max) < 0 ) )
      {
         AV22porUnaje = DecimalUtil.doubleToDec(1) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV29Pgmname, httpContext.getMessage( "resta ", "")+GXutil.trim( GXutil.str( AV16auxPorUnaje, 6, 4))+httpContext.getMessage( " a &porUnaje ", "")+GXutil.trim( GXutil.str( AV22porUnaje, 6, 4))) ;
         AV22porUnaje = AV22porUnaje.subtract(AV16auxPorUnaje) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV29Pgmname, httpContext.getMessage( "queda &porUnaje ", "")+GXutil.trim( GXutil.str( AV22porUnaje, 6, 4))) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV29Pgmname, httpContext.getMessage( "!resta ", "")+GXutil.trim( GXutil.str( AV17auxSinTopePorUnaje, 6, 4))+httpContext.getMessage( " a &porUnaje ", "")+GXutil.trim( GXutil.str( AV22porUnaje, 6, 4))) ;
         AV22porUnaje = AV22porUnaje.subtract(AV17auxSinTopePorUnaje) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV29Pgmname, httpContext.getMessage( "!queda &porUnaje ", "")+GXutil.trim( GXutil.str( AV22porUnaje, 6, 4))) ;
         if ( AV22porUnaje.doubleValue() > 0 )
         {
            AV19brutoImportes = GXutil.roundDecimal( AV25netoImportes.divide(AV22porUnaje, 18, java.math.RoundingMode.DOWN), 2) ;
         }
         new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV29Pgmname, httpContext.getMessage( "###&brutoImportes ", "")+GXutil.trim( GXutil.str( AV19brutoImportes, 14, 2))+httpContext.getMessage( " &porUnaje ", "")+GXutil.trim( GXutil.str( AV22porUnaje, 6, 4))) ;
         if ( ( DecimalUtil.compareTo(AV19brutoImportes, AV20base_imp_min) < 0 ) || ( DecimalUtil.compareTo(AV19brutoImportes, AV21base_imp_max) > 0 ) )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV29Pgmname, httpContext.getMessage( "va a buscar con tope", "")) ;
            /* Execute user subroutine: 'CON TOPE' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      else
      {
         AV19brutoImportes = AV25netoImportes ;
         /* Execute user subroutine: 'CON TOPE' */
         S121 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'DEVOLVER ERROR' Routine */
      returnInSub = false ;
      if ( ! (GXutil.strcmp("", AV18auxError)==0) )
      {
         AV8Error = GXutil.trim( AV18auxError) ;
         returnInSub = true;
         if (true) return;
      }
   }

   public void S121( )
   {
      /* 'CON TOPE' Routine */
      returnInSub = false ;
      if ( AV26calcularConTope )
      {
         if ( DecimalUtil.compareTo(AV19brutoImportes, AV20base_imp_min) <= 0 )
         {
            AV24impuestoTopeado = AV20base_imp_min ;
         }
         else
         {
            AV24impuestoTopeado = AV21base_imp_max ;
         }
         AV24impuestoTopeado = AV24impuestoTopeado.multiply(AV16auxPorUnaje) ;
         AV22porUnaje = DecimalUtil.doubleToDec(1).subtract(AV17auxSinTopePorUnaje) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV29Pgmname, httpContext.getMessage( "buscando con tope.. poruja ", "")+GXutil.trim( GXutil.str( AV22porUnaje, 6, 4))) ;
         if ( AV22porUnaje.doubleValue() > 0 )
         {
            AV19brutoImportes = (AV25netoImportes.add(AV24impuestoTopeado)).divide(AV22porUnaje, 18, java.math.RoundingMode.DOWN) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV29Pgmname, httpContext.getMessage( "bacheimpor ", "")+GXutil.trim( GXutil.str( AV19brutoImportes, 14, 2))+httpContext.getMessage( " &netoImportes ", "")+GXutil.trim( GXutil.str( AV25netoImportes, 14, 2))+httpContext.getMessage( " &impuestoTopeado ", "")+GXutil.trim( GXutil.str( AV24impuestoTopeado, 14, 2))+httpContext.getMessage( " porunaje ", "")+GXutil.trim( GXutil.str( AV22porUnaje, 6, 4))+httpContext.getMessage( " auxsintopeporunaje ", "")+GXutil.trim( GXutil.str( AV17auxSinTopePorUnaje, 6, 4))+httpContext.getMessage( " &auxPorUnaje ", "")+GXutil.trim( GXutil.str( AV16auxPorUnaje, 6, 4))+httpContext.getMessage( " &base_imp_max ", "")+GXutil.trim( GXutil.str( AV21base_imp_max, 14, 2))) ;
         }
      }
   }

   protected void cleanup( )
   {
      this.aP11[0] = calcularbrutodesdeneto.this.AV19brutoImportes;
      this.aP12[0] = calcularbrutodesdeneto.this.AV8Error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV19brutoImportes = DecimalUtil.ZERO ;
      AV8Error = "" ;
      AV16auxPorUnaje = DecimalUtil.ZERO ;
      GXv_decimal1 = new java.math.BigDecimal[1] ;
      AV17auxSinTopePorUnaje = DecimalUtil.ZERO ;
      GXv_decimal2 = new java.math.BigDecimal[1] ;
      AV18auxError = "" ;
      GXv_char3 = new String[1] ;
      GXv_char4 = new String[1] ;
      AV29Pgmname = "" ;
      AV22porUnaje = DecimalUtil.ZERO ;
      AV24impuestoTopeado = DecimalUtil.ZERO ;
      AV29Pgmname = "calcularBrutoDesdeNeto" ;
      /* GeneXus formulas. */
      AV29Pgmname = "calcularBrutoDesdeNeto" ;
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV11LegNumero ;
   private java.math.BigDecimal AV25netoImportes ;
   private java.math.BigDecimal AV20base_imp_min ;
   private java.math.BigDecimal AV21base_imp_max ;
   private java.math.BigDecimal AV19brutoImportes ;
   private java.math.BigDecimal AV16auxPorUnaje ;
   private java.math.BigDecimal GXv_decimal1[] ;
   private java.math.BigDecimal AV17auxSinTopePorUnaje ;
   private java.math.BigDecimal GXv_decimal2[] ;
   private java.math.BigDecimal AV22porUnaje ;
   private java.math.BigDecimal AV24impuestoTopeado ;
   private String AV15parmSinCod ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private String AV29Pgmname ;
   private java.util.Date AV12LegSuelFecha ;
   private boolean AV26calcularConTope ;
   private boolean AV13parmLegLiqApo ;
   private boolean AV14parmLegJubilado ;
   private boolean returnInSub ;
   private String AV8Error ;
   private String AV18auxError ;
   private String[] aP12 ;
   private java.math.BigDecimal[] aP11 ;
}

