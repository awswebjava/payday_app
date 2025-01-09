package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class f1357_mostrargnsi_impl extends GXDataArea
{
   public f1357_mostrargnsi_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public f1357_mostrargnsi_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( f1357_mostrargnsi_impl.class ));
   }

   public f1357_mostrargnsi_impl( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "CliCod") ;
         gxfirstwebparm_bkp = gxfirstwebparm ;
         gxfirstwebparm = httpContext.DecryptAjaxCall( gxfirstwebparm) ;
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
         if ( GXutil.strcmp(gxfirstwebparm, "dyncall") == 0 )
         {
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            dyncall( httpContext.GetNextPar( )) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxEvt") == 0 )
         {
            httpContext.setAjaxEventMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "CliCod") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "CliCod") ;
         }
         else
         {
            if ( ! httpContext.IsValidAjaxCall( false) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = gxfirstwebparm_bkp ;
         }
         if ( ! entryPointCalled && ! ( isAjaxCallMode( ) || isFullAjaxMode( ) ) )
         {
            AV8CliCod = (int)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliCod), 6, 0));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV15EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV15EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15EmpCod), 4, 0));
               AV16F1357CTipoPre = (byte)(GXutil.lval( httpContext.GetPar( "F1357CTipoPre"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV16F1357CTipoPre", GXutil.str( AV16F1357CTipoPre, 1, 0));
               AV9F1357CPer = httpContext.GetPar( "F1357CPer") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV9F1357CPer", AV9F1357CPer);
               AV10F1357CSec = (byte)(GXutil.lval( httpContext.GetPar( "F1357CSec"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV10F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10F1357CSec), 2, 0));
               AV11LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV11LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11LegNumero), 8, 0));
            }
         }
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         MasterPageObj= createMasterPage(remoteHandle, "web.wwpbaseobjects.workwithplusmasterpageprompt");
         MasterPageObj.setDataArea(this,false);
         validateSpaRequest();
         MasterPageObj.webExecute();
         if ( ( GxWebError == 0 ) && httpContext.isAjaxRequest( ) )
         {
            httpContext.enableOutput();
            if ( ! httpContext.isAjaxRequest( ) )
            {
               httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
            }
            if ( ! httpContext.willRedirect( ) )
            {
               addString( httpContext.getJSONResponse( )) ;
            }
            else
            {
               if ( httpContext.isAjaxRequest( ) )
               {
                  httpContext.disableOutput();
               }
               renderHtmlHeaders( ) ;
               httpContext.redirect( httpContext.wjLoc );
               httpContext.dispatchAjaxCommands();
            }
         }
      }
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
   }

   public byte executeStartEvent( )
   {
      pa9Q2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start9Q2( ) ;
      }
      return gxajaxcallmode ;
   }

   public void renderHtmlHeaders( )
   {
      web.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), true);
   }

   public void renderHtmlOpenForm( )
   {
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.writeText( "<title>") ;
      httpContext.writeValue( Form.getCaption()) ;
      httpContext.writeTextNL( "</title>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( GXutil.len( sDynURL) > 0 )
      {
         httpContext.writeText( "<BASE href=\""+sDynURL+"\" />") ;
      }
      define_styles( ) ;
      if ( nGXWrapped != 1 )
      {
         MasterPageObj.master_styles();
      }
      if ( ( ( httpContext.getBrowserType( ) == 1 ) || ( httpContext.getBrowserType( ) == 5 ) ) && ( GXutil.strcmp(httpContext.getBrowserVersion( ), "7.0") == 0 ) )
      {
         httpContext.AddJavascriptSource("json2.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      }
      httpContext.AddJavascriptSource("jquery.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("gxgral.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("gxcfg.js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = ((nGXWrapped==0) ? " data-HasEnter=\"false\" data-Skiponenter=\"false\"" : "") ;
      httpContext.writeText( "<body ") ;
      bodyStyle = "" + "background-color:" + WebUtils.getHTMLColor( Form.getIBackground()) + ";color:" + WebUtils.getHTMLColor( Form.getTextcolor()) + ";" ;
      if ( nGXWrapped == 0 )
      {
         bodyStyle += "-moz-opacity:0;opacity:0;" ;
      }
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      if ( nGXWrapped != 1 )
      {
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.f1357_mostrargnsi", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV8CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV15EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV16F1357CTipoPre,1,0)),GXutil.URLEncode(GXutil.rtrim(AV9F1357CPer)),GXutil.URLEncode(GXutil.ltrimstr(AV10F1357CSec,2,0)),GXutil.URLEncode(GXutil.ltrimstr(AV11LegNumero,8,0))}, new String[] {"CliCod","EmpCod","F1357CTipoPre","F1357CPer","F1357CSec","LegNumero"}) +"\">") ;
         web.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
         web.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
         web.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
         httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
      }
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", "hsh"+"F1357_MostrarGNSI");
      forbiddenHiddens.add("GXV1", localUtil.format( AV7F1357_GNSI.getgxTv_SdtF1357_GNSI_F1357lrgravada(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("GXV2", localUtil.format( AV7F1357_GNSI.getgxTv_SdtF1357_GNSI_Anticiposdesac(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("GXV3", localUtil.format( AV7F1357_GNSI.getgxTv_SdtF1357_GNSI_F1357ldgtotal(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("GXV4", localUtil.format( AV7F1357_GNSI.getgxTv_SdtF1357_GNSI_F1357ldptotalart30(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("GXV5", localUtil.format( AV7F1357_GNSI.getgxTv_SdtF1357_GNSI_Descuentosdeley(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("f1357_mostrargnsi:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "F1357_gnsi", AV7F1357_GNSI);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("F1357_gnsi", AV7F1357_GNSI);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV8CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV15EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vF1357CTIPOPRE", GXutil.ltrim( localUtil.ntoc( AV16F1357CTipoPre, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vF1357CPER", GXutil.rtrim( AV9F1357CPer));
      web.GxWebStd.gx_hidden_field( httpContext, "vF1357CSEC", GXutil.ltrim( localUtil.ntoc( AV10F1357CSec, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLEGNUMERO", GXutil.ltrim( localUtil.ntoc( AV11LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vF1357_GNSI", AV7F1357_GNSI);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vF1357_GNSI", AV7F1357_GNSI);
      }
   }

   public void renderHtmlCloseForm( )
   {
      sendCloseFormHiddens( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "GX_FocusControl", GX_FocusControl);
      httpContext.SendAjaxEncryptionKey();
      sendSecurityToken(sPrefix);
      httpContext.SendComponentObjects();
      httpContext.SendServerCommands();
      httpContext.SendState();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( nGXWrapped != 1 )
      {
         httpContext.writeTextNL( "</form>") ;
      }
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      include_jscripts( ) ;
      httpContext.writeText( "<script type=\"text/javascript\">") ;
      httpContext.writeText( "gx.setLanguageCode(\""+httpContext.getLanguageProperty( "code")+"\");") ;
      if ( ! httpContext.isSpaRequest( ) )
      {
         httpContext.writeText( "gx.setDateFormat(\""+httpContext.getLanguageProperty( "date_fmt")+"\");") ;
         httpContext.writeText( "gx.setTimeFormat("+httpContext.getLanguageProperty( "time_fmt")+");") ;
         httpContext.writeText( "gx.setCenturyFirstYear("+40+");") ;
         httpContext.writeText( "gx.setDecimalPoint(\""+httpContext.getLanguageProperty( "decimal_point")+"\");") ;
         httpContext.writeText( "gx.setThousandSeparator(\""+httpContext.getLanguageProperty( "thousand_sep")+"\");") ;
         httpContext.writeText( "gx.StorageTimeZone = "+1+";") ;
      }
      httpContext.writeText( "</script>") ;
   }

   public void renderHtmlContent( )
   {
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         httpContext.writeText( "<div") ;
         web.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         we9Q2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt9Q2( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return false ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("web.f1357_mostrargnsi", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV8CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV15EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV16F1357CTipoPre,1,0)),GXutil.URLEncode(GXutil.rtrim(AV9F1357CPer)),GXutil.URLEncode(GXutil.ltrimstr(AV10F1357CSec,2,0)),GXutil.URLEncode(GXutil.ltrimstr(AV11LegNumero,8,0))}, new String[] {"CliCod","EmpCod","F1357CTipoPre","F1357CPer","F1357CSec","LegNumero"})  ;
   }

   public String getPgmname( )
   {
      return "F1357_MostrarGNSI" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Composición de GNSI", "") ;
   }

   public void wb9Q0( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         if ( nGXWrapped == 1 )
         {
            renderHtmlHeaders( ) ;
            renderHtmlOpenForm( ) ;
         }
         web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), "", "", "", "false");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", divLayoutmaintable_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMainPopover", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableattributes_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavF1357_gnsi_f1357lrgravada_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavF1357_gnsi_f1357lrgravada_Internalname, httpContext.getMessage( "+ REMUNERACIÓN GRAVADA (Incluye pluriempleo, y sin restar los descuentos de ley)", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtavF1357_gnsi_f1357lrgravada_Internalname, GXutil.ltrim( localUtil.ntoc( AV7F1357_GNSI.getgxTv_SdtF1357_GNSI_F1357lrgravada(), (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavF1357_gnsi_f1357lrgravada_Enabled!=0) ? localUtil.format( AV7F1357_GNSI.getgxTv_SdtF1357_GNSI_F1357lrgravada(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV7F1357_GNSI.getgxTv_SdtF1357_GNSI_F1357lrgravada(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavF1357_gnsi_f1357lrgravada_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavF1357_gnsi_f1357lrgravada_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_F1357_MostrarGNSI.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavF1357_gnsi_anticiposdesac_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavF1357_gnsi_anticiposdesac_Internalname, httpContext.getMessage( "+ ANTICIPOS DE SAC", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtavF1357_gnsi_anticiposdesac_Internalname, GXutil.ltrim( localUtil.ntoc( AV7F1357_GNSI.getgxTv_SdtF1357_GNSI_Anticiposdesac(), (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavF1357_gnsi_anticiposdesac_Enabled!=0) ? localUtil.format( AV7F1357_GNSI.getgxTv_SdtF1357_GNSI_Anticiposdesac(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV7F1357_GNSI.getgxTv_SdtF1357_GNSI_Anticiposdesac(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavF1357_gnsi_anticiposdesac_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavF1357_gnsi_anticiposdesac_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_F1357_MostrarGNSI.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavF1357_gnsi_f1357ldgtotal_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavF1357_gnsi_f1357ldgtotal_Internalname, httpContext.getMessage( "- TOTAL DEDUCCIONES GENERALES", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtavF1357_gnsi_f1357ldgtotal_Internalname, GXutil.ltrim( localUtil.ntoc( AV7F1357_GNSI.getgxTv_SdtF1357_GNSI_F1357ldgtotal(), (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavF1357_gnsi_f1357ldgtotal_Enabled!=0) ? localUtil.format( AV7F1357_GNSI.getgxTv_SdtF1357_GNSI_F1357ldgtotal(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV7F1357_GNSI.getgxTv_SdtF1357_GNSI_F1357ldgtotal(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavF1357_gnsi_f1357ldgtotal_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavF1357_gnsi_f1357ldgtotal_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_F1357_MostrarGNSI.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavF1357_gnsi_f1357ldptotalart30_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavF1357_gnsi_f1357ldptotalart30_Internalname, httpContext.getMessage( "- TOTAL DEDUCCIONES ART. 30", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtavF1357_gnsi_f1357ldptotalart30_Internalname, GXutil.ltrim( localUtil.ntoc( AV7F1357_GNSI.getgxTv_SdtF1357_GNSI_F1357ldptotalart30(), (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavF1357_gnsi_f1357ldptotalart30_Enabled!=0) ? localUtil.format( AV7F1357_GNSI.getgxTv_SdtF1357_GNSI_F1357ldptotalart30(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV7F1357_GNSI.getgxTv_SdtF1357_GNSI_F1357ldptotalart30(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavF1357_gnsi_f1357ldptotalart30_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavF1357_gnsi_f1357ldptotalart30_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_F1357_MostrarGNSI.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavF1357_gnsi_descuentosdeley_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavF1357_gnsi_descuentosdeley_Internalname, httpContext.getMessage( "- Descuentos De Ley sobre impuesto gravado (Incluye pluriempleo)", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtavF1357_gnsi_descuentosdeley_Internalname, GXutil.ltrim( localUtil.ntoc( AV7F1357_GNSI.getgxTv_SdtF1357_GNSI_Descuentosdeley(), (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavF1357_gnsi_descuentosdeley_Enabled!=0) ? localUtil.format( AV7F1357_GNSI.getgxTv_SdtF1357_GNSI_Descuentosdeley(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV7F1357_GNSI.getgxTv_SdtF1357_GNSI_Descuentosdeley(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavF1357_gnsi_descuentosdeley_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavF1357_gnsi_descuentosdeley_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_F1357_MostrarGNSI.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start9Q2( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
         }
         Form.getMeta().addItem("description", httpContext.getMessage( "Composición de GNSI", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup9Q0( ) ;
   }

   public void ws9Q2( )
   {
      start9Q2( ) ;
      evt9Q2( ) ;
   }

   public void evt9Q2( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
            sEvt = httpContext.cgiGet( "_EventName") ;
            EvtGridId = httpContext.cgiGet( "_EventGridId") ;
            EvtRowId = httpContext.cgiGet( "_EventRowId") ;
            if ( GXutil.len( sEvt) > 0 )
            {
               sEvtType = GXutil.left( sEvt, 1) ;
               sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
               if ( GXutil.strcmp(sEvtType, "M") != 0 )
               {
                  if ( GXutil.strcmp(sEvtType, "E") == 0 )
                  {
                     sEvtType = GXutil.right( sEvt, 1) ;
                     if ( GXutil.strcmp(sEvtType, ".") == 0 )
                     {
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                        if ( GXutil.strcmp(sEvt, "RFR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                        }
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Start */
                           e119Q2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e129Q2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           if ( ! wbErr )
                           {
                              Rfr0gs = false ;
                              if ( ! Rfr0gs )
                              {
                              }
                              dynload_actions( ) ;
                           }
                           /* No code required for Cancel button. It is implemented as the Reset button. */
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we9Q2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            if ( nGXWrapped == 1 )
            {
               renderHtmlCloseForm( ) ;
            }
         }
      }
   }

   public void pa9Q2( )
   {
      if ( nDonePA == 0 )
      {
         if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
         {
            gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
         }
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
         init_web_controls( ) ;
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
         if ( ! httpContext.isAjaxRequest( ) )
         {
            GX_FocusControl = edtavF1357_gnsi_f1357lrgravada_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void send_integrity_hashes( )
   {
   }

   public void clear_multi_value_controls( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf9Q2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV26Pgmname = "F1357_MostrarGNSI" ;
      Gx_err = (short)(0) ;
      edtavF1357_gnsi_f1357lrgravada_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_gnsi_f1357lrgravada_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_gnsi_f1357lrgravada_Enabled), 5, 0), true);
      edtavF1357_gnsi_anticiposdesac_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_gnsi_anticiposdesac_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_gnsi_anticiposdesac_Enabled), 5, 0), true);
      edtavF1357_gnsi_f1357ldgtotal_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_gnsi_f1357ldgtotal_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_gnsi_f1357ldgtotal_Enabled), 5, 0), true);
      edtavF1357_gnsi_f1357ldptotalart30_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_gnsi_f1357ldptotalart30_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_gnsi_f1357ldptotalart30_Enabled), 5, 0), true);
      edtavF1357_gnsi_descuentosdeley_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_gnsi_descuentosdeley_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_gnsi_descuentosdeley_Enabled), 5, 0), true);
   }

   public void rf9Q2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e129Q2 ();
         wb9Q0( ) ;
      }
   }

   public void send_integrity_lvl_hashes9Q2( )
   {
   }

   public void before_start_formulas( )
   {
      AV26Pgmname = "F1357_MostrarGNSI" ;
      Gx_err = (short)(0) ;
      edtavF1357_gnsi_f1357lrgravada_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_gnsi_f1357lrgravada_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_gnsi_f1357lrgravada_Enabled), 5, 0), true);
      edtavF1357_gnsi_anticiposdesac_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_gnsi_anticiposdesac_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_gnsi_anticiposdesac_Enabled), 5, 0), true);
      edtavF1357_gnsi_f1357ldgtotal_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_gnsi_f1357ldgtotal_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_gnsi_f1357ldgtotal_Enabled), 5, 0), true);
      edtavF1357_gnsi_f1357ldptotalart30_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_gnsi_f1357ldptotalart30_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_gnsi_f1357ldptotalart30_Enabled), 5, 0), true);
      edtavF1357_gnsi_descuentosdeley_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_gnsi_descuentosdeley_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_gnsi_descuentosdeley_Enabled), 5, 0), true);
      fix_multi_value_controls( ) ;
   }

   public void strup9Q0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e119Q2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vF1357_GNSI"), AV7F1357_GNSI);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "F1357_gnsi"), AV7F1357_GNSI);
         /* Read saved values. */
         /* Read variables values. */
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_gnsi_f1357lrgravada_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_gnsi_f1357lrgravada_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357_GNSI_F1357LRGRAVADA");
            GX_FocusControl = edtavF1357_gnsi_f1357lrgravada_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7F1357_GNSI.setgxTv_SdtF1357_GNSI_F1357lrgravada( DecimalUtil.ZERO );
         }
         else
         {
            AV7F1357_GNSI.setgxTv_SdtF1357_GNSI_F1357lrgravada( localUtil.ctond( httpContext.cgiGet( edtavF1357_gnsi_f1357lrgravada_Internalname)) );
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_gnsi_anticiposdesac_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_gnsi_anticiposdesac_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357_GNSI_ANTICIPOSDESAC");
            GX_FocusControl = edtavF1357_gnsi_anticiposdesac_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7F1357_GNSI.setgxTv_SdtF1357_GNSI_Anticiposdesac( DecimalUtil.ZERO );
         }
         else
         {
            AV7F1357_GNSI.setgxTv_SdtF1357_GNSI_Anticiposdesac( localUtil.ctond( httpContext.cgiGet( edtavF1357_gnsi_anticiposdesac_Internalname)) );
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_gnsi_f1357ldgtotal_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_gnsi_f1357ldgtotal_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357_GNSI_F1357LDGTOTAL");
            GX_FocusControl = edtavF1357_gnsi_f1357ldgtotal_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7F1357_GNSI.setgxTv_SdtF1357_GNSI_F1357ldgtotal( DecimalUtil.ZERO );
         }
         else
         {
            AV7F1357_GNSI.setgxTv_SdtF1357_GNSI_F1357ldgtotal( localUtil.ctond( httpContext.cgiGet( edtavF1357_gnsi_f1357ldgtotal_Internalname)) );
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_gnsi_f1357ldptotalart30_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_gnsi_f1357ldptotalart30_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357_GNSI_F1357LDPTOTALART30");
            GX_FocusControl = edtavF1357_gnsi_f1357ldptotalart30_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7F1357_GNSI.setgxTv_SdtF1357_GNSI_F1357ldptotalart30( DecimalUtil.ZERO );
         }
         else
         {
            AV7F1357_GNSI.setgxTv_SdtF1357_GNSI_F1357ldptotalart30( localUtil.ctond( httpContext.cgiGet( edtavF1357_gnsi_f1357ldptotalart30_Internalname)) );
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_gnsi_descuentosdeley_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_gnsi_descuentosdeley_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357_GNSI_DESCUENTOSDELEY");
            GX_FocusControl = edtavF1357_gnsi_descuentosdeley_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7F1357_GNSI.setgxTv_SdtF1357_GNSI_Descuentosdeley( DecimalUtil.ZERO );
         }
         else
         {
            AV7F1357_GNSI.setgxTv_SdtF1357_GNSI_Descuentosdeley( localUtil.ctond( httpContext.cgiGet( edtavF1357_gnsi_descuentosdeley_Internalname)) );
         }
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         forbiddenHiddens = new com.genexus.util.GXProperties() ;
         forbiddenHiddens.add("hshsalt", "hsh"+"F1357_MostrarGNSI");
         AV7F1357_GNSI.setgxTv_SdtF1357_GNSI_F1357lrgravada( localUtil.ctond( httpContext.cgiGet( edtavF1357_gnsi_f1357lrgravada_Internalname)) );
         forbiddenHiddens.add("GXV1", localUtil.format( AV7F1357_GNSI.getgxTv_SdtF1357_GNSI_F1357lrgravada(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
         AV7F1357_GNSI.setgxTv_SdtF1357_GNSI_Anticiposdesac( localUtil.ctond( httpContext.cgiGet( edtavF1357_gnsi_anticiposdesac_Internalname)) );
         forbiddenHiddens.add("GXV2", localUtil.format( AV7F1357_GNSI.getgxTv_SdtF1357_GNSI_Anticiposdesac(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
         AV7F1357_GNSI.setgxTv_SdtF1357_GNSI_F1357ldgtotal( localUtil.ctond( httpContext.cgiGet( edtavF1357_gnsi_f1357ldgtotal_Internalname)) );
         forbiddenHiddens.add("GXV3", localUtil.format( AV7F1357_GNSI.getgxTv_SdtF1357_GNSI_F1357ldgtotal(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
         AV7F1357_GNSI.setgxTv_SdtF1357_GNSI_F1357ldptotalart30( localUtil.ctond( httpContext.cgiGet( edtavF1357_gnsi_f1357ldptotalart30_Internalname)) );
         forbiddenHiddens.add("GXV4", localUtil.format( AV7F1357_GNSI.getgxTv_SdtF1357_GNSI_F1357ldptotalart30(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
         AV7F1357_GNSI.setgxTv_SdtF1357_GNSI_Descuentosdeley( localUtil.ctond( httpContext.cgiGet( edtavF1357_gnsi_descuentosdeley_Internalname)) );
         forbiddenHiddens.add("GXV5", localUtil.format( AV7F1357_GNSI.getgxTv_SdtF1357_GNSI_Descuentosdeley(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
         hsh = httpContext.cgiGet( "hsh") ;
         if ( ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
         {
            GXutil.writeLogError("f1357_mostrargnsi:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
            GxWebError = (byte)(1) ;
            httpContext.sendError( 403 );
            GXutil.writeLog("send_http_error_code 403");
            return  ;
         }
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e119Q2 ();
      if (returnInSub) return;
   }

   public void e119Q2( )
   {
      /* Start Routine */
      returnInSub = false ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      AV25GXLvl11 = (byte)(0) ;
      /* Using cursor H009Q2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV15EmpCod), Byte.valueOf(AV16F1357CTipoPre), AV9F1357CPer, Byte.valueOf(AV10F1357CSec), Integer.valueOf(AV11LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = H009Q2_A6LegNumero[0] ;
         A778F1357CSec = H009Q2_A778F1357CSec[0] ;
         A777F1357CPer = H009Q2_A777F1357CPer[0] ;
         A784F1357CTipoPre = H009Q2_A784F1357CTipoPre[0] ;
         A1EmpCod = H009Q2_A1EmpCod[0] ;
         A3CliCod = H009Q2_A3CliCod[0] ;
         A797F1357LRTipReg = H009Q2_A797F1357LRTipReg[0] ;
         A800F1357LRGravada = H009Q2_A800F1357LRGravada[0] ;
         AV25GXLvl11 = (byte)(1) ;
         AV7F1357_GNSI.setgxTv_SdtF1357_GNSI_F1357lrgravada( A800F1357LRGravada );
         new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, httpContext.getMessage( "F1357LRGravada ", "")+GXutil.trim( GXutil.str( A800F1357LRGravada, 16, 2))) ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV25GXLvl11 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, httpContext.getMessage( "none", "")) ;
      }
      /* Using cursor H009Q3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV15EmpCod), Byte.valueOf(AV16F1357CTipoPre), AV9F1357CPer, Byte.valueOf(AV10F1357CSec), Integer.valueOf(AV11LegNumero)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A6LegNumero = H009Q3_A6LegNumero[0] ;
         A778F1357CSec = H009Q3_A778F1357CSec[0] ;
         A777F1357CPer = H009Q3_A777F1357CPer[0] ;
         A784F1357CTipoPre = H009Q3_A784F1357CTipoPre[0] ;
         A1EmpCod = H009Q3_A1EmpCod[0] ;
         A3CliCod = H009Q3_A3CliCod[0] ;
         A863F1357LDGTipReg = H009Q3_A863F1357LDGTipReg[0] ;
         A820F1357LDGTotal = H009Q3_A820F1357LDGTotal[0] ;
         AV7F1357_GNSI.setgxTv_SdtF1357_GNSI_F1357ldgtotal( A820F1357LDGTotal );
         pr_default.readNext(1);
      }
      pr_default.close(1);
      /* Using cursor H009Q4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV15EmpCod), Byte.valueOf(AV16F1357CTipoPre), AV9F1357CPer, Byte.valueOf(AV10F1357CSec), Integer.valueOf(AV11LegNumero)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A6LegNumero = H009Q4_A6LegNumero[0] ;
         A778F1357CSec = H009Q4_A778F1357CSec[0] ;
         A777F1357CPer = H009Q4_A777F1357CPer[0] ;
         A784F1357CTipoPre = H009Q4_A784F1357CTipoPre[0] ;
         A1EmpCod = H009Q4_A1EmpCod[0] ;
         A3CliCod = H009Q4_A3CliCod[0] ;
         A862F1357LDPTipReg = H009Q4_A862F1357LDPTipReg[0] ;
         A834F1357LDPTotalArt30 = H009Q4_A834F1357LDPTotalArt30[0] ;
         AV7F1357_GNSI.setgxTv_SdtF1357_GNSI_F1357ldptotalart30( A834F1357LDPTotalArt30 );
         pr_default.readNext(2);
      }
      pr_default.close(2);
      /* Using cursor H009Q5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV15EmpCod), Byte.valueOf(AV16F1357CTipoPre), AV9F1357CPer, Byte.valueOf(AV10F1357CSec), Integer.valueOf(AV11LegNumero)});
      while ( (pr_default.getStatus(3) != 101) )
      {
         A6LegNumero = H009Q5_A6LegNumero[0] ;
         A778F1357CSec = H009Q5_A778F1357CSec[0] ;
         A777F1357CPer = H009Q5_A777F1357CPer[0] ;
         A784F1357CTipoPre = H009Q5_A784F1357CTipoPre[0] ;
         A1EmpCod = H009Q5_A1EmpCod[0] ;
         A3CliCod = H009Q5_A3CliCod[0] ;
         A861F1357LCTipReg = H009Q5_A861F1357LCTipReg[0] ;
         A1082F1357LC_AnticiposDeSac = H009Q5_A1082F1357LC_AnticiposDeSac[0] ;
         A927F1357LC_DescuSobreGrav = H009Q5_A927F1357LC_DescuSobreGrav[0] ;
         AV7F1357_GNSI.setgxTv_SdtF1357_GNSI_Anticiposdesac( A1082F1357LC_AnticiposDeSac );
         AV7F1357_GNSI.setgxTv_SdtF1357_GNSI_Descuentosdeley( A927F1357LC_DescuSobreGrav );
         pr_default.readNext(3);
      }
      pr_default.close(3);
   }

   protected void nextLoad( )
   {
   }

   protected void e129Q2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV8CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliCod), 6, 0));
      AV15EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15EmpCod), 4, 0));
      AV16F1357CTipoPre = ((Number) GXutil.testNumericType( getParm(obj,2), TypeConstants.BYTE)).byteValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16F1357CTipoPre", GXutil.str( AV16F1357CTipoPre, 1, 0));
      AV9F1357CPer = (String)getParm(obj,3) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9F1357CPer", AV9F1357CPer);
      AV10F1357CSec = ((Number) GXutil.testNumericType( getParm(obj,4), TypeConstants.BYTE)).byteValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10F1357CSec), 2, 0));
      AV11LegNumero = ((Number) GXutil.testNumericType( getParm(obj,5), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11LegNumero), 8, 0));
   }

   public String getresponse( String sGXDynURL )
   {
      initialize_properties( ) ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      sDynURL = sGXDynURL ;
      nGotPars = 1 ;
      nGXWrapped = 1 ;
      httpContext.setWrapped(true);
      pa9Q2( ) ;
      ws9Q2( ) ;
      we9Q2( ) ;
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
      httpContext.setWrapped(false);
      httpContext.GX_msglist = BackMsgLst ;
      String response = "";
      try
      {
         response = ((java.io.ByteArrayOutputStream) httpContext.getOutputStream()).toString("UTF8");
      }
      catch (java.io.UnsupportedEncodingException e)
      {
         Application.printWarning(e.getMessage(), e);
      }
      finally
      {
         httpContext.closeOutputStream();
      }
      return response;
   }

   public void responsestatic( String sGXDynURL )
   {
   }

   public void define_styles( )
   {
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412202054718", true, true);
         idxLst = (int)(idxLst+1) ;
      }
      if ( ! outputEnabled )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
      }
      /* End function define_styles */
   }

   public void include_jscripts( )
   {
      if ( nGXWrapped != 1 )
      {
         httpContext.AddJavascriptSource("messages."+httpContext.getLanguageProperty( "code")+".js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
         httpContext.AddJavascriptSource("gxdec.js", "?"+httpContext.getBuildNumber( 214800), false, true);
         httpContext.AddJavascriptSource("f1357_mostrargnsi.js", "?202412202054718", false, true);
      }
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtavF1357_gnsi_f1357lrgravada_Internalname = "F1357_GNSI_F1357LRGRAVADA" ;
      edtavF1357_gnsi_anticiposdesac_Internalname = "F1357_GNSI_ANTICIPOSDESAC" ;
      edtavF1357_gnsi_f1357ldgtotal_Internalname = "F1357_GNSI_F1357LDGTOTAL" ;
      edtavF1357_gnsi_f1357ldptotalart30_Internalname = "F1357_GNSI_F1357LDPTOTALART30" ;
      edtavF1357_gnsi_descuentosdeley_Internalname = "F1357_GNSI_DESCUENTOSDELEY" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_default_properties( ) ;
      edtavF1357_gnsi_descuentosdeley_Enabled = -1 ;
      edtavF1357_gnsi_f1357ldptotalart30_Enabled = -1 ;
      edtavF1357_gnsi_f1357ldgtotal_Enabled = -1 ;
      edtavF1357_gnsi_anticiposdesac_Enabled = -1 ;
      edtavF1357_gnsi_f1357lrgravada_Enabled = -1 ;
      edtavF1357_gnsi_descuentosdeley_Jsonclick = "" ;
      edtavF1357_gnsi_descuentosdeley_Enabled = 0 ;
      edtavF1357_gnsi_f1357ldptotalart30_Jsonclick = "" ;
      edtavF1357_gnsi_f1357ldptotalart30_Enabled = 0 ;
      edtavF1357_gnsi_f1357ldgtotal_Jsonclick = "" ;
      edtavF1357_gnsi_f1357ldgtotal_Enabled = 0 ;
      edtavF1357_gnsi_anticiposdesac_Jsonclick = "" ;
      edtavF1357_gnsi_anticiposdesac_Enabled = 0 ;
      edtavF1357_gnsi_f1357lrgravada_Jsonclick = "" ;
      edtavF1357_gnsi_f1357lrgravada_Enabled = 0 ;
      divLayoutmaintable_Class = "Table TableTransactionTemplate" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Composición de GNSI", "") );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GXV1',fld:'F1357_GNSI_F1357LRGRAVADA',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'GXV2',fld:'F1357_GNSI_ANTICIPOSDESAC',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'GXV3',fld:'F1357_GNSI_F1357LDGTOTAL',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'GXV4',fld:'F1357_GNSI_F1357LDPTOTALART30',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'GXV5',fld:'F1357_GNSI_DESCUENTOSDELEY',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

   protected void cleanup( )
   {
      super.cleanup();
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      wcpOAV9F1357CPer = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV9F1357CPer = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      AV7F1357_GNSI = new web.SdtF1357_GNSI(remoteHandle, context);
      GX_FocusControl = "" ;
      sPrefix = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV26Pgmname = "" ;
      hsh = "" ;
      scmdbuf = "" ;
      H009Q2_A6LegNumero = new int[1] ;
      H009Q2_A778F1357CSec = new byte[1] ;
      H009Q2_A777F1357CPer = new String[] {""} ;
      H009Q2_A784F1357CTipoPre = new byte[1] ;
      H009Q2_A1EmpCod = new short[1] ;
      H009Q2_A3CliCod = new int[1] ;
      H009Q2_A797F1357LRTipReg = new String[] {""} ;
      H009Q2_A800F1357LRGravada = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A777F1357CPer = "" ;
      A797F1357LRTipReg = "" ;
      A800F1357LRGravada = DecimalUtil.ZERO ;
      H009Q3_A6LegNumero = new int[1] ;
      H009Q3_A778F1357CSec = new byte[1] ;
      H009Q3_A777F1357CPer = new String[] {""} ;
      H009Q3_A784F1357CTipoPre = new byte[1] ;
      H009Q3_A1EmpCod = new short[1] ;
      H009Q3_A3CliCod = new int[1] ;
      H009Q3_A863F1357LDGTipReg = new String[] {""} ;
      H009Q3_A820F1357LDGTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A863F1357LDGTipReg = "" ;
      A820F1357LDGTotal = DecimalUtil.ZERO ;
      H009Q4_A6LegNumero = new int[1] ;
      H009Q4_A778F1357CSec = new byte[1] ;
      H009Q4_A777F1357CPer = new String[] {""} ;
      H009Q4_A784F1357CTipoPre = new byte[1] ;
      H009Q4_A1EmpCod = new short[1] ;
      H009Q4_A3CliCod = new int[1] ;
      H009Q4_A862F1357LDPTipReg = new String[] {""} ;
      H009Q4_A834F1357LDPTotalArt30 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A862F1357LDPTipReg = "" ;
      A834F1357LDPTotalArt30 = DecimalUtil.ZERO ;
      H009Q5_A6LegNumero = new int[1] ;
      H009Q5_A778F1357CSec = new byte[1] ;
      H009Q5_A777F1357CPer = new String[] {""} ;
      H009Q5_A784F1357CTipoPre = new byte[1] ;
      H009Q5_A1EmpCod = new short[1] ;
      H009Q5_A3CliCod = new int[1] ;
      H009Q5_A861F1357LCTipReg = new String[] {""} ;
      H009Q5_A1082F1357LC_AnticiposDeSac = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009Q5_A927F1357LC_DescuSobreGrav = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A861F1357LCTipReg = "" ;
      A1082F1357LC_AnticiposDeSac = DecimalUtil.ZERO ;
      A927F1357LC_DescuSobreGrav = DecimalUtil.ZERO ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.f1357_mostrargnsi__default(),
         new Object[] {
             new Object[] {
            H009Q2_A6LegNumero, H009Q2_A778F1357CSec, H009Q2_A777F1357CPer, H009Q2_A784F1357CTipoPre, H009Q2_A1EmpCod, H009Q2_A3CliCod, H009Q2_A797F1357LRTipReg, H009Q2_A800F1357LRGravada
            }
            , new Object[] {
            H009Q3_A6LegNumero, H009Q3_A778F1357CSec, H009Q3_A777F1357CPer, H009Q3_A784F1357CTipoPre, H009Q3_A1EmpCod, H009Q3_A3CliCod, H009Q3_A863F1357LDGTipReg, H009Q3_A820F1357LDGTotal
            }
            , new Object[] {
            H009Q4_A6LegNumero, H009Q4_A778F1357CSec, H009Q4_A777F1357CPer, H009Q4_A784F1357CTipoPre, H009Q4_A1EmpCod, H009Q4_A3CliCod, H009Q4_A862F1357LDPTipReg, H009Q4_A834F1357LDPTotalArt30
            }
            , new Object[] {
            H009Q5_A6LegNumero, H009Q5_A778F1357CSec, H009Q5_A777F1357CPer, H009Q5_A784F1357CTipoPre, H009Q5_A1EmpCod, H009Q5_A3CliCod, H009Q5_A861F1357LCTipReg, H009Q5_A1082F1357LC_AnticiposDeSac, H009Q5_A927F1357LC_DescuSobreGrav
            }
         }
      );
      AV26Pgmname = "F1357_MostrarGNSI" ;
      /* GeneXus formulas. */
      AV26Pgmname = "F1357_MostrarGNSI" ;
      Gx_err = (short)(0) ;
      edtavF1357_gnsi_f1357lrgravada_Enabled = 0 ;
      edtavF1357_gnsi_anticiposdesac_Enabled = 0 ;
      edtavF1357_gnsi_f1357ldgtotal_Enabled = 0 ;
      edtavF1357_gnsi_f1357ldptotalart30_Enabled = 0 ;
      edtavF1357_gnsi_descuentosdeley_Enabled = 0 ;
   }

   private byte wcpOAV16F1357CTipoPre ;
   private byte wcpOAV10F1357CSec ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV16F1357CTipoPre ;
   private byte AV10F1357CSec ;
   private byte gxajaxcallmode ;
   private byte nGXWrapped ;
   private byte nDonePA ;
   private byte AV25GXLvl11 ;
   private byte A778F1357CSec ;
   private byte A784F1357CTipoPre ;
   private short wcpOAV15EmpCod ;
   private short nRcdExists_6 ;
   private short nIsMod_6 ;
   private short nRcdExists_5 ;
   private short nIsMod_5 ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short AV15EmpCod ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short A1EmpCod ;
   private int wcpOAV8CliCod ;
   private int wcpOAV11LegNumero ;
   private int AV8CliCod ;
   private int AV11LegNumero ;
   private int edtavF1357_gnsi_f1357lrgravada_Enabled ;
   private int edtavF1357_gnsi_anticiposdesac_Enabled ;
   private int edtavF1357_gnsi_f1357ldgtotal_Enabled ;
   private int edtavF1357_gnsi_f1357ldptotalart30_Enabled ;
   private int edtavF1357_gnsi_descuentosdeley_Enabled ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int idxLst ;
   private java.math.BigDecimal A800F1357LRGravada ;
   private java.math.BigDecimal A820F1357LDGTotal ;
   private java.math.BigDecimal A834F1357LDPTotalArt30 ;
   private java.math.BigDecimal A1082F1357LC_AnticiposDeSac ;
   private java.math.BigDecimal A927F1357LC_DescuSobreGrav ;
   private String wcpOAV9F1357CPer ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV9F1357CPer ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String divTableattributes_Internalname ;
   private String edtavF1357_gnsi_f1357lrgravada_Internalname ;
   private String edtavF1357_gnsi_f1357lrgravada_Jsonclick ;
   private String edtavF1357_gnsi_anticiposdesac_Internalname ;
   private String edtavF1357_gnsi_anticiposdesac_Jsonclick ;
   private String edtavF1357_gnsi_f1357ldgtotal_Internalname ;
   private String edtavF1357_gnsi_f1357ldgtotal_Jsonclick ;
   private String edtavF1357_gnsi_f1357ldptotalart30_Internalname ;
   private String edtavF1357_gnsi_f1357ldptotalart30_Jsonclick ;
   private String edtavF1357_gnsi_descuentosdeley_Internalname ;
   private String edtavF1357_gnsi_descuentosdeley_Jsonclick ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV26Pgmname ;
   private String hsh ;
   private String scmdbuf ;
   private String A777F1357CPer ;
   private String A797F1357LRTipReg ;
   private String A863F1357LDGTipReg ;
   private String A862F1357LDPTipReg ;
   private String A861F1357LCTipReg ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private web.SdtF1357_GNSI AV7F1357_GNSI ;
   private IDataStoreProvider pr_default ;
   private int[] H009Q2_A6LegNumero ;
   private byte[] H009Q2_A778F1357CSec ;
   private String[] H009Q2_A777F1357CPer ;
   private byte[] H009Q2_A784F1357CTipoPre ;
   private short[] H009Q2_A1EmpCod ;
   private int[] H009Q2_A3CliCod ;
   private String[] H009Q2_A797F1357LRTipReg ;
   private java.math.BigDecimal[] H009Q2_A800F1357LRGravada ;
   private int[] H009Q3_A6LegNumero ;
   private byte[] H009Q3_A778F1357CSec ;
   private String[] H009Q3_A777F1357CPer ;
   private byte[] H009Q3_A784F1357CTipoPre ;
   private short[] H009Q3_A1EmpCod ;
   private int[] H009Q3_A3CliCod ;
   private String[] H009Q3_A863F1357LDGTipReg ;
   private java.math.BigDecimal[] H009Q3_A820F1357LDGTotal ;
   private int[] H009Q4_A6LegNumero ;
   private byte[] H009Q4_A778F1357CSec ;
   private String[] H009Q4_A777F1357CPer ;
   private byte[] H009Q4_A784F1357CTipoPre ;
   private short[] H009Q4_A1EmpCod ;
   private int[] H009Q4_A3CliCod ;
   private String[] H009Q4_A862F1357LDPTipReg ;
   private java.math.BigDecimal[] H009Q4_A834F1357LDPTotalArt30 ;
   private int[] H009Q5_A6LegNumero ;
   private byte[] H009Q5_A778F1357CSec ;
   private String[] H009Q5_A777F1357CPer ;
   private byte[] H009Q5_A784F1357CTipoPre ;
   private short[] H009Q5_A1EmpCod ;
   private int[] H009Q5_A3CliCod ;
   private String[] H009Q5_A861F1357LCTipReg ;
   private java.math.BigDecimal[] H009Q5_A1082F1357LC_AnticiposDeSac ;
   private java.math.BigDecimal[] H009Q5_A927F1357LC_DescuSobreGrav ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class f1357_mostrargnsi__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H009Q2", "SELECT LegNumero, F1357CSec, F1357CPer, F1357CTipoPre, EmpCod, CliCod, F1357LRTipReg, F1357LRGravada FROM F1357LegRemun WHERE CliCod = ? and EmpCod = ? and F1357CTipoPre = ? and F1357CPer = ( ?) and F1357CSec = ? and LegNumero = ? ORDER BY CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H009Q3", "SELECT LegNumero, F1357CSec, F1357CPer, F1357CTipoPre, EmpCod, CliCod, F1357LDGTipReg, F1357LDGTotal FROM F1357LegDedGen WHERE CliCod = ? and EmpCod = ? and F1357CTipoPre = ? and F1357CPer = ( ?) and F1357CSec = ? and LegNumero = ? ORDER BY CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H009Q4", "SELECT LegNumero, F1357CSec, F1357CPer, F1357CTipoPre, EmpCod, CliCod, F1357LDPTipReg, F1357LDPTotalArt30 FROM F1357LDedPer WHERE CliCod = ? and EmpCod = ? and F1357CTipoPre = ? and F1357CPer = ( ?) and F1357CSec = ? and LegNumero = ? ORDER BY CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H009Q5", "SELECT LegNumero, F1357CSec, F1357CPer, F1357CTipoPre, EmpCod, CliCod, F1357LCTipReg, F1357LC_AnticiposDeSac, F1357LC_DescuSobreGrav FROM F1357LCalculo WHERE CliCod = ? and EmpCod = ? and F1357CTipoPre = ? and F1357CPer = ( ?) and F1357CSec = ? and LegNumero = ? ORDER BY CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 6);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 2);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 6);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 2);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 6);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 2);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 6);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 2);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,2);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 6);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 6);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 6);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 6);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               return;
      }
   }

}

