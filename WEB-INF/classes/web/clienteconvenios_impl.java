package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class clienteconvenios_impl extends GXDataArea
{
   public void initenv( )
   {
      if ( GxWebError != 0 )
      {
         return  ;
      }
   }

   public void inittrn( )
   {
      initialize_properties( ) ;
      entryPointCalled = false ;
      gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CLICONVENIO") == 0 )
      {
         AV8CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliPaiConve), 4, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIPAICONVE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CliPaiConve), "ZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlacliconvenio4K202( AV8CliPaiConve) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel3"+"_"+"CLICOD") == 0 )
      {
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx3asaclicod4K202( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel9"+"_"+"CLICONVEVER") == 0 )
      {
         AV15Insert_CliConveVer = (int)(GXutil.lval( httpContext.GetPar( "Insert_CliConveVer"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15Insert_CliConveVer", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15Insert_CliConveVer), 6, 0));
         Gx_BScreen = (byte)(GXutil.lval( httpContext.GetPar( "Gx_BScreen"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx9asacliconvever4K202( AV15Insert_CliConveVer, Gx_BScreen) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel11"+"_"+"") == 0 )
      {
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxasa16394K202( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel12"+"_"+"") == 0 )
      {
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel13"+"_"+"") == 0 )
      {
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxasa21304K202( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel14"+"_"+"") == 0 )
      {
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_21") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_21( A3CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_23") == 0 )
      {
         A1564CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = httpContext.GetPar( "CliConvenio") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_23( A1564CliPaiConve, A1565CliConvenio) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_22") == 0 )
      {
         A1566CliConveVer = (int)(GXutil.lval( httpContext.GetPar( "CliConveVer"))) ;
         n1566CliConveVer = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1566CliConveVer", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1566CliConveVer), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_22( A1566CliConveVer) ;
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
         gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
      {
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
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
         Gx_mode = gxfirstwebparm ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
         {
            AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
            AV8CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliPaiConve), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIPAICONVE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CliPaiConve), "ZZZ9")));
            AV9CliConvenio = httpContext.GetPar( "CliConvenio") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9CliConvenio", AV9CliConvenio);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9CliConvenio, ""))));
         }
      }
      if ( toggleJsOutput )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
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
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
         }
         Form.getMeta().addItem("description", httpContext.getMessage( "Cliente Convenios", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = dynCliConvenio.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public clienteconvenios_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public clienteconvenios_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( clienteconvenios_impl.class ));
   }

   public clienteconvenios_impl( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynCliConvenio = new HTMLChoice();
      chkCliConveHab = UIFactory.getCheckbox(this);
      chkCliConveActObl = UIFactory.getCheckbox(this);
   }

   public void webExecute( )
   {
      initenv( ) ;
      inittrn( ) ;
      if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
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

   public void fix_multi_value_controls( )
   {
      if ( dynCliConvenio.getItemCount() > 0 )
      {
         A1565CliConvenio = dynCliConvenio.getValidValue(A1565CliConvenio) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynCliConvenio.setValue( GXutil.rtrim( A1565CliConvenio) );
         httpContext.ajax_rsp_assign_prop("", false, dynCliConvenio.getInternalname(), "Values", dynCliConvenio.ToJavascriptSource(), true);
      }
      A1639CliConveHab = GXutil.strtobool( GXutil.booltostr( A1639CliConveHab)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1639CliConveHab", A1639CliConveHab);
      A2130CliConveActObl = GXutil.strtobool( GXutil.booltostr( A2130CliConveActObl)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2130CliConveActObl", A2130CliConveActObl);
   }

   public void draw( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         disable_std_buttons( ) ;
         enableDisable( ) ;
         set_caption( ) ;
         /* Form start */
         drawControls( ) ;
         fix_multi_value_controls( ) ;
      }
      /* Execute Exit event if defined. */
   }

   public void drawControls( )
   {
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Padding0", "left", "top", "", "", "div");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynCliConvenio.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynCliConvenio.getInternalname(), httpContext.getMessage( "Convenio", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynCliConvenio, dynCliConvenio.getInternalname(), GXutil.rtrim( A1565CliConvenio), 1, dynCliConvenio.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, dynCliConvenio.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "", true, (byte)(0), "HLP_ClienteConvenios.htm");
      dynCliConvenio.setValue( GXutil.rtrim( A1565CliConvenio) );
      httpContext.ajax_rsp_assign_prop("", false, dynCliConvenio.getInternalname(), "Values", dynCliConvenio.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divCliconvehab_cell_Internalname, 1, 0, "px", 0, "px", divCliconvehab_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", chkCliConveHab.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkCliConveHab.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkCliConveHab.getInternalname(), httpContext.getMessage( "Habilitado", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkCliConveHab.getInternalname(), GXutil.booltostr( A1639CliConveHab), "", httpContext.getMessage( "Habilitado", ""), chkCliConveHab.getVisible(), chkCliConveHab.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(27, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,27);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCliConveEscFrecAct_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCliConveEscFrecAct_Internalname, httpContext.getMessage( "Frecuencia de actualización (meses) de escalas salariales", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliConveEscFrecAct_Internalname, GXutil.ltrim( localUtil.ntoc( A2132CliConveEscFrecAct, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtCliConveEscFrecAct_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2132CliConveEscFrecAct), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A2132CliConveEscFrecAct), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliConveEscFrecAct_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCliConveEscFrecAct_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ClienteConvenios.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divCliconveactobl_cell_Internalname, 1, 0, "px", 0, "px", divCliconveactobl_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", chkCliConveActObl.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkCliConveActObl.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkCliConveActObl.getInternalname(), httpContext.getMessage( "Obliga a actualizar escalas salariales", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkCliConveActObl.getInternalname(), GXutil.booltostr( A2130CliConveActObl), "", httpContext.getMessage( "Obliga a actualizar escalas salariales", ""), chkCliConveActObl.getVisible(), chkCliConveActObl.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(37, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,37);\"");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ClienteConvenios.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ClienteConvenios.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ClienteConvenios.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      /* End of table */
      httpContext.writeText( "</table>") ;
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,53);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ClienteConvenios.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliPaiConve_Internalname, GXutil.ltrim( localUtil.ntoc( A1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1564CliPaiConve), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,54);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliPaiConve_Jsonclick, 0, "Attribute", "", "", "", "", edtCliPaiConve_Visible, edtCliPaiConve_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_ClienteConvenios.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 55,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliConveVer_Internalname, GXutil.ltrim( localUtil.ntoc( A1566CliConveVer, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1566CliConveVer), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,55);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliConveVer_Jsonclick, 0, "Attribute", "", "", "", "", edtCliConveVer_Visible, edtCliConveVer_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ClienteConvenios.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
   }

   public void userMain( )
   {
      standaloneStartup( ) ;
   }

   public void userMainFullajax( )
   {
      initenv( ) ;
      inittrn( ) ;
      userMain( ) ;
      draw( ) ;
      sendCloseFormHiddens( ) ;
   }

   public void standaloneStartup( )
   {
      standaloneStartupServer( ) ;
      disable_std_buttons( ) ;
      enableDisable( ) ;
      process( ) ;
   }

   public void standaloneStartupServer( )
   {
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e114K2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1564CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( "Z1564CliPaiConve"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1565CliConvenio = httpContext.cgiGet( "Z1565CliConvenio") ;
            Z2130CliConveActObl = GXutil.strtobool( httpContext.cgiGet( "Z2130CliConveActObl")) ;
            Z1639CliConveHab = GXutil.strtobool( httpContext.cgiGet( "Z1639CliConveHab")) ;
            Z2429CliConveEsquemaEs = GXutil.strtobool( httpContext.cgiGet( "Z2429CliConveEsquemaEs")) ;
            Z1566CliConveVer = (int)(localUtil.ctol( httpContext.cgiGet( "Z1566CliConveVer"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1566CliConveVer = ((0==A1566CliConveVer) ? true : false) ;
            A2429CliConveEsquemaEs = GXutil.strtobool( httpContext.cgiGet( "Z2429CliConveEsquemaEs")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N1566CliConveVer = (int)(localUtil.ctol( httpContext.cgiGet( "N1566CliConveVer"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1566CliConveVer = ((0==A1566CliConveVer) ? true : false) ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( "vCLIPAICONVE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV9CliConvenio = httpContext.cgiGet( "vCLICONVENIO") ;
            AV15Insert_CliConveVer = (int)(localUtil.ctol( httpContext.cgiGet( "vINSERT_CLICONVEVER"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2429CliConveEsquemaEs = GXutil.strtobool( httpContext.cgiGet( "CLICONVEESQUEMAES")) ;
            A344CliNom = httpContext.cgiGet( "CLINOM") ;
            A1568CliConveVerNom = httpContext.cgiGet( "CLICONVEVERNOM") ;
            A1567CliConvenioDescrip = httpContext.cgiGet( "CLICONVENIODESCRIP") ;
            AV25Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Dvpanel_tableattributes_Objectcall = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Objectcall") ;
            Dvpanel_tableattributes_Class = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Class") ;
            Dvpanel_tableattributes_Enabled = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Enabled")) ;
            Dvpanel_tableattributes_Width = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Width") ;
            Dvpanel_tableattributes_Height = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Height") ;
            Dvpanel_tableattributes_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autowidth")) ;
            Dvpanel_tableattributes_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoheight")) ;
            Dvpanel_tableattributes_Cls = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Cls") ;
            Dvpanel_tableattributes_Showheader = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showheader")) ;
            Dvpanel_tableattributes_Title = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Title") ;
            Dvpanel_tableattributes_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsible")) ;
            Dvpanel_tableattributes_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsed")) ;
            Dvpanel_tableattributes_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showcollapseicon")) ;
            Dvpanel_tableattributes_Iconposition = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Iconposition") ;
            Dvpanel_tableattributes_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoscroll")) ;
            Dvpanel_tableattributes_Visible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Visible")) ;
            Dvpanel_tableattributes_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            /* Read variables values. */
            dynCliConvenio.setValue( httpContext.cgiGet( dynCliConvenio.getInternalname()) );
            A1565CliConvenio = httpContext.cgiGet( dynCliConvenio.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
            A1639CliConveHab = GXutil.strtobool( httpContext.cgiGet( chkCliConveHab.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1639CliConveHab", A1639CliConveHab);
            A2132CliConveEscFrecAct = (short)(localUtil.ctol( httpContext.cgiGet( edtCliConveEscFrecAct_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2132CliConveEscFrecAct", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2132CliConveEscFrecAct), 4, 0));
            A2130CliConveActObl = GXutil.strtobool( httpContext.cgiGet( chkCliConveActObl.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2130CliConveActObl", A2130CliConveActObl);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A3CliCod = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            }
            else
            {
               A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCliPaiConve_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCliPaiConve_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLIPAICONVE");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliPaiConve_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1564CliPaiConve = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
            }
            else
            {
               A1564CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( edtCliPaiConve_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCliConveVer_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCliConveVer_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLICONVEVER");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliConveVer_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1566CliConveVer = 0 ;
               n1566CliConveVer = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1566CliConveVer", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1566CliConveVer), 6, 0));
            }
            else
            {
               A1566CliConveVer = (int)(localUtil.ctol( httpContext.cgiGet( edtCliConveVer_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               n1566CliConveVer = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1566CliConveVer", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1566CliConveVer), 6, 0));
            }
            n1566CliConveVer = ((0==A1566CliConveVer) ? true : false) ;
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"ClienteConvenios");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("CliConveEsquemaEs", GXutil.booltostr( A2429CliConveEsquemaEs));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("clienteconvenios:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
            standaloneNotModal( ) ;
         }
         else
         {
            standaloneNotModal( ) ;
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") == 0 )
            {
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1564CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
               A1565CliConvenio = httpContext.GetPar( "CliConvenio") ;
               httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
               getEqualNoModal( ) ;
               gxacliconvenio_html4K202( AV8CliPaiConve) ;
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               disable_std_buttons( ) ;
               standaloneModal( ) ;
            }
            else
            {
               if ( isDsp( ) )
               {
                  sMode202 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  gxacliconvenio_html4K202( AV8CliPaiConve) ;
                  Gx_mode = sMode202 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound202 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_4K0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "CLICOD");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtCliCod_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
   }

   public void process( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read Transaction buttons. */
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
                     if ( GXutil.strcmp(sEvt, "START") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Start */
                        e114K2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e124K2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        if ( ! isDsp( ) )
                        {
                           btn_enter( ) ;
                        }
                        /* No code required for Cancel button. It is implemented as the Reset button. */
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

   public void afterTrn( )
   {
      if ( trnEnded == 1 )
      {
         if ( ! (GXutil.strcmp("", endTrnMsgTxt)==0) )
         {
            httpContext.GX_msglist.addItem(endTrnMsgTxt, endTrnMsgCod, 0, "", true);
         }
         /* Execute user event: After Trn */
         e124K2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll4K202( ) ;
            standaloneNotModal( ) ;
            standaloneModal( ) ;
         }
      }
      endTrnMsgTxt = "" ;
   }

   public String toString( )
   {
      return "" ;
   }

   public GXContentInfo getContentInfo( )
   {
      return (GXContentInfo)(null) ;
   }

   public void disable_std_buttons( )
   {
      bttBtntrn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
      if ( isDsp( ) || isDlt( ) )
      {
         bttBtntrn_delete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
         if ( isDsp( ) )
         {
            bttBtntrn_enter_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Visible), 5, 0), true);
         }
         disableAttributes4K202( ) ;
      }
   }

   public void set_caption( )
   {
      if ( ( IsConfirmed == 1 ) && ( AnyError == 0 ) )
      {
         if ( isDlt( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_confdelete"), 0, "", true);
         }
         else
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_mustconfirm"), 0, "", true);
         }
      }
   }

   public void confirm_4K0( )
   {
      beforeValidate4K202( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls4K202( ) ;
         }
         else
         {
            checkExtendedTable4K202( ) ;
            closeExtendedTableCursors4K202( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption4K0( )
   {
   }

   public void e114K2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV10WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV10WWPContext = GXv_SdtWWPContext1[0] ;
      AV11IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV11IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClienteConvenios_Insert", GXv_boolean3) ;
         clienteconvenios_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV11IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV11IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClienteConvenios_Update", GXv_boolean3) ;
         clienteconvenios_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV11IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV11IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClienteConvenios_Delete", GXv_boolean3) ;
         clienteconvenios_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV11IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( ! AV11IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV25Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV13TrnContext.fromxml(AV14WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV13TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV25Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV26GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26GXV1), 8, 0));
         while ( AV26GXV1 <= AV13TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV16TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV13TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV26GXV1));
            if ( GXutil.strcmp(AV16TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "CliConveVer") == 0 )
            {
               AV15Insert_CliConveVer = (int)(GXutil.lval( AV16TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV15Insert_CliConveVer", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15Insert_CliConveVer), 6, 0));
            }
            AV26GXV1 = (int)(AV26GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26GXV1), 8, 0));
         }
      }
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtCliPaiConve_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Visible), 5, 0), true);
      edtCliConveVer_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConveVer_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveVer_Visible), 5, 0), true);
   }

   public void e124K2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(4);
      pr_default.close(3);
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void S112( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      chkCliConveHab.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkCliConveHab.getInternalname(), "Visible", GXutil.ltrimstr( chkCliConveHab.getVisible(), 5, 0), true);
      divCliconvehab_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divCliconvehab_cell_Internalname, "Class", divCliconvehab_cell_Class, true);
      chkCliConveActObl.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkCliConveActObl.getInternalname(), "Visible", GXutil.ltrimstr( chkCliConveActObl.getVisible(), 5, 0), true);
      divCliconveactobl_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divCliconveactobl_cell_Internalname, "Class", divCliconveactobl_cell_Class, true);
   }

   public void zm4K202( int GX_JID )
   {
      if ( ( GX_JID == 20 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z2130CliConveActObl = T004K3_A2130CliConveActObl[0] ;
            Z1639CliConveHab = T004K3_A1639CliConveHab[0] ;
            Z2429CliConveEsquemaEs = T004K3_A2429CliConveEsquemaEs[0] ;
            Z1566CliConveVer = T004K3_A1566CliConveVer[0] ;
         }
         else
         {
            Z2130CliConveActObl = A2130CliConveActObl ;
            Z1639CliConveHab = A1639CliConveHab ;
            Z2429CliConveEsquemaEs = A2429CliConveEsquemaEs ;
            Z1566CliConveVer = A1566CliConveVer ;
         }
      }
      if ( GX_JID == -20 )
      {
         Z2130CliConveActObl = A2130CliConveActObl ;
         Z1639CliConveHab = A1639CliConveHab ;
         Z2429CliConveEsquemaEs = A2429CliConveEsquemaEs ;
         Z3CliCod = A3CliCod ;
         Z1566CliConveVer = A1566CliConveVer ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z344CliNom = A344CliNom ;
         Z1567CliConvenioDescrip = A1567CliConvenioDescrip ;
         Z2132CliConveEscFrecAct = A2132CliConveEscFrecAct ;
         Z1568CliConveVerNom = A1568CliConveVerNom ;
      }
   }

   public void standaloneNotModal( )
   {
      Gx_BScreen = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7CliCod) )
      {
         A3CliCod = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int4 = A3CliCod ;
            GXv_int5[0] = GXt_int4 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
            clienteconvenios_impl.this.GXt_int4 = GXv_int5[0] ;
            A3CliCod = GXt_int4 ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         }
      }
      if ( ! (0==AV7CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      else
      {
         edtCliCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      GXt_boolean2 = false ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new web.getclienteconveniador(remoteHandle, context).execute( AV7CliCod, GXv_boolean3) ;
      clienteconvenios_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      chkCliConveHab.setVisible( (GXt_boolean2 ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkCliConveHab.getInternalname(), "Visible", GXutil.ltrimstr( chkCliConveHab.getVisible(), 5, 0), true);
      GXt_boolean2 = false ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new web.getclienteconveniador(remoteHandle, context).execute( AV7CliCod, GXv_boolean3) ;
      clienteconvenios_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      if ( ! ( GXt_boolean2 ) )
      {
         divCliconvehab_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divCliconvehab_cell_Internalname, "Class", divCliconvehab_cell_Class, true);
      }
      else
      {
         GXt_boolean2 = false ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.getclienteconveniador(remoteHandle, context).execute( AV7CliCod, GXv_boolean3) ;
         clienteconvenios_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         if ( GXt_boolean2 )
         {
            divCliconvehab_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divCliconvehab_cell_Internalname, "Class", divCliconvehab_cell_Class, true);
         }
      }
      GXt_boolean2 = false ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new web.getclienteconveniador(remoteHandle, context).execute( AV7CliCod, GXv_boolean3) ;
      clienteconvenios_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      chkCliConveActObl.setVisible( (!GXt_boolean2 ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkCliConveActObl.getInternalname(), "Visible", GXutil.ltrimstr( chkCliConveActObl.getVisible(), 5, 0), true);
      GXt_boolean2 = false ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new web.getclienteconveniador(remoteHandle, context).execute( AV7CliCod, GXv_boolean3) ;
      clienteconvenios_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      if ( ! ( ! GXt_boolean2 ) )
      {
         divCliconveactobl_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divCliconveactobl_cell_Internalname, "Class", divCliconveactobl_cell_Class, true);
      }
      else
      {
         GXt_boolean2 = false ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.getclienteconveniador(remoteHandle, context).execute( AV7CliCod, GXv_boolean3) ;
         clienteconvenios_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         if ( ! GXt_boolean2 )
         {
            divCliconveactobl_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divCliconveactobl_cell_Internalname, "Class", divCliconveactobl_cell_Class, true);
         }
      }
      if ( ! (0==AV7CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      gxacliconvenio_html4K202( AV8CliPaiConve) ;
      if ( ! (0==AV8CliPaiConve) )
      {
         A1564CliPaiConve = AV8CliPaiConve ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
      }
      if ( ! (0==AV8CliPaiConve) )
      {
         edtCliPaiConve_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Enabled), 5, 0), true);
      }
      else
      {
         edtCliPaiConve_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Enabled), 5, 0), true);
      }
      if ( ! (0==AV8CliPaiConve) )
      {
         edtCliPaiConve_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV9CliConvenio)==0) )
      {
         A1565CliConvenio = AV9CliConvenio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
      }
      if ( ! (GXutil.strcmp("", AV9CliConvenio)==0) )
      {
         dynCliConvenio.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynCliConvenio.getInternalname(), "Enabled", GXutil.ltrimstr( dynCliConvenio.getEnabled(), 5, 0), true);
      }
      else
      {
         dynCliConvenio.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, dynCliConvenio.getInternalname(), "Enabled", GXutil.ltrimstr( dynCliConvenio.getEnabled(), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV9CliConvenio)==0) )
      {
         dynCliConvenio.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynCliConvenio.getInternalname(), "Enabled", GXutil.ltrimstr( dynCliConvenio.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV15Insert_CliConveVer) )
      {
         edtCliConveVer_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliConveVer_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveVer_Enabled), 5, 0), true);
      }
      else
      {
         edtCliConveVer_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliConveVer_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveVer_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( GXutil.strcmp(Gx_mode, "DSP") == 0 )
      {
         bttBtntrn_enter_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      }
      else
      {
         bttBtntrn_enter_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV15Insert_CliConveVer) )
      {
         A1566CliConveVer = AV15Insert_CliConveVer ;
         n1566CliConveVer = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1566CliConveVer", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1566CliConveVer), 6, 0));
      }
      else
      {
         if ( isIns( )  && (0==A1566CliConveVer) && ( Gx_BScreen == 0 ) )
         {
            GXt_int4 = A1566CliConveVer ;
            GXv_int5[0] = GXt_int4 ;
            new web.primerversiondeconvenio(remoteHandle, context).execute( (short)(0), "", GXv_int5) ;
            clienteconvenios_impl.this.GXt_int4 = GXv_int5[0] ;
            A1566CliConveVer = GXt_int4 ;
            n1566CliConveVer = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1566CliConveVer", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1566CliConveVer), 6, 0));
         }
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         /* Using cursor T004K4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod)});
         A344CliNom = T004K4_A344CliNom[0] ;
         pr_default.close(2);
         AV25Pgmname = "ClienteConvenios" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25Pgmname", AV25Pgmname);
         /* Using cursor T004K6 */
         pr_default.execute(4, new Object[] {Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         A1567CliConvenioDescrip = T004K6_A1567CliConvenioDescrip[0] ;
         A2132CliConveEscFrecAct = T004K6_A2132CliConveEscFrecAct[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2132CliConveEscFrecAct", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2132CliConveEscFrecAct), 4, 0));
         pr_default.close(4);
         /* Using cursor T004K5 */
         pr_default.execute(3, new Object[] {Boolean.valueOf(n1566CliConveVer), Integer.valueOf(A1566CliConveVer)});
         A1568CliConveVerNom = T004K5_A1568CliConveVerNom[0] ;
         pr_default.close(3);
      }
   }

   public void load4K202( )
   {
      /* Using cursor T004K7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound202 = (short)(1) ;
         A1567CliConvenioDescrip = T004K7_A1567CliConvenioDescrip[0] ;
         A1568CliConveVerNom = T004K7_A1568CliConveVerNom[0] ;
         A2132CliConveEscFrecAct = T004K7_A2132CliConveEscFrecAct[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2132CliConveEscFrecAct", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2132CliConveEscFrecAct), 4, 0));
         A2130CliConveActObl = T004K7_A2130CliConveActObl[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2130CliConveActObl", A2130CliConveActObl);
         A344CliNom = T004K7_A344CliNom[0] ;
         A1639CliConveHab = T004K7_A1639CliConveHab[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1639CliConveHab", A1639CliConveHab);
         A2429CliConveEsquemaEs = T004K7_A2429CliConveEsquemaEs[0] ;
         A1566CliConveVer = T004K7_A1566CliConveVer[0] ;
         n1566CliConveVer = T004K7_n1566CliConveVer[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1566CliConveVer", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1566CliConveVer), 6, 0));
         zm4K202( -20) ;
      }
      pr_default.close(5);
      onLoadActions4K202( ) ;
   }

   public void onLoadActions4K202( )
   {
      AV25Pgmname = "ClienteConvenios" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25Pgmname", AV25Pgmname);
   }

   public void checkExtendedTable4K202( )
   {
      nIsDirty_202 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      AV25Pgmname = "ClienteConvenios" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25Pgmname", AV25Pgmname);
      /* Using cursor T004K4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A344CliNom = T004K4_A344CliNom[0] ;
      pr_default.close(2);
      /* Using cursor T004K6 */
      pr_default.execute(4, new Object[] {Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Conve Versiones", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVENIO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliPaiConve_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A1567CliConvenioDescrip = T004K6_A1567CliConvenioDescrip[0] ;
      A2132CliConveEscFrecAct = T004K6_A2132CliConveEscFrecAct[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A2132CliConveEscFrecAct", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2132CliConveEscFrecAct), 4, 0));
      pr_default.close(4);
      /* Using cursor T004K5 */
      pr_default.execute(3, new Object[] {Boolean.valueOf(n1566CliConveVer), Integer.valueOf(A1566CliConveVer)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         if ( ! ( (0==A1566CliConveVer) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Convenio Cliente Version", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVEVER");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliConveVer_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A1568CliConveVerNom = T004K5_A1568CliConveVerNom[0] ;
      pr_default.close(3);
   }

   public void closeExtendedTableCursors4K202( )
   {
      pr_default.close(2);
      pr_default.close(4);
      pr_default.close(3);
   }

   public void enableDisable( )
   {
   }

   public void gxload_21( int A3CliCod )
   {
      /* Using cursor T004K8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A344CliNom = T004K8_A344CliNom[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A344CliNom)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void gxload_23( short A1564CliPaiConve ,
                          String A1565CliConvenio )
   {
      /* Using cursor T004K9 */
      pr_default.execute(7, new Object[] {Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
      if ( (pr_default.getStatus(7) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Conve Versiones", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVENIO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliPaiConve_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A1567CliConvenioDescrip = T004K9_A1567CliConvenioDescrip[0] ;
      A2132CliConveEscFrecAct = T004K9_A2132CliConveEscFrecAct[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A2132CliConveEscFrecAct", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2132CliConveEscFrecAct), 4, 0));
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A1567CliConvenioDescrip)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A2132CliConveEscFrecAct, (byte)(4), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(7) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(7);
   }

   public void gxload_22( int A1566CliConveVer )
   {
      /* Using cursor T004K10 */
      pr_default.execute(8, new Object[] {Boolean.valueOf(n1566CliConveVer), Integer.valueOf(A1566CliConveVer)});
      if ( (pr_default.getStatus(8) == 101) )
      {
         if ( ! ( (0==A1566CliConveVer) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Convenio Cliente Version", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVEVER");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliConveVer_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A1568CliConveVerNom = T004K10_A1568CliConveVerNom[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A1568CliConveVerNom)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(8) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(8);
   }

   public void getKey4K202( )
   {
      /* Using cursor T004K11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound202 = (short)(1) ;
      }
      else
      {
         RcdFound202 = (short)(0) ;
      }
      pr_default.close(9);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T004K3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm4K202( 20) ;
         RcdFound202 = (short)(1) ;
         A2130CliConveActObl = T004K3_A2130CliConveActObl[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2130CliConveActObl", A2130CliConveActObl);
         A1639CliConveHab = T004K3_A1639CliConveHab[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1639CliConveHab", A1639CliConveHab);
         A2429CliConveEsquemaEs = T004K3_A2429CliConveEsquemaEs[0] ;
         A3CliCod = T004K3_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1566CliConveVer = T004K3_A1566CliConveVer[0] ;
         n1566CliConveVer = T004K3_n1566CliConveVer[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1566CliConveVer", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1566CliConveVer), 6, 0));
         A1564CliPaiConve = T004K3_A1564CliPaiConve[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = T004K3_A1565CliConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         sMode202 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load4K202( ) ;
         if ( AnyError == 1 )
         {
            RcdFound202 = (short)(0) ;
            initializeNonKey4K202( ) ;
         }
         Gx_mode = sMode202 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound202 = (short)(0) ;
         initializeNonKey4K202( ) ;
         sMode202 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode202 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey4K202( ) ;
      if ( RcdFound202 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound202 = (short)(0) ;
      /* Using cursor T004K12 */
      pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1565CliConvenio});
      if ( (pr_default.getStatus(10) != 101) )
      {
         while ( (pr_default.getStatus(10) != 101) && ( ( T004K12_A3CliCod[0] < A3CliCod ) || ( T004K12_A3CliCod[0] == A3CliCod ) && ( T004K12_A1564CliPaiConve[0] < A1564CliPaiConve ) || ( T004K12_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004K12_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004K12_A1565CliConvenio[0], A1565CliConvenio) < 0 ) ) )
         {
            pr_default.readNext(10);
         }
         if ( (pr_default.getStatus(10) != 101) && ( ( T004K12_A3CliCod[0] > A3CliCod ) || ( T004K12_A3CliCod[0] == A3CliCod ) && ( T004K12_A1564CliPaiConve[0] > A1564CliPaiConve ) || ( T004K12_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004K12_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004K12_A1565CliConvenio[0], A1565CliConvenio) > 0 ) ) )
         {
            A3CliCod = T004K12_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1564CliPaiConve = T004K12_A1564CliPaiConve[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
            A1565CliConvenio = T004K12_A1565CliConvenio[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
            RcdFound202 = (short)(1) ;
         }
      }
      pr_default.close(10);
   }

   public void move_previous( )
   {
      RcdFound202 = (short)(0) ;
      /* Using cursor T004K13 */
      pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1565CliConvenio});
      if ( (pr_default.getStatus(11) != 101) )
      {
         while ( (pr_default.getStatus(11) != 101) && ( ( T004K13_A3CliCod[0] > A3CliCod ) || ( T004K13_A3CliCod[0] == A3CliCod ) && ( T004K13_A1564CliPaiConve[0] > A1564CliPaiConve ) || ( T004K13_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004K13_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004K13_A1565CliConvenio[0], A1565CliConvenio) > 0 ) ) )
         {
            pr_default.readNext(11);
         }
         if ( (pr_default.getStatus(11) != 101) && ( ( T004K13_A3CliCod[0] < A3CliCod ) || ( T004K13_A3CliCod[0] == A3CliCod ) && ( T004K13_A1564CliPaiConve[0] < A1564CliPaiConve ) || ( T004K13_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004K13_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004K13_A1565CliConvenio[0], A1565CliConvenio) < 0 ) ) )
         {
            A3CliCod = T004K13_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1564CliPaiConve = T004K13_A1564CliPaiConve[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
            A1565CliConvenio = T004K13_A1565CliConvenio[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
            RcdFound202 = (short)(1) ;
         }
      }
      pr_default.close(11);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey4K202( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = dynCliConvenio.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert4K202( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound202 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1564CliPaiConve = Z1564CliPaiConve ;
               httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
               A1565CliConvenio = Z1565CliConvenio ;
               httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = dynCliConvenio.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update4K202( ) ;
               GX_FocusControl = dynCliConvenio.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) )
            {
               /* Insert record */
               GX_FocusControl = dynCliConvenio.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert4K202( ) ;
               if ( AnyError == 1 )
               {
                  GX_FocusControl = "" ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "CLICOD");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtCliCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = dynCliConvenio.getInternalname() ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert4K202( ) ;
                  if ( AnyError == 1 )
                  {
                     GX_FocusControl = "" ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
      afterTrn( ) ;
      if ( isUpd( ) || isDlt( ) )
      {
         if ( AnyError == 0 )
         {
            httpContext.nUserReturn = (byte)(1) ;
         }
      }
   }

   public void btn_delete( )
   {
      if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = Z1564CliPaiConve ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = Z1565CliConvenio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = dynCliConvenio.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency4K202( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T004K2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ClienteConvenios"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( Z2130CliConveActObl != T004K2_A2130CliConveActObl[0] ) || ( Z1639CliConveHab != T004K2_A1639CliConveHab[0] ) || ( Z2429CliConveEsquemaEs != T004K2_A2429CliConveEsquemaEs[0] ) || ( Z1566CliConveVer != T004K2_A1566CliConveVer[0] ) )
         {
            if ( Z2130CliConveActObl != T004K2_A2130CliConveActObl[0] )
            {
               GXutil.writeLogln("clienteconvenios:[seudo value changed for attri]"+"CliConveActObl");
               GXutil.writeLogRaw("Old: ",Z2130CliConveActObl);
               GXutil.writeLogRaw("Current: ",T004K2_A2130CliConveActObl[0]);
            }
            if ( Z1639CliConveHab != T004K2_A1639CliConveHab[0] )
            {
               GXutil.writeLogln("clienteconvenios:[seudo value changed for attri]"+"CliConveHab");
               GXutil.writeLogRaw("Old: ",Z1639CliConveHab);
               GXutil.writeLogRaw("Current: ",T004K2_A1639CliConveHab[0]);
            }
            if ( Z2429CliConveEsquemaEs != T004K2_A2429CliConveEsquemaEs[0] )
            {
               GXutil.writeLogln("clienteconvenios:[seudo value changed for attri]"+"CliConveEsquemaEs");
               GXutil.writeLogRaw("Old: ",Z2429CliConveEsquemaEs);
               GXutil.writeLogRaw("Current: ",T004K2_A2429CliConveEsquemaEs[0]);
            }
            if ( Z1566CliConveVer != T004K2_A1566CliConveVer[0] )
            {
               GXutil.writeLogln("clienteconvenios:[seudo value changed for attri]"+"CliConveVer");
               GXutil.writeLogRaw("Old: ",Z1566CliConveVer);
               GXutil.writeLogRaw("Current: ",T004K2_A1566CliConveVer[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ClienteConvenios"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert4K202( )
   {
      beforeValidate4K202( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable4K202( ) ;
      }
      if ( AnyError == 0 )
      {
         zm4K202( 0) ;
         checkOptimisticConcurrency4K202( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm4K202( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert4K202( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T004K14 */
                  pr_default.execute(12, new Object[] {Boolean.valueOf(A2130CliConveActObl), Boolean.valueOf(A1639CliConveHab), Boolean.valueOf(A2429CliConveEsquemaEs), Integer.valueOf(A3CliCod), Boolean.valueOf(n1566CliConveVer), Integer.valueOf(A1566CliConveVer), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ClienteConvenios");
                  if ( (pr_default.getStatus(12) == 1) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption4K0( ) ;
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load4K202( ) ;
         }
         endLevel4K202( ) ;
      }
      closeExtendedTableCursors4K202( ) ;
   }

   public void update4K202( )
   {
      beforeValidate4K202( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable4K202( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency4K202( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm4K202( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate4K202( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T004K15 */
                  pr_default.execute(13, new Object[] {Boolean.valueOf(A2130CliConveActObl), Boolean.valueOf(A1639CliConveHab), Boolean.valueOf(A2429CliConveEsquemaEs), Boolean.valueOf(n1566CliConveVer), Integer.valueOf(A1566CliConveVer), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ClienteConvenios");
                  if ( (pr_default.getStatus(13) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ClienteConvenios"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate4K202( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        if ( isUpd( ) || isDlt( ) )
                        {
                           if ( AnyError == 0 )
                           {
                              httpContext.nUserReturn = (byte)(1) ;
                           }
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel4K202( ) ;
      }
      closeExtendedTableCursors4K202( ) ;
   }

   public void deferredUpdate4K202( )
   {
   }

   public void delete( )
   {
      beforeValidate4K202( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency4K202( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls4K202( ) ;
         afterConfirm4K202( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete4K202( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T004K16 */
               pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ClienteConvenios");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     if ( isUpd( ) || isDlt( ) )
                     {
                        if ( AnyError == 0 )
                        {
                           httpContext.nUserReturn = (byte)(1) ;
                        }
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode202 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel4K202( ) ;
      Gx_mode = sMode202 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls4K202( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV25Pgmname = "ClienteConvenios" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25Pgmname", AV25Pgmname);
         /* Using cursor T004K17 */
         pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod)});
         A344CliNom = T004K17_A344CliNom[0] ;
         pr_default.close(15);
         /* Using cursor T004K18 */
         pr_default.execute(16, new Object[] {Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         A1567CliConvenioDescrip = T004K18_A1567CliConvenioDescrip[0] ;
         A2132CliConveEscFrecAct = T004K18_A2132CliConveEscFrecAct[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2132CliConveEscFrecAct", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2132CliConveEscFrecAct), 4, 0));
         pr_default.close(16);
         /* Using cursor T004K19 */
         pr_default.execute(17, new Object[] {Boolean.valueOf(n1566CliConveVer), Integer.valueOf(A1566CliConveVer)});
         A1568CliConveVerNom = T004K19_A1568CliConveVerNom[0] ;
         pr_default.close(17);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T004K20 */
         pr_default.execute(18, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(18) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LiquidacionConvenio", "")+" ("+httpContext.getMessage( "Convenio Liquidacion", "")+")"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(18);
         /* Using cursor T004K21 */
         pr_default.execute(19, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(19) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LiquidacionConvenio", "")+" ("+httpContext.getMessage( "Convenio Liquidacion", "")+")"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(19);
         /* Using cursor T004K22 */
         pr_default.execute(20, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(20) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "convenio_estados_no_presen", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(20);
         /* Using cursor T004K23 */
         pr_default.execute(21, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(21) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "cliente Convenio_importes", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(21);
         /* Using cursor T004K24 */
         pr_default.execute(22, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(22) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "convenio_tiposdetrabajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(22);
         /* Using cursor T004K25 */
         pr_default.execute(23, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(23) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Promedio para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(23);
         /* Using cursor T004K26 */
         pr_default.execute(24, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(24) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Convenio_horasextras_por Dia", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(24);
         /* Using cursor T004K27 */
         pr_default.execute(25, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(25) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(25);
         /* Using cursor T004K28 */
         pr_default.execute(26, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(26) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(26);
         /* Using cursor T004K29 */
         pr_default.execute(27, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(27) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(27);
         /* Using cursor T004K30 */
         pr_default.execute(28, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(28) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(28);
         /* Using cursor T004K31 */
         pr_default.execute(29, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(29) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(29);
         /* Using cursor T004K32 */
         pr_default.execute(30, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(30) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(30);
         /* Using cursor T004K33 */
         pr_default.execute(31, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(31) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(31);
         /* Using cursor T004K34 */
         pr_default.execute(32, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(32) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(32);
         /* Using cursor T004K35 */
         pr_default.execute(33, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(33) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(33);
         /* Using cursor T004K36 */
         pr_default.execute(34, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(34) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(34);
         /* Using cursor T004K37 */
         pr_default.execute(35, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(35) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(35);
         /* Using cursor T004K38 */
         pr_default.execute(36, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(36) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(36);
         /* Using cursor T004K39 */
         pr_default.execute(37, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(37) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(37);
         /* Using cursor T004K40 */
         pr_default.execute(38, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(38) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(38);
         /* Using cursor T004K41 */
         pr_default.execute(39, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(39) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(39);
         /* Using cursor T004K42 */
         pr_default.execute(40, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(40) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(40);
         /* Using cursor T004K43 */
         pr_default.execute(41, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(41) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(41);
         /* Using cursor T004K44 */
         pr_default.execute(42, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(42) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(42);
         /* Using cursor T004K45 */
         pr_default.execute(43, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(43) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(43);
         /* Using cursor T004K46 */
         pr_default.execute(44, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(44) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(44);
         /* Using cursor T004K47 */
         pr_default.execute(45, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(45) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(45);
         /* Using cursor T004K48 */
         pr_default.execute(46, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(46) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(46);
         /* Using cursor T004K49 */
         pr_default.execute(47, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(47) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(47);
         /* Using cursor T004K50 */
         pr_default.execute(48, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(48) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(48);
         /* Using cursor T004K51 */
         pr_default.execute(49, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(49) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(49);
         /* Using cursor T004K52 */
         pr_default.execute(50, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(50) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(50);
         /* Using cursor T004K53 */
         pr_default.execute(51, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(51) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(51);
         /* Using cursor T004K54 */
         pr_default.execute(52, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(52) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(52);
         /* Using cursor T004K55 */
         pr_default.execute(53, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(53) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(53);
         /* Using cursor T004K56 */
         pr_default.execute(54, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(54) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(54);
         /* Using cursor T004K57 */
         pr_default.execute(55, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(55) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(55);
         /* Using cursor T004K58 */
         pr_default.execute(56, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(56) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(56);
         /* Using cursor T004K59 */
         pr_default.execute(57, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(57) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(57);
         /* Using cursor T004K60 */
         pr_default.execute(58, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(58) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(58);
         /* Using cursor T004K61 */
         pr_default.execute(59, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(59) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(59);
         /* Using cursor T004K62 */
         pr_default.execute(60, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(60) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(60);
         /* Using cursor T004K63 */
         pr_default.execute(61, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(61) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(61);
         /* Using cursor T004K64 */
         pr_default.execute(62, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(62) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(62);
         /* Using cursor T004K65 */
         pr_default.execute(63, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(63) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(63);
         /* Using cursor T004K66 */
         pr_default.execute(64, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(64) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(64);
         /* Using cursor T004K67 */
         pr_default.execute(65, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(65) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(65);
         /* Using cursor T004K68 */
         pr_default.execute(66, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(66) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(66);
         /* Using cursor T004K69 */
         pr_default.execute(67, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(67) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(67);
         /* Using cursor T004K70 */
         pr_default.execute(68, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(68) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(68);
         /* Using cursor T004K71 */
         pr_default.execute(69, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(69) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(69);
         /* Using cursor T004K72 */
         pr_default.execute(70, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(70) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(70);
         /* Using cursor T004K73 */
         pr_default.execute(71, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(71) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(71);
         /* Using cursor T004K74 */
         pr_default.execute(72, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(72) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(72);
         /* Using cursor T004K75 */
         pr_default.execute(73, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(73) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(73);
         /* Using cursor T004K76 */
         pr_default.execute(74, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(74) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(74);
         /* Using cursor T004K77 */
         pr_default.execute(75, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(75) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(75);
         /* Using cursor T004K78 */
         pr_default.execute(76, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(76) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(76);
         /* Using cursor T004K79 */
         pr_default.execute(77, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(77) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(77);
         /* Using cursor T004K80 */
         pr_default.execute(78, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(78) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(78);
         /* Using cursor T004K81 */
         pr_default.execute(79, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(79) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(79);
         /* Using cursor T004K82 */
         pr_default.execute(80, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(80) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(80);
         /* Using cursor T004K83 */
         pr_default.execute(81, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(81) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Convenio_base_calculo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(81);
         /* Using cursor T004K84 */
         pr_default.execute(82, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(82) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "convenio_adicional", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(82);
         /* Using cursor T004K85 */
         pr_default.execute(83, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(83) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Categoria", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(83);
         /* Using cursor T004K86 */
         pr_default.execute(84, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(84) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Cliente Convenio_Particularidades", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(84);
      }
   }

   public void endLevel4K202( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete4K202( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "clienteconvenios");
         if ( AnyError == 0 )
         {
            confirmValues4K0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "clienteconvenios");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart4K202( )
   {
      /* Scan By routine */
      /* Using cursor T004K87 */
      pr_default.execute(85);
      RcdFound202 = (short)(0) ;
      if ( (pr_default.getStatus(85) != 101) )
      {
         RcdFound202 = (short)(1) ;
         A3CliCod = T004K87_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = T004K87_A1564CliPaiConve[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = T004K87_A1565CliConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext4K202( )
   {
      /* Scan next routine */
      pr_default.readNext(85);
      RcdFound202 = (short)(0) ;
      if ( (pr_default.getStatus(85) != 101) )
      {
         RcdFound202 = (short)(1) ;
         A3CliCod = T004K87_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = T004K87_A1564CliPaiConve[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = T004K87_A1565CliConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
      }
   }

   public void scanEnd4K202( )
   {
      pr_default.close(85);
   }

   public void afterConfirm4K202( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert4K202( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate4K202( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete4K202( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete4K202( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate4K202( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes4K202( )
   {
      dynCliConvenio.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynCliConvenio.getInternalname(), "Enabled", GXutil.ltrimstr( dynCliConvenio.getEnabled(), 5, 0), true);
      chkCliConveHab.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkCliConveHab.getInternalname(), "Enabled", GXutil.ltrimstr( chkCliConveHab.getEnabled(), 5, 0), true);
      edtCliConveEscFrecAct_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConveEscFrecAct_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveEscFrecAct_Enabled), 5, 0), true);
      chkCliConveActObl.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkCliConveActObl.getInternalname(), "Enabled", GXutil.ltrimstr( chkCliConveActObl.getEnabled(), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtCliPaiConve_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Enabled), 5, 0), true);
      edtCliConveVer_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConveVer_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveVer_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes4K202( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues4K0( )
   {
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
      MasterPageObj.master_styles();
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
      bodyStyle += "-moz-opacity:0;opacity:0;" ;
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.clienteconvenios", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(AV9CliConvenio))}, new String[] {"Gx_mode","CliCod","CliPaiConve","CliConvenio"}) +"\">") ;
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
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", "hsh"+"ClienteConvenios");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("CliConveEsquemaEs", GXutil.booltostr( A2429CliConveEsquemaEs));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("clienteconvenios:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1564CliPaiConve", GXutil.ltrim( localUtil.ntoc( Z1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1565CliConvenio", GXutil.rtrim( Z1565CliConvenio));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z2130CliConveActObl", Z2130CliConveActObl);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1639CliConveHab", Z1639CliConveHab);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z2429CliConveEsquemaEs", Z2429CliConveEsquemaEs);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1566CliConveVer", GXutil.ltrim( localUtil.ntoc( Z1566CliConveVer, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "N1566CliConveVer", GXutil.ltrim( localUtil.ntoc( A1566CliConveVer, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLIPAICONVE", GXutil.ltrim( localUtil.ntoc( AV8CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIPAICONVE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CliPaiConve), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICONVENIO", GXutil.rtrim( AV9CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9CliConvenio, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_CLICONVEVER", GXutil.ltrim( localUtil.ntoc( AV15Insert_CliConveVer, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGXBSCREEN", GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "CLICONVEESQUEMAES", A2429CliConveEsquemaEs);
      web.GxWebStd.gx_hidden_field( httpContext, "CLINOM", A344CliNom);
      web.GxWebStd.gx_hidden_field( httpContext, "CLICONVEVERNOM", A1568CliConveVerNom);
      web.GxWebStd.gx_hidden_field( httpContext, "CLICONVENIODESCRIP", A1567CliConvenioDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV25Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Objectcall", GXutil.rtrim( Dvpanel_tableattributes_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Enabled", GXutil.booltostr( Dvpanel_tableattributes_Enabled));
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

   public byte executeStartEvent( )
   {
      standaloneStartup( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      return gxajaxcallmode ;
   }

   public void renderHtmlContent( )
   {
      httpContext.writeText( "<div") ;
      web.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
      httpContext.writeText( ">") ;
      draw( ) ;
      httpContext.writeText( "</div>") ;
   }

   public void dispatchEvents( )
   {
      process( ) ;
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
      return formatLink("web.clienteconvenios", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(AV9CliConvenio))}, new String[] {"Gx_mode","CliCod","CliPaiConve","CliConvenio"})  ;
   }

   public String getPgmname( )
   {
      return "ClienteConvenios" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Cliente Convenios", "") ;
   }

   public void initializeNonKey4K202( )
   {
      A1567CliConvenioDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1567CliConvenioDescrip", A1567CliConvenioDescrip);
      A1568CliConveVerNom = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1568CliConveVerNom", A1568CliConveVerNom);
      A2132CliConveEscFrecAct = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2132CliConveEscFrecAct", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2132CliConveEscFrecAct), 4, 0));
      A2130CliConveActObl = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2130CliConveActObl", A2130CliConveActObl);
      A344CliNom = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A344CliNom", A344CliNom);
      A1639CliConveHab = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1639CliConveHab", A1639CliConveHab);
      A2429CliConveEsquemaEs = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2429CliConveEsquemaEs", A2429CliConveEsquemaEs);
      A1566CliConveVer = new web.primerversiondeconvenio(remoteHandle, context).executeUdp( (short)(0), "") ;
      n1566CliConveVer = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1566CliConveVer", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1566CliConveVer), 6, 0));
      Z2130CliConveActObl = false ;
      Z1639CliConveHab = false ;
      Z2429CliConveEsquemaEs = false ;
      Z1566CliConveVer = 0 ;
   }

   public void initAll4K202( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1564CliPaiConve = AV21PaiCod ;
      httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
      A1565CliConvenio = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
      initializeNonKey4K202( ) ;
   }

   public void standaloneModalInsert( )
   {
      A1566CliConveVer = i1566CliConveVer ;
      n1566CliConveVer = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1566CliConveVer", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1566CliConveVer), 6, 0));
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025181747620", true, true);
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
      httpContext.AddJavascriptSource("clienteconvenios.js", "?2025181747620", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      dynCliConvenio.setInternalname( "CLICONVENIO" );
      chkCliConveHab.setInternalname( "CLICONVEHAB" );
      divCliconvehab_cell_Internalname = "CLICONVEHAB_CELL" ;
      edtCliConveEscFrecAct_Internalname = "CLICONVEESCFRECACT" ;
      chkCliConveActObl.setInternalname( "CLICONVEACTOBL" );
      divCliconveactobl_cell_Internalname = "CLICONVEACTOBL_CELL" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtCliPaiConve_Internalname = "CLIPAICONVE" ;
      edtCliConveVer_Internalname = "CLICONVEVER" ;
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
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Cliente Convenios", "") );
      edtCliConveVer_Jsonclick = "" ;
      edtCliConveVer_Enabled = 1 ;
      edtCliConveVer_Visible = 1 ;
      edtCliPaiConve_Jsonclick = "" ;
      edtCliPaiConve_Enabled = 1 ;
      edtCliPaiConve_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      chkCliConveActObl.setEnabled( 1 );
      chkCliConveActObl.setVisible( 1 );
      divCliconveactobl_cell_Class = "col-xs-12" ;
      edtCliConveEscFrecAct_Jsonclick = "" ;
      edtCliConveEscFrecAct_Enabled = 0 ;
      chkCliConveHab.setEnabled( 1 );
      chkCliConveHab.setVisible( 1 );
      divCliconvehab_cell_Class = "col-xs-12" ;
      dynCliConvenio.setJsonclick( "" );
      dynCliConvenio.setEnabled( 1 );
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
      divLayoutmaintable_Class = "Table" ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxdlacliconvenio4K202( short AV8CliPaiConve )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlacliconvenio_data4K202( AV8CliPaiConve) ;
      gxdynajaxindex = 1 ;
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         addString( gxwrpcisep+"{\"c\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrlcodr.item(gxdynajaxindex))+"\",\"d\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrldescr.item(gxdynajaxindex))+"\"}") ;
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
         gxwrpcisep = "," ;
      }
      addString( "]") ;
      if ( gxdynajaxctrlcodr.getCount() == 0 )
      {
         addString( ",101") ;
      }
      addString( "]") ;
   }

   public void gxacliconvenio_html4K202( short AV8CliPaiConve )
   {
      String gxdynajaxvalue;
      gxdlacliconvenio_data4K202( AV8CliPaiConve) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynCliConvenio.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynCliConvenio.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlacliconvenio_data4K202( short AV8CliPaiConve )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T004K88 */
      pr_default.execute(86, new Object[] {Short.valueOf(AV8CliPaiConve)});
      while ( (pr_default.getStatus(86) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( T004K88_A9ConveCodigo[0]));
         gxdynajaxctrldescr.add(T004K88_A160ConveDescri[0]);
         pr_default.readNext(86);
      }
      pr_default.close(86);
   }

   public void gx3asaclicod4K202( int AV7CliCod )
   {
      if ( ! (0==AV7CliCod) )
      {
         A3CliCod = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int4 = A3CliCod ;
            GXv_int5[0] = GXt_int4 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
            clienteconvenios_impl.this.GXt_int4 = GXv_int5[0] ;
            A3CliCod = GXt_int4 ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx9asacliconvever4K202( int AV15Insert_CliConveVer ,
                                       byte Gx_BScreen )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV15Insert_CliConveVer) )
      {
         A1566CliConveVer = AV15Insert_CliConveVer ;
         n1566CliConveVer = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1566CliConveVer", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1566CliConveVer), 6, 0));
      }
      else
      {
         if ( isIns( )  && (0==A1566CliConveVer) && ( Gx_BScreen == 0 ) )
         {
            GXt_int4 = A1566CliConveVer ;
            GXv_int5[0] = GXt_int4 ;
            new web.primerversiondeconvenio(remoteHandle, context).execute( (short)(0), "", GXv_int5) ;
            clienteconvenios_impl.this.GXt_int4 = GXv_int5[0] ;
            A1566CliConveVer = GXt_int4 ;
            n1566CliConveVer = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1566CliConveVer", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1566CliConveVer), 6, 0));
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A1566CliConveVer, (byte)(6), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gxasa16394K202( int AV7CliCod )
   {
      GXt_boolean2 = false ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new web.getclienteconveniador(remoteHandle, context).execute( AV7CliCod, GXv_boolean3) ;
      clienteconvenios_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      chkCliConveHab.setVisible( (GXt_boolean2 ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkCliConveHab.getInternalname(), "Visible", GXutil.ltrimstr( chkCliConveHab.getVisible(), 5, 0), true);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gxasa21304K202( int AV7CliCod )
   {
      GXt_boolean2 = false ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new web.getclienteconveniador(remoteHandle, context).execute( AV7CliCod, GXv_boolean3) ;
      clienteconvenios_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      chkCliConveActObl.setVisible( (!GXt_boolean2 ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkCliConveActObl.getInternalname(), "Visible", GXutil.ltrimstr( chkCliConveActObl.getVisible(), 5, 0), true);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void init_web_controls( )
   {
      dynCliConvenio.setName( "CLICONVENIO" );
      dynCliConvenio.setWebtags( "" );
      chkCliConveHab.setName( "CLICONVEHAB" );
      chkCliConveHab.setWebtags( "" );
      chkCliConveHab.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkCliConveHab.getInternalname(), "TitleCaption", chkCliConveHab.getCaption(), true);
      chkCliConveHab.setCheckedValue( "false" );
      A1639CliConveHab = GXutil.strtobool( GXutil.booltostr( A1639CliConveHab)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1639CliConveHab", A1639CliConveHab);
      chkCliConveActObl.setName( "CLICONVEACTOBL" );
      chkCliConveActObl.setWebtags( "" );
      chkCliConveActObl.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkCliConveActObl.getInternalname(), "TitleCaption", chkCliConveActObl.getCaption(), true);
      chkCliConveActObl.setCheckedValue( "false" );
      A2130CliConveActObl = GXutil.strtobool( GXutil.booltostr( A2130CliConveActObl)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2130CliConveActObl", A2130CliConveActObl);
      /* End function init_web_controls */
   }

   public boolean isIns( )
   {
      return ((GXutil.strcmp(Gx_mode, "INS")==0) ? true : false) ;
   }

   public boolean isDlt( )
   {
      return ((GXutil.strcmp(Gx_mode, "DLT")==0) ? true : false) ;
   }

   public boolean isUpd( )
   {
      return ((GXutil.strcmp(Gx_mode, "UPD")==0) ? true : false) ;
   }

   public boolean isDsp( )
   {
      return ((GXutil.strcmp(Gx_mode, "DSP")==0) ? true : false) ;
   }

   public void valid_Clicod( )
   {
      A1565CliConvenio = dynCliConvenio.getValue() ;
      /* Using cursor T004K89 */
      pr_default.execute(87, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(87) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      A344CliNom = T004K89_A344CliNom[0] ;
      pr_default.close(87);
      dynload_actions( ) ;
      if ( dynCliConvenio.getItemCount() > 0 )
      {
         A1565CliConvenio = dynCliConvenio.getValidValue(A1565CliConvenio) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynCliConvenio.setValue( GXutil.rtrim( A1565CliConvenio) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A344CliNom", A344CliNom);
   }

   public void valid_Clipaiconve( )
   {
      A1565CliConvenio = dynCliConvenio.getValue() ;
      /* Using cursor T004K90 */
      pr_default.execute(88, new Object[] {Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
      if ( (pr_default.getStatus(88) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Conve Versiones", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVENIO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliPaiConve_Internalname ;
      }
      A1567CliConvenioDescrip = T004K90_A1567CliConvenioDescrip[0] ;
      A2132CliConveEscFrecAct = T004K90_A2132CliConveEscFrecAct[0] ;
      pr_default.close(88);
      dynload_actions( ) ;
      if ( dynCliConvenio.getItemCount() > 0 )
      {
         A1565CliConvenio = dynCliConvenio.getValidValue(A1565CliConvenio) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynCliConvenio.setValue( GXutil.rtrim( A1565CliConvenio) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A1567CliConvenioDescrip", A1567CliConvenioDescrip);
      httpContext.ajax_rsp_assign_attri("", false, "A2132CliConveEscFrecAct", GXutil.ltrim( localUtil.ntoc( A2132CliConveEscFrecAct, (byte)(4), (byte)(0), ".", "")));
   }

   public void valid_Cliconvever( )
   {
      n1566CliConveVer = false ;
      A1565CliConvenio = dynCliConvenio.getValue() ;
      /* Using cursor T004K91 */
      pr_default.execute(89, new Object[] {Boolean.valueOf(n1566CliConveVer), Integer.valueOf(A1566CliConveVer)});
      if ( (pr_default.getStatus(89) == 101) )
      {
         if ( ! ( (0==A1566CliConveVer) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Convenio Cliente Version", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVEVER");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliConveVer_Internalname ;
         }
      }
      A1568CliConveVerNom = T004K91_A1568CliConveVerNom[0] ;
      pr_default.close(89);
      dynload_actions( ) ;
      if ( dynCliConvenio.getItemCount() > 0 )
      {
         A1565CliConvenio = dynCliConvenio.getValidValue(A1565CliConvenio) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynCliConvenio.setValue( GXutil.rtrim( A1565CliConvenio) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A1568CliConveVerNom", A1568CliConveVerNom);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'A1639CliConveHab',fld:'CLICONVEHAB',pic:''},{av:'A2130CliConveActObl',fld:'CLICONVEACTOBL',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'A1639CliConveHab',fld:'CLICONVEHAB',pic:''},{av:'A2130CliConveActObl',fld:'CLICONVEACTOBL',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'A2429CliConveEsquemaEs',fld:'CLICONVEESQUEMAES',pic:''},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'A1639CliConveHab',fld:'CLICONVEHAB',pic:''},{av:'A2130CliConveActObl',fld:'CLICONVEACTOBL',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'A1639CliConveHab',fld:'CLICONVEHAB',pic:''},{av:'A2130CliConveActObl',fld:'CLICONVEACTOBL',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e124K2',iparms:[{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'A1639CliConveHab',fld:'CLICONVEHAB',pic:''},{av:'A2130CliConveActObl',fld:'CLICONVEACTOBL',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'A1639CliConveHab',fld:'CLICONVEHAB',pic:''},{av:'A2130CliConveActObl',fld:'CLICONVEACTOBL',pic:''}]}");
      setEventMetadata("VALID_CLICONVENIO","{handler:'valid_Cliconvenio',iparms:[{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'A1639CliConveHab',fld:'CLICONVEHAB',pic:''},{av:'A2130CliConveActObl',fld:'CLICONVEACTOBL',pic:''}]");
      setEventMetadata("VALID_CLICONVENIO",",oparms:[{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'A1639CliConveHab',fld:'CLICONVEHAB',pic:''},{av:'A2130CliConveActObl',fld:'CLICONVEACTOBL',pic:''}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A344CliNom',fld:'CLINOM',pic:'@!'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'A1639CliConveHab',fld:'CLICONVEHAB',pic:''},{av:'A2130CliConveActObl',fld:'CLICONVEACTOBL',pic:''}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'A344CliNom',fld:'CLINOM',pic:'@!'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'A1639CliConveHab',fld:'CLICONVEHAB',pic:''},{av:'A2130CliConveActObl',fld:'CLICONVEACTOBL',pic:''}]}");
      setEventMetadata("VALID_CLIPAICONVE","{handler:'valid_Clipaiconve',iparms:[{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'A1567CliConvenioDescrip',fld:'CLICONVENIODESCRIP',pic:''},{av:'A2132CliConveEscFrecAct',fld:'CLICONVEESCFRECACT',pic:'ZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'A1639CliConveHab',fld:'CLICONVEHAB',pic:''},{av:'A2130CliConveActObl',fld:'CLICONVEACTOBL',pic:''}]");
      setEventMetadata("VALID_CLIPAICONVE",",oparms:[{av:'A1567CliConvenioDescrip',fld:'CLICONVENIODESCRIP',pic:''},{av:'A2132CliConveEscFrecAct',fld:'CLICONVEESCFRECACT',pic:'ZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'A1639CliConveHab',fld:'CLICONVEHAB',pic:''},{av:'A2130CliConveActObl',fld:'CLICONVEACTOBL',pic:''}]}");
      setEventMetadata("VALID_CLICONVEVER","{handler:'valid_Cliconvever',iparms:[{av:'A1566CliConveVer',fld:'CLICONVEVER',pic:'ZZZZZ9'},{av:'A1568CliConveVerNom',fld:'CLICONVEVERNOM',pic:'@!'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'A1639CliConveHab',fld:'CLICONVEHAB',pic:''},{av:'A2130CliConveActObl',fld:'CLICONVEACTOBL',pic:''}]");
      setEventMetadata("VALID_CLICONVEVER",",oparms:[{av:'A1568CliConveVerNom',fld:'CLICONVEVERNOM',pic:'@!'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'A1639CliConveHab',fld:'CLICONVEHAB',pic:''},{av:'A2130CliConveActObl',fld:'CLICONVEACTOBL',pic:''}]}");
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
      pr_default.close(87);
      pr_default.close(15);
      pr_default.close(89);
      pr_default.close(17);
      pr_default.close(88);
      pr_default.close(16);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV9CliConvenio = "" ;
      Z1565CliConvenio = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A1565CliConvenio = "" ;
      Gx_mode = "" ;
      AV9CliConvenio = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A344CliNom = "" ;
      A1568CliConveVerNom = "" ;
      A1567CliConvenioDescrip = "" ;
      AV25Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode202 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV10WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV13TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV14WebSession = httpContext.getWebSession();
      AV16TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      Z344CliNom = "" ;
      Z1567CliConvenioDescrip = "" ;
      Z1568CliConveVerNom = "" ;
      T004K4_A344CliNom = new String[] {""} ;
      T004K6_A1567CliConvenioDescrip = new String[] {""} ;
      T004K6_A2132CliConveEscFrecAct = new short[1] ;
      T004K5_A1568CliConveVerNom = new String[] {""} ;
      T004K7_A1567CliConvenioDescrip = new String[] {""} ;
      T004K7_A1568CliConveVerNom = new String[] {""} ;
      T004K7_A2132CliConveEscFrecAct = new short[1] ;
      T004K7_A2130CliConveActObl = new boolean[] {false} ;
      T004K7_A344CliNom = new String[] {""} ;
      T004K7_A1639CliConveHab = new boolean[] {false} ;
      T004K7_A2429CliConveEsquemaEs = new boolean[] {false} ;
      T004K7_A3CliCod = new int[1] ;
      T004K7_A1566CliConveVer = new int[1] ;
      T004K7_n1566CliConveVer = new boolean[] {false} ;
      T004K7_A1564CliPaiConve = new short[1] ;
      T004K7_A1565CliConvenio = new String[] {""} ;
      T004K8_A344CliNom = new String[] {""} ;
      T004K9_A1567CliConvenioDescrip = new String[] {""} ;
      T004K9_A2132CliConveEscFrecAct = new short[1] ;
      T004K10_A1568CliConveVerNom = new String[] {""} ;
      T004K11_A3CliCod = new int[1] ;
      T004K11_A1564CliPaiConve = new short[1] ;
      T004K11_A1565CliConvenio = new String[] {""} ;
      T004K3_A2130CliConveActObl = new boolean[] {false} ;
      T004K3_A1639CliConveHab = new boolean[] {false} ;
      T004K3_A2429CliConveEsquemaEs = new boolean[] {false} ;
      T004K3_A3CliCod = new int[1] ;
      T004K3_A1566CliConveVer = new int[1] ;
      T004K3_n1566CliConveVer = new boolean[] {false} ;
      T004K3_A1564CliPaiConve = new short[1] ;
      T004K3_A1565CliConvenio = new String[] {""} ;
      T004K12_A3CliCod = new int[1] ;
      T004K12_A1564CliPaiConve = new short[1] ;
      T004K12_A1565CliConvenio = new String[] {""} ;
      T004K13_A3CliCod = new int[1] ;
      T004K13_A1564CliPaiConve = new short[1] ;
      T004K13_A1565CliConvenio = new String[] {""} ;
      T004K2_A2130CliConveActObl = new boolean[] {false} ;
      T004K2_A1639CliConveHab = new boolean[] {false} ;
      T004K2_A2429CliConveEsquemaEs = new boolean[] {false} ;
      T004K2_A3CliCod = new int[1] ;
      T004K2_A1566CliConveVer = new int[1] ;
      T004K2_n1566CliConveVer = new boolean[] {false} ;
      T004K2_A1564CliPaiConve = new short[1] ;
      T004K2_A1565CliConvenio = new String[] {""} ;
      T004K17_A344CliNom = new String[] {""} ;
      T004K18_A1567CliConvenioDescrip = new String[] {""} ;
      T004K18_A2132CliConveEscFrecAct = new short[1] ;
      T004K19_A1568CliConveVerNom = new String[] {""} ;
      T004K20_A3CliCod = new int[1] ;
      T004K20_A1EmpCod = new short[1] ;
      T004K20_A31LiqNro = new int[1] ;
      T004K20_A2142LiqPaiConve = new short[1] ;
      T004K20_A2143LiqConvenio = new String[] {""} ;
      T004K21_A3CliCod = new int[1] ;
      T004K21_A1EmpCod = new short[1] ;
      T004K21_A31LiqNro = new int[1] ;
      T004K21_A2142LiqPaiConve = new short[1] ;
      T004K21_A2143LiqConvenio = new String[] {""} ;
      T004K22_A3CliCod = new int[1] ;
      T004K22_A1564CliPaiConve = new short[1] ;
      T004K22_A1565CliConvenio = new String[] {""} ;
      T004K22_A1805ConveSitPresen = new String[] {""} ;
      T004K23_A3CliCod = new int[1] ;
      T004K23_A1564CliPaiConve = new short[1] ;
      T004K23_A1565CliConvenio = new String[] {""} ;
      T004K23_A1587CliConveImpVig = new java.util.Date[] {GXutil.nullDate()} ;
      T004K23_A1588CliConveImpTipo = new String[] {""} ;
      T004K24_A3CliCod = new int[1] ;
      T004K24_A1564CliPaiConve = new short[1] ;
      T004K24_A1565CliConvenio = new String[] {""} ;
      T004K24_A1294PaiTipoTraId = new String[] {""} ;
      T004K25_A3CliCod = new int[1] ;
      T004K25_A1564CliPaiConve = new short[1] ;
      T004K25_A1565CliConvenio = new String[] {""} ;
      T004K25_A37TipoConCod = new String[] {""} ;
      T004K25_A1377ConvePromFijVar = new String[] {""} ;
      T004K26_A3CliCod = new int[1] ;
      T004K26_A1564CliPaiConve = new short[1] ;
      T004K26_A1565CliConvenio = new String[] {""} ;
      T004K26_A1327ConveHsExSec = new short[1] ;
      T004K27_A3CliCod = new int[1] ;
      T004K27_A1564CliPaiConve = new short[1] ;
      T004K27_A1565CliConvenio = new String[] {""} ;
      T004K27_A1381ConveMenCliCod = new int[1] ;
      T004K27_A1375ConveMenConCodigo = new String[] {""} ;
      T004K28_A3CliCod = new int[1] ;
      T004K28_A1564CliPaiConve = new short[1] ;
      T004K28_A1565CliConvenio = new String[] {""} ;
      T004K28_A1381ConveMenCliCod = new int[1] ;
      T004K28_A1375ConveMenConCodigo = new String[] {""} ;
      T004K29_A3CliCod = new int[1] ;
      T004K29_A1564CliPaiConve = new short[1] ;
      T004K29_A1565CliConvenio = new String[] {""} ;
      T004K29_A1381ConveMenCliCod = new int[1] ;
      T004K29_A1375ConveMenConCodigo = new String[] {""} ;
      T004K30_A3CliCod = new int[1] ;
      T004K30_A1564CliPaiConve = new short[1] ;
      T004K30_A1565CliConvenio = new String[] {""} ;
      T004K30_A1381ConveMenCliCod = new int[1] ;
      T004K30_A1375ConveMenConCodigo = new String[] {""} ;
      T004K31_A3CliCod = new int[1] ;
      T004K31_A1564CliPaiConve = new short[1] ;
      T004K31_A1565CliConvenio = new String[] {""} ;
      T004K31_A1381ConveMenCliCod = new int[1] ;
      T004K31_A1375ConveMenConCodigo = new String[] {""} ;
      T004K32_A3CliCod = new int[1] ;
      T004K32_A1564CliPaiConve = new short[1] ;
      T004K32_A1565CliConvenio = new String[] {""} ;
      T004K32_A1381ConveMenCliCod = new int[1] ;
      T004K32_A1375ConveMenConCodigo = new String[] {""} ;
      T004K33_A3CliCod = new int[1] ;
      T004K33_A1564CliPaiConve = new short[1] ;
      T004K33_A1565CliConvenio = new String[] {""} ;
      T004K33_A1381ConveMenCliCod = new int[1] ;
      T004K33_A1375ConveMenConCodigo = new String[] {""} ;
      T004K34_A3CliCod = new int[1] ;
      T004K34_A1564CliPaiConve = new short[1] ;
      T004K34_A1565CliConvenio = new String[] {""} ;
      T004K34_A1381ConveMenCliCod = new int[1] ;
      T004K34_A1375ConveMenConCodigo = new String[] {""} ;
      T004K35_A3CliCod = new int[1] ;
      T004K35_A1564CliPaiConve = new short[1] ;
      T004K35_A1565CliConvenio = new String[] {""} ;
      T004K35_A1381ConveMenCliCod = new int[1] ;
      T004K35_A1375ConveMenConCodigo = new String[] {""} ;
      T004K36_A3CliCod = new int[1] ;
      T004K36_A1564CliPaiConve = new short[1] ;
      T004K36_A1565CliConvenio = new String[] {""} ;
      T004K36_A1381ConveMenCliCod = new int[1] ;
      T004K36_A1375ConveMenConCodigo = new String[] {""} ;
      T004K37_A3CliCod = new int[1] ;
      T004K37_A1564CliPaiConve = new short[1] ;
      T004K37_A1565CliConvenio = new String[] {""} ;
      T004K37_A1381ConveMenCliCod = new int[1] ;
      T004K37_A1375ConveMenConCodigo = new String[] {""} ;
      T004K38_A3CliCod = new int[1] ;
      T004K38_A1564CliPaiConve = new short[1] ;
      T004K38_A1565CliConvenio = new String[] {""} ;
      T004K38_A1381ConveMenCliCod = new int[1] ;
      T004K38_A1375ConveMenConCodigo = new String[] {""} ;
      T004K39_A3CliCod = new int[1] ;
      T004K39_A1564CliPaiConve = new short[1] ;
      T004K39_A1565CliConvenio = new String[] {""} ;
      T004K39_A1381ConveMenCliCod = new int[1] ;
      T004K39_A1375ConveMenConCodigo = new String[] {""} ;
      T004K40_A3CliCod = new int[1] ;
      T004K40_A1564CliPaiConve = new short[1] ;
      T004K40_A1565CliConvenio = new String[] {""} ;
      T004K40_A1381ConveMenCliCod = new int[1] ;
      T004K40_A1375ConveMenConCodigo = new String[] {""} ;
      T004K41_A3CliCod = new int[1] ;
      T004K41_A1564CliPaiConve = new short[1] ;
      T004K41_A1565CliConvenio = new String[] {""} ;
      T004K41_A1381ConveMenCliCod = new int[1] ;
      T004K41_A1375ConveMenConCodigo = new String[] {""} ;
      T004K42_A3CliCod = new int[1] ;
      T004K42_A1564CliPaiConve = new short[1] ;
      T004K42_A1565CliConvenio = new String[] {""} ;
      T004K42_A1381ConveMenCliCod = new int[1] ;
      T004K42_A1375ConveMenConCodigo = new String[] {""} ;
      T004K43_A3CliCod = new int[1] ;
      T004K43_A1564CliPaiConve = new short[1] ;
      T004K43_A1565CliConvenio = new String[] {""} ;
      T004K43_A1381ConveMenCliCod = new int[1] ;
      T004K43_A1375ConveMenConCodigo = new String[] {""} ;
      T004K44_A3CliCod = new int[1] ;
      T004K44_A1564CliPaiConve = new short[1] ;
      T004K44_A1565CliConvenio = new String[] {""} ;
      T004K44_A1381ConveMenCliCod = new int[1] ;
      T004K44_A1375ConveMenConCodigo = new String[] {""} ;
      T004K45_A3CliCod = new int[1] ;
      T004K45_A1564CliPaiConve = new short[1] ;
      T004K45_A1565CliConvenio = new String[] {""} ;
      T004K45_A1381ConveMenCliCod = new int[1] ;
      T004K45_A1375ConveMenConCodigo = new String[] {""} ;
      T004K46_A3CliCod = new int[1] ;
      T004K46_A1564CliPaiConve = new short[1] ;
      T004K46_A1565CliConvenio = new String[] {""} ;
      T004K46_A1381ConveMenCliCod = new int[1] ;
      T004K46_A1375ConveMenConCodigo = new String[] {""} ;
      T004K47_A3CliCod = new int[1] ;
      T004K47_A1564CliPaiConve = new short[1] ;
      T004K47_A1565CliConvenio = new String[] {""} ;
      T004K47_A1381ConveMenCliCod = new int[1] ;
      T004K47_A1375ConveMenConCodigo = new String[] {""} ;
      T004K48_A3CliCod = new int[1] ;
      T004K48_A1564CliPaiConve = new short[1] ;
      T004K48_A1565CliConvenio = new String[] {""} ;
      T004K48_A1381ConveMenCliCod = new int[1] ;
      T004K48_A1375ConveMenConCodigo = new String[] {""} ;
      T004K49_A3CliCod = new int[1] ;
      T004K49_A1564CliPaiConve = new short[1] ;
      T004K49_A1565CliConvenio = new String[] {""} ;
      T004K49_A1381ConveMenCliCod = new int[1] ;
      T004K49_A1375ConveMenConCodigo = new String[] {""} ;
      T004K50_A3CliCod = new int[1] ;
      T004K50_A1564CliPaiConve = new short[1] ;
      T004K50_A1565CliConvenio = new String[] {""} ;
      T004K50_A1381ConveMenCliCod = new int[1] ;
      T004K50_A1375ConveMenConCodigo = new String[] {""} ;
      T004K51_A3CliCod = new int[1] ;
      T004K51_A1564CliPaiConve = new short[1] ;
      T004K51_A1565CliConvenio = new String[] {""} ;
      T004K51_A1381ConveMenCliCod = new int[1] ;
      T004K51_A1375ConveMenConCodigo = new String[] {""} ;
      T004K52_A3CliCod = new int[1] ;
      T004K52_A1564CliPaiConve = new short[1] ;
      T004K52_A1565CliConvenio = new String[] {""} ;
      T004K52_A1381ConveMenCliCod = new int[1] ;
      T004K52_A1375ConveMenConCodigo = new String[] {""} ;
      T004K53_A3CliCod = new int[1] ;
      T004K53_A1564CliPaiConve = new short[1] ;
      T004K53_A1565CliConvenio = new String[] {""} ;
      T004K53_A1381ConveMenCliCod = new int[1] ;
      T004K53_A1375ConveMenConCodigo = new String[] {""} ;
      T004K54_A3CliCod = new int[1] ;
      T004K54_A1564CliPaiConve = new short[1] ;
      T004K54_A1565CliConvenio = new String[] {""} ;
      T004K54_A1381ConveMenCliCod = new int[1] ;
      T004K54_A1375ConveMenConCodigo = new String[] {""} ;
      T004K55_A3CliCod = new int[1] ;
      T004K55_A1564CliPaiConve = new short[1] ;
      T004K55_A1565CliConvenio = new String[] {""} ;
      T004K55_A1381ConveMenCliCod = new int[1] ;
      T004K55_A1375ConveMenConCodigo = new String[] {""} ;
      T004K56_A3CliCod = new int[1] ;
      T004K56_A1564CliPaiConve = new short[1] ;
      T004K56_A1565CliConvenio = new String[] {""} ;
      T004K56_A1381ConveMenCliCod = new int[1] ;
      T004K56_A1375ConveMenConCodigo = new String[] {""} ;
      T004K57_A3CliCod = new int[1] ;
      T004K57_A1564CliPaiConve = new short[1] ;
      T004K57_A1565CliConvenio = new String[] {""} ;
      T004K57_A1381ConveMenCliCod = new int[1] ;
      T004K57_A1375ConveMenConCodigo = new String[] {""} ;
      T004K58_A3CliCod = new int[1] ;
      T004K58_A1564CliPaiConve = new short[1] ;
      T004K58_A1565CliConvenio = new String[] {""} ;
      T004K58_A1381ConveMenCliCod = new int[1] ;
      T004K58_A1375ConveMenConCodigo = new String[] {""} ;
      T004K59_A3CliCod = new int[1] ;
      T004K59_A1564CliPaiConve = new short[1] ;
      T004K59_A1565CliConvenio = new String[] {""} ;
      T004K59_A1381ConveMenCliCod = new int[1] ;
      T004K59_A1375ConveMenConCodigo = new String[] {""} ;
      T004K60_A3CliCod = new int[1] ;
      T004K60_A1564CliPaiConve = new short[1] ;
      T004K60_A1565CliConvenio = new String[] {""} ;
      T004K60_A1381ConveMenCliCod = new int[1] ;
      T004K60_A1375ConveMenConCodigo = new String[] {""} ;
      T004K61_A3CliCod = new int[1] ;
      T004K61_A1564CliPaiConve = new short[1] ;
      T004K61_A1565CliConvenio = new String[] {""} ;
      T004K61_A1381ConveMenCliCod = new int[1] ;
      T004K61_A1375ConveMenConCodigo = new String[] {""} ;
      T004K62_A3CliCod = new int[1] ;
      T004K62_A1564CliPaiConve = new short[1] ;
      T004K62_A1565CliConvenio = new String[] {""} ;
      T004K62_A1381ConveMenCliCod = new int[1] ;
      T004K62_A1375ConveMenConCodigo = new String[] {""} ;
      T004K63_A3CliCod = new int[1] ;
      T004K63_A1564CliPaiConve = new short[1] ;
      T004K63_A1565CliConvenio = new String[] {""} ;
      T004K63_A1381ConveMenCliCod = new int[1] ;
      T004K63_A1375ConveMenConCodigo = new String[] {""} ;
      T004K64_A3CliCod = new int[1] ;
      T004K64_A1564CliPaiConve = new short[1] ;
      T004K64_A1565CliConvenio = new String[] {""} ;
      T004K64_A1381ConveMenCliCod = new int[1] ;
      T004K64_A1375ConveMenConCodigo = new String[] {""} ;
      T004K65_A3CliCod = new int[1] ;
      T004K65_A1564CliPaiConve = new short[1] ;
      T004K65_A1565CliConvenio = new String[] {""} ;
      T004K65_A1381ConveMenCliCod = new int[1] ;
      T004K65_A1375ConveMenConCodigo = new String[] {""} ;
      T004K66_A3CliCod = new int[1] ;
      T004K66_A1564CliPaiConve = new short[1] ;
      T004K66_A1565CliConvenio = new String[] {""} ;
      T004K66_A1381ConveMenCliCod = new int[1] ;
      T004K66_A1375ConveMenConCodigo = new String[] {""} ;
      T004K67_A3CliCod = new int[1] ;
      T004K67_A1564CliPaiConve = new short[1] ;
      T004K67_A1565CliConvenio = new String[] {""} ;
      T004K67_A1381ConveMenCliCod = new int[1] ;
      T004K67_A1375ConveMenConCodigo = new String[] {""} ;
      T004K68_A3CliCod = new int[1] ;
      T004K68_A1564CliPaiConve = new short[1] ;
      T004K68_A1565CliConvenio = new String[] {""} ;
      T004K68_A1381ConveMenCliCod = new int[1] ;
      T004K68_A1375ConveMenConCodigo = new String[] {""} ;
      T004K69_A3CliCod = new int[1] ;
      T004K69_A1564CliPaiConve = new short[1] ;
      T004K69_A1565CliConvenio = new String[] {""} ;
      T004K69_A1381ConveMenCliCod = new int[1] ;
      T004K69_A1375ConveMenConCodigo = new String[] {""} ;
      T004K70_A3CliCod = new int[1] ;
      T004K70_A1564CliPaiConve = new short[1] ;
      T004K70_A1565CliConvenio = new String[] {""} ;
      T004K70_A1381ConveMenCliCod = new int[1] ;
      T004K70_A1375ConveMenConCodigo = new String[] {""} ;
      T004K71_A3CliCod = new int[1] ;
      T004K71_A1564CliPaiConve = new short[1] ;
      T004K71_A1565CliConvenio = new String[] {""} ;
      T004K71_A1381ConveMenCliCod = new int[1] ;
      T004K71_A1375ConveMenConCodigo = new String[] {""} ;
      T004K72_A3CliCod = new int[1] ;
      T004K72_A1564CliPaiConve = new short[1] ;
      T004K72_A1565CliConvenio = new String[] {""} ;
      T004K72_A1381ConveMenCliCod = new int[1] ;
      T004K72_A1375ConveMenConCodigo = new String[] {""} ;
      T004K73_A3CliCod = new int[1] ;
      T004K73_A1564CliPaiConve = new short[1] ;
      T004K73_A1565CliConvenio = new String[] {""} ;
      T004K73_A1381ConveMenCliCod = new int[1] ;
      T004K73_A1375ConveMenConCodigo = new String[] {""} ;
      T004K74_A3CliCod = new int[1] ;
      T004K74_A1564CliPaiConve = new short[1] ;
      T004K74_A1565CliConvenio = new String[] {""} ;
      T004K74_A1381ConveMenCliCod = new int[1] ;
      T004K74_A1375ConveMenConCodigo = new String[] {""} ;
      T004K75_A3CliCod = new int[1] ;
      T004K75_A1564CliPaiConve = new short[1] ;
      T004K75_A1565CliConvenio = new String[] {""} ;
      T004K75_A1381ConveMenCliCod = new int[1] ;
      T004K75_A1375ConveMenConCodigo = new String[] {""} ;
      T004K76_A3CliCod = new int[1] ;
      T004K76_A1564CliPaiConve = new short[1] ;
      T004K76_A1565CliConvenio = new String[] {""} ;
      T004K76_A1381ConveMenCliCod = new int[1] ;
      T004K76_A1375ConveMenConCodigo = new String[] {""} ;
      T004K77_A3CliCod = new int[1] ;
      T004K77_A1564CliPaiConve = new short[1] ;
      T004K77_A1565CliConvenio = new String[] {""} ;
      T004K77_A1381ConveMenCliCod = new int[1] ;
      T004K77_A1375ConveMenConCodigo = new String[] {""} ;
      T004K78_A3CliCod = new int[1] ;
      T004K78_A1564CliPaiConve = new short[1] ;
      T004K78_A1565CliConvenio = new String[] {""} ;
      T004K78_A1381ConveMenCliCod = new int[1] ;
      T004K78_A1375ConveMenConCodigo = new String[] {""} ;
      T004K79_A3CliCod = new int[1] ;
      T004K79_A1564CliPaiConve = new short[1] ;
      T004K79_A1565CliConvenio = new String[] {""} ;
      T004K79_A1381ConveMenCliCod = new int[1] ;
      T004K79_A1375ConveMenConCodigo = new String[] {""} ;
      T004K80_A3CliCod = new int[1] ;
      T004K80_A1564CliPaiConve = new short[1] ;
      T004K80_A1565CliConvenio = new String[] {""} ;
      T004K80_A1381ConveMenCliCod = new int[1] ;
      T004K80_A1375ConveMenConCodigo = new String[] {""} ;
      T004K81_A3CliCod = new int[1] ;
      T004K81_A1564CliPaiConve = new short[1] ;
      T004K81_A1565CliConvenio = new String[] {""} ;
      T004K81_A1381ConveMenCliCod = new int[1] ;
      T004K81_A1375ConveMenConCodigo = new String[] {""} ;
      T004K82_A3CliCod = new int[1] ;
      T004K82_A1564CliPaiConve = new short[1] ;
      T004K82_A1565CliConvenio = new String[] {""} ;
      T004K82_A1381ConveMenCliCod = new int[1] ;
      T004K82_A1375ConveMenConCodigo = new String[] {""} ;
      T004K83_A3CliCod = new int[1] ;
      T004K83_A1564CliPaiConve = new short[1] ;
      T004K83_A1565CliConvenio = new String[] {""} ;
      T004K83_A1454ConveBaseClaseLeg = new byte[1] ;
      T004K83_A1455ConveBaseTipo = new String[] {""} ;
      T004K83_A1456ConveBaseCod1 = new String[] {""} ;
      T004K83_A1457ConveBaseCod2 = new String[] {""} ;
      T004K84_A3CliCod = new int[1] ;
      T004K84_A1564CliPaiConve = new short[1] ;
      T004K84_A1565CliConvenio = new String[] {""} ;
      T004K84_A996ConveAdicod = new String[] {""} ;
      T004K85_A3CliCod = new int[1] ;
      T004K85_A1564CliPaiConve = new short[1] ;
      T004K85_A1565CliConvenio = new String[] {""} ;
      T004K85_A8CatCodigo = new String[] {""} ;
      T004K86_A3CliCod = new int[1] ;
      T004K86_A1564CliPaiConve = new short[1] ;
      T004K86_A1565CliConvenio = new String[] {""} ;
      T004K86_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      T004K87_A3CliCod = new int[1] ;
      T004K87_A1564CliPaiConve = new short[1] ;
      T004K87_A1565CliConvenio = new String[] {""} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T004K88_A46PaiCod = new short[1] ;
      T004K88_A9ConveCodigo = new String[] {""} ;
      T004K88_A160ConveDescri = new String[] {""} ;
      GXv_int5 = new int[1] ;
      GXv_boolean3 = new boolean[1] ;
      T004K89_A344CliNom = new String[] {""} ;
      T004K90_A1567CliConvenioDescrip = new String[] {""} ;
      T004K90_A2132CliConveEscFrecAct = new short[1] ;
      T004K91_A1568CliConveVerNom = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.clienteconvenios__default(),
         new Object[] {
             new Object[] {
            T004K2_A2130CliConveActObl, T004K2_A1639CliConveHab, T004K2_A2429CliConveEsquemaEs, T004K2_A3CliCod, T004K2_A1566CliConveVer, T004K2_n1566CliConveVer, T004K2_A1564CliPaiConve, T004K2_A1565CliConvenio
            }
            , new Object[] {
            T004K3_A2130CliConveActObl, T004K3_A1639CliConveHab, T004K3_A2429CliConveEsquemaEs, T004K3_A3CliCod, T004K3_A1566CliConveVer, T004K3_n1566CliConveVer, T004K3_A1564CliPaiConve, T004K3_A1565CliConvenio
            }
            , new Object[] {
            T004K4_A344CliNom
            }
            , new Object[] {
            T004K5_A1568CliConveVerNom
            }
            , new Object[] {
            T004K6_A1567CliConvenioDescrip, T004K6_A2132CliConveEscFrecAct
            }
            , new Object[] {
            T004K7_A1567CliConvenioDescrip, T004K7_A1568CliConveVerNom, T004K7_A2132CliConveEscFrecAct, T004K7_A2130CliConveActObl, T004K7_A344CliNom, T004K7_A1639CliConveHab, T004K7_A2429CliConveEsquemaEs, T004K7_A3CliCod, T004K7_A1566CliConveVer, T004K7_n1566CliConveVer,
            T004K7_A1564CliPaiConve, T004K7_A1565CliConvenio
            }
            , new Object[] {
            T004K8_A344CliNom
            }
            , new Object[] {
            T004K9_A1567CliConvenioDescrip, T004K9_A2132CliConveEscFrecAct
            }
            , new Object[] {
            T004K10_A1568CliConveVerNom
            }
            , new Object[] {
            T004K11_A3CliCod, T004K11_A1564CliPaiConve, T004K11_A1565CliConvenio
            }
            , new Object[] {
            T004K12_A3CliCod, T004K12_A1564CliPaiConve, T004K12_A1565CliConvenio
            }
            , new Object[] {
            T004K13_A3CliCod, T004K13_A1564CliPaiConve, T004K13_A1565CliConvenio
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T004K17_A344CliNom
            }
            , new Object[] {
            T004K18_A1567CliConvenioDescrip, T004K18_A2132CliConveEscFrecAct
            }
            , new Object[] {
            T004K19_A1568CliConveVerNom
            }
            , new Object[] {
            T004K20_A3CliCod, T004K20_A1EmpCod, T004K20_A31LiqNro, T004K20_A2142LiqPaiConve, T004K20_A2143LiqConvenio
            }
            , new Object[] {
            T004K21_A3CliCod, T004K21_A1EmpCod, T004K21_A31LiqNro, T004K21_A2142LiqPaiConve, T004K21_A2143LiqConvenio
            }
            , new Object[] {
            T004K22_A3CliCod, T004K22_A1564CliPaiConve, T004K22_A1565CliConvenio, T004K22_A1805ConveSitPresen
            }
            , new Object[] {
            T004K23_A3CliCod, T004K23_A1564CliPaiConve, T004K23_A1565CliConvenio, T004K23_A1587CliConveImpVig, T004K23_A1588CliConveImpTipo
            }
            , new Object[] {
            T004K24_A3CliCod, T004K24_A1564CliPaiConve, T004K24_A1565CliConvenio, T004K24_A1294PaiTipoTraId
            }
            , new Object[] {
            T004K25_A3CliCod, T004K25_A1564CliPaiConve, T004K25_A1565CliConvenio, T004K25_A37TipoConCod, T004K25_A1377ConvePromFijVar
            }
            , new Object[] {
            T004K26_A3CliCod, T004K26_A1564CliPaiConve, T004K26_A1565CliConvenio, T004K26_A1327ConveHsExSec
            }
            , new Object[] {
            T004K27_A3CliCod, T004K27_A1564CliPaiConve, T004K27_A1565CliConvenio, T004K27_A1381ConveMenCliCod, T004K27_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K28_A3CliCod, T004K28_A1564CliPaiConve, T004K28_A1565CliConvenio, T004K28_A1381ConveMenCliCod, T004K28_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K29_A3CliCod, T004K29_A1564CliPaiConve, T004K29_A1565CliConvenio, T004K29_A1381ConveMenCliCod, T004K29_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K30_A3CliCod, T004K30_A1564CliPaiConve, T004K30_A1565CliConvenio, T004K30_A1381ConveMenCliCod, T004K30_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K31_A3CliCod, T004K31_A1564CliPaiConve, T004K31_A1565CliConvenio, T004K31_A1381ConveMenCliCod, T004K31_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K32_A3CliCod, T004K32_A1564CliPaiConve, T004K32_A1565CliConvenio, T004K32_A1381ConveMenCliCod, T004K32_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K33_A3CliCod, T004K33_A1564CliPaiConve, T004K33_A1565CliConvenio, T004K33_A1381ConveMenCliCod, T004K33_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K34_A3CliCod, T004K34_A1564CliPaiConve, T004K34_A1565CliConvenio, T004K34_A1381ConveMenCliCod, T004K34_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K35_A3CliCod, T004K35_A1564CliPaiConve, T004K35_A1565CliConvenio, T004K35_A1381ConveMenCliCod, T004K35_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K36_A3CliCod, T004K36_A1564CliPaiConve, T004K36_A1565CliConvenio, T004K36_A1381ConveMenCliCod, T004K36_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K37_A3CliCod, T004K37_A1564CliPaiConve, T004K37_A1565CliConvenio, T004K37_A1381ConveMenCliCod, T004K37_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K38_A3CliCod, T004K38_A1564CliPaiConve, T004K38_A1565CliConvenio, T004K38_A1381ConveMenCliCod, T004K38_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K39_A3CliCod, T004K39_A1564CliPaiConve, T004K39_A1565CliConvenio, T004K39_A1381ConveMenCliCod, T004K39_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K40_A3CliCod, T004K40_A1564CliPaiConve, T004K40_A1565CliConvenio, T004K40_A1381ConveMenCliCod, T004K40_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K41_A3CliCod, T004K41_A1564CliPaiConve, T004K41_A1565CliConvenio, T004K41_A1381ConveMenCliCod, T004K41_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K42_A3CliCod, T004K42_A1564CliPaiConve, T004K42_A1565CliConvenio, T004K42_A1381ConveMenCliCod, T004K42_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K43_A3CliCod, T004K43_A1564CliPaiConve, T004K43_A1565CliConvenio, T004K43_A1381ConveMenCliCod, T004K43_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K44_A3CliCod, T004K44_A1564CliPaiConve, T004K44_A1565CliConvenio, T004K44_A1381ConveMenCliCod, T004K44_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K45_A3CliCod, T004K45_A1564CliPaiConve, T004K45_A1565CliConvenio, T004K45_A1381ConveMenCliCod, T004K45_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K46_A3CliCod, T004K46_A1564CliPaiConve, T004K46_A1565CliConvenio, T004K46_A1381ConveMenCliCod, T004K46_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K47_A3CliCod, T004K47_A1564CliPaiConve, T004K47_A1565CliConvenio, T004K47_A1381ConveMenCliCod, T004K47_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K48_A3CliCod, T004K48_A1564CliPaiConve, T004K48_A1565CliConvenio, T004K48_A1381ConveMenCliCod, T004K48_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K49_A3CliCod, T004K49_A1564CliPaiConve, T004K49_A1565CliConvenio, T004K49_A1381ConveMenCliCod, T004K49_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K50_A3CliCod, T004K50_A1564CliPaiConve, T004K50_A1565CliConvenio, T004K50_A1381ConveMenCliCod, T004K50_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K51_A3CliCod, T004K51_A1564CliPaiConve, T004K51_A1565CliConvenio, T004K51_A1381ConveMenCliCod, T004K51_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K52_A3CliCod, T004K52_A1564CliPaiConve, T004K52_A1565CliConvenio, T004K52_A1381ConveMenCliCod, T004K52_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K53_A3CliCod, T004K53_A1564CliPaiConve, T004K53_A1565CliConvenio, T004K53_A1381ConveMenCliCod, T004K53_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K54_A3CliCod, T004K54_A1564CliPaiConve, T004K54_A1565CliConvenio, T004K54_A1381ConveMenCliCod, T004K54_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K55_A3CliCod, T004K55_A1564CliPaiConve, T004K55_A1565CliConvenio, T004K55_A1381ConveMenCliCod, T004K55_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K56_A3CliCod, T004K56_A1564CliPaiConve, T004K56_A1565CliConvenio, T004K56_A1381ConveMenCliCod, T004K56_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K57_A3CliCod, T004K57_A1564CliPaiConve, T004K57_A1565CliConvenio, T004K57_A1381ConveMenCliCod, T004K57_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K58_A3CliCod, T004K58_A1564CliPaiConve, T004K58_A1565CliConvenio, T004K58_A1381ConveMenCliCod, T004K58_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K59_A3CliCod, T004K59_A1564CliPaiConve, T004K59_A1565CliConvenio, T004K59_A1381ConveMenCliCod, T004K59_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K60_A3CliCod, T004K60_A1564CliPaiConve, T004K60_A1565CliConvenio, T004K60_A1381ConveMenCliCod, T004K60_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K61_A3CliCod, T004K61_A1564CliPaiConve, T004K61_A1565CliConvenio, T004K61_A1381ConveMenCliCod, T004K61_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K62_A3CliCod, T004K62_A1564CliPaiConve, T004K62_A1565CliConvenio, T004K62_A1381ConveMenCliCod, T004K62_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K63_A3CliCod, T004K63_A1564CliPaiConve, T004K63_A1565CliConvenio, T004K63_A1381ConveMenCliCod, T004K63_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K64_A3CliCod, T004K64_A1564CliPaiConve, T004K64_A1565CliConvenio, T004K64_A1381ConveMenCliCod, T004K64_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K65_A3CliCod, T004K65_A1564CliPaiConve, T004K65_A1565CliConvenio, T004K65_A1381ConveMenCliCod, T004K65_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K66_A3CliCod, T004K66_A1564CliPaiConve, T004K66_A1565CliConvenio, T004K66_A1381ConveMenCliCod, T004K66_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K67_A3CliCod, T004K67_A1564CliPaiConve, T004K67_A1565CliConvenio, T004K67_A1381ConveMenCliCod, T004K67_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K68_A3CliCod, T004K68_A1564CliPaiConve, T004K68_A1565CliConvenio, T004K68_A1381ConveMenCliCod, T004K68_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K69_A3CliCod, T004K69_A1564CliPaiConve, T004K69_A1565CliConvenio, T004K69_A1381ConveMenCliCod, T004K69_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K70_A3CliCod, T004K70_A1564CliPaiConve, T004K70_A1565CliConvenio, T004K70_A1381ConveMenCliCod, T004K70_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K71_A3CliCod, T004K71_A1564CliPaiConve, T004K71_A1565CliConvenio, T004K71_A1381ConveMenCliCod, T004K71_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K72_A3CliCod, T004K72_A1564CliPaiConve, T004K72_A1565CliConvenio, T004K72_A1381ConveMenCliCod, T004K72_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K73_A3CliCod, T004K73_A1564CliPaiConve, T004K73_A1565CliConvenio, T004K73_A1381ConveMenCliCod, T004K73_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K74_A3CliCod, T004K74_A1564CliPaiConve, T004K74_A1565CliConvenio, T004K74_A1381ConveMenCliCod, T004K74_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K75_A3CliCod, T004K75_A1564CliPaiConve, T004K75_A1565CliConvenio, T004K75_A1381ConveMenCliCod, T004K75_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K76_A3CliCod, T004K76_A1564CliPaiConve, T004K76_A1565CliConvenio, T004K76_A1381ConveMenCliCod, T004K76_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K77_A3CliCod, T004K77_A1564CliPaiConve, T004K77_A1565CliConvenio, T004K77_A1381ConveMenCliCod, T004K77_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K78_A3CliCod, T004K78_A1564CliPaiConve, T004K78_A1565CliConvenio, T004K78_A1381ConveMenCliCod, T004K78_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K79_A3CliCod, T004K79_A1564CliPaiConve, T004K79_A1565CliConvenio, T004K79_A1381ConveMenCliCod, T004K79_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K80_A3CliCod, T004K80_A1564CliPaiConve, T004K80_A1565CliConvenio, T004K80_A1381ConveMenCliCod, T004K80_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K81_A3CliCod, T004K81_A1564CliPaiConve, T004K81_A1565CliConvenio, T004K81_A1381ConveMenCliCod, T004K81_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K82_A3CliCod, T004K82_A1564CliPaiConve, T004K82_A1565CliConvenio, T004K82_A1381ConveMenCliCod, T004K82_A1375ConveMenConCodigo
            }
            , new Object[] {
            T004K83_A3CliCod, T004K83_A1564CliPaiConve, T004K83_A1565CliConvenio, T004K83_A1454ConveBaseClaseLeg, T004K83_A1455ConveBaseTipo, T004K83_A1456ConveBaseCod1, T004K83_A1457ConveBaseCod2
            }
            , new Object[] {
            T004K84_A3CliCod, T004K84_A1564CliPaiConve, T004K84_A1565CliConvenio, T004K84_A996ConveAdicod
            }
            , new Object[] {
            T004K85_A3CliCod, T004K85_A1564CliPaiConve, T004K85_A1565CliConvenio, T004K85_A8CatCodigo
            }
            , new Object[] {
            T004K86_A3CliCod, T004K86_A1564CliPaiConve, T004K86_A1565CliConvenio, T004K86_A1575CliConveVig
            }
            , new Object[] {
            T004K87_A3CliCod, T004K87_A1564CliPaiConve, T004K87_A1565CliConvenio
            }
            , new Object[] {
            T004K88_A46PaiCod, T004K88_A9ConveCodigo, T004K88_A160ConveDescri
            }
            , new Object[] {
            T004K89_A344CliNom
            }
            , new Object[] {
            T004K90_A1567CliConvenioDescrip, T004K90_A2132CliConveEscFrecAct
            }
            , new Object[] {
            T004K91_A1568CliConveVerNom
            }
         }
      );
      AV25Pgmname = "ClienteConvenios" ;
      Z1566CliConveVer = new web.primerversiondeconvenio(remoteHandle, context).executeUdp( (short)(0), "") ;
      n1566CliConveVer = false ;
      N1566CliConveVer = new web.primerversiondeconvenio(remoteHandle, context).executeUdp( (short)(0), "") ;
      n1566CliConveVer = false ;
      i1566CliConveVer = new web.primerversiondeconvenio(remoteHandle, context).executeUdp( (short)(0), "") ;
      n1566CliConveVer = false ;
      A1566CliConveVer = new web.primerversiondeconvenio(remoteHandle, context).executeUdp( (short)(0), "") ;
      n1566CliConveVer = false ;
      Z1564CliPaiConve = (short)(0) ;
      A1564CliPaiConve = (short)(0) ;
   }

   private byte GxWebError ;
   private byte Gx_BScreen ;
   private byte nKeyPressed ;
   private byte gxajaxcallmode ;
   private short wcpOAV8CliPaiConve ;
   private short Z1564CliPaiConve ;
   private short AV8CliPaiConve ;
   private short A1564CliPaiConve ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A2132CliConveEscFrecAct ;
   private short RcdFound202 ;
   private short Z2132CliConveEscFrecAct ;
   private short nIsDirty_202 ;
   private short AV21PaiCod ;
   private int wcpOAV7CliCod ;
   private int Z3CliCod ;
   private int Z1566CliConveVer ;
   private int N1566CliConveVer ;
   private int AV7CliCod ;
   private int AV15Insert_CliConveVer ;
   private int A3CliCod ;
   private int A1566CliConveVer ;
   private int trnEnded ;
   private int edtCliConveEscFrecAct_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtCliPaiConve_Visible ;
   private int edtCliPaiConve_Enabled ;
   private int edtCliConveVer_Visible ;
   private int edtCliConveVer_Enabled ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV26GXV1 ;
   private int GX_JID ;
   private int i1566CliConveVer ;
   private int idxLst ;
   private int gxdynajaxindex ;
   private int GXt_int4 ;
   private int GXv_int5[] ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV9CliConvenio ;
   private String Z1565CliConvenio ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A1565CliConvenio ;
   private String Gx_mode ;
   private String AV9CliConvenio ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String sStyleString ;
   private String tblTablemainfix_Internalname ;
   private String divTablecontent_Internalname ;
   private String Dvpanel_tableattributes_Width ;
   private String Dvpanel_tableattributes_Cls ;
   private String Dvpanel_tableattributes_Title ;
   private String Dvpanel_tableattributes_Iconposition ;
   private String Dvpanel_tableattributes_Internalname ;
   private String divTableattributes_Internalname ;
   private String TempTags ;
   private String divCliconvehab_cell_Internalname ;
   private String divCliconvehab_cell_Class ;
   private String ClassString ;
   private String StyleString ;
   private String edtCliConveEscFrecAct_Internalname ;
   private String edtCliConveEscFrecAct_Jsonclick ;
   private String divCliconveactobl_cell_Internalname ;
   private String divCliconveactobl_cell_Class ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtCliPaiConve_Internalname ;
   private String edtCliPaiConve_Jsonclick ;
   private String edtCliConveVer_Internalname ;
   private String edtCliConveVer_Jsonclick ;
   private String AV25Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode202 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String gxwrpcisep ;
   private boolean Z2130CliConveActObl ;
   private boolean Z1639CliConveHab ;
   private boolean Z2429CliConveEsquemaEs ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n1566CliConveVer ;
   private boolean wbErr ;
   private boolean A1639CliConveHab ;
   private boolean A2130CliConveActObl ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean A2429CliConveEsquemaEs ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV11IsAuthorized ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private String A344CliNom ;
   private String A1568CliConveVerNom ;
   private String A1567CliConvenioDescrip ;
   private String Z344CliNom ;
   private String Z1567CliConvenioDescrip ;
   private String Z1568CliConveVerNom ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV14WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice dynCliConvenio ;
   private ICheckbox chkCliConveHab ;
   private ICheckbox chkCliConveActObl ;
   private IDataStoreProvider pr_default ;
   private String[] T004K4_A344CliNom ;
   private String[] T004K6_A1567CliConvenioDescrip ;
   private short[] T004K6_A2132CliConveEscFrecAct ;
   private String[] T004K5_A1568CliConveVerNom ;
   private String[] T004K7_A1567CliConvenioDescrip ;
   private String[] T004K7_A1568CliConveVerNom ;
   private short[] T004K7_A2132CliConveEscFrecAct ;
   private boolean[] T004K7_A2130CliConveActObl ;
   private String[] T004K7_A344CliNom ;
   private boolean[] T004K7_A1639CliConveHab ;
   private boolean[] T004K7_A2429CliConveEsquemaEs ;
   private int[] T004K7_A3CliCod ;
   private int[] T004K7_A1566CliConveVer ;
   private boolean[] T004K7_n1566CliConveVer ;
   private short[] T004K7_A1564CliPaiConve ;
   private String[] T004K7_A1565CliConvenio ;
   private String[] T004K8_A344CliNom ;
   private String[] T004K9_A1567CliConvenioDescrip ;
   private short[] T004K9_A2132CliConveEscFrecAct ;
   private String[] T004K10_A1568CliConveVerNom ;
   private int[] T004K11_A3CliCod ;
   private short[] T004K11_A1564CliPaiConve ;
   private String[] T004K11_A1565CliConvenio ;
   private boolean[] T004K3_A2130CliConveActObl ;
   private boolean[] T004K3_A1639CliConveHab ;
   private boolean[] T004K3_A2429CliConveEsquemaEs ;
   private int[] T004K3_A3CliCod ;
   private int[] T004K3_A1566CliConveVer ;
   private boolean[] T004K3_n1566CliConveVer ;
   private short[] T004K3_A1564CliPaiConve ;
   private String[] T004K3_A1565CliConvenio ;
   private int[] T004K12_A3CliCod ;
   private short[] T004K12_A1564CliPaiConve ;
   private String[] T004K12_A1565CliConvenio ;
   private int[] T004K13_A3CliCod ;
   private short[] T004K13_A1564CliPaiConve ;
   private String[] T004K13_A1565CliConvenio ;
   private boolean[] T004K2_A2130CliConveActObl ;
   private boolean[] T004K2_A1639CliConveHab ;
   private boolean[] T004K2_A2429CliConveEsquemaEs ;
   private int[] T004K2_A3CliCod ;
   private int[] T004K2_A1566CliConveVer ;
   private boolean[] T004K2_n1566CliConveVer ;
   private short[] T004K2_A1564CliPaiConve ;
   private String[] T004K2_A1565CliConvenio ;
   private String[] T004K17_A344CliNom ;
   private String[] T004K18_A1567CliConvenioDescrip ;
   private short[] T004K18_A2132CliConveEscFrecAct ;
   private String[] T004K19_A1568CliConveVerNom ;
   private int[] T004K20_A3CliCod ;
   private short[] T004K20_A1EmpCod ;
   private int[] T004K20_A31LiqNro ;
   private short[] T004K20_A2142LiqPaiConve ;
   private String[] T004K20_A2143LiqConvenio ;
   private int[] T004K21_A3CliCod ;
   private short[] T004K21_A1EmpCod ;
   private int[] T004K21_A31LiqNro ;
   private short[] T004K21_A2142LiqPaiConve ;
   private String[] T004K21_A2143LiqConvenio ;
   private int[] T004K22_A3CliCod ;
   private short[] T004K22_A1564CliPaiConve ;
   private String[] T004K22_A1565CliConvenio ;
   private String[] T004K22_A1805ConveSitPresen ;
   private int[] T004K23_A3CliCod ;
   private short[] T004K23_A1564CliPaiConve ;
   private String[] T004K23_A1565CliConvenio ;
   private java.util.Date[] T004K23_A1587CliConveImpVig ;
   private String[] T004K23_A1588CliConveImpTipo ;
   private int[] T004K24_A3CliCod ;
   private short[] T004K24_A1564CliPaiConve ;
   private String[] T004K24_A1565CliConvenio ;
   private String[] T004K24_A1294PaiTipoTraId ;
   private int[] T004K25_A3CliCod ;
   private short[] T004K25_A1564CliPaiConve ;
   private String[] T004K25_A1565CliConvenio ;
   private String[] T004K25_A37TipoConCod ;
   private String[] T004K25_A1377ConvePromFijVar ;
   private int[] T004K26_A3CliCod ;
   private short[] T004K26_A1564CliPaiConve ;
   private String[] T004K26_A1565CliConvenio ;
   private short[] T004K26_A1327ConveHsExSec ;
   private int[] T004K27_A3CliCod ;
   private short[] T004K27_A1564CliPaiConve ;
   private String[] T004K27_A1565CliConvenio ;
   private int[] T004K27_A1381ConveMenCliCod ;
   private String[] T004K27_A1375ConveMenConCodigo ;
   private int[] T004K28_A3CliCod ;
   private short[] T004K28_A1564CliPaiConve ;
   private String[] T004K28_A1565CliConvenio ;
   private int[] T004K28_A1381ConveMenCliCod ;
   private String[] T004K28_A1375ConveMenConCodigo ;
   private int[] T004K29_A3CliCod ;
   private short[] T004K29_A1564CliPaiConve ;
   private String[] T004K29_A1565CliConvenio ;
   private int[] T004K29_A1381ConveMenCliCod ;
   private String[] T004K29_A1375ConveMenConCodigo ;
   private int[] T004K30_A3CliCod ;
   private short[] T004K30_A1564CliPaiConve ;
   private String[] T004K30_A1565CliConvenio ;
   private int[] T004K30_A1381ConveMenCliCod ;
   private String[] T004K30_A1375ConveMenConCodigo ;
   private int[] T004K31_A3CliCod ;
   private short[] T004K31_A1564CliPaiConve ;
   private String[] T004K31_A1565CliConvenio ;
   private int[] T004K31_A1381ConveMenCliCod ;
   private String[] T004K31_A1375ConveMenConCodigo ;
   private int[] T004K32_A3CliCod ;
   private short[] T004K32_A1564CliPaiConve ;
   private String[] T004K32_A1565CliConvenio ;
   private int[] T004K32_A1381ConveMenCliCod ;
   private String[] T004K32_A1375ConveMenConCodigo ;
   private int[] T004K33_A3CliCod ;
   private short[] T004K33_A1564CliPaiConve ;
   private String[] T004K33_A1565CliConvenio ;
   private int[] T004K33_A1381ConveMenCliCod ;
   private String[] T004K33_A1375ConveMenConCodigo ;
   private int[] T004K34_A3CliCod ;
   private short[] T004K34_A1564CliPaiConve ;
   private String[] T004K34_A1565CliConvenio ;
   private int[] T004K34_A1381ConveMenCliCod ;
   private String[] T004K34_A1375ConveMenConCodigo ;
   private int[] T004K35_A3CliCod ;
   private short[] T004K35_A1564CliPaiConve ;
   private String[] T004K35_A1565CliConvenio ;
   private int[] T004K35_A1381ConveMenCliCod ;
   private String[] T004K35_A1375ConveMenConCodigo ;
   private int[] T004K36_A3CliCod ;
   private short[] T004K36_A1564CliPaiConve ;
   private String[] T004K36_A1565CliConvenio ;
   private int[] T004K36_A1381ConveMenCliCod ;
   private String[] T004K36_A1375ConveMenConCodigo ;
   private int[] T004K37_A3CliCod ;
   private short[] T004K37_A1564CliPaiConve ;
   private String[] T004K37_A1565CliConvenio ;
   private int[] T004K37_A1381ConveMenCliCod ;
   private String[] T004K37_A1375ConveMenConCodigo ;
   private int[] T004K38_A3CliCod ;
   private short[] T004K38_A1564CliPaiConve ;
   private String[] T004K38_A1565CliConvenio ;
   private int[] T004K38_A1381ConveMenCliCod ;
   private String[] T004K38_A1375ConveMenConCodigo ;
   private int[] T004K39_A3CliCod ;
   private short[] T004K39_A1564CliPaiConve ;
   private String[] T004K39_A1565CliConvenio ;
   private int[] T004K39_A1381ConveMenCliCod ;
   private String[] T004K39_A1375ConveMenConCodigo ;
   private int[] T004K40_A3CliCod ;
   private short[] T004K40_A1564CliPaiConve ;
   private String[] T004K40_A1565CliConvenio ;
   private int[] T004K40_A1381ConveMenCliCod ;
   private String[] T004K40_A1375ConveMenConCodigo ;
   private int[] T004K41_A3CliCod ;
   private short[] T004K41_A1564CliPaiConve ;
   private String[] T004K41_A1565CliConvenio ;
   private int[] T004K41_A1381ConveMenCliCod ;
   private String[] T004K41_A1375ConveMenConCodigo ;
   private int[] T004K42_A3CliCod ;
   private short[] T004K42_A1564CliPaiConve ;
   private String[] T004K42_A1565CliConvenio ;
   private int[] T004K42_A1381ConveMenCliCod ;
   private String[] T004K42_A1375ConveMenConCodigo ;
   private int[] T004K43_A3CliCod ;
   private short[] T004K43_A1564CliPaiConve ;
   private String[] T004K43_A1565CliConvenio ;
   private int[] T004K43_A1381ConveMenCliCod ;
   private String[] T004K43_A1375ConveMenConCodigo ;
   private int[] T004K44_A3CliCod ;
   private short[] T004K44_A1564CliPaiConve ;
   private String[] T004K44_A1565CliConvenio ;
   private int[] T004K44_A1381ConveMenCliCod ;
   private String[] T004K44_A1375ConveMenConCodigo ;
   private int[] T004K45_A3CliCod ;
   private short[] T004K45_A1564CliPaiConve ;
   private String[] T004K45_A1565CliConvenio ;
   private int[] T004K45_A1381ConveMenCliCod ;
   private String[] T004K45_A1375ConveMenConCodigo ;
   private int[] T004K46_A3CliCod ;
   private short[] T004K46_A1564CliPaiConve ;
   private String[] T004K46_A1565CliConvenio ;
   private int[] T004K46_A1381ConveMenCliCod ;
   private String[] T004K46_A1375ConveMenConCodigo ;
   private int[] T004K47_A3CliCod ;
   private short[] T004K47_A1564CliPaiConve ;
   private String[] T004K47_A1565CliConvenio ;
   private int[] T004K47_A1381ConveMenCliCod ;
   private String[] T004K47_A1375ConveMenConCodigo ;
   private int[] T004K48_A3CliCod ;
   private short[] T004K48_A1564CliPaiConve ;
   private String[] T004K48_A1565CliConvenio ;
   private int[] T004K48_A1381ConveMenCliCod ;
   private String[] T004K48_A1375ConveMenConCodigo ;
   private int[] T004K49_A3CliCod ;
   private short[] T004K49_A1564CliPaiConve ;
   private String[] T004K49_A1565CliConvenio ;
   private int[] T004K49_A1381ConveMenCliCod ;
   private String[] T004K49_A1375ConveMenConCodigo ;
   private int[] T004K50_A3CliCod ;
   private short[] T004K50_A1564CliPaiConve ;
   private String[] T004K50_A1565CliConvenio ;
   private int[] T004K50_A1381ConveMenCliCod ;
   private String[] T004K50_A1375ConveMenConCodigo ;
   private int[] T004K51_A3CliCod ;
   private short[] T004K51_A1564CliPaiConve ;
   private String[] T004K51_A1565CliConvenio ;
   private int[] T004K51_A1381ConveMenCliCod ;
   private String[] T004K51_A1375ConveMenConCodigo ;
   private int[] T004K52_A3CliCod ;
   private short[] T004K52_A1564CliPaiConve ;
   private String[] T004K52_A1565CliConvenio ;
   private int[] T004K52_A1381ConveMenCliCod ;
   private String[] T004K52_A1375ConveMenConCodigo ;
   private int[] T004K53_A3CliCod ;
   private short[] T004K53_A1564CliPaiConve ;
   private String[] T004K53_A1565CliConvenio ;
   private int[] T004K53_A1381ConveMenCliCod ;
   private String[] T004K53_A1375ConveMenConCodigo ;
   private int[] T004K54_A3CliCod ;
   private short[] T004K54_A1564CliPaiConve ;
   private String[] T004K54_A1565CliConvenio ;
   private int[] T004K54_A1381ConveMenCliCod ;
   private String[] T004K54_A1375ConveMenConCodigo ;
   private int[] T004K55_A3CliCod ;
   private short[] T004K55_A1564CliPaiConve ;
   private String[] T004K55_A1565CliConvenio ;
   private int[] T004K55_A1381ConveMenCliCod ;
   private String[] T004K55_A1375ConveMenConCodigo ;
   private int[] T004K56_A3CliCod ;
   private short[] T004K56_A1564CliPaiConve ;
   private String[] T004K56_A1565CliConvenio ;
   private int[] T004K56_A1381ConveMenCliCod ;
   private String[] T004K56_A1375ConveMenConCodigo ;
   private int[] T004K57_A3CliCod ;
   private short[] T004K57_A1564CliPaiConve ;
   private String[] T004K57_A1565CliConvenio ;
   private int[] T004K57_A1381ConveMenCliCod ;
   private String[] T004K57_A1375ConveMenConCodigo ;
   private int[] T004K58_A3CliCod ;
   private short[] T004K58_A1564CliPaiConve ;
   private String[] T004K58_A1565CliConvenio ;
   private int[] T004K58_A1381ConveMenCliCod ;
   private String[] T004K58_A1375ConveMenConCodigo ;
   private int[] T004K59_A3CliCod ;
   private short[] T004K59_A1564CliPaiConve ;
   private String[] T004K59_A1565CliConvenio ;
   private int[] T004K59_A1381ConveMenCliCod ;
   private String[] T004K59_A1375ConveMenConCodigo ;
   private int[] T004K60_A3CliCod ;
   private short[] T004K60_A1564CliPaiConve ;
   private String[] T004K60_A1565CliConvenio ;
   private int[] T004K60_A1381ConveMenCliCod ;
   private String[] T004K60_A1375ConveMenConCodigo ;
   private int[] T004K61_A3CliCod ;
   private short[] T004K61_A1564CliPaiConve ;
   private String[] T004K61_A1565CliConvenio ;
   private int[] T004K61_A1381ConveMenCliCod ;
   private String[] T004K61_A1375ConveMenConCodigo ;
   private int[] T004K62_A3CliCod ;
   private short[] T004K62_A1564CliPaiConve ;
   private String[] T004K62_A1565CliConvenio ;
   private int[] T004K62_A1381ConveMenCliCod ;
   private String[] T004K62_A1375ConveMenConCodigo ;
   private int[] T004K63_A3CliCod ;
   private short[] T004K63_A1564CliPaiConve ;
   private String[] T004K63_A1565CliConvenio ;
   private int[] T004K63_A1381ConveMenCliCod ;
   private String[] T004K63_A1375ConveMenConCodigo ;
   private int[] T004K64_A3CliCod ;
   private short[] T004K64_A1564CliPaiConve ;
   private String[] T004K64_A1565CliConvenio ;
   private int[] T004K64_A1381ConveMenCliCod ;
   private String[] T004K64_A1375ConveMenConCodigo ;
   private int[] T004K65_A3CliCod ;
   private short[] T004K65_A1564CliPaiConve ;
   private String[] T004K65_A1565CliConvenio ;
   private int[] T004K65_A1381ConveMenCliCod ;
   private String[] T004K65_A1375ConveMenConCodigo ;
   private int[] T004K66_A3CliCod ;
   private short[] T004K66_A1564CliPaiConve ;
   private String[] T004K66_A1565CliConvenio ;
   private int[] T004K66_A1381ConveMenCliCod ;
   private String[] T004K66_A1375ConveMenConCodigo ;
   private int[] T004K67_A3CliCod ;
   private short[] T004K67_A1564CliPaiConve ;
   private String[] T004K67_A1565CliConvenio ;
   private int[] T004K67_A1381ConveMenCliCod ;
   private String[] T004K67_A1375ConveMenConCodigo ;
   private int[] T004K68_A3CliCod ;
   private short[] T004K68_A1564CliPaiConve ;
   private String[] T004K68_A1565CliConvenio ;
   private int[] T004K68_A1381ConveMenCliCod ;
   private String[] T004K68_A1375ConveMenConCodigo ;
   private int[] T004K69_A3CliCod ;
   private short[] T004K69_A1564CliPaiConve ;
   private String[] T004K69_A1565CliConvenio ;
   private int[] T004K69_A1381ConveMenCliCod ;
   private String[] T004K69_A1375ConveMenConCodigo ;
   private int[] T004K70_A3CliCod ;
   private short[] T004K70_A1564CliPaiConve ;
   private String[] T004K70_A1565CliConvenio ;
   private int[] T004K70_A1381ConveMenCliCod ;
   private String[] T004K70_A1375ConveMenConCodigo ;
   private int[] T004K71_A3CliCod ;
   private short[] T004K71_A1564CliPaiConve ;
   private String[] T004K71_A1565CliConvenio ;
   private int[] T004K71_A1381ConveMenCliCod ;
   private String[] T004K71_A1375ConveMenConCodigo ;
   private int[] T004K72_A3CliCod ;
   private short[] T004K72_A1564CliPaiConve ;
   private String[] T004K72_A1565CliConvenio ;
   private int[] T004K72_A1381ConveMenCliCod ;
   private String[] T004K72_A1375ConveMenConCodigo ;
   private int[] T004K73_A3CliCod ;
   private short[] T004K73_A1564CliPaiConve ;
   private String[] T004K73_A1565CliConvenio ;
   private int[] T004K73_A1381ConveMenCliCod ;
   private String[] T004K73_A1375ConveMenConCodigo ;
   private int[] T004K74_A3CliCod ;
   private short[] T004K74_A1564CliPaiConve ;
   private String[] T004K74_A1565CliConvenio ;
   private int[] T004K74_A1381ConveMenCliCod ;
   private String[] T004K74_A1375ConveMenConCodigo ;
   private int[] T004K75_A3CliCod ;
   private short[] T004K75_A1564CliPaiConve ;
   private String[] T004K75_A1565CliConvenio ;
   private int[] T004K75_A1381ConveMenCliCod ;
   private String[] T004K75_A1375ConveMenConCodigo ;
   private int[] T004K76_A3CliCod ;
   private short[] T004K76_A1564CliPaiConve ;
   private String[] T004K76_A1565CliConvenio ;
   private int[] T004K76_A1381ConveMenCliCod ;
   private String[] T004K76_A1375ConveMenConCodigo ;
   private int[] T004K77_A3CliCod ;
   private short[] T004K77_A1564CliPaiConve ;
   private String[] T004K77_A1565CliConvenio ;
   private int[] T004K77_A1381ConveMenCliCod ;
   private String[] T004K77_A1375ConveMenConCodigo ;
   private int[] T004K78_A3CliCod ;
   private short[] T004K78_A1564CliPaiConve ;
   private String[] T004K78_A1565CliConvenio ;
   private int[] T004K78_A1381ConveMenCliCod ;
   private String[] T004K78_A1375ConveMenConCodigo ;
   private int[] T004K79_A3CliCod ;
   private short[] T004K79_A1564CliPaiConve ;
   private String[] T004K79_A1565CliConvenio ;
   private int[] T004K79_A1381ConveMenCliCod ;
   private String[] T004K79_A1375ConveMenConCodigo ;
   private int[] T004K80_A3CliCod ;
   private short[] T004K80_A1564CliPaiConve ;
   private String[] T004K80_A1565CliConvenio ;
   private int[] T004K80_A1381ConveMenCliCod ;
   private String[] T004K80_A1375ConveMenConCodigo ;
   private int[] T004K81_A3CliCod ;
   private short[] T004K81_A1564CliPaiConve ;
   private String[] T004K81_A1565CliConvenio ;
   private int[] T004K81_A1381ConveMenCliCod ;
   private String[] T004K81_A1375ConveMenConCodigo ;
   private int[] T004K82_A3CliCod ;
   private short[] T004K82_A1564CliPaiConve ;
   private String[] T004K82_A1565CliConvenio ;
   private int[] T004K82_A1381ConveMenCliCod ;
   private String[] T004K82_A1375ConveMenConCodigo ;
   private int[] T004K83_A3CliCod ;
   private short[] T004K83_A1564CliPaiConve ;
   private String[] T004K83_A1565CliConvenio ;
   private byte[] T004K83_A1454ConveBaseClaseLeg ;
   private String[] T004K83_A1455ConveBaseTipo ;
   private String[] T004K83_A1456ConveBaseCod1 ;
   private String[] T004K83_A1457ConveBaseCod2 ;
   private int[] T004K84_A3CliCod ;
   private short[] T004K84_A1564CliPaiConve ;
   private String[] T004K84_A1565CliConvenio ;
   private String[] T004K84_A996ConveAdicod ;
   private int[] T004K85_A3CliCod ;
   private short[] T004K85_A1564CliPaiConve ;
   private String[] T004K85_A1565CliConvenio ;
   private String[] T004K85_A8CatCodigo ;
   private int[] T004K86_A3CliCod ;
   private short[] T004K86_A1564CliPaiConve ;
   private String[] T004K86_A1565CliConvenio ;
   private java.util.Date[] T004K86_A1575CliConveVig ;
   private int[] T004K87_A3CliCod ;
   private short[] T004K87_A1564CliPaiConve ;
   private String[] T004K87_A1565CliConvenio ;
   private short[] T004K88_A46PaiCod ;
   private String[] T004K88_A9ConveCodigo ;
   private String[] T004K88_A160ConveDescri ;
   private String[] T004K89_A344CliNom ;
   private String[] T004K90_A1567CliConvenioDescrip ;
   private short[] T004K90_A2132CliConveEscFrecAct ;
   private String[] T004K91_A1568CliConveVerNom ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV10WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV13TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV16TrnContextAtt ;
}

final  class clienteconvenios__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T004K2", "SELECT CliConveActObl, CliConveHab, CliConveEsquemaEs, CliCod, CliConveVer, CliPaiConve, CliConvenio FROM ClienteConvenios WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  FOR UPDATE OF ClienteConvenios NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004K3", "SELECT CliConveActObl, CliConveHab, CliConveEsquemaEs, CliCod, CliConveVer, CliPaiConve, CliConvenio FROM ClienteConvenios WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004K4", "SELECT CliNom FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004K5", "SELECT CliNom AS CliConveVerNom FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004K6", "SELECT ConveDescri AS CliConvenioDescrip, ConveEscFrecAct AS CliConveEscFrecAct FROM Convenio WHERE PaiCod = ? AND ConveCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004K7", "SELECT T3.ConveDescri AS CliConvenioDescrip, T4.CliNom AS CliConveVerNom, T3.ConveEscFrecAct AS CliConveEscFrecAct, TM1.CliConveActObl, T2.CliNom, TM1.CliConveHab, TM1.CliConveEsquemaEs, TM1.CliCod, TM1.CliConveVer AS CliConveVer, TM1.CliPaiConve AS CliPaiConve, TM1.CliConvenio AS CliConvenio FROM (((ClienteConvenios TM1 INNER JOIN Cliente T2 ON T2.CliCod = TM1.CliCod) INNER JOIN Convenio T3 ON T3.PaiCod = TM1.CliPaiConve AND T3.ConveCodigo = TM1.CliConvenio) LEFT JOIN Cliente T4 ON T4.CliCod = TM1.CliConveVer) WHERE TM1.CliCod = ? and TM1.CliPaiConve = ? and TM1.CliConvenio = ( ?) ORDER BY TM1.CliCod, TM1.CliPaiConve, TM1.CliConvenio ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004K8", "SELECT CliNom FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004K9", "SELECT ConveDescri AS CliConvenioDescrip, ConveEscFrecAct AS CliConveEscFrecAct FROM Convenio WHERE PaiCod = ? AND ConveCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004K10", "SELECT CliNom AS CliConveVerNom FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004K11", "SELECT CliCod, CliPaiConve, CliConvenio FROM ClienteConvenios WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004K12", "SELECT CliCod, CliPaiConve, CliConvenio FROM ClienteConvenios WHERE ( CliCod > ? or CliCod = ? and CliPaiConve > ? or CliPaiConve = ? and CliCod = ? and CliConvenio > ( ?)) ORDER BY CliCod, CliPaiConve, CliConvenio  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K13", "SELECT CliCod, CliPaiConve, CliConvenio FROM ClienteConvenios WHERE ( CliCod < ? or CliCod = ? and CliPaiConve < ? or CliPaiConve = ? and CliCod = ? and CliConvenio < ( ?)) ORDER BY CliCod DESC, CliPaiConve DESC, CliConvenio DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T004K14", "SAVEPOINT gxupdate;INSERT INTO ClienteConvenios(CliConveActObl, CliConveHab, CliConveEsquemaEs, CliCod, CliConveVer, CliPaiConve, CliConvenio) VALUES(?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T004K15", "SAVEPOINT gxupdate;UPDATE ClienteConvenios SET CliConveActObl=?, CliConveHab=?, CliConveEsquemaEs=?, CliConveVer=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T004K16", "SAVEPOINT gxupdate;DELETE FROM ClienteConvenios  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T004K17", "SELECT CliNom FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004K18", "SELECT ConveDescri AS CliConvenioDescrip, ConveEscFrecAct AS CliConveEscFrecAct FROM Convenio WHERE PaiCod = ? AND ConveCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004K19", "SELECT CliNom AS CliConveVerNom FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004K20", "SELECT CliCod, EmpCod, LiqNro, LiqPaiConve, LiqConvenio FROM LiquidacionConvenio WHERE CliCod = ? AND LiqPaiConve = ? AND LiqConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K21", "SELECT CliCod, EmpCod, LiqNro, LiqPaiConve, LiqConvenio FROM LiquidacionConvenio WHERE CliCod = ? AND LiqPaiConve = ? AND LiqConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K22", "SELECT CliCod, CliPaiConve, CliConvenio, ConveSitPresen FROM convenio_estados_no_presen WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K23", "SELECT CliCod, CliPaiConve, CliConvenio, CliConveImpVig, CliConveImpTipo FROM clienteConvenio_importes WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K24", "SELECT CliCod, CliPaiConve, CliConvenio, PaiTipoTraId FROM convenio_tiposdetrabajo WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K25", "SELECT CliCod, CliPaiConve, CliConvenio, TipoConCod, ConvePromFijVar FROM Convenio_promedio_horanormal_mensualizad WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K26", "SELECT CliCod, CliPaiConve, CliConvenio, ConveHsExSec FROM Convenio_horasextras_porDia WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K27", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE ConveMenCliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K28", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K29", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K30", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K31", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K32", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K33", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K34", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K35", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K36", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K37", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K38", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K39", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K40", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K41", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K42", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K43", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K44", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K45", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K46", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K47", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K48", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K49", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K50", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K51", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K52", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K53", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K54", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K55", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K56", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K57", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K58", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K59", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K60", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K61", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K62", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K63", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K64", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K65", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K66", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K67", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K68", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K69", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K70", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K71", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K72", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K73", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K74", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K75", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K76", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K77", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K78", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K79", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K80", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K81", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K82", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K83", "SELECT CliCod, CliPaiConve, CliConvenio, ConveBaseClaseLeg, ConveBaseTipo, ConveBaseCod1, ConveBaseCod2 FROM Convenio_base_calculo WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K84", "SELECT CliCod, CliPaiConve, CliConvenio, ConveAdicod FROM convenio_adicional WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K85", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo FROM Categoria1 WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K86", "SELECT CliCod, CliPaiConve, CliConvenio, CliConveVig FROM ClienteConvenio_Particularidades WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004K87", "SELECT CliCod, CliPaiConve, CliConvenio FROM ClienteConvenios ORDER BY CliCod, CliPaiConve, CliConvenio ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004K88", "SELECT PaiCod, ConveCodigo, ConveDescri FROM Convenio WHERE PaiCod = ? ORDER BY ConveDescri ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004K89", "SELECT CliNom FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004K90", "SELECT ConveDescri AS CliConvenioDescrip, ConveEscFrecAct AS CliConveEscFrecAct FROM Convenio WHERE PaiCod = ? AND ConveCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004K91", "SELECT CliNom AS CliConveVerNom FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((short[]) buf[6])[0] = rslt.getShort(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               return;
            case 1 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((short[]) buf[6])[0] = rslt.getShort(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((int[]) buf[8])[0] = rslt.getInt(9);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((short[]) buf[10])[0] = rslt.getShort(10);
               ((String[]) buf[11])[0] = rslt.getString(11, 20);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 15 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 16 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 17 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 18 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 19 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 20 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 4);
               return;
            case 21 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 22 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 23 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 24 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 25 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 26 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 27 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 28 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 29 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
      }
      getresults30( cursor, rslt, buf) ;
   }

   public void getresults30( int cursor ,
                             IFieldGetter rslt ,
                             Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 31 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 32 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 33 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 34 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 35 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 36 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 37 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 38 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 39 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 40 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 41 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 42 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 43 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 44 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 45 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 46 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 47 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 48 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 49 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 50 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 51 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 52 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 53 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 54 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 55 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 56 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 57 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 58 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 59 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
      }
      getresults60( cursor, rslt, buf) ;
   }

   public void getresults60( int cursor ,
                             IFieldGetter rslt ,
                             Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 60 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 61 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 62 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 63 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 64 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 65 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 66 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 67 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 68 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 69 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 70 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 71 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 72 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 73 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 74 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 75 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 76 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 77 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 78 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 79 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 80 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 81 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               return;
            case 82 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 83 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               return;
            case 84 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               return;
            case 85 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 86 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 87 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 88 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 89 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
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
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 3 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 8 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 20);
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 20);
               return;
            case 12 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setBoolean(2, ((Boolean) parms[1]).booleanValue());
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(5, ((Number) parms[5]).intValue());
               }
               stmt.setShort(6, ((Number) parms[6]).shortValue());
               stmt.setString(7, (String)parms[7], 20);
               return;
            case 13 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setBoolean(2, ((Boolean) parms[1]).booleanValue());
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(4, ((Number) parms[4]).intValue());
               }
               stmt.setInt(5, ((Number) parms[5]).intValue());
               stmt.setShort(6, ((Number) parms[6]).shortValue());
               stmt.setString(7, (String)parms[7], 20);
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 16 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 17 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 19 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 20 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 21 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 22 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 23 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 24 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 25 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 26 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 27 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 28 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 29 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
      setparameters30( cursor, stmt, parms) ;
   }

   public void setparameters30( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 31 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 32 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 33 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 34 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 35 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 36 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 37 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 38 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 39 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 40 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 41 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 42 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 43 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 44 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 45 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 46 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 47 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 48 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 49 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 50 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 51 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 52 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 53 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 54 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 55 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 56 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 57 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 58 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 59 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
      setparameters60( cursor, stmt, parms) ;
   }

   public void setparameters60( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 60 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 61 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 62 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 63 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 64 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 65 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 66 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 67 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 68 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 69 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 70 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 71 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 72 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 73 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 74 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 75 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 76 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 77 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 78 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 79 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 80 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 81 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 82 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 83 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 84 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 86 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 87 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 88 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 89 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
      }
   }

}

