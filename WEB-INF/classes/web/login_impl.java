package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class login_impl extends GXWebPanel
{
   public login_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public login_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( login_impl.class ));
   }

   public login_impl( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void executeCmdLine( String args[] )
   {
      try
      {
         AV8defaultSecUserName = (String) args[0];
         AV32URL = (String) args[1];
      }
      catch ( ArrayIndexOutOfBoundsException e )
      {
      }

      nGotPars = 1 ;
      webExecute();
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
         gxfirstwebparm = httpContext.GetFirstPar( "defaultSecUserName") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "defaultSecUserName") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "defaultSecUserName") ;
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
            AV8defaultSecUserName = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8defaultSecUserName", AV8defaultSecUserName);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDEFAULTSECUSERNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8defaultSecUserName, ""))));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV32URL = httpContext.GetPar( "URL") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV32URL", AV32URL);
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
         pa302( ) ;
         validateSpaRequest();
         if ( ! isAjaxCallMode( ) )
         {
         }
         if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
         {
            ws302( ) ;
            if ( ! isAjaxCallMode( ) )
            {
               we302( ) ;
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
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.writeText( "<title>") ;
      httpContext.writeValue( httpContext.getMessage( "Iniciar sesión", "")) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.login", new String[] {GXutil.URLEncode(GXutil.rtrim(AV8defaultSecUserName)),GXutil.URLEncode(GXutil.rtrim(AV32URL))}, new String[] {"defaultSecUserName","URL"}) +"\">") ;
      web.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      web.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      web.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV37Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDEFAULTSECUSERNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8defaultSecUserName, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV37Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV37Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vDEFAULTSECUSERNAME", AV8defaultSecUserName);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDEFAULTSECUSERNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8defaultSecUserName, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vURL", AV32URL);
   }

   public void renderHtmlCloseForm302( )
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
      httpContext.writeTextNL( "</form>") ;
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
      httpContext.writeTextNL( "</body>") ;
      httpContext.writeTextNL( "</html>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
   }

   public String getPgmname( )
   {
      return "Login" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Iniciar sesión", "") ;
   }

   public void wb300( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         renderHtmlHeaders( ) ;
         renderHtmlOpenForm( ) ;
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
         web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 P0", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divLogincontainer_Internalname, 1, 0, "px", 0, "px", "loginContainer", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divLoginimagen_Internalname, 1, 0, "px", 0, "px", "loginImagen", "left", "top", "", "", "div");
         /* Static images/pictures */
         ClassString = "LoginImage" + " " + ((GXutil.strcmp(imgLoginimage_gximage, "")==0) ? "GX_Image_LoginImage2_Class" : "GX_Image_"+imgLoginimage_gximage+"_Class") ;
         StyleString = "" ;
         sImgUrl = context.getHttpContext().getImagePath( "c7589cfe-0d9b-4194-b875-c8beb49b7a66", "", context.getHttpContext().getTheme( )) ;
         web.GxWebStd.gx_bitmap( httpContext, imgLoginimage_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), imgLoginimage_Visible, 1, "", "", 0, 0, 0, "px", 0, "px", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", " "+"data-gx-image"+" ", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Login.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group gx-label-top", "left", "top", ""+" data-gx-for=\""+imgavImagenlogin_Internalname+"\"", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 100, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Static Bitmap Variable */
         ClassString = "LoginImage" + " " + ((GXutil.strcmp(imgavImagenlogin_gximage, "")==0) ? "" : "GX_Image_"+imgavImagenlogin_gximage+"_Class") ;
         StyleString = "" ;
         AV26ImagenLogin_IsBlob = (boolean)(((GXutil.strcmp("", AV26ImagenLogin)==0)&&(GXutil.strcmp("", AV38Imagenlogin_GXI)==0))||!(GXutil.strcmp("", AV26ImagenLogin)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV26ImagenLogin)==0) ? AV38Imagenlogin_GXI : httpContext.getResourceRelative(AV26ImagenLogin)) ;
         web.GxWebStd.gx_bitmap( httpContext, imgavImagenlogin_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV26ImagenLogin_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Login.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divLogininputs_Internalname, 1, 0, "px", 0, "px", "loginInputs", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablelogincontent_Internalname, 1, 0, "px", 0, "px", "TableLoginContent", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;justify-content:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "MB15", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablelogintextos_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table1_20_302( true) ;
      }
      else
      {
         wb_table1_20_302( false) ;
      }
      return  ;
   }

   public void wb_table1_20_302e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblock1_Internalname, httpContext.getMessage( "Solo quedaría iniciar sesión, Adelante!", ""), "", "", lblTextblock1_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "loginText2", 0, "", 1, 1, 0, (short)(0), "HLP_Login.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableinputs_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "CellPaddingLogin DscTop", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtablesecusername_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblocksecusername_Internalname, httpContext.getMessage( "Usuario", ""), "", "", lblTextblocksecusername_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Login.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavSecusername_Internalname, httpContext.getMessage( "Sec User Name", ""), "col-sm-3 h40Label", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavSecusername_Internalname, AV14SecUserName, GXutil.rtrim( localUtil.format( AV14SecUserName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,37);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", httpContext.getMessage( "ejemplo@payday.ar", ""), edtavSecusername_Jsonclick, 0, "h40", "", "", "", "", 1, edtavSecusername_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Login.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "CellPaddingLogin DscTop", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtablesecuserpassword_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblocksecuserpassword_Internalname, httpContext.getMessage( "WWP_GAM_Password", ""), "", "", lblTextblocksecuserpassword_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Login.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavSecuserpassword_Internalname, httpContext.getMessage( "Sec User Password", ""), "col-sm-3 h40Label", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavSecuserpassword_Internalname, AV15SecUserPassword, GXutil.rtrim( localUtil.format( AV15SecUserPassword, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,45);\""+" "+"data-gx-password-reveal"+" "+"idenableshowpasswordhint=\"True\""+" ", "'"+""+"'"+",false,"+"'"+""+"'", "", "", httpContext.getMessage( "Ingresar Contraseña", ""), "", edtavSecuserpassword_Jsonclick, 0, "h40", "", "", "", "", 1, edtavSecuserpassword_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(-1), (short)(0), 0, (byte)(0), (byte)(0), (byte)(-1), true, "password", "left", true, "", "HLP_Login.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "MT15", "left", "top", "", "flex-grow:1;", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilledFullWidth MT10" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnenter_Internalname, "", httpContext.getMessage( "WWP_GAM_Login", ""), bttBtnenter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Login.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "DataContentCellLogin CellPaddingLogin", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblForgotpassword_Internalname, httpContext.getMessage( "Olvidó su contraseña?", ""), "", "", lblForgotpassword_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataDescriptionLogin", 0, "", lblForgotpassword_Visible, 1, 0, (short)(1), "HLP_Login.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "DataContentCellLogin CellPaddingLogin", "left", "top", "", "align-self:center;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblRegisteruser_Internalname, httpContext.getMessage( "Cree una cuenta", ""), "", "", lblRegisteruser_Jsonclick, "'"+""+"'"+",false,"+"'"+"e11301_client"+"'", "", "DataDescriptionLogin", 7, "", lblRegisteruser_Visible, 1, 0, (short)(0), "HLP_Login.htm");
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
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start302( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Iniciar sesión", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup300( ) ;
   }

   public void ws302( )
   {
      start302( ) ;
      evt302( ) ;
   }

   public void evt302( )
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
                        e12302 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        if ( ! wbErr )
                        {
                           Rfr0gs = false ;
                           if ( ! Rfr0gs )
                           {
                              /* Execute user event: Enter */
                              e13302 ();
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Load */
                        e14302 ();
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

   public void we302( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm302( ) ;
         }
      }
   }

   public void pa302( )
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
            GX_FocusControl = edtavSecusername_Internalname ;
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
      rf302( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV37Pgmname = "Login" ;
      Gx_err = (short)(0) ;
   }

   public void rf302( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e14302 ();
         wb300( ) ;
      }
   }

   public void send_integrity_lvl_hashes302( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV37Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV37Pgmname, ""))));
   }

   public void before_start_formulas( )
   {
      AV37Pgmname = "Login" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup300( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e12302 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         /* Read variables values. */
         AV26ImagenLogin = httpContext.cgiGet( imgavImagenlogin_Internalname) ;
         AV14SecUserName = httpContext.cgiGet( edtavSecusername_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14SecUserName", AV14SecUserName);
         AV15SecUserPassword = httpContext.cgiGet( edtavSecuserpassword_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15SecUserPassword", AV15SecUserPassword);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
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
      e12302 ();
      if (returnInSub) return;
   }

   public void e12302( )
   {
      /* Start Routine */
      returnInSub = false ;
      imgLoginimage_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, imgLoginimage_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgLoginimage_Visible), 5, 0), true);
      AV27Links.add(httpContext.getMessage( "https://images.unsplash.com/photo-1543269865-cbf427effbad?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", ""), 0);
      AV27Links.add(httpContext.getMessage( "https://images.unsplash.com/photo-1520333789090-1afc82db536a?q=80&w=1471&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", ""), 0);
      AV28indiceAleatorio = (short)(DecimalUtil.decToDouble(GXutil.roundDecimal( DecimalUtil.doubleToDec(GXutil.random( )*AV27Links.size()), 0))) ;
      System.out.println( AV37Pgmname+httpContext.getMessage( "&indiceAleatorio ", "")+GXutil.trim( GXutil.str( AV28indiceAleatorio, 4, 0)) );
      if ( AV28indiceAleatorio == 0 )
      {
         AV28indiceAleatorio = (short)(AV28indiceAleatorio+1) ;
      }
      else
      {
         if ( AV28indiceAleatorio > AV27Links.size() )
         {
            AV28indiceAleatorio = (short)(AV27Links.size()) ;
         }
      }
      AV26ImagenLogin = (String)AV27Links.elementAt(-1+AV28indiceAleatorio) ;
      httpContext.ajax_rsp_assign_prop("", false, imgavImagenlogin_Internalname, "Bitmap", ((GXutil.strcmp("", AV26ImagenLogin)==0) ? AV38Imagenlogin_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV26ImagenLogin))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgavImagenlogin_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV26ImagenLogin), true);
      AV38Imagenlogin_GXI = GXDbFile.pathToUrl( (String)AV27Links.elementAt(-1+AV28indiceAleatorio), context.getHttpContext()) ;
      httpContext.ajax_rsp_assign_prop("", false, imgavImagenlogin_Internalname, "Bitmap", ((GXutil.strcmp("", AV26ImagenLogin)==0) ? AV38Imagenlogin_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV26ImagenLogin))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgavImagenlogin_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV26ImagenLogin), true);
      if ( false )
      {
         callWebObject(formatLink("web.registroconconvenio", new String[] {GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "INS", ""))),GXutil.URLEncode(GXutil.ltrimstr(0,9,0))}, new String[] {"TrnMode","SecUserId"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
         callWebObject(formatLink("web.registronucleo", new String[] {GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "INS", ""))),GXutil.URLEncode(GXutil.ltrimstr(0,9,0))}, new String[] {"TrnMode","SecUserId"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
         callWebObject(formatLink("web.menu", new String[] {GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"MenuOpcCod"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
         callWebObject(formatLink("web.ahealth", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(2) ;
      }
      GXv_boolean1[0] = AV18hay ;
      new web.hayalguncliente(remoteHandle, context).execute( GXv_boolean1) ;
      login_impl.this.AV18hay = GXv_boolean1[0] ;
      if ( ! AV18hay )
      {
         callWebObject(formatLink("web.registronucleo", new String[] {GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "INS", ""))),GXutil.URLEncode(GXutil.ltrimstr(0,9,0))}, new String[] {"TrnMode","SecUserId"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      else
      {
      }
      if ( ! (GXutil.strcmp("", AV8defaultSecUserName)==0) )
      {
         AV14SecUserName = AV8defaultSecUserName ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14SecUserName", AV14SecUserName);
      }
      lblForgotpassword_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, lblForgotpassword_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblForgotpassword_Visible), 5, 0), true);
      AV16WebSession.clear();
      divLayoutmaintable_Class = "MainContainer" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      AV29registerEnable = GXutil.boolval( new web.getmetaparmvalue(remoteHandle, context).executeUdp( httpContext.getMessage( "register_enable", ""))) ;
      lblRegisteruser_Visible = (AV29registerEnable ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, lblRegisteruser_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblRegisteruser_Visible), 5, 0), true);
      if ( GXutil.strcmp(AV31Httprequest.getMethod(), "GET") == 0 )
      {
         GXt_SdtWWP_DesignSystemSettings2 = AV30WWP_DesignSystemSettings;
         GXv_SdtWWP_DesignSystemSettings3[0] = GXt_SdtWWP_DesignSystemSettings2;
         new web.wwpbaseobjects.wwp_getdesignsystemsettings(remoteHandle, context).execute( GXv_SdtWWP_DesignSystemSettings3) ;
         GXt_SdtWWP_DesignSystemSettings2 = GXv_SdtWWP_DesignSystemSettings3[0] ;
         AV30WWP_DesignSystemSettings = GXt_SdtWWP_DesignSystemSettings2;
         this.executeExternalObjectMethod("", false, "gx.core.ds", "setOption", new Object[] {"base-color",AV30WWP_DesignSystemSettings.getgxTv_SdtWWP_DesignSystemSettings_Basecolor()}, false);
         this.executeExternalObjectMethod("", false, "gx.core.ds", "setOption", new Object[] {"background-color",AV30WWP_DesignSystemSettings.getgxTv_SdtWWP_DesignSystemSettings_Backgroundstyle()}, false);
         this.executeExternalObjectMethod("", false, "gx.core.ds", "setOption", new Object[] {"font-size",AV30WWP_DesignSystemSettings.getgxTv_SdtWWP_DesignSystemSettings_Fontsize()}, false);
      }
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e13302 ();
      if (returnInSub) return;
   }

   public void e13302( )
   {
      /* Enter Routine */
      returnInSub = false ;
      AV7CliCod = 0 ;
      AV11LogInSuccessful = false ;
      GXv_boolean1[0] = AV9Existe ;
      GXv_boolean4[0] = AV11LogInSuccessful ;
      GXv_int5[0] = AV7CliCod ;
      new web.validarusupsw(remoteHandle, context).execute( AV14SecUserName, AV15SecUserPassword, GXv_boolean1, GXv_boolean4, GXv_int5) ;
      login_impl.this.AV9Existe = GXv_boolean1[0] ;
      login_impl.this.AV11LogInSuccessful = GXv_boolean4[0] ;
      login_impl.this.AV7CliCod = GXv_int5[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, "5") ;
      if ( AV11LogInSuccessful && ! (0==AV7CliCod) && ( AV9Existe ) )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV7CliCod, AV37Pgmname, httpContext.getMessage( "6 &CliCod ", "")+GXutil.trim( GXutil.str( AV7CliCod, 6, 0))) ;
         GXv_char6[0] = AV33EmpCodPalabra ;
         new web.wwpbaseobjects.loaduserkeyvalue(remoteHandle, context).execute( httpContext.getMessage( "EmpCod", ""), AV7CliCod, AV14SecUserName, GXv_char6) ;
         login_impl.this.AV33EmpCodPalabra = GXv_char6[0] ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV7CliCod, AV37Pgmname, httpContext.getMessage( "&EmpCodPalabra ", "")+GXutil.trim( AV33EmpCodPalabra)) ;
         if ( (GXutil.strcmp("", AV33EmpCodPalabra)==0) )
         {
            GXv_int7[0] = AV5EmpCod ;
            GXv_char6[0] = AV6EmpNom ;
            new web.primeraempresa(remoteHandle, context).execute( AV7CliCod, GXv_int7, GXv_char6) ;
            login_impl.this.AV5EmpCod = GXv_int7[0] ;
            login_impl.this.AV6EmpNom = GXv_char6[0] ;
         }
         else
         {
            AV5EmpCod = (short)(GXutil.lval( AV33EmpCodPalabra)) ;
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "&clicod ", "")+GXutil.trim( GXutil.str( AV7CliCod, 6, 0))) ;
         AV16WebSession.setValue(httpContext.getMessage( "CliCod", ""), GXutil.trim( GXutil.str( AV7CliCod, 6, 0)));
         new web.msgdebug_prod2(remoteHandle, context).execute( AV7CliCod, AV37Pgmname, httpContext.getMessage( "&EmpCod ", "")+GXutil.trim( GXutil.str( AV5EmpCod, 4, 0))) ;
         new web.setempresa(remoteHandle, context).execute( AV5EmpCod) ;
         GXt_dtime8 = AV34ahora ;
         GXv_dtime9[0] = GXt_dtime8 ;
         new web.getahora(remoteHandle, context).execute( AV7CliCod, GXv_dtime9) ;
         login_impl.this.GXt_dtime8 = GXv_dtime9[0] ;
         AV34ahora = GXt_dtime8 ;
         GXv_boolean4[0] = true ;
         new web.grabaloginregistro(remoteHandle, context).execute( AV7CliCod, AV14SecUserName, AV34ahora, GXv_boolean4) ;
         GXv_boolean4[0] = AV20ClienteConveniador ;
         new web.getclienteconveniador(remoteHandle, context).execute( AV7CliCod, GXv_boolean4) ;
         login_impl.this.AV20ClienteConveniador = GXv_boolean4[0] ;
         if ( AV20ClienteConveniador )
         {
            new web.setconvenio(remoteHandle, context).execute( GXutil.trim( new web.getprimerclienteconvenio(remoteHandle, context).executeUdp( AV7CliCod))) ;
         }
         AV16WebSession.setValue(httpContext.getMessage( "SecUserName", ""), GXutil.trim( AV14SecUserName));
         GXv_char6[0] = AV17terminoInicializacion ;
         new web.getparametro(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( "FIN_INI", ""), GXv_char6) ;
         login_impl.this.AV17terminoInicializacion = GXv_char6[0] ;
         if ( GXutil.strcmp(AV17terminoInicializacion, httpContext.getMessage( "S", "")) != 0 )
         {
            new web.limpiarmensajes(remoteHandle, context).execute( ) ;
            new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "Se están inicializando los datos para el nuevo usuario, por favor aguarde unos instantes e intente nuevamente", "")) ;
         }
         else
         {
            GXv_char6[0] = AV21homeURL ;
            GXv_char10[0] = "" ;
            new web.gethome(remoteHandle, context).execute( GXv_char6, GXv_char10) ;
            login_impl.this.AV21homeURL = GXv_char6[0] ;
            callWebObject(formatLink(AV21homeURL, new String[] {}, new String[] {}) );
            httpContext.wjLocDisableFrm = (byte)(0) ;
         }
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, "7") ;
         if ( ! (0==AV7CliCod) )
         {
            GXv_boolean4[0] = false ;
            new web.grabaloginregistro(remoteHandle, context).execute( AV7CliCod, AV14SecUserName, GXutil.now( ), GXv_boolean4) ;
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, "8") ;
         if ( (0==AV7CliCod) && ( AV9Existe ) )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, "9") ;
            httpContext.GX_msglist.addItem(httpContext.getMessage( "<#CLEAR#>", ""));
            new web.alert(remoteHandle, context).execute( "error", httpContext.getMessage( "Error: El usuario no tiene asignado cliente", "")) ;
         }
         else
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, "10") ;
            httpContext.GX_msglist.addItem(httpContext.getMessage( "<#CLEAR#>", ""));
            new web.alert(remoteHandle, context).execute( "error", httpContext.getMessage( "Password o Usuario Incorrectos", "")) ;
         }
      }
      /*  Sending Event outputs  */
   }

   protected void nextLoad( )
   {
   }

   protected void e14302( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void wb_table1_20_302( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemergedsignin_Internalname, tblTablemergedsignin_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='MergeDataCell'>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblSignin_Internalname, httpContext.getMessage( "Bienvenido a PayDay! ", ""), "", "", lblSignin_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "loginText mr5", 0, "", 1, 1, 0, (short)(0), "HLP_Login.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblock2_Internalname, httpContext.getMessage( "<svg width=\"23\" height=\"22\" viewBox=\"0 0 23 22\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M5.22792 17.3758C5.04253 17.3387 4.89422 17.3016 4.70883 17.2274C4.52345 17.1533 4.37514 17.1162 4.22683 17.0421C3.89313 16.8937 3.59651 16.7084 3.29989 16.4859C2.70665 16.078 2.22465 15.5219 1.85387 14.8545C1.4831 14.2242 1.26063 13.4826 1.22355 12.7782C1.18648 12.4074 1.22355 12.0737 1.26063 11.7029C1.29771 11.5175 1.33479 11.3692 1.37186 11.1838C1.40894 10.9984 1.4831 10.8501 1.52017 10.6647L1.55725 11.1838C1.55725 11.3692 1.59433 11.5175 1.63141 11.7029C1.66848 12.0366 1.74264 12.3703 1.81679 12.6669C1.9651 13.2972 2.18757 13.8905 2.52126 14.4466C2.85496 15.0028 3.22574 15.5219 3.70774 16.0039C3.93021 16.2264 4.18975 16.4488 4.44929 16.6713C4.56052 16.7825 4.70883 16.8937 4.85714 17.005L5.22792 17.3758ZM5.11668 18.7105C5.00545 18.7847 4.85714 18.8218 4.70883 18.8588C4.56052 18.8959 4.44929 18.933 4.30098 18.933C4.04144 18.9701 3.74482 19.0072 3.4482 18.9701C2.89204 18.933 2.2988 18.7847 1.81679 18.5252C1.29771 18.2656 0.852781 17.8578 0.556161 17.3758C0.407852 17.1533 0.259542 16.8937 0.14831 16.6342C0.111232 16.523 0.0741548 16.3747 0.0370774 16.2264C0.0370774 16.1151 0 16.0039 0 15.8556C0.111232 15.9668 0.185387 16.078 0.259542 16.1522C0.370774 16.2634 0.444929 16.3747 0.519084 16.4488C0.704471 16.6342 0.852781 16.8196 1.03817 16.9679C1.40894 17.3016 1.77972 17.5982 2.22465 17.8207C2.6325 18.0431 3.1145 18.2285 3.55943 18.3768C3.7819 18.451 4.04144 18.4881 4.30098 18.5622C4.41221 18.5993 4.56052 18.5993 4.67176 18.6364C4.85714 18.6735 4.96837 18.6735 5.11668 18.7105ZM13.4962 0.690912C13.6816 0.72799 13.8299 0.802144 14.0153 0.876299C14.2007 0.950454 14.349 1.02461 14.4973 1.09876C14.831 1.28415 15.1276 1.46954 15.4242 1.692C16.0174 2.13693 16.4995 2.73017 16.8331 3.39756C17.1668 4.06496 17.3522 4.80651 17.3522 5.51098C17.3522 5.88175 17.3152 6.21545 17.241 6.58622C17.2039 6.77161 17.1668 6.91992 17.0927 7.10531C17.0185 7.29069 16.9815 7.439 16.9073 7.58731L16.8702 7.06823C16.8702 6.88284 16.8702 6.73453 16.8331 6.54914L16.7219 5.54805C16.6107 4.91774 16.3882 4.28742 16.0916 3.69418C15.795 3.10094 15.4242 2.58186 14.9793 2.09985C14.7568 1.84031 14.4973 1.61785 14.2748 1.35831C14.1636 1.24707 14.0153 1.13584 13.867 1.02461L13.4962 0.690912ZM16.7219 0.542603C16.8702 0.57968 16.9815 0.616757 17.0927 0.690912C17.2039 0.72799 17.3522 0.802144 17.4635 0.876299C17.6859 1.02461 17.9084 1.17292 18.1309 1.35831C18.5387 1.72908 18.8724 2.17401 19.0578 2.69309C19.2803 3.21218 19.3544 3.76834 19.2803 4.3245C19.2432 4.58404 19.169 4.84358 19.0949 5.10312C19.0578 5.21436 18.9836 5.36267 18.9466 5.4739C18.8724 5.58513 18.8353 5.69636 18.7241 5.8076V5.43682V5.06605C18.7241 4.80651 18.687 4.58404 18.687 4.36158C18.6129 3.87957 18.5387 3.43464 18.3533 3.02679C18.1679 2.58186 17.9455 2.21109 17.6859 1.80323C17.5376 1.61785 17.3893 1.39538 17.241 1.21C17.1668 1.09876 17.0927 1.02461 16.9815 0.913377C16.9073 0.72799 16.7961 0.616757 16.7219 0.542603Z\" fill=\"#4F46E5\"/><path d=\"M5.22792 17.3758C5.04253 17.3387 4.89422 17.3016 4.70883 17.2274C4.52345 17.1533 4.37514 17.1162 4.22683 17.0421C3.89313 16.8937 3.59651 16.7084 3.29989 16.4859C2.70665 16.078 2.22465 15.5219 1.85387 14.8545C1.4831 14.2242 1.26063 13.4826 1.22355 12.7782C1.18648 12.4074 1.22355 12.0737 1.26063 11.7029C1.29771 11.5175 1.33479 11.3692 1.37186 11.1838C1.40894 10.9984 1.4831 10.8501 1.52017 10.6647L1.55725 11.1838C1.55725 11.3692 1.59433 11.5175 1.63141 11.7029C1.66848 12.0366 1.74264 12.3703 1.81679 12.6669C1.9651 13.2972 2.18757 13.8905 2.52126 14.4466C2.85496 15.0028 3.22574 15.5219 3.70774 16.0039C3.93021 16.2264 4.18975 16.4488 4.44929 16.6713C4.56052 16.7825 4.70883 16.8937 4.85714 17.005L5.22792 17.3758ZM5.11668 18.7105C5.00545 18.7847 4.85714 18.8218 4.70883 18.8588C4.56052 18.8959 4.44929 18.933 4.30098 18.933C4.04144 18.9701 3.74482 19.0072 3.4482 18.9701C2.89204 18.933 2.2988 18.7847 1.81679 18.5252C1.29771 18.2656 0.852781 17.8578 0.556161 17.3758C0.407852 17.1533 0.259542 16.8937 0.14831 16.6342C0.111232 16.523 0.0741548 16.3747 0.0370774 16.2264C0.0370774 16.1151 0 16.0039 0 15.8556C0.111232 15.9668 0.185387 16.078 0.259542 16.1522C0.370774 16.2634 0.444929 16.3747 0.519084 16.4488C0.704471 16.6342 0.852781 16.8196 1.03817 16.9679C1.40894 17.3016 1.77972 17.5982 2.22465 17.8207C2.6325 18.0431 3.1145 18.2285 3.55943 18.3768C3.7819 18.451 4.04144 18.4881 4.30098 18.5622C4.41221 18.5993 4.56052 18.5993 4.67176 18.6364C4.85714 18.6735 4.96837 18.6735 5.11668 18.7105ZM13.4962 0.690912C13.6816 0.72799 13.8299 0.802144 14.0153 0.876299C14.2007 0.950454 14.349 1.02461 14.4973 1.09876C14.831 1.28415 15.1276 1.46954 15.4242 1.692C16.0174 2.13693 16.4995 2.73017 16.8331 3.39756C17.1668 4.06496 17.3522 4.80651 17.3522 5.51098C17.3522 5.88175 17.3152 6.21545 17.241 6.58622C17.2039 6.77161 17.1668 6.91992 17.0927 7.10531C17.0185 7.29069 16.9815 7.439 16.9073 7.58731L16.8702 7.06823C16.8702 6.88284 16.8702 6.73453 16.8331 6.54914L16.7219 5.54805C16.6107 4.91774 16.3882 4.28742 16.0916 3.69418C15.795 3.10094 15.4242 2.58186 14.9793 2.09985C14.7568 1.84031 14.4973 1.61785 14.2748 1.35831C14.1636 1.24707 14.0153 1.13584 13.867 1.02461L13.4962 0.690912ZM16.7219 0.542603C16.8702 0.57968 16.9815 0.616757 17.0927 0.690912C17.2039 0.72799 17.3522 0.802144 17.4635 0.876299C17.6859 1.02461 17.9084 1.17292 18.1309 1.35831C18.5387 1.72908 18.8724 2.17401 19.0578 2.69309C19.2803 3.21218 19.3544 3.76834 19.2803 4.3245C19.2432 4.58404 19.169 4.84358 19.0949 5.10312C19.0578 5.21436 18.9836 5.36267 18.9466 5.4739C18.8724 5.58513 18.8353 5.69636 18.7241 5.8076V5.43682V5.06605C18.7241 4.80651 18.687 4.58404 18.687 4.36158C18.6129 3.87957 18.5387 3.43464 18.3533 3.02679C18.1679 2.58186 17.9455 2.21109 17.6859 1.80323C17.5376 1.61785 17.3893 1.39538 17.241 1.21C17.1668 1.09876 17.0927 1.02461 16.9815 0.913377C16.9073 0.72799 16.7961 0.616757 16.7219 0.542603Z\" fill=\"black\" fill-opacity=\"0.2\"/><path d=\"M2.96602 6.06719C2.22448 6.40089 1.96493 7.29075 2.29863 8.0323L6.97038 17.7837L9.5658 16.5601L4.89405 6.77166C4.56035 6.03012 3.70757 5.69642 2.96602 6.06719ZM15.2387 13.8164L17.9824 12.5187L12.6432 1.39544C12.2725 0.653889 11.3826 0.320192 10.604 0.690967C9.86242 1.06174 9.52873 1.9516 9.8995 2.73022L15.2387 13.8164Z\" fill=\"#FFDD67\"/><path d=\"M10.6414 0.653789C10.5673 0.690867 10.4931 0.727944 10.4189 0.802099C11.1234 0.616712 11.865 0.950409 12.1987 1.6178L17.5378 12.741L18.0198 12.5186L12.6807 1.39534C12.3099 0.616712 11.42 0.283015 10.6414 0.653789Z\" fill=\"#EBA352\"/><path d=\"M9.56572 16.5229L12.4207 15.151L6.9703 3.80534C6.59952 3.02671 5.63551 2.65594 4.85689 3.02671C4.07826 3.39748 3.74456 4.3615 4.11534 5.14012L9.56572 16.5229Z\" fill=\"#FFDD67\"/><path d=\"M4.85723 3.06377C4.78308 3.10085 4.70892 3.13793 4.63477 3.21208C5.33924 3.0267 6.15494 3.36039 6.48864 4.06487L9.86268 11.1467L10.6784 11.6287L6.97064 3.8424C6.59987 3.0267 5.67293 2.693 4.85723 3.06377Z\" fill=\"#EBA352\"/><path d=\"M11.9759 14.2612L14.8308 12.8894L9.38045 1.54367C9.00968 0.765047 8.04567 0.394272 7.26704 0.802124C6.48842 1.1729 6.15472 2.13691 6.52549 2.91554L11.9759 14.2612Z\" fill=\"#FFDD67\"/><path d=\"M7.2671 0.765068C7.19294 0.802146 7.11879 0.876301 7.04463 0.913378C7.7491 0.727991 8.56481 1.06169 8.8985 1.76616L12.7175 9.77488L13.5332 10.2569L9.38051 1.54369C9.00974 0.727991 8.04572 0.394294 7.2671 0.765068ZM2.96612 6.06714C2.89196 6.10422 2.81781 6.14129 2.74365 6.21545C3.41105 6.03006 4.11552 6.36376 4.41214 7.03115L7.19294 12.8523L8.00865 13.3343L4.89414 6.80869C4.56045 6.03006 3.70767 5.69637 2.96612 6.06714Z\" fill=\"#EBA352\"/><path d=\"M21.8014 4.95471C20.8003 4.17608 19.1689 5.02886 18.3532 7.69844C17.7971 9.55231 17.7229 10.1085 16.5364 10.6646L15.869 9.29277C15.869 9.29277 5.33905 14.3724 5.7469 15.1881C5.7469 15.1881 7.00753 19.1183 9.15802 20.9351C12.3467 23.6788 19.7992 20.7497 20.1329 13.6679C20.3183 9.55231 22.8767 5.80749 21.8014 4.95471Z\" fill=\"#FFDD67\"/><path d=\"M21.8015 4.95473C21.6161 4.80642 21.3936 4.73227 21.1712 4.69519C21.2083 4.73227 21.2824 4.73227 21.3195 4.76935C22.4318 5.62213 21.2824 7.58723 20.6521 9.36695C20.133 10.7759 19.6881 12.2219 19.7622 13.6308C20.0589 19.7857 13.8669 22.7148 10.1592 21.6025C13.7928 23.1227 20.5409 20.2306 20.2442 13.8162C20.1701 12.4073 20.5779 11.0354 21.1341 9.55233C21.7273 7.77262 22.8767 5.80751 21.8015 4.95473Z\" fill=\"#EBA352\"/><path d=\"M16.8704 10.5164C14.5716 10.7759 11.1976 14.0758 13.5705 17.6723C11.8279 14.0387 14.6828 11.5916 16.4996 10.7388C16.685 10.5905 16.8704 10.5164 16.8704 10.5164Z\" fill=\"#EBA352\"/></svg>", ""), "", "", lblTextblock2_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_Login.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_20_302e( true) ;
      }
      else
      {
         wb_table1_20_302e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV8defaultSecUserName = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8defaultSecUserName", AV8defaultSecUserName);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDEFAULTSECUSERNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8defaultSecUserName, ""))));
      AV32URL = (String)getParm(obj,1) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV32URL", AV32URL);
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
      pa302( ) ;
      ws302( ) ;
      we302( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025171354442", true, true);
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
      httpContext.AddJavascriptSource("messages."+httpContext.getLanguageProperty( "code")+".js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      httpContext.AddJavascriptSource("login.js", "?2025171354442", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      imgLoginimage_Internalname = "LOGINIMAGE" ;
      imgavImagenlogin_Internalname = "vIMAGENLOGIN" ;
      divLoginimagen_Internalname = "LOGINIMAGEN" ;
      lblSignin_Internalname = "SIGNIN" ;
      lblTextblock2_Internalname = "TEXTBLOCK2" ;
      tblTablemergedsignin_Internalname = "TABLEMERGEDSIGNIN" ;
      lblTextblock1_Internalname = "TEXTBLOCK1" ;
      divTablelogintextos_Internalname = "TABLELOGINTEXTOS" ;
      lblTextblocksecusername_Internalname = "TEXTBLOCKSECUSERNAME" ;
      edtavSecusername_Internalname = "vSECUSERNAME" ;
      divUnnamedtablesecusername_Internalname = "UNNAMEDTABLESECUSERNAME" ;
      lblTextblocksecuserpassword_Internalname = "TEXTBLOCKSECUSERPASSWORD" ;
      edtavSecuserpassword_Internalname = "vSECUSERPASSWORD" ;
      divUnnamedtablesecuserpassword_Internalname = "UNNAMEDTABLESECUSERPASSWORD" ;
      bttBtnenter_Internalname = "BTNENTER" ;
      lblForgotpassword_Internalname = "FORGOTPASSWORD" ;
      lblRegisteruser_Internalname = "REGISTERUSER" ;
      divTableinputs_Internalname = "TABLEINPUTS" ;
      divTablelogincontent_Internalname = "TABLELOGINCONTENT" ;
      divLogininputs_Internalname = "LOGININPUTS" ;
      divLogincontainer_Internalname = "LOGINCONTAINER" ;
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
      lblRegisteruser_Visible = 1 ;
      lblForgotpassword_Visible = 1 ;
      edtavSecuserpassword_Jsonclick = "" ;
      edtavSecuserpassword_Enabled = 1 ;
      edtavSecusername_Jsonclick = "" ;
      edtavSecusername_Enabled = 1 ;
      imgavImagenlogin_gximage = "" ;
      imgLoginimage_Visible = 1 ;
      divLayoutmaintable_Class = "Table" ;
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV37Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV8defaultSecUserName',fld:'vDEFAULTSECUSERNAME',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("ENTER","{handler:'e13302',iparms:[{av:'AV14SecUserName',fld:'vSECUSERNAME',pic:''},{av:'AV15SecUserPassword',fld:'vSECUSERPASSWORD',pic:''},{av:'AV37Pgmname',fld:'vPGMNAME',pic:'',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REGISTERUSER.CLICK","{handler:'e11301',iparms:[]");
      setEventMetadata("REGISTERUSER.CLICK",",oparms:[]}");
      setEventMetadata("VALIDV_SECUSERNAME","{handler:'validv_Secusername',iparms:[]");
      setEventMetadata("VALIDV_SECUSERNAME",",oparms:[]}");
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
      wcpOAV8defaultSecUserName = "" ;
      wcpOAV32URL = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV8defaultSecUserName = "" ;
      AV32URL = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      AV37Pgmname = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      imgLoginimage_gximage = "" ;
      StyleString = "" ;
      sImgUrl = "" ;
      AV26ImagenLogin = "" ;
      AV38Imagenlogin_GXI = "" ;
      lblTextblock1_Jsonclick = "" ;
      lblTextblocksecusername_Jsonclick = "" ;
      TempTags = "" ;
      AV14SecUserName = "" ;
      lblTextblocksecuserpassword_Jsonclick = "" ;
      AV15SecUserPassword = "" ;
      bttBtnenter_Jsonclick = "" ;
      lblForgotpassword_Jsonclick = "" ;
      lblRegisteruser_Jsonclick = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV27Links = new GXSimpleCollection<String>(String.class, "internal", "");
      AV16WebSession = httpContext.getWebSession();
      AV31Httprequest = httpContext.getHttpRequest();
      AV30WWP_DesignSystemSettings = new web.wwpbaseobjects.SdtWWP_DesignSystemSettings(remoteHandle, context);
      GXt_SdtWWP_DesignSystemSettings2 = new web.wwpbaseobjects.SdtWWP_DesignSystemSettings(remoteHandle, context);
      GXv_SdtWWP_DesignSystemSettings3 = new web.wwpbaseobjects.SdtWWP_DesignSystemSettings[1] ;
      GXv_boolean1 = new boolean[1] ;
      GXv_int5 = new int[1] ;
      AV33EmpCodPalabra = "" ;
      GXv_int7 = new short[1] ;
      AV6EmpNom = "" ;
      AV34ahora = GXutil.resetTime( GXutil.nullDate() );
      GXt_dtime8 = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime9 = new java.util.Date[1] ;
      AV17terminoInicializacion = "" ;
      AV21homeURL = "" ;
      GXv_char6 = new String[1] ;
      GXv_char10 = new String[1] ;
      GXv_boolean4 = new boolean[1] ;
      sStyleString = "" ;
      lblSignin_Jsonclick = "" ;
      lblTextblock2_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      AV37Pgmname = "Login" ;
      /* GeneXus formulas. */
      AV37Pgmname = "Login" ;
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV28indiceAleatorio ;
   private short AV5EmpCod ;
   private short GXv_int7[] ;
   private int imgLoginimage_Visible ;
   private int edtavSecusername_Enabled ;
   private int edtavSecuserpassword_Enabled ;
   private int lblForgotpassword_Visible ;
   private int lblRegisteruser_Visible ;
   private int AV7CliCod ;
   private int GXv_int5[] ;
   private int idxLst ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String AV37Pgmname ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String divLogincontainer_Internalname ;
   private String divLoginimagen_Internalname ;
   private String ClassString ;
   private String imgLoginimage_gximage ;
   private String StyleString ;
   private String sImgUrl ;
   private String imgLoginimage_Internalname ;
   private String imgavImagenlogin_Internalname ;
   private String imgavImagenlogin_gximage ;
   private String divLogininputs_Internalname ;
   private String divTablelogincontent_Internalname ;
   private String divTablelogintextos_Internalname ;
   private String lblTextblock1_Internalname ;
   private String lblTextblock1_Jsonclick ;
   private String divTableinputs_Internalname ;
   private String divUnnamedtablesecusername_Internalname ;
   private String lblTextblocksecusername_Internalname ;
   private String lblTextblocksecusername_Jsonclick ;
   private String edtavSecusername_Internalname ;
   private String TempTags ;
   private String edtavSecusername_Jsonclick ;
   private String divUnnamedtablesecuserpassword_Internalname ;
   private String lblTextblocksecuserpassword_Internalname ;
   private String lblTextblocksecuserpassword_Jsonclick ;
   private String edtavSecuserpassword_Internalname ;
   private String edtavSecuserpassword_Jsonclick ;
   private String bttBtnenter_Internalname ;
   private String bttBtnenter_Jsonclick ;
   private String lblForgotpassword_Internalname ;
   private String lblForgotpassword_Jsonclick ;
   private String lblRegisteruser_Internalname ;
   private String lblRegisteruser_Jsonclick ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV33EmpCodPalabra ;
   private String AV17terminoInicializacion ;
   private String GXv_char6[] ;
   private String GXv_char10[] ;
   private String sStyleString ;
   private String tblTablemergedsignin_Internalname ;
   private String lblSignin_Internalname ;
   private String lblSignin_Jsonclick ;
   private String lblTextblock2_Internalname ;
   private String lblTextblock2_Jsonclick ;
   private java.util.Date AV34ahora ;
   private java.util.Date GXt_dtime8 ;
   private java.util.Date GXv_dtime9[] ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean AV26ImagenLogin_IsBlob ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV18hay ;
   private boolean AV29registerEnable ;
   private boolean AV11LogInSuccessful ;
   private boolean AV9Existe ;
   private boolean GXv_boolean1[] ;
   private boolean AV20ClienteConveniador ;
   private boolean GXv_boolean4[] ;
   private String wcpOAV8defaultSecUserName ;
   private String wcpOAV32URL ;
   private String AV8defaultSecUserName ;
   private String AV32URL ;
   private String AV38Imagenlogin_GXI ;
   private String AV14SecUserName ;
   private String AV15SecUserPassword ;
   private String AV6EmpNom ;
   private String AV21homeURL ;
   private String AV26ImagenLogin ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV31Httprequest ;
   private com.genexus.webpanels.WebSession AV16WebSession ;
   private GXSimpleCollection<String> AV27Links ;
   private web.wwpbaseobjects.SdtWWP_DesignSystemSettings AV30WWP_DesignSystemSettings ;
   private web.wwpbaseobjects.SdtWWP_DesignSystemSettings GXt_SdtWWP_DesignSystemSettings2 ;
   private web.wwpbaseobjects.SdtWWP_DesignSystemSettings GXv_SdtWWP_DesignSystemSettings3[] ;
}

