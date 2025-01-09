package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class obra_social_adherentes extends GXProcedure
{
   public obra_social_adherentes( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obra_social_adherentes.class ), "" );
   }

   public obra_social_adherentes( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 ,
                                           int aP3 ,
                                           java.util.Date aP4 ,
                                           String aP5 ,
                                           java.math.BigDecimal[] aP6 ,
                                           String[] aP7 ,
                                           String[] aP8 ,
                                           byte[] aP9 )
   {
      obra_social_adherentes.this.aP10 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        String aP5 ,
                        java.math.BigDecimal[] aP6 ,
                        String[] aP7 ,
                        String[] aP8 ,
                        byte[] aP9 ,
                        java.math.BigDecimal[] aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             java.math.BigDecimal[] aP6 ,
                             String[] aP7 ,
                             String[] aP8 ,
                             byte[] aP9 ,
                             java.math.BigDecimal[] aP10 )
   {
      obra_social_adherentes.this.AV8CliCod = aP0;
      obra_social_adherentes.this.AV13EmpCod = aP1;
      obra_social_adherentes.this.AV12LiqNro = aP2;
      obra_social_adherentes.this.AV11LegNumero = aP3;
      obra_social_adherentes.this.AV21LiqPeriodo = aP4;
      obra_social_adherentes.this.AV14ProcesoLiquidacion = aP5;
      obra_social_adherentes.this.aP6 = aP6;
      obra_social_adherentes.this.aP7 = aP7;
      obra_social_adherentes.this.aP8 = aP8;
      obra_social_adherentes.this.aP9 = aP9;
      obra_social_adherentes.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV16LiqDCalculado = (byte)(1) ;
      GXv_int1[0] = AV24cantidad ;
      new web.cantidaddeadherentes(remoteHandle, context).execute( AV8CliCod, AV13EmpCod, AV11LegNumero, GXv_int1) ;
      obra_social_adherentes.this.AV24cantidad = GXv_int1[0] ;
      AV25Importes = DecimalUtil.doubleToDec(AV24cantidad) ;
      if ( AV24cantidad == 0 )
      {
         AV19LiqDLog = httpContext.getMessage( "Sin adherentes vinculados a la obra social", "") ;
      }
      else
      {
         AV19LiqDLog = httpContext.getMessage( "Se inicializa valor en cantidad de adherentes ", "") + GXutil.trim( GXutil.str( AV24cantidad, 4, 0)) ;
         GXt_char2 = AV10auxConCodigo ;
         GXt_char3 = AV10auxConCodigo ;
         GXv_char4[0] = GXt_char3 ;
         new web.concepto_obrasocial_codigoparam(remoteHandle, context).execute( GXv_char4) ;
         obra_social_adherentes.this.GXt_char3 = GXv_char4[0] ;
         GXv_char5[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char3, GXv_char5) ;
         obra_social_adherentes.this.GXt_char2 = GXv_char5[0] ;
         AV10auxConCodigo = GXt_char2 ;
         GXv_decimal6[0] = AV15LiqDValUni ;
         GXv_boolean7[0] = false ;
         GXv_int8[0] = AV17auxLiqDCalculado ;
         new web.getliqdimpbase(remoteHandle, context).execute( AV8CliCod, AV13EmpCod, AV12LiqNro, AV11LegNumero, AV10auxConCodigo, AV14ProcesoLiquidacion, GXv_decimal6, GXv_boolean7, GXv_int8) ;
         obra_social_adherentes.this.AV15LiqDValUni = GXv_decimal6[0] ;
         obra_social_adherentes.this.AV17auxLiqDCalculado = GXv_int8[0] ;
         if ( AV17auxLiqDCalculado == 0 )
         {
            AV16LiqDCalculado = (byte)(0) ;
            AV18error = httpContext.getMessage( "Falta calcular obra social", "") ;
            AV19LiqDLog = AV18error ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV25Importes = AV25Importes.multiply(AV15LiqDValUni) ;
         AV19LiqDLog += httpContext.getMessage( ". Se multipica por la base de cálculo de obra social ", "") + GXutil.trim( GXutil.str( AV15LiqDValUni, 14, 2)) ;
         AV20OpeCliId = "[apo_OS_adh_ali]" ;
         GXv_char5[0] = AV22OpeCliValor ;
         GXv_char4[0] = AV27auxError ;
         new web.getopeclivalor(remoteHandle, context).execute( AV8CliCod, AV20OpeCliId, AV21LiqPeriodo, AV14ProcesoLiquidacion, GXv_char5, GXv_char4) ;
         obra_social_adherentes.this.AV22OpeCliValor = GXv_char5[0] ;
         obra_social_adherentes.this.AV27auxError = GXv_char4[0] ;
         if ( ! (GXutil.strcmp("", AV27auxError)==0) )
         {
            AV16LiqDCalculado = (byte)(0) ;
            AV18error = AV27auxError ;
            AV19LiqDLog = AV18error ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV23porUnaje = CommonUtil.decimalVal( AV22OpeCliValor, ".") ;
         AV25Importes = AV25Importes.multiply(AV23porUnaje) ;
         AV19LiqDLog += httpContext.getMessage( ". Se multiplica por ", "") + GXutil.trim( GXutil.str( AV23porUnaje, 6, 4)) + httpContext.getMessage( " de alícuota por adherente", "") ;
         AV26cantidadCalculada = AV23porUnaje.multiply(DecimalUtil.doubleToDec(100)) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = obra_social_adherentes.this.AV25Importes;
      this.aP7[0] = obra_social_adherentes.this.AV18error;
      this.aP8[0] = obra_social_adherentes.this.AV19LiqDLog;
      this.aP9[0] = obra_social_adherentes.this.AV16LiqDCalculado;
      this.aP10[0] = obra_social_adherentes.this.AV26cantidadCalculada;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV25Importes = DecimalUtil.ZERO ;
      AV18error = "" ;
      AV19LiqDLog = "" ;
      AV26cantidadCalculada = DecimalUtil.ZERO ;
      GXv_int1 = new short[1] ;
      AV10auxConCodigo = "" ;
      GXt_char2 = "" ;
      GXt_char3 = "" ;
      AV15LiqDValUni = DecimalUtil.ZERO ;
      GXv_decimal6 = new java.math.BigDecimal[1] ;
      GXv_boolean7 = new boolean[1] ;
      GXv_int8 = new byte[1] ;
      AV20OpeCliId = "" ;
      AV22OpeCliValor = "" ;
      GXv_char5 = new String[1] ;
      AV27auxError = "" ;
      GXv_char4 = new String[1] ;
      AV23porUnaje = DecimalUtil.ZERO ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV16LiqDCalculado ;
   private byte AV17auxLiqDCalculado ;
   private byte GXv_int8[] ;
   private short AV13EmpCod ;
   private short AV24cantidad ;
   private short GXv_int1[] ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV12LiqNro ;
   private int AV11LegNumero ;
   private java.math.BigDecimal AV25Importes ;
   private java.math.BigDecimal AV26cantidadCalculada ;
   private java.math.BigDecimal AV15LiqDValUni ;
   private java.math.BigDecimal GXv_decimal6[] ;
   private java.math.BigDecimal AV23porUnaje ;
   private String AV14ProcesoLiquidacion ;
   private String AV10auxConCodigo ;
   private String GXt_char2 ;
   private String GXt_char3 ;
   private String AV20OpeCliId ;
   private String GXv_char5[] ;
   private String GXv_char4[] ;
   private java.util.Date AV21LiqPeriodo ;
   private boolean GXv_boolean7[] ;
   private boolean returnInSub ;
   private String AV19LiqDLog ;
   private String AV22OpeCliValor ;
   private String AV18error ;
   private String AV27auxError ;
   private java.math.BigDecimal[] aP10 ;
   private java.math.BigDecimal[] aP6 ;
   private String[] aP7 ;
   private String[] aP8 ;
   private byte[] aP9 ;
}

