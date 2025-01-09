package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class obtsueldobasicomensualdecategoria extends GXProcedure
{
   public obtsueldobasicomensualdecategoria( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obtsueldobasicomensualdecategoria.class ), "" );
   }

   public obtsueldobasicomensualdecategoria( int remoteHandle ,
                                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             byte aP3 ,
                             short aP4 ,
                             java.util.Date aP5 ,
                             String[] aP6 ,
                             java.math.BigDecimal[] aP7 )
   {
      obtsueldobasicomensualdecategoria.this.aP8 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        byte aP3 ,
                        short aP4 ,
                        java.util.Date aP5 ,
                        String[] aP6 ,
                        java.math.BigDecimal[] aP7 ,
                        String[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             byte aP3 ,
                             short aP4 ,
                             java.util.Date aP5 ,
                             String[] aP6 ,
                             java.math.BigDecimal[] aP7 ,
                             String[] aP8 )
   {
      obtsueldobasicomensualdecategoria.this.AV9CliCod = aP0;
      obtsueldobasicomensualdecategoria.this.AV30LegConveCodigo = aP1;
      obtsueldobasicomensualdecategoria.this.AV29LegCatCodigo = aP2;
      obtsueldobasicomensualdecategoria.this.AV32claseLeg = aP3;
      obtsueldobasicomensualdecategoria.this.AV31LegPaiCod = aP4;
      obtsueldobasicomensualdecategoria.this.AV19LiqPeriodo = aP5;
      obtsueldobasicomensualdecategoria.this.aP6 = aP6;
      obtsueldobasicomensualdecategoria.this.aP7 = aP7;
      obtsueldobasicomensualdecategoria.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV21SueldoJornal = DecimalUtil.ZERO ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "!!1 &CliCod ", "")+GXutil.trim( GXutil.str( AV9CliCod, 6, 0))+httpContext.getMessage( " &&LegCatCodigo ", "")+GXutil.trim( AV29LegCatCodigo)+httpContext.getMessage( " &&LegConveCodigo ", "")+GXutil.trim( AV30LegConveCodigo)) ;
      if ( ! (GXutil.strcmp("", AV29LegCatCodigo)==0) && ! (GXutil.strcmp("", AV30LegConveCodigo)==0) )
      {
         GXv_int1[0] = AV33CliPaiConve ;
         new web.getpaisdeconvenio(remoteHandle, context).execute( AV30LegConveCodigo, AV31LegPaiCod, GXv_int1) ;
         obtsueldobasicomensualdecategoria.this.AV33CliPaiConve = GXv_int1[0] ;
         GXv_boolean2[0] = AV10devolvioValorHora ;
         GXv_char3[0] = AV13error ;
         GXv_decimal4[0] = AV21SueldoJornal ;
         new web.getescalasalarialvigente3(remoteHandle, context).execute( AV9CliCod, AV33CliPaiConve, AV30LegConveCodigo, AV29LegCatCodigo, AV19LiqPeriodo, AV32claseLeg, httpContext.getMessage( "TOTAL", ""), GXv_boolean2, GXv_char3, GXv_decimal4) ;
         obtsueldobasicomensualdecategoria.this.AV10devolvioValorHora = GXv_boolean2[0] ;
         obtsueldobasicomensualdecategoria.this.AV13error = GXv_char3[0] ;
         obtsueldobasicomensualdecategoria.this.AV21SueldoJornal = GXv_decimal4[0] ;
         GXv_char3[0] = AV25CatDescrip ;
         GXv_boolean2[0] = false ;
         new web.getcategoria(remoteHandle, context).execute( AV9CliCod, AV9CliCod, AV30LegConveCodigo, AV29LegCatCodigo, GXv_char3, GXv_boolean2) ;
         obtsueldobasicomensualdecategoria.this.AV25CatDescrip = GXv_char3[0] ;
         AV8LiqDLog = httpContext.getMessage( "Se inicializa valor con ", "") + GXutil.trim( GXutil.str( AV21SueldoJornal, 14, 2)) + httpContext.getMessage( " según la escala salarial vigente al ", "") + GXutil.trim( localUtil.dtoc( AV19LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) + httpContext.getMessage( " para el convenio ", "") + GXutil.trim( A937LegConveCodigo) + httpContext.getMessage( " de la categoría ", "") + GXutil.trim( AV25CatDescrip) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "error ", "")+AV13error) ;
         if ( ! (GXutil.strcmp("", AV13error)==0) )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "&LegNumero ", "")+GXutil.trim( GXutil.str( AV17LegNumero, 8, 0))+httpContext.getMessage( " &SueldoJornal ", "")+GXutil.trim( GXutil.str( AV21SueldoJornal, 14, 2))) ;
      }
      if ( AV10devolvioValorHora )
      {
         GXv_decimal4[0] = AV16horasMes ;
         GXv_char3[0] = AV27horasMesLiqDLog ;
         GXv_char5[0] = AV13error ;
         new web.horasmes(remoteHandle, context).execute( AV9CliCod, (short)(0), 0, AV19LiqPeriodo, GXv_decimal4, GXv_char3, GXv_char5) ;
         obtsueldobasicomensualdecategoria.this.AV16horasMes = GXv_decimal4[0] ;
         obtsueldobasicomensualdecategoria.this.AV27horasMesLiqDLog = GXv_char3[0] ;
         obtsueldobasicomensualdecategoria.this.AV13error = GXv_char5[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "e!!rror ", "")+AV13error) ;
         if ( ! (GXutil.strcmp("", AV13error)==0) )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "&horasMes ", "")+GXutil.trim( GXutil.str( AV16horasMes, 5, 1))) ;
         AV21SueldoJornal = AV21SueldoJornal.multiply(AV16horasMes) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "&&SueldoJornal ", "")+GXutil.trim( GXutil.str( AV21SueldoJornal, 14, 2))) ;
         GXv_char5[0] = AV28horasMesTooltip ;
         new web.armatooltip(remoteHandle, context).execute( AV9CliCod, AV16horasMes, AV27horasMesLiqDLog, false, GXv_char5) ;
         obtsueldobasicomensualdecategoria.this.AV28horasMesTooltip = GXv_char5[0] ;
         AV8LiqDLog += httpContext.getMessage( ". Se multiplica por ", "") + GXutil.trim( AV28horasMesTooltip) + httpContext.getMessage( " horas del mes", "") ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "liqdlog ", "")+GXutil.trim( AV8LiqDLog)) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = obtsueldobasicomensualdecategoria.this.AV13error;
      this.aP7[0] = obtsueldobasicomensualdecategoria.this.AV21SueldoJornal;
      this.aP8[0] = obtsueldobasicomensualdecategoria.this.AV8LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13error = "" ;
      AV21SueldoJornal = DecimalUtil.ZERO ;
      AV8LiqDLog = "" ;
      AV36Pgmname = "" ;
      GXv_int1 = new short[1] ;
      AV25CatDescrip = "" ;
      GXv_boolean2 = new boolean[1] ;
      A937LegConveCodigo = "" ;
      AV16horasMes = DecimalUtil.ZERO ;
      GXv_decimal4 = new java.math.BigDecimal[1] ;
      AV27horasMesLiqDLog = "" ;
      GXv_char3 = new String[1] ;
      AV28horasMesTooltip = "" ;
      GXv_char5 = new String[1] ;
      AV36Pgmname = "ObtSueldoBasicoMensualDeCategoria" ;
      /* GeneXus formulas. */
      AV36Pgmname = "ObtSueldoBasicoMensualDeCategoria" ;
      Gx_err = (short)(0) ;
   }

   private byte AV32claseLeg ;
   private short AV31LegPaiCod ;
   private short AV33CliPaiConve ;
   private short GXv_int1[] ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV17LegNumero ;
   private java.math.BigDecimal AV21SueldoJornal ;
   private java.math.BigDecimal AV16horasMes ;
   private java.math.BigDecimal GXv_decimal4[] ;
   private String AV30LegConveCodigo ;
   private String AV29LegCatCodigo ;
   private String AV36Pgmname ;
   private String A937LegConveCodigo ;
   private String GXv_char3[] ;
   private String GXv_char5[] ;
   private java.util.Date AV19LiqPeriodo ;
   private boolean AV10devolvioValorHora ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private String AV8LiqDLog ;
   private String AV27horasMesLiqDLog ;
   private String AV13error ;
   private String AV25CatDescrip ;
   private String AV28horasMesTooltip ;
   private String[] aP8 ;
   private String[] aP6 ;
   private java.math.BigDecimal[] aP7 ;
}

