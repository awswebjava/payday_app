package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class parseartextoconveniotarifas extends GXProcedure
{
   public parseartextoconveniotarifas( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( parseartextoconveniotarifas.class ), "" );
   }

   public parseartextoconveniotarifas( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( int aP0 ,
                          short aP1 ,
                          String aP2 ,
                          String aP3 ,
                          String[] aP4 ,
                          java.math.BigDecimal[] aP5 ,
                          java.util.Date[] aP6 )
   {
      parseartextoconveniotarifas.this.aP7 = new int[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        String aP3 ,
                        String[] aP4 ,
                        java.math.BigDecimal[] aP5 ,
                        java.util.Date[] aP6 ,
                        int[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String[] aP4 ,
                             java.math.BigDecimal[] aP5 ,
                             java.util.Date[] aP6 ,
                             int[] aP7 )
   {
      parseartextoconveniotarifas.this.AV10CliCod = aP0;
      parseartextoconveniotarifas.this.AV18PaiCod = aP1;
      parseartextoconveniotarifas.this.AV11ConveCodigo = aP2;
      parseartextoconveniotarifas.this.AV23VarBusWeb = aP3;
      parseartextoconveniotarifas.this.AV22valorCrudo = aP4[0];
      this.aP4 = aP4;
      parseartextoconveniotarifas.this.aP5 = aP5;
      parseartextoconveniotarifas.this.aP6 = aP6;
      parseartextoconveniotarifas.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.strcmp(AV11ConveCodigo, new web.conveniouecara(remoteHandle, context).executeUdp( )) == 0 )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         AV22valorCrudo = GXutil.strReplace( AV22valorCrudo, httpContext.getMessage( "(aumento del ", ""), "") ;
         AV19porUnaje = CommonUtil.decimalVal( GXutil.substring( AV22valorCrudo, 1, 2), ".").divide(DecimalUtil.doubleToDec(100), 18, java.math.RoundingMode.DOWN) ;
         AV19porUnaje = AV19porUnaje.add(DecimalUtil.doubleToDec(1)) ;
         AV24vigentesAlPalabra = httpContext.getMessage( "al ", "") ;
         /* Execute user subroutine: 'PARSEAR FECHA ORIGEN' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, httpContext.getMessage( "valor crudo ", "")+AV22valorCrudo) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, httpContext.getMessage( "valor &VarBusWeb  \"", "")+GXutil.trim( AV23VarBusWeb)+"\"") ;
         AV22valorCrudo = GXutil.strReplace( GXutil.lower( AV22valorCrudo), GXutil.trim( GXutil.lower( AV23VarBusWeb))+" ", "") ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, httpContext.getMessage( "valor crudo ", "")+AV22valorCrudo) ;
         AV19porUnaje = CommonUtil.decimalVal( GXutil.substring( AV22valorCrudo, 1, 2), ".").divide(DecimalUtil.doubleToDec(100), 18, java.math.RoundingMode.DOWN) ;
         AV19porUnaje = AV19porUnaje.add(DecimalUtil.doubleToDec(1)) ;
         AV24vigentesAlPalabra = httpContext.getMessage( "vigentes al ", "") ;
         /* Execute user subroutine: 'PARSEAR FECHA ORIGEN' */
         S111 ();
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
      /* 'PARSEAR FECHA ORIGEN' Routine */
      returnInSub = false ;
      AV20posIni = (short)(GXutil.strSearch( AV22valorCrudo, AV24vigentesAlPalabra, 1)+GXutil.len( AV24vigentesAlPalabra)) ;
      AV13diaNro = (short)(GXutil.lval( GXutil.substring( AV22valorCrudo, AV20posIni, 2))) ;
      AV20posIni = (short)(GXutil.strSearch( AV22valorCrudo, httpContext.getMessage( " de ", ""), 1)+4) ;
      AV14mesNombre = GXutil.substring( AV22valorCrudo, AV20posIni, 3) ;
      GXv_int1[0] = AV15mesNro ;
      new web.devuelvenromes(remoteHandle, context).execute( AV14mesNombre, GXv_int1) ;
      parseartextoconveniotarifas.this.AV15mesNro = GXv_int1[0] ;
      AV20posIni = (short)(GXutil.len( AV22valorCrudo)-3) ;
      AV9anio = (short)(GXutil.lval( GXutil.substring( AV22valorCrudo, AV20posIni, 4))) ;
      AV21scrapeFecha = localUtil.ymdtod( AV9anio, AV15mesNro, AV13diaNro) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, httpContext.getMessage( "&anio ", "")+GXutil.trim( GXutil.str( AV9anio, 4, 0))+httpContext.getMessage( " mesnro ", "")+GXutil.trim( GXutil.str( AV15mesNro, 2, 0))+httpContext.getMessage( " dianro ", "")+GXutil.trim( GXutil.str( AV13diaNro, 4, 0))+httpContext.getMessage( " &scrapeFecha ", "")+GXutil.trim( localUtil.dtoc( AV21scrapeFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      GXv_date2[0] = AV17origen_CatVigencia ;
      GXv_int1[0] = (byte)(0) ;
      new web.getconveultivig(remoteHandle, context).execute( AV10CliCod, AV18PaiCod, AV11ConveCodigo, AV21scrapeFecha, GXv_date2, GXv_int1) ;
      parseartextoconveniotarifas.this.AV17origen_CatVigencia = GXv_date2[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, httpContext.getMessage( "&origen_CatVigencia ", "")+GXutil.trim( localUtil.dtoc( AV17origen_CatVigencia, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      AV8AAAAMMDD_str = GXutil.trim( GXutil.str( GXutil.year( AV17origen_CatVigencia), 10, 0)) + GXutil.padl( GXutil.str( GXutil.month( AV17origen_CatVigencia), 10, 0), (short)(2), "0") + GXutil.padl( GXutil.str( GXutil.day( AV17origen_CatVigencia), 10, 0), (short)(2), "0") ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, httpContext.getMessage( "&AAAAMMDD_str \"", "")+AV8AAAAMMDD_str+"\"") ;
      AV16origen = (int)(GXutil.lval( AV8AAAAMMDD_str)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, httpContext.getMessage( "&origen ", "")+GXutil.trim( GXutil.str( AV16origen, 8, 0))) ;
   }

   protected void cleanup( )
   {
      this.aP4[0] = parseartextoconveniotarifas.this.AV22valorCrudo;
      this.aP5[0] = parseartextoconveniotarifas.this.AV19porUnaje;
      this.aP6[0] = parseartextoconveniotarifas.this.AV17origen_CatVigencia;
      this.aP7[0] = parseartextoconveniotarifas.this.AV16origen;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV19porUnaje = DecimalUtil.ZERO ;
      AV17origen_CatVigencia = GXutil.nullDate() ;
      AV24vigentesAlPalabra = "" ;
      AV27Pgmname = "" ;
      AV14mesNombre = "" ;
      AV21scrapeFecha = GXutil.nullDate() ;
      GXv_date2 = new java.util.Date[1] ;
      GXv_int1 = new byte[1] ;
      AV8AAAAMMDD_str = "" ;
      AV27Pgmname = "parsearTextoConvenioTarifas" ;
      /* GeneXus formulas. */
      AV27Pgmname = "parsearTextoConvenioTarifas" ;
      Gx_err = (short)(0) ;
   }

   private byte AV15mesNro ;
   private byte GXv_int1[] ;
   private short AV18PaiCod ;
   private short AV20posIni ;
   private short AV13diaNro ;
   private short AV9anio ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV16origen ;
   private java.math.BigDecimal AV19porUnaje ;
   private String AV11ConveCodigo ;
   private String AV24vigentesAlPalabra ;
   private String AV27Pgmname ;
   private String AV14mesNombre ;
   private String AV8AAAAMMDD_str ;
   private java.util.Date AV17origen_CatVigencia ;
   private java.util.Date AV21scrapeFecha ;
   private java.util.Date GXv_date2[] ;
   private boolean Cond_result ;
   private boolean returnInSub ;
   private String AV23VarBusWeb ;
   private String AV22valorCrudo ;
   private int[] aP7 ;
   private String[] aP4 ;
   private java.math.BigDecimal[] aP5 ;
   private java.util.Date[] aP6 ;
}

