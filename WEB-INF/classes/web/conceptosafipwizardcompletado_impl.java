package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class conceptosafipwizardcompletado_impl extends GXWebComponent
{
   public conceptosafipwizardcompletado_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public conceptosafipwizardcompletado_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptosafipwizardcompletado_impl.class ));
   }

   public conceptosafipwizardcompletado_impl( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void setPrefix( String sPPrefix )
   {
      sPrefix = sPPrefix;
   }

   protected void createObjects( )
   {
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( nGotPars == 0 )
         {
            entryPointCalled = false ;
            gxfirstwebparm = httpContext.GetFirstPar( "WebSessionKey") ;
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
            else if ( GXutil.strcmp(gxfirstwebparm, "dyncomponent") == 0 )
            {
               httpContext.setAjaxEventMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               nDynComponent = (byte)(1) ;
               sCompPrefix = httpContext.GetPar( "sCompPrefix") ;
               sSFPrefix = httpContext.GetPar( "sSFPrefix") ;
               AV15WebSessionKey = httpContext.GetPar( "WebSessionKey") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15WebSessionKey", AV15WebSessionKey);
               AV12PreviousStep = httpContext.GetPar( "PreviousStep") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12PreviousStep", AV12PreviousStep);
               AV10GoingBack = GXutil.strtobool( httpContext.GetPar( "GoingBack")) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10GoingBack", AV10GoingBack);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,AV15WebSessionKey,AV12PreviousStep,Boolean.valueOf(AV10GoingBack)});
               componentstart();
               httpContext.ajax_rspStartCmp(sPrefix);
               componentdraw();
               httpContext.ajax_rspEndCmp();
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
               gxfirstwebparm = httpContext.GetFirstPar( "WebSessionKey") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "WebSessionKey") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Griderrores") == 0 )
            {
               gxnrgriderrores_newrow_invoke( ) ;
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Griderrores") == 0 )
            {
               gxgrgriderrores_refresh_invoke( ) ;
               return  ;
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
            if ( toggleJsOutput )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableJsOutput();
               }
            }
         }
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isLocalStorageSupported( ) )
         {
            httpContext.pushCurrentUrl();
         }
      }
   }

   public void gxnrgriderrores_newrow_invoke( )
   {
      nRC_GXsfl_12 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_12"))) ;
      nGXsfl_12_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_12_idx"))) ;
      sGXsfl_12_idx = httpContext.GetPar( "sGXsfl_12_idx") ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgriderrores_newrow( ) ;
      /* End function gxnrGriderrores_newrow_invoke */
   }

   public void gxgrgriderrores_refresh_invoke( )
   {
      subGriderrores_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGriderrores_Rows"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV22sdt_errores);
      AV11HasValidationErrors = GXutil.strtobool( httpContext.GetPar( "HasValidationErrors")) ;
      AV17archivo = httpContext.GetPar( "archivo") ;
      AV18archivofullpath = httpContext.GetPar( "archivofullpath") ;
      AV5ArchivoChar = httpContext.GetPar( "ArchivoChar") ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      init_default_properties( ) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgriderrores_refresh( subGriderrores_Rows, AV22sdt_errores, AV11HasValidationErrors, AV17archivo, AV18archivofullpath, AV5ArchivoChar, sPrefix) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGriderrores_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa6X2( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            validateSpaRequest();
         }
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( ! isAjaxCallMode( ) )
            {
               if ( nDynComponent == 0 )
               {
                  httpContext.sendError( 404 );
                  GXutil.writeLog("send_http_error_code 404");
                  GxWebError = (byte)(1) ;
               }
            }
         }
         if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
         {
            if ( nDynComponent == 0 )
            {
               throw new RuntimeException("WebComponent is not allowed to run");
            }
         }
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
      cleanup();
   }

   public void renderHtmlHeaders( )
   {
      web.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), true);
   }

   public void renderHtmlOpenForm( )
   {
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
         httpContext.writeText( "<title>") ;
         httpContext.writeValue( httpContext.getMessage( "Conceptos Afip Wizard Completado", "")) ;
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
      httpContext.AddJavascriptSource("UserControls/WWP_IconButtonRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.closeHtmlHeader();
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
         httpContext.writeText( "<body ") ;
         bodyStyle = "" ;
         if ( nGXWrapped == 0 )
         {
            bodyStyle += "-moz-opacity:0;opacity:0;" ;
         }
         httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
         httpContext.writeText( FormProcess+">") ;
         httpContext.skipLines( 1 );
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.conceptosafipwizardcompletado", new String[] {GXutil.URLEncode(GXutil.rtrim(AV15WebSessionKey)),GXutil.URLEncode(GXutil.rtrim(AV12PreviousStep)),GXutil.URLEncode(GXutil.booltostr(AV10GoingBack))}, new String[] {"WebSessionKey","PreviousStep","GoingBack"}) +"\">") ;
         web.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
         web.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
         web.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
         httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, "FORM", "Class", "form-horizontal Form", true);
      }
      else
      {
         boolean toggleHtmlOutput = httpContext.isOutputEnabled( );
         if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableOutput();
            }
         }
         httpContext.writeText( "<div") ;
         web.GxWebStd.classAttribute( httpContext, "gxwebcomponent-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         if ( toggleHtmlOutput )
         {
            if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableOutput();
               }
            }
         }
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
      }
      if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
      }
   }

   public void send_integrity_footer_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vHASVALIDATIONERRORS", getSecureSignedToken( sPrefix, AV11HasValidationErrors));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSDT_ERRORES", getSecureSignedToken( sPrefix, AV22sdt_errores));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vARCHIVO", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV17archivo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vARCHIVOFULLPATH", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV18archivofullpath, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"ConceptosAfipWizardCompletado");
      forbiddenHiddens.add("ArchivoChar", AV5ArchivoChar);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("conceptosafipwizardcompletado:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"Sdt_errores", AV22sdt_errores);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"Sdt_errores", AV22sdt_errores);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_Sdt_errores", getSecureSignedToken( sPrefix, AV22sdt_errores));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_12", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_12, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV15WebSessionKey", wcpOAV15WebSessionKey);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV12PreviousStep", wcpOAV12PreviousStep);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"wcpOAV10GoingBack", wcpOAV10GoingBack);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vHASVALIDATIONERRORS", AV11HasValidationErrors);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vHASVALIDATIONERRORS", getSecureSignedToken( sPrefix, AV11HasValidationErrors));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vWEBSESSIONKEY", AV15WebSessionKey);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vSDT_ERRORES", AV22sdt_errores);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vSDT_ERRORES", AV22sdt_errores);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSDT_ERRORES", getSecureSignedToken( sPrefix, AV22sdt_errores));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vARCHIVO", AV17archivo);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vARCHIVO", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV17archivo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vARCHIVOFULLPATH", AV18archivofullpath);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vARCHIVOFULLPATH", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV18archivofullpath, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPREVIOUSSTEP", AV12PreviousStep);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vGOINGBACK", AV10GoingBack);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDERRORES_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDERRORES_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDERRORES_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDERRORES_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDERRORES_Rows", GXutil.ltrim( localUtil.ntoc( subGriderrores_Rows, (byte)(6), (byte)(0), ".", "")));
   }

   public void renderHtmlCloseForm6X2( )
   {
      sendCloseFormHiddens( ) ;
      if ( ( GXutil.len( sPrefix) != 0 ) && ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) ) )
      {
         componentjscripts();
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GX_FocusControl", GX_FocusControl);
      define_styles( ) ;
      sendSecurityToken(sPrefix);
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.SendAjaxEncryptionKey();
         httpContext.SendComponentObjects();
         httpContext.SendServerCommands();
         httpContext.SendState();
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         httpContext.writeTextNL( "</form>") ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
         include_jscripts( ) ;
         httpContext.writeTextNL( "</body>") ;
         httpContext.writeTextNL( "</html>") ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
      }
      else
      {
         httpContext.SendWebComponentState();
         httpContext.writeText( "</div>") ;
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
   }

   public String getPgmname( )
   {
      return "ConceptosAfipWizardCompletado" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Conceptos Afip Wizard Completado", "") ;
   }

   public void wb6X0( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         if ( GXutil.len( sPrefix) == 0 )
         {
            renderHtmlHeaders( ) ;
         }
         renderHtmlOpenForm( ) ;
         if ( GXutil.len( sPrefix) != 0 )
         {
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.conceptosafipwizardcompletado");
            httpContext.AddJavascriptSource("UserControls/WWP_IconButtonRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
         }
         web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), "", "", sPrefix, "false");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCompletedimage_Internalname, lblCompletedimage_Caption, "", "", lblCompletedimage_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_ConceptosAfipWizardCompletado.htm");
         web.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 HasGridEmpowerer", "left", "top", "", "", "div");
         /*  Grid Control  */
         GriderroresContainer.SetWrapped(nGXWrapped);
         startgridcontrol12( ) ;
      }
      if ( wbEnd == 12 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_12 = (int)(nGXsfl_12_idx-1) ;
         if ( GriderroresContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            GriderroresContainer.AddObjectProperty("GRIDERRORES_nEOF", GRIDERRORES_nEOF);
            GriderroresContainer.AddObjectProperty("GRIDERRORES_nFirstRecordOnPage", GRIDERRORES_nFirstRecordOnPage);
            AV30GXV1 = nGXsfl_12_idx ;
            if ( subGriderrores_Visible != 0 )
            {
               sStyleString = "" ;
            }
            else
            {
               sStyleString = " style=\"display:none;\"" ;
            }
            httpContext.writeText( "<div id=\""+sPrefix+"GriderroresContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Griderrores", GriderroresContainer, subGriderrores_Internalname);
            if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GriderroresContainerData", GriderroresContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GriderroresContainerData"+"V", GriderroresContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"GriderroresContainerData"+"V"+"\" value='"+GriderroresContainer.GridValuesHidden()+"'/>") ;
            }
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCompletedtitle_Internalname, httpContext.getMessage( "WWP_WizardCompleted", ""), "", "", lblCompletedtitle_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "WizardTextBlock", 0, "", lblCompletedtitle_Visible, 1, 0, (short)(0), "HLP_ConceptosAfipWizardCompletado.htm");
         web.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCompleteddescription_Internalname, httpContext.getMessage( "WWP_WizardCompletedDescription", ""), "", "", lblCompleteddescription_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "WizardTextBlockDescription", 0, "", lblCompleteddescription_Visible, 1, 0, (short)(0), "HLP_ConceptosAfipWizardCompletado.htm");
         web.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtavArchivochar_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavArchivochar_Internalname+"\"", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 24,'" + sPrefix + "',false,'" + sGXsfl_12_idx + "',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtavArchivochar_Internalname, AV5ArchivoChar, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,24);\"", (short)(0), edtavArchivochar_Visible, edtavArchivochar_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_ConceptosAfipWizardCompletado.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellWizardActions", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableactions_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "justify-content:flex-end;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* User Defined Control */
         ucBtnwizardlastnext.setProperty("AfterIconClass", Btnwizardlastnext_Aftericonclass);
         ucBtnwizardlastnext.setProperty("Caption", Btnwizardlastnext_Caption);
         ucBtnwizardlastnext.setProperty("Class", Btnwizardlastnext_Class);
         ucBtnwizardlastnext.render(context, "wwp_iconbutton", Btnwizardlastnext_Internalname, sPrefix+"BTNWIZARDLASTNEXTContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 31,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtndescargar_Internalname, "gx.evt.setGridEvt("+GXutil.str( 12, 2, 0)+","+"null"+");", httpContext.getMessage( "Descargar Archivo", ""), bttBtndescargar_Jsonclick, 5, httpContext.getMessage( "Descargar Archivo", ""), "", StyleString, ClassString, bttBtndescargar_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'DODESCARGAR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ConceptosAfipWizardCompletado.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divHtml_bottomauxiliarcontrols_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
         /* User Defined Control */
         ucGriderrores_empowerer.render(context, "wwp.gridempowerer", Griderrores_empowerer_Internalname, sPrefix+"GRIDERRORES_EMPOWERERContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 12 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GriderroresContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               GriderroresContainer.AddObjectProperty("GRIDERRORES_nEOF", GRIDERRORES_nEOF);
               GriderroresContainer.AddObjectProperty("GRIDERRORES_nFirstRecordOnPage", GRIDERRORES_nFirstRecordOnPage);
               AV30GXV1 = nGXsfl_12_idx ;
               if ( subGriderrores_Visible != 0 )
               {
                  sStyleString = "" ;
               }
               else
               {
                  sStyleString = " style=\"display:none;\"" ;
               }
               httpContext.writeText( "<div id=\""+sPrefix+"GriderroresContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Griderrores", GriderroresContainer, subGriderrores_Internalname);
               if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GriderroresContainerData", GriderroresContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GriderroresContainerData"+"V", GriderroresContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"GriderroresContainerData"+"V"+"\" value='"+GriderroresContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start6X2( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isSpaRequest( ) )
         {
            if ( httpContext.exposeMetadata( ) )
            {
               Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
            }
            Form.getMeta().addItem("description", httpContext.getMessage( "Conceptos Afip Wizard Completado", ""), (short)(0)) ;
         }
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
         httpContext.wbHandled = (byte)(0) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            sXEvt = httpContext.cgiGet( "_EventName") ;
            if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
            {
            }
         }
      }
      wbErr = false ;
      if ( ( GXutil.len( sPrefix) == 0 ) || ( nDraw == 1 ) )
      {
         if ( nDoneStart == 0 )
         {
            strup6X0( ) ;
         }
      }
   }

   public void ws6X2( )
   {
      start6X2( ) ;
      evt6X2( ) ;
   }

   public void evt6X2( )
   {
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ( ( ( GXutil.len( sPrefix) == 0 ) ) || ( GXutil.strSearch( sXEvt, sPrefix, 1) > 0 ) ) && ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
            if ( httpContext.wbHandled == 0 )
            {
               if ( GXutil.len( sPrefix) == 0 )
               {
                  sEvt = httpContext.cgiGet( "_EventName") ;
                  EvtGridId = httpContext.cgiGet( "_EventGridId") ;
                  EvtRowId = httpContext.cgiGet( "_EventRowId") ;
               }
               if ( GXutil.len( sEvt) > 0 )
               {
                  sEvtType = GXutil.left( sEvt, 1) ;
                  sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
                  if ( GXutil.strcmp(sEvtType, "E") == 0 )
                  {
                     sEvtType = GXutil.right( sEvt, 1) ;
                     if ( GXutil.strcmp(sEvtType, ".") == 0 )
                     {
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                        if ( GXutil.strcmp(sEvt, "RFR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup6X0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup6X0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 if ( ! wbErr )
                                 {
                                    Rfr0gs = false ;
                                    if ( ! Rfr0gs )
                                    {
                                       /* Execute user event: Enter */
                                       e116X2 ();
                                    }
                                    dynload_actions( ) ;
                                 }
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "'DODESCARGAR'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup6X0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'DoDescargar' */
                                 e126X2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup6X0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = edtavArchivochar_Internalname ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDERRORESPAGING") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup6X0( ) ;
                           }
                           sEvt = httpContext.cgiGet( sPrefix+"GRIDERRORESPAGING") ;
                           if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                           {
                              subgriderrores_firstpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "PREV") == 0 )
                           {
                              subgriderrores_previouspage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                           {
                              subgriderrores_nextpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                           {
                              subgriderrores_lastpage( ) ;
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 16), "GRIDERRORES.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup6X0( ) ;
                           }
                           nGXsfl_12_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_12_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_12_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_122( ) ;
                           AV30GXV1 = (int)(nGXsfl_12_idx+GRIDERRORES_nFirstRecordOnPage) ;
                           if ( ( AV22sdt_errores.size() >= AV30GXV1 ) && ( AV30GXV1 > 0 ) )
                           {
                              AV22sdt_errores.currentItem( ((web.Sdtsdt_errores_sdt_erroresItem)AV22sdt_errores.elementAt(-1+AV30GXV1)) );
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavArchivochar_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       /* Execute user event: Start */
                                       e136X2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavArchivochar_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       /* Execute user event: Refresh */
                                       e146X2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "GRIDERRORES.LOAD") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavArchivochar_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       e156X2 ();
                                    }
                                 }
                                 /* No code required for Cancel button. It is implemented as the Reset button. */
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                                 {
                                    strup6X0( ) ;
                                 }
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavArchivochar_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                    }
                                 }
                              }
                           }
                           else
                           {
                           }
                        }
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we6X2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm6X2( ) ;
         }
      }
   }

   public void pa6X2( )
   {
      if ( nDonePA == 0 )
      {
         if ( GXutil.len( sPrefix) != 0 )
         {
            initialize_properties( ) ;
         }
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
            {
               gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
            }
         }
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableJsOutput();
            }
         }
         init_web_controls( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( toggleJsOutput )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableJsOutput();
               }
            }
         }
         if ( ! httpContext.isAjaxRequest( ) )
         {
            GX_FocusControl = edtavArchivochar_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxnrgriderrores_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_122( ) ;
      while ( nGXsfl_12_idx <= nRC_GXsfl_12 )
      {
         sendrow_122( ) ;
         nGXsfl_12_idx = ((subGriderrores_Islastpage==1)&&(nGXsfl_12_idx+1>subgriderrores_fnc_recordsperpage( )) ? 1 : nGXsfl_12_idx+1) ;
         sGXsfl_12_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_12_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_122( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GriderroresContainer)) ;
      /* End function gxnrGriderrores_newrow */
   }

   public void gxgrgriderrores_refresh( int subGriderrores_Rows ,
                                        GXBaseCollection<web.Sdtsdt_errores_sdt_erroresItem> AV22sdt_errores ,
                                        boolean AV11HasValidationErrors ,
                                        String AV17archivo ,
                                        String AV18archivofullpath ,
                                        String AV5ArchivoChar ,
                                        String sPrefix )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e146X2 ();
      GRIDERRORES_nCurrentRecord = 0 ;
      rf6X2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"ConceptosAfipWizardCompletado");
      forbiddenHiddens.add("ArchivoChar", AV5ArchivoChar);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("conceptosafipwizardcompletado:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
      /* End function gxgrGriderrores_refresh */
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
      rf6X2( ) ;
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
      edtavSdt_errores__mensaje_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavSdt_errores__mensaje_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdt_errores__mensaje_Enabled), 5, 0), !bGXsfl_12_Refreshing);
      edtavArchivochar_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavArchivochar_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavArchivochar_Enabled), 5, 0), true);
   }

   public void rf6X2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GriderroresContainer.ClearRows();
      }
      wbStart = (short)(12) ;
      /* Execute user event: Refresh */
      e146X2 ();
      nGXsfl_12_idx = 1 ;
      sGXsfl_12_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_12_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_122( ) ;
      bGXsfl_12_Refreshing = true ;
      GriderroresContainer.AddObjectProperty("GridName", "Griderrores");
      GriderroresContainer.AddObjectProperty("CmpContext", sPrefix);
      GriderroresContainer.AddObjectProperty("InMasterPage", "false");
      GriderroresContainer.AddObjectProperty("Class", "WorkWith");
      GriderroresContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GriderroresContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GriderroresContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGriderrores_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GriderroresContainer.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( subGriderrores_Visible, (byte)(5), (byte)(0), ".", "")));
      GriderroresContainer.setPageSize( subgriderrores_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_122( ) ;
         e156X2 ();
         if ( ( GRIDERRORES_nCurrentRecord > 0 ) && ( GRIDERRORES_nGridOutOfScope == 0 ) && ( nGXsfl_12_idx == 1 ) )
         {
            GRIDERRORES_nCurrentRecord = 0 ;
            GRIDERRORES_nGridOutOfScope = 1 ;
            subgriderrores_firstpage( ) ;
            e156X2 ();
         }
         wbEnd = (short)(12) ;
         wb6X0( ) ;
      }
      bGXsfl_12_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes6X2( )
   {
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vHASVALIDATIONERRORS", AV11HasValidationErrors);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vHASVALIDATIONERRORS", getSecureSignedToken( sPrefix, AV11HasValidationErrors));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vSDT_ERRORES", AV22sdt_errores);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vSDT_ERRORES", AV22sdt_errores);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSDT_ERRORES", getSecureSignedToken( sPrefix, AV22sdt_errores));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vARCHIVO", AV17archivo);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vARCHIVO", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV17archivo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vARCHIVOFULLPATH", AV18archivofullpath);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vARCHIVOFULLPATH", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV18archivofullpath, ""))));
   }

   public int subgriderrores_fnc_pagecount( )
   {
      GRIDERRORES_nRecordCount = subgriderrores_fnc_recordcount( ) ;
      if ( ((int)((GRIDERRORES_nRecordCount) % (subgriderrores_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( GRIDERRORES_nRecordCount/ (double) (subgriderrores_fnc_recordsperpage( )))) ;
      }
      return (int)(GXutil.Int( GRIDERRORES_nRecordCount/ (double) (subgriderrores_fnc_recordsperpage( )))+1) ;
   }

   public int subgriderrores_fnc_recordcount( )
   {
      return AV22sdt_errores.size() ;
   }

   public int subgriderrores_fnc_recordsperpage( )
   {
      if ( subGriderrores_Rows > 0 )
      {
         return subGriderrores_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgriderrores_fnc_currentpage( )
   {
      return (int)(GXutil.Int( GRIDERRORES_nFirstRecordOnPage/ (double) (subgriderrores_fnc_recordsperpage( )))+1) ;
   }

   public short subgriderrores_firstpage( )
   {
      GRIDERRORES_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDERRORES_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDERRORES_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgriderrores_refresh( subGriderrores_Rows, AV22sdt_errores, AV11HasValidationErrors, AV17archivo, AV18archivofullpath, AV5ArchivoChar, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgriderrores_nextpage( )
   {
      GRIDERRORES_nRecordCount = subgriderrores_fnc_recordcount( ) ;
      if ( ( GRIDERRORES_nRecordCount >= subgriderrores_fnc_recordsperpage( ) ) && ( GRIDERRORES_nEOF == 0 ) )
      {
         GRIDERRORES_nFirstRecordOnPage = (long)(GRIDERRORES_nFirstRecordOnPage+subgriderrores_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDERRORES_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDERRORES_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      GriderroresContainer.AddObjectProperty("GRIDERRORES_nFirstRecordOnPage", GRIDERRORES_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgriderrores_refresh( subGriderrores_Rows, AV22sdt_errores, AV11HasValidationErrors, AV17archivo, AV18archivofullpath, AV5ArchivoChar, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRIDERRORES_nEOF==0) ? 0 : 2)) ;
   }

   public short subgriderrores_previouspage( )
   {
      if ( GRIDERRORES_nFirstRecordOnPage >= subgriderrores_fnc_recordsperpage( ) )
      {
         GRIDERRORES_nFirstRecordOnPage = (long)(GRIDERRORES_nFirstRecordOnPage-subgriderrores_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDERRORES_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDERRORES_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgriderrores_refresh( subGriderrores_Rows, AV22sdt_errores, AV11HasValidationErrors, AV17archivo, AV18archivofullpath, AV5ArchivoChar, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgriderrores_lastpage( )
   {
      GRIDERRORES_nRecordCount = subgriderrores_fnc_recordcount( ) ;
      if ( GRIDERRORES_nRecordCount > subgriderrores_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRIDERRORES_nRecordCount) % (subgriderrores_fnc_recordsperpage( )))) == 0 )
         {
            GRIDERRORES_nFirstRecordOnPage = (long)(GRIDERRORES_nRecordCount-subgriderrores_fnc_recordsperpage( )) ;
         }
         else
         {
            GRIDERRORES_nFirstRecordOnPage = (long)(GRIDERRORES_nRecordCount-((int)((GRIDERRORES_nRecordCount) % (subgriderrores_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRIDERRORES_nFirstRecordOnPage = 0 ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDERRORES_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDERRORES_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgriderrores_refresh( subGriderrores_Rows, AV22sdt_errores, AV11HasValidationErrors, AV17archivo, AV18archivofullpath, AV5ArchivoChar, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgriderrores_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRIDERRORES_nFirstRecordOnPage = (long)(subgriderrores_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRIDERRORES_nFirstRecordOnPage = 0 ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDERRORES_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDERRORES_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgriderrores_refresh( subGriderrores_Rows, AV22sdt_errores, AV11HasValidationErrors, AV17archivo, AV18archivofullpath, AV5ArchivoChar, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      edtavSdt_errores__mensaje_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavSdt_errores__mensaje_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdt_errores__mensaje_Enabled), 5, 0), !bGXsfl_12_Refreshing);
      edtavArchivochar_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavArchivochar_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavArchivochar_Enabled), 5, 0), true);
      fix_multi_value_controls( ) ;
   }

   public void strup6X0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e136X2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"Sdt_errores"), AV22sdt_errores);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vSDT_ERRORES"), AV22sdt_errores);
         /* Read saved values. */
         nRC_GXsfl_12 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_12"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV15WebSessionKey = httpContext.cgiGet( sPrefix+"wcpOAV15WebSessionKey") ;
         wcpOAV12PreviousStep = httpContext.cgiGet( sPrefix+"wcpOAV12PreviousStep") ;
         wcpOAV10GoingBack = GXutil.strtobool( httpContext.cgiGet( sPrefix+"wcpOAV10GoingBack")) ;
         GRIDERRORES_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( sPrefix+"GRIDERRORES_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRIDERRORES_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRIDERRORES_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         subGriderrores_Rows = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRIDERRORES_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDERRORES_Rows", GXutil.ltrim( localUtil.ntoc( subGriderrores_Rows, (byte)(6), (byte)(0), ".", "")));
         nRC_GXsfl_12 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_12"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         nGXsfl_12_fel_idx = 0 ;
         while ( nGXsfl_12_fel_idx < nRC_GXsfl_12 )
         {
            nGXsfl_12_fel_idx = ((subGriderrores_Islastpage==1)&&(nGXsfl_12_fel_idx+1>subgriderrores_fnc_recordsperpage( )) ? 1 : nGXsfl_12_fel_idx+1) ;
            sGXsfl_12_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_12_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_122( ) ;
            AV30GXV1 = (int)(nGXsfl_12_fel_idx+GRIDERRORES_nFirstRecordOnPage) ;
            if ( ( AV22sdt_errores.size() >= AV30GXV1 ) && ( AV30GXV1 > 0 ) )
            {
               AV22sdt_errores.currentItem( ((web.Sdtsdt_errores_sdt_erroresItem)AV22sdt_errores.elementAt(-1+AV30GXV1)) );
            }
         }
         if ( nGXsfl_12_fel_idx == 0 )
         {
            nGXsfl_12_idx = 1 ;
            sGXsfl_12_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_12_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_122( ) ;
         }
         nGXsfl_12_fel_idx = 1 ;
         /* Read variables values. */
         AV5ArchivoChar = httpContext.cgiGet( edtavArchivochar_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5ArchivoChar", AV5ArchivoChar);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         forbiddenHiddens = new com.genexus.util.GXProperties() ;
         forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"ConceptosAfipWizardCompletado");
         AV5ArchivoChar = httpContext.cgiGet( edtavArchivochar_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5ArchivoChar", AV5ArchivoChar);
         forbiddenHiddens.add("ArchivoChar", AV5ArchivoChar);
         hsh = httpContext.cgiGet( sPrefix+"hsh") ;
         if ( ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
         {
            GXutil.writeLogError("conceptosafipwizardcompletado:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
            GxWebError = (byte)(1) ;
            httpContext.sendError( 403 );
            GXutil.writeLog("send_http_error_code 403");
            return  ;
         }
         /* Check if conditions changed and reset current page numbers */
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e136X2 ();
      if (returnInSub) return;
   }

   public void e136X2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV6CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      conceptosafipwizardcompletado_impl.this.GXt_int1 = GXv_int2[0] ;
      AV6CliCod = GXt_int1 ;
      /* Execute user subroutine: 'LOADVARIABLESFROMWIZARDDATA' */
      S112 ();
      if (returnInSub) return;
      Griderrores_empowerer_Gridinternalname = subGriderrores_Internalname ;
      ucGriderrores_empowerer.sendProperty(context, sPrefix, false, Griderrores_empowerer_Internalname, "GridInternalName", Griderrores_empowerer_Gridinternalname);
      subGriderrores_Rows = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDERRORES_Rows", GXutil.ltrim( localUtil.ntoc( subGriderrores_Rows, (byte)(6), (byte)(0), ".", "")));
      GXv_objcol_svchar3[0] = AV19errores ;
      new web.validarwizardconceptosafip(remoteHandle, context).execute( AV6CliCod, "", GXv_objcol_svchar3) ;
      AV19errores = GXv_objcol_svchar3[0] ;
      edtavArchivochar_Visible = 1 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavArchivochar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavArchivochar_Visible), 5, 0), true);
      lblCompletedtitle_Visible = 1 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, lblCompletedtitle_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCompletedtitle_Visible), 5, 0), true);
      lblCompleteddescription_Visible = 1 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, lblCompleteddescription_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCompleteddescription_Visible), 5, 0), true);
      bttBtndescargar_Visible = 1 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtndescargar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtndescargar_Visible), 5, 0), true);
      lblCompletedimage_Caption = httpContext.getMessage( "<i class='fas fa-check' style='font-size: 100px'></i>", "") ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, lblCompletedimage_Internalname, "Caption", lblCompletedimage_Caption, true);
      if ( AV19errores.size() > 0 )
      {
         /* Execute user subroutine: 'ES ERROR' */
         S122 ();
         if (returnInSub) return;
         subGriderrores_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, sPrefix+"GriderroresContainerDiv", "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(subGriderrores_Visible), 5, 0), true);
         AV20e = (short)(1) ;
         while ( AV20e <= AV19errores.size() )
         {
            AV21itemError = (web.Sdtsdt_errores_sdt_erroresItem)new web.Sdtsdt_errores_sdt_erroresItem(remoteHandle, context);
            AV21itemError.setgxTv_Sdtsdt_errores_sdt_erroresItem_Mensaje( (String)AV19errores.elementAt(-1+AV20e) );
            AV22sdt_errores.add(AV21itemError, 0);
            gx_BV12 = true ;
            AV20e = (short)(AV20e+1) ;
         }
      }
      else
      {
         subGriderrores_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, sPrefix+"GriderroresContainerDiv", "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(subGriderrores_Visible), 5, 0), true);
         GXv_char4[0] = AV9error ;
         new web.guardarwizardconceptosafip(remoteHandle, context).execute( AV6CliCod, GXv_char4) ;
         conceptosafipwizardcompletado_impl.this.AV9error = GXv_char4[0] ;
         if ( ! (GXutil.strcmp("", AV9error)==0) )
         {
            httpContext.GX_msglist.addItem(AV9error);
            /* Execute user subroutine: 'ES ERROR' */
            S122 ();
            if (returnInSub) return;
         }
         else
         {
            GXv_char4[0] = AV18archivofullpath ;
            GXv_char5[0] = AV17archivo ;
            new web.genarchivoconcepempafip(remoteHandle, context).execute( GXv_char4, GXv_char5) ;
            conceptosafipwizardcompletado_impl.this.AV18archivofullpath = GXv_char4[0] ;
            conceptosafipwizardcompletado_impl.this.AV17archivo = GXv_char5[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18archivofullpath", AV18archivofullpath);
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vARCHIVOFULLPATH", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV18archivofullpath, ""))));
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17archivo", AV17archivo);
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vARCHIVO", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV17archivo, ""))));
            GXv_char5[0] = AV5ArchivoChar ;
            new web.leertxtchico(remoteHandle, context).execute( AV18archivofullpath, GXv_char5) ;
            conceptosafipwizardcompletado_impl.this.AV5ArchivoChar = GXv_char5[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5ArchivoChar", AV5ArchivoChar);
         }
      }
   }

   public void e146X2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV6CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      conceptosafipwizardcompletado_impl.this.GXt_int1 = GXv_int2[0] ;
      AV6CliCod = GXt_int1 ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S132 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   private void e156X2( )
   {
      /* Griderrores_Load Routine */
      returnInSub = false ;
      AV30GXV1 = 1 ;
      while ( AV30GXV1 <= AV22sdt_errores.size() )
      {
         AV22sdt_errores.currentItem( ((web.Sdtsdt_errores_sdt_erroresItem)AV22sdt_errores.elementAt(-1+AV30GXV1)) );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(12) ;
         }
         if ( ( subGriderrores_Islastpage == 1 ) || ( subGriderrores_Rows == 0 ) || ( ( GRIDERRORES_nCurrentRecord >= GRIDERRORES_nFirstRecordOnPage ) && ( GRIDERRORES_nCurrentRecord < GRIDERRORES_nFirstRecordOnPage + subgriderrores_fnc_recordsperpage( ) ) ) )
         {
            sendrow_122( ) ;
            GRIDERRORES_nEOF = (byte)(0) ;
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDERRORES_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDERRORES_nEOF, (byte)(1), (byte)(0), ".", "")));
            if ( GRIDERRORES_nCurrentRecord + 1 >= subgriderrores_fnc_recordcount( ) )
            {
               GRIDERRORES_nEOF = (byte)(1) ;
               web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDERRORES_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDERRORES_nEOF, (byte)(1), (byte)(0), ".", "")));
            }
         }
         GRIDERRORES_nCurrentRecord = (long)(GRIDERRORES_nCurrentRecord+1) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_12_Refreshing )
         {
            httpContext.doAjaxLoad(12, GriderroresRow);
         }
         AV30GXV1 = (int)(AV30GXV1+1) ;
      }
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e116X2 ();
      if (returnInSub) return;
   }

   public void e116X2( )
   {
      AV30GXV1 = (int)(nGXsfl_12_idx+GRIDERRORES_nFirstRecordOnPage) ;
      if ( ( AV30GXV1 > 0 ) && ( AV22sdt_errores.size() >= AV30GXV1 ) )
      {
         AV22sdt_errores.currentItem( ((web.Sdtsdt_errores_sdt_erroresItem)AV22sdt_errores.elementAt(-1+AV30GXV1)) );
      }
      /* Enter Routine */
      returnInSub = false ;
      if ( true )
      {
         if ( ! AV11HasValidationErrors )
         {
            /* Execute user subroutine: 'SAVEVARIABLESTOWIZARDDATA' */
            S142 ();
            if (returnInSub) return;
            AV13proximoPaso = AV14WebSession.getValue(httpContext.getMessage( "proximoPaso", "")) ;
            callWebObject(formatLink("web.conceptosafipwizard", new String[] {GXutil.URLEncode(GXutil.rtrim("Inicio")),GXutil.URLEncode(GXutil.rtrim(GXutil.trim( AV13proximoPaso))),GXutil.URLEncode(GXutil.booltostr(false))}, new String[] {"PreviousStep","CurrentStep","GoingBack"}) );
            httpContext.wjLocDisableFrm = (byte)(1) ;
         }
      }
      else
      {
         if ( ! AV11HasValidationErrors )
         {
            /* Execute user subroutine: 'SAVEVARIABLESTOWIZARDDATA' */
            S142 ();
            if (returnInSub) return;
            /* Execute user subroutine: 'FINISHWIZARD' */
            S152 ();
            if (returnInSub) return;
            AV14WebSession.remove(AV15WebSessionKey);
         }
      }
      /*  Sending Event outputs  */
   }

   public void e126X2( )
   {
      /* 'DoDescargar' Routine */
      returnInSub = false ;
      callWebObject(formatLink("web.adownload", new String[] {GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "text/plain", ""))),GXutil.URLEncode(GXutil.rtrim(AV17archivo)),GXutil.URLEncode(GXutil.rtrim(AV18archivofullpath))}, new String[] {"contenttype","filename","filepath"}) );
      httpContext.wjLocDisableFrm = (byte)(2) ;
   }

   public void S132( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      if ( ! ( false ) )
      {
         Btnwizardlastnext_Visible = false ;
         ucBtnwizardlastnext.sendProperty(context, sPrefix, false, Btnwizardlastnext_Internalname, "Visible", GXutil.booltostr( Btnwizardlastnext_Visible));
      }
   }

   public void S112( )
   {
      /* 'LOADVARIABLESFROMWIZARDDATA' Routine */
      returnInSub = false ;
      AV16WizardData.fromJSonString(AV14WebSession.getValue(AV15WebSessionKey), null);
      AV5ArchivoChar = AV16WizardData.getgxTv_SdtConceptosAfipWizardData_Completado().getgxTv_SdtConceptosAfipWizardData_Completado_Archivochar() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5ArchivoChar", AV5ArchivoChar);
      AV22sdt_errores = AV16WizardData.getgxTv_SdtConceptosAfipWizardData_Completado().getgxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores() ;
      gx_BV12 = true ;
   }

   public void S142( )
   {
      /* 'SAVEVARIABLESTOWIZARDDATA' Routine */
      returnInSub = false ;
      AV16WizardData.fromJSonString(AV14WebSession.getValue(AV15WebSessionKey), null);
      AV16WizardData.getgxTv_SdtConceptosAfipWizardData_Completado().setgxTv_SdtConceptosAfipWizardData_Completado_Archivochar( AV5ArchivoChar );
      AV16WizardData.getgxTv_SdtConceptosAfipWizardData_Completado().setgxTv_SdtConceptosAfipWizardData_Completado_Sdt_errores( AV22sdt_errores );
      AV14WebSession.setValue(AV15WebSessionKey, AV16WizardData.toJSonString(false, true));
   }

   public void S152( )
   {
      /* 'FINISHWIZARD' Routine */
      returnInSub = false ;
   }

   public void S122( )
   {
      /* 'ES ERROR' Routine */
      returnInSub = false ;
      edtavArchivochar_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavArchivochar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavArchivochar_Visible), 5, 0), true);
      bttBtndescargar_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtndescargar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtndescargar_Visible), 5, 0), true);
      lblCompletedtitle_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, lblCompletedtitle_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCompletedtitle_Visible), 5, 0), true);
      lblCompleteddescription_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, lblCompleteddescription_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCompleteddescription_Visible), 5, 0), true);
      lblCompletedimage_Caption = httpContext.getMessage( "<i class='fas fa-times' style='font-size: 100px'></i>", "") ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, lblCompletedimage_Internalname, "Caption", lblCompletedimage_Caption, true);
      if ( AV19errores.size() > 1 )
      {
         edtavSdt_errores__mensaje_Title = httpContext.getMessage( "Errores", "") ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavSdt_errores__mensaje_Internalname, "Title", edtavSdt_errores__mensaje_Title, !bGXsfl_12_Refreshing);
      }
      else
      {
         edtavSdt_errores__mensaje_Title = httpContext.getMessage( "Error", "") ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavSdt_errores__mensaje_Internalname, "Title", edtavSdt_errores__mensaje_Title, !bGXsfl_12_Refreshing);
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV15WebSessionKey = (String)getParm(obj,0,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15WebSessionKey", AV15WebSessionKey);
      AV12PreviousStep = (String)getParm(obj,1,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12PreviousStep", AV12PreviousStep);
      AV10GoingBack = ((Boolean) getParm(obj,2,TypeConstants.BOOLEAN)).booleanValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10GoingBack", AV10GoingBack);
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
      pa6X2( ) ;
      ws6X2( ) ;
      we6X2( ) ;
      httpContext.setWrapped(false);
      httpContext.SaveComponentMsgList(sPrefix);
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

   public void componentbind( Object[] obj )
   {
      if ( IsUrlCreated( ) )
      {
         return  ;
      }
      sCtrlAV15WebSessionKey = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlAV12PreviousStep = (String)getParm(obj,1,TypeConstants.STRING) ;
      sCtrlAV10GoingBack = (String)getParm(obj,2,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa6X2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "conceptosafipwizardcompletado", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa6X2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV15WebSessionKey = (String)getParm(obj,2,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15WebSessionKey", AV15WebSessionKey);
         AV12PreviousStep = (String)getParm(obj,3,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12PreviousStep", AV12PreviousStep);
         AV10GoingBack = ((Boolean) getParm(obj,4,TypeConstants.BOOLEAN)).booleanValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10GoingBack", AV10GoingBack);
      }
      wcpOAV15WebSessionKey = httpContext.cgiGet( sPrefix+"wcpOAV15WebSessionKey") ;
      wcpOAV12PreviousStep = httpContext.cgiGet( sPrefix+"wcpOAV12PreviousStep") ;
      wcpOAV10GoingBack = GXutil.strtobool( httpContext.cgiGet( sPrefix+"wcpOAV10GoingBack")) ;
      if ( ! GetJustCreated( ) && ( ( GXutil.strcmp(AV15WebSessionKey, wcpOAV15WebSessionKey) != 0 ) || ( GXutil.strcmp(AV12PreviousStep, wcpOAV12PreviousStep) != 0 ) || ( AV10GoingBack != wcpOAV10GoingBack ) ) )
      {
         setjustcreated();
      }
      wcpOAV15WebSessionKey = AV15WebSessionKey ;
      wcpOAV12PreviousStep = AV12PreviousStep ;
      wcpOAV10GoingBack = AV10GoingBack ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlAV15WebSessionKey = httpContext.cgiGet( sPrefix+"AV15WebSessionKey_CTRL") ;
      if ( GXutil.len( sCtrlAV15WebSessionKey) > 0 )
      {
         AV15WebSessionKey = httpContext.cgiGet( sCtrlAV15WebSessionKey) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15WebSessionKey", AV15WebSessionKey);
      }
      else
      {
         AV15WebSessionKey = httpContext.cgiGet( sPrefix+"AV15WebSessionKey_PARM") ;
      }
      sCtrlAV12PreviousStep = httpContext.cgiGet( sPrefix+"AV12PreviousStep_CTRL") ;
      if ( GXutil.len( sCtrlAV12PreviousStep) > 0 )
      {
         AV12PreviousStep = httpContext.cgiGet( sCtrlAV12PreviousStep) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12PreviousStep", AV12PreviousStep);
      }
      else
      {
         AV12PreviousStep = httpContext.cgiGet( sPrefix+"AV12PreviousStep_PARM") ;
      }
      sCtrlAV10GoingBack = httpContext.cgiGet( sPrefix+"AV10GoingBack_CTRL") ;
      if ( GXutil.len( sCtrlAV10GoingBack) > 0 )
      {
         AV10GoingBack = GXutil.strtobool( httpContext.cgiGet( sCtrlAV10GoingBack)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10GoingBack", AV10GoingBack);
      }
      else
      {
         AV10GoingBack = GXutil.strtobool( httpContext.cgiGet( sPrefix+"AV10GoingBack_PARM")) ;
      }
   }

   public void componentprocess( String sPPrefix ,
                                 String sPSFPrefix ,
                                 String sCompEvt )
   {
      sCompPrefix = sPPrefix ;
      sSFPrefix = sPSFPrefix ;
      sPrefix = sCompPrefix + sSFPrefix ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      initweb( ) ;
      nDraw = (byte)(0) ;
      pa6X2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws6X2( ) ;
      if ( isFullAjaxMode( ) )
      {
         componentdraw();
      }
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void componentstart( )
   {
      if ( nDoneStart == 0 )
      {
         wcstart( ) ;
      }
   }

   public void wcstart( )
   {
      nDraw = (byte)(1) ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      ws6X2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV15WebSessionKey_PARM", AV15WebSessionKey);
      if ( GXutil.len( GXutil.rtrim( sCtrlAV15WebSessionKey)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV15WebSessionKey_CTRL", GXutil.rtrim( sCtrlAV15WebSessionKey));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV12PreviousStep_PARM", AV12PreviousStep);
      if ( GXutil.len( GXutil.rtrim( sCtrlAV12PreviousStep)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV12PreviousStep_CTRL", GXutil.rtrim( sCtrlAV12PreviousStep));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV10GoingBack_PARM", GXutil.booltostr( AV10GoingBack));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV10GoingBack)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV10GoingBack_CTRL", GXutil.rtrim( sCtrlAV10GoingBack));
      }
   }

   public void componentdraw( )
   {
      if ( nDoneStart == 0 )
      {
         wcstart( ) ;
      }
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      wcparametersset( ) ;
      we6X2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public String componentgetstring( String sGXControl )
   {
      String sCtrlName;
      if ( GXutil.strcmp(GXutil.substring( sGXControl, 1, 1), "&") == 0 )
      {
         sCtrlName = GXutil.substring( sGXControl, 2, GXutil.len( sGXControl)-1) ;
      }
      else
      {
         sCtrlName = sGXControl ;
      }
      return httpContext.cgiGet( sPrefix+"v"+GXutil.upper( sCtrlName)) ;
   }

   public void componentjscripts( )
   {
      include_jscripts( ) ;
   }

   public void componentthemes( )
   {
      define_styles( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122019472050", true, true);
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
      httpContext.AddJavascriptSource("conceptosafipwizardcompletado.js", "?2024122019472050", false, true);
      httpContext.AddJavascriptSource("UserControls/WWP_IconButtonRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_122( )
   {
      edtavSdt_errores__mensaje_Internalname = sPrefix+"SDT_ERRORES__MENSAJE_"+sGXsfl_12_idx ;
   }

   public void subsflControlProps_fel_122( )
   {
      edtavSdt_errores__mensaje_Internalname = sPrefix+"SDT_ERRORES__MENSAJE_"+sGXsfl_12_fel_idx ;
   }

   public void sendrow_122( )
   {
      subsflControlProps_122( ) ;
      wb6X0( ) ;
      if ( ( subGriderrores_Rows * 1 == 0 ) || ( nGXsfl_12_idx <= subgriderrores_fnc_recordsperpage( ) * 1 ) )
      {
         GriderroresRow = GXWebRow.GetNew(context,GriderroresContainer) ;
         if ( subGriderrores_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGriderrores_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGriderrores_Class, "") != 0 )
            {
               subGriderrores_Linesclass = subGriderrores_Class+"Odd" ;
            }
         }
         else if ( subGriderrores_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGriderrores_Backstyle = (byte)(0) ;
            subGriderrores_Backcolor = subGriderrores_Allbackcolor ;
            if ( GXutil.strcmp(subGriderrores_Class, "") != 0 )
            {
               subGriderrores_Linesclass = subGriderrores_Class+"Uniform" ;
            }
         }
         else if ( subGriderrores_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGriderrores_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGriderrores_Class, "") != 0 )
            {
               subGriderrores_Linesclass = subGriderrores_Class+"Odd" ;
            }
            subGriderrores_Backcolor = (int)(0x0) ;
         }
         else if ( subGriderrores_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGriderrores_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_12_idx) % (2))) == 0 )
            {
               subGriderrores_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGriderrores_Class, "") != 0 )
               {
                  subGriderrores_Linesclass = subGriderrores_Class+"Even" ;
               }
            }
            else
            {
               subGriderrores_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGriderrores_Class, "") != 0 )
               {
                  subGriderrores_Linesclass = subGriderrores_Class+"Odd" ;
               }
            }
         }
         if ( GriderroresContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_12_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GriderroresContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GriderroresRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdt_errores__mensaje_Internalname,((web.Sdtsdt_errores_sdt_erroresItem)AV22sdt_errores.elementAt(-1+AV30GXV1)).getgxTv_Sdtsdt_errores_sdt_erroresItem_Mensaje(),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavSdt_errores__mensaje_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdt_errores__mensaje_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(12),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes6X2( ) ;
         GriderroresContainer.AddRow(GriderroresRow);
         nGXsfl_12_idx = ((subGriderrores_Islastpage==1)&&(nGXsfl_12_idx+1>subgriderrores_fnc_recordsperpage( )) ? 1 : nGXsfl_12_idx+1) ;
         sGXsfl_12_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_12_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_122( ) ;
      }
      /* End function sendrow_122 */
   }

   public void startgridcontrol12( )
   {
      if ( GriderroresContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+sPrefix+"GriderroresContainer"+"DivS\" data-gxgridid=\"12\">") ;
         sStyleString = "" ;
         if ( subGriderrores_Visible == 0 )
         {
            sStyleString += "display:none;" ;
         }
         web.GxWebStd.gx_table_start( httpContext, subGriderrores_Internalname, subGriderrores_Internalname, "", "WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
         /* Subfile titles */
         httpContext.writeText( "<tr") ;
         httpContext.writeTextNL( ">") ;
         if ( subGriderrores_Backcolorstyle == 0 )
         {
            subGriderrores_Titlebackstyle = (byte)(0) ;
            if ( GXutil.len( subGriderrores_Class) > 0 )
            {
               subGriderrores_Linesclass = subGriderrores_Class+"Title" ;
            }
         }
         else
         {
            subGriderrores_Titlebackstyle = (byte)(1) ;
            if ( subGriderrores_Backcolorstyle == 1 )
            {
               subGriderrores_Titlebackcolor = subGriderrores_Allbackcolor ;
               if ( GXutil.len( subGriderrores_Class) > 0 )
               {
                  subGriderrores_Linesclass = subGriderrores_Class+"UniformTitle" ;
               }
            }
            else
            {
               if ( GXutil.len( subGriderrores_Class) > 0 )
               {
                  subGriderrores_Linesclass = subGriderrores_Class+"Title" ;
               }
            }
         }
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( edtavSdt_errores__mensaje_Title) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
         GriderroresContainer.AddObjectProperty("GridName", "Griderrores");
      }
      else
      {
         GriderroresContainer.AddObjectProperty("GridName", "Griderrores");
         GriderroresContainer.AddObjectProperty("Header", subGriderrores_Header);
         GriderroresContainer.AddObjectProperty("Class", "WorkWith");
         GriderroresContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         GriderroresContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         GriderroresContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGriderrores_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         GriderroresContainer.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( subGriderrores_Visible, (byte)(5), (byte)(0), ".", "")));
         GriderroresContainer.AddObjectProperty("CmpContext", sPrefix);
         GriderroresContainer.AddObjectProperty("InMasterPage", "false");
         GriderroresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GriderroresColumn.AddObjectProperty("Title", GXutil.rtrim( edtavSdt_errores__mensaje_Title));
         GriderroresColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdt_errores__mensaje_Enabled, (byte)(5), (byte)(0), ".", "")));
         GriderroresContainer.AddColumnProperties(GriderroresColumn);
         GriderroresContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGriderrores_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         GriderroresContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGriderrores_Allowselection, (byte)(1), (byte)(0), ".", "")));
         GriderroresContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGriderrores_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         GriderroresContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGriderrores_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         GriderroresContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGriderrores_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         GriderroresContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGriderrores_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         GriderroresContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGriderrores_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void init_default_properties( )
   {
      lblCompletedimage_Internalname = sPrefix+"COMPLETEDIMAGE" ;
      edtavSdt_errores__mensaje_Internalname = sPrefix+"SDT_ERRORES__MENSAJE" ;
      lblCompletedtitle_Internalname = sPrefix+"COMPLETEDTITLE" ;
      lblCompleteddescription_Internalname = sPrefix+"COMPLETEDDESCRIPTION" ;
      edtavArchivochar_Internalname = sPrefix+"vARCHIVOCHAR" ;
      Btnwizardlastnext_Internalname = sPrefix+"BTNWIZARDLASTNEXT" ;
      bttBtndescargar_Internalname = sPrefix+"BTNDESCARGAR" ;
      divTableactions_Internalname = sPrefix+"TABLEACTIONS" ;
      divTablemain_Internalname = sPrefix+"TABLEMAIN" ;
      Griderrores_empowerer_Internalname = sPrefix+"GRIDERRORES_EMPOWERER" ;
      divHtml_bottomauxiliarcontrols_Internalname = sPrefix+"HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = sPrefix+"LAYOUTMAINTABLE" ;
      Form.setInternalname( sPrefix+"FORM" );
      subGriderrores_Internalname = sPrefix+"GRIDERRORES" ;
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.setDefaultTheme("WorkWithPlusDS");
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
      }
      init_default_properties( ) ;
      subGriderrores_Allowcollapsing = (byte)(0) ;
      subGriderrores_Allowselection = (byte)(0) ;
      subGriderrores_Header = "" ;
      edtavSdt_errores__mensaje_Title = httpContext.getMessage( "Error", "") ;
      edtavSdt_errores__mensaje_Jsonclick = "" ;
      edtavSdt_errores__mensaje_Enabled = 0 ;
      subGriderrores_Class = "WorkWith" ;
      subGriderrores_Backcolorstyle = (byte)(0) ;
      edtavSdt_errores__mensaje_Title = httpContext.getMessage( "Error", "") ;
      Btnwizardlastnext_Visible = GXutil.toBoolean( -1) ;
      edtavSdt_errores__mensaje_Enabled = -1 ;
      bttBtndescargar_Visible = 1 ;
      Btnwizardlastnext_Class = "Button ButtonWizard" ;
      Btnwizardlastnext_Caption = httpContext.getMessage( "WWP_WizardFinishCaption", "") ;
      Btnwizardlastnext_Aftericonclass = "fas fa-arrow-right" ;
      edtavArchivochar_Enabled = 1 ;
      edtavArchivochar_Visible = 1 ;
      lblCompleteddescription_Visible = 1 ;
      lblCompletedtitle_Visible = 1 ;
      subGriderrores_Visible = 1 ;
      lblCompletedimage_Caption = httpContext.getMessage( "<i class='fas fa-check' style='font-size: 100px'></i>", "") ;
      subGriderrores_Rows = 0 ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRIDERRORES_nFirstRecordOnPage'},{av:'GRIDERRORES_nEOF'},{av:'subGriderrores_Rows',ctrl:'GRIDERRORES',prop:'Rows'},{av:'sPrefix'},{av:'AV22sdt_errores',fld:'vSDT_ERRORES',grid:12,pic:'',hsh:true},{av:'nGXsfl_12_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:12},{av:'nRC_GXsfl_12',ctrl:'GRIDERRORES',prop:'GridRC',grid:12},{av:'AV11HasValidationErrors',fld:'vHASVALIDATIONERRORS',pic:'',hsh:true},{av:'AV17archivo',fld:'vARCHIVO',pic:'',hsh:true},{av:'AV18archivofullpath',fld:'vARCHIVOFULLPATH',pic:'',hsh:true},{av:'AV5ArchivoChar',fld:'vARCHIVOCHAR',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'Btnwizardlastnext_Visible',ctrl:'BTNWIZARDLASTNEXT',prop:'Visible'}]}");
      setEventMetadata("GRIDERRORES.LOAD","{handler:'e156X2',iparms:[]");
      setEventMetadata("GRIDERRORES.LOAD",",oparms:[]}");
      setEventMetadata("ENTER","{handler:'e116X2',iparms:[{av:'AV11HasValidationErrors',fld:'vHASVALIDATIONERRORS',pic:'',hsh:true},{av:'AV15WebSessionKey',fld:'vWEBSESSIONKEY',pic:''},{av:'AV5ArchivoChar',fld:'vARCHIVOCHAR',pic:''},{av:'AV22sdt_errores',fld:'vSDT_ERRORES',grid:12,pic:'',hsh:true},{av:'nGXsfl_12_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:12},{av:'GRIDERRORES_nFirstRecordOnPage'},{av:'nRC_GXsfl_12',ctrl:'GRIDERRORES',prop:'GridRC',grid:12}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("'DODESCARGAR'","{handler:'e126X2',iparms:[{av:'AV17archivo',fld:'vARCHIVO',pic:'',hsh:true},{av:'AV18archivofullpath',fld:'vARCHIVOFULLPATH',pic:'',hsh:true}]");
      setEventMetadata("'DODESCARGAR'",",oparms:[]}");
      setEventMetadata("GRIDERRORES_FIRSTPAGE","{handler:'subgriderrores_firstpage',iparms:[{av:'GRIDERRORES_nFirstRecordOnPage'},{av:'GRIDERRORES_nEOF'},{av:'subGriderrores_Rows',ctrl:'GRIDERRORES',prop:'Rows'},{av:'AV11HasValidationErrors',fld:'vHASVALIDATIONERRORS',pic:'',hsh:true},{av:'AV17archivo',fld:'vARCHIVO',pic:'',hsh:true},{av:'AV18archivofullpath',fld:'vARCHIVOFULLPATH',pic:'',hsh:true},{av:'AV5ArchivoChar',fld:'vARCHIVOCHAR',pic:''},{av:'sPrefix'},{av:'AV22sdt_errores',fld:'vSDT_ERRORES',grid:12,pic:'',hsh:true},{av:'nGXsfl_12_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:12},{av:'nRC_GXsfl_12',ctrl:'GRIDERRORES',prop:'GridRC',grid:12}]");
      setEventMetadata("GRIDERRORES_FIRSTPAGE",",oparms:[{av:'Btnwizardlastnext_Visible',ctrl:'BTNWIZARDLASTNEXT',prop:'Visible'}]}");
      setEventMetadata("GRIDERRORES_PREVPAGE","{handler:'subgriderrores_previouspage',iparms:[{av:'GRIDERRORES_nFirstRecordOnPage'},{av:'GRIDERRORES_nEOF'},{av:'subGriderrores_Rows',ctrl:'GRIDERRORES',prop:'Rows'},{av:'AV11HasValidationErrors',fld:'vHASVALIDATIONERRORS',pic:'',hsh:true},{av:'AV17archivo',fld:'vARCHIVO',pic:'',hsh:true},{av:'AV18archivofullpath',fld:'vARCHIVOFULLPATH',pic:'',hsh:true},{av:'AV5ArchivoChar',fld:'vARCHIVOCHAR',pic:''},{av:'sPrefix'},{av:'AV22sdt_errores',fld:'vSDT_ERRORES',grid:12,pic:'',hsh:true},{av:'nGXsfl_12_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:12},{av:'nRC_GXsfl_12',ctrl:'GRIDERRORES',prop:'GridRC',grid:12}]");
      setEventMetadata("GRIDERRORES_PREVPAGE",",oparms:[{av:'Btnwizardlastnext_Visible',ctrl:'BTNWIZARDLASTNEXT',prop:'Visible'}]}");
      setEventMetadata("GRIDERRORES_NEXTPAGE","{handler:'subgriderrores_nextpage',iparms:[{av:'GRIDERRORES_nFirstRecordOnPage'},{av:'GRIDERRORES_nEOF'},{av:'subGriderrores_Rows',ctrl:'GRIDERRORES',prop:'Rows'},{av:'AV11HasValidationErrors',fld:'vHASVALIDATIONERRORS',pic:'',hsh:true},{av:'AV17archivo',fld:'vARCHIVO',pic:'',hsh:true},{av:'AV18archivofullpath',fld:'vARCHIVOFULLPATH',pic:'',hsh:true},{av:'AV5ArchivoChar',fld:'vARCHIVOCHAR',pic:''},{av:'sPrefix'},{av:'AV22sdt_errores',fld:'vSDT_ERRORES',grid:12,pic:'',hsh:true},{av:'nGXsfl_12_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:12},{av:'nRC_GXsfl_12',ctrl:'GRIDERRORES',prop:'GridRC',grid:12}]");
      setEventMetadata("GRIDERRORES_NEXTPAGE",",oparms:[{av:'Btnwizardlastnext_Visible',ctrl:'BTNWIZARDLASTNEXT',prop:'Visible'}]}");
      setEventMetadata("GRIDERRORES_LASTPAGE","{handler:'subgriderrores_lastpage',iparms:[{av:'GRIDERRORES_nFirstRecordOnPage'},{av:'GRIDERRORES_nEOF'},{av:'subGriderrores_Rows',ctrl:'GRIDERRORES',prop:'Rows'},{av:'AV11HasValidationErrors',fld:'vHASVALIDATIONERRORS',pic:'',hsh:true},{av:'AV17archivo',fld:'vARCHIVO',pic:'',hsh:true},{av:'AV18archivofullpath',fld:'vARCHIVOFULLPATH',pic:'',hsh:true},{av:'AV5ArchivoChar',fld:'vARCHIVOCHAR',pic:''},{av:'sPrefix'},{av:'AV22sdt_errores',fld:'vSDT_ERRORES',grid:12,pic:'',hsh:true},{av:'nGXsfl_12_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:12},{av:'nRC_GXsfl_12',ctrl:'GRIDERRORES',prop:'GridRC',grid:12}]");
      setEventMetadata("GRIDERRORES_LASTPAGE",",oparms:[{av:'Btnwizardlastnext_Visible',ctrl:'BTNWIZARDLASTNEXT',prop:'Visible'}]}");
      setEventMetadata("NULL","{handler:'validv_Gxv2',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
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
      wcpOAV15WebSessionKey = "" ;
      wcpOAV12PreviousStep = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV15WebSessionKey = "" ;
      AV12PreviousStep = "" ;
      AV22sdt_errores = new GXBaseCollection<web.Sdtsdt_errores_sdt_erroresItem>(web.Sdtsdt_errores_sdt_erroresItem.class, "sdt_erroresItem", "PayDay", remoteHandle);
      AV17archivo = "" ;
      AV18archivofullpath = "" ;
      AV5ArchivoChar = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      GX_FocusControl = "" ;
      lblCompletedimage_Jsonclick = "" ;
      GriderroresContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      lblCompletedtitle_Jsonclick = "" ;
      lblCompleteddescription_Jsonclick = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucBtnwizardlastnext = new com.genexus.webpanels.GXUserControl();
      bttBtndescargar_Jsonclick = "" ;
      ucGriderrores_empowerer = new com.genexus.webpanels.GXUserControl();
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      hsh = "" ;
      Griderrores_empowerer_Gridinternalname = "" ;
      AV19errores = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_svchar3 = new GXSimpleCollection[1] ;
      AV21itemError = new web.Sdtsdt_errores_sdt_erroresItem(remoteHandle, context);
      AV9error = "" ;
      GXv_char4 = new String[1] ;
      GXv_char5 = new String[1] ;
      GXv_int2 = new int[1] ;
      GriderroresRow = new com.genexus.webpanels.GXWebRow();
      AV13proximoPaso = "" ;
      AV14WebSession = httpContext.getWebSession();
      AV16WizardData = new web.SdtConceptosAfipWizardData(remoteHandle, context);
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV15WebSessionKey = "" ;
      sCtrlAV12PreviousStep = "" ;
      sCtrlAV10GoingBack = "" ;
      subGriderrores_Linesclass = "" ;
      ROClassString = "" ;
      GriderroresColumn = new com.genexus.webpanels.GXWebColumn();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavSdt_errores__mensaje_Enabled = 0 ;
      edtavArchivochar_Enabled = 0 ;
   }

   private byte GRIDERRORES_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte subGriderrores_Backcolorstyle ;
   private byte nGXWrapped ;
   private byte subGriderrores_Backstyle ;
   private byte subGriderrores_Titlebackstyle ;
   private byte subGriderrores_Allowselection ;
   private byte subGriderrores_Allowhovering ;
   private byte subGriderrores_Allowcollapsing ;
   private byte subGriderrores_Collapsed ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV20e ;
   private int nRC_GXsfl_12 ;
   private int subGriderrores_Rows ;
   private int nGXsfl_12_idx=1 ;
   private int AV30GXV1 ;
   private int subGriderrores_Visible ;
   private int lblCompletedtitle_Visible ;
   private int lblCompleteddescription_Visible ;
   private int edtavArchivochar_Visible ;
   private int edtavArchivochar_Enabled ;
   private int bttBtndescargar_Visible ;
   private int subGriderrores_Islastpage ;
   private int edtavSdt_errores__mensaje_Enabled ;
   private int GRIDERRORES_nGridOutOfScope ;
   private int nGXsfl_12_fel_idx=1 ;
   private int AV6CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int idxLst ;
   private int subGriderrores_Backcolor ;
   private int subGriderrores_Allbackcolor ;
   private int subGriderrores_Titlebackcolor ;
   private int subGriderrores_Selectedindex ;
   private int subGriderrores_Selectioncolor ;
   private int subGriderrores_Hoveringcolor ;
   private long GRIDERRORES_nFirstRecordOnPage ;
   private long GRIDERRORES_nCurrentRecord ;
   private long GRIDERRORES_nRecordCount ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String sGXsfl_12_idx="0001" ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String lblCompletedimage_Internalname ;
   private String lblCompletedimage_Caption ;
   private String lblCompletedimage_Jsonclick ;
   private String sStyleString ;
   private String subGriderrores_Internalname ;
   private String lblCompletedtitle_Internalname ;
   private String lblCompletedtitle_Jsonclick ;
   private String lblCompleteddescription_Internalname ;
   private String lblCompleteddescription_Jsonclick ;
   private String edtavArchivochar_Internalname ;
   private String TempTags ;
   private String ClassString ;
   private String StyleString ;
   private String divTableactions_Internalname ;
   private String Btnwizardlastnext_Aftericonclass ;
   private String Btnwizardlastnext_Caption ;
   private String Btnwizardlastnext_Class ;
   private String Btnwizardlastnext_Internalname ;
   private String bttBtndescargar_Internalname ;
   private String bttBtndescargar_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Griderrores_empowerer_Internalname ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavSdt_errores__mensaje_Internalname ;
   private String sGXsfl_12_fel_idx="0001" ;
   private String hsh ;
   private String Griderrores_empowerer_Gridinternalname ;
   private String GXv_char4[] ;
   private String GXv_char5[] ;
   private String AV13proximoPaso ;
   private String edtavSdt_errores__mensaje_Title ;
   private String sCtrlAV15WebSessionKey ;
   private String sCtrlAV12PreviousStep ;
   private String sCtrlAV10GoingBack ;
   private String subGriderrores_Class ;
   private String subGriderrores_Linesclass ;
   private String ROClassString ;
   private String edtavSdt_errores__mensaje_Jsonclick ;
   private String subGriderrores_Header ;
   private boolean wcpOAV10GoingBack ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV10GoingBack ;
   private boolean AV11HasValidationErrors ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_12_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_BV12 ;
   private boolean gx_refresh_fired ;
   private boolean Btnwizardlastnext_Visible ;
   private String AV5ArchivoChar ;
   private String wcpOAV15WebSessionKey ;
   private String wcpOAV12PreviousStep ;
   private String AV15WebSessionKey ;
   private String AV12PreviousStep ;
   private String AV17archivo ;
   private String AV18archivofullpath ;
   private String AV9error ;
   private com.genexus.webpanels.GXWebGrid GriderroresContainer ;
   private com.genexus.webpanels.GXWebRow GriderroresRow ;
   private com.genexus.webpanels.GXWebColumn GriderroresColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV14WebSession ;
   private com.genexus.webpanels.GXUserControl ucBtnwizardlastnext ;
   private com.genexus.webpanels.GXUserControl ucGriderrores_empowerer ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private GXSimpleCollection<String> AV19errores ;
   private GXSimpleCollection<String> GXv_objcol_svchar3[] ;
   private GXBaseCollection<web.Sdtsdt_errores_sdt_erroresItem> AV22sdt_errores ;
   private web.SdtConceptosAfipWizardData AV16WizardData ;
   private web.Sdtsdt_errores_sdt_erroresItem AV21itemError ;
}

