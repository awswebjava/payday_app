package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class calculo_sac_proximo_estimado extends GXProcedure
{
   public calculo_sac_proximo_estimado( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( calculo_sac_proximo_estimado.class ), "" );
   }

   public calculo_sac_proximo_estimado( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             boolean aP7 ,
                             java.math.BigDecimal[] aP8 ,
                             byte[] aP9 ,
                             String[] aP10 )
   {
      calculo_sac_proximo_estimado.this.aP11 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
      return aP11[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        java.util.Date aP5 ,
                        String aP6 ,
                        boolean aP7 ,
                        java.math.BigDecimal[] aP8 ,
                        byte[] aP9 ,
                        String[] aP10 ,
                        String[] aP11 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             boolean aP7 ,
                             java.math.BigDecimal[] aP8 ,
                             byte[] aP9 ,
                             String[] aP10 ,
                             String[] aP11 )
   {
      calculo_sac_proximo_estimado.this.AV19CliCod = aP0;
      calculo_sac_proximo_estimado.this.AV18EmpCod = aP1;
      calculo_sac_proximo_estimado.this.AV17LiqNro = aP2;
      calculo_sac_proximo_estimado.this.AV52LiqRelNro = aP3;
      calculo_sac_proximo_estimado.this.AV16LegNumero = aP4;
      calculo_sac_proximo_estimado.this.AV14LiqPeriodo = aP5;
      calculo_sac_proximo_estimado.this.AV10ProcesoLIquidacion = aP6;
      calculo_sac_proximo_estimado.this.AV46insertandoConceptos = aP7;
      calculo_sac_proximo_estimado.this.aP8 = aP8;
      calculo_sac_proximo_estimado.this.aP9 = aP9;
      calculo_sac_proximo_estimado.this.aP10 = aP10;
      calculo_sac_proximo_estimado.this.aP11 = aP11;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV21LiqDCalculado = (byte)(1) ;
      GXt_char1 = AV25sacLiquidadoConCodigo ;
      GXt_char2 = AV25sacLiquidadoConCodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.concepto_sacliquidadoperiodo_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      calculo_sac_proximo_estimado.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV19CliCod, GXt_char2, GXv_char4) ;
      calculo_sac_proximo_estimado.this.GXt_char1 = GXv_char4[0] ;
      AV25sacLiquidadoConCodigo = GXt_char1 ;
      GXv_decimal5[0] = AV26sacLiquidadoLiqDImpCalcu ;
      GXv_boolean6[0] = AV51existe ;
      GXv_int7[0] = AV27sacLiqLiqDCalculado ;
      new web.getliqdimpcalcu(remoteHandle, context).execute( AV19CliCod, AV18EmpCod, AV17LiqNro, AV16LegNumero, AV25sacLiquidadoConCodigo, AV10ProcesoLIquidacion, AV46insertandoConceptos, GXv_decimal5, GXv_boolean6, GXv_int7) ;
      calculo_sac_proximo_estimado.this.AV26sacLiquidadoLiqDImpCalcu = GXv_decimal5[0] ;
      calculo_sac_proximo_estimado.this.AV51existe = GXv_boolean6[0] ;
      calculo_sac_proximo_estimado.this.AV27sacLiqLiqDCalculado = GXv_int7[0] ;
      if ( ( AV27sacLiqLiqDCalculado == 0 ) && ( AV51existe ) )
      {
         AV21LiqDCalculado = (byte)(0) ;
         AV22error = httpContext.getMessage( "Falta calcular sac liquidado en el semestre", "") ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV55Pgmname, "1") ;
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV26sacLiquidadoLiqDImpCalcu)==0) )
      {
         AV31Importes = AV26sacLiquidadoLiqDImpCalcu ;
         AV23LiqDLog = httpContext.getMessage( "Se inicializa valor con el sac liquidado ", "") + GXutil.trim( GXutil.str( AV26sacLiquidadoLiqDImpCalcu, 14, 2)) ;
         GXt_char2 = AV25sacLiquidadoConCodigo ;
         GXt_char1 = AV25sacLiquidadoConCodigo ;
         GXv_char4[0] = GXt_char1 ;
         new web.otroemplsac_codigoparam(remoteHandle, context).execute( GXv_char4) ;
         calculo_sac_proximo_estimado.this.GXt_char1 = GXv_char4[0] ;
         GXv_char3[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV19CliCod, GXt_char1, GXv_char3) ;
         calculo_sac_proximo_estimado.this.GXt_char2 = GXv_char3[0] ;
         AV25sacLiquidadoConCodigo = GXt_char2 ;
         GXv_decimal5[0] = AV26sacLiquidadoLiqDImpCalcu ;
         GXv_boolean6[0] = AV51existe ;
         GXv_int7[0] = AV27sacLiqLiqDCalculado ;
         new web.getliqdimpcalcu(remoteHandle, context).execute( AV19CliCod, AV18EmpCod, AV17LiqNro, AV16LegNumero, AV25sacLiquidadoConCodigo, AV10ProcesoLIquidacion, AV46insertandoConceptos, GXv_decimal5, GXv_boolean6, GXv_int7) ;
         calculo_sac_proximo_estimado.this.AV26sacLiquidadoLiqDImpCalcu = GXv_decimal5[0] ;
         calculo_sac_proximo_estimado.this.AV51existe = GXv_boolean6[0] ;
         calculo_sac_proximo_estimado.this.AV27sacLiqLiqDCalculado = GXv_int7[0] ;
         if ( ( AV27sacLiqLiqDCalculado == 0 ) && ( AV51existe ) )
         {
            AV21LiqDCalculado = (byte)(0) ;
            AV22error = httpContext.getMessage( "Falta calcular sac otros empleos", "") ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV26sacLiquidadoLiqDImpCalcu)==0) )
         {
            AV31Importes = AV31Importes.add(AV26sacLiquidadoLiqDImpCalcu) ;
            AV23LiqDLog = httpContext.getMessage( "Se suma SAC de otros empleos ", "") + GXutil.trim( GXutil.str( AV26sacLiquidadoLiqDImpCalcu, 14, 2)) ;
         }
      }
      else
      {
         GXt_char2 = AV15haberesSacConCodigo ;
         GXt_char1 = AV15haberesSacConCodigo ;
         GXv_char4[0] = GXt_char1 ;
         new web.concepto_haberessac_codigoparam(remoteHandle, context).execute( GXv_char4) ;
         calculo_sac_proximo_estimado.this.GXt_char1 = GXv_char4[0] ;
         GXv_char3[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV19CliCod, GXt_char1, GXv_char3) ;
         calculo_sac_proximo_estimado.this.GXt_char2 = GXv_char3[0] ;
         AV15haberesSacConCodigo = GXt_char2 ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV55Pgmname, "2") ;
         GXv_decimal5[0] = AV11mejorLiqDImpCalcu ;
         GXv_char4[0] = AV22error ;
         GXv_int7[0] = AV21LiqDCalculado ;
         GXv_char3[0] = AV23LiqDLog ;
         new web.mejorsac(remoteHandle, context).execute( AV19CliCod, AV18EmpCod, AV17LiqNro, AV52LiqRelNro, AV16LegNumero, AV15haberesSacConCodigo, AV14LiqPeriodo, AV10ProcesoLIquidacion, GXv_decimal5, GXv_char4, GXv_int7, GXv_char3) ;
         calculo_sac_proximo_estimado.this.AV11mejorLiqDImpCalcu = GXv_decimal5[0] ;
         calculo_sac_proximo_estimado.this.AV22error = GXv_char4[0] ;
         calculo_sac_proximo_estimado.this.AV21LiqDCalculado = GXv_int7[0] ;
         calculo_sac_proximo_estimado.this.AV23LiqDLog = GXv_char3[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV55Pgmname, "3 "+GXutil.trim( GXutil.str( AV11mejorLiqDImpCalcu, 14, 2))) ;
         if ( AV21LiqDCalculado == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV55Pgmname, "4") ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV31Importes = AV11mejorLiqDImpCalcu ;
         GXt_char2 = AV49otrosEmplConCodigo ;
         GXt_char1 = AV49otrosEmplConCodigo ;
         GXv_char4[0] = GXt_char1 ;
         new web.otroemplgananciabruta_codigoparam(remoteHandle, context).execute( GXv_char4) ;
         calculo_sac_proximo_estimado.this.GXt_char1 = GXv_char4[0] ;
         GXv_char3[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV19CliCod, GXt_char1, GXv_char3) ;
         calculo_sac_proximo_estimado.this.GXt_char2 = GXv_char3[0] ;
         AV49otrosEmplConCodigo = GXt_char2 ;
         GXv_decimal5[0] = AV48otrEmplBrutoLiqDImpCalcu ;
         GXv_boolean6[0] = AV51existe ;
         GXv_int7[0] = AV50auxLiqDCalculado ;
         new web.getliqdimpcalcu(remoteHandle, context).execute( AV19CliCod, AV18EmpCod, AV17LiqNro, AV16LegNumero, AV49otrosEmplConCodigo, AV10ProcesoLIquidacion, AV46insertandoConceptos, GXv_decimal5, GXv_boolean6, GXv_int7) ;
         calculo_sac_proximo_estimado.this.AV48otrEmplBrutoLiqDImpCalcu = GXv_decimal5[0] ;
         calculo_sac_proximo_estimado.this.AV51existe = GXv_boolean6[0] ;
         calculo_sac_proximo_estimado.this.AV50auxLiqDCalculado = GXv_int7[0] ;
         if ( ( AV50auxLiqDCalculado == 0 ) && ( AV51existe ) )
         {
            AV21LiqDCalculado = (byte)(0) ;
            AV22error = httpContext.getMessage( "Falta calcular otros empleos ganancia bruta", "") ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV48otrEmplBrutoLiqDImpCalcu)==0) )
         {
            AV31Importes = AV31Importes.add(AV48otrEmplBrutoLiqDImpCalcu) ;
            AV23LiqDLog += httpContext.getMessage( ". Suma ganancia bruta de otros empleos de mes actual", "") ;
         }
         GXv_char4[0] = AV40TLiqCod ;
         new web.gettipoliq(remoteHandle, context).execute( AV19CliCod, AV18EmpCod, AV17LiqNro, GXv_char4) ;
         calculo_sac_proximo_estimado.this.AV40TLiqCod = GXv_char4[0] ;
         GXt_char2 = AV38primeraQuincenaTLiqCod ;
         GXt_char1 = AV38primeraQuincenaTLiqCod ;
         GXv_char4[0] = GXt_char1 ;
         new web.tipoliqquincena_codigoparam(remoteHandle, context).execute( GXv_char4) ;
         calculo_sac_proximo_estimado.this.GXt_char1 = GXv_char4[0] ;
         GXv_char3[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV19CliCod, GXt_char1, GXv_char3) ;
         calculo_sac_proximo_estimado.this.GXt_char2 = GXv_char3[0] ;
         AV38primeraQuincenaTLiqCod = GXt_char2 ;
         if ( GXutil.strcmp(AV40TLiqCod, AV38primeraQuincenaTLiqCod) == 0 )
         {
            GXv_int7[0] = AV41LegClase ;
            new web.getlegajoclase(remoteHandle, context).execute( AV19CliCod, AV18EmpCod, AV16LegNumero, GXv_int7) ;
            calculo_sac_proximo_estimado.this.AV41LegClase = GXv_int7[0] ;
            GXv_int7[0] = (byte)(AV39esPrimera) ;
            new web.esprimeraquincena(remoteHandle, context).execute( AV19CliCod, AV18EmpCod, AV17LiqNro, AV16LegNumero, AV14LiqPeriodo, AV41LegClase, GXv_int7) ;
            calculo_sac_proximo_estimado.this.AV39esPrimera = GXv_int7[0] ;
            if ( AV39esPrimera == 1 )
            {
               if ( ( GXutil.month( AV14LiqPeriodo) == new web.primermestrabajado(remoteHandle, context).executeUdp( AV19CliCod, AV18EmpCod, AV16LegNumero, AV14LiqPeriodo) ) || ( GXutil.month( AV14LiqPeriodo) == 7 ) )
               {
                  Cond_result = true ;
               }
               else
               {
                  Cond_result = false ;
               }
               if ( Cond_result )
               {
                  AV37primerQuincenaSemestre = true ;
               }
            }
         }
         if ( AV37primerQuincenaSemestre )
         {
            AV31Importes = AV31Importes.multiply(DecimalUtil.doubleToDec(2)) ;
            AV23LiqDLog += httpContext.getMessage( ". Se multiplica por 2 por ser primer quincena del semestre, quedando en ", "") + GXutil.trim( GXutil.str( AV31Importes, 14, 2)) ;
         }
         AV31Importes = AV31Importes.divide(DecimalUtil.doubleToDec(2), 18, java.math.RoundingMode.DOWN) ;
         AV23LiqDLog += httpContext.getMessage( ". Se divide entre 2.", "") ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP8[0] = calculo_sac_proximo_estimado.this.AV31Importes;
      this.aP9[0] = calculo_sac_proximo_estimado.this.AV21LiqDCalculado;
      this.aP10[0] = calculo_sac_proximo_estimado.this.AV22error;
      this.aP11[0] = calculo_sac_proximo_estimado.this.AV23LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV31Importes = DecimalUtil.ZERO ;
      AV22error = "" ;
      AV23LiqDLog = "" ;
      AV25sacLiquidadoConCodigo = "" ;
      AV26sacLiquidadoLiqDImpCalcu = DecimalUtil.ZERO ;
      AV55Pgmname = "" ;
      AV15haberesSacConCodigo = "" ;
      AV11mejorLiqDImpCalcu = DecimalUtil.ZERO ;
      AV49otrosEmplConCodigo = "" ;
      AV48otrEmplBrutoLiqDImpCalcu = DecimalUtil.ZERO ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      GXv_boolean6 = new boolean[1] ;
      AV40TLiqCod = "" ;
      AV38primeraQuincenaTLiqCod = "" ;
      GXt_char2 = "" ;
      GXt_char1 = "" ;
      GXv_char4 = new String[1] ;
      GXv_char3 = new String[1] ;
      GXv_int7 = new byte[1] ;
      AV55Pgmname = "calculo_sac_proximo_estimado" ;
      /* GeneXus formulas. */
      AV55Pgmname = "calculo_sac_proximo_estimado" ;
      Gx_err = (short)(0) ;
   }

   private byte AV21LiqDCalculado ;
   private byte AV27sacLiqLiqDCalculado ;
   private byte AV50auxLiqDCalculado ;
   private byte AV41LegClase ;
   private byte GXv_int7[] ;
   private short AV18EmpCod ;
   private short AV39esPrimera ;
   private short Gx_err ;
   private int AV19CliCod ;
   private int AV17LiqNro ;
   private int AV52LiqRelNro ;
   private int AV16LegNumero ;
   private java.math.BigDecimal AV31Importes ;
   private java.math.BigDecimal AV26sacLiquidadoLiqDImpCalcu ;
   private java.math.BigDecimal AV11mejorLiqDImpCalcu ;
   private java.math.BigDecimal AV48otrEmplBrutoLiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private String AV10ProcesoLIquidacion ;
   private String AV25sacLiquidadoConCodigo ;
   private String AV55Pgmname ;
   private String AV15haberesSacConCodigo ;
   private String AV49otrosEmplConCodigo ;
   private String AV40TLiqCod ;
   private String AV38primeraQuincenaTLiqCod ;
   private String GXt_char2 ;
   private String GXt_char1 ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private java.util.Date AV14LiqPeriodo ;
   private boolean AV46insertandoConceptos ;
   private boolean AV51existe ;
   private boolean returnInSub ;
   private boolean GXv_boolean6[] ;
   private boolean Cond_result ;
   private boolean AV37primerQuincenaSemestre ;
   private String AV23LiqDLog ;
   private String AV22error ;
   private String[] aP11 ;
   private java.math.BigDecimal[] aP8 ;
   private byte[] aP9 ;
   private String[] aP10 ;
}

