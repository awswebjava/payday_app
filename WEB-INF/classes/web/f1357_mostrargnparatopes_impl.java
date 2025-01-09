package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class f1357_mostrargnparatopes_impl extends GXDataArea
{
   public f1357_mostrargnparatopes_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public f1357_mostrargnparatopes_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( f1357_mostrargnparatopes_impl.class ));
   }

   public f1357_mostrargnparatopes_impl( int remoteHandle ,
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
            AV11CliCod = (int)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11CliCod), 6, 0));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV12EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV12EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12EmpCod), 4, 0));
               AV15F1357CTipoPre = (byte)(GXutil.lval( httpContext.GetPar( "F1357CTipoPre"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV15F1357CTipoPre", GXutil.str( AV15F1357CTipoPre, 1, 0));
               AV8F1357CPer = httpContext.GetPar( "F1357CPer") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV8F1357CPer", AV8F1357CPer);
               AV13F1357CSec = (byte)(GXutil.lval( httpContext.GetPar( "F1357CSec"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV13F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13F1357CSec), 2, 0));
               AV14LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV14LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14LegNumero), 8, 0));
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
      pa9R2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start9R2( ) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.f1357_mostrargnparatopes", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV11CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV12EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV15F1357CTipoPre,1,0)),GXutil.URLEncode(GXutil.rtrim(AV8F1357CPer)),GXutil.URLEncode(GXutil.ltrimstr(AV13F1357CSec,2,0)),GXutil.URLEncode(GXutil.ltrimstr(AV14LegNumero,8,0))}, new String[] {"CliCod","EmpCod","F1357CTipoPre","F1357CPer","F1357CSec","LegNumero"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"F1357_MostrarGNParaTopes");
      forbiddenHiddens.add("GXV1", localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357lrgravada(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("GXV2", localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_Descuentosdeley(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("GXV3", localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgseguro(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("GXV4", localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsegumixto(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("GXV5", localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgretpriv(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("GXV6", localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgcuotapartes(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("GXV7", localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsepelio(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("GXV8", localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgrodado(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("GXV9", localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgoblig(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("GXV10", localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldghipoteca(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("GXV11", localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsgr(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("GXV12", localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgdomes(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("GXV13", localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgalquiler(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("GXV14", localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgviaticos(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("GXV15", localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgindu(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("GXV16", localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgotras(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("f1357_mostrargnparatopes:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "F1357_ganancianetaparatopes", AV7F1357_GananciaNetaParaTopes);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("F1357_ganancianetaparatopes", AV7F1357_GananciaNetaParaTopes);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV11CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV12EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vF1357CTIPOPRE", GXutil.ltrim( localUtil.ntoc( AV15F1357CTipoPre, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vF1357CPER", GXutil.rtrim( AV8F1357CPer));
      web.GxWebStd.gx_hidden_field( httpContext, "vF1357CSEC", GXutil.ltrim( localUtil.ntoc( AV13F1357CSec, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLEGNUMERO", GXutil.ltrim( localUtil.ntoc( AV14LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vF1357_GANANCIANETAPARATOPES", AV7F1357_GananciaNetaParaTopes);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vF1357_GANANCIANETAPARATOPES", AV7F1357_GananciaNetaParaTopes);
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
         we9R2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt9R2( ) ;
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
      return formatLink("web.f1357_mostrargnparatopes", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV11CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV12EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV15F1357CTipoPre,1,0)),GXutil.URLEncode(GXutil.rtrim(AV8F1357CPer)),GXutil.URLEncode(GXutil.ltrimstr(AV13F1357CSec,2,0)),GXutil.URLEncode(GXutil.ltrimstr(AV14LegNumero,8,0))}, new String[] {"CliCod","EmpCod","F1357CTipoPre","F1357CPer","F1357CSec","LegNumero"})  ;
   }

   public String getPgmname( )
   {
      return "F1357_MostrarGNParaTopes" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Composición de ganancia neta para topes", "") ;
   }

   public void wb9R0( )
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavF1357_ganancianetaparatopes_f1357lrgravada_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavF1357_ganancianetaparatopes_f1357lrgravada_Internalname, httpContext.getMessage( "+ REMUNERACIÓN GRAVADA ", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtavF1357_ganancianetaparatopes_f1357lrgravada_Internalname, GXutil.ltrim( localUtil.ntoc( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357lrgravada(), (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavF1357_ganancianetaparatopes_f1357lrgravada_Enabled!=0) ? localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357lrgravada(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357lrgravada(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavF1357_ganancianetaparatopes_f1357lrgravada_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavF1357_ganancianetaparatopes_f1357lrgravada_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_F1357_MostrarGNParaTopes.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavF1357_ganancianetaparatopes_descuentosdeley_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavF1357_ganancianetaparatopes_descuentosdeley_Internalname, httpContext.getMessage( "- Descuentos De Ley", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtavF1357_ganancianetaparatopes_descuentosdeley_Internalname, GXutil.ltrim( localUtil.ntoc( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_Descuentosdeley(), (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavF1357_ganancianetaparatopes_descuentosdeley_Enabled!=0) ? localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_Descuentosdeley(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_Descuentosdeley(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavF1357_ganancianetaparatopes_descuentosdeley_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavF1357_ganancianetaparatopes_descuentosdeley_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_F1357_MostrarGNParaTopes.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavF1357_ganancianetaparatopes_f1357ldgseguro_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavF1357_ganancianetaparatopes_f1357ldgseguro_Internalname, httpContext.getMessage( "- PRIMAS DE SEGURO PARA EL CASO DE MUERTE", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtavF1357_ganancianetaparatopes_f1357ldgseguro_Internalname, GXutil.ltrim( localUtil.ntoc( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgseguro(), (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavF1357_ganancianetaparatopes_f1357ldgseguro_Enabled!=0) ? localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgseguro(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgseguro(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavF1357_ganancianetaparatopes_f1357ldgseguro_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavF1357_ganancianetaparatopes_f1357ldgseguro_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_F1357_MostrarGNParaTopes.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavF1357_ganancianetaparatopes_f1357ldgsegumixto_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavF1357_ganancianetaparatopes_f1357ldgsegumixto_Internalname, httpContext.getMessage( "- SEGUROS MUERTE/MIXTOS SUJETAS AL CONTROL DE LA SSN", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtavF1357_ganancianetaparatopes_f1357ldgsegumixto_Internalname, GXutil.ltrim( localUtil.ntoc( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsegumixto(), (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavF1357_ganancianetaparatopes_f1357ldgsegumixto_Enabled!=0) ? localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsegumixto(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsegumixto(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavF1357_ganancianetaparatopes_f1357ldgsegumixto_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavF1357_ganancianetaparatopes_f1357ldgsegumixto_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_F1357_MostrarGNParaTopes.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavF1357_ganancianetaparatopes_f1357ldgretpriv_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavF1357_ganancianetaparatopes_f1357ldgretpriv_Internalname, httpContext.getMessage( "- SEGURO DE RETIRO PRIVADOS -SUJETAS AL CONTROL DE LA SSN", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtavF1357_ganancianetaparatopes_f1357ldgretpriv_Internalname, GXutil.ltrim( localUtil.ntoc( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgretpriv(), (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavF1357_ganancianetaparatopes_f1357ldgretpriv_Enabled!=0) ? localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgretpriv(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgretpriv(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavF1357_ganancianetaparatopes_f1357ldgretpriv_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavF1357_ganancianetaparatopes_f1357ldgretpriv_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_F1357_MostrarGNParaTopes.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavF1357_ganancianetaparatopes_f1357ldgcuotapartes_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavF1357_ganancianetaparatopes_f1357ldgcuotapartes_Internalname, httpContext.getMessage( "- ADQUISICIÓN DE CUOTAPARTES DE FCI CON FINES DE RETIRO", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtavF1357_ganancianetaparatopes_f1357ldgcuotapartes_Internalname, GXutil.ltrim( localUtil.ntoc( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgcuotapartes(), (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavF1357_ganancianetaparatopes_f1357ldgcuotapartes_Enabled!=0) ? localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgcuotapartes(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgcuotapartes(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavF1357_ganancianetaparatopes_f1357ldgcuotapartes_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavF1357_ganancianetaparatopes_f1357ldgcuotapartes_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_F1357_MostrarGNParaTopes.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavF1357_ganancianetaparatopes_f1357ldgsepelio_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavF1357_ganancianetaparatopes_f1357ldgsepelio_Internalname, httpContext.getMessage( "- GASTOS DE SEPELIO", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtavF1357_ganancianetaparatopes_f1357ldgsepelio_Internalname, GXutil.ltrim( localUtil.ntoc( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsepelio(), (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavF1357_ganancianetaparatopes_f1357ldgsepelio_Enabled!=0) ? localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsepelio(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsepelio(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavF1357_ganancianetaparatopes_f1357ldgsepelio_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavF1357_ganancianetaparatopes_f1357ldgsepelio_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_F1357_MostrarGNParaTopes.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavF1357_ganancianetaparatopes_f1357ldgrodado_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavF1357_ganancianetaparatopes_f1357ldgrodado_Internalname, httpContext.getMessage( "- GTOS AMORT E INT RODADO CORREDORES Y VIAJANTES DE COMERCIO", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtavF1357_ganancianetaparatopes_f1357ldgrodado_Internalname, GXutil.ltrim( localUtil.ntoc( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgrodado(), (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavF1357_ganancianetaparatopes_f1357ldgrodado_Enabled!=0) ? localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgrodado(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgrodado(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavF1357_ganancianetaparatopes_f1357ldgrodado_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavF1357_ganancianetaparatopes_f1357ldgrodado_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_F1357_MostrarGNParaTopes.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavF1357_ganancianetaparatopes_f1357ldgoblig_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavF1357_ganancianetaparatopes_f1357ldgoblig_Internalname, httpContext.getMessage( "- DTOS OBLIG POR LEY NACIONAL, PROVINCIAL O MUNICIPAL", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtavF1357_ganancianetaparatopes_f1357ldgoblig_Internalname, GXutil.ltrim( localUtil.ntoc( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgoblig(), (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavF1357_ganancianetaparatopes_f1357ldgoblig_Enabled!=0) ? localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgoblig(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgoblig(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavF1357_ganancianetaparatopes_f1357ldgoblig_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavF1357_ganancianetaparatopes_f1357ldgoblig_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_F1357_MostrarGNParaTopes.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavF1357_ganancianetaparatopes_f1357ldghipoteca_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavF1357_ganancianetaparatopes_f1357ldghipoteca_Internalname, httpContext.getMessage( "- INTERESES CRÉDITOS HIPOTECARIOS", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtavF1357_ganancianetaparatopes_f1357ldghipoteca_Internalname, GXutil.ltrim( localUtil.ntoc( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldghipoteca(), (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavF1357_ganancianetaparatopes_f1357ldghipoteca_Enabled!=0) ? localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldghipoteca(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldghipoteca(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavF1357_ganancianetaparatopes_f1357ldghipoteca_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavF1357_ganancianetaparatopes_f1357ldghipoteca_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_F1357_MostrarGNParaTopes.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavF1357_ganancianetaparatopes_f1357ldgsgr_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavF1357_ganancianetaparatopes_f1357ldgsgr_Internalname, httpContext.getMessage( "- AP. CAP. SOC. /FONDO DE RIESGO DE SOCIOS PROTECTORES DE SGR", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtavF1357_ganancianetaparatopes_f1357ldgsgr_Internalname, GXutil.ltrim( localUtil.ntoc( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsgr(), (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavF1357_ganancianetaparatopes_f1357ldgsgr_Enabled!=0) ? localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsgr(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsgr(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavF1357_ganancianetaparatopes_f1357ldgsgr_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavF1357_ganancianetaparatopes_f1357ldgsgr_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_F1357_MostrarGNParaTopes.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavF1357_ganancianetaparatopes_f1357ldgdomes_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavF1357_ganancianetaparatopes_f1357ldgdomes_Internalname, httpContext.getMessage( "- EMPLEADOS DEL SERVICIO DOMESTICO", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtavF1357_ganancianetaparatopes_f1357ldgdomes_Internalname, GXutil.ltrim( localUtil.ntoc( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgdomes(), (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavF1357_ganancianetaparatopes_f1357ldgdomes_Enabled!=0) ? localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgdomes(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgdomes(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavF1357_ganancianetaparatopes_f1357ldgdomes_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavF1357_ganancianetaparatopes_f1357ldgdomes_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_F1357_MostrarGNParaTopes.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavF1357_ganancianetaparatopes_f1357ldgalquiler_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavF1357_ganancianetaparatopes_f1357ldgalquiler_Internalname, httpContext.getMessage( "- ALQUILERES DE INMUEBLES DESTINADOS A SU CASA HABITACIÓN", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtavF1357_ganancianetaparatopes_f1357ldgalquiler_Internalname, GXutil.ltrim( localUtil.ntoc( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgalquiler(), (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavF1357_ganancianetaparatopes_f1357ldgalquiler_Enabled!=0) ? localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgalquiler(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgalquiler(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavF1357_ganancianetaparatopes_f1357ldgalquiler_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavF1357_ganancianetaparatopes_f1357ldgalquiler_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_F1357_MostrarGNParaTopes.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavF1357_ganancianetaparatopes_f1357ldgviaticos_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavF1357_ganancianetaparatopes_f1357ldgviaticos_Internalname, httpContext.getMessage( "- GTOS MOV./VIÁTICOS ABONADOS POR EL EMPLEADOR", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtavF1357_ganancianetaparatopes_f1357ldgviaticos_Internalname, GXutil.ltrim( localUtil.ntoc( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgviaticos(), (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavF1357_ganancianetaparatopes_f1357ldgviaticos_Enabled!=0) ? localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgviaticos(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgviaticos(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavF1357_ganancianetaparatopes_f1357ldgviaticos_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavF1357_ganancianetaparatopes_f1357ldgviaticos_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_F1357_MostrarGNParaTopes.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavF1357_ganancianetaparatopes_f1357ldgindu_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavF1357_ganancianetaparatopes_f1357ldgindu_Internalname, httpContext.getMessage( "- INDUMENTARIA/EQUIPAMIENTO-USO EXLUSIVO-CARÁCTER OBLIGATORIO", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtavF1357_ganancianetaparatopes_f1357ldgindu_Internalname, GXutil.ltrim( localUtil.ntoc( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgindu(), (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavF1357_ganancianetaparatopes_f1357ldgindu_Enabled!=0) ? localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgindu(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgindu(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavF1357_ganancianetaparatopes_f1357ldgindu_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavF1357_ganancianetaparatopes_f1357ldgindu_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_F1357_MostrarGNParaTopes.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavF1357_ganancianetaparatopes_f1357ldgotras_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavF1357_ganancianetaparatopes_f1357ldgotras_Internalname, httpContext.getMessage( "- OTRAS DEDUCCIONES", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtavF1357_ganancianetaparatopes_f1357ldgotras_Internalname, GXutil.ltrim( localUtil.ntoc( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgotras(), (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavF1357_ganancianetaparatopes_f1357ldgotras_Enabled!=0) ? localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgotras(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgotras(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavF1357_ganancianetaparatopes_f1357ldgotras_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavF1357_ganancianetaparatopes_f1357ldgotras_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_F1357_MostrarGNParaTopes.htm");
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

   public void start9R2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Composición de ganancia neta para topes", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup9R0( ) ;
   }

   public void ws9R2( )
   {
      start9R2( ) ;
      evt9R2( ) ;
   }

   public void evt9R2( )
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
                           e119R2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e129R2 ();
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

   public void we9R2( )
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

   public void pa9R2( )
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
            GX_FocusControl = edtavF1357_ganancianetaparatopes_f1357lrgravada_Internalname ;
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
      rf9R2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavF1357_ganancianetaparatopes_f1357lrgravada_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_ganancianetaparatopes_f1357lrgravada_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_ganancianetaparatopes_f1357lrgravada_Enabled), 5, 0), true);
      edtavF1357_ganancianetaparatopes_descuentosdeley_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_ganancianetaparatopes_descuentosdeley_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_ganancianetaparatopes_descuentosdeley_Enabled), 5, 0), true);
      edtavF1357_ganancianetaparatopes_f1357ldgseguro_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_ganancianetaparatopes_f1357ldgseguro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_ganancianetaparatopes_f1357ldgseguro_Enabled), 5, 0), true);
      edtavF1357_ganancianetaparatopes_f1357ldgsegumixto_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_ganancianetaparatopes_f1357ldgsegumixto_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_ganancianetaparatopes_f1357ldgsegumixto_Enabled), 5, 0), true);
      edtavF1357_ganancianetaparatopes_f1357ldgretpriv_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_ganancianetaparatopes_f1357ldgretpriv_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_ganancianetaparatopes_f1357ldgretpriv_Enabled), 5, 0), true);
      edtavF1357_ganancianetaparatopes_f1357ldgcuotapartes_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_ganancianetaparatopes_f1357ldgcuotapartes_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_ganancianetaparatopes_f1357ldgcuotapartes_Enabled), 5, 0), true);
      edtavF1357_ganancianetaparatopes_f1357ldgsepelio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_ganancianetaparatopes_f1357ldgsepelio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_ganancianetaparatopes_f1357ldgsepelio_Enabled), 5, 0), true);
      edtavF1357_ganancianetaparatopes_f1357ldgrodado_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_ganancianetaparatopes_f1357ldgrodado_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_ganancianetaparatopes_f1357ldgrodado_Enabled), 5, 0), true);
      edtavF1357_ganancianetaparatopes_f1357ldgoblig_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_ganancianetaparatopes_f1357ldgoblig_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_ganancianetaparatopes_f1357ldgoblig_Enabled), 5, 0), true);
      edtavF1357_ganancianetaparatopes_f1357ldghipoteca_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_ganancianetaparatopes_f1357ldghipoteca_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_ganancianetaparatopes_f1357ldghipoteca_Enabled), 5, 0), true);
      edtavF1357_ganancianetaparatopes_f1357ldgsgr_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_ganancianetaparatopes_f1357ldgsgr_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_ganancianetaparatopes_f1357ldgsgr_Enabled), 5, 0), true);
      edtavF1357_ganancianetaparatopes_f1357ldgdomes_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_ganancianetaparatopes_f1357ldgdomes_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_ganancianetaparatopes_f1357ldgdomes_Enabled), 5, 0), true);
      edtavF1357_ganancianetaparatopes_f1357ldgalquiler_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_ganancianetaparatopes_f1357ldgalquiler_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_ganancianetaparatopes_f1357ldgalquiler_Enabled), 5, 0), true);
      edtavF1357_ganancianetaparatopes_f1357ldgviaticos_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_ganancianetaparatopes_f1357ldgviaticos_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_ganancianetaparatopes_f1357ldgviaticos_Enabled), 5, 0), true);
      edtavF1357_ganancianetaparatopes_f1357ldgindu_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_ganancianetaparatopes_f1357ldgindu_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_ganancianetaparatopes_f1357ldgindu_Enabled), 5, 0), true);
      edtavF1357_ganancianetaparatopes_f1357ldgotras_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_ganancianetaparatopes_f1357ldgotras_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_ganancianetaparatopes_f1357ldgotras_Enabled), 5, 0), true);
   }

   public void rf9R2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e129R2 ();
         wb9R0( ) ;
      }
   }

   public void send_integrity_lvl_hashes9R2( )
   {
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      edtavF1357_ganancianetaparatopes_f1357lrgravada_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_ganancianetaparatopes_f1357lrgravada_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_ganancianetaparatopes_f1357lrgravada_Enabled), 5, 0), true);
      edtavF1357_ganancianetaparatopes_descuentosdeley_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_ganancianetaparatopes_descuentosdeley_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_ganancianetaparatopes_descuentosdeley_Enabled), 5, 0), true);
      edtavF1357_ganancianetaparatopes_f1357ldgseguro_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_ganancianetaparatopes_f1357ldgseguro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_ganancianetaparatopes_f1357ldgseguro_Enabled), 5, 0), true);
      edtavF1357_ganancianetaparatopes_f1357ldgsegumixto_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_ganancianetaparatopes_f1357ldgsegumixto_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_ganancianetaparatopes_f1357ldgsegumixto_Enabled), 5, 0), true);
      edtavF1357_ganancianetaparatopes_f1357ldgretpriv_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_ganancianetaparatopes_f1357ldgretpriv_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_ganancianetaparatopes_f1357ldgretpriv_Enabled), 5, 0), true);
      edtavF1357_ganancianetaparatopes_f1357ldgcuotapartes_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_ganancianetaparatopes_f1357ldgcuotapartes_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_ganancianetaparatopes_f1357ldgcuotapartes_Enabled), 5, 0), true);
      edtavF1357_ganancianetaparatopes_f1357ldgsepelio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_ganancianetaparatopes_f1357ldgsepelio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_ganancianetaparatopes_f1357ldgsepelio_Enabled), 5, 0), true);
      edtavF1357_ganancianetaparatopes_f1357ldgrodado_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_ganancianetaparatopes_f1357ldgrodado_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_ganancianetaparatopes_f1357ldgrodado_Enabled), 5, 0), true);
      edtavF1357_ganancianetaparatopes_f1357ldgoblig_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_ganancianetaparatopes_f1357ldgoblig_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_ganancianetaparatopes_f1357ldgoblig_Enabled), 5, 0), true);
      edtavF1357_ganancianetaparatopes_f1357ldghipoteca_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_ganancianetaparatopes_f1357ldghipoteca_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_ganancianetaparatopes_f1357ldghipoteca_Enabled), 5, 0), true);
      edtavF1357_ganancianetaparatopes_f1357ldgsgr_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_ganancianetaparatopes_f1357ldgsgr_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_ganancianetaparatopes_f1357ldgsgr_Enabled), 5, 0), true);
      edtavF1357_ganancianetaparatopes_f1357ldgdomes_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_ganancianetaparatopes_f1357ldgdomes_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_ganancianetaparatopes_f1357ldgdomes_Enabled), 5, 0), true);
      edtavF1357_ganancianetaparatopes_f1357ldgalquiler_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_ganancianetaparatopes_f1357ldgalquiler_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_ganancianetaparatopes_f1357ldgalquiler_Enabled), 5, 0), true);
      edtavF1357_ganancianetaparatopes_f1357ldgviaticos_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_ganancianetaparatopes_f1357ldgviaticos_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_ganancianetaparatopes_f1357ldgviaticos_Enabled), 5, 0), true);
      edtavF1357_ganancianetaparatopes_f1357ldgindu_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_ganancianetaparatopes_f1357ldgindu_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_ganancianetaparatopes_f1357ldgindu_Enabled), 5, 0), true);
      edtavF1357_ganancianetaparatopes_f1357ldgotras_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavF1357_ganancianetaparatopes_f1357ldgotras_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavF1357_ganancianetaparatopes_f1357ldgotras_Enabled), 5, 0), true);
      fix_multi_value_controls( ) ;
   }

   public void strup9R0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e119R2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vF1357_GANANCIANETAPARATOPES"), AV7F1357_GananciaNetaParaTopes);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "F1357_ganancianetaparatopes"), AV7F1357_GananciaNetaParaTopes);
         /* Read saved values. */
         /* Read variables values. */
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357lrgravada_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357lrgravada_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357_GANANCIANETAPARATOPES_F1357LRGRAVADA");
            GX_FocusControl = edtavF1357_ganancianetaparatopes_f1357lrgravada_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357lrgravada( DecimalUtil.ZERO );
         }
         else
         {
            AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357lrgravada( localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357lrgravada_Internalname)) );
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_descuentosdeley_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_descuentosdeley_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357_GANANCIANETAPARATOPES_DESCUENTOSDELEY");
            GX_FocusControl = edtavF1357_ganancianetaparatopes_descuentosdeley_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_Descuentosdeley( DecimalUtil.ZERO );
         }
         else
         {
            AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_Descuentosdeley( localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_descuentosdeley_Internalname)) );
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgseguro_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgseguro_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357_GANANCIANETAPARATOPES_F1357LDGSEGURO");
            GX_FocusControl = edtavF1357_ganancianetaparatopes_f1357ldgseguro_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgseguro( DecimalUtil.ZERO );
         }
         else
         {
            AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgseguro( localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgseguro_Internalname)) );
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgsegumixto_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgsegumixto_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357_GANANCIANETAPARATOPES_F1357LDGSEGUMIXTO");
            GX_FocusControl = edtavF1357_ganancianetaparatopes_f1357ldgsegumixto_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsegumixto( DecimalUtil.ZERO );
         }
         else
         {
            AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsegumixto( localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgsegumixto_Internalname)) );
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgretpriv_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgretpriv_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357_GANANCIANETAPARATOPES_F1357LDGRETPRIV");
            GX_FocusControl = edtavF1357_ganancianetaparatopes_f1357ldgretpriv_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgretpriv( DecimalUtil.ZERO );
         }
         else
         {
            AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgretpriv( localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgretpriv_Internalname)) );
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgcuotapartes_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgcuotapartes_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357_GANANCIANETAPARATOPES_F1357LDGCUOTAPARTES");
            GX_FocusControl = edtavF1357_ganancianetaparatopes_f1357ldgcuotapartes_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgcuotapartes( DecimalUtil.ZERO );
         }
         else
         {
            AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgcuotapartes( localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgcuotapartes_Internalname)) );
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgsepelio_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgsepelio_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357_GANANCIANETAPARATOPES_F1357LDGSEPELIO");
            GX_FocusControl = edtavF1357_ganancianetaparatopes_f1357ldgsepelio_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsepelio( DecimalUtil.ZERO );
         }
         else
         {
            AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsepelio( localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgsepelio_Internalname)) );
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgrodado_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgrodado_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357_GANANCIANETAPARATOPES_F1357LDGRODADO");
            GX_FocusControl = edtavF1357_ganancianetaparatopes_f1357ldgrodado_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgrodado( DecimalUtil.ZERO );
         }
         else
         {
            AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgrodado( localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgrodado_Internalname)) );
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgoblig_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgoblig_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357_GANANCIANETAPARATOPES_F1357LDGOBLIG");
            GX_FocusControl = edtavF1357_ganancianetaparatopes_f1357ldgoblig_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgoblig( DecimalUtil.ZERO );
         }
         else
         {
            AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgoblig( localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgoblig_Internalname)) );
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldghipoteca_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldghipoteca_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357_GANANCIANETAPARATOPES_F1357LDGHIPOTECA");
            GX_FocusControl = edtavF1357_ganancianetaparatopes_f1357ldghipoteca_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldghipoteca( DecimalUtil.ZERO );
         }
         else
         {
            AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldghipoteca( localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldghipoteca_Internalname)) );
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgsgr_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgsgr_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357_GANANCIANETAPARATOPES_F1357LDGSGR");
            GX_FocusControl = edtavF1357_ganancianetaparatopes_f1357ldgsgr_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsgr( DecimalUtil.ZERO );
         }
         else
         {
            AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsgr( localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgsgr_Internalname)) );
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgdomes_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgdomes_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357_GANANCIANETAPARATOPES_F1357LDGDOMES");
            GX_FocusControl = edtavF1357_ganancianetaparatopes_f1357ldgdomes_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgdomes( DecimalUtil.ZERO );
         }
         else
         {
            AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgdomes( localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgdomes_Internalname)) );
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgalquiler_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgalquiler_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357_GANANCIANETAPARATOPES_F1357LDGALQUILER");
            GX_FocusControl = edtavF1357_ganancianetaparatopes_f1357ldgalquiler_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgalquiler( DecimalUtil.ZERO );
         }
         else
         {
            AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgalquiler( localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgalquiler_Internalname)) );
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgviaticos_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgviaticos_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357_GANANCIANETAPARATOPES_F1357LDGVIATICOS");
            GX_FocusControl = edtavF1357_ganancianetaparatopes_f1357ldgviaticos_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgviaticos( DecimalUtil.ZERO );
         }
         else
         {
            AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgviaticos( localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgviaticos_Internalname)) );
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgindu_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgindu_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357_GANANCIANETAPARATOPES_F1357LDGINDU");
            GX_FocusControl = edtavF1357_ganancianetaparatopes_f1357ldgindu_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgindu( DecimalUtil.ZERO );
         }
         else
         {
            AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgindu( localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgindu_Internalname)) );
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgotras_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgotras_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357_GANANCIANETAPARATOPES_F1357LDGOTRAS");
            GX_FocusControl = edtavF1357_ganancianetaparatopes_f1357ldgotras_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgotras( DecimalUtil.ZERO );
         }
         else
         {
            AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgotras( localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgotras_Internalname)) );
         }
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         forbiddenHiddens = new com.genexus.util.GXProperties() ;
         forbiddenHiddens.add("hshsalt", "hsh"+"F1357_MostrarGNParaTopes");
         AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357lrgravada( localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357lrgravada_Internalname)) );
         forbiddenHiddens.add("GXV1", localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357lrgravada(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
         AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_Descuentosdeley( localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_descuentosdeley_Internalname)) );
         forbiddenHiddens.add("GXV2", localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_Descuentosdeley(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
         AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgseguro( localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgseguro_Internalname)) );
         forbiddenHiddens.add("GXV3", localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgseguro(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
         AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsegumixto( localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgsegumixto_Internalname)) );
         forbiddenHiddens.add("GXV4", localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsegumixto(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
         AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgretpriv( localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgretpriv_Internalname)) );
         forbiddenHiddens.add("GXV5", localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgretpriv(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
         AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgcuotapartes( localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgcuotapartes_Internalname)) );
         forbiddenHiddens.add("GXV6", localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgcuotapartes(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
         AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsepelio( localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgsepelio_Internalname)) );
         forbiddenHiddens.add("GXV7", localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsepelio(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
         AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgrodado( localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgrodado_Internalname)) );
         forbiddenHiddens.add("GXV8", localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgrodado(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
         AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgoblig( localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgoblig_Internalname)) );
         forbiddenHiddens.add("GXV9", localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgoblig(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
         AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldghipoteca( localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldghipoteca_Internalname)) );
         forbiddenHiddens.add("GXV10", localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldghipoteca(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
         AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsgr( localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgsgr_Internalname)) );
         forbiddenHiddens.add("GXV11", localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsgr(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
         AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgdomes( localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgdomes_Internalname)) );
         forbiddenHiddens.add("GXV12", localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgdomes(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
         AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgalquiler( localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgalquiler_Internalname)) );
         forbiddenHiddens.add("GXV13", localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgalquiler(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
         AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgviaticos( localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgviaticos_Internalname)) );
         forbiddenHiddens.add("GXV14", localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgviaticos(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
         AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgindu( localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgindu_Internalname)) );
         forbiddenHiddens.add("GXV15", localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgindu(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
         AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgotras( localUtil.ctond( httpContext.cgiGet( edtavF1357_ganancianetaparatopes_f1357ldgotras_Internalname)) );
         forbiddenHiddens.add("GXV16", localUtil.format( AV7F1357_GananciaNetaParaTopes.getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgotras(), "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"));
         hsh = httpContext.cgiGet( "hsh") ;
         if ( ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
         {
            GXutil.writeLogError("f1357_mostrargnparatopes:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
      e119R2 ();
      if (returnInSub) return;
   }

   public void e119R2( )
   {
      /* Start Routine */
      returnInSub = false ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      /* Using cursor H009R2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV12EmpCod), Byte.valueOf(AV15F1357CTipoPre), AV8F1357CPer, Byte.valueOf(AV13F1357CSec), Integer.valueOf(AV14LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = H009R2_A6LegNumero[0] ;
         A778F1357CSec = H009R2_A778F1357CSec[0] ;
         A777F1357CPer = H009R2_A777F1357CPer[0] ;
         A784F1357CTipoPre = H009R2_A784F1357CTipoPre[0] ;
         A1EmpCod = H009R2_A1EmpCod[0] ;
         A3CliCod = H009R2_A3CliCod[0] ;
         A797F1357LRTipReg = H009R2_A797F1357LRTipReg[0] ;
         A800F1357LRGravada = H009R2_A800F1357LRGravada[0] ;
         AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357lrgravada( A800F1357LRGravada );
         pr_default.readNext(0);
      }
      pr_default.close(0);
      /* Using cursor H009R3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV12EmpCod), Byte.valueOf(AV15F1357CTipoPre), AV8F1357CPer, Byte.valueOf(AV13F1357CSec), Integer.valueOf(AV14LegNumero)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A6LegNumero = H009R3_A6LegNumero[0] ;
         A778F1357CSec = H009R3_A778F1357CSec[0] ;
         A777F1357CPer = H009R3_A777F1357CPer[0] ;
         A784F1357CTipoPre = H009R3_A784F1357CTipoPre[0] ;
         A1EmpCod = H009R3_A1EmpCod[0] ;
         A3CliCod = H009R3_A3CliCod[0] ;
         A863F1357LDGTipReg = H009R3_A863F1357LDGTipReg[0] ;
         A825F1357LDGDescuentosLey = H009R3_A825F1357LDGDescuentosLey[0] ;
         A826F1357LDGOtrDescuLey = H009R3_A826F1357LDGOtrDescuLey[0] ;
         A803F1357LDGSeguro = H009R3_A803F1357LDGSeguro[0] ;
         A804F1357LDGSeguMixto = H009R3_A804F1357LDGSeguMixto[0] ;
         A805F1357LDGRetPriv = H009R3_A805F1357LDGRetPriv[0] ;
         A806F1357LDGCuotapartes = H009R3_A806F1357LDGCuotapartes[0] ;
         A807F1357LDGSepelio = H009R3_A807F1357LDGSepelio[0] ;
         A808F1357LDGRodado = H009R3_A808F1357LDGRodado[0] ;
         A810F1357LDGOblig = H009R3_A810F1357LDGOblig[0] ;
         A812F1357LDGHipoteca = H009R3_A812F1357LDGHipoteca[0] ;
         A813F1357LDGSGR = H009R3_A813F1357LDGSGR[0] ;
         A816F1357LDGDomes = H009R3_A816F1357LDGDomes[0] ;
         A815F1357LDGAlquiler = H009R3_A815F1357LDGAlquiler[0] ;
         A817F1357LDGViaticos = H009R3_A817F1357LDGViaticos[0] ;
         A818F1357LDGIndu = H009R3_A818F1357LDGIndu[0] ;
         A819F1357LDGOtras = H009R3_A819F1357LDGOtras[0] ;
         AV9F1357_DeduccionesGenerales.fromJSonString(A825F1357LDGDescuentosLey, null);
         AV10F1357_DeduccionesGeneralesOtrosEmpleos.fromJSonString(A826F1357LDGOtrDescuLey, null);
         AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_Descuentosdeley( AV9F1357_DeduccionesGenerales.getgxTv_SdtF1357_DeduccionesGenerales_Jub().add(AV9F1357_DeduccionesGenerales.getgxTv_SdtF1357_DeduccionesGenerales_Os()).add(AV9F1357_DeduccionesGenerales.getgxTv_SdtF1357_DeduccionesGenerales_Cuotasin()).add(AV10F1357_DeduccionesGeneralesOtrosEmpleos.getgxTv_SdtF1357_DeduccionesGenerales_Jub()).add(AV10F1357_DeduccionesGeneralesOtrosEmpleos.getgxTv_SdtF1357_DeduccionesGenerales_Os()).add(AV10F1357_DeduccionesGeneralesOtrosEmpleos.getgxTv_SdtF1357_DeduccionesGenerales_Cuotasin()) );
         AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgseguro( A803F1357LDGSeguro );
         AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsegumixto( A804F1357LDGSeguMixto );
         AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgretpriv( A805F1357LDGRetPriv );
         AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgcuotapartes( A806F1357LDGCuotapartes );
         AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsepelio( A807F1357LDGSepelio );
         AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgrodado( A808F1357LDGRodado );
         AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgoblig( A810F1357LDGOblig );
         AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldghipoteca( A812F1357LDGHipoteca );
         AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsgr( A813F1357LDGSGR );
         AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgdomes( A816F1357LDGDomes );
         AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgalquiler( A815F1357LDGAlquiler );
         AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgviaticos( A817F1357LDGViaticos );
         AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgindu( A818F1357LDGIndu );
         AV7F1357_GananciaNetaParaTopes.setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgotras( A819F1357LDGOtras );
         pr_default.readNext(1);
      }
      pr_default.close(1);
   }

   protected void nextLoad( )
   {
   }

   protected void e129R2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV11CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11CliCod), 6, 0));
      AV12EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12EmpCod), 4, 0));
      AV15F1357CTipoPre = ((Number) GXutil.testNumericType( getParm(obj,2), TypeConstants.BYTE)).byteValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15F1357CTipoPre", GXutil.str( AV15F1357CTipoPre, 1, 0));
      AV8F1357CPer = (String)getParm(obj,3) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8F1357CPer", AV8F1357CPer);
      AV13F1357CSec = ((Number) GXutil.testNumericType( getParm(obj,4), TypeConstants.BYTE)).byteValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13F1357CSec), 2, 0));
      AV14LegNumero = ((Number) GXutil.testNumericType( getParm(obj,5), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14LegNumero), 8, 0));
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
      pa9R2( ) ;
      ws9R2( ) ;
      we9R2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412202054630", true, true);
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
         httpContext.AddJavascriptSource("f1357_mostrargnparatopes.js", "?202412202054630", false, true);
      }
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtavF1357_ganancianetaparatopes_f1357lrgravada_Internalname = "F1357_GANANCIANETAPARATOPES_F1357LRGRAVADA" ;
      edtavF1357_ganancianetaparatopes_descuentosdeley_Internalname = "F1357_GANANCIANETAPARATOPES_DESCUENTOSDELEY" ;
      edtavF1357_ganancianetaparatopes_f1357ldgseguro_Internalname = "F1357_GANANCIANETAPARATOPES_F1357LDGSEGURO" ;
      edtavF1357_ganancianetaparatopes_f1357ldgsegumixto_Internalname = "F1357_GANANCIANETAPARATOPES_F1357LDGSEGUMIXTO" ;
      edtavF1357_ganancianetaparatopes_f1357ldgretpriv_Internalname = "F1357_GANANCIANETAPARATOPES_F1357LDGRETPRIV" ;
      edtavF1357_ganancianetaparatopes_f1357ldgcuotapartes_Internalname = "F1357_GANANCIANETAPARATOPES_F1357LDGCUOTAPARTES" ;
      edtavF1357_ganancianetaparatopes_f1357ldgsepelio_Internalname = "F1357_GANANCIANETAPARATOPES_F1357LDGSEPELIO" ;
      edtavF1357_ganancianetaparatopes_f1357ldgrodado_Internalname = "F1357_GANANCIANETAPARATOPES_F1357LDGRODADO" ;
      edtavF1357_ganancianetaparatopes_f1357ldgoblig_Internalname = "F1357_GANANCIANETAPARATOPES_F1357LDGOBLIG" ;
      edtavF1357_ganancianetaparatopes_f1357ldghipoteca_Internalname = "F1357_GANANCIANETAPARATOPES_F1357LDGHIPOTECA" ;
      edtavF1357_ganancianetaparatopes_f1357ldgsgr_Internalname = "F1357_GANANCIANETAPARATOPES_F1357LDGSGR" ;
      edtavF1357_ganancianetaparatopes_f1357ldgdomes_Internalname = "F1357_GANANCIANETAPARATOPES_F1357LDGDOMES" ;
      edtavF1357_ganancianetaparatopes_f1357ldgalquiler_Internalname = "F1357_GANANCIANETAPARATOPES_F1357LDGALQUILER" ;
      edtavF1357_ganancianetaparatopes_f1357ldgviaticos_Internalname = "F1357_GANANCIANETAPARATOPES_F1357LDGVIATICOS" ;
      edtavF1357_ganancianetaparatopes_f1357ldgindu_Internalname = "F1357_GANANCIANETAPARATOPES_F1357LDGINDU" ;
      edtavF1357_ganancianetaparatopes_f1357ldgotras_Internalname = "F1357_GANANCIANETAPARATOPES_F1357LDGOTRAS" ;
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
      edtavF1357_ganancianetaparatopes_f1357ldgotras_Enabled = -1 ;
      edtavF1357_ganancianetaparatopes_f1357ldgindu_Enabled = -1 ;
      edtavF1357_ganancianetaparatopes_f1357ldgviaticos_Enabled = -1 ;
      edtavF1357_ganancianetaparatopes_f1357ldgalquiler_Enabled = -1 ;
      edtavF1357_ganancianetaparatopes_f1357ldgdomes_Enabled = -1 ;
      edtavF1357_ganancianetaparatopes_f1357ldgsgr_Enabled = -1 ;
      edtavF1357_ganancianetaparatopes_f1357ldghipoteca_Enabled = -1 ;
      edtavF1357_ganancianetaparatopes_f1357ldgoblig_Enabled = -1 ;
      edtavF1357_ganancianetaparatopes_f1357ldgrodado_Enabled = -1 ;
      edtavF1357_ganancianetaparatopes_f1357ldgsepelio_Enabled = -1 ;
      edtavF1357_ganancianetaparatopes_f1357ldgcuotapartes_Enabled = -1 ;
      edtavF1357_ganancianetaparatopes_f1357ldgretpriv_Enabled = -1 ;
      edtavF1357_ganancianetaparatopes_f1357ldgsegumixto_Enabled = -1 ;
      edtavF1357_ganancianetaparatopes_f1357ldgseguro_Enabled = -1 ;
      edtavF1357_ganancianetaparatopes_descuentosdeley_Enabled = -1 ;
      edtavF1357_ganancianetaparatopes_f1357lrgravada_Enabled = -1 ;
      edtavF1357_ganancianetaparatopes_f1357ldgotras_Jsonclick = "" ;
      edtavF1357_ganancianetaparatopes_f1357ldgotras_Enabled = 0 ;
      edtavF1357_ganancianetaparatopes_f1357ldgindu_Jsonclick = "" ;
      edtavF1357_ganancianetaparatopes_f1357ldgindu_Enabled = 0 ;
      edtavF1357_ganancianetaparatopes_f1357ldgviaticos_Jsonclick = "" ;
      edtavF1357_ganancianetaparatopes_f1357ldgviaticos_Enabled = 0 ;
      edtavF1357_ganancianetaparatopes_f1357ldgalquiler_Jsonclick = "" ;
      edtavF1357_ganancianetaparatopes_f1357ldgalquiler_Enabled = 0 ;
      edtavF1357_ganancianetaparatopes_f1357ldgdomes_Jsonclick = "" ;
      edtavF1357_ganancianetaparatopes_f1357ldgdomes_Enabled = 0 ;
      edtavF1357_ganancianetaparatopes_f1357ldgsgr_Jsonclick = "" ;
      edtavF1357_ganancianetaparatopes_f1357ldgsgr_Enabled = 0 ;
      edtavF1357_ganancianetaparatopes_f1357ldghipoteca_Jsonclick = "" ;
      edtavF1357_ganancianetaparatopes_f1357ldghipoteca_Enabled = 0 ;
      edtavF1357_ganancianetaparatopes_f1357ldgoblig_Jsonclick = "" ;
      edtavF1357_ganancianetaparatopes_f1357ldgoblig_Enabled = 0 ;
      edtavF1357_ganancianetaparatopes_f1357ldgrodado_Jsonclick = "" ;
      edtavF1357_ganancianetaparatopes_f1357ldgrodado_Enabled = 0 ;
      edtavF1357_ganancianetaparatopes_f1357ldgsepelio_Jsonclick = "" ;
      edtavF1357_ganancianetaparatopes_f1357ldgsepelio_Enabled = 0 ;
      edtavF1357_ganancianetaparatopes_f1357ldgcuotapartes_Jsonclick = "" ;
      edtavF1357_ganancianetaparatopes_f1357ldgcuotapartes_Enabled = 0 ;
      edtavF1357_ganancianetaparatopes_f1357ldgretpriv_Jsonclick = "" ;
      edtavF1357_ganancianetaparatopes_f1357ldgretpriv_Enabled = 0 ;
      edtavF1357_ganancianetaparatopes_f1357ldgsegumixto_Jsonclick = "" ;
      edtavF1357_ganancianetaparatopes_f1357ldgsegumixto_Enabled = 0 ;
      edtavF1357_ganancianetaparatopes_f1357ldgseguro_Jsonclick = "" ;
      edtavF1357_ganancianetaparatopes_f1357ldgseguro_Enabled = 0 ;
      edtavF1357_ganancianetaparatopes_descuentosdeley_Jsonclick = "" ;
      edtavF1357_ganancianetaparatopes_descuentosdeley_Enabled = 0 ;
      edtavF1357_ganancianetaparatopes_f1357lrgravada_Jsonclick = "" ;
      edtavF1357_ganancianetaparatopes_f1357lrgravada_Enabled = 0 ;
      divLayoutmaintable_Class = "Table TableTransactionTemplate" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Composición de ganancia neta para topes", "") );
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GXV1',fld:'F1357_GANANCIANETAPARATOPES_F1357LRGRAVADA',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'GXV2',fld:'F1357_GANANCIANETAPARATOPES_DESCUENTOSDELEY',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'GXV3',fld:'F1357_GANANCIANETAPARATOPES_F1357LDGSEGURO',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'GXV4',fld:'F1357_GANANCIANETAPARATOPES_F1357LDGSEGUMIXTO',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'GXV5',fld:'F1357_GANANCIANETAPARATOPES_F1357LDGRETPRIV',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'GXV6',fld:'F1357_GANANCIANETAPARATOPES_F1357LDGCUOTAPARTES',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'GXV7',fld:'F1357_GANANCIANETAPARATOPES_F1357LDGSEPELIO',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'GXV8',fld:'F1357_GANANCIANETAPARATOPES_F1357LDGRODADO',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'GXV9',fld:'F1357_GANANCIANETAPARATOPES_F1357LDGOBLIG',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'GXV10',fld:'F1357_GANANCIANETAPARATOPES_F1357LDGHIPOTECA',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'GXV11',fld:'F1357_GANANCIANETAPARATOPES_F1357LDGSGR',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'GXV12',fld:'F1357_GANANCIANETAPARATOPES_F1357LDGDOMES',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'GXV13',fld:'F1357_GANANCIANETAPARATOPES_F1357LDGALQUILER',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'GXV14',fld:'F1357_GANANCIANETAPARATOPES_F1357LDGVIATICOS',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'GXV15',fld:'F1357_GANANCIANETAPARATOPES_F1357LDGINDU',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'GXV16',fld:'F1357_GANANCIANETAPARATOPES_F1357LDGOTRAS',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'}]");
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
      wcpOAV8F1357CPer = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV8F1357CPer = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      AV7F1357_GananciaNetaParaTopes = new web.SdtF1357_GananciaNetaParaTopes(remoteHandle, context);
      GX_FocusControl = "" ;
      sPrefix = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      hsh = "" ;
      scmdbuf = "" ;
      H009R2_A6LegNumero = new int[1] ;
      H009R2_A778F1357CSec = new byte[1] ;
      H009R2_A777F1357CPer = new String[] {""} ;
      H009R2_A784F1357CTipoPre = new byte[1] ;
      H009R2_A1EmpCod = new short[1] ;
      H009R2_A3CliCod = new int[1] ;
      H009R2_A797F1357LRTipReg = new String[] {""} ;
      H009R2_A800F1357LRGravada = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A777F1357CPer = "" ;
      A797F1357LRTipReg = "" ;
      A800F1357LRGravada = DecimalUtil.ZERO ;
      H009R3_A6LegNumero = new int[1] ;
      H009R3_A778F1357CSec = new byte[1] ;
      H009R3_A777F1357CPer = new String[] {""} ;
      H009R3_A784F1357CTipoPre = new byte[1] ;
      H009R3_A1EmpCod = new short[1] ;
      H009R3_A3CliCod = new int[1] ;
      H009R3_A863F1357LDGTipReg = new String[] {""} ;
      H009R3_A825F1357LDGDescuentosLey = new String[] {""} ;
      H009R3_A826F1357LDGOtrDescuLey = new String[] {""} ;
      H009R3_A803F1357LDGSeguro = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009R3_A804F1357LDGSeguMixto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009R3_A805F1357LDGRetPriv = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009R3_A806F1357LDGCuotapartes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009R3_A807F1357LDGSepelio = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009R3_A808F1357LDGRodado = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009R3_A810F1357LDGOblig = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009R3_A812F1357LDGHipoteca = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009R3_A813F1357LDGSGR = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009R3_A816F1357LDGDomes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009R3_A815F1357LDGAlquiler = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009R3_A817F1357LDGViaticos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009R3_A818F1357LDGIndu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009R3_A819F1357LDGOtras = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A863F1357LDGTipReg = "" ;
      A825F1357LDGDescuentosLey = "" ;
      A826F1357LDGOtrDescuLey = "" ;
      A803F1357LDGSeguro = DecimalUtil.ZERO ;
      A804F1357LDGSeguMixto = DecimalUtil.ZERO ;
      A805F1357LDGRetPriv = DecimalUtil.ZERO ;
      A806F1357LDGCuotapartes = DecimalUtil.ZERO ;
      A807F1357LDGSepelio = DecimalUtil.ZERO ;
      A808F1357LDGRodado = DecimalUtil.ZERO ;
      A810F1357LDGOblig = DecimalUtil.ZERO ;
      A812F1357LDGHipoteca = DecimalUtil.ZERO ;
      A813F1357LDGSGR = DecimalUtil.ZERO ;
      A816F1357LDGDomes = DecimalUtil.ZERO ;
      A815F1357LDGAlquiler = DecimalUtil.ZERO ;
      A817F1357LDGViaticos = DecimalUtil.ZERO ;
      A818F1357LDGIndu = DecimalUtil.ZERO ;
      A819F1357LDGOtras = DecimalUtil.ZERO ;
      AV9F1357_DeduccionesGenerales = new web.SdtF1357_DeduccionesGenerales(remoteHandle, context);
      AV10F1357_DeduccionesGeneralesOtrosEmpleos = new web.SdtF1357_DeduccionesGenerales(remoteHandle, context);
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.f1357_mostrargnparatopes__default(),
         new Object[] {
             new Object[] {
            H009R2_A6LegNumero, H009R2_A778F1357CSec, H009R2_A777F1357CPer, H009R2_A784F1357CTipoPre, H009R2_A1EmpCod, H009R2_A3CliCod, H009R2_A797F1357LRTipReg, H009R2_A800F1357LRGravada
            }
            , new Object[] {
            H009R3_A6LegNumero, H009R3_A778F1357CSec, H009R3_A777F1357CPer, H009R3_A784F1357CTipoPre, H009R3_A1EmpCod, H009R3_A3CliCod, H009R3_A863F1357LDGTipReg, H009R3_A825F1357LDGDescuentosLey, H009R3_A826F1357LDGOtrDescuLey, H009R3_A803F1357LDGSeguro,
            H009R3_A804F1357LDGSeguMixto, H009R3_A805F1357LDGRetPriv, H009R3_A806F1357LDGCuotapartes, H009R3_A807F1357LDGSepelio, H009R3_A808F1357LDGRodado, H009R3_A810F1357LDGOblig, H009R3_A812F1357LDGHipoteca, H009R3_A813F1357LDGSGR, H009R3_A816F1357LDGDomes, H009R3_A815F1357LDGAlquiler,
            H009R3_A817F1357LDGViaticos, H009R3_A818F1357LDGIndu, H009R3_A819F1357LDGOtras
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavF1357_ganancianetaparatopes_f1357lrgravada_Enabled = 0 ;
      edtavF1357_ganancianetaparatopes_descuentosdeley_Enabled = 0 ;
      edtavF1357_ganancianetaparatopes_f1357ldgseguro_Enabled = 0 ;
      edtavF1357_ganancianetaparatopes_f1357ldgsegumixto_Enabled = 0 ;
      edtavF1357_ganancianetaparatopes_f1357ldgretpriv_Enabled = 0 ;
      edtavF1357_ganancianetaparatopes_f1357ldgcuotapartes_Enabled = 0 ;
      edtavF1357_ganancianetaparatopes_f1357ldgsepelio_Enabled = 0 ;
      edtavF1357_ganancianetaparatopes_f1357ldgrodado_Enabled = 0 ;
      edtavF1357_ganancianetaparatopes_f1357ldgoblig_Enabled = 0 ;
      edtavF1357_ganancianetaparatopes_f1357ldghipoteca_Enabled = 0 ;
      edtavF1357_ganancianetaparatopes_f1357ldgsgr_Enabled = 0 ;
      edtavF1357_ganancianetaparatopes_f1357ldgdomes_Enabled = 0 ;
      edtavF1357_ganancianetaparatopes_f1357ldgalquiler_Enabled = 0 ;
      edtavF1357_ganancianetaparatopes_f1357ldgviaticos_Enabled = 0 ;
      edtavF1357_ganancianetaparatopes_f1357ldgindu_Enabled = 0 ;
      edtavF1357_ganancianetaparatopes_f1357ldgotras_Enabled = 0 ;
   }

   private byte wcpOAV15F1357CTipoPre ;
   private byte wcpOAV13F1357CSec ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV15F1357CTipoPre ;
   private byte AV13F1357CSec ;
   private byte gxajaxcallmode ;
   private byte nGXWrapped ;
   private byte nDonePA ;
   private byte A778F1357CSec ;
   private byte A784F1357CTipoPre ;
   private short wcpOAV12EmpCod ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short AV12EmpCod ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short A1EmpCod ;
   private int wcpOAV11CliCod ;
   private int wcpOAV14LegNumero ;
   private int AV11CliCod ;
   private int AV14LegNumero ;
   private int edtavF1357_ganancianetaparatopes_f1357lrgravada_Enabled ;
   private int edtavF1357_ganancianetaparatopes_descuentosdeley_Enabled ;
   private int edtavF1357_ganancianetaparatopes_f1357ldgseguro_Enabled ;
   private int edtavF1357_ganancianetaparatopes_f1357ldgsegumixto_Enabled ;
   private int edtavF1357_ganancianetaparatopes_f1357ldgretpriv_Enabled ;
   private int edtavF1357_ganancianetaparatopes_f1357ldgcuotapartes_Enabled ;
   private int edtavF1357_ganancianetaparatopes_f1357ldgsepelio_Enabled ;
   private int edtavF1357_ganancianetaparatopes_f1357ldgrodado_Enabled ;
   private int edtavF1357_ganancianetaparatopes_f1357ldgoblig_Enabled ;
   private int edtavF1357_ganancianetaparatopes_f1357ldghipoteca_Enabled ;
   private int edtavF1357_ganancianetaparatopes_f1357ldgsgr_Enabled ;
   private int edtavF1357_ganancianetaparatopes_f1357ldgdomes_Enabled ;
   private int edtavF1357_ganancianetaparatopes_f1357ldgalquiler_Enabled ;
   private int edtavF1357_ganancianetaparatopes_f1357ldgviaticos_Enabled ;
   private int edtavF1357_ganancianetaparatopes_f1357ldgindu_Enabled ;
   private int edtavF1357_ganancianetaparatopes_f1357ldgotras_Enabled ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int idxLst ;
   private java.math.BigDecimal A800F1357LRGravada ;
   private java.math.BigDecimal A803F1357LDGSeguro ;
   private java.math.BigDecimal A804F1357LDGSeguMixto ;
   private java.math.BigDecimal A805F1357LDGRetPriv ;
   private java.math.BigDecimal A806F1357LDGCuotapartes ;
   private java.math.BigDecimal A807F1357LDGSepelio ;
   private java.math.BigDecimal A808F1357LDGRodado ;
   private java.math.BigDecimal A810F1357LDGOblig ;
   private java.math.BigDecimal A812F1357LDGHipoteca ;
   private java.math.BigDecimal A813F1357LDGSGR ;
   private java.math.BigDecimal A816F1357LDGDomes ;
   private java.math.BigDecimal A815F1357LDGAlquiler ;
   private java.math.BigDecimal A817F1357LDGViaticos ;
   private java.math.BigDecimal A818F1357LDGIndu ;
   private java.math.BigDecimal A819F1357LDGOtras ;
   private String wcpOAV8F1357CPer ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV8F1357CPer ;
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
   private String edtavF1357_ganancianetaparatopes_f1357lrgravada_Internalname ;
   private String edtavF1357_ganancianetaparatopes_f1357lrgravada_Jsonclick ;
   private String edtavF1357_ganancianetaparatopes_descuentosdeley_Internalname ;
   private String edtavF1357_ganancianetaparatopes_descuentosdeley_Jsonclick ;
   private String edtavF1357_ganancianetaparatopes_f1357ldgseguro_Internalname ;
   private String edtavF1357_ganancianetaparatopes_f1357ldgseguro_Jsonclick ;
   private String edtavF1357_ganancianetaparatopes_f1357ldgsegumixto_Internalname ;
   private String edtavF1357_ganancianetaparatopes_f1357ldgsegumixto_Jsonclick ;
   private String edtavF1357_ganancianetaparatopes_f1357ldgretpriv_Internalname ;
   private String edtavF1357_ganancianetaparatopes_f1357ldgretpriv_Jsonclick ;
   private String edtavF1357_ganancianetaparatopes_f1357ldgcuotapartes_Internalname ;
   private String edtavF1357_ganancianetaparatopes_f1357ldgcuotapartes_Jsonclick ;
   private String edtavF1357_ganancianetaparatopes_f1357ldgsepelio_Internalname ;
   private String edtavF1357_ganancianetaparatopes_f1357ldgsepelio_Jsonclick ;
   private String edtavF1357_ganancianetaparatopes_f1357ldgrodado_Internalname ;
   private String edtavF1357_ganancianetaparatopes_f1357ldgrodado_Jsonclick ;
   private String edtavF1357_ganancianetaparatopes_f1357ldgoblig_Internalname ;
   private String edtavF1357_ganancianetaparatopes_f1357ldgoblig_Jsonclick ;
   private String edtavF1357_ganancianetaparatopes_f1357ldghipoteca_Internalname ;
   private String edtavF1357_ganancianetaparatopes_f1357ldghipoteca_Jsonclick ;
   private String edtavF1357_ganancianetaparatopes_f1357ldgsgr_Internalname ;
   private String edtavF1357_ganancianetaparatopes_f1357ldgsgr_Jsonclick ;
   private String edtavF1357_ganancianetaparatopes_f1357ldgdomes_Internalname ;
   private String edtavF1357_ganancianetaparatopes_f1357ldgdomes_Jsonclick ;
   private String edtavF1357_ganancianetaparatopes_f1357ldgalquiler_Internalname ;
   private String edtavF1357_ganancianetaparatopes_f1357ldgalquiler_Jsonclick ;
   private String edtavF1357_ganancianetaparatopes_f1357ldgviaticos_Internalname ;
   private String edtavF1357_ganancianetaparatopes_f1357ldgviaticos_Jsonclick ;
   private String edtavF1357_ganancianetaparatopes_f1357ldgindu_Internalname ;
   private String edtavF1357_ganancianetaparatopes_f1357ldgindu_Jsonclick ;
   private String edtavF1357_ganancianetaparatopes_f1357ldgotras_Internalname ;
   private String edtavF1357_ganancianetaparatopes_f1357ldgotras_Jsonclick ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String hsh ;
   private String scmdbuf ;
   private String A777F1357CPer ;
   private String A797F1357LRTipReg ;
   private String A863F1357LDGTipReg ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private String A825F1357LDGDescuentosLey ;
   private String A826F1357LDGOtrDescuLey ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private web.SdtF1357_GananciaNetaParaTopes AV7F1357_GananciaNetaParaTopes ;
   private IDataStoreProvider pr_default ;
   private int[] H009R2_A6LegNumero ;
   private byte[] H009R2_A778F1357CSec ;
   private String[] H009R2_A777F1357CPer ;
   private byte[] H009R2_A784F1357CTipoPre ;
   private short[] H009R2_A1EmpCod ;
   private int[] H009R2_A3CliCod ;
   private String[] H009R2_A797F1357LRTipReg ;
   private java.math.BigDecimal[] H009R2_A800F1357LRGravada ;
   private int[] H009R3_A6LegNumero ;
   private byte[] H009R3_A778F1357CSec ;
   private String[] H009R3_A777F1357CPer ;
   private byte[] H009R3_A784F1357CTipoPre ;
   private short[] H009R3_A1EmpCod ;
   private int[] H009R3_A3CliCod ;
   private String[] H009R3_A863F1357LDGTipReg ;
   private String[] H009R3_A825F1357LDGDescuentosLey ;
   private String[] H009R3_A826F1357LDGOtrDescuLey ;
   private java.math.BigDecimal[] H009R3_A803F1357LDGSeguro ;
   private java.math.BigDecimal[] H009R3_A804F1357LDGSeguMixto ;
   private java.math.BigDecimal[] H009R3_A805F1357LDGRetPriv ;
   private java.math.BigDecimal[] H009R3_A806F1357LDGCuotapartes ;
   private java.math.BigDecimal[] H009R3_A807F1357LDGSepelio ;
   private java.math.BigDecimal[] H009R3_A808F1357LDGRodado ;
   private java.math.BigDecimal[] H009R3_A810F1357LDGOblig ;
   private java.math.BigDecimal[] H009R3_A812F1357LDGHipoteca ;
   private java.math.BigDecimal[] H009R3_A813F1357LDGSGR ;
   private java.math.BigDecimal[] H009R3_A816F1357LDGDomes ;
   private java.math.BigDecimal[] H009R3_A815F1357LDGAlquiler ;
   private java.math.BigDecimal[] H009R3_A817F1357LDGViaticos ;
   private java.math.BigDecimal[] H009R3_A818F1357LDGIndu ;
   private java.math.BigDecimal[] H009R3_A819F1357LDGOtras ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.SdtF1357_DeduccionesGenerales AV9F1357_DeduccionesGenerales ;
   private web.SdtF1357_DeduccionesGenerales AV10F1357_DeduccionesGeneralesOtrosEmpleos ;
}

final  class f1357_mostrargnparatopes__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H009R2", "SELECT LegNumero, F1357CSec, F1357CPer, F1357CTipoPre, EmpCod, CliCod, F1357LRTipReg, F1357LRGravada FROM F1357LegRemun WHERE CliCod = ? and EmpCod = ? and F1357CTipoPre = ? and F1357CPer = ( ?) and F1357CSec = ? and LegNumero = ? ORDER BY CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H009R3", "SELECT LegNumero, F1357CSec, F1357CPer, F1357CTipoPre, EmpCod, CliCod, F1357LDGTipReg, F1357LDGDescuentosLey, F1357LDGOtrDescuLey, F1357LDGSeguro, F1357LDGSeguMixto, F1357LDGRetPriv, F1357LDGCuotapartes, F1357LDGSepelio, F1357LDGRodado, F1357LDGOblig, F1357LDGHipoteca, F1357LDGSGR, F1357LDGDomes, F1357LDGAlquiler, F1357LDGViaticos, F1357LDGIndu, F1357LDGOtras FROM F1357LegDedGen WHERE CliCod = ? and EmpCod = ? and F1357CTipoPre = ? and F1357CPer = ( ?) and F1357CSec = ? and LegNumero = ? ORDER BY CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[7])[0] = rslt.getLongVarchar(8);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(9);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,2);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(11,2);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(12,2);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(13,2);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(14,2);
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(15,2);
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(16,2);
               ((java.math.BigDecimal[]) buf[16])[0] = rslt.getBigDecimal(17,2);
               ((java.math.BigDecimal[]) buf[17])[0] = rslt.getBigDecimal(18,2);
               ((java.math.BigDecimal[]) buf[18])[0] = rslt.getBigDecimal(19,2);
               ((java.math.BigDecimal[]) buf[19])[0] = rslt.getBigDecimal(20,2);
               ((java.math.BigDecimal[]) buf[20])[0] = rslt.getBigDecimal(21,2);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(22,2);
               ((java.math.BigDecimal[]) buf[22])[0] = rslt.getBigDecimal(23,2);
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
      }
   }

}

