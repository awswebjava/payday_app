package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class diastrabmesparabaseimp extends GXProcedure
{
   public diastrabmesparabaseimp( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( diastrabmesparabaseimp.class ), "" );
   }

   public diastrabmesparabaseimp( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             short aP5 ,
                             String aP6 ,
                             boolean aP7 ,
                             short[] aP8 ,
                             String[] aP9 ,
                             byte[] aP10 )
   {
      diastrabmesparabaseimp.this.aP11 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
      return aP11[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        short aP5 ,
                        String aP6 ,
                        boolean aP7 ,
                        short[] aP8 ,
                        String[] aP9 ,
                        byte[] aP10 ,
                        String[] aP11 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             short aP5 ,
                             String aP6 ,
                             boolean aP7 ,
                             short[] aP8 ,
                             String[] aP9 ,
                             byte[] aP10 ,
                             String[] aP11 )
   {
      diastrabmesparabaseimp.this.AV9CliCod = aP0;
      diastrabmesparabaseimp.this.AV10EmpCod = aP1;
      diastrabmesparabaseimp.this.AV11LiqNro = aP2;
      diastrabmesparabaseimp.this.AV12LegNumero = aP3;
      diastrabmesparabaseimp.this.AV17LiqPeriodo = aP4;
      diastrabmesparabaseimp.this.AV19dias_mes = aP5;
      diastrabmesparabaseimp.this.AV22ProcesoLiquidacion = aP6;
      diastrabmesparabaseimp.this.AV23insertandoConceptos = aP7;
      diastrabmesparabaseimp.this.aP8 = aP8;
      diastrabmesparabaseimp.this.aP9 = aP9;
      diastrabmesparabaseimp.this.aP10 = aP10;
      diastrabmesparabaseimp.this.aP11 = aP11;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV15LiqDCalculado = (byte)(1) ;
      GXt_char1 = AV8diasPropTopeSueldoConCodigo ;
      GXt_char2 = AV8diasPropTopeSueldoConCodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.concepto_diasproportopesueldo_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      diastrabmesparabaseimp.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char2, GXv_char4) ;
      diastrabmesparabaseimp.this.GXt_char1 = GXv_char4[0] ;
      AV8diasPropTopeSueldoConCodigo = GXt_char1 ;
      GXv_decimal5[0] = DecimalUtil.doubleToDec(AV13dias_tope) ;
      GXv_boolean6[0] = AV24existe ;
      GXv_int7[0] = AV14dtmLiqDCalculado ;
      new web.getliqdimpcalcu(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, AV12LegNumero, AV8diasPropTopeSueldoConCodigo, AV22ProcesoLiquidacion, AV23insertandoConceptos, GXv_decimal5, GXv_boolean6, GXv_int7) ;
      diastrabmesparabaseimp.this.AV13dias_tope = (short)(DecimalUtil.decToDouble(GXv_decimal5[0])) ;
      diastrabmesparabaseimp.this.AV24existe = GXv_boolean6[0] ;
      diastrabmesparabaseimp.this.AV14dtmLiqDCalculado = GXv_int7[0] ;
      if ( ! AV24existe )
      {
         GXt_char2 = AV25parmValue ;
         GXt_char1 = AV25parmValue ;
         GXv_char4[0] = GXt_char1 ;
         new web.meses30dias_codigoparam(remoteHandle, context).execute( GXv_char4) ;
         diastrabmesparabaseimp.this.GXt_char1 = GXv_char4[0] ;
         GXv_char3[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char1, GXv_char3) ;
         diastrabmesparabaseimp.this.GXt_char2 = GXv_char3[0] ;
         AV25parmValue = GXt_char2 ;
         AV26todosLosMeses30 = GXutil.boolval( AV25parmValue) ;
         GXv_int8[0] = AV20dias_trabajados_mes ;
         GXv_int9[0] = (short)(0) ;
         GXv_char4[0] = AV27auxLiqDLog ;
         new web.cantdiasmescompleto(remoteHandle, context).execute( AV26todosLosMeses30, AV17LiqPeriodo, GXv_int8, GXv_int9, GXv_char4) ;
         diastrabmesparabaseimp.this.AV20dias_trabajados_mes = GXv_int8[0] ;
         diastrabmesparabaseimp.this.AV27auxLiqDLog = GXv_char4[0] ;
         AV21LiqDLog = httpContext.getMessage( "Al ser liquidación básica: ", "") + GXutil.trim( AV27auxLiqDLog) ;
      }
      else
      {
         if ( AV14dtmLiqDCalculado == 0 )
         {
            AV15LiqDCalculado = (byte)(0) ;
            AV16error = httpContext.getMessage( "Falta calcular concepto ", "") + GXutil.trim( AV8diasPropTopeSueldoConCodigo) ;
            AV21LiqDLog += ". " + GXutil.trim( AV16error) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         GXv_decimal5[0] = DecimalUtil.doubleToDec(AV18dtmAnteriores) ;
         new web.getliqdimpcalcu_periodoliqant(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, AV12LegNumero, AV17LiqPeriodo, AV8diasPropTopeSueldoConCodigo, true, GXv_decimal5) ;
         diastrabmesparabaseimp.this.AV18dtmAnteriores = (short)(DecimalUtil.decToDouble(GXv_decimal5[0])) ;
         if ( ! (0==AV18dtmAnteriores) )
         {
            if ( AV18dtmAnteriores < AV19dias_mes )
            {
               AV20dias_trabajados_mes = AV13dias_tope ;
               AV21LiqDLog = httpContext.getMessage( "Recupera ", "") + GXutil.trim( GXutil.str( AV13dias_tope, 4, 0)) + httpContext.getMessage( " días para proporcionar tope", "") ;
               AV20dias_trabajados_mes = (short)(AV20dias_trabajados_mes+AV18dtmAnteriores) ;
               AV21LiqDLog += httpContext.getMessage( ". Le suma ", "") + GXutil.trim( GXutil.str( AV18dtmAnteriores, 4, 0)) + httpContext.getMessage( " días de liquidaciones anteriores del mismo periodo, quedando en ", "") + GXutil.trim( GXutil.str( AV20dias_trabajados_mes, 4, 0)) ;
            }
            else
            {
               AV20dias_trabajados_mes = AV18dtmAnteriores ;
               AV21LiqDLog += httpContext.getMessage( "Recupera ", "") + GXutil.trim( GXutil.str( AV18dtmAnteriores, 4, 0)) + httpContext.getMessage( " días de liquidaciones anteriores del mismo periodo, quedando en ", "") + GXutil.trim( GXutil.str( AV20dias_trabajados_mes, 4, 0)) ;
            }
         }
         else
         {
            AV20dias_trabajados_mes = AV13dias_tope ;
            AV21LiqDLog = httpContext.getMessage( "Recupera ", "") + GXutil.trim( GXutil.str( AV13dias_tope, 4, 0)) + httpContext.getMessage( " días para proporcionar tope (concepto ", "") + GXutil.trim( AV8diasPropTopeSueldoConCodigo) + ")" ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP8[0] = diastrabmesparabaseimp.this.AV20dias_trabajados_mes;
      this.aP9[0] = diastrabmesparabaseimp.this.AV16error;
      this.aP10[0] = diastrabmesparabaseimp.this.AV15LiqDCalculado;
      this.aP11[0] = diastrabmesparabaseimp.this.AV21LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV16error = "" ;
      AV21LiqDLog = "" ;
      AV8diasPropTopeSueldoConCodigo = "" ;
      GXv_boolean6 = new boolean[1] ;
      GXv_int7 = new byte[1] ;
      AV25parmValue = "" ;
      GXt_char2 = "" ;
      GXt_char1 = "" ;
      GXv_char3 = new String[1] ;
      GXv_int8 = new short[1] ;
      GXv_int9 = new short[1] ;
      AV27auxLiqDLog = "" ;
      GXv_char4 = new String[1] ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV15LiqDCalculado ;
   private byte AV14dtmLiqDCalculado ;
   private byte GXv_int7[] ;
   private short AV10EmpCod ;
   private short AV19dias_mes ;
   private short AV20dias_trabajados_mes ;
   private short AV13dias_tope ;
   private short GXv_int8[] ;
   private short GXv_int9[] ;
   private short AV18dtmAnteriores ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV11LiqNro ;
   private int AV12LegNumero ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private String AV22ProcesoLiquidacion ;
   private String AV8diasPropTopeSueldoConCodigo ;
   private String GXt_char2 ;
   private String GXt_char1 ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private java.util.Date AV17LiqPeriodo ;
   private boolean AV23insertandoConceptos ;
   private boolean AV24existe ;
   private boolean GXv_boolean6[] ;
   private boolean AV26todosLosMeses30 ;
   private boolean returnInSub ;
   private String AV21LiqDLog ;
   private String AV25parmValue ;
   private String AV27auxLiqDLog ;
   private String AV16error ;
   private String[] aP11 ;
   private short[] aP8 ;
   private String[] aP9 ;
   private byte[] aP10 ;
}

