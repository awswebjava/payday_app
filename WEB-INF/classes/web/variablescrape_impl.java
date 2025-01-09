package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class variablescrape_impl extends GXDataArea
{
   public variablescrape_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public variablescrape_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( variablescrape_impl.class ));
   }

   public variablescrape_impl( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbavClirelsec = new HTMLChoice();
      cmbavVarscraptdoc = new HTMLChoice();
      cmbavVarscraptipo = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "OpeCliId") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "OpeCliId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "OpeCliId") ;
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
            AV5OpeCliId = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV5OpeCliId", AV5OpeCliId);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOPECLIID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV5OpeCliId, ""))));
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
      paKJ2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startKJ2( ) ;
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
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-"+GXutil.substring( httpContext.getLanguageProperty( "culture"), 1, 2)+".js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"false\" data-Skiponenter=\"false\"" ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.variablescrape", new String[] {GXutil.URLEncode(GXutil.rtrim(AV5OpeCliId))}, new String[] {"OpeCliId"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV34Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOPECLICODFORMULA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10OpeCliCodFormula, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOPECLIID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV5OpeCliId, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", "hsh"+"VariableScrape");
      forbiddenHiddens.add("OpeCliCodFormula", GXutil.rtrim( localUtil.format( AV10OpeCliCodFormula, "")));
      forbiddenHiddens.add("OpeCliDescrip", GXutil.rtrim( localUtil.format( AV11OpeCliDescrip, "")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("variablescrape:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV34Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV34Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV8CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vDATE", localUtil.dtoc( AV23date, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "vVALORCRUDO", GXutil.rtrim( AV29valorCrudo));
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
   }

   public void renderHtmlContent( )
   {
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         httpContext.writeText( "<div") ;
         web.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         weKJ2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtKJ2( ) ;
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
      return formatLink("web.variablescrape", new String[] {GXutil.URLEncode(GXutil.rtrim(AV5OpeCliId))}, new String[] {"OpeCliId"})  ;
   }

   public String getPgmname( )
   {
      return "VariableScrape" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Variable Scrape", "") ;
   }

   public void wbKJ0( )
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
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMain", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavOpeclicodformula_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavOpeclicodformula_Internalname, httpContext.getMessage( "Variable", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 14,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavOpeclicodformula_Internalname, GXutil.rtrim( AV10OpeCliCodFormula), GXutil.rtrim( localUtil.format( AV10OpeCliCodFormula, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,14);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavOpeclicodformula_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavOpeclicodformula_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_VariableScrape.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavOpeclidescrip_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavOpeclidescrip_Internalname, httpContext.getMessage( "Descripción", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 19,'',false,'',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtavOpeclidescrip_Internalname, AV11OpeCliDescrip, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,19);\"", (short)(0), 1, edtavOpeclidescrip_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_VariableScrape.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavOpeclivig_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavOpeclivig_Internalname, httpContext.getMessage( "Fecha", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 24,'',false,'',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavOpeclivig_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavOpeclivig_Internalname, localUtil.format(AV20OpeCliVig, "99/99/99"), localUtil.format( AV20OpeCliVig, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,24);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavOpeclivig_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtavOpeclivig_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_VariableScrape.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtavOpeclivig_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavOpeclivig_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_VariableScrape.htm");
         httpContext.writeTextNL( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavOpeclivalor_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavOpeclivalor_Internalname, httpContext.getMessage( "Valor", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = ((edtavOpeclivalor_Fontbold==1) ? "font-weight:bold;" : "font-weight:normal;") ;
         ClassString = "Attribute" ;
         StyleString = ((edtavOpeclivalor_Fontbold==1) ? "font-weight:bold;" : "font-weight:normal;") ;
         web.GxWebStd.gx_html_textarea( httpContext, edtavOpeclivalor_Internalname, AV13OpeCliValor, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,29);\"", (short)(0), 1, edtavOpeclivalor_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "500000", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_VariableScrape.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Static images/pictures */
         ClassString = "Image" + " " + ((GXutil.strcmp(imgWarningicon_gximage, "")==0) ? "GX_Image_WarningIcon_Class" : "GX_Image_"+imgWarningicon_gximage+"_Class") ;
         StyleString = "" ;
         sImgUrl = context.getHttpContext().getImagePath( "4041cec4-85fe-4bd8-aaa2-a8a2026c306c", "", context.getHttpContext().getTheme( )) ;
         web.GxWebStd.gx_bitmap( httpContext, imgWarningicon_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), imgWarningicon_Visible, 1, "", imgWarningicon_Tooltiptext, 0, 0, 0, "px", 0, "px", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", " "+"data-gx-image"+" ", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_VariableScrape.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavUrl_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavUrl_Internalname, httpContext.getMessage( "Origen", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavUrl_Internalname, AV18Url, GXutil.rtrim( localUtil.format( AV18Url, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,37);\"", "'"+""+"'"+",false,"+"'"+""+"'", edtavUrl_Link, edtavUrl_Linktarget, "", "", edtavUrl_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavUrl_Enabled, 0, "url", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXus\\Url", "left", true, "", "HLP_VariableScrape.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavScrape_opeclivalor_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavScrape_opeclivalor_Internalname, httpContext.getMessage( "Respuesta", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtavScrape_opeclivalor_Internalname, AV27scrape_OpeCliValor, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,42);\"", (short)(1), 1, edtavScrape_opeclivalor_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "500000", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_VariableScrape.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Required", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavClirelsec.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavClirelsec.getInternalname(), httpContext.getMessage( "Fecha/hora de liberación", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavClirelsec, cmbavClirelsec.getInternalname(), GXutil.trim( GXutil.str( AV14CliRelSec, 6, 0)), 1, cmbavClirelsec.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavClirelsec.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,47);\"", "", true, (byte)(0), "HLP_VariableScrape.htm");
         cmbavClirelsec.setValue( GXutil.trim( GXutil.str( AV14CliRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavClirelsec.getInternalname(), "Values", cmbavClirelsec.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 50,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnrecapturar_Internalname, "", httpContext.getMessage( "Editar búsqueda", ""), bttBtnrecapturar_Jsonclick, 7, httpContext.getMessage( "Editar búsqueda", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e11kj1_client"+"'", TempTags, "", 2, "HLP_VariableScrape.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         wb_table1_53_KJ2( true) ;
      }
      else
      {
         wb_table1_53_KJ2( false) ;
      }
      return  ;
   }

   public void wb_table1_53_KJ2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 89,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtngrabar_Internalname, "", httpContext.getMessage( "Confirmar", ""), bttBtngrabar_Jsonclick, 5, httpContext.getMessage( "Confirmar", ""), "", StyleString, ClassString, bttBtngrabar_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOGRABAR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_VariableScrape.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
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
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtavOpecliid_Internalname, GXutil.rtrim( AV5OpeCliId), GXutil.rtrim( localUtil.format( AV5OpeCliId, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavOpecliid_Jsonclick, 0, "Attribute", "", "", "", "", edtavOpecliid_Visible, 0, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_VariableScrape.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void startKJ2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Variable Scrape", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupKJ0( ) ;
   }

   public void wsKJ2( )
   {
      startKJ2( ) ;
      evtKJ2( ) ;
   }

   public void evtKJ2( )
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
                           e12KJ2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOGRABAR'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoGrabar' */
                           e13KJ2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOBUSCAR'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoBuscar' */
                           e14KJ2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Refresh */
                           e15KJ2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e16KJ2 ();
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

   public void weKJ2( )
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

   public void paKJ2( )
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
            GX_FocusControl = edtavOpeclicodformula_Internalname ;
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
      if ( cmbavClirelsec.getItemCount() > 0 )
      {
         AV14CliRelSec = (int)(GXutil.lval( cmbavClirelsec.getValidValue(GXutil.trim( GXutil.str( AV14CliRelSec, 6, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14CliRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14CliRelSec), 6, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavClirelsec.setValue( GXutil.trim( GXutil.str( AV14CliRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavClirelsec.getInternalname(), "Values", cmbavClirelsec.ToJavascriptSource(), true);
      }
      if ( cmbavVarscraptdoc.getItemCount() > 0 )
      {
         AV26VarScrapTDoc = cmbavVarscraptdoc.getValidValue(AV26VarScrapTDoc) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26VarScrapTDoc", AV26VarScrapTDoc);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavVarscraptdoc.setValue( GXutil.rtrim( AV26VarScrapTDoc) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavVarscraptdoc.getInternalname(), "Values", cmbavVarscraptdoc.ToJavascriptSource(), true);
      }
      if ( cmbavVarscraptipo.getItemCount() > 0 )
      {
         AV25VarScrapTipo = cmbavVarscraptipo.getValidValue(AV25VarScrapTipo) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25VarScrapTipo", AV25VarScrapTipo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavVarscraptipo.setValue( GXutil.rtrim( AV25VarScrapTipo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavVarscraptipo.getInternalname(), "Values", cmbavVarscraptipo.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfKJ2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV34Pgmname = "VariableScrape" ;
      Gx_err = (short)(0) ;
      edtavOpeclicodformula_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavOpeclicodformula_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOpeclicodformula_Enabled), 5, 0), true);
      edtavOpeclidescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavOpeclidescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOpeclidescrip_Enabled), 5, 0), true);
      edtavOpeclivalor_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavOpeclivalor_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOpeclivalor_Enabled), 5, 0), true);
      edtavUrl_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUrl_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUrl_Enabled), 5, 0), true);
      edtavScrape_opeclivalor_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavScrape_opeclivalor_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavScrape_opeclivalor_Enabled), 5, 0), true);
   }

   public void rfKJ2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e15KJ2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e16KJ2 ();
         wbKJ0( ) ;
      }
   }

   public void send_integrity_lvl_hashesKJ2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV34Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV34Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV8CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CliCod), "ZZZZZ9")));
   }

   public void before_start_formulas( )
   {
      AV34Pgmname = "VariableScrape" ;
      Gx_err = (short)(0) ;
      edtavOpeclicodformula_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavOpeclicodformula_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOpeclicodformula_Enabled), 5, 0), true);
      edtavOpeclidescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavOpeclidescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOpeclidescrip_Enabled), 5, 0), true);
      edtavOpeclivalor_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavOpeclivalor_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOpeclivalor_Enabled), 5, 0), true);
      edtavUrl_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUrl_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUrl_Enabled), 5, 0), true);
      edtavScrape_opeclivalor_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavScrape_opeclivalor_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavScrape_opeclivalor_Enabled), 5, 0), true);
      fix_multi_value_controls( ) ;
   }

   public void strupKJ0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e12KJ2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         /* Read variables values. */
         AV10OpeCliCodFormula = httpContext.cgiGet( edtavOpeclicodformula_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10OpeCliCodFormula", AV10OpeCliCodFormula);
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOPECLICODFORMULA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10OpeCliCodFormula, ""))));
         AV11OpeCliDescrip = httpContext.cgiGet( edtavOpeclidescrip_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11OpeCliDescrip", AV11OpeCliDescrip);
         if ( localUtil.vcdate( httpContext.cgiGet( edtavOpeclivig_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vOPECLIVIG");
            GX_FocusControl = edtavOpeclivig_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV20OpeCliVig = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20OpeCliVig", localUtil.format(AV20OpeCliVig, "99/99/99"));
         }
         else
         {
            AV20OpeCliVig = localUtil.ctod( httpContext.cgiGet( edtavOpeclivig_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20OpeCliVig", localUtil.format(AV20OpeCliVig, "99/99/99"));
         }
         AV13OpeCliValor = httpContext.cgiGet( edtavOpeclivalor_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13OpeCliValor", AV13OpeCliValor);
         AV18Url = httpContext.cgiGet( edtavUrl_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18Url", AV18Url);
         AV27scrape_OpeCliValor = httpContext.cgiGet( edtavScrape_opeclivalor_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27scrape_OpeCliValor", AV27scrape_OpeCliValor);
         cmbavClirelsec.setValue( httpContext.cgiGet( cmbavClirelsec.getInternalname()) );
         AV14CliRelSec = (int)(GXutil.lval( httpContext.cgiGet( cmbavClirelsec.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14CliRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14CliRelSec), 6, 0));
         AV15VarBusGoogle = httpContext.cgiGet( edtavVarbusgoogle_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15VarBusGoogle", AV15VarBusGoogle);
         AV16VarBaseURL = httpContext.cgiGet( edtavVarbaseurl_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16VarBaseURL", AV16VarBaseURL);
         AV17VarBusWeb = httpContext.cgiGet( edtavVarbusweb_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17VarBusWeb", AV17VarBusWeb);
         AV30VarScrapFin = httpContext.cgiGet( edtavVarscrapfin_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV30VarScrapFin", AV30VarScrapFin);
         cmbavVarscraptdoc.setValue( httpContext.cgiGet( cmbavVarscraptdoc.getInternalname()) );
         AV26VarScrapTDoc = httpContext.cgiGet( cmbavVarscraptdoc.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26VarScrapTDoc", AV26VarScrapTDoc);
         cmbavVarscraptipo.setValue( httpContext.cgiGet( cmbavVarscraptipo.getInternalname()) );
         AV25VarScrapTipo = httpContext.cgiGet( cmbavVarscraptipo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25VarScrapTipo", AV25VarScrapTipo);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         forbiddenHiddens = new com.genexus.util.GXProperties() ;
         forbiddenHiddens.add("hshsalt", "hsh"+"VariableScrape");
         AV10OpeCliCodFormula = httpContext.cgiGet( edtavOpeclicodformula_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10OpeCliCodFormula", AV10OpeCliCodFormula);
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOPECLICODFORMULA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10OpeCliCodFormula, ""))));
         forbiddenHiddens.add("OpeCliCodFormula", GXutil.rtrim( localUtil.format( AV10OpeCliCodFormula, "")));
         AV11OpeCliDescrip = httpContext.cgiGet( edtavOpeclidescrip_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11OpeCliDescrip", AV11OpeCliDescrip);
         forbiddenHiddens.add("OpeCliDescrip", GXutil.rtrim( localUtil.format( AV11OpeCliDescrip, "")));
         hsh = httpContext.cgiGet( "hsh") ;
         if ( ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
         {
            GXutil.writeLogError("variablescrape:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
      e12KJ2 ();
      if (returnInSub) return;
   }

   public void e12KJ2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV8CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      variablescrape_impl.this.GXt_int1 = GXv_int2[0] ;
      AV8CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CliCod), "ZZZZZ9")));
      edtavUrl_Linktarget = "_blank" ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUrl_Internalname, "Linktarget", edtavUrl_Linktarget, true);
      edtavUrl_Link = AV18Url ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUrl_Internalname, "Link", edtavUrl_Link, true);
      edtavOpecliid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavOpecliid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOpecliid_Visible), 5, 0), true);
      GXv_date3[0] = AV20OpeCliVig ;
      new web.getopeclinextfecha(remoteHandle, context).execute( AV8CliCod, AV5OpeCliId, GXutil.serverDate( context, remoteHandle, pr_default), GXv_date3) ;
      variablescrape_impl.this.AV20OpeCliVig = GXv_date3[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20OpeCliVig", localUtil.format(AV20OpeCliVig, "99/99/99"));
      GXv_char4[0] = AV16VarBaseURL ;
      GXv_char5[0] = AV25VarScrapTipo ;
      GXv_char6[0] = AV26VarScrapTDoc ;
      GXv_char7[0] = AV15VarBusGoogle ;
      GXv_char8[0] = AV17VarBusWeb ;
      GXv_char9[0] = AV30VarScrapFin ;
      new web.getvarbusqueda(remoteHandle, context).execute( AV8CliCod, AV5OpeCliId, AV20OpeCliVig, GXv_char4, GXv_char5, GXv_char6, GXv_char7, GXv_char8, GXv_char9) ;
      variablescrape_impl.this.AV16VarBaseURL = GXv_char4[0] ;
      variablescrape_impl.this.AV25VarScrapTipo = GXv_char5[0] ;
      variablescrape_impl.this.AV26VarScrapTDoc = GXv_char6[0] ;
      variablescrape_impl.this.AV15VarBusGoogle = GXv_char7[0] ;
      variablescrape_impl.this.AV17VarBusWeb = GXv_char8[0] ;
      variablescrape_impl.this.AV30VarScrapFin = GXv_char9[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16VarBaseURL", AV16VarBaseURL);
      httpContext.ajax_rsp_assign_attri("", false, "AV25VarScrapTipo", AV25VarScrapTipo);
      httpContext.ajax_rsp_assign_attri("", false, "AV26VarScrapTDoc", AV26VarScrapTDoc);
      httpContext.ajax_rsp_assign_attri("", false, "AV15VarBusGoogle", AV15VarBusGoogle);
      httpContext.ajax_rsp_assign_attri("", false, "AV17VarBusWeb", AV17VarBusWeb);
      httpContext.ajax_rsp_assign_attri("", false, "AV30VarScrapFin", AV30VarScrapFin);
      GXv_char9[0] = AV11OpeCliDescrip ;
      GXv_char8[0] = AV10OpeCliCodFormula ;
      new web.getopeclidescripyformula(remoteHandle, context).execute( AV8CliCod, AV5OpeCliId, GXv_char9, GXv_char8) ;
      variablescrape_impl.this.AV11OpeCliDescrip = GXv_char9[0] ;
      variablescrape_impl.this.AV10OpeCliCodFormula = GXv_char8[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11OpeCliDescrip", AV11OpeCliDescrip);
      httpContext.ajax_rsp_assign_attri("", false, "AV10OpeCliCodFormula", AV10OpeCliCodFormula);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOPECLICODFORMULA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10OpeCliCodFormula, ""))));
      /* Execute user subroutine: 'SCRAPE' */
      S112 ();
      if (returnInSub) return;
      cmbavClirelsec.removeAllItems();
      cmbavClirelsec.addItem("0", httpContext.getMessage( "Seleccionar", ""), (short)(0));
      /* Using cursor H00KJ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = H00KJ2_A3CliCod[0] ;
         A1880CliReDTChar = H00KJ2_A1880CliReDTChar[0] ;
         A1885CliRelSec = H00KJ2_A1885CliRelSec[0] ;
         cmbavClirelsec.addItem(GXutil.trim( GXutil.str( A1885CliRelSec, 6, 0)), GXutil.trim( A1880CliReDTChar), (short)(0));
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void e13KJ2( )
   {
      /* 'DoGrabar' Routine */
      returnInSub = false ;
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV20OpeCliVig)) || (GXutil.strcmp("", AV13OpeCliValor)==0) )
      {
         AV19error = httpContext.getMessage( "Debe ingresar fecha y valor", "") ;
         httpContext.GX_msglist.addItem(AV19error);
         new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, AV19error) ;
      }
      else
      {
         if ( (0==AV14CliRelSec) )
         {
            AV19error = httpContext.getMessage( "Debe ingresar fecha de liberación", "") ;
            httpContext.GX_msglist.addItem(AV19error);
            new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, AV19error) ;
         }
         else
         {
            GXv_boolean10[0] = AV22aplicadoHay ;
            new web.validarfecharelease(remoteHandle, context).execute( AV8CliCod, AV14CliRelSec, GXv_boolean10) ;
            variablescrape_impl.this.AV22aplicadoHay = GXv_boolean10[0] ;
            if ( AV22aplicadoHay )
            {
               GXt_char11 = AV19error ;
               GXv_char9[0] = GXt_char11 ;
               new web.txterrorrelease(remoteHandle, context).execute( AV8CliCod, GXv_char9) ;
               variablescrape_impl.this.GXt_char11 = GXv_char9[0] ;
               AV19error = GXt_char11 ;
               httpContext.GX_msglist.addItem(AV19error);
               new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, AV19error) ;
            }
            else
            {
               new web.grabaopecli(remoteHandle, context).execute( AV8CliCod, AV5OpeCliId, AV10OpeCliCodFormula, AV10OpeCliCodFormula, AV11OpeCliDescrip, AV13OpeCliValor, "", AV20OpeCliVig, AV23date, false, 0, AV14CliRelSec, AV8CliCod) ;
               httpContext.setWebReturnParms(new Object[] {});
               httpContext.setWebReturnParmsMetadata(new Object[] {});
               httpContext.wjLocDisableFrm = (byte)(1) ;
               httpContext.nUserReturn = (byte)(1) ;
               returnInSub = true;
               if (true) return;
            }
         }
      }
   }

   public void e14KJ2( )
   {
      /* 'DoBuscar' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'SCRAPE' */
      S112 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void S122( )
   {
      /* 'CHECKREQUIREDFIELDS' Routine */
      returnInSub = false ;
      AV21CheckRequiredFieldsResult = true ;
      if ( (0==AV14CliRelSec) )
      {
         httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Fecha/hora de liberación", ""), "", "", "", "", "", "", "", ""), "error", cmbavClirelsec.getInternalname(), "true", ""));
         AV21CheckRequiredFieldsResult = false ;
      }
   }

   public void e15KJ2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV8CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      variablescrape_impl.this.GXt_int1 = GXv_int2[0] ;
      AV8CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CliCod), "ZZZZZ9")));
      /*  Sending Event outputs  */
   }

   public void S112( )
   {
      /* 'SCRAPE' Routine */
      returnInSub = false ;
      GXv_char9[0] = AV27scrape_OpeCliValor ;
      GXv_char8[0] = AV18Url ;
      GXv_char7[0] = AV19error ;
      new web.scrape(remoteHandle, context).execute( AV8CliCod, AV16VarBaseURL, AV25VarScrapTipo, AV26VarScrapTDoc, AV15VarBusGoogle, AV17VarBusWeb, AV30VarScrapFin, GXutil.trim( AV5OpeCliId), GXv_char9, GXv_char8, GXv_char7) ;
      variablescrape_impl.this.AV27scrape_OpeCliValor = GXv_char9[0] ;
      variablescrape_impl.this.AV18Url = GXv_char8[0] ;
      variablescrape_impl.this.AV19error = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27scrape_OpeCliValor", AV27scrape_OpeCliValor);
      httpContext.ajax_rsp_assign_attri("", false, "AV18Url", AV18Url);
      if ( ! (GXutil.strcmp("", AV19error)==0) )
      {
         httpContext.GX_msglist.addItem(AV19error);
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV18Url)==0) )
         {
            edtavUrl_Link = formatLink(AV18Url, new String[] {}, new String[] {})  ;
            httpContext.ajax_rsp_assign_prop("", false, edtavUrl_Internalname, "Link", edtavUrl_Link, true);
         }
      }
      tblTablerecap_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, tblTablerecap_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblTablerecap_Visible), 5, 0), true);
      imgWarningicon_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, imgWarningicon_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgWarningicon_Visible), 5, 0), true);
      if ( (GXutil.strcmp("", AV27scrape_OpeCliValor)==0) )
      {
         AV13OpeCliValor = "" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13OpeCliValor", AV13OpeCliValor);
         bttBtngrabar_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtngrabar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtngrabar_Visible), 5, 0), true);
         if ( (GXutil.strcmp("", AV19error)==0) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "No se encontró valor con la búsqueda especificada", ""));
         }
      }
      else
      {
         bttBtngrabar_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtngrabar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtngrabar_Visible), 5, 0), true);
         edtavOpeclivalor_Fontbold = (byte)(1) ;
         httpContext.ajax_rsp_assign_prop("", false, edtavOpeclivalor_Internalname, "Fontbold", GXutil.str( edtavOpeclivalor_Fontbold, 1, 0), true);
         if ( CommonUtil.decimalVal( AV27scrape_OpeCliValor, ".").doubleValue() > 0 )
         {
            AV28numeroEs = true ;
         }
         else
         {
            AV28numeroEs = false ;
         }
         if ( AV28numeroEs )
         {
            AV13OpeCliValor = GXutil.trim( AV27scrape_OpeCliValor) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV13OpeCliValor", AV13OpeCliValor);
            AV19error = "" ;
         }
         else
         {
            GXv_char9[0] = AV13OpeCliValor ;
            GXv_char8[0] = AV29valorCrudo ;
            GXv_char7[0] = AV19error ;
            new web.parseartextovariables(remoteHandle, context).execute( AV5OpeCliId, AV27scrape_OpeCliValor, GXv_char9, GXv_char8, GXv_char7) ;
            variablescrape_impl.this.AV13OpeCliValor = GXv_char9[0] ;
            variablescrape_impl.this.AV29valorCrudo = GXv_char8[0] ;
            variablescrape_impl.this.AV19error = GXv_char7[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "AV13OpeCliValor", AV13OpeCliValor);
            httpContext.ajax_rsp_assign_attri("", false, "AV29valorCrudo", AV29valorCrudo);
         }
         if ( ! (GXutil.strcmp("", AV19error)==0) )
         {
            httpContext.GX_msglist.addItem(AV19error);
            new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, AV19error) ;
            AV13OpeCliValor = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV13OpeCliValor", AV13OpeCliValor);
         }
         else
         {
            AV27scrape_OpeCliValor = GXutil.strReplace( AV27scrape_OpeCliValor, GXutil.trim( AV29valorCrudo), httpContext.getMessage( "<b>", "")+GXutil.trim( AV29valorCrudo)+httpContext.getMessage( "</b>", "")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27scrape_OpeCliValor", AV27scrape_OpeCliValor);
            GXv_char9[0] = AV24ultiOpeCliValor ;
            GXv_date3[0] = AV23date ;
            new web.getopecliultivaloryfecha(remoteHandle, context).execute( AV8CliCod, AV5OpeCliId, AV20OpeCliVig, GXv_char9, GXv_date3) ;
            variablescrape_impl.this.AV24ultiOpeCliValor = GXv_char9[0] ;
            variablescrape_impl.this.AV23date = GXv_date3[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23date", localUtil.format(AV23date, "99/99/99"));
            if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV13OpeCliValor)), GXutil.upper( GXutil.trim( AV24ultiOpeCliValor))) == 0 )
            {
               imgWarningicon_Visible = 1 ;
               httpContext.ajax_rsp_assign_prop("", false, imgWarningicon_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgWarningicon_Visible), 5, 0), true);
               imgWarningicon_Tooltiptext = httpContext.getMessage( "El valor es igual al valor más reciente", "") ;
               httpContext.ajax_rsp_assign_prop("", false, imgWarningicon_Internalname, "Tooltiptext", imgWarningicon_Tooltiptext, true);
            }
         }
      }
   }

   protected void nextLoad( )
   {
   }

   protected void e16KJ2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void wb_table1_53_KJ2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         if ( tblTablerecap_Visible == 0 )
         {
            sStyleString += "display:none;" ;
         }
         web.GxWebStd.gx_table_start( httpContext, tblTablerecap_Internalname, tblTablerecap_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavVarbusgoogle_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavVarbusgoogle_Internalname, httpContext.getMessage( "Buscar en google", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 58,'',false,'',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtavVarbusgoogle_Internalname, AV15VarBusGoogle, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,58);\"", (short)(0), 1, edtavVarbusgoogle_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_VariableScrape.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavVarbaseurl_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavVarbaseurl_Internalname, httpContext.getMessage( "Solo resultados de la página", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavVarbaseurl_Internalname, AV16VarBaseURL, GXutil.rtrim( localUtil.format( AV16VarBaseURL, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,63);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavVarbaseurl_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavVarbaseurl_Enabled, 0, "text", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "left", true, "", "HLP_VariableScrape.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavVarbusweb_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavVarbusweb_Internalname, httpContext.getMessage( "Buscar el título", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 68,'',false,'',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtavVarbusweb_Internalname, AV17VarBusWeb, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,68);\"", (short)(0), 1, edtavVarbusweb_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_VariableScrape.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavVarscrapfin_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavVarscrapfin_Internalname, httpContext.getMessage( "Hasta", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 73,'',false,'',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtavVarscrapfin_Internalname, AV30VarScrapFin, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,73);\"", (short)(0), 1, edtavVarscrapfin_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_VariableScrape.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavVarscraptdoc.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavVarscraptdoc.getInternalname(), httpContext.getMessage( "En documentos tipo", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 78,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavVarscraptdoc, cmbavVarscraptdoc.getInternalname(), GXutil.rtrim( AV26VarScrapTDoc), 1, cmbavVarscraptdoc.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavVarscraptdoc.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,78);\"", "", true, (byte)(0), "HLP_VariableScrape.htm");
         cmbavVarscraptdoc.setValue( GXutil.rtrim( AV26VarScrapTDoc) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavVarscraptdoc.getInternalname(), "Values", cmbavVarscraptdoc.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavVarscraptipo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavVarscraptipo.getInternalname(), httpContext.getMessage( "En", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 83,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavVarscraptipo, cmbavVarscraptipo.getInternalname(), GXutil.rtrim( AV25VarScrapTipo), 1, cmbavVarscraptipo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavVarscraptipo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,83);\"", "", true, (byte)(0), "HLP_VariableScrape.htm");
         cmbavVarscraptipo.setValue( GXutil.rtrim( AV25VarScrapTipo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavVarscraptipo.getInternalname(), "Values", cmbavVarscraptipo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 86,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnbuscar_Internalname, "", httpContext.getMessage( "Buscar", ""), bttBtnbuscar_Jsonclick, 5, httpContext.getMessage( "Buscar", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOBUSCAR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_VariableScrape.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_53_KJ2e( true) ;
      }
      else
      {
         wb_table1_53_KJ2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV5OpeCliId = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5OpeCliId", AV5OpeCliId);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOPECLIID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV5OpeCliId, ""))));
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
      paKJ2( ) ;
      wsKJ2( ) ;
      weKJ2( ) ;
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
      httpContext.AddStyleSheetFile("calendar-system.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122020435647", true, true);
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
      httpContext.AddJavascriptSource("variablescrape.js", "?2024122020435647", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtavOpeclicodformula_Internalname = "vOPECLICODFORMULA" ;
      edtavOpeclidescrip_Internalname = "vOPECLIDESCRIP" ;
      edtavOpeclivig_Internalname = "vOPECLIVIG" ;
      edtavOpeclivalor_Internalname = "vOPECLIVALOR" ;
      imgWarningicon_Internalname = "WARNINGICON" ;
      edtavUrl_Internalname = "vURL" ;
      edtavScrape_opeclivalor_Internalname = "vSCRAPE_OPECLIVALOR" ;
      cmbavClirelsec.setInternalname( "vCLIRELSEC" );
      bttBtnrecapturar_Internalname = "BTNRECAPTURAR" ;
      edtavVarbusgoogle_Internalname = "vVARBUSGOOGLE" ;
      edtavVarbaseurl_Internalname = "vVARBASEURL" ;
      edtavVarbusweb_Internalname = "vVARBUSWEB" ;
      edtavVarscrapfin_Internalname = "vVARSCRAPFIN" ;
      cmbavVarscraptdoc.setInternalname( "vVARSCRAPTDOC" );
      cmbavVarscraptipo.setInternalname( "vVARSCRAPTIPO" );
      bttBtnbuscar_Internalname = "BTNBUSCAR" ;
      tblTablerecap_Internalname = "TABLERECAP" ;
      bttBtngrabar_Internalname = "BTNGRABAR" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavOpecliid_Internalname = "vOPECLIID" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
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
      cmbavVarscraptipo.setJsonclick( "" );
      cmbavVarscraptipo.setEnabled( 1 );
      cmbavVarscraptdoc.setJsonclick( "" );
      cmbavVarscraptdoc.setEnabled( 1 );
      edtavVarscrapfin_Enabled = 1 ;
      edtavVarbusweb_Enabled = 1 ;
      edtavVarbaseurl_Jsonclick = "" ;
      edtavVarbaseurl_Enabled = 1 ;
      edtavVarbusgoogle_Enabled = 1 ;
      tblTablerecap_Visible = 1 ;
      edtavOpecliid_Jsonclick = "" ;
      edtavOpecliid_Visible = 1 ;
      bttBtngrabar_Visible = 1 ;
      cmbavClirelsec.setJsonclick( "" );
      cmbavClirelsec.setEnabled( 1 );
      edtavScrape_opeclivalor_Enabled = 1 ;
      edtavUrl_Jsonclick = "" ;
      edtavUrl_Linktarget = "" ;
      edtavUrl_Link = "" ;
      edtavUrl_Enabled = 1 ;
      imgWarningicon_Visible = 1 ;
      imgWarningicon_Tooltiptext = "" ;
      edtavOpeclivalor_Fontbold = (byte)(0) ;
      edtavOpeclivalor_Enabled = 1 ;
      edtavOpeclivig_Jsonclick = "" ;
      edtavOpeclivig_Enabled = 1 ;
      edtavOpeclidescrip_Enabled = 1 ;
      edtavOpeclicodformula_Jsonclick = "" ;
      edtavOpeclicodformula_Enabled = 1 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Variable Scrape", "") );
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      cmbavClirelsec.setName( "vCLIRELSEC" );
      cmbavClirelsec.setWebtags( "" );
      cmbavClirelsec.addItem(GXutil.trim( GXutil.str( 0, 6, 0)), httpContext.getMessage( "GX_EmptyItemText", ""), (short)(0));
      if ( cmbavClirelsec.getItemCount() > 0 )
      {
         AV14CliRelSec = (int)(GXutil.lval( cmbavClirelsec.getValidValue(GXutil.trim( GXutil.str( AV14CliRelSec, 6, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14CliRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14CliRelSec), 6, 0));
      }
      cmbavVarscraptdoc.setName( "vVARSCRAPTDOC" );
      cmbavVarscraptdoc.setWebtags( "" );
      cmbavVarscraptdoc.addItem("HTML", httpContext.getMessage( "Html", ""), (short)(0));
      cmbavVarscraptdoc.addItem("PDF", httpContext.getMessage( "PDF", ""), (short)(0));
      if ( cmbavVarscraptdoc.getItemCount() > 0 )
      {
         AV26VarScrapTDoc = cmbavVarscraptdoc.getValidValue(AV26VarScrapTDoc) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26VarScrapTDoc", AV26VarScrapTDoc);
      }
      cmbavVarscraptipo.setName( "vVARSCRAPTIPO" );
      cmbavVarscraptipo.setWebtags( "" );
      cmbavVarscraptipo.addItem("Tabla", httpContext.getMessage( "Tabla", ""), (short)(0));
      cmbavVarscraptipo.addItem("Texto", httpContext.getMessage( "Texto", ""), (short)(0));
      cmbavVarscraptipo.addItem("Imagen", httpContext.getMessage( "Imagen", ""), (short)(0));
      if ( cmbavVarscraptipo.getItemCount() > 0 )
      {
         AV25VarScrapTipo = cmbavVarscraptipo.getValidValue(AV25VarScrapTipo) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25VarScrapTipo", AV25VarScrapTipo);
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV34Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV10OpeCliCodFormula',fld:'vOPECLICODFORMULA',pic:'',hsh:true},{av:'AV5OpeCliId',fld:'vOPECLIID',pic:'',hsh:true},{av:'AV11OpeCliDescrip',fld:'vOPECLIDESCRIP',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]}");
      setEventMetadata("'DORECAPTURAR'","{handler:'e11KJ1',iparms:[]");
      setEventMetadata("'DORECAPTURAR'",",oparms:[{av:'tblTablerecap_Visible',ctrl:'TABLERECAP',prop:'Visible'}]}");
      setEventMetadata("'DOGRABAR'","{handler:'e13KJ2',iparms:[{av:'AV20OpeCliVig',fld:'vOPECLIVIG',pic:''},{av:'AV13OpeCliValor',fld:'vOPECLIVALOR',pic:''},{av:'AV34Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'cmbavClirelsec'},{av:'AV14CliRelSec',fld:'vCLIRELSEC',pic:'ZZZZZ9'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV5OpeCliId',fld:'vOPECLIID',pic:'',hsh:true},{av:'AV10OpeCliCodFormula',fld:'vOPECLICODFORMULA',pic:'',hsh:true},{av:'AV11OpeCliDescrip',fld:'vOPECLIDESCRIP',pic:''},{av:'AV23date',fld:'vDATE',pic:''}]");
      setEventMetadata("'DOGRABAR'",",oparms:[]}");
      setEventMetadata("'DOBUSCAR'","{handler:'e14KJ2',iparms:[{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV16VarBaseURL',fld:'vVARBASEURL',pic:''},{av:'cmbavVarscraptipo'},{av:'AV25VarScrapTipo',fld:'vVARSCRAPTIPO',pic:''},{av:'cmbavVarscraptdoc'},{av:'AV26VarScrapTDoc',fld:'vVARSCRAPTDOC',pic:''},{av:'AV15VarBusGoogle',fld:'vVARBUSGOOGLE',pic:''},{av:'AV17VarBusWeb',fld:'vVARBUSWEB',pic:''},{av:'AV30VarScrapFin',fld:'vVARSCRAPFIN',pic:''},{av:'AV5OpeCliId',fld:'vOPECLIID',pic:'',hsh:true},{av:'AV34Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV29valorCrudo',fld:'vVALORCRUDO',pic:''},{av:'AV20OpeCliVig',fld:'vOPECLIVIG',pic:''}]");
      setEventMetadata("'DOBUSCAR'",",oparms:[{av:'AV18Url',fld:'vURL',pic:''},{av:'AV27scrape_OpeCliValor',fld:'vSCRAPE_OPECLIVALOR',pic:''},{av:'edtavUrl_Link',ctrl:'vURL',prop:'Link'},{av:'tblTablerecap_Visible',ctrl:'TABLERECAP',prop:'Visible'},{av:'imgWarningicon_Visible',ctrl:'WARNINGICON',prop:'Visible'},{av:'edtavOpeclivalor_Fontbold',ctrl:'vOPECLIVALOR',prop:'Fontbold'},{av:'AV29valorCrudo',fld:'vVALORCRUDO',pic:''},{av:'AV23date',fld:'vDATE',pic:''},{av:'imgWarningicon_Tooltiptext',ctrl:'WARNINGICON',prop:'Tooltiptext'},{av:'AV13OpeCliValor',fld:'vOPECLIVALOR',pic:''},{ctrl:'BTNGRABAR',prop:'Visible'}]}");
      setEventMetadata("VALIDV_URL","{handler:'validv_Url',iparms:[]");
      setEventMetadata("VALIDV_URL",",oparms:[]}");
      setEventMetadata("VALIDV_VARBASEURL","{handler:'validv_Varbaseurl',iparms:[]");
      setEventMetadata("VALIDV_VARBASEURL",",oparms:[]}");
      setEventMetadata("VALIDV_VARSCRAPTDOC","{handler:'validv_Varscraptdoc',iparms:[]");
      setEventMetadata("VALIDV_VARSCRAPTDOC",",oparms:[]}");
      setEventMetadata("VALIDV_VARSCRAPTIPO","{handler:'validv_Varscraptipo',iparms:[]");
      setEventMetadata("VALIDV_VARSCRAPTIPO",",oparms:[]}");
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
      wcpOAV5OpeCliId = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV5OpeCliId = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      AV34Pgmname = "" ;
      AV10OpeCliCodFormula = "" ;
      GXKey = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      AV11OpeCliDescrip = "" ;
      AV23date = GXutil.nullDate() ;
      AV29valorCrudo = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      AV20OpeCliVig = GXutil.nullDate() ;
      AV13OpeCliValor = "" ;
      imgWarningicon_gximage = "" ;
      sImgUrl = "" ;
      AV18Url = "" ;
      AV27scrape_OpeCliValor = "" ;
      bttBtnrecapturar_Jsonclick = "" ;
      bttBtngrabar_Jsonclick = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV26VarScrapTDoc = "" ;
      AV25VarScrapTipo = "" ;
      AV15VarBusGoogle = "" ;
      AV16VarBaseURL = "" ;
      AV17VarBusWeb = "" ;
      AV30VarScrapFin = "" ;
      hsh = "" ;
      GXv_char4 = new String[1] ;
      GXv_char5 = new String[1] ;
      GXv_char6 = new String[1] ;
      scmdbuf = "" ;
      H00KJ2_A3CliCod = new int[1] ;
      H00KJ2_A1880CliReDTChar = new String[] {""} ;
      H00KJ2_A1885CliRelSec = new int[1] ;
      A1880CliReDTChar = "" ;
      AV19error = "" ;
      GXv_boolean10 = new boolean[1] ;
      GXt_char11 = "" ;
      GXv_int2 = new int[1] ;
      GXv_char8 = new String[1] ;
      GXv_char7 = new String[1] ;
      AV24ultiOpeCliValor = "" ;
      GXv_char9 = new String[1] ;
      GXv_date3 = new java.util.Date[1] ;
      sStyleString = "" ;
      bttBtnbuscar_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.variablescrape__default(),
         new Object[] {
             new Object[] {
            H00KJ2_A3CliCod, H00KJ2_A1880CliReDTChar, H00KJ2_A1885CliRelSec
            }
         }
      );
      AV34Pgmname = "VariableScrape" ;
      /* GeneXus formulas. */
      AV34Pgmname = "VariableScrape" ;
      Gx_err = (short)(0) ;
      edtavOpeclicodformula_Enabled = 0 ;
      edtavOpeclidescrip_Enabled = 0 ;
      edtavOpeclivalor_Enabled = 0 ;
      edtavUrl_Enabled = 0 ;
      edtavScrape_opeclivalor_Enabled = 0 ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte edtavOpeclivalor_Fontbold ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int edtavOpeclicodformula_Enabled ;
   private int edtavOpeclidescrip_Enabled ;
   private int edtavOpeclivig_Enabled ;
   private int edtavOpeclivalor_Enabled ;
   private int imgWarningicon_Visible ;
   private int edtavUrl_Enabled ;
   private int edtavScrape_opeclivalor_Enabled ;
   private int AV14CliRelSec ;
   private int bttBtngrabar_Visible ;
   private int edtavOpecliid_Visible ;
   private int A3CliCod ;
   private int A1885CliRelSec ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int tblTablerecap_Visible ;
   private int edtavVarbusgoogle_Enabled ;
   private int edtavVarbaseurl_Enabled ;
   private int edtavVarbusweb_Enabled ;
   private int edtavVarscrapfin_Enabled ;
   private int idxLst ;
   private String wcpOAV5OpeCliId ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV5OpeCliId ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String AV34Pgmname ;
   private String AV10OpeCliCodFormula ;
   private String GXKey ;
   private String AV29valorCrudo ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String divTablecontent_Internalname ;
   private String edtavOpeclicodformula_Internalname ;
   private String TempTags ;
   private String edtavOpeclicodformula_Jsonclick ;
   private String edtavOpeclidescrip_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtavOpeclivig_Internalname ;
   private String edtavOpeclivig_Jsonclick ;
   private String edtavOpeclivalor_Internalname ;
   private String imgWarningicon_gximage ;
   private String sImgUrl ;
   private String imgWarningicon_Internalname ;
   private String imgWarningicon_Tooltiptext ;
   private String edtavUrl_Internalname ;
   private String edtavUrl_Link ;
   private String edtavUrl_Linktarget ;
   private String edtavUrl_Jsonclick ;
   private String edtavScrape_opeclivalor_Internalname ;
   private String bttBtnrecapturar_Internalname ;
   private String bttBtnrecapturar_Jsonclick ;
   private String bttBtngrabar_Internalname ;
   private String bttBtngrabar_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtavOpecliid_Internalname ;
   private String edtavOpecliid_Jsonclick ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV26VarScrapTDoc ;
   private String AV25VarScrapTipo ;
   private String edtavVarbusgoogle_Internalname ;
   private String edtavVarbaseurl_Internalname ;
   private String edtavVarbusweb_Internalname ;
   private String edtavVarscrapfin_Internalname ;
   private String hsh ;
   private String GXv_char4[] ;
   private String GXv_char5[] ;
   private String GXv_char6[] ;
   private String scmdbuf ;
   private String GXt_char11 ;
   private String tblTablerecap_Internalname ;
   private String GXv_char8[] ;
   private String GXv_char7[] ;
   private String GXv_char9[] ;
   private String sStyleString ;
   private String edtavVarbaseurl_Jsonclick ;
   private String bttBtnbuscar_Internalname ;
   private String bttBtnbuscar_Jsonclick ;
   private java.util.Date AV23date ;
   private java.util.Date AV20OpeCliVig ;
   private java.util.Date GXv_date3[] ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV22aplicadoHay ;
   private boolean GXv_boolean10[] ;
   private boolean AV21CheckRequiredFieldsResult ;
   private boolean AV28numeroEs ;
   private String AV13OpeCliValor ;
   private String AV27scrape_OpeCliValor ;
   private String AV24ultiOpeCliValor ;
   private String AV11OpeCliDescrip ;
   private String AV18Url ;
   private String AV15VarBusGoogle ;
   private String AV16VarBaseURL ;
   private String AV17VarBusWeb ;
   private String AV30VarScrapFin ;
   private String A1880CliReDTChar ;
   private String AV19error ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbavClirelsec ;
   private HTMLChoice cmbavVarscraptdoc ;
   private HTMLChoice cmbavVarscraptipo ;
   private IDataStoreProvider pr_default ;
   private int[] H00KJ2_A3CliCod ;
   private String[] H00KJ2_A1880CliReDTChar ;
   private int[] H00KJ2_A1885CliRelSec ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class variablescrape__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00KJ2", "SELECT CliCod, CliReDTChar, CliRelSec FROM Cliente_Release WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
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
               return;
      }
   }

}

