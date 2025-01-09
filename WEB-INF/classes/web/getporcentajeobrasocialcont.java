package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getporcentajeobrasocialcont extends GXProcedure
{
   public getporcentajeobrasocialcont( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getporcentajeobrasocialcont.class ), "" );
   }

   public getporcentajeobrasocialcont( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           short aP1 ,
                           int aP2 ,
                           int aP3 ,
                           java.util.Date aP4 ,
                           String aP5 ,
                           boolean aP6 ,
                           String aP7 ,
                           java.math.BigDecimal[] aP8 ,
                           String[] aP9 )
   {
      getporcentajeobrasocialcont.this.aP10 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        String aP5 ,
                        boolean aP6 ,
                        String aP7 ,
                        java.math.BigDecimal[] aP8 ,
                        String[] aP9 ,
                        byte[] aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             boolean aP6 ,
                             String aP7 ,
                             java.math.BigDecimal[] aP8 ,
                             String[] aP9 ,
                             byte[] aP10 )
   {
      getporcentajeobrasocialcont.this.AV13CliCod = aP0;
      getporcentajeobrasocialcont.this.AV17EmpCod = aP1;
      getporcentajeobrasocialcont.this.AV23LiqNro = aP2;
      getporcentajeobrasocialcont.this.AV18LegNumero = aP3;
      getporcentajeobrasocialcont.this.AV14LiqPeriodo = aP4;
      getporcentajeobrasocialcont.this.AV15ProcesoLiquidacion = aP5;
      getporcentajeobrasocialcont.this.AV25insertandoConceptos = aP6;
      getporcentajeobrasocialcont.this.AV22que = aP7;
      getporcentajeobrasocialcont.this.aP8 = aP8;
      getporcentajeobrasocialcont.this.aP9 = aP9;
      getporcentajeobrasocialcont.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV28LiqDCalculado = (byte)(1) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "que ", "")+AV22que) ;
      GXt_char1 = AV24brutoConCodigo ;
      GXt_char2 = AV24brutoConCodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.concepto_sueldobruto_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      getporcentajeobrasocialcont.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV13CliCod, GXt_char2, GXv_char4) ;
      getporcentajeobrasocialcont.this.GXt_char1 = GXv_char4[0] ;
      AV24brutoConCodigo = GXt_char1 ;
      GXv_decimal5[0] = AV21brutoImportes ;
      GXv_boolean6[0] = AV29existe ;
      GXv_int7[0] = AV26brutoLiqDCalculado ;
      new web.getliqdimpcalcu(remoteHandle, context).execute( AV13CliCod, AV17EmpCod, AV23LiqNro, AV18LegNumero, AV24brutoConCodigo, AV15ProcesoLiquidacion, AV25insertandoConceptos, GXv_decimal5, GXv_boolean6, GXv_int7) ;
      getporcentajeobrasocialcont.this.AV21brutoImportes = GXv_decimal5[0] ;
      getporcentajeobrasocialcont.this.AV29existe = GXv_boolean6[0] ;
      getporcentajeobrasocialcont.this.AV26brutoLiqDCalculado = GXv_int7[0] ;
      if ( ( AV26brutoLiqDCalculado == 0 ) && ( AV29existe ) )
      {
         AV27error = httpContext.getMessage( "Falta calcular sueldo bruto", "") ;
         AV28LiqDCalculado = (byte)(0) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "return 1", "")) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV12OpeCliId = "[distr_OS_ali]" ;
      GXv_char4[0] = AV16distr_OS_ali_VarcharJSON ;
      GXv_char3[0] = AV30auxError ;
      new web.getopeclivalor(remoteHandle, context).execute( AV13CliCod, AV12OpeCliId, AV14LiqPeriodo, AV15ProcesoLiquidacion, GXv_char4, GXv_char3) ;
      getporcentajeobrasocialcont.this.AV16distr_OS_ali_VarcharJSON = GXv_char4[0] ;
      getporcentajeobrasocialcont.this.AV30auxError = GXv_char3[0] ;
      if ( ! (GXutil.strcmp("", AV30auxError)==0) )
      {
         AV28LiqDCalculado = (byte)(0) ;
         AV27error = AV30auxError ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV11pct_os_fsr.fromJSonString(AV16distr_OS_ali_VarcharJSON, null);
      GXv_char4[0] = AV8ConveCodigo ;
      new web.empleadogetconvenio(remoteHandle, context).execute( AV13CliCod, AV17EmpCod, AV18LegNumero, GXv_char4) ;
      getporcentajeobrasocialcont.this.AV8ConveCodigo = GXv_char4[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "&ConveCodigo ", "")+GXutil.trim( AV8ConveCodigo)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "&&pct_os_fsr ", "")+GXutil.trim( AV11pct_os_fsr.toJSonString(false))+httpContext.getMessage( " &brutoImportes ", "")+GXutil.trim( GXutil.str( AV21brutoImportes, 14, 2))) ;
      AV34GXV1 = 1 ;
      while ( AV34GXV1 <= AV11pct_os_fsr.size() )
      {
         AV20item = (web.Sdtpct_os_fsr_pct_os_fsrItem)((web.Sdtpct_os_fsr_pct_os_fsrItem)AV11pct_os_fsr.elementAt(-1+AV34GXV1));
         new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, "1") ;
         if ( ( DecimalUtil.compareTo(AV21brutoImportes, AV20item.getgxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneraciondesde()) >= 0 ) && ( ( DecimalUtil.compareTo(AV21brutoImportes, AV20item.getgxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneracionhasta()) <= 0 ) || ( AV20item.getgxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneracionhasta().doubleValue() == 0 ) ) )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, "2") ;
            if ( ( ( AV20item.getgxTv_Sdtpct_os_fsr_pct_os_fsrItem_Enconvenio() ) && ! (GXutil.strcmp("", AV8ConveCodigo)==0) ) || ( ! AV20item.getgxTv_Sdtpct_os_fsr_pct_os_fsrItem_Enconvenio() && (GXutil.strcmp("", AV8ConveCodigo)==0) ) )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, "3") ;
               if ( GXutil.strcmp(AV22que, httpContext.getMessage( "OS", "")) == 0 )
               {
                  AV9porUnaje = AV20item.getgxTv_Sdtpct_os_fsr_pct_os_fsrItem_Alicuota() ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, "4") ;
               }
               else
               {
                  AV9porUnaje = DecimalUtil.doubleToDec(1).subtract(AV20item.getgxTv_Sdtpct_os_fsr_pct_os_fsrItem_Alicuota()) ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, "5") ;
               }
            }
         }
         AV34GXV1 = (int)(AV34GXV1+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP8[0] = getporcentajeobrasocialcont.this.AV9porUnaje;
      this.aP9[0] = getporcentajeobrasocialcont.this.AV27error;
      this.aP10[0] = getporcentajeobrasocialcont.this.AV28LiqDCalculado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9porUnaje = DecimalUtil.ZERO ;
      AV27error = "" ;
      AV33Pgmname = "" ;
      AV24brutoConCodigo = "" ;
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      AV21brutoImportes = DecimalUtil.ZERO ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      GXv_boolean6 = new boolean[1] ;
      GXv_int7 = new byte[1] ;
      AV12OpeCliId = "" ;
      AV16distr_OS_ali_VarcharJSON = "" ;
      AV30auxError = "" ;
      GXv_char3 = new String[1] ;
      AV11pct_os_fsr = new GXBaseCollection<web.Sdtpct_os_fsr_pct_os_fsrItem>(web.Sdtpct_os_fsr_pct_os_fsrItem.class, "pct_os_fsrItem", "PayDay", remoteHandle);
      AV8ConveCodigo = "" ;
      GXv_char4 = new String[1] ;
      AV20item = new web.Sdtpct_os_fsr_pct_os_fsrItem(remoteHandle, context);
      AV33Pgmname = "getPorcentajeObraSocialCont" ;
      /* GeneXus formulas. */
      AV33Pgmname = "getPorcentajeObraSocialCont" ;
      Gx_err = (short)(0) ;
   }

   private byte AV28LiqDCalculado ;
   private byte AV26brutoLiqDCalculado ;
   private byte GXv_int7[] ;
   private short AV17EmpCod ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV23LiqNro ;
   private int AV18LegNumero ;
   private int AV34GXV1 ;
   private java.math.BigDecimal AV9porUnaje ;
   private java.math.BigDecimal AV21brutoImportes ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private String AV15ProcesoLiquidacion ;
   private String AV22que ;
   private String AV33Pgmname ;
   private String AV24brutoConCodigo ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String AV12OpeCliId ;
   private String GXv_char3[] ;
   private String AV8ConveCodigo ;
   private String GXv_char4[] ;
   private java.util.Date AV14LiqPeriodo ;
   private boolean AV25insertandoConceptos ;
   private boolean AV29existe ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private String AV27error ;
   private String AV16distr_OS_ali_VarcharJSON ;
   private String AV30auxError ;
   private byte[] aP10 ;
   private java.math.BigDecimal[] aP8 ;
   private String[] aP9 ;
   private GXBaseCollection<web.Sdtpct_os_fsr_pct_os_fsrItem> AV11pct_os_fsr ;
   private web.Sdtpct_os_fsr_pct_os_fsrItem AV20item ;
}

