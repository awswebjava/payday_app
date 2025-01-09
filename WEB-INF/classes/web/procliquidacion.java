package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class procliquidacion extends GXProcedure
{
   public procliquidacion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( procliquidacion.class ), "" );
   }

   public procliquidacion( int remoteHandle ,
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
                             int aP5 ,
                             int aP6 ,
                             byte aP7 ,
                             boolean aP8 ,
                             String aP9 ,
                             String aP10 ,
                             String aP11 ,
                             java.math.BigDecimal aP12 ,
                             java.math.BigDecimal aP13 ,
                             byte aP14 ,
                             String aP15 ,
                             String aP16 ,
                             boolean[] aP17 ,
                             boolean[] aP18 )
   {
      procliquidacion.this.aP19 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19);
      return aP19[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        String aP4 ,
                        int aP5 ,
                        int aP6 ,
                        byte aP7 ,
                        boolean aP8 ,
                        String aP9 ,
                        String aP10 ,
                        String aP11 ,
                        java.math.BigDecimal aP12 ,
                        java.math.BigDecimal aP13 ,
                        byte aP14 ,
                        String aP15 ,
                        String aP16 ,
                        boolean[] aP17 ,
                        boolean[] aP18 ,
                        String[] aP19 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             String aP4 ,
                             int aP5 ,
                             int aP6 ,
                             byte aP7 ,
                             boolean aP8 ,
                             String aP9 ,
                             String aP10 ,
                             String aP11 ,
                             java.math.BigDecimal aP12 ,
                             java.math.BigDecimal aP13 ,
                             byte aP14 ,
                             String aP15 ,
                             String aP16 ,
                             boolean[] aP17 ,
                             boolean[] aP18 ,
                             String[] aP19 )
   {
      procliquidacion.this.AV9CliCod = aP0;
      procliquidacion.this.AV10EmpCod = aP1;
      procliquidacion.this.AV13LegNumero = aP2;
      procliquidacion.this.AV19LiqPeriodo = aP3;
      procliquidacion.this.AV20TliqCod = aP4;
      procliquidacion.this.AV11LiqNro = aP5;
      procliquidacion.this.AV12LiqRelNro = aP6;
      procliquidacion.this.AV8liq_nivel_complejidad = aP7;
      procliquidacion.this.AV21redondeoHay = aP8;
      procliquidacion.this.AV22remuTipoConCod = aP9;
      procliquidacion.this.AV23noRemuTipoConCod = aP10;
      procliquidacion.this.AV24descuTipoConCod = aP11;
      procliquidacion.this.AV25base_imp_min = aP12;
      procliquidacion.this.AV26base_imp_max = aP13;
      procliquidacion.this.AV27cantDiasMes = aP14;
      procliquidacion.this.AV14llamador = aP15;
      procliquidacion.this.AV15ConveCodigo = aP16;
      procliquidacion.this.aP17 = aP17;
      procliquidacion.this.aP18 = aP18;
      procliquidacion.this.aP19 = aP19;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV36grossingUpConCodigo ;
      GXt_char2 = AV36grossingUpConCodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.grossigup_concepto_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      procliquidacion.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char2, GXv_char4) ;
      procliquidacion.this.GXt_char1 = GXv_char4[0] ;
      AV36grossingUpConCodigo = GXt_char1 ;
      AV34keyPalabra = httpContext.getMessage( "grossingup_calculo_", "") + GXutil.trim( GXutil.str( AV9CliCod, 6, 0)) + "_" + GXutil.trim( GXutil.str( AV10EmpCod, 4, 0)) + "_" + GXutil.trim( GXutil.str( AV13LegNumero, 8, 0)) ;
      AV35websession.remove(AV34keyPalabra);
      GXv_char4[0] = AV40ParmValue ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, new web.grossigup_maxintent_codigoparam(remoteHandle, context).executeUdp( ), GXv_char4) ;
      procliquidacion.this.AV40ParmValue = GXv_char4[0] ;
      AV39maxIntentos = (short)(GXutil.lval( AV40ParmValue)) ;
      AV38i = (short)(1) ;
      while ( true )
      {
         gxexitloop = false ;
         if ( gxexitloop )
         {
            break;
         }
         if ( AV8liq_nivel_complejidad == 4 )
         {
            GXv_boolean5[0] = AV16errorCiclicoHay ;
            GXv_boolean6[0] = AV17errorComunHay ;
            GXv_char4[0] = AV18principalError ;
            new web.procliqconganancias(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, AV12LiqRelNro, AV13LegNumero, (byte)(1), AV14llamador, true, AV15ConveCodigo, GXv_boolean5, GXv_boolean6, GXv_char4) ;
            procliquidacion.this.AV16errorCiclicoHay = GXv_boolean5[0] ;
            procliquidacion.this.AV17errorComunHay = GXv_boolean6[0] ;
            procliquidacion.this.AV18principalError = GXv_char4[0] ;
         }
         else
         {
            if ( AV8liq_nivel_complejidad == 3 )
            {
               GXv_boolean6[0] = AV16errorCiclicoHay ;
               GXv_boolean5[0] = AV17errorComunHay ;
               GXv_char4[0] = AV18principalError ;
               new web.procliqsinganancias(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, AV12LiqRelNro, AV13LegNumero, (byte)(1), AV14llamador, true, AV15ConveCodigo, GXv_boolean6, GXv_boolean5, GXv_char4) ;
               procliquidacion.this.AV16errorCiclicoHay = GXv_boolean6[0] ;
               procliquidacion.this.AV17errorComunHay = GXv_boolean5[0] ;
               procliquidacion.this.AV18principalError = GXv_char4[0] ;
            }
            else
            {
               GXv_boolean6[0] = AV16errorCiclicoHay ;
               GXv_boolean5[0] = AV17errorComunHay ;
               GXv_char4[0] = AV18principalError ;
               new web.procliquidacionsimple(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, AV12LiqRelNro, AV19LiqPeriodo, AV20TliqCod, AV13LegNumero, (byte)(1), AV14llamador, true, AV15ConveCodigo, AV21redondeoHay, AV22remuTipoConCod, AV23noRemuTipoConCod, AV24descuTipoConCod, AV25base_imp_min, AV26base_imp_max, AV27cantDiasMes, GXv_boolean6, GXv_boolean5, GXv_char4) ;
               procliquidacion.this.AV16errorCiclicoHay = GXv_boolean6[0] ;
               procliquidacion.this.AV17errorComunHay = GXv_boolean5[0] ;
               procliquidacion.this.AV18principalError = GXv_char4[0] ;
            }
         }
         GXv_boolean6[0] = AV37grossingHay ;
         new web.hayliqlegdet(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, AV13LegNumero, AV36grossingUpConCodigo, GXv_boolean6) ;
         procliquidacion.this.AV37grossingHay = GXv_boolean6[0] ;
         if ( AV37grossingHay )
         {
            GXv_decimal7[0] = AV28LegSuelImporte ;
            GXv_char4[0] = AV29LegSuelTipo ;
            GXv_boolean6[0] = AV31existe ;
            new web.getlegajosueldoultimo2(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV13LegNumero, AV19LiqPeriodo, httpContext.getMessage( "Neto", ""), GXv_decimal7, GXv_char4, GXv_boolean6) ;
            procliquidacion.this.AV28LegSuelImporte = GXv_decimal7[0] ;
            procliquidacion.this.AV29LegSuelTipo = GXv_char4[0] ;
            procliquidacion.this.AV31existe = GXv_boolean6[0] ;
            if ( GXutil.strcmp(AV29LegSuelTipo, "GrossingUp") != 0 )
            {
               AV17errorComunHay = true ;
               AV18principalError = httpContext.getMessage( "El legajo no tiene configurado sueldo como \"Grossing up\" pero se insertó el concepto en la liquidación", "") ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            else
            {
               if ( ! AV31existe )
               {
                  AV17errorComunHay = true ;
                  AV18principalError = httpContext.getMessage( "No existe sueldo al ", "") + GXutil.trim( localUtil.dtoc( AV19LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) + httpContext.getMessage( " para validar grossing up", "") ;
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               GXv_boolean6[0] = AV32ok ;
               GXv_char4[0] = AV33auxError ;
               new web.validargrossingup(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, AV13LegNumero, AV28LegSuelImporte, GXv_boolean6, GXv_char4) ;
               procliquidacion.this.AV32ok = GXv_boolean6[0] ;
               procliquidacion.this.AV33auxError = GXv_char4[0] ;
               if ( ! (GXutil.strcmp("", AV33auxError)==0) )
               {
                  AV17errorComunHay = true ;
                  AV18principalError = GXutil.trim( AV33auxError) ;
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               if ( AV32ok )
               {
                  if (true) break;
               }
               else
               {
                  AV38i = (short)(AV38i+1) ;
                  if ( AV38i > AV39maxIntentos )
                  {
                     AV17errorComunHay = true ;
                     AV18principalError = httpContext.getMessage( "Se sobrepasó la cantidad de ", "") + GXutil.trim( GXutil.str( AV39maxIntentos, 4, 0)) + httpContext.getMessage( " intentos para calcular grossing up", "") ;
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
                  else
                  {
                     GXv_int8[0] = (short)(0) ;
                     new web.revivirapendientes(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, AV13LegNumero, (byte)(1), true, GXv_int8) ;
                  }
               }
            }
         }
         else
         {
            if (true) break;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP17[0] = procliquidacion.this.AV16errorCiclicoHay;
      this.aP18[0] = procliquidacion.this.AV17errorComunHay;
      this.aP19[0] = procliquidacion.this.AV18principalError;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV18principalError = "" ;
      AV36grossingUpConCodigo = "" ;
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      GXv_char3 = new String[1] ;
      AV34keyPalabra = "" ;
      AV35websession = httpContext.getWebSession();
      AV40ParmValue = "" ;
      GXv_boolean5 = new boolean[1] ;
      AV28LegSuelImporte = DecimalUtil.ZERO ;
      GXv_decimal7 = new java.math.BigDecimal[1] ;
      AV29LegSuelTipo = "" ;
      GXv_boolean6 = new boolean[1] ;
      AV33auxError = "" ;
      GXv_char4 = new String[1] ;
      GXv_int8 = new short[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV8liq_nivel_complejidad ;
   private byte AV27cantDiasMes ;
   private short AV10EmpCod ;
   private short AV39maxIntentos ;
   private short AV38i ;
   private short GXv_int8[] ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV13LegNumero ;
   private int AV11LiqNro ;
   private int AV12LiqRelNro ;
   private java.math.BigDecimal AV25base_imp_min ;
   private java.math.BigDecimal AV26base_imp_max ;
   private java.math.BigDecimal AV28LegSuelImporte ;
   private java.math.BigDecimal GXv_decimal7[] ;
   private String AV20TliqCod ;
   private String AV22remuTipoConCod ;
   private String AV23noRemuTipoConCod ;
   private String AV24descuTipoConCod ;
   private String AV14llamador ;
   private String AV15ConveCodigo ;
   private String AV36grossingUpConCodigo ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String AV34keyPalabra ;
   private String AV29LegSuelTipo ;
   private String GXv_char4[] ;
   private java.util.Date AV19LiqPeriodo ;
   private boolean AV21redondeoHay ;
   private boolean AV16errorCiclicoHay ;
   private boolean AV17errorComunHay ;
   private boolean gxexitloop ;
   private boolean GXv_boolean5[] ;
   private boolean AV37grossingHay ;
   private boolean AV31existe ;
   private boolean returnInSub ;
   private boolean AV32ok ;
   private boolean GXv_boolean6[] ;
   private String AV40ParmValue ;
   private String AV18principalError ;
   private String AV33auxError ;
   private String[] aP19 ;
   private boolean[] aP17 ;
   private boolean[] aP18 ;
   private com.genexus.webpanels.WebSession AV35websession ;
}

