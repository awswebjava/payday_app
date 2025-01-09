package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwp_selectimportfile2_impl extends GXWebComponent
{
   public wwp_selectimportfile2_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwp_selectimportfile2_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_selectimportfile2_impl.class ));
   }

   public wwp_selectimportfile2_impl( int remoteHandle ,
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
            gxfirstwebparm = httpContext.GetFirstPar( "TransactionName") ;
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
               AV25TransactionName = httpContext.GetPar( "TransactionName") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25TransactionName", AV25TransactionName);
               AV18ImportType = httpContext.GetPar( "ImportType") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18ImportType", AV18ImportType);
               AV14ExtraParmsJson = httpContext.GetPar( "ExtraParmsJson") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14ExtraParmsJson", AV14ExtraParmsJson);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,AV25TransactionName,AV18ImportType,AV14ExtraParmsJson});
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
               gxfirstwebparm = httpContext.GetFirstPar( "TransactionName") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "TransactionName") ;
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

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa872( ) ;
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
         httpContext.writeText( " "+"class=\"form-horizontal FormNoBackgroundColor\""+" "+ "style='"+bodyStyle+"'") ;
         httpContext.writeText( FormProcess+">") ;
         httpContext.skipLines( 1 );
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal FormNoBackgroundColor\" data-gx-class=\"form-horizontal FormNoBackgroundColor\" novalidate action=\""+formatLink("web.wwpbaseobjects.wwp_selectimportfile2", new String[] {GXutil.URLEncode(GXutil.rtrim(AV25TransactionName)),GXutil.URLEncode(GXutil.rtrim(AV18ImportType)),GXutil.URLEncode(GXutil.rtrim(AV14ExtraParmsJson))}, new String[] {"TransactionName","ImportType","ExtraParmsJson"}) +"\">") ;
         web.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
         web.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
         web.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
         httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, "FORM", "Class", "form-horizontal FormNoBackgroundColor", true);
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
         web.GxWebStd.classAttribute( httpContext, "gxwebcomponent-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal FormNoBackgroundColor" : Form.getThemeClass())+"-fx");
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
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV25TransactionName", wcpOAV25TransactionName);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV18ImportType", wcpOAV18ImportType);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV14ExtraParmsJson", wcpOAV14ExtraParmsJson);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vIMPORTTYPE", AV18ImportType);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vEXTRAPARMSJSON", AV14ExtraParmsJson);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTRANSACTIONNAME", AV25TransactionName);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vRESULTADOEJECUCION", AV27resultadoEjecucion);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vERRORMSGS", AV13ErrorMsgs);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vERRORMSGS", AV13ErrorMsgs);
      }
      GXCCtlgxBlob = "vFILTERTOUPLOAD" + "_gxBlob" ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+GXCCtlgxBlob, AV15FilterToUpload);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vFILTERTOUPLOAD_Filename", GXutil.rtrim( edtavFiltertoupload_Filename));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vFILTERTOUPLOAD_Filename", GXutil.rtrim( edtavFiltertoupload_Filename));
   }

   public void renderHtmlCloseForm872( )
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
      return "WWPBaseObjects.WWP_SelectImportFile2" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Importar archivo", "") ;
   }

   public void wb870( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.wwpbaseobjects.wwp_selectimportfile2");
         }
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", divLayoutmaintable_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMainTransactionPopUp", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, sPrefix, "false");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableattributes_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell AttributeImportFileCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavFiltertoupload_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavFiltertoupload_Internalname, httpContext.getMessage( "Archivo", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         ClassString = "Attribute" ;
         StyleString = "" ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 17,'" + sPrefix + "',false,'',0)\"" ;
         edtavFiltertoupload_Filetype = "tmp" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavFiltertoupload_Internalname, "Filetype", edtavFiltertoupload_Filetype, true);
         if ( ! (GXutil.strcmp("", AV15FilterToUpload)==0) )
         {
            gxblobfileaux.setSource( AV15FilterToUpload );
            if ( ! gxblobfileaux.hasExtension() || ( GXutil.strcmp(edtavFiltertoupload_Filetype, "tmp") != 0 ) )
            {
               gxblobfileaux.setExt(GXutil.trim( edtavFiltertoupload_Filetype));
            }
            if ( gxblobfileaux.getErrCode() == 0 )
            {
               AV15FilterToUpload = gxblobfileaux.getURI() ;
               httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavFiltertoupload_Internalname, "URL", httpContext.getResourceRelative(AV15FilterToUpload), true);
               edtavFiltertoupload_Filetype = gxblobfileaux.getExtension() ;
               httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavFiltertoupload_Internalname, "Filetype", edtavFiltertoupload_Filetype, true);
               gxblobfileaux.setBlobToDelete();
            }
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavFiltertoupload_Internalname, "URL", httpContext.getResourceRelative(AV15FilterToUpload), true);
         }
         web.GxWebStd.gx_blob_field( httpContext, edtavFiltertoupload_Internalname, GXutil.rtrim( AV15FilterToUpload), httpContext.getResourceRelative(AV15FilterToUpload), ((GXutil.strcmp("", edtavFiltertoupload_Contenttype)==0) ? com.genexus.internet.HttpResponse.getContentType(((GXutil.strcmp("", edtavFiltertoupload_Filetype)==0) ? AV15FilterToUpload : edtavFiltertoupload_Filetype)) : edtavFiltertoupload_Contenttype), false, "", edtavFiltertoupload_Parameters, 0, edtavFiltertoupload_Enabled, 1, "", "", 0, -1, 250, "px", 60, "px", 0, 0, 0, edtavFiltertoupload_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", StyleString, ClassString, "", "", ""+TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,17);\"", "", "", "HLP_WWPBaseObjects\\WWP_SelectImportFile2.htm");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroupRight", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnenter_Internalname, "", httpContext.getMessage( "Importar", ""), bttBtnenter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\WWP_SelectImportFile2.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 24,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "BtnDefault" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnucancel_Internalname, "", httpContext.getMessage( "Cancelar", ""), bttBtnucancel_Jsonclick, 7, httpContext.getMessage( "Cancelar", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e11871_client"+"'", TempTags, "", 2, "HLP_WWPBaseObjects\\WWP_SelectImportFile2.htm");
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

   public void start872( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Importar archivo", ""), (short)(0)) ;
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
            strup870( ) ;
         }
      }
   }

   public void ws872( )
   {
      start872( ) ;
      evt872( ) ;
   }

   public void evt872( )
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
                              strup870( ) ;
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
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup870( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e12872 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup870( ) ;
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
                                       e13872 ();
                                    }
                                    dynload_actions( ) ;
                                 }
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup870( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e14872 ();
                              }
                           }
                           /* No code required for Cancel button. It is implemented as the Reset button. */
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup870( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = edtavFiltertoupload_Internalname ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                              }
                           }
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

   public void we872( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm872( ) ;
         }
      }
   }

   public void pa872( )
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
            GX_FocusControl = edtavFiltertoupload_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
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
      rf872( ) ;
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
   }

   public void rf872( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e14872 ();
         wb870( ) ;
      }
   }

   public void send_integrity_lvl_hashes872( )
   {
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup870( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e12872 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOAV25TransactionName = httpContext.cgiGet( sPrefix+"wcpOAV25TransactionName") ;
         wcpOAV18ImportType = httpContext.cgiGet( sPrefix+"wcpOAV18ImportType") ;
         wcpOAV14ExtraParmsJson = httpContext.cgiGet( sPrefix+"wcpOAV14ExtraParmsJson") ;
         edtavFiltertoupload_Filename = httpContext.cgiGet( sPrefix+"vFILTERTOUPLOAD_Filename") ;
         /* Read variables values. */
         AV15FilterToUpload = httpContext.cgiGet( edtavFiltertoupload_Internalname) ;
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         if ( (GXutil.strcmp("", AV15FilterToUpload)==0) )
         {
            GXCCtlgxBlob = "vFILTERTOUPLOAD" + "_gxBlob" ;
            AV15FilterToUpload = httpContext.cgiGet( sPrefix+GXCCtlgxBlob) ;
         }
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e12872 ();
      if (returnInSub) return;
   }

   public void e12872( )
   {
      /* Start Routine */
      returnInSub = false ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      Form.setCaption( httpContext.getMessage( "Importar archivo", "") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, "FORM", "Caption", Form.getCaption(), true);
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e13872 ();
      if (returnInSub) return;
   }

   public void e13872( )
   {
      /* Enter Routine */
      returnInSub = false ;
      AV16FilterToUploadExt = edtavFiltertoupload_Filename ;
      AV16FilterToUploadExt = ((GXutil.strSearch( AV16FilterToUploadExt, ".", 1)>0) ? GXutil.substring( AV16FilterToUploadExt, GXutil.strSearchRev( AV16FilterToUploadExt, ".", -1)+1, GXutil.len( AV16FilterToUploadExt)-GXutil.strSearchRev( AV16FilterToUploadExt, ".", -1)) : "") ;
      httpContext.GX_msglist.addItem("<#CLEAR#>");
      if ( ! (GXutil.strcmp("", AV15FilterToUpload)==0) )
      {
         if ( GXutil.strcmp(GXutil.trim( GXutil.upper( AV16FilterToUploadExt)), GXutil.trim( GXutil.upper( AV18ImportType))) == 0 )
         {
            AV22ResultMsg = "" ;
            AV26ExtraParms.fromJSonString(AV14ExtraParmsJson, null);
            AV5CliCod = (int)(GXutil.lval( (String)AV26ExtraParms.elementAt(-1+1))) ;
            AV6EmpCod = (short)(GXutil.lval( (String)AV26ExtraParms.elementAt(-1+2))) ;
            AV17ImpLiqSec = (short)(GXutil.lval( (String)AV26ExtraParms.elementAt(-1+3))) ;
            if ( GXutil.strcmp(AV25TransactionName, httpContext.getMessage( "ImportCC", "")) == 0 )
            {
               GXt_boolean1 = AV27resultadoEjecucion ;
               GXv_objcol_SdtMessages_Message2[0] = AV13ErrorMsgs ;
               GXv_boolean3[0] = GXt_boolean1 ;
               new web.importararchivoconceptosafip(remoteHandle, context).execute( AV5CliCod, AV6EmpCod, AV17ImpLiqSec, AV15FilterToUpload, GXv_objcol_SdtMessages_Message2, GXv_boolean3) ;
               AV13ErrorMsgs = GXv_objcol_SdtMessages_Message2[0] ;
               wwp_selectimportfile2_impl.this.GXt_boolean1 = GXv_boolean3[0] ;
               AV27resultadoEjecucion = GXt_boolean1 ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV27resultadoEjecucion", AV27resultadoEjecucion);
            }
            else if ( GXutil.strcmp(AV25TransactionName, httpContext.getMessage( "ImportLSD", "")) == 0 )
            {
               GXt_boolean1 = AV27resultadoEjecucion ;
               GXv_objcol_SdtMessages_Message2[0] = AV13ErrorMsgs ;
               GXv_boolean3[0] = GXt_boolean1 ;
               new web.importararchivolsd(remoteHandle, context).execute( AV5CliCod, AV6EmpCod, AV17ImpLiqSec, AV15FilterToUpload, "", GXv_objcol_SdtMessages_Message2, GXv_boolean3) ;
               AV13ErrorMsgs = GXv_objcol_SdtMessages_Message2[0] ;
               wwp_selectimportfile2_impl.this.GXt_boolean1 = GXv_boolean3[0] ;
               AV27resultadoEjecucion = GXt_boolean1 ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV27resultadoEjecucion", AV27resultadoEjecucion);
            }
            else
            {
               new web.alert(remoteHandle, context).execute( "error", httpContext.getMessage( "No se reconoce la acción ", "")+AV25TransactionName) ;
            }
            if ( AV27resultadoEjecucion )
            {
               AV20LastErrorType = (byte)(2) ;
               AV30GXV1 = 1 ;
               while ( AV30GXV1 <= AV13ErrorMsgs.size() )
               {
                  AV21Message = (com.genexus.SdtMessages_Message)((com.genexus.SdtMessages_Message)AV13ErrorMsgs.elementAt(-1+AV30GXV1));
                  if ( ! (GXutil.strcmp("", AV22ResultMsg)==0) )
                  {
                     AV22ResultMsg += GXutil.newLine( ) ;
                     if ( ( AV20LastErrorType == 0 ) && ( AV21Message.getgxTv_SdtMessages_Message_Type() == 2 ) )
                     {
                        AV22ResultMsg += GXutil.newLine( ) ;
                     }
                  }
                  AV20LastErrorType = AV21Message.getgxTv_SdtMessages_Message_Type() ;
                  AV22ResultMsg += AV21Message.getgxTv_SdtMessages_Message_Description() ;
                  AV30GXV1 = (int)(AV30GXV1+1) ;
               }
               httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( httpContext.getMessage( "WWP_ImportFile_ImportSuccessTitle", ""), AV22ResultMsg, "success", "", "na", ""));
               this.executeExternalObjectMethod(sPrefix, false, "WWPActions", "WCPopup_Close", new Object[] {AV22ResultMsg}, false);
            }
            else
            {
               AV15FilterToUpload = "" ;
               httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavFiltertoupload_Internalname, "URL", httpContext.getResourceRelative(AV15FilterToUpload), true);
               AV31GXV2 = 1 ;
               while ( AV31GXV2 <= AV13ErrorMsgs.size() )
               {
                  AV21Message = (com.genexus.SdtMessages_Message)((com.genexus.SdtMessages_Message)AV13ErrorMsgs.elementAt(-1+AV31GXV2));
                  if ( ! (GXutil.strcmp("", AV22ResultMsg)==0) )
                  {
                     AV22ResultMsg += GXutil.newLine( ) ;
                     if ( GXutil.strcmp(AV21Message.getgxTv_SdtMessages_Message_Id(), "WWP_LineId") == 0 )
                     {
                        AV22ResultMsg += GXutil.newLine( ) ;
                     }
                  }
                  AV22ResultMsg += AV21Message.getgxTv_SdtMessages_Message_Description() ;
                  AV31GXV2 = (int)(AV31GXV2+1) ;
               }
               httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( httpContext.getMessage( "WWP_ImportFile_ErrorImportingTitle", ""), AV22ResultMsg, "error", "", "false", ""));
            }
         }
         else
         {
            AV15FilterToUpload = "" ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavFiltertoupload_Internalname, "URL", httpContext.getResourceRelative(AV15FilterToUpload), true);
            AV22ResultMsg = GXutil.format( httpContext.getMessage( "WWP_ImportFile_ExpectedFileType", ""), httpContext.getMessage( "txt", ""), "", "", "", "", "", "", "", "") ;
            httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( httpContext.getMessage( "WWP_ImportFile_ErrorImportingTitle", ""), AV22ResultMsg, "error", "", "na", ""));
         }
      }
      else
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "File", ""), "", "", "", "", "", "", "", ""));
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV13ErrorMsgs", AV13ErrorMsgs);
   }

   protected void nextLoad( )
   {
   }

   protected void e14872( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV25TransactionName = (String)getParm(obj,0,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25TransactionName", AV25TransactionName);
      AV18ImportType = (String)getParm(obj,1,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18ImportType", AV18ImportType);
      AV14ExtraParmsJson = (String)getParm(obj,2,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14ExtraParmsJson", AV14ExtraParmsJson);
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
      pa872( ) ;
      ws872( ) ;
      we872( ) ;
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
      sCtrlAV25TransactionName = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlAV18ImportType = (String)getParm(obj,1,TypeConstants.STRING) ;
      sCtrlAV14ExtraParmsJson = (String)getParm(obj,2,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa872( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "wwpbaseobjects\\wwp_selectimportfile2", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa872( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV25TransactionName = (String)getParm(obj,2,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25TransactionName", AV25TransactionName);
         AV18ImportType = (String)getParm(obj,3,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18ImportType", AV18ImportType);
         AV14ExtraParmsJson = (String)getParm(obj,4,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14ExtraParmsJson", AV14ExtraParmsJson);
      }
      wcpOAV25TransactionName = httpContext.cgiGet( sPrefix+"wcpOAV25TransactionName") ;
      wcpOAV18ImportType = httpContext.cgiGet( sPrefix+"wcpOAV18ImportType") ;
      wcpOAV14ExtraParmsJson = httpContext.cgiGet( sPrefix+"wcpOAV14ExtraParmsJson") ;
      if ( ! GetJustCreated( ) && ( ( GXutil.strcmp(AV25TransactionName, wcpOAV25TransactionName) != 0 ) || ( GXutil.strcmp(AV18ImportType, wcpOAV18ImportType) != 0 ) || ( GXutil.strcmp(AV14ExtraParmsJson, wcpOAV14ExtraParmsJson) != 0 ) ) )
      {
         setjustcreated();
      }
      wcpOAV25TransactionName = AV25TransactionName ;
      wcpOAV18ImportType = AV18ImportType ;
      wcpOAV14ExtraParmsJson = AV14ExtraParmsJson ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlAV25TransactionName = httpContext.cgiGet( sPrefix+"AV25TransactionName_CTRL") ;
      if ( GXutil.len( sCtrlAV25TransactionName) > 0 )
      {
         AV25TransactionName = httpContext.cgiGet( sCtrlAV25TransactionName) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25TransactionName", AV25TransactionName);
      }
      else
      {
         AV25TransactionName = httpContext.cgiGet( sPrefix+"AV25TransactionName_PARM") ;
      }
      sCtrlAV18ImportType = httpContext.cgiGet( sPrefix+"AV18ImportType_CTRL") ;
      if ( GXutil.len( sCtrlAV18ImportType) > 0 )
      {
         AV18ImportType = httpContext.cgiGet( sCtrlAV18ImportType) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18ImportType", AV18ImportType);
      }
      else
      {
         AV18ImportType = httpContext.cgiGet( sPrefix+"AV18ImportType_PARM") ;
      }
      sCtrlAV14ExtraParmsJson = httpContext.cgiGet( sPrefix+"AV14ExtraParmsJson_CTRL") ;
      if ( GXutil.len( sCtrlAV14ExtraParmsJson) > 0 )
      {
         AV14ExtraParmsJson = httpContext.cgiGet( sCtrlAV14ExtraParmsJson) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14ExtraParmsJson", AV14ExtraParmsJson);
      }
      else
      {
         AV14ExtraParmsJson = httpContext.cgiGet( sPrefix+"AV14ExtraParmsJson_PARM") ;
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
      pa872( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws872( ) ;
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
      ws872( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV25TransactionName_PARM", AV25TransactionName);
      if ( GXutil.len( GXutil.rtrim( sCtrlAV25TransactionName)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV25TransactionName_CTRL", GXutil.rtrim( sCtrlAV25TransactionName));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV18ImportType_PARM", AV18ImportType);
      if ( GXutil.len( GXutil.rtrim( sCtrlAV18ImportType)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV18ImportType_CTRL", GXutil.rtrim( sCtrlAV18ImportType));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV14ExtraParmsJson_PARM", AV14ExtraParmsJson);
      if ( GXutil.len( GXutil.rtrim( sCtrlAV14ExtraParmsJson)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV14ExtraParmsJson_CTRL", GXutil.rtrim( sCtrlAV14ExtraParmsJson));
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
      we872( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122020451377", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/wwp_selectimportfile2.js", "?2024122020451377", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtavFiltertoupload_Internalname = sPrefix+"vFILTERTOUPLOAD" ;
      divTableattributes_Internalname = sPrefix+"TABLEATTRIBUTES" ;
      bttBtnenter_Internalname = sPrefix+"BTNENTER" ;
      bttBtnucancel_Internalname = sPrefix+"BTNUCANCEL" ;
      divTablemain_Internalname = sPrefix+"TABLEMAIN" ;
      divLayoutmaintable_Internalname = sPrefix+"LAYOUTMAINTABLE" ;
      Form.setInternalname( sPrefix+"FORM" );
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
      edtavFiltertoupload_Jsonclick = "" ;
      edtavFiltertoupload_Parameters = "" ;
      edtavFiltertoupload_Contenttype = "" ;
      edtavFiltertoupload_Filetype = "" ;
      edtavFiltertoupload_Enabled = 1 ;
      divLayoutmaintable_Class = "Table TableTransactionTemplate" ;
      edtavFiltertoupload_Filename = "" ;
      Form.setCaption( httpContext.getMessage( "Importar archivo", "") );
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUCANCEL'","{handler:'e11871',iparms:[]");
      setEventMetadata("'DOUCANCEL'",",oparms:[]}");
      setEventMetadata("ENTER","{handler:'e13872',iparms:[{av:'edtavFiltertoupload_Filename',ctrl:'vFILTERTOUPLOAD',prop:'Filename'},{av:'AV15FilterToUpload',fld:'vFILTERTOUPLOAD',pic:''},{av:'AV18ImportType',fld:'vIMPORTTYPE',pic:''},{av:'AV14ExtraParmsJson',fld:'vEXTRAPARMSJSON',pic:''},{av:'AV25TransactionName',fld:'vTRANSACTIONNAME',pic:''},{av:'AV27resultadoEjecucion',fld:'vRESULTADOEJECUCION',pic:''},{av:'AV13ErrorMsgs',fld:'vERRORMSGS',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV27resultadoEjecucion',fld:'vRESULTADOEJECUCION',pic:''},{av:'AV13ErrorMsgs',fld:'vERRORMSGS',pic:''},{av:'AV15FilterToUpload',fld:'vFILTERTOUPLOAD',pic:''}]}");
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
      wcpOAV25TransactionName = "" ;
      wcpOAV18ImportType = "" ;
      wcpOAV14ExtraParmsJson = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV25TransactionName = "" ;
      AV18ImportType = "" ;
      AV14ExtraParmsJson = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV13ErrorMsgs = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      GXCCtlgxBlob = "" ;
      AV15FilterToUpload = "" ;
      GX_FocusControl = "" ;
      ClassString = "" ;
      StyleString = "" ;
      TempTags = "" ;
      gxblobfileaux = new com.genexus.util.GXFile();
      bttBtnenter_Jsonclick = "" ;
      bttBtnucancel_Jsonclick = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV16FilterToUploadExt = "" ;
      AV22ResultMsg = "" ;
      AV26ExtraParms = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_SdtMessages_Message2 = new GXBaseCollection[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV21Message = new com.genexus.SdtMessages_Message(remoteHandle, context);
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV25TransactionName = "" ;
      sCtrlAV18ImportType = "" ;
      sCtrlAV14ExtraParmsJson = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte AV20LastErrorType ;
   private byte nGXWrapped ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV6EmpCod ;
   private short AV17ImpLiqSec ;
   private int edtavFiltertoupload_Enabled ;
   private int AV5CliCod ;
   private int AV30GXV1 ;
   private int AV31GXV2 ;
   private int idxLst ;
   private String edtavFiltertoupload_Filename ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GXCCtlgxBlob ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTableattributes_Internalname ;
   private String edtavFiltertoupload_Internalname ;
   private String TempTags ;
   private String edtavFiltertoupload_Filetype ;
   private String edtavFiltertoupload_Contenttype ;
   private String edtavFiltertoupload_Parameters ;
   private String edtavFiltertoupload_Jsonclick ;
   private String bttBtnenter_Internalname ;
   private String bttBtnenter_Jsonclick ;
   private String bttBtnucancel_Internalname ;
   private String bttBtnucancel_Jsonclick ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String sCtrlAV25TransactionName ;
   private String sCtrlAV18ImportType ;
   private String sCtrlAV14ExtraParmsJson ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV27resultadoEjecucion ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean3[] ;
   private String AV15FilterToUpload ;
   private String wcpOAV25TransactionName ;
   private String wcpOAV18ImportType ;
   private String wcpOAV14ExtraParmsJson ;
   private String AV25TransactionName ;
   private String AV18ImportType ;
   private String AV14ExtraParmsJson ;
   private String AV16FilterToUploadExt ;
   private String AV22ResultMsg ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.util.GXFile gxblobfileaux ;
   private GXSimpleCollection<String> AV26ExtraParms ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV13ErrorMsgs ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> GXv_objcol_SdtMessages_Message2[] ;
   private com.genexus.SdtMessages_Message AV21Message ;
}

