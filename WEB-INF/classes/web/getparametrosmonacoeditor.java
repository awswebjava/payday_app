package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getparametrosmonacoeditor extends GXProcedure
{
   public getparametrosmonacoeditor( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getparametrosmonacoeditor.class ), "" );
   }

   public getparametrosmonacoeditor( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String[] aP5 ,
                             String[] aP6 ,
                             String[] aP7 ,
                             String[] aP8 ,
                             String[] aP9 ,
                             String[] aP10 ,
                             String[] aP11 ,
                             String[] aP12 ,
                             String[] aP13 ,
                             String[] aP14 ,
                             String[] aP15 )
   {
      getparametrosmonacoeditor.this.aP16 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16);
      return aP16[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        String[] aP5 ,
                        String[] aP6 ,
                        String[] aP7 ,
                        String[] aP8 ,
                        String[] aP9 ,
                        String[] aP10 ,
                        String[] aP11 ,
                        String[] aP12 ,
                        String[] aP13 ,
                        String[] aP14 ,
                        String[] aP15 ,
                        String[] aP16 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String[] aP5 ,
                             String[] aP6 ,
                             String[] aP7 ,
                             String[] aP8 ,
                             String[] aP9 ,
                             String[] aP10 ,
                             String[] aP11 ,
                             String[] aP12 ,
                             String[] aP13 ,
                             String[] aP14 ,
                             String[] aP15 ,
                             String[] aP16 )
   {
      getparametrosmonacoeditor.this.AV29CliCod = aP0;
      getparametrosmonacoeditor.this.AV30EmpCod = aP1;
      getparametrosmonacoeditor.this.AV31LiqNro = aP2;
      getparametrosmonacoeditor.this.AV32LegNumero = aP3;
      getparametrosmonacoeditor.this.AV16ConCodigo = aP4;
      getparametrosmonacoeditor.this.aP5 = aP5;
      getparametrosmonacoeditor.this.aP6 = aP6;
      getparametrosmonacoeditor.this.aP7 = aP7;
      getparametrosmonacoeditor.this.aP8 = aP8;
      getparametrosmonacoeditor.this.aP9 = aP9;
      getparametrosmonacoeditor.this.aP10 = aP10;
      getparametrosmonacoeditor.this.aP11 = aP11;
      getparametrosmonacoeditor.this.aP12 = aP12;
      getparametrosmonacoeditor.this.aP13 = aP13;
      getparametrosmonacoeditor.this.aP14 = aP14;
      getparametrosmonacoeditor.this.aP15 = aP15;
      getparametrosmonacoeditor.this.aP16 = aP16;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV29CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      getparametrosmonacoeditor.this.GXt_int1 = GXv_int2[0] ;
      AV29CliCod = GXt_int1 ;
      GXt_char3 = AV24sistema ;
      GXv_char4[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV29CliCod, httpContext.getMessage( "sistema", ""), GXv_char4) ;
      getparametrosmonacoeditor.this.GXt_char3 = GXv_char4[0] ;
      AV24sistema = GXt_char3 ;
      GXt_char3 = AV8lineNumbers_OnOff ;
      GXv_char4[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV29CliCod, httpContext.getMessage( "monaco_lineNumbers", ""), GXv_char4) ;
      getparametrosmonacoeditor.this.GXt_char3 = GXv_char4[0] ;
      AV8lineNumbers_OnOff = GXt_char3 ;
      GXt_char3 = AV12wordWrap ;
      GXv_char4[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV29CliCod, httpContext.getMessage( "monaco_wordWrap", ""), GXv_char4) ;
      getparametrosmonacoeditor.this.GXt_char3 = GXv_char4[0] ;
      AV12wordWrap = GXt_char3 ;
      GXt_char3 = AV13wordWrapColumn ;
      GXv_char4[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV29CliCod, httpContext.getMessage( "monaco_Columns", ""), GXv_char4) ;
      getparametrosmonacoeditor.this.GXt_char3 = GXv_char4[0] ;
      AV13wordWrapColumn = GXt_char3 ;
      GXt_char3 = AV9monaco_foreground ;
      GXv_char4[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV29CliCod, httpContext.getMessage( "monaco_foreground", ""), GXv_char4) ;
      getparametrosmonacoeditor.this.GXt_char3 = GXv_char4[0] ;
      AV9monaco_foreground = GXt_char3 ;
      GXt_char3 = AV10monaco_minimap ;
      GXv_char4[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV29CliCod, httpContext.getMessage( "monaco_minimap", ""), GXv_char4) ;
      getparametrosmonacoeditor.this.GXt_char3 = GXv_char4[0] ;
      AV10monaco_minimap = GXt_char3 ;
      GXt_boolean5 = AV15esConceptosDefault ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.esconceptosdefault(remoteHandle, context).execute( GXv_boolean6) ;
      getparametrosmonacoeditor.this.GXt_boolean5 = GXv_boolean6[0] ;
      AV15esConceptosDefault = GXt_boolean5 ;
      if ( ! (GXutil.strcmp("", AV16ConCodigo)==0) )
      {
         GXt_boolean5 = AV39editable ;
         GXv_boolean6[0] = GXt_boolean5 ;
         new web.permitemodificacionformula(remoteHandle, context).execute( AV29CliCod, AV16ConCodigo, GXv_boolean6) ;
         getparametrosmonacoeditor.this.GXt_boolean5 = GXv_boolean6[0] ;
         AV39editable = GXt_boolean5 ;
      }
      else
      {
         AV39editable = true ;
      }
      if ( ( AV15esConceptosDefault ) || ( AV39editable ) )
      {
         AV11readonly = httpContext.getMessage( "false", "") ;
      }
      else
      {
         AV11readonly = httpContext.getMessage( "true", "") ;
      }
      GXt_char3 = AV35parametrosTokens ;
      GXv_char4[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV29CliCod, httpContext.getMessage( "monaco_tokens", ""), GXv_char4) ;
      getparametrosmonacoeditor.this.GXt_char3 = GXv_char4[0] ;
      AV35parametrosTokens = GXt_char3 ;
      GXt_char3 = AV38colorTokenVariables ;
      GXt_char7 = AV38colorTokenVariables ;
      GXv_char4[0] = GXt_char7 ;
      new web.monacocolortokencalculos_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      getparametrosmonacoeditor.this.GXt_char7 = GXv_char4[0] ;
      GXv_char8[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV29CliCod, GXt_char7, GXv_char8) ;
      getparametrosmonacoeditor.this.GXt_char3 = GXv_char8[0] ;
      AV38colorTokenVariables = GXt_char3 ;
      GXt_char7 = AV35parametrosTokens ;
      GXv_char8[0] = GXt_char7 ;
      new web.monacocolortokencalculos_codigoparam(remoteHandle, context).execute( GXv_char8) ;
      getparametrosmonacoeditor.this.GXt_char7 = GXv_char8[0] ;
      AV35parametrosTokens = GXutil.strReplace( AV35parametrosTokens, GXt_char7, GXutil.trim( AV38colorTokenVariables)) ;
      GXt_char7 = AV38colorTokenVariables ;
      GXt_char3 = AV38colorTokenVariables ;
      GXv_char8[0] = GXt_char3 ;
      new web.monacocolortokenconceptos_codigoparam(remoteHandle, context).execute( GXv_char8) ;
      getparametrosmonacoeditor.this.GXt_char3 = GXv_char8[0] ;
      GXv_char4[0] = GXt_char7 ;
      new web.getparametro(remoteHandle, context).execute( AV29CliCod, GXt_char3, GXv_char4) ;
      getparametrosmonacoeditor.this.GXt_char7 = GXv_char4[0] ;
      AV38colorTokenVariables = GXt_char7 ;
      GXt_char7 = AV35parametrosTokens ;
      GXv_char8[0] = GXt_char7 ;
      new web.monacocolortokenconceptos_codigoparam(remoteHandle, context).execute( GXv_char8) ;
      getparametrosmonacoeditor.this.GXt_char7 = GXv_char8[0] ;
      AV35parametrosTokens = GXutil.strReplace( AV35parametrosTokens, GXt_char7, GXutil.trim( AV38colorTokenVariables)) ;
      GXt_char7 = AV38colorTokenVariables ;
      GXt_char3 = AV38colorTokenVariables ;
      GXv_char8[0] = GXt_char3 ;
      new web.monacocolortokennumeros_codigoparam(remoteHandle, context).execute( GXv_char8) ;
      getparametrosmonacoeditor.this.GXt_char3 = GXv_char8[0] ;
      GXv_char4[0] = GXt_char7 ;
      new web.getparametro(remoteHandle, context).execute( AV29CliCod, GXt_char3, GXv_char4) ;
      getparametrosmonacoeditor.this.GXt_char7 = GXv_char4[0] ;
      AV38colorTokenVariables = GXt_char7 ;
      GXt_char7 = AV35parametrosTokens ;
      GXv_char8[0] = GXt_char7 ;
      new web.monacocolortokennumeros_codigoparam(remoteHandle, context).execute( GXv_char8) ;
      getparametrosmonacoeditor.this.GXt_char7 = GXv_char8[0] ;
      AV35parametrosTokens = GXutil.strReplace( AV35parametrosTokens, GXt_char7, GXutil.trim( AV38colorTokenVariables)) ;
      GXt_char7 = AV38colorTokenVariables ;
      GXt_char3 = AV38colorTokenVariables ;
      GXv_char8[0] = GXt_char3 ;
      new web.monacocolortokenvariables_codigoparam(remoteHandle, context).execute( GXv_char8) ;
      getparametrosmonacoeditor.this.GXt_char3 = GXv_char8[0] ;
      GXv_char4[0] = GXt_char7 ;
      new web.getparametro(remoteHandle, context).execute( AV29CliCod, GXt_char3, GXv_char4) ;
      getparametrosmonacoeditor.this.GXt_char7 = GXv_char4[0] ;
      AV38colorTokenVariables = GXt_char7 ;
      GXt_char7 = AV35parametrosTokens ;
      GXv_char8[0] = GXt_char7 ;
      new web.monacocolortokenvariables_codigoparam(remoteHandle, context).execute( GXv_char8) ;
      getparametrosmonacoeditor.this.GXt_char7 = GXv_char8[0] ;
      AV35parametrosTokens = GXutil.strReplace( AV35parametrosTokens, GXt_char7, GXutil.trim( AV38colorTokenVariables)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV42Pgmname, AV35parametrosTokens) ;
      AV17monaco_token.fromJSonString(AV35parametrosTokens, null);
      AV19monacoTokens = "" ;
      AV34i = (short)(0) ;
      AV43GXV1 = 1 ;
      while ( AV43GXV1 <= AV17monaco_token.size() )
      {
         AV18item = (web.Sdtmonaco_token_monaco_tokenItem)((web.Sdtmonaco_token_monaco_tokenItem)AV17monaco_token.elementAt(-1+AV43GXV1));
         AV34i = (short)(AV34i+1) ;
         AV19monacoTokens += "[" + GXutil.trim( AV18item.getgxTv_Sdtmonaco_token_monaco_tokenItem_Regex()) + ", '" + GXutil.trim( AV18item.getgxTv_Sdtmonaco_token_monaco_tokenItem_Nombre()) + "']" ;
         if ( AV34i < AV17monaco_token.size() )
         {
            AV19monacoTokens += "," ;
         }
         AV43GXV1 = (int)(AV43GXV1+1) ;
      }
      AV20monacoTokensStyle = "" ;
      AV34i = (short)(0) ;
      AV44GXV2 = 1 ;
      while ( AV44GXV2 <= AV17monaco_token.size() )
      {
         AV18item = (web.Sdtmonaco_token_monaco_tokenItem)((web.Sdtmonaco_token_monaco_tokenItem)AV17monaco_token.elementAt(-1+AV44GXV2));
         AV34i = (short)(AV34i+1) ;
         AV20monacoTokensStyle += httpContext.getMessage( "{ token: '", "") + GXutil.trim( AV18item.getgxTv_Sdtmonaco_token_monaco_tokenItem_Nombre()) + "', " + GXutil.trim( AV18item.getgxTv_Sdtmonaco_token_monaco_tokenItem_Css()) + " }" ;
         if ( AV34i < AV17monaco_token.size() )
         {
            AV20monacoTokensStyle += "," ;
         }
         AV44GXV2 = (int)(AV44GXV2+1) ;
      }
      GXt_char7 = AV27wsSugerencias ;
      GXt_char3 = AV27wsSugerencias ;
      GXv_char8[0] = GXt_char3 ;
      new web.monacourlsug_codigoparam(remoteHandle, context).execute( GXv_char8) ;
      getparametrosmonacoeditor.this.GXt_char3 = GXv_char8[0] ;
      GXv_char4[0] = GXt_char7 ;
      new web.getparametro(remoteHandle, context).execute( AV29CliCod, GXt_char3, GXv_char4) ;
      getparametrosmonacoeditor.this.GXt_char7 = GXv_char4[0] ;
      AV27wsSugerencias = GXt_char7 ;
      AV28puerto = AV26httpRequest.getServerPort() ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV42Pgmname, httpContext.getMessage( "&&httpRequest.BaseUrl.Trim() ", "")+GXutil.trim( AV26httpRequest.getBaseURL())) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV42Pgmname, httpContext.getMessage( "&wsSugerencias ", "")+GXutil.trim( AV27wsSugerencias)) ;
      AV21urlSugerencias = GXutil.trim( AV26httpRequest.getBaseURL()) + GXutil.trim( AV27wsSugerencias) + httpContext.getMessage( "?CliCod=", "") + GXutil.trim( GXutil.str( AV29CliCod, 6, 0)) + httpContext.getMessage( ",EmpCod=", "") + GXutil.trim( GXutil.str( AV30EmpCod, 4, 0)) + httpContext.getMessage( ",LiqNro=", "") + GXutil.trim( GXutil.str( AV31LiqNro, 8, 0)) + httpContext.getMessage( ",LegNumero=", "") + GXutil.trim( GXutil.str( AV32LegNumero, 8, 0)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV42Pgmname, httpContext.getMessage( "&urlSugerencias ", "")+GXutil.trim( AV21urlSugerencias)) ;
      GXt_char7 = AV22nombreLenguaje ;
      GXv_char8[0] = GXt_char7 ;
      new web.monaconombrelenguaje(remoteHandle, context).execute( GXv_char8) ;
      getparametrosmonacoeditor.this.GXt_char7 = GXv_char8[0] ;
      AV22nombreLenguaje = GXt_char7 ;
      GXt_char7 = AV23monacoBrackets ;
      GXv_char8[0] = GXt_char7 ;
      new web.getparametro(remoteHandle, context).execute( AV29CliCod, httpContext.getMessage( "monaco_brackets", ""), GXv_char8) ;
      getparametrosmonacoeditor.this.GXt_char7 = GXv_char8[0] ;
      AV23monacoBrackets = GXt_char7 ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = getparametrosmonacoeditor.this.AV8lineNumbers_OnOff;
      this.aP6[0] = getparametrosmonacoeditor.this.AV12wordWrap;
      this.aP7[0] = getparametrosmonacoeditor.this.AV13wordWrapColumn;
      this.aP8[0] = getparametrosmonacoeditor.this.AV9monaco_foreground;
      this.aP9[0] = getparametrosmonacoeditor.this.AV10monaco_minimap;
      this.aP10[0] = getparametrosmonacoeditor.this.AV11readonly;
      this.aP11[0] = getparametrosmonacoeditor.this.AV19monacoTokens;
      this.aP12[0] = getparametrosmonacoeditor.this.AV20monacoTokensStyle;
      this.aP13[0] = getparametrosmonacoeditor.this.AV21urlSugerencias;
      this.aP14[0] = getparametrosmonacoeditor.this.AV22nombreLenguaje;
      this.aP15[0] = getparametrosmonacoeditor.this.AV23monacoBrackets;
      this.aP16[0] = getparametrosmonacoeditor.this.AV24sistema;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8lineNumbers_OnOff = "" ;
      AV12wordWrap = "" ;
      AV13wordWrapColumn = "" ;
      AV9monaco_foreground = "" ;
      AV10monaco_minimap = "" ;
      AV11readonly = "" ;
      AV19monacoTokens = "" ;
      AV20monacoTokensStyle = "" ;
      AV21urlSugerencias = "" ;
      AV22nombreLenguaje = "" ;
      AV23monacoBrackets = "" ;
      AV24sistema = "" ;
      GXv_int2 = new int[1] ;
      GXv_boolean6 = new boolean[1] ;
      AV35parametrosTokens = "" ;
      AV38colorTokenVariables = "" ;
      AV42Pgmname = "" ;
      AV17monaco_token = new GXBaseCollection<web.Sdtmonaco_token_monaco_tokenItem>(web.Sdtmonaco_token_monaco_tokenItem.class, "monaco_tokenItem", "PayDay", remoteHandle);
      AV18item = new web.Sdtmonaco_token_monaco_tokenItem(remoteHandle, context);
      AV27wsSugerencias = "" ;
      GXt_char3 = "" ;
      GXv_char4 = new String[1] ;
      AV26httpRequest = httpContext.getHttpRequest();
      GXt_char7 = "" ;
      GXv_char8 = new String[1] ;
      AV42Pgmname = "getParametrosMonacoEditor" ;
      /* GeneXus formulas. */
      AV42Pgmname = "getParametrosMonacoEditor" ;
      Gx_err = (short)(0) ;
   }

   private short AV30EmpCod ;
   private short AV34i ;
   private short Gx_err ;
   private int AV29CliCod ;
   private int AV31LiqNro ;
   private int AV32LegNumero ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int AV43GXV1 ;
   private int AV44GXV2 ;
   private int AV28puerto ;
   private String AV16ConCodigo ;
   private String AV8lineNumbers_OnOff ;
   private String AV12wordWrap ;
   private String AV13wordWrapColumn ;
   private String AV9monaco_foreground ;
   private String AV10monaco_minimap ;
   private String AV11readonly ;
   private String AV22nombreLenguaje ;
   private String AV24sistema ;
   private String AV38colorTokenVariables ;
   private String AV42Pgmname ;
   private String GXt_char3 ;
   private String GXv_char4[] ;
   private String GXt_char7 ;
   private String GXv_char8[] ;
   private boolean AV15esConceptosDefault ;
   private boolean AV39editable ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private String AV35parametrosTokens ;
   private String AV19monacoTokens ;
   private String AV20monacoTokensStyle ;
   private String AV21urlSugerencias ;
   private String AV23monacoBrackets ;
   private String AV27wsSugerencias ;
   private com.genexus.internet.HttpRequest AV26httpRequest ;
   private String[] aP16 ;
   private String[] aP5 ;
   private String[] aP6 ;
   private String[] aP7 ;
   private String[] aP8 ;
   private String[] aP9 ;
   private String[] aP10 ;
   private String[] aP11 ;
   private String[] aP12 ;
   private String[] aP13 ;
   private String[] aP14 ;
   private String[] aP15 ;
   private GXBaseCollection<web.Sdtmonaco_token_monaco_tokenItem> AV17monaco_token ;
   private web.Sdtmonaco_token_monaco_tokenItem AV18item ;
}

