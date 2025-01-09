package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class empbasehoranormal_impl extends GXDataArea
{
   public empbasehoranormal_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public empbasehoranormal_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empbasehoranormal_impl.class ));
   }

   public empbasehoranormal_impl( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavWelcomemessage_nomostrarmas = UIFactory.getCheckbox(this);
      cmbavEmpresabase_calculo_empbaseclaseleg = new HTMLChoice();
      cmbavEmpresabase_calculo_empbasetipo = new HTMLChoice();
      cmbavEmpresabase_calculo_empbasepromtcnt = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "TrnMode") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "TrnMode") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "TrnMode") ;
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
            AV18TrnMode = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV18TrnMode", AV18TrnMode);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV18TrnMode, ""))));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV22CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV22CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22CliCod), 6, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV22CliCod), "ZZZZZ9")));
               AV23EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV23EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23EmpCod), 4, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV23EmpCod), "ZZZ9")));
               AV24EmpBaseClaseLeg = (byte)(GXutil.lval( httpContext.GetPar( "EmpBaseClaseLeg"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV24EmpBaseClaseLeg", GXutil.str( AV24EmpBaseClaseLeg, 1, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASECLASELEG", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV24EmpBaseClaseLeg), "9")));
               AV25EmpBaseTipo = httpContext.GetPar( "EmpBaseTipo") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV25EmpBaseTipo", AV25EmpBaseTipo);
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASETIPO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV25EmpBaseTipo, ""))));
               AV26EmpBaseCod1 = httpContext.GetPar( "EmpBaseCod1") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV26EmpBaseCod1", AV26EmpBaseCod1);
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASECOD1", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV26EmpBaseCod1, ""))));
               AV27EmpBaseCod2 = httpContext.GetPar( "EmpBaseCod2") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV27EmpBaseCod2", AV27EmpBaseCod2);
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASECOD2", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV27EmpBaseCod2, ""))));
               AV28MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV28MenuOpcCod", AV28MenuOpcCod);
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV28MenuOpcCod, ""))));
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
         MasterPageObj= createMasterPage(remoteHandle, "web.wwpbaseobjects.newmasterpage");
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
      paOF2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startOF2( ) ;
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.empbasehoranormal", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18TrnMode)),GXutil.URLEncode(GXutil.ltrimstr(AV22CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV23EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV24EmpBaseClaseLeg,1,0)),GXutil.URLEncode(GXutil.rtrim(AV25EmpBaseTipo)),GXutil.URLEncode(GXutil.rtrim(AV26EmpBaseCod1)),GXutil.URLEncode(GXutil.rtrim(AV27EmpBaseCod2)),GXutil.URLEncode(GXutil.rtrim(AV28MenuOpcCod))}, new String[] {"TrnMode","CliCod","EmpCod","EmpBaseClaseLeg","EmpBaseTipo","EmpBaseCod1","EmpBaseCod2","MenuOpcCod"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV18TrnMode, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV28MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV22CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV23EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASECLASELEG", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV24EmpBaseClaseLeg), "9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASETIPO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV25EmpBaseTipo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASECOD1", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV26EmpBaseCod1, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASECOD2", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV27EmpBaseCod2, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Empresabase_calculo", AV12Empresabase_calculo);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Empresabase_calculo", AV12Empresabase_calculo);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTRNMODE", GXutil.rtrim( AV18TrnMode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV18TrnMode, ""))));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vCHECKREQUIREDFIELDSRESULT", AV20CheckRequiredFieldsResult);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMESSAGES", AV17Messages);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMESSAGES", AV17Messages);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV28MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV28MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV22CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV22CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV23EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV23EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPBASECLASELEG", GXutil.ltrim( localUtil.ntoc( AV24EmpBaseClaseLeg, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASECLASELEG", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV24EmpBaseClaseLeg), "9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPBASETIPO", GXutil.rtrim( AV25EmpBaseTipo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASETIPO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV25EmpBaseTipo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPBASECOD1", GXutil.rtrim( AV26EmpBaseCod1));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASECOD1", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV26EmpBaseCod1, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPBASECOD2", GXutil.rtrim( AV27EmpBaseCod2));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASECOD2", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV27EmpBaseCod2, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vEMPRESABASE_CALCULO", AV12Empresabase_calculo);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vEMPRESABASE_CALCULO", AV12Empresabase_calculo);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Width", GXutil.rtrim( Dvpanel_tableattributes_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autowidth", GXutil.booltostr( Dvpanel_tableattributes_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoheight", GXutil.booltostr( Dvpanel_tableattributes_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Cls", GXutil.rtrim( Dvpanel_tableattributes_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Title", GXutil.rtrim( Dvpanel_tableattributes_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsible", GXutil.booltostr( Dvpanel_tableattributes_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsed", GXutil.booltostr( Dvpanel_tableattributes_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Showcollapseicon", GXutil.booltostr( Dvpanel_tableattributes_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Iconposition", GXutil.rtrim( Dvpanel_tableattributes_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoscroll", GXutil.booltostr( Dvpanel_tableattributes_Autoscroll));
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
         weOF2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtOF2( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return true ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("web.empbasehoranormal", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18TrnMode)),GXutil.URLEncode(GXutil.ltrimstr(AV22CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV23EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV24EmpBaseClaseLeg,1,0)),GXutil.URLEncode(GXutil.rtrim(AV25EmpBaseTipo)),GXutil.URLEncode(GXutil.rtrim(AV26EmpBaseCod1)),GXutil.URLEncode(GXutil.rtrim(AV27EmpBaseCod2)),GXutil.URLEncode(GXutil.rtrim(AV28MenuOpcCod))}, new String[] {"TrnMode","CliCod","EmpCod","EmpBaseClaseLeg","EmpBaseTipo","EmpBaseCod1","EmpBaseCod2","MenuOpcCod"})  ;
   }

   public String getPgmname( )
   {
      return "EmpBaseHoraNormal" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Emp Base Hora Normal", "") ;
   }

   public void wbOF0( )
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
         web.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", divLayoutmaintable_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMain", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_welcometableparent_Internalname, divWelcomemessage_welcometableparent_Visible, 0, "px", 0, "px", "WelcomeTableParent", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_welcometableprincipal_Internalname, 1, 0, "px", 0, "px", "WelcomeHeaderItem", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_tableclose_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "justify-content:flex-end;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_closehelp_Internalname, lblWelcomemessage_closehelp_Caption, "", "", lblWelcomemessage_closehelp_Jsonclick, "'"+""+"'"+",false,"+"'"+"e11of1_client"+"'", "", "TextBlock", 7, "", 1, 1, 0, (short)(1), "HLP_EmpBaseHoraNormal.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_welcomecontentitem_Internalname, 1, 0, "px", 0, "px", "WelcomeContentItem", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_welcomecontentflex_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "WelcomeTableImagenCell", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_welcometableimagen_Internalname, 1, 0, "px", 0, "px", "WelcomeTableImagen", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;align-items:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, "", httpContext.getMessage( "Welcome Message_Foto", ""), "gx-form-item WelcomeImagenLabel", 0, true, "width: 25%;");
         /* Static Bitmap Variable */
         ClassString = "WelcomeImagen" + " " + ((GXutil.strcmp(imgavWelcomemessage_foto_gximage, "")==0) ? "" : "GX_Image_"+imgavWelcomemessage_foto_gximage+"_Class") ;
         StyleString = "" ;
         AV15WelcomeMessage_Foto_IsBlob = (boolean)(((GXutil.strcmp("", AV15WelcomeMessage_Foto)==0)&&(GXutil.strcmp("", AV40Welcomemessage_foto_GXI)==0))||!(GXutil.strcmp("", AV15WelcomeMessage_Foto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV15WelcomeMessage_Foto)==0) ? AV40Welcomemessage_foto_GXI : httpContext.getResourceRelative(AV15WelcomeMessage_Foto)) ;
         web.GxWebStd.gx_bitmap( httpContext, imgavWelcomemessage_foto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, imgavWelcomemessage_foto_Enabled, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV15WelcomeMessage_Foto_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_EmpBaseHoraNormal.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "WelcomeTableTextoCell", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_tabletexto_Internalname, 1, 0, "px", 0, "px", "WelcomeTableTexto", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;align-items:flex-start;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table1_24_OF2( true) ;
      }
      else
      {
         wb_table1_24_OF2( false) ;
      }
      return  ;
   }

   public void wb_table1_24_OF2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table2_29_OF2( true) ;
      }
      else
      {
         wb_table2_29_OF2( false) ;
      }
      return  ;
   }

   public void wb_table2_29_OF2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_welcomebottomitem_Internalname, 1, 0, "px", 0, "px", "WelcomeBottomItem", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_tablecmb_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "justify-content:flex-end;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_tablec_Internalname, 1, 0, "px", 0, "px", "TableC font14px", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavWelcomemessage_nomostrarmas.getInternalname(), httpContext.getMessage( "Welcome Message_No Mostrar Mas", ""), "gx-form-item AttributeCheckBoxLabel", 0, true, "width: 25%;");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavWelcomemessage_nomostrarmas.getInternalname(), GXutil.booltostr( AV14WelcomeMessage_NoMostrarMas), "", httpContext.getMessage( "Welcome Message_No Mostrar Mas", ""), 1, chkavWelcomemessage_nomostrarmas.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,39);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_tabletext_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_combotext_Internalname, lblWelcomemessage_combotext_Caption, "", "", lblWelcomemessage_combotext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTextNomm", 0, "", 1, 1, 0, (short)(0), "HLP_EmpBaseHoraNormal.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Padding0", "left", "top", "", "", "div");
         wb_table3_46_OF2( true) ;
      }
      else
      {
         wb_table3_46_OF2( false) ;
      }
      return  ;
   }

   public void wb_table3_46_OF2e( boolean wbgen )
   {
      if ( wbgen )
      {
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 98,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavEmpresabase_calculo_clicod_Internalname, GXutil.ltrim( localUtil.ntoc( AV12Empresabase_calculo.getgxTv_SdtEmpresabase_calculo_Clicod(), (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV12Empresabase_calculo.getgxTv_SdtEmpresabase_calculo_Clicod()), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,98);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEmpresabase_calculo_clicod_Jsonclick, 0, "Attribute", "", "", "", "", edtavEmpresabase_calculo_clicod_Visible, 1, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_EmpBaseHoraNormal.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 99,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavEmpresabase_calculo_empcod_Internalname, GXutil.ltrim( localUtil.ntoc( AV12Empresabase_calculo.getgxTv_SdtEmpresabase_calculo_Empcod(), (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV12Empresabase_calculo.getgxTv_SdtEmpresabase_calculo_Empcod()), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,99);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEmpresabase_calculo_empcod_Jsonclick, 0, "Attribute", "", "", "", "", edtavEmpresabase_calculo_empcod_Visible, 1, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_EmpBaseHoraNormal.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 100,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavEmpresabase_calculo_empbasecod1_Internalname, GXutil.rtrim( AV12Empresabase_calculo.getgxTv_SdtEmpresabase_calculo_Empbasecod1()), GXutil.rtrim( localUtil.format( AV12Empresabase_calculo.getgxTv_SdtEmpresabase_calculo_Empbasecod1(), "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,100);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEmpresabase_calculo_empbasecod1_Jsonclick, 0, "Attribute", "", "", "", "", edtavEmpresabase_calculo_empbasecod1_Visible, 1, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_EmpBaseHoraNormal.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 101,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavEmpresabase_calculo_empbasecod2_Internalname, GXutil.rtrim( AV12Empresabase_calculo.getgxTv_SdtEmpresabase_calculo_Empbasecod2()), GXutil.rtrim( localUtil.format( AV12Empresabase_calculo.getgxTv_SdtEmpresabase_calculo_Empbasecod2(), "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,101);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEmpresabase_calculo_empbasecod2_Jsonclick, 0, "Attribute", "", "", "", "", edtavEmpresabase_calculo_empbasecod2_Visible, 1, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_EmpBaseHoraNormal.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void startOF2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Emp Base Hora Normal", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupOF0( ) ;
   }

   public void wsOF2( )
   {
      startOF2( ) ;
      evtOF2( ) ;
   }

   public void evtOF2( )
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
                           e12OF2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Refresh */
                           e13OF2 ();
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
                                 e14OF2 ();
                              }
                              dynload_actions( ) ;
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e15OF2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e16OF2 ();
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

   public void weOF2( )
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

   public void paOF2( )
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
            GX_FocusControl = chkavWelcomemessage_nomostrarmas.getInternalname() ;
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
      AV14WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV14WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14WelcomeMessage_NoMostrarMas", AV14WelcomeMessage_NoMostrarMas);
      if ( cmbavEmpresabase_calculo_empbaseclaseleg.getItemCount() > 0 )
      {
         AV12Empresabase_calculo.setgxTv_SdtEmpresabase_calculo_Empbaseclaseleg( (byte)(GXutil.lval( cmbavEmpresabase_calculo_empbaseclaseleg.getValidValue(GXutil.trim( GXutil.str( AV12Empresabase_calculo.getgxTv_SdtEmpresabase_calculo_Empbaseclaseleg(), 1, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavEmpresabase_calculo_empbaseclaseleg.setValue( GXutil.trim( GXutil.str( AV12Empresabase_calculo.getgxTv_SdtEmpresabase_calculo_Empbaseclaseleg(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavEmpresabase_calculo_empbaseclaseleg.getInternalname(), "Values", cmbavEmpresabase_calculo_empbaseclaseleg.ToJavascriptSource(), true);
      }
      if ( cmbavEmpresabase_calculo_empbasetipo.getItemCount() > 0 )
      {
         AV12Empresabase_calculo.setgxTv_SdtEmpresabase_calculo_Empbasetipo( cmbavEmpresabase_calculo_empbasetipo.getValidValue(AV12Empresabase_calculo.getgxTv_SdtEmpresabase_calculo_Empbasetipo()) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavEmpresabase_calculo_empbasetipo.setValue( GXutil.rtrim( AV12Empresabase_calculo.getgxTv_SdtEmpresabase_calculo_Empbasetipo()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavEmpresabase_calculo_empbasetipo.getInternalname(), "Values", cmbavEmpresabase_calculo_empbasetipo.ToJavascriptSource(), true);
      }
      if ( cmbavEmpresabase_calculo_empbasepromtcnt.getItemCount() > 0 )
      {
         AV12Empresabase_calculo.setgxTv_SdtEmpresabase_calculo_Empbasepromtcnt( cmbavEmpresabase_calculo_empbasepromtcnt.getValidValue(AV12Empresabase_calculo.getgxTv_SdtEmpresabase_calculo_Empbasepromtcnt()) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavEmpresabase_calculo_empbasepromtcnt.setValue( GXutil.rtrim( AV12Empresabase_calculo.getgxTv_SdtEmpresabase_calculo_Empbasepromtcnt()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavEmpresabase_calculo_empbasepromtcnt.getInternalname(), "Values", cmbavEmpresabase_calculo_empbasepromtcnt.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfOF2( ) ;
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
      edtavEmpnom_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEmpnom_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmpnom_Enabled), 5, 0), true);
   }

   public void rfOF2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e13OF2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e16OF2 ();
         wbOF0( ) ;
      }
   }

   public void send_integrity_lvl_hashesOF2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vTRNMODE", GXutil.rtrim( AV18TrnMode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV18TrnMode, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV28MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV28MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV22CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV22CliCod), "ZZZZZ9")));
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      edtavEmpnom_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEmpnom_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmpnom_Enabled), 5, 0), true);
      fix_multi_value_controls( ) ;
   }

   public void strupOF0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e12OF2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vEMPRESABASE_CALCULO"), AV12Empresabase_calculo);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Empresabase_calculo"), AV12Empresabase_calculo);
         /* Read saved values. */
         Dvpanel_tableattributes_Width = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Width") ;
         Dvpanel_tableattributes_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autowidth")) ;
         Dvpanel_tableattributes_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoheight")) ;
         Dvpanel_tableattributes_Cls = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Cls") ;
         Dvpanel_tableattributes_Title = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Title") ;
         Dvpanel_tableattributes_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsible")) ;
         Dvpanel_tableattributes_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsed")) ;
         Dvpanel_tableattributes_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showcollapseicon")) ;
         Dvpanel_tableattributes_Iconposition = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Iconposition") ;
         Dvpanel_tableattributes_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoscroll")) ;
         /* Read variables values. */
         AV15WelcomeMessage_Foto = httpContext.cgiGet( imgavWelcomemessage_foto_Internalname) ;
         AV14WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.cgiGet( chkavWelcomemessage_nomostrarmas.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14WelcomeMessage_NoMostrarMas", AV14WelcomeMessage_NoMostrarMas);
         AV13EmpNom = GXutil.upper( httpContext.cgiGet( edtavEmpnom_Internalname)) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13EmpNom", AV13EmpNom);
         cmbavEmpresabase_calculo_empbaseclaseleg.setValue( httpContext.cgiGet( cmbavEmpresabase_calculo_empbaseclaseleg.getInternalname()) );
         AV12Empresabase_calculo.setgxTv_SdtEmpresabase_calculo_Empbaseclaseleg( (byte)(GXutil.lval( httpContext.cgiGet( cmbavEmpresabase_calculo_empbaseclaseleg.getInternalname()))) );
         cmbavEmpresabase_calculo_empbasetipo.setValue( httpContext.cgiGet( cmbavEmpresabase_calculo_empbasetipo.getInternalname()) );
         AV12Empresabase_calculo.setgxTv_SdtEmpresabase_calculo_Empbasetipo( httpContext.cgiGet( cmbavEmpresabase_calculo_empbasetipo.getInternalname()) );
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavEmpresabase_calculo_empbasepromcnt1_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavEmpresabase_calculo_empbasepromcnt1_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPRESABASE_CALCULO_EMPBASEPROMCNT1");
            GX_FocusControl = edtavEmpresabase_calculo_empbasepromcnt1_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV12Empresabase_calculo.setgxTv_SdtEmpresabase_calculo_Empbasepromcnt1( (short)(0) );
         }
         else
         {
            AV12Empresabase_calculo.setgxTv_SdtEmpresabase_calculo_Empbasepromcnt1( (short)(localUtil.ctol( httpContext.cgiGet( edtavEmpresabase_calculo_empbasepromcnt1_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavEmpresabase_calculo_empbasepromcnt2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavEmpresabase_calculo_empbasepromcnt2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPRESABASE_CALCULO_EMPBASEPROMCNT2");
            GX_FocusControl = edtavEmpresabase_calculo_empbasepromcnt2_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV12Empresabase_calculo.setgxTv_SdtEmpresabase_calculo_Empbasepromcnt2( (short)(0) );
         }
         else
         {
            AV12Empresabase_calculo.setgxTv_SdtEmpresabase_calculo_Empbasepromcnt2( (short)(localUtil.ctol( httpContext.cgiGet( edtavEmpresabase_calculo_empbasepromcnt2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
         }
         cmbavEmpresabase_calculo_empbasepromtcnt.setValue( httpContext.cgiGet( cmbavEmpresabase_calculo_empbasepromtcnt.getInternalname()) );
         AV12Empresabase_calculo.setgxTv_SdtEmpresabase_calculo_Empbasepromtcnt( httpContext.cgiGet( cmbavEmpresabase_calculo_empbasepromtcnt.getInternalname()) );
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavEmpresabase_calculo_clicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavEmpresabase_calculo_clicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPRESABASE_CALCULO_CLICOD");
            GX_FocusControl = edtavEmpresabase_calculo_clicod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV12Empresabase_calculo.setgxTv_SdtEmpresabase_calculo_Clicod( 0 );
         }
         else
         {
            AV12Empresabase_calculo.setgxTv_SdtEmpresabase_calculo_Clicod( (int)(localUtil.ctol( httpContext.cgiGet( edtavEmpresabase_calculo_clicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavEmpresabase_calculo_empcod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavEmpresabase_calculo_empcod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPRESABASE_CALCULO_EMPCOD");
            GX_FocusControl = edtavEmpresabase_calculo_empcod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV12Empresabase_calculo.setgxTv_SdtEmpresabase_calculo_Empcod( (short)(0) );
         }
         else
         {
            AV12Empresabase_calculo.setgxTv_SdtEmpresabase_calculo_Empcod( (short)(localUtil.ctol( httpContext.cgiGet( edtavEmpresabase_calculo_empcod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
         }
         AV12Empresabase_calculo.setgxTv_SdtEmpresabase_calculo_Empbasecod1( httpContext.cgiGet( edtavEmpresabase_calculo_empbasecod1_Internalname) );
         AV12Empresabase_calculo.setgxTv_SdtEmpresabase_calculo_Empbasecod2( httpContext.cgiGet( edtavEmpresabase_calculo_empbasecod2_Internalname) );
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
      e12OF2 ();
      if (returnInSub) return;
   }

   public void e12OF2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( AV28MenuOpcCod, "", "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      AV19LoadSuccess = true ;
      if ( ( ( GXutil.strcmp(AV18TrnMode, "DSP") == 0 ) ) || ( ( GXutil.strcmp(AV18TrnMode, "INS") == 0 ) ) || ( ( GXutil.strcmp(AV18TrnMode, "UPD") == 0 ) ) || ( ( GXutil.strcmp(AV18TrnMode, "DLT") == 0 ) ) )
      {
         if ( GXutil.strcmp(AV18TrnMode, "INS") != 0 )
         {
            AV12Empresabase_calculo.Load(AV22CliCod, AV23EmpCod, AV24EmpBaseClaseLeg, AV25EmpBaseTipo, AV26EmpBaseCod1, AV27EmpBaseCod2);
            AV19LoadSuccess = AV12Empresabase_calculo.Success() ;
            if ( ! AV19LoadSuccess )
            {
               AV17Messages = AV12Empresabase_calculo.GetMessages() ;
               /* Execute user subroutine: 'SHOW MESSAGES' */
               S112 ();
               if (returnInSub) return;
            }
            if ( ( GXutil.strcmp(AV18TrnMode, "DSP") == 0 ) || ( GXutil.strcmp(AV18TrnMode, "DLT") == 0 ) )
            {
               edtavEmpresabase_calculo_empbasepromcnt1_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavEmpresabase_calculo_empbasepromcnt1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmpresabase_calculo_empbasepromcnt1_Enabled), 5, 0), true);
               edtavEmpresabase_calculo_empbasepromcnt2_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavEmpresabase_calculo_empbasepromcnt2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmpresabase_calculo_empbasepromcnt2_Enabled), 5, 0), true);
               cmbavEmpresabase_calculo_empbasepromtcnt.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop("", false, cmbavEmpresabase_calculo_empbasepromtcnt.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavEmpresabase_calculo_empbasepromtcnt.getEnabled(), 5, 0), true);
               chkavWelcomemessage_nomostrarmas.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop("", false, chkavWelcomemessage_nomostrarmas.getInternalname(), "Enabled", GXutil.ltrimstr( chkavWelcomemessage_nomostrarmas.getEnabled(), 5, 0), true);
               imgavWelcomemessage_foto_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgavWelcomemessage_foto_Enabled), 5, 0), true);
            }
            cmbavEmpresabase_calculo_empbaseclaseleg.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop("", false, cmbavEmpresabase_calculo_empbaseclaseleg.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavEmpresabase_calculo_empbaseclaseleg.getEnabled(), 5, 0), true);
            cmbavEmpresabase_calculo_empbasetipo.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop("", false, cmbavEmpresabase_calculo_empbasetipo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavEmpresabase_calculo_empbasetipo.getEnabled(), 5, 0), true);
         }
      }
      else
      {
         AV19LoadSuccess = false ;
         httpContext.setWebReturnParms(new Object[] {});
         httpContext.setWebReturnParmsMetadata(new Object[] {});
         httpContext.wjLocDisableFrm = (byte)(1) ;
         httpContext.nUserReturn = (byte)(1) ;
         returnInSub = true;
         if (true) return;
      }
      if ( AV19LoadSuccess )
      {
         if ( GXutil.strcmp(AV18TrnMode, "DLT") == 0 )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "GXM_confdelete", ""));
         }
      }
      edtavEmpresabase_calculo_clicod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEmpresabase_calculo_clicod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmpresabase_calculo_clicod_Visible), 5, 0), true);
      edtavEmpresabase_calculo_empcod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEmpresabase_calculo_empcod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmpresabase_calculo_empcod_Visible), 5, 0), true);
      edtavEmpresabase_calculo_empbasecod1_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEmpresabase_calculo_empbasecod1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmpresabase_calculo_empbasecod1_Visible), 5, 0), true);
      edtavEmpresabase_calculo_empbasecod2_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEmpresabase_calculo_empbasecod2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmpresabase_calculo_empbasecod2_Visible), 5, 0), true);
      GXv_char1[0] = AV7MenuBienveImgURL ;
      GXv_char2[0] = AV9MenuBienveTitulo ;
      GXv_char3[0] = AV10MenuBienveTexto ;
      GXv_boolean4[0] = AV11MenuBienveVisible ;
      new web.getpropscompbienvenida(remoteHandle, context).execute( AV28MenuOpcCod, GXv_char1, GXv_char2, GXv_char3, GXv_boolean4) ;
      empbasehoranormal_impl.this.AV7MenuBienveImgURL = GXv_char1[0] ;
      empbasehoranormal_impl.this.AV9MenuBienveTitulo = GXv_char2[0] ;
      empbasehoranormal_impl.this.AV10MenuBienveTexto = GXv_char3[0] ;
      empbasehoranormal_impl.this.AV11MenuBienveVisible = GXv_boolean4[0] ;
      divWelcomemessage_welcometableparent_Visible = (AV11MenuBienveVisible ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, divWelcomemessage_welcometableparent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divWelcomemessage_welcometableparent_Visible), 5, 0), true);
      if ( AV11MenuBienveVisible )
      {
         lblWelcomemessage_titulo_Caption = GXutil.trim( AV9MenuBienveTitulo) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_titulo_Internalname, "Caption", lblWelcomemessage_titulo_Caption, true);
         lblWelcomemessage_descripcion_Caption = GXutil.trim( AV10MenuBienveTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_descripcion_Internalname, "Caption", lblWelcomemessage_descripcion_Caption, true);
         AV15WelcomeMessage_Foto = AV7MenuBienveImgURL ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV15WelcomeMessage_Foto)==0) ? AV40Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV15WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV15WelcomeMessage_Foto), true);
         AV40Welcomemessage_foto_GXI = GXDbFile.pathToUrl( AV7MenuBienveImgURL, context.getHttpContext()) ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV15WelcomeMessage_Foto)==0) ? AV40Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV15WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV15WelcomeMessage_Foto), true);
      }
      GXt_char5 = "" ;
      GXt_char6 = "" ;
      GXv_char3[0] = GXt_char6 ;
      new web.svgid_cerrarbienve(remoteHandle, context).execute( GXv_char3) ;
      empbasehoranormal_impl.this.GXt_char6 = GXv_char3[0] ;
      GXv_char2[0] = GXt_char5 ;
      new web.getsvg(remoteHandle, context).execute( GXt_char6, GXv_char2) ;
      empbasehoranormal_impl.this.GXt_char5 = GXv_char2[0] ;
      lblWelcomemessage_closehelp_Caption = GXt_char5 ;
      httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_closehelp_Internalname, "Caption", lblWelcomemessage_closehelp_Caption, true);
   }

   public void e13OF2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e14OF2 ();
      if (returnInSub) return;
   }

   public void e14OF2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV18TrnMode, "DSP") != 0 )
      {
         if ( GXutil.strcmp(AV18TrnMode, "DLT") != 0 )
         {
            /* Execute user subroutine: 'CHECKREQUIREDFIELDS' */
            S132 ();
            if (returnInSub) return;
         }
         if ( ( GXutil.strcmp(AV18TrnMode, "DLT") == 0 ) || AV20CheckRequiredFieldsResult )
         {
            if ( GXutil.strcmp(AV18TrnMode, "DLT") == 0 )
            {
               AV12Empresabase_calculo.Delete();
            }
            else
            {
               AV12Empresabase_calculo.Save();
            }
            if ( AV12Empresabase_calculo.Success() )
            {
               /* Execute user subroutine: 'AFTER_TRN' */
               S142 ();
               if (returnInSub) return;
            }
            else
            {
               AV17Messages = AV12Empresabase_calculo.GetMessages() ;
               /* Execute user subroutine: 'SHOW MESSAGES' */
               S112 ();
               if (returnInSub) return;
            }
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12Empresabase_calculo", AV12Empresabase_calculo);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV17Messages", AV17Messages);
   }

   public void S122( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      if ( ! ( ( GXutil.strcmp(AV18TrnMode, "DSP") != 0 ) ) )
      {
         bttBtnenter_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnenter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnenter_Visible), 5, 0), true);
      }
   }

   public void S112( )
   {
      /* 'SHOW MESSAGES' Routine */
      returnInSub = false ;
      AV41GXV10 = 1 ;
      while ( AV41GXV10 <= AV17Messages.size() )
      {
         AV16Message = (com.genexus.SdtMessages_Message)((com.genexus.SdtMessages_Message)AV17Messages.elementAt(-1+AV41GXV10));
         httpContext.GX_msglist.addItem(AV16Message.getgxTv_SdtMessages_Message_Description());
         AV41GXV10 = (int)(AV41GXV10+1) ;
      }
   }

   public void S142( )
   {
      /* 'AFTER_TRN' Routine */
      returnInSub = false ;
      Application.commitDataStores(context, remoteHandle, pr_default, "empbasehoranormal");
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      returnInSub = true;
      if (true) return;
   }

   public void S132( )
   {
      /* 'CHECKREQUIREDFIELDS' Routine */
      returnInSub = false ;
      AV20CheckRequiredFieldsResult = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20CheckRequiredFieldsResult", AV20CheckRequiredFieldsResult);
   }

   public void e15OF2( )
   {
      /* Welcomemessage_nomostrarmas_Click Routine */
      returnInSub = false ;
      if ( AV14WelcomeMessage_NoMostrarMas )
      {
         GXv_boolean4[0] = false ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV28MenuOpcCod, GXv_boolean4) ;
         GXv_char3[0] = AV8textoNoMostrara ;
         new web.getparametro(remoteHandle, context).execute( AV22CliCod, new web.textonomostrara_codigoparam(remoteHandle, context).executeUdp( ), GXv_char3) ;
         empbasehoranormal_impl.this.AV8textoNoMostrara = GXv_char3[0] ;
         lblWelcomemessage_combotext_Caption = GXutil.trim( AV8textoNoMostrara) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      else
      {
         GXv_boolean4[0] = true ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV28MenuOpcCod, GXv_boolean4) ;
         lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      /*  Sending Event outputs  */
   }

   protected void nextLoad( )
   {
   }

   protected void e16OF2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void wb_table3_46_OF2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "TableContentPadding", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_tableattributes.setProperty("Width", Dvpanel_tableattributes_Width);
         ucDvpanel_tableattributes.setProperty("AutoWidth", Dvpanel_tableattributes_Autowidth);
         ucDvpanel_tableattributes.setProperty("AutoHeight", Dvpanel_tableattributes_Autoheight);
         ucDvpanel_tableattributes.setProperty("Cls", Dvpanel_tableattributes_Cls);
         ucDvpanel_tableattributes.setProperty("Title", Dvpanel_tableattributes_Title);
         ucDvpanel_tableattributes.setProperty("Collapsible", Dvpanel_tableattributes_Collapsible);
         ucDvpanel_tableattributes.setProperty("Collapsed", Dvpanel_tableattributes_Collapsed);
         ucDvpanel_tableattributes.setProperty("ShowCollapseIcon", Dvpanel_tableattributes_Showcollapseicon);
         ucDvpanel_tableattributes.setProperty("IconPosition", Dvpanel_tableattributes_Iconposition);
         ucDvpanel_tableattributes.setProperty("AutoScroll", Dvpanel_tableattributes_Autoscroll);
         ucDvpanel_tableattributes.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tableattributes_Internalname, "DVPANEL_TABLEATTRIBUTESContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_TABLEATTRIBUTESContainer"+"TableAttributes"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableattributes_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEmpnom_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavEmpnom_Internalname, httpContext.getMessage( "Nombre", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavEmpnom_Internalname, AV13EmpNom, GXutil.rtrim( localUtil.format( AV13EmpNom, "@!")), TempTags+" onchange=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onblur(this,59);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEmpnom_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavEmpnom_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_EmpBaseHoraNormal.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavEmpresabase_calculo_empbaseclaseleg.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavEmpresabase_calculo_empbaseclaseleg.getInternalname(), httpContext.getMessage( "Clase de legajo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavEmpresabase_calculo_empbaseclaseleg, cmbavEmpresabase_calculo_empbaseclaseleg.getInternalname(), GXutil.trim( GXutil.str( AV12Empresabase_calculo.getgxTv_SdtEmpresabase_calculo_Empbaseclaseleg(), 1, 0)), 1, cmbavEmpresabase_calculo_empbaseclaseleg.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavEmpresabase_calculo_empbaseclaseleg.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,64);\"", "", true, (byte)(0), "HLP_EmpBaseHoraNormal.htm");
         cmbavEmpresabase_calculo_empbaseclaseleg.setValue( GXutil.trim( GXutil.str( AV12Empresabase_calculo.getgxTv_SdtEmpresabase_calculo_Empbaseclaseleg(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavEmpresabase_calculo_empbaseclaseleg.getInternalname(), "Values", cmbavEmpresabase_calculo_empbaseclaseleg.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavEmpresabase_calculo_empbasetipo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavEmpresabase_calculo_empbasetipo.getInternalname(), httpContext.getMessage( "Tipo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavEmpresabase_calculo_empbasetipo, cmbavEmpresabase_calculo_empbasetipo.getInternalname(), GXutil.rtrim( AV12Empresabase_calculo.getgxTv_SdtEmpresabase_calculo_Empbasetipo()), 1, cmbavEmpresabase_calculo_empbasetipo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavEmpresabase_calculo_empbasetipo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,69);\"", "", true, (byte)(0), "HLP_EmpBaseHoraNormal.htm");
         cmbavEmpresabase_calculo_empbasetipo.setValue( GXutil.rtrim( AV12Empresabase_calculo.getgxTv_SdtEmpresabase_calculo_Empbasetipo()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavEmpresabase_calculo_empbasetipo.getInternalname(), "Values", cmbavEmpresabase_calculo_empbasetipo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEmpresabase_calculo_empbasepromcnt1_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavEmpresabase_calculo_empbasepromcnt1_Internalname, httpContext.getMessage( "Cantidad de días/meses a promediar", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavEmpresabase_calculo_empbasepromcnt1_Internalname, GXutil.ltrim( localUtil.ntoc( AV12Empresabase_calculo.getgxTv_SdtEmpresabase_calculo_Empbasepromcnt1(), (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV12Empresabase_calculo.getgxTv_SdtEmpresabase_calculo_Empbasepromcnt1()), "ZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,74);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEmpresabase_calculo_empbasepromcnt1_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavEmpresabase_calculo_empbasepromcnt1_Enabled, 1, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_EmpBaseHoraNormal.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEmpresabase_calculo_empbasepromcnt2_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavEmpresabase_calculo_empbasepromcnt2_Internalname, httpContext.getMessage( "Cantidad de días/meses a promediar segunda alternativa", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 79,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavEmpresabase_calculo_empbasepromcnt2_Internalname, GXutil.ltrim( localUtil.ntoc( AV12Empresabase_calculo.getgxTv_SdtEmpresabase_calculo_Empbasepromcnt2(), (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV12Empresabase_calculo.getgxTv_SdtEmpresabase_calculo_Empbasepromcnt2()), "ZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,79);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEmpresabase_calculo_empbasepromcnt2_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavEmpresabase_calculo_empbasepromcnt2_Enabled, 1, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_EmpBaseHoraNormal.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavEmpresabase_calculo_empbasepromtcnt.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavEmpresabase_calculo_empbasepromtcnt.getInternalname(), httpContext.getMessage( "Días o Meses", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 84,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavEmpresabase_calculo_empbasepromtcnt, cmbavEmpresabase_calculo_empbasepromtcnt.getInternalname(), GXutil.rtrim( AV12Empresabase_calculo.getgxTv_SdtEmpresabase_calculo_Empbasepromtcnt()), 1, cmbavEmpresabase_calculo_empbasepromtcnt.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavEmpresabase_calculo_empbasepromtcnt.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,84);\"", "", true, (byte)(0), "HLP_EmpBaseHoraNormal.htm");
         cmbavEmpresabase_calculo_empbasepromtcnt.setValue( GXutil.rtrim( AV12Empresabase_calculo.getgxTv_SdtEmpresabase_calculo_Empbasepromtcnt()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavEmpresabase_calculo_empbasepromtcnt.getInternalname(), "Values", cmbavEmpresabase_calculo_empbasepromtcnt.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group TableContentPadding", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 92,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnenter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtnenter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtnenter_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_EmpBaseHoraNormal.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 94,'',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtncancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtncancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_EmpBaseHoraNormal.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_46_OF2e( true) ;
      }
      else
      {
         wb_table3_46_OF2e( false) ;
      }
   }

   public void wb_table2_29_OF2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabledescripcion_Internalname, tblWelcomemessage_tabledescripcion_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_descripcion_Internalname, lblWelcomemessage_descripcion_Caption, "", "", lblWelcomemessage_descripcion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeDescription", 0, "", 1, 1, 0, (short)(0), "HLP_EmpBaseHoraNormal.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_29_OF2e( true) ;
      }
      else
      {
         wb_table2_29_OF2e( false) ;
      }
   }

   public void wb_table1_24_OF2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabletitulo_Internalname, tblWelcomemessage_tabletitulo_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_titulo_Internalname, lblWelcomemessage_titulo_Caption, "", "", lblWelcomemessage_titulo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTitle", 0, "", 1, 1, 0, (short)(0), "HLP_EmpBaseHoraNormal.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_24_OF2e( true) ;
      }
      else
      {
         wb_table1_24_OF2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV18TrnMode = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18TrnMode", AV18TrnMode);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV18TrnMode, ""))));
      AV22CliCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV22CliCod), "ZZZZZ9")));
      AV23EmpCod = ((Number) GXutil.testNumericType( getParm(obj,2), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23EmpCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV23EmpCod), "ZZZ9")));
      AV24EmpBaseClaseLeg = ((Number) GXutil.testNumericType( getParm(obj,3), TypeConstants.BYTE)).byteValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24EmpBaseClaseLeg", GXutil.str( AV24EmpBaseClaseLeg, 1, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASECLASELEG", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV24EmpBaseClaseLeg), "9")));
      AV25EmpBaseTipo = (String)getParm(obj,4) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25EmpBaseTipo", AV25EmpBaseTipo);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASETIPO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV25EmpBaseTipo, ""))));
      AV26EmpBaseCod1 = (String)getParm(obj,5) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26EmpBaseCod1", AV26EmpBaseCod1);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASECOD1", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV26EmpBaseCod1, ""))));
      AV27EmpBaseCod2 = (String)getParm(obj,6) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27EmpBaseCod2", AV27EmpBaseCod2);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASECOD2", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV27EmpBaseCod2, ""))));
      AV28MenuOpcCod = (String)getParm(obj,7) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28MenuOpcCod", AV28MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV28MenuOpcCod, ""))));
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
      paOF2( ) ;
      wsOF2( ) ;
      weOF2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251316505274", true, true);
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
      httpContext.AddJavascriptSource("empbasehoranormal.js", "?20251316505274", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblWelcomemessage_closehelp_Internalname = "WELCOMEMESSAGE_CLOSEHELP" ;
      divWelcomemessage_tableclose_Internalname = "WELCOMEMESSAGE_TABLECLOSE" ;
      divWelcomemessage_welcometableprincipal_Internalname = "WELCOMEMESSAGE_WELCOMETABLEPRINCIPAL" ;
      imgavWelcomemessage_foto_Internalname = "vWELCOMEMESSAGE_FOTO" ;
      divWelcomemessage_welcometableimagen_Internalname = "WELCOMEMESSAGE_WELCOMETABLEIMAGEN" ;
      lblWelcomemessage_titulo_Internalname = "WELCOMEMESSAGE_TITULO" ;
      tblWelcomemessage_tabletitulo_Internalname = "WELCOMEMESSAGE_TABLETITULO" ;
      lblWelcomemessage_descripcion_Internalname = "WELCOMEMESSAGE_DESCRIPCION" ;
      tblWelcomemessage_tabledescripcion_Internalname = "WELCOMEMESSAGE_TABLEDESCRIPCION" ;
      divWelcomemessage_tabletexto_Internalname = "WELCOMEMESSAGE_TABLETEXTO" ;
      divWelcomemessage_welcomecontentflex_Internalname = "WELCOMEMESSAGE_WELCOMECONTENTFLEX" ;
      divWelcomemessage_welcomecontentitem_Internalname = "WELCOMEMESSAGE_WELCOMECONTENTITEM" ;
      chkavWelcomemessage_nomostrarmas.setInternalname( "vWELCOMEMESSAGE_NOMOSTRARMAS" );
      divWelcomemessage_tablec_Internalname = "WELCOMEMESSAGE_TABLEC" ;
      lblWelcomemessage_combotext_Internalname = "WELCOMEMESSAGE_COMBOTEXT" ;
      divWelcomemessage_tabletext_Internalname = "WELCOMEMESSAGE_TABLETEXT" ;
      divWelcomemessage_tablecmb_Internalname = "WELCOMEMESSAGE_TABLECMB" ;
      divWelcomemessage_welcomebottomitem_Internalname = "WELCOMEMESSAGE_WELCOMEBOTTOMITEM" ;
      divWelcomemessage_welcometableparent_Internalname = "WELCOMEMESSAGE_WELCOMETABLEPARENT" ;
      edtavEmpnom_Internalname = "vEMPNOM" ;
      cmbavEmpresabase_calculo_empbaseclaseleg.setInternalname( "EMPRESABASE_CALCULO_EMPBASECLASELEG" );
      cmbavEmpresabase_calculo_empbasetipo.setInternalname( "EMPRESABASE_CALCULO_EMPBASETIPO" );
      edtavEmpresabase_calculo_empbasepromcnt1_Internalname = "EMPRESABASE_CALCULO_EMPBASEPROMCNT1" ;
      edtavEmpresabase_calculo_empbasepromcnt2_Internalname = "EMPRESABASE_CALCULO_EMPBASEPROMCNT2" ;
      cmbavEmpresabase_calculo_empbasepromtcnt.setInternalname( "EMPRESABASE_CALCULO_EMPBASEPROMTCNT" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtnenter_Internalname = "BTNENTER" ;
      bttBtncancel_Internalname = "BTNCANCEL" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavEmpresabase_calculo_clicod_Internalname = "EMPRESABASE_CALCULO_CLICOD" ;
      edtavEmpresabase_calculo_empcod_Internalname = "EMPRESABASE_CALCULO_EMPCOD" ;
      edtavEmpresabase_calculo_empbasecod1_Internalname = "EMPRESABASE_CALCULO_EMPBASECOD1" ;
      edtavEmpresabase_calculo_empbasecod2_Internalname = "EMPRESABASE_CALCULO_EMPBASECOD2" ;
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
      bttBtnenter_Visible = 1 ;
      cmbavEmpresabase_calculo_empbasepromtcnt.setJsonclick( "" );
      cmbavEmpresabase_calculo_empbasepromtcnt.setEnabled( 1 );
      edtavEmpresabase_calculo_empbasepromcnt2_Jsonclick = "" ;
      edtavEmpresabase_calculo_empbasepromcnt2_Enabled = 1 ;
      edtavEmpresabase_calculo_empbasepromcnt1_Jsonclick = "" ;
      edtavEmpresabase_calculo_empbasepromcnt1_Enabled = 1 ;
      cmbavEmpresabase_calculo_empbasetipo.setJsonclick( "" );
      cmbavEmpresabase_calculo_empbasetipo.setEnabled( 1 );
      cmbavEmpresabase_calculo_empbaseclaseleg.setJsonclick( "" );
      cmbavEmpresabase_calculo_empbaseclaseleg.setEnabled( 1 );
      edtavEmpnom_Jsonclick = "" ;
      edtavEmpnom_Enabled = 1 ;
      lblWelcomemessage_descripcion_Caption = httpContext.getMessage( "Descripcion", "") ;
      lblWelcomemessage_titulo_Caption = httpContext.getMessage( "Titulo", "") ;
      cmbavEmpresabase_calculo_empbasetipo.setEnabled( 1 );
      cmbavEmpresabase_calculo_empbaseclaseleg.setEnabled( 1 );
      cmbavEmpresabase_calculo_empbasepromtcnt.setEnabled( 1 );
      edtavEmpresabase_calculo_empbasepromcnt2_Enabled = 1 ;
      edtavEmpresabase_calculo_empbasepromcnt1_Enabled = 1 ;
      edtavEmpresabase_calculo_empbasecod2_Jsonclick = "" ;
      edtavEmpresabase_calculo_empbasecod2_Visible = 1 ;
      edtavEmpresabase_calculo_empbasecod1_Jsonclick = "" ;
      edtavEmpresabase_calculo_empbasecod1_Visible = 1 ;
      edtavEmpresabase_calculo_empcod_Jsonclick = "" ;
      edtavEmpresabase_calculo_empcod_Visible = 1 ;
      edtavEmpresabase_calculo_clicod_Jsonclick = "" ;
      edtavEmpresabase_calculo_clicod_Visible = 1 ;
      lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
      chkavWelcomemessage_nomostrarmas.setEnabled( 1 );
      imgavWelcomemessage_foto_gximage = "" ;
      imgavWelcomemessage_foto_Enabled = 0 ;
      lblWelcomemessage_closehelp_Caption = "X" ;
      divWelcomemessage_welcometableparent_Visible = 1 ;
      divLayoutmaintable_Class = "Table TableTransactionTemplate" ;
      Dvpanel_tableattributes_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Iconposition = "Right" ;
      Dvpanel_tableattributes_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Title = httpContext.getMessage( "WWP_TemplateDataPanelTitle", "") ;
      Dvpanel_tableattributes_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_tableattributes_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tableattributes_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Width = "100%" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Emp Base Hora Normal", "") );
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      chkavWelcomemessage_nomostrarmas.setName( "vWELCOMEMESSAGE_NOMOSTRARMAS" );
      chkavWelcomemessage_nomostrarmas.setWebtags( "" );
      chkavWelcomemessage_nomostrarmas.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavWelcomemessage_nomostrarmas.getInternalname(), "TitleCaption", chkavWelcomemessage_nomostrarmas.getCaption(), true);
      chkavWelcomemessage_nomostrarmas.setCheckedValue( "false" );
      AV14WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV14WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14WelcomeMessage_NoMostrarMas", AV14WelcomeMessage_NoMostrarMas);
      cmbavEmpresabase_calculo_empbaseclaseleg.setName( "EMPRESABASE_CALCULO_EMPBASECLASELEG" );
      cmbavEmpresabase_calculo_empbaseclaseleg.setWebtags( "" );
      cmbavEmpresabase_calculo_empbaseclaseleg.addItem("1", httpContext.getMessage( "Mensual", ""), (short)(0));
      cmbavEmpresabase_calculo_empbaseclaseleg.addItem("2", httpContext.getMessage( "Quincenal", ""), (short)(0));
      cmbavEmpresabase_calculo_empbaseclaseleg.addItem("3", httpContext.getMessage( "Semanal", ""), (short)(0));
      cmbavEmpresabase_calculo_empbaseclaseleg.addItem("4", httpContext.getMessage( "Diaria", ""), (short)(0));
      if ( cmbavEmpresabase_calculo_empbaseclaseleg.getItemCount() > 0 )
      {
         AV12Empresabase_calculo.setgxTv_SdtEmpresabase_calculo_Empbaseclaseleg( (byte)(GXutil.lval( cmbavEmpresabase_calculo_empbaseclaseleg.getValidValue(GXutil.trim( GXutil.str( AV12Empresabase_calculo.getgxTv_SdtEmpresabase_calculo_Empbaseclaseleg(), 1, 0))))) );
      }
      cmbavEmpresabase_calculo_empbasetipo.setName( "EMPRESABASE_CALCULO_EMPBASETIPO" );
      cmbavEmpresabase_calculo_empbasetipo.setWebtags( "" );
      cmbavEmpresabase_calculo_empbasetipo.addItem("licencia", httpContext.getMessage( "Licencia", ""), (short)(0));
      cmbavEmpresabase_calculo_empbasetipo.addItem("feriado", httpContext.getMessage( "Feriado/No laborable", ""), (short)(0));
      cmbavEmpresabase_calculo_empbasetipo.addItem("horaNormal", httpContext.getMessage( "Hora Normal", ""), (short)(0));
      if ( cmbavEmpresabase_calculo_empbasetipo.getItemCount() > 0 )
      {
         AV12Empresabase_calculo.setgxTv_SdtEmpresabase_calculo_Empbasetipo( cmbavEmpresabase_calculo_empbasetipo.getValidValue(AV12Empresabase_calculo.getgxTv_SdtEmpresabase_calculo_Empbasetipo()) );
      }
      cmbavEmpresabase_calculo_empbasepromtcnt.setName( "EMPRESABASE_CALCULO_EMPBASEPROMTCNT" );
      cmbavEmpresabase_calculo_empbasepromtcnt.setWebtags( "" );
      cmbavEmpresabase_calculo_empbasepromtcnt.addItem("dias", httpContext.getMessage( "días", ""), (short)(0));
      cmbavEmpresabase_calculo_empbasepromtcnt.addItem("meses", httpContext.getMessage( "meses", ""), (short)(0));
      if ( cmbavEmpresabase_calculo_empbasepromtcnt.getItemCount() > 0 )
      {
         AV12Empresabase_calculo.setgxTv_SdtEmpresabase_calculo_Empbasepromtcnt( cmbavEmpresabase_calculo_empbasepromtcnt.getValidValue(AV12Empresabase_calculo.getgxTv_SdtEmpresabase_calculo_Empbasepromtcnt()) );
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV14WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV18TrnMode',fld:'vTRNMODE',pic:'',hsh:true},{av:'AV28MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV22CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV23EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV24EmpBaseClaseLeg',fld:'vEMPBASECLASELEG',pic:'9',hsh:true},{av:'AV25EmpBaseTipo',fld:'vEMPBASETIPO',pic:'',hsh:true},{av:'AV26EmpBaseCod1',fld:'vEMPBASECOD1',pic:'',hsh:true},{av:'AV27EmpBaseCod2',fld:'vEMPBASECOD2',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{ctrl:'BTNENTER',prop:'Visible'}]}");
      setEventMetadata("ENTER","{handler:'e14OF2',iparms:[{av:'AV18TrnMode',fld:'vTRNMODE',pic:'',hsh:true},{av:'AV20CheckRequiredFieldsResult',fld:'vCHECKREQUIREDFIELDSRESULT',pic:''},{av:'AV12Empresabase_calculo',fld:'vEMPRESABASE_CALCULO',pic:''},{av:'AV17Messages',fld:'vMESSAGES',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV12Empresabase_calculo',fld:'vEMPRESABASE_CALCULO',pic:''},{av:'AV17Messages',fld:'vMESSAGES',pic:''},{av:'AV20CheckRequiredFieldsResult',fld:'vCHECKREQUIREDFIELDSRESULT',pic:''}]}");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK","{handler:'e15OF2',iparms:[{av:'AV14WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV28MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV22CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK",",oparms:[{av:'lblWelcomemessage_combotext_Caption',ctrl:'WELCOMEMESSAGE_COMBOTEXT',prop:'Caption'}]}");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK","{handler:'e11OF1',iparms:[]");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK",",oparms:[{av:'divWelcomemessage_welcometableparent_Visible',ctrl:'WELCOMEMESSAGE_WELCOMETABLEPARENT',prop:'Visible'}]}");
      setEventMetadata("VALIDV_GXV1","{handler:'validv_Gxv1',iparms:[]");
      setEventMetadata("VALIDV_GXV1",",oparms:[]}");
      setEventMetadata("VALIDV_GXV2","{handler:'validv_Gxv2',iparms:[]");
      setEventMetadata("VALIDV_GXV2",",oparms:[]}");
      setEventMetadata("VALIDV_GXV5","{handler:'validv_Gxv5',iparms:[]");
      setEventMetadata("VALIDV_GXV5",",oparms:[]}");
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
      wcpOAV18TrnMode = "" ;
      wcpOAV25EmpBaseTipo = "" ;
      wcpOAV26EmpBaseCod1 = "" ;
      wcpOAV27EmpBaseCod2 = "" ;
      wcpOAV28MenuOpcCod = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV18TrnMode = "" ;
      AV25EmpBaseTipo = "" ;
      AV26EmpBaseCod1 = "" ;
      AV27EmpBaseCod2 = "" ;
      AV28MenuOpcCod = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV12Empresabase_calculo = new web.SdtEmpresabase_calculo(remoteHandle);
      AV17Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      GX_FocusControl = "" ;
      sPrefix = "" ;
      lblWelcomemessage_closehelp_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      AV15WelcomeMessage_Foto = "" ;
      AV40Welcomemessage_foto_GXI = "" ;
      sImgUrl = "" ;
      TempTags = "" ;
      lblWelcomemessage_combotext_Jsonclick = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV13EmpNom = "" ;
      AV7MenuBienveImgURL = "" ;
      GXv_char1 = new String[1] ;
      AV9MenuBienveTitulo = "" ;
      AV10MenuBienveTexto = "" ;
      GXt_char5 = "" ;
      GXt_char6 = "" ;
      GXv_char2 = new String[1] ;
      AV16Message = new com.genexus.SdtMessages_Message(remoteHandle, context);
      AV8textoNoMostrara = "" ;
      GXv_char3 = new String[1] ;
      GXv_boolean4 = new boolean[1] ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      bttBtnenter_Jsonclick = "" ;
      bttBtncancel_Jsonclick = "" ;
      lblWelcomemessage_descripcion_Jsonclick = "" ;
      lblWelcomemessage_titulo_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empbasehoranormal__default(),
         new Object[] {
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavEmpnom_Enabled = 0 ;
   }

   private byte wcpOAV24EmpBaseClaseLeg ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV24EmpBaseClaseLeg ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wcpOAV23EmpCod ;
   private short AV23EmpCod ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOAV22CliCod ;
   private int AV22CliCod ;
   private int divWelcomemessage_welcometableparent_Visible ;
   private int imgavWelcomemessage_foto_Enabled ;
   private int edtavEmpresabase_calculo_clicod_Visible ;
   private int edtavEmpresabase_calculo_empcod_Visible ;
   private int edtavEmpresabase_calculo_empbasecod1_Visible ;
   private int edtavEmpresabase_calculo_empbasecod2_Visible ;
   private int edtavEmpnom_Enabled ;
   private int edtavEmpresabase_calculo_empbasepromcnt1_Enabled ;
   private int edtavEmpresabase_calculo_empbasepromcnt2_Enabled ;
   private int bttBtnenter_Visible ;
   private int AV41GXV10 ;
   private int idxLst ;
   private String wcpOAV18TrnMode ;
   private String wcpOAV25EmpBaseTipo ;
   private String wcpOAV26EmpBaseCod1 ;
   private String wcpOAV27EmpBaseCod2 ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV18TrnMode ;
   private String AV25EmpBaseTipo ;
   private String AV26EmpBaseCod1 ;
   private String AV27EmpBaseCod2 ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Dvpanel_tableattributes_Width ;
   private String Dvpanel_tableattributes_Cls ;
   private String Dvpanel_tableattributes_Title ;
   private String Dvpanel_tableattributes_Iconposition ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String divWelcomemessage_welcometableparent_Internalname ;
   private String divWelcomemessage_welcometableprincipal_Internalname ;
   private String divWelcomemessage_tableclose_Internalname ;
   private String lblWelcomemessage_closehelp_Internalname ;
   private String lblWelcomemessage_closehelp_Caption ;
   private String lblWelcomemessage_closehelp_Jsonclick ;
   private String divWelcomemessage_welcomecontentitem_Internalname ;
   private String divWelcomemessage_welcomecontentflex_Internalname ;
   private String divWelcomemessage_welcometableimagen_Internalname ;
   private String ClassString ;
   private String imgavWelcomemessage_foto_gximage ;
   private String StyleString ;
   private String sImgUrl ;
   private String imgavWelcomemessage_foto_Internalname ;
   private String divWelcomemessage_tabletexto_Internalname ;
   private String divWelcomemessage_welcomebottomitem_Internalname ;
   private String divWelcomemessage_tablecmb_Internalname ;
   private String divWelcomemessage_tablec_Internalname ;
   private String TempTags ;
   private String divWelcomemessage_tabletext_Internalname ;
   private String lblWelcomemessage_combotext_Internalname ;
   private String lblWelcomemessage_combotext_Caption ;
   private String lblWelcomemessage_combotext_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtavEmpresabase_calculo_clicod_Internalname ;
   private String edtavEmpresabase_calculo_clicod_Jsonclick ;
   private String edtavEmpresabase_calculo_empcod_Internalname ;
   private String edtavEmpresabase_calculo_empcod_Jsonclick ;
   private String edtavEmpresabase_calculo_empbasecod1_Internalname ;
   private String edtavEmpresabase_calculo_empbasecod1_Jsonclick ;
   private String edtavEmpresabase_calculo_empbasecod2_Internalname ;
   private String edtavEmpresabase_calculo_empbasecod2_Jsonclick ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavEmpnom_Internalname ;
   private String edtavEmpresabase_calculo_empbasepromcnt1_Internalname ;
   private String edtavEmpresabase_calculo_empbasepromcnt2_Internalname ;
   private String GXv_char1[] ;
   private String lblWelcomemessage_titulo_Caption ;
   private String lblWelcomemessage_titulo_Internalname ;
   private String lblWelcomemessage_descripcion_Caption ;
   private String lblWelcomemessage_descripcion_Internalname ;
   private String GXt_char5 ;
   private String GXt_char6 ;
   private String GXv_char2[] ;
   private String bttBtnenter_Internalname ;
   private String GXv_char3[] ;
   private String sStyleString ;
   private String tblTablemainfix_Internalname ;
   private String divTablecontent_Internalname ;
   private String Dvpanel_tableattributes_Internalname ;
   private String divTableattributes_Internalname ;
   private String edtavEmpnom_Jsonclick ;
   private String edtavEmpresabase_calculo_empbasepromcnt1_Jsonclick ;
   private String edtavEmpresabase_calculo_empbasepromcnt2_Jsonclick ;
   private String bttBtnenter_Jsonclick ;
   private String bttBtncancel_Internalname ;
   private String bttBtncancel_Jsonclick ;
   private String tblWelcomemessage_tabledescripcion_Internalname ;
   private String lblWelcomemessage_descripcion_Jsonclick ;
   private String tblWelcomemessage_tabletitulo_Internalname ;
   private String lblWelcomemessage_titulo_Jsonclick ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV20CheckRequiredFieldsResult ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean wbLoad ;
   private boolean AV15WelcomeMessage_Foto_IsBlob ;
   private boolean AV14WelcomeMessage_NoMostrarMas ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV19LoadSuccess ;
   private boolean AV11MenuBienveVisible ;
   private boolean GXv_boolean4[] ;
   private String AV10MenuBienveTexto ;
   private String AV8textoNoMostrara ;
   private String wcpOAV28MenuOpcCod ;
   private String AV28MenuOpcCod ;
   private String AV40Welcomemessage_foto_GXI ;
   private String AV13EmpNom ;
   private String AV7MenuBienveImgURL ;
   private String AV9MenuBienveTitulo ;
   private String AV15WelcomeMessage_Foto ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private ICheckbox chkavWelcomemessage_nomostrarmas ;
   private HTMLChoice cmbavEmpresabase_calculo_empbaseclaseleg ;
   private HTMLChoice cmbavEmpresabase_calculo_empbasetipo ;
   private HTMLChoice cmbavEmpresabase_calculo_empbasepromtcnt ;
   private IDataStoreProvider pr_default ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV17Messages ;
   private com.genexus.SdtMessages_Message AV16Message ;
   private web.SdtEmpresabase_calculo AV12Empresabase_calculo ;
}

final  class empbasehoranormal__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
      }
   }

}

