package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class tipoliquidacion_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel1"+"_"+"CLICOD") == 0 )
      {
         AV11CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx1asaclicod1E47( AV11CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_13") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_13( A3CliCod) ;
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel1") == 0 )
      {
         gxnrgridlevel1_newrow_invoke( ) ;
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
      if ( ! entryPointCalled && ! ( isAjaxCallMode( ) || isFullAjaxMode( ) ) )
      {
         Gx_mode = gxfirstwebparm ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
         {
            AV11CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11CliCod), 6, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11CliCod), "ZZZZZ9")));
            AV7TLiqCod = httpContext.GetPar( "TLiqCod") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7TLiqCod", AV7TLiqCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTLIQCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV7TLiqCod, ""))));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Tipo Liquidacion", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtTLiqCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrgridlevel1_newrow_invoke( )
   {
      nRC_GXsfl_45 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_45"))) ;
      nGXsfl_45_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_45_idx"))) ;
      sGXsfl_45_idx = httpContext.GetPar( "sGXsfl_45_idx") ;
      Gx_mode = httpContext.GetPar( "Mode") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel1_newrow( ) ;
      /* End function gxnrGridlevel1_newrow_invoke */
   }

   public tipoliquidacion_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public tipoliquidacion_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( tipoliquidacion_impl.class ));
   }

   public tipoliquidacion_impl( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkTLiqAcuDiasTrab = UIFactory.getCheckbox(this);
      chkTliqSAC = UIFactory.getCheckbox(this);
      cmbTLiqModTra = new HTMLChoice();
      cmbTLiqFrecPag = new HTMLChoice();
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
      A1076TLiqAcuDiasTrab = GXutil.strtobool( GXutil.booltostr( A1076TLiqAcuDiasTrab)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1076TLiqAcuDiasTrab", A1076TLiqAcuDiasTrab);
      A1211TliqSAC = GXutil.strtobool( GXutil.booltostr( A1211TliqSAC)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1211TliqSAC", A1211TliqSAC);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTLiqCod_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtTLiqCod_Internalname, httpContext.getMessage( "Código", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtTLiqCod_Internalname, GXutil.rtrim( A32TLiqCod), GXutil.rtrim( localUtil.format( A32TLiqCod, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTLiqCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtTLiqCod_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CodigoCaracter", "left", true, "", "HLP_TipoLiquidacion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTliqDesc_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtTliqDesc_Internalname, httpContext.getMessage( "Descripcion", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtTliqDesc_Internalname, A340TliqDesc, GXutil.rtrim( localUtil.format( A340TliqDesc, "@!")), TempTags+" onchange=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTliqDesc_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtTliqDesc_Enabled, 0, "text", "", 30, "chr", 1, "row", 30, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionMedia", "left", true, "", "HLP_TipoLiquidacion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkTLiqAcuDiasTrab.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkTLiqAcuDiasTrab.getInternalname(), httpContext.getMessage( "Acumular días trabajados para LSD", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkTLiqAcuDiasTrab.getInternalname(), GXutil.booltostr( A1076TLiqAcuDiasTrab), "", httpContext.getMessage( "Acumular días trabajados para LSD", ""), 1, chkTLiqAcuDiasTrab.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(32, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,32);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkTliqSAC.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkTliqSAC.getInternalname(), httpContext.getMessage( "Liquida SAC", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkTliqSAC.getInternalname(), GXutil.booltostr( A1211TliqSAC), "", httpContext.getMessage( "Liquida SAC", ""), 1, chkTliqSAC.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(37, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,37);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTLiqCodFor_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtTLiqCodFor_Internalname, httpContext.getMessage( "Código de parámetro en fórmulas", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtTLiqCodFor_Internalname, GXutil.rtrim( A2091TLiqCodFor), GXutil.rtrim( localUtil.format( A2091TLiqCodFor, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,42);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTLiqCodFor_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtTLiqCodFor_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "palabra", "left", true, "", "HLP_TipoLiquidacion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /*  Grid Control  */
      startgridcontrol45( ) ;
      nGXsfl_45_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount300 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_300 = (short)(1) ;
            scanStart1E300( ) ;
            while ( RcdFound300 != 0 )
            {
               init_level_properties300( ) ;
               getByPrimaryKey1E300( ) ;
               addRow1E300( ) ;
               scanNext1E300( ) ;
            }
            scanEnd1E300( ) ;
            nBlankRcdCount300 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         standaloneNotModal1E300( ) ;
         standaloneModal1E300( ) ;
         sMode300 = Gx_mode ;
         while ( nGXsfl_45_idx < nRC_GXsfl_45 )
         {
            bGXsfl_45_Refreshing = true ;
            readRow1E300( ) ;
            cmbTLiqModTra.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "TLIQMODTRA_"+sGXsfl_45_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
            httpContext.ajax_rsp_assign_prop("", false, cmbTLiqModTra.getInternalname(), "Enabled", GXutil.ltrimstr( cmbTLiqModTra.getEnabled(), 5, 0), !bGXsfl_45_Refreshing);
            cmbTLiqFrecPag.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "TLIQFRECPAG_"+sGXsfl_45_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
            httpContext.ajax_rsp_assign_prop("", false, cmbTLiqFrecPag.getInternalname(), "Enabled", GXutil.ltrimstr( cmbTLiqFrecPag.getEnabled(), 5, 0), !bGXsfl_45_Refreshing);
            edtTLiqDescAuxFrec_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "TLIQDESCAUXFREC_"+sGXsfl_45_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtTLiqDescAuxFrec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTLiqDescAuxFrec_Enabled), 5, 0), !bGXsfl_45_Refreshing);
            if ( ( nRcdExists_300 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal1E300( ) ;
            }
            sendRow1E300( ) ;
            bGXsfl_45_Refreshing = false ;
         }
         Gx_mode = sMode300 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount300 = (short)(5) ;
         nRcdExists_300 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart1E300( ) ;
            while ( RcdFound300 != 0 )
            {
               sGXsfl_45_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_45_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_45300( ) ;
               init_level_properties300( ) ;
               standaloneNotModal1E300( ) ;
               getByPrimaryKey1E300( ) ;
               standaloneModal1E300( ) ;
               addRow1E300( ) ;
               scanNext1E300( ) ;
            }
            scanEnd1E300( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode300 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_45_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_45_idx+1), 4, 0), (short)(4), "0") ;
         subsflControlProps_45300( ) ;
         initAll1E300( ) ;
         init_level_properties300( ) ;
         nRcdExists_300 = (short)(0) ;
         nIsMod_300 = (short)(0) ;
         nRcdDeleted_300 = (short)(0) ;
         nBlankRcdCount300 = (short)(nBlankRcdUsr300+nBlankRcdCount300) ;
         fRowAdded = 0 ;
         while ( nBlankRcdCount300 > 0 )
         {
            standaloneNotModal1E300( ) ;
            standaloneModal1E300( ) ;
            addRow1E300( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = cmbTLiqModTra.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount300 = (short)(nBlankRcdCount300-1) ;
         }
         Gx_mode = sMode300 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridlevel1Container"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridlevel1", Gridlevel1Container, subGridlevel1_Internalname);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel1ContainerData", Gridlevel1Container.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel1ContainerData"+"V", Gridlevel1Container.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel1ContainerData"+"V"+"\" value='"+Gridlevel1Container.GridValuesHidden()+"'/>") ;
      }
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 56,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_TipoLiquidacion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 58,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_TipoLiquidacion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 60,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_TipoLiquidacion.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,64);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_TipoLiquidacion.htm");
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
      e111E2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z32TLiqCod = httpContext.cgiGet( "Z32TLiqCod") ;
            Z340TliqDesc = httpContext.cgiGet( "Z340TliqDesc") ;
            Z341TLiqHabilitada = GXutil.strtobool( httpContext.cgiGet( "Z341TLiqHabilitada")) ;
            Z1076TLiqAcuDiasTrab = GXutil.strtobool( httpContext.cgiGet( "Z1076TLiqAcuDiasTrab")) ;
            Z1211TliqSAC = GXutil.strtobool( httpContext.cgiGet( "Z1211TliqSAC")) ;
            Z1817TLiqOrd = (short)(localUtil.ctol( httpContext.cgiGet( "Z1817TLiqOrd"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2091TLiqCodFor = httpContext.cgiGet( "Z2091TLiqCodFor") ;
            A341TLiqHabilitada = GXutil.strtobool( httpContext.cgiGet( "Z341TLiqHabilitada")) ;
            A1817TLiqOrd = (short)(localUtil.ctol( httpContext.cgiGet( "Z1817TLiqOrd"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            nRC_GXsfl_45 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_45"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV11CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV7TLiqCod = httpContext.cgiGet( "vTLIQCOD") ;
            Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A341TLiqHabilitada = GXutil.strtobool( httpContext.cgiGet( "TLIQHABILITADA")) ;
            A1817TLiqOrd = (short)(localUtil.ctol( httpContext.cgiGet( "TLIQORD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV20Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            A32TLiqCod = httpContext.cgiGet( edtTLiqCod_Internalname) ;
            n32TLiqCod = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A32TLiqCod", A32TLiqCod);
            A340TliqDesc = GXutil.upper( httpContext.cgiGet( edtTliqDesc_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A340TliqDesc", A340TliqDesc);
            A1076TLiqAcuDiasTrab = GXutil.strtobool( httpContext.cgiGet( chkTLiqAcuDiasTrab.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1076TLiqAcuDiasTrab", A1076TLiqAcuDiasTrab);
            A1211TliqSAC = GXutil.strtobool( httpContext.cgiGet( chkTliqSAC.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1211TliqSAC", A1211TliqSAC);
            A2091TLiqCodFor = httpContext.cgiGet( edtTLiqCodFor_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2091TLiqCodFor", A2091TLiqCodFor);
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
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"TipoLiquidacion");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("TLiqHabilitada", GXutil.booltostr( A341TLiqHabilitada));
            forbiddenHiddens.add("TLiqOrd", localUtil.format( DecimalUtil.doubleToDec(A1817TLiqOrd), "ZZZ9"));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A32TLiqCod, Z32TLiqCod) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("tipoliquidacion:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
            /* Check if conditions changed and reset current page numbers */
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
               A32TLiqCod = httpContext.GetPar( "TLiqCod") ;
               n32TLiqCod = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A32TLiqCod", A32TLiqCod);
               getEqualNoModal( ) ;
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               disable_std_buttons( ) ;
               standaloneModal( ) ;
            }
            else
            {
               if ( isDsp( ) )
               {
                  sMode47 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode47 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound47 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_1E0( ) ;
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
                        e111E2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e121E2 ();
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
                     sEvtType = GXutil.right( sEvt, 4) ;
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
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
         e121E2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll1E47( ) ;
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
         disableAttributes1E47( ) ;
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

   public void confirm_1E0( )
   {
      beforeValidate1E47( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1E47( ) ;
         }
         else
         {
            checkExtendedTable1E47( ) ;
            closeExtendedTableCursors1E47( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode47 = Gx_mode ;
         confirm_1E300( ) ;
         if ( AnyError == 0 )
         {
            /* Restore parent mode. */
            Gx_mode = sMode47 ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            IsConfirmed = (short)(1) ;
            httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
         }
         /* Restore parent mode. */
         Gx_mode = sMode47 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
   }

   public void confirm_1E300( )
   {
      nGXsfl_45_idx = 0 ;
      while ( nGXsfl_45_idx < nRC_GXsfl_45 )
      {
         readRow1E300( ) ;
         if ( ( nRcdExists_300 != 0 ) || ( nIsMod_300 != 0 ) )
         {
            getKey1E300( ) ;
            if ( ( nRcdExists_300 == 0 ) && ( nRcdDeleted_300 == 0 ) )
            {
               if ( RcdFound300 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate1E300( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable1E300( ) ;
                     closeExtendedTableCursors1E300( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "TLIQMODTRA_" + sGXsfl_45_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = cmbTLiqModTra.getInternalname() ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound300 != 0 )
               {
                  if ( nRcdDeleted_300 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey1E300( ) ;
                     load1E300( ) ;
                     beforeValidate1E300( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls1E300( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_300 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate1E300( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable1E300( ) ;
                           closeExtendedTableCursors1E300( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                              httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                           }
                        }
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_300 == 0 )
                  {
                     GXCCtl = "TLIQMODTRA_" + sGXsfl_45_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = cmbTLiqModTra.getInternalname() ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( cmbTLiqModTra.getInternalname(), GXutil.rtrim( A2408TLiqModTra)) ;
         httpContext.changePostValue( cmbTLiqFrecPag.getInternalname(), GXutil.ltrim( localUtil.ntoc( A2412TLiqFrecPag, (byte)(1), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( edtTLiqDescAuxFrec_Internalname, A2413TLiqDescAuxFrec) ;
         httpContext.changePostValue( "ZT_"+"Z2408TLiqModTra_"+sGXsfl_45_idx, GXutil.rtrim( Z2408TLiqModTra)) ;
         httpContext.changePostValue( "ZT_"+"Z2412TLiqFrecPag_"+sGXsfl_45_idx, GXutil.ltrim( localUtil.ntoc( Z2412TLiqFrecPag, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2413TLiqDescAuxFrec_"+sGXsfl_45_idx, Z2413TLiqDescAuxFrec) ;
         httpContext.changePostValue( "nRcdDeleted_300_"+sGXsfl_45_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_300, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_300_"+sGXsfl_45_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_300, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_300_"+sGXsfl_45_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_300, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_300 != 0 )
         {
            httpContext.changePostValue( "TLIQMODTRA_"+sGXsfl_45_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( cmbTLiqModTra.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "TLIQFRECPAG_"+sGXsfl_45_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( cmbTLiqFrecPag.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "TLIQDESCAUXFREC_"+sGXsfl_45_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtTLiqDescAuxFrec_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void resetCaption1E0( )
   {
   }

   public void e111E2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0] ;
      AV13IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWTipoLiquidacion_Insert", GXv_boolean3) ;
         tipoliquidacion_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWTipoLiquidacion_Update", GXv_boolean3) ;
         tipoliquidacion_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWTipoLiquidacion_Delete", GXv_boolean3) ;
         tipoliquidacion_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( ! AV13IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV20Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV9TrnContext.fromxml(AV10WebSession.getValue("TrnContext"), null, null);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
   }

   public void e121E2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(4);
      pr_default.close(3);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm1E47( int GX_JID )
   {
      if ( ( GX_JID == 12 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z340TliqDesc = T001E5_A340TliqDesc[0] ;
            Z341TLiqHabilitada = T001E5_A341TLiqHabilitada[0] ;
            Z1076TLiqAcuDiasTrab = T001E5_A1076TLiqAcuDiasTrab[0] ;
            Z1211TliqSAC = T001E5_A1211TliqSAC[0] ;
            Z1817TLiqOrd = T001E5_A1817TLiqOrd[0] ;
            Z2091TLiqCodFor = T001E5_A2091TLiqCodFor[0] ;
         }
         else
         {
            Z340TliqDesc = A340TliqDesc ;
            Z341TLiqHabilitada = A341TLiqHabilitada ;
            Z1076TLiqAcuDiasTrab = A1076TLiqAcuDiasTrab ;
            Z1211TliqSAC = A1211TliqSAC ;
            Z1817TLiqOrd = A1817TLiqOrd ;
            Z2091TLiqCodFor = A2091TLiqCodFor ;
         }
      }
      if ( GX_JID == -12 )
      {
         Z32TLiqCod = A32TLiqCod ;
         Z340TliqDesc = A340TliqDesc ;
         Z341TLiqHabilitada = A341TLiqHabilitada ;
         Z1076TLiqAcuDiasTrab = A1076TLiqAcuDiasTrab ;
         Z1211TliqSAC = A1211TliqSAC ;
         Z1817TLiqOrd = A1817TLiqOrd ;
         Z2091TLiqCodFor = A2091TLiqCodFor ;
         Z3CliCod = A3CliCod ;
      }
   }

   public void standaloneNotModal( )
   {
      Gx_BScreen = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV11CliCod) )
      {
         A3CliCod = AV11CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int4 = A3CliCod ;
            GXv_int5[0] = GXt_int4 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
            tipoliquidacion_impl.this.GXt_int4 = GXv_int5[0] ;
            A3CliCod = GXt_int4 ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         }
      }
      if ( ! (0==AV11CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      else
      {
         edtCliCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV11CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV7TLiqCod)==0) )
      {
         A32TLiqCod = AV7TLiqCod ;
         n32TLiqCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A32TLiqCod", A32TLiqCod);
      }
      if ( ! (GXutil.strcmp("", AV7TLiqCod)==0) )
      {
         edtTLiqCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtTLiqCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTLiqCod_Enabled), 5, 0), true);
      }
      else
      {
         edtTLiqCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtTLiqCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTLiqCod_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV7TLiqCod)==0) )
      {
         edtTLiqCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtTLiqCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTLiqCod_Enabled), 5, 0), true);
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
      if ( isIns( )  && (false==A341TLiqHabilitada) && ( Gx_BScreen == 0 ) )
      {
         A341TLiqHabilitada = true ;
         httpContext.ajax_rsp_assign_attri("", false, "A341TLiqHabilitada", A341TLiqHabilitada);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV20Pgmname = "TipoLiquidacion" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20Pgmname", AV20Pgmname);
      }
   }

   public void load1E47( )
   {
      /* Using cursor T001E7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound47 = (short)(1) ;
         A340TliqDesc = T001E7_A340TliqDesc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A340TliqDesc", A340TliqDesc);
         A341TLiqHabilitada = T001E7_A341TLiqHabilitada[0] ;
         A1076TLiqAcuDiasTrab = T001E7_A1076TLiqAcuDiasTrab[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1076TLiqAcuDiasTrab", A1076TLiqAcuDiasTrab);
         A1211TliqSAC = T001E7_A1211TliqSAC[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1211TliqSAC", A1211TliqSAC);
         A1817TLiqOrd = T001E7_A1817TLiqOrd[0] ;
         A2091TLiqCodFor = T001E7_A2091TLiqCodFor[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2091TLiqCodFor", A2091TLiqCodFor);
         zm1E47( -12) ;
      }
      pr_default.close(5);
      onLoadActions1E47( ) ;
   }

   public void onLoadActions1E47( )
   {
      AV20Pgmname = "TipoLiquidacion" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20Pgmname", AV20Pgmname);
   }

   public void checkExtendedTable1E47( )
   {
      nIsDirty_47 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      AV20Pgmname = "TipoLiquidacion" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20Pgmname", AV20Pgmname);
      /* Using cursor T001E6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(4);
      if ( (GXutil.strcmp("", A32TLiqCod)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Tipo de Liquidación", ""), "", "", "", "", "", "", "", ""), 1, "TLIQCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTLiqCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (GXutil.strcmp("", A340TliqDesc)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Descripcion", ""), "", "", "", "", "", "", "", ""), 1, "TLIQDESC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTliqDesc_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors1E47( )
   {
      pr_default.close(4);
   }

   public void enableDisable( )
   {
   }

   public void gxload_13( int A3CliCod )
   {
      /* Using cursor T001E8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void getKey1E47( )
   {
      /* Using cursor T001E9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound47 = (short)(1) ;
      }
      else
      {
         RcdFound47 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T001E5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod});
      if ( (pr_default.getStatus(3) != 101) )
      {
         zm1E47( 12) ;
         RcdFound47 = (short)(1) ;
         A32TLiqCod = T001E5_A32TLiqCod[0] ;
         n32TLiqCod = T001E5_n32TLiqCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A32TLiqCod", A32TLiqCod);
         A340TliqDesc = T001E5_A340TliqDesc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A340TliqDesc", A340TliqDesc);
         A341TLiqHabilitada = T001E5_A341TLiqHabilitada[0] ;
         A1076TLiqAcuDiasTrab = T001E5_A1076TLiqAcuDiasTrab[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1076TLiqAcuDiasTrab", A1076TLiqAcuDiasTrab);
         A1211TliqSAC = T001E5_A1211TliqSAC[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1211TliqSAC", A1211TliqSAC);
         A1817TLiqOrd = T001E5_A1817TLiqOrd[0] ;
         A2091TLiqCodFor = T001E5_A2091TLiqCodFor[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2091TLiqCodFor", A2091TLiqCodFor);
         A3CliCod = T001E5_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         Z3CliCod = A3CliCod ;
         Z32TLiqCod = A32TLiqCod ;
         sMode47 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load1E47( ) ;
         if ( AnyError == 1 )
         {
            RcdFound47 = (short)(0) ;
            initializeNonKey1E47( ) ;
         }
         Gx_mode = sMode47 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound47 = (short)(0) ;
         initializeNonKey1E47( ) ;
         sMode47 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode47 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(3);
   }

   public void getEqualNoModal( )
   {
      getKey1E47( ) ;
      if ( RcdFound47 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound47 = (short)(0) ;
      /* Using cursor T001E10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T001E10_A3CliCod[0] < A3CliCod ) || ( T001E10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T001E10_A32TLiqCod[0], A32TLiqCod) < 0 ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T001E10_A3CliCod[0] > A3CliCod ) || ( T001E10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T001E10_A32TLiqCod[0], A32TLiqCod) > 0 ) ) )
         {
            A3CliCod = T001E10_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A32TLiqCod = T001E10_A32TLiqCod[0] ;
            n32TLiqCod = T001E10_n32TLiqCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A32TLiqCod", A32TLiqCod);
            RcdFound47 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound47 = (short)(0) ;
      /* Using cursor T001E11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T001E11_A3CliCod[0] > A3CliCod ) || ( T001E11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T001E11_A32TLiqCod[0], A32TLiqCod) > 0 ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T001E11_A3CliCod[0] < A3CliCod ) || ( T001E11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T001E11_A32TLiqCod[0], A32TLiqCod) < 0 ) ) )
         {
            A3CliCod = T001E11_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A32TLiqCod = T001E11_A32TLiqCod[0] ;
            n32TLiqCod = T001E11_n32TLiqCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A32TLiqCod", A32TLiqCod);
            RcdFound47 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1E47( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtTLiqCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert1E47( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound47 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A32TLiqCod, Z32TLiqCod) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A32TLiqCod = Z32TLiqCod ;
               n32TLiqCod = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A32TLiqCod", A32TLiqCod);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtTLiqCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update1E47( ) ;
               GX_FocusControl = edtTLiqCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A32TLiqCod, Z32TLiqCod) != 0 ) )
            {
               /* Insert record */
               GX_FocusControl = edtTLiqCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert1E47( ) ;
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
                  GX_FocusControl = edtTLiqCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert1E47( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A32TLiqCod, Z32TLiqCod) != 0 ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A32TLiqCod = Z32TLiqCod ;
         n32TLiqCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A32TLiqCod", A32TLiqCod);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtTLiqCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency1E47( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T001E4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod});
         if ( (pr_default.getStatus(2) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"TipoLiquidacion"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(2) == 101) || ( GXutil.strcmp(Z340TliqDesc, T001E4_A340TliqDesc[0]) != 0 ) || ( Z341TLiqHabilitada != T001E4_A341TLiqHabilitada[0] ) || ( Z1076TLiqAcuDiasTrab != T001E4_A1076TLiqAcuDiasTrab[0] ) || ( Z1211TliqSAC != T001E4_A1211TliqSAC[0] ) || ( Z1817TLiqOrd != T001E4_A1817TLiqOrd[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z2091TLiqCodFor, T001E4_A2091TLiqCodFor[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z340TliqDesc, T001E4_A340TliqDesc[0]) != 0 )
            {
               GXutil.writeLogln("tipoliquidacion:[seudo value changed for attri]"+"TliqDesc");
               GXutil.writeLogRaw("Old: ",Z340TliqDesc);
               GXutil.writeLogRaw("Current: ",T001E4_A340TliqDesc[0]);
            }
            if ( Z341TLiqHabilitada != T001E4_A341TLiqHabilitada[0] )
            {
               GXutil.writeLogln("tipoliquidacion:[seudo value changed for attri]"+"TLiqHabilitada");
               GXutil.writeLogRaw("Old: ",Z341TLiqHabilitada);
               GXutil.writeLogRaw("Current: ",T001E4_A341TLiqHabilitada[0]);
            }
            if ( Z1076TLiqAcuDiasTrab != T001E4_A1076TLiqAcuDiasTrab[0] )
            {
               GXutil.writeLogln("tipoliquidacion:[seudo value changed for attri]"+"TLiqAcuDiasTrab");
               GXutil.writeLogRaw("Old: ",Z1076TLiqAcuDiasTrab);
               GXutil.writeLogRaw("Current: ",T001E4_A1076TLiqAcuDiasTrab[0]);
            }
            if ( Z1211TliqSAC != T001E4_A1211TliqSAC[0] )
            {
               GXutil.writeLogln("tipoliquidacion:[seudo value changed for attri]"+"TliqSAC");
               GXutil.writeLogRaw("Old: ",Z1211TliqSAC);
               GXutil.writeLogRaw("Current: ",T001E4_A1211TliqSAC[0]);
            }
            if ( Z1817TLiqOrd != T001E4_A1817TLiqOrd[0] )
            {
               GXutil.writeLogln("tipoliquidacion:[seudo value changed for attri]"+"TLiqOrd");
               GXutil.writeLogRaw("Old: ",Z1817TLiqOrd);
               GXutil.writeLogRaw("Current: ",T001E4_A1817TLiqOrd[0]);
            }
            if ( GXutil.strcmp(Z2091TLiqCodFor, T001E4_A2091TLiqCodFor[0]) != 0 )
            {
               GXutil.writeLogln("tipoliquidacion:[seudo value changed for attri]"+"TLiqCodFor");
               GXutil.writeLogRaw("Old: ",Z2091TLiqCodFor);
               GXutil.writeLogRaw("Current: ",T001E4_A2091TLiqCodFor[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"TipoLiquidacion"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1E47( )
   {
      beforeValidate1E47( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1E47( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1E47( 0) ;
         checkOptimisticConcurrency1E47( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1E47( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1E47( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001E12 */
                  pr_default.execute(10, new Object[] {Boolean.valueOf(n32TLiqCod), A32TLiqCod, A340TliqDesc, Boolean.valueOf(A341TLiqHabilitada), Boolean.valueOf(A1076TLiqAcuDiasTrab), Boolean.valueOf(A1211TliqSAC), Short.valueOf(A1817TLiqOrd), A2091TLiqCodFor, Integer.valueOf(A3CliCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoLiquidacion");
                  if ( (pr_default.getStatus(10) == 1) )
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
                        processLevel1E47( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                           resetCaption1E0( ) ;
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
         else
         {
            load1E47( ) ;
         }
         endLevel1E47( ) ;
      }
      closeExtendedTableCursors1E47( ) ;
   }

   public void update1E47( )
   {
      beforeValidate1E47( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1E47( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1E47( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1E47( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1E47( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001E13 */
                  pr_default.execute(11, new Object[] {A340TliqDesc, Boolean.valueOf(A341TLiqHabilitada), Boolean.valueOf(A1076TLiqAcuDiasTrab), Boolean.valueOf(A1211TliqSAC), Short.valueOf(A1817TLiqOrd), A2091TLiqCodFor, Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoLiquidacion");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"TipoLiquidacion"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1E47( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel1E47( ) ;
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
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel1E47( ) ;
      }
      closeExtendedTableCursors1E47( ) ;
   }

   public void deferredUpdate1E47( )
   {
   }

   public void delete( )
   {
      beforeValidate1E47( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1E47( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1E47( ) ;
         afterConfirm1E47( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1E47( ) ;
            if ( AnyError == 0 )
            {
               scanStart1E300( ) ;
               while ( RcdFound300 != 0 )
               {
                  getByPrimaryKey1E300( ) ;
                  delete1E300( ) ;
                  scanNext1E300( ) ;
               }
               scanEnd1E300( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001E14 */
                  pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoLiquidacion");
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
      }
      sMode47 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1E47( ) ;
      Gx_mode = sMode47 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1E47( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV20Pgmname = "TipoLiquidacion" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20Pgmname", AV20Pgmname);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T001E15 */
         pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod});
         if ( (pr_default.getStatus(13) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LegPreliqCab", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
         /* Using cursor T001E16 */
         pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod});
         if ( (pr_default.getStatus(14) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liquidacion", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(14);
         /* Using cursor T001E17 */
         pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod});
         if ( (pr_default.getStatus(15) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Tipo Liquidacion", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(15);
      }
   }

   public void processNestedLevel1E300( )
   {
      nGXsfl_45_idx = 0 ;
      while ( nGXsfl_45_idx < nRC_GXsfl_45 )
      {
         readRow1E300( ) ;
         if ( ( nRcdExists_300 != 0 ) || ( nIsMod_300 != 0 ) )
         {
            standaloneNotModal1E300( ) ;
            getKey1E300( ) ;
            if ( ( nRcdExists_300 == 0 ) && ( nRcdDeleted_300 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert1E300( ) ;
            }
            else
            {
               if ( RcdFound300 != 0 )
               {
                  if ( ( nRcdDeleted_300 != 0 ) && ( nRcdExists_300 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete1E300( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_300 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update1E300( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_300 == 0 )
                  {
                     GXCCtl = "TLIQMODTRA_" + sGXsfl_45_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = cmbTLiqModTra.getInternalname() ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( cmbTLiqModTra.getInternalname(), GXutil.rtrim( A2408TLiqModTra)) ;
         httpContext.changePostValue( cmbTLiqFrecPag.getInternalname(), GXutil.ltrim( localUtil.ntoc( A2412TLiqFrecPag, (byte)(1), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( edtTLiqDescAuxFrec_Internalname, A2413TLiqDescAuxFrec) ;
         httpContext.changePostValue( "ZT_"+"Z2408TLiqModTra_"+sGXsfl_45_idx, GXutil.rtrim( Z2408TLiqModTra)) ;
         httpContext.changePostValue( "ZT_"+"Z2412TLiqFrecPag_"+sGXsfl_45_idx, GXutil.ltrim( localUtil.ntoc( Z2412TLiqFrecPag, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2413TLiqDescAuxFrec_"+sGXsfl_45_idx, Z2413TLiqDescAuxFrec) ;
         httpContext.changePostValue( "nRcdDeleted_300_"+sGXsfl_45_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_300, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_300_"+sGXsfl_45_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_300, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_300_"+sGXsfl_45_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_300, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_300 != 0 )
         {
            httpContext.changePostValue( "TLIQMODTRA_"+sGXsfl_45_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( cmbTLiqModTra.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "TLIQFRECPAG_"+sGXsfl_45_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( cmbTLiqFrecPag.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "TLIQDESCAUXFREC_"+sGXsfl_45_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtTLiqDescAuxFrec_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll1E300( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_300 = (short)(0) ;
      nIsMod_300 = (short)(0) ;
      nRcdDeleted_300 = (short)(0) ;
   }

   public void processLevel1E47( )
   {
      /* Save parent mode. */
      sMode47 = Gx_mode ;
      processNestedLevel1E300( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode47 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
   }

   public void endLevel1E47( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(2);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1E47( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "tipoliquidacion");
         if ( AnyError == 0 )
         {
            confirmValues1E0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "tipoliquidacion");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart1E47( )
   {
      /* Scan By routine */
      /* Using cursor T001E18 */
      pr_default.execute(16);
      RcdFound47 = (short)(0) ;
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound47 = (short)(1) ;
         A3CliCod = T001E18_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A32TLiqCod = T001E18_A32TLiqCod[0] ;
         n32TLiqCod = T001E18_n32TLiqCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A32TLiqCod", A32TLiqCod);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1E47( )
   {
      /* Scan next routine */
      pr_default.readNext(16);
      RcdFound47 = (short)(0) ;
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound47 = (short)(1) ;
         A3CliCod = T001E18_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A32TLiqCod = T001E18_A32TLiqCod[0] ;
         n32TLiqCod = T001E18_n32TLiqCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A32TLiqCod", A32TLiqCod);
      }
   }

   public void scanEnd1E47( )
   {
      pr_default.close(16);
   }

   public void afterConfirm1E47( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1E47( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1E47( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1E47( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1E47( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1E47( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1E47( )
   {
      edtTLiqCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTLiqCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTLiqCod_Enabled), 5, 0), true);
      edtTliqDesc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTliqDesc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTliqDesc_Enabled), 5, 0), true);
      chkTLiqAcuDiasTrab.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkTLiqAcuDiasTrab.getInternalname(), "Enabled", GXutil.ltrimstr( chkTLiqAcuDiasTrab.getEnabled(), 5, 0), true);
      chkTliqSAC.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkTliqSAC.getInternalname(), "Enabled", GXutil.ltrimstr( chkTliqSAC.getEnabled(), 5, 0), true);
      edtTLiqCodFor_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTLiqCodFor_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTLiqCodFor_Enabled), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
   }

   public void zm1E300( int GX_JID )
   {
      if ( ( GX_JID == 14 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z2413TLiqDescAuxFrec = T001E3_A2413TLiqDescAuxFrec[0] ;
         }
         else
         {
            Z2413TLiqDescAuxFrec = A2413TLiqDescAuxFrec ;
         }
      }
      if ( GX_JID == -14 )
      {
         Z3CliCod = A3CliCod ;
         Z32TLiqCod = A32TLiqCod ;
         Z2408TLiqModTra = A2408TLiqModTra ;
         Z2412TLiqFrecPag = A2412TLiqFrecPag ;
         Z2413TLiqDescAuxFrec = A2413TLiqDescAuxFrec ;
      }
   }

   public void standaloneNotModal1E300( )
   {
   }

   public void standaloneModal1E300( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         cmbTLiqModTra.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbTLiqModTra.getInternalname(), "Enabled", GXutil.ltrimstr( cmbTLiqModTra.getEnabled(), 5, 0), !bGXsfl_45_Refreshing);
      }
      else
      {
         cmbTLiqModTra.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbTLiqModTra.getInternalname(), "Enabled", GXutil.ltrimstr( cmbTLiqModTra.getEnabled(), 5, 0), !bGXsfl_45_Refreshing);
      }
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         cmbTLiqFrecPag.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbTLiqFrecPag.getInternalname(), "Enabled", GXutil.ltrimstr( cmbTLiqFrecPag.getEnabled(), 5, 0), !bGXsfl_45_Refreshing);
      }
      else
      {
         cmbTLiqFrecPag.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbTLiqFrecPag.getInternalname(), "Enabled", GXutil.ltrimstr( cmbTLiqFrecPag.getEnabled(), 5, 0), !bGXsfl_45_Refreshing);
      }
   }

   public void load1E300( )
   {
      /* Using cursor T001E19 */
      pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod, A2408TLiqModTra, Byte.valueOf(A2412TLiqFrecPag)});
      if ( (pr_default.getStatus(17) != 101) )
      {
         RcdFound300 = (short)(1) ;
         A2413TLiqDescAuxFrec = T001E19_A2413TLiqDescAuxFrec[0] ;
         zm1E300( -14) ;
      }
      pr_default.close(17);
      onLoadActions1E300( ) ;
   }

   public void onLoadActions1E300( )
   {
   }

   public void checkExtendedTable1E300( )
   {
      nIsDirty_300 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal1E300( ) ;
      if ( ! ( ( GXutil.strcmp(A2408TLiqModTra, "E") == 0 ) || ( GXutil.strcmp(A2408TLiqModTra, "I") == 0 ) ) )
      {
         GXCCtl = "TLIQMODTRA_" + sGXsfl_45_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Modo de trabajo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = cmbTLiqModTra.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( A2412TLiqFrecPag == 1 ) || ( A2412TLiqFrecPag == 2 ) || ( A2412TLiqFrecPag == 3 ) || ( A2412TLiqFrecPag == 4 ) ) )
      {
         GXCCtl = "TLIQFRECPAG_" + sGXsfl_45_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Frecuencia de pago", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = cmbTLiqFrecPag.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors1E300( )
   {
   }

   public void enableDisable1E300( )
   {
   }

   public void getKey1E300( )
   {
      /* Using cursor T001E20 */
      pr_default.execute(18, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod, A2408TLiqModTra, Byte.valueOf(A2412TLiqFrecPag)});
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound300 = (short)(1) ;
      }
      else
      {
         RcdFound300 = (short)(0) ;
      }
      pr_default.close(18);
   }

   public void getByPrimaryKey1E300( )
   {
      /* Using cursor T001E3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod, A2408TLiqModTra, Byte.valueOf(A2412TLiqFrecPag)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm1E300( 14) ;
         RcdFound300 = (short)(1) ;
         initializeNonKey1E300( ) ;
         A2408TLiqModTra = T001E3_A2408TLiqModTra[0] ;
         A2412TLiqFrecPag = T001E3_A2412TLiqFrecPag[0] ;
         A2413TLiqDescAuxFrec = T001E3_A2413TLiqDescAuxFrec[0] ;
         Z3CliCod = A3CliCod ;
         Z32TLiqCod = A32TLiqCod ;
         Z2408TLiqModTra = A2408TLiqModTra ;
         Z2412TLiqFrecPag = A2412TLiqFrecPag ;
         sMode300 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load1E300( ) ;
         Gx_mode = sMode300 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound300 = (short)(0) ;
         initializeNonKey1E300( ) ;
         sMode300 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal1E300( ) ;
         Gx_mode = sMode300 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes1E300( ) ;
      }
      pr_default.close(1);
   }

   public void checkOptimisticConcurrency1E300( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T001E2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod, A2408TLiqModTra, Byte.valueOf(A2412TLiqFrecPag)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"TipoLiquidacionmodo_frec"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z2413TLiqDescAuxFrec, T001E2_A2413TLiqDescAuxFrec[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z2413TLiqDescAuxFrec, T001E2_A2413TLiqDescAuxFrec[0]) != 0 )
            {
               GXutil.writeLogln("tipoliquidacion:[seudo value changed for attri]"+"TLiqDescAuxFrec");
               GXutil.writeLogRaw("Old: ",Z2413TLiqDescAuxFrec);
               GXutil.writeLogRaw("Current: ",T001E2_A2413TLiqDescAuxFrec[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"TipoLiquidacionmodo_frec"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1E300( )
   {
      beforeValidate1E300( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1E300( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1E300( 0) ;
         checkOptimisticConcurrency1E300( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1E300( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1E300( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001E21 */
                  pr_default.execute(19, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod, A2408TLiqModTra, Byte.valueOf(A2412TLiqFrecPag), A2413TLiqDescAuxFrec});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoLiquidacionmodo_frec");
                  if ( (pr_default.getStatus(19) == 1) )
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
            load1E300( ) ;
         }
         endLevel1E300( ) ;
      }
      closeExtendedTableCursors1E300( ) ;
   }

   public void update1E300( )
   {
      beforeValidate1E300( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1E300( ) ;
      }
      if ( ( nIsMod_300 != 0 ) || ( nIsDirty_300 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency1E300( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm1E300( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate1E300( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T001E22 */
                     pr_default.execute(20, new Object[] {A2413TLiqDescAuxFrec, Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod, A2408TLiqModTra, Byte.valueOf(A2412TLiqFrecPag)});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoLiquidacionmodo_frec");
                     if ( (pr_default.getStatus(20) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"TipoLiquidacionmodo_frec"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate1E300( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey1E300( ) ;
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
            endLevel1E300( ) ;
         }
      }
      closeExtendedTableCursors1E300( ) ;
   }

   public void deferredUpdate1E300( )
   {
   }

   public void delete1E300( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate1E300( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1E300( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1E300( ) ;
         afterConfirm1E300( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1E300( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T001E23 */
               pr_default.execute(21, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod, A2408TLiqModTra, Byte.valueOf(A2412TLiqFrecPag)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoLiquidacionmodo_frec");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode300 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1E300( ) ;
      Gx_mode = sMode300 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1E300( )
   {
      standaloneModal1E300( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel1E300( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart1E300( )
   {
      /* Scan By routine */
      /* Using cursor T001E24 */
      pr_default.execute(22, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod});
      RcdFound300 = (short)(0) ;
      if ( (pr_default.getStatus(22) != 101) )
      {
         RcdFound300 = (short)(1) ;
         A2408TLiqModTra = T001E24_A2408TLiqModTra[0] ;
         A2412TLiqFrecPag = T001E24_A2412TLiqFrecPag[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1E300( )
   {
      /* Scan next routine */
      pr_default.readNext(22);
      RcdFound300 = (short)(0) ;
      if ( (pr_default.getStatus(22) != 101) )
      {
         RcdFound300 = (short)(1) ;
         A2408TLiqModTra = T001E24_A2408TLiqModTra[0] ;
         A2412TLiqFrecPag = T001E24_A2412TLiqFrecPag[0] ;
      }
   }

   public void scanEnd1E300( )
   {
      pr_default.close(22);
   }

   public void afterConfirm1E300( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1E300( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1E300( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1E300( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1E300( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1E300( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1E300( )
   {
      cmbTLiqModTra.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbTLiqModTra.getInternalname(), "Enabled", GXutil.ltrimstr( cmbTLiqModTra.getEnabled(), 5, 0), !bGXsfl_45_Refreshing);
      cmbTLiqFrecPag.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbTLiqFrecPag.getInternalname(), "Enabled", GXutil.ltrimstr( cmbTLiqFrecPag.getEnabled(), 5, 0), !bGXsfl_45_Refreshing);
      edtTLiqDescAuxFrec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTLiqDescAuxFrec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTLiqDescAuxFrec_Enabled), 5, 0), !bGXsfl_45_Refreshing);
   }

   public void send_integrity_lvl_hashes1E300( )
   {
   }

   public void send_integrity_lvl_hashes1E47( )
   {
   }

   public void subsflControlProps_45300( )
   {
      cmbTLiqModTra.setInternalname( "TLIQMODTRA_"+sGXsfl_45_idx );
      cmbTLiqFrecPag.setInternalname( "TLIQFRECPAG_"+sGXsfl_45_idx );
      edtTLiqDescAuxFrec_Internalname = "TLIQDESCAUXFREC_"+sGXsfl_45_idx ;
   }

   public void subsflControlProps_fel_45300( )
   {
      cmbTLiqModTra.setInternalname( "TLIQMODTRA_"+sGXsfl_45_fel_idx );
      cmbTLiqFrecPag.setInternalname( "TLIQFRECPAG_"+sGXsfl_45_fel_idx );
      edtTLiqDescAuxFrec_Internalname = "TLIQDESCAUXFREC_"+sGXsfl_45_fel_idx ;
   }

   public void addRow1E300( )
   {
      nGXsfl_45_idx = (int)(nGXsfl_45_idx+1) ;
      sGXsfl_45_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_45_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_45300( ) ;
      sendRow1E300( ) ;
   }

   public void sendRow1E300( )
   {
      Gridlevel1Row = GXWebRow.GetNew(context) ;
      if ( subGridlevel1_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridlevel1_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridlevel1_Class, "") != 0 )
         {
            subGridlevel1_Linesclass = subGridlevel1_Class+"Odd" ;
         }
      }
      else if ( subGridlevel1_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridlevel1_Backstyle = (byte)(0) ;
         subGridlevel1_Backcolor = subGridlevel1_Allbackcolor ;
         if ( GXutil.strcmp(subGridlevel1_Class, "") != 0 )
         {
            subGridlevel1_Linesclass = subGridlevel1_Class+"Uniform" ;
         }
      }
      else if ( subGridlevel1_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridlevel1_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridlevel1_Class, "") != 0 )
         {
            subGridlevel1_Linesclass = subGridlevel1_Class+"Odd" ;
         }
         subGridlevel1_Backcolor = (int)(0x0) ;
      }
      else if ( subGridlevel1_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridlevel1_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_45_idx) % (2))) == 0 )
         {
            subGridlevel1_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel1_Class, "") != 0 )
            {
               subGridlevel1_Linesclass = subGridlevel1_Class+"Even" ;
            }
         }
         else
         {
            subGridlevel1_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel1_Class, "") != 0 )
            {
               subGridlevel1_Linesclass = subGridlevel1_Class+"Odd" ;
            }
         }
      }
      /* Subfile cell */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_300_" + sGXsfl_45_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 46,'',false,'" + sGXsfl_45_idx + "',45)\"" ;
      GXCCtl = "TLIQMODTRA_" + sGXsfl_45_idx ;
      cmbTLiqModTra.setName( GXCCtl );
      cmbTLiqModTra.setWebtags( "" );
      cmbTLiqModTra.addItem("E", httpContext.getMessage( "Empleado", ""), (short)(0));
      cmbTLiqModTra.addItem("I", httpContext.getMessage( "Independiente", ""), (short)(0));
      if ( cmbTLiqModTra.getItemCount() > 0 )
      {
         A2408TLiqModTra = cmbTLiqModTra.getValidValue(A2408TLiqModTra) ;
      }
      /* ComboBox */
      Gridlevel1Row.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbTLiqModTra,cmbTLiqModTra.getInternalname(),GXutil.rtrim( A2408TLiqModTra),Integer.valueOf(1),cmbTLiqModTra.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(cmbTLiqModTra.getEnabled()),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","TrnColumn","",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,46);\"","",Boolean.valueOf(true),Integer.valueOf(0)});
      cmbTLiqModTra.setValue( GXutil.rtrim( A2408TLiqModTra) );
      httpContext.ajax_rsp_assign_prop("", false, cmbTLiqModTra.getInternalname(), "Values", cmbTLiqModTra.ToJavascriptSource(), !bGXsfl_45_Refreshing);
      /* Subfile cell */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_300_" + sGXsfl_45_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 47,'',false,'" + sGXsfl_45_idx + "',45)\"" ;
      GXCCtl = "TLIQFRECPAG_" + sGXsfl_45_idx ;
      cmbTLiqFrecPag.setName( GXCCtl );
      cmbTLiqFrecPag.setWebtags( "" );
      cmbTLiqFrecPag.addItem("1", httpContext.getMessage( "Mensual", ""), (short)(0));
      cmbTLiqFrecPag.addItem("2", httpContext.getMessage( "Quincenal", ""), (short)(0));
      cmbTLiqFrecPag.addItem("3", httpContext.getMessage( "Semanal", ""), (short)(0));
      cmbTLiqFrecPag.addItem("4", httpContext.getMessage( "Diaria", ""), (short)(0));
      if ( cmbTLiqFrecPag.getItemCount() > 0 )
      {
         A2412TLiqFrecPag = (byte)(GXutil.lval( cmbTLiqFrecPag.getValidValue(GXutil.trim( GXutil.str( A2412TLiqFrecPag, 1, 0))))) ;
      }
      /* ComboBox */
      Gridlevel1Row.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbTLiqFrecPag,cmbTLiqFrecPag.getInternalname(),GXutil.trim( GXutil.str( A2412TLiqFrecPag, 1, 0)),Integer.valueOf(1),cmbTLiqFrecPag.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(-1),Integer.valueOf(cmbTLiqFrecPag.getEnabled()),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","TrnColumn","",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,47);\"","",Boolean.valueOf(true),Integer.valueOf(0)});
      cmbTLiqFrecPag.setValue( GXutil.trim( GXutil.str( A2412TLiqFrecPag, 1, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbTLiqFrecPag.getInternalname(), "Values", cmbTLiqFrecPag.ToJavascriptSource(), !bGXsfl_45_Refreshing);
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_300_" + sGXsfl_45_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 48,'',false,'" + sGXsfl_45_idx + "',45)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtTLiqDescAuxFrec_Internalname,A2413TLiqDescAuxFrec,GXutil.rtrim( localUtil.format( A2413TLiqDescAuxFrec, "@!")),TempTags+" onchange=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onblur(this,48);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtTLiqDescAuxFrec_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtTLiqDescAuxFrec_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(30),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(45),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionMedia","left",Boolean.valueOf(true),""});
      httpContext.ajax_sending_grid_row(Gridlevel1Row);
      send_integrity_lvl_hashes1E300( ) ;
      GXCCtl = "Z2408TLiqModTra_" + sGXsfl_45_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Z2408TLiqModTra));
      GXCCtl = "Z2412TLiqFrecPag_" + sGXsfl_45_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z2412TLiqFrecPag, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z2413TLiqDescAuxFrec_" + sGXsfl_45_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, Z2413TLiqDescAuxFrec);
      GXCCtl = "nRcdDeleted_300_" + sGXsfl_45_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_300, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdExists_300_" + sGXsfl_45_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_300, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nIsMod_300_" + sGXsfl_45_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_300, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vMODE_" + sGXsfl_45_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Gx_mode));
      GXCCtl = "vCLICOD_" + sGXsfl_45_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV11CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vTLIQCOD_" + sGXsfl_45_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( AV7TLiqCod));
      web.GxWebStd.gx_hidden_field( httpContext, "TLIQMODTRA_"+sGXsfl_45_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( cmbTLiqModTra.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "TLIQFRECPAG_"+sGXsfl_45_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( cmbTLiqFrecPag.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "TLIQDESCAUXFREC_"+sGXsfl_45_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtTLiqDescAuxFrec_Enabled, (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridlevel1Container.AddRow(Gridlevel1Row);
   }

   public void readRow1E300( )
   {
      nGXsfl_45_idx = (int)(nGXsfl_45_idx+1) ;
      sGXsfl_45_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_45_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_45300( ) ;
      cmbTLiqModTra.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "TLIQMODTRA_"+sGXsfl_45_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
      cmbTLiqFrecPag.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "TLIQFRECPAG_"+sGXsfl_45_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
      edtTLiqDescAuxFrec_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "TLIQDESCAUXFREC_"+sGXsfl_45_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      cmbTLiqModTra.setName( cmbTLiqModTra.getInternalname() );
      cmbTLiqModTra.setValue( httpContext.cgiGet( cmbTLiqModTra.getInternalname()) );
      A2408TLiqModTra = httpContext.cgiGet( cmbTLiqModTra.getInternalname()) ;
      cmbTLiqFrecPag.setName( cmbTLiqFrecPag.getInternalname() );
      cmbTLiqFrecPag.setValue( httpContext.cgiGet( cmbTLiqFrecPag.getInternalname()) );
      A2412TLiqFrecPag = (byte)(GXutil.lval( httpContext.cgiGet( cmbTLiqFrecPag.getInternalname()))) ;
      A2413TLiqDescAuxFrec = GXutil.upper( httpContext.cgiGet( edtTLiqDescAuxFrec_Internalname)) ;
      GXCCtl = "Z2408TLiqModTra_" + sGXsfl_45_idx ;
      Z2408TLiqModTra = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z2412TLiqFrecPag_" + sGXsfl_45_idx ;
      Z2412TLiqFrecPag = (byte)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z2413TLiqDescAuxFrec_" + sGXsfl_45_idx ;
      Z2413TLiqDescAuxFrec = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "nRcdDeleted_300_" + sGXsfl_45_idx ;
      nRcdDeleted_300 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdExists_300_" + sGXsfl_45_idx ;
      nRcdExists_300 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nIsMod_300_" + sGXsfl_45_idx ;
      nIsMod_300 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
   }

   public void assign_properties_default( )
   {
      defcmbTLiqFrecPag_Enabled = cmbTLiqFrecPag.getEnabled() ;
      defcmbTLiqModTra_Enabled = cmbTLiqModTra.getEnabled() ;
   }

   public void confirmValues1E0( )
   {
      nGXsfl_45_idx = 0 ;
      sGXsfl_45_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_45_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_45300( ) ;
      while ( nGXsfl_45_idx < nRC_GXsfl_45 )
      {
         nGXsfl_45_idx = (int)(nGXsfl_45_idx+1) ;
         sGXsfl_45_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_45_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_45300( ) ;
         httpContext.changePostValue( "Z2408TLiqModTra_"+sGXsfl_45_idx, httpContext.cgiGet( "ZT_"+"Z2408TLiqModTra_"+sGXsfl_45_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2408TLiqModTra_"+sGXsfl_45_idx) ;
         httpContext.changePostValue( "Z2412TLiqFrecPag_"+sGXsfl_45_idx, httpContext.cgiGet( "ZT_"+"Z2412TLiqFrecPag_"+sGXsfl_45_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2412TLiqFrecPag_"+sGXsfl_45_idx) ;
         httpContext.changePostValue( "Z2413TLiqDescAuxFrec_"+sGXsfl_45_idx, httpContext.cgiGet( "ZT_"+"Z2413TLiqDescAuxFrec_"+sGXsfl_45_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2413TLiqDescAuxFrec_"+sGXsfl_45_idx) ;
      }
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.tipoliquidacion", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV11CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV7TLiqCod))}, new String[] {"Gx_mode","CliCod","TLiqCod"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"TipoLiquidacion");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("TLiqHabilitada", GXutil.booltostr( A341TLiqHabilitada));
      forbiddenHiddens.add("TLiqOrd", localUtil.format( DecimalUtil.doubleToDec(A1817TLiqOrd), "ZZZ9"));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("tipoliquidacion:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z32TLiqCod", GXutil.rtrim( Z32TLiqCod));
      web.GxWebStd.gx_hidden_field( httpContext, "Z340TliqDesc", Z340TliqDesc);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z341TLiqHabilitada", Z341TLiqHabilitada);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1076TLiqAcuDiasTrab", Z1076TLiqAcuDiasTrab);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1211TliqSAC", Z1211TliqSAC);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1817TLiqOrd", GXutil.ltrim( localUtil.ntoc( Z1817TLiqOrd, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2091TLiqCodFor", GXutil.rtrim( Z2091TLiqCodFor));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_45", GXutil.ltrim( localUtil.ntoc( nGXsfl_45_idx, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV11CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTLIQCOD", GXutil.rtrim( AV7TLiqCod));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTLIQCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV7TLiqCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vGXBSCREEN", GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "TLIQHABILITADA", A341TLiqHabilitada);
      web.GxWebStd.gx_hidden_field( httpContext, "TLIQORD", GXutil.ltrim( localUtil.ntoc( A1817TLiqOrd, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV20Pgmname));
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
      return formatLink("web.tipoliquidacion", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV11CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV7TLiqCod))}, new String[] {"Gx_mode","CliCod","TLiqCod"})  ;
   }

   public String getPgmname( )
   {
      return "TipoLiquidacion" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Tipo Liquidacion", "") ;
   }

   public void initializeNonKey1E47( )
   {
      A340TliqDesc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A340TliqDesc", A340TliqDesc);
      A1076TLiqAcuDiasTrab = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1076TLiqAcuDiasTrab", A1076TLiqAcuDiasTrab);
      A1211TliqSAC = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1211TliqSAC", A1211TliqSAC);
      A1817TLiqOrd = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1817TLiqOrd", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1817TLiqOrd), 4, 0));
      A2091TLiqCodFor = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2091TLiqCodFor", A2091TLiqCodFor);
      A341TLiqHabilitada = true ;
      httpContext.ajax_rsp_assign_attri("", false, "A341TLiqHabilitada", A341TLiqHabilitada);
      Z340TliqDesc = "" ;
      Z341TLiqHabilitada = false ;
      Z1076TLiqAcuDiasTrab = false ;
      Z1211TliqSAC = false ;
      Z1817TLiqOrd = (short)(0) ;
      Z2091TLiqCodFor = "" ;
   }

   public void initAll1E47( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A32TLiqCod = "" ;
      n32TLiqCod = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A32TLiqCod", A32TLiqCod);
      initializeNonKey1E47( ) ;
   }

   public void standaloneModalInsert( )
   {
      A341TLiqHabilitada = i341TLiqHabilitada ;
      httpContext.ajax_rsp_assign_attri("", false, "A341TLiqHabilitada", A341TLiqHabilitada);
   }

   public void initializeNonKey1E300( )
   {
      A2413TLiqDescAuxFrec = "" ;
      Z2413TLiqDescAuxFrec = "" ;
   }

   public void initAll1E300( )
   {
      A2408TLiqModTra = "" ;
      A2412TLiqFrecPag = (byte)(0) ;
      initializeNonKey1E300( ) ;
   }

   public void standaloneModalInsert1E300( )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713585386", true, true);
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
      httpContext.AddJavascriptSource("tipoliquidacion.js", "?20251713585387", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_level_properties300( )
   {
      cmbTLiqFrecPag.setEnabled( defcmbTLiqFrecPag_Enabled );
      httpContext.ajax_rsp_assign_prop("", false, cmbTLiqFrecPag.getInternalname(), "Enabled", GXutil.ltrimstr( cmbTLiqFrecPag.getEnabled(), 5, 0), !bGXsfl_45_Refreshing);
      cmbTLiqModTra.setEnabled( defcmbTLiqModTra_Enabled );
      httpContext.ajax_rsp_assign_prop("", false, cmbTLiqModTra.getInternalname(), "Enabled", GXutil.ltrimstr( cmbTLiqModTra.getEnabled(), 5, 0), !bGXsfl_45_Refreshing);
   }

   public void startgridcontrol45( )
   {
      Gridlevel1Container.AddObjectProperty("GridName", "Gridlevel1");
      Gridlevel1Container.AddObjectProperty("Header", subGridlevel1_Header);
      Gridlevel1Container.AddObjectProperty("Class", "WorkWith");
      Gridlevel1Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("CmpContext", "");
      Gridlevel1Container.AddObjectProperty("InMasterPage", "false");
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", GXutil.rtrim( A2408TLiqModTra));
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( cmbTLiqModTra.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2412TLiqFrecPag, (byte)(1), (byte)(0), ".", "")));
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( cmbTLiqFrecPag.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", A2413TLiqDescAuxFrec);
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtTLiqDescAuxFrec_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Container.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Collapsed, (byte)(1), (byte)(0), ".", "")));
   }

   public void init_default_properties( )
   {
      edtTLiqCod_Internalname = "TLIQCOD" ;
      edtTliqDesc_Internalname = "TLIQDESC" ;
      chkTLiqAcuDiasTrab.setInternalname( "TLIQACUDIASTRAB" );
      chkTliqSAC.setInternalname( "TLIQSAC" );
      edtTLiqCodFor_Internalname = "TLIQCODFOR" ;
      cmbTLiqModTra.setInternalname( "TLIQMODTRA" );
      cmbTLiqFrecPag.setInternalname( "TLIQFRECPAG" );
      edtTLiqDescAuxFrec_Internalname = "TLIQDESCAUXFREC" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtCliCod_Internalname = "CLICOD" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridlevel1_Internalname = "GRIDLEVEL1" ;
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
      subGridlevel1_Allowcollapsing = (byte)(0) ;
      subGridlevel1_Allowselection = (byte)(0) ;
      subGridlevel1_Header = "" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Tipo Liquidacion", "") );
      edtTLiqDescAuxFrec_Jsonclick = "" ;
      cmbTLiqFrecPag.setJsonclick( "" );
      cmbTLiqModTra.setJsonclick( "" );
      subGridlevel1_Class = "WorkWith" ;
      subGridlevel1_Backcolorstyle = (byte)(0) ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtTLiqDescAuxFrec_Enabled = 1 ;
      cmbTLiqFrecPag.setEnabled( 1 );
      cmbTLiqModTra.setEnabled( 1 );
      edtTLiqCodFor_Jsonclick = "" ;
      edtTLiqCodFor_Enabled = 1 ;
      chkTliqSAC.setEnabled( 1 );
      chkTLiqAcuDiasTrab.setEnabled( 1 );
      edtTliqDesc_Jsonclick = "" ;
      edtTliqDesc_Enabled = 1 ;
      edtTLiqCod_Jsonclick = "" ;
      edtTLiqCod_Enabled = 1 ;
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

   public void gx1asaclicod1E47( int AV11CliCod )
   {
      if ( ! (0==AV11CliCod) )
      {
         A3CliCod = AV11CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int4 = A3CliCod ;
            GXv_int5[0] = GXt_int4 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
            tipoliquidacion_impl.this.GXt_int4 = GXv_int5[0] ;
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

   public void gxnrgridlevel1_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_45300( ) ;
      while ( nGXsfl_45_idx <= nRC_GXsfl_45 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal1E300( ) ;
         standaloneModal1E300( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow1E300( ) ;
         nGXsfl_45_idx = (int)(nGXsfl_45_idx+1) ;
         sGXsfl_45_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_45_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_45300( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel1Container)) ;
      /* End function gxnrGridlevel1_newrow */
   }

   public void init_web_controls( )
   {
      chkTLiqAcuDiasTrab.setName( "TLIQACUDIASTRAB" );
      chkTLiqAcuDiasTrab.setWebtags( "" );
      chkTLiqAcuDiasTrab.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkTLiqAcuDiasTrab.getInternalname(), "TitleCaption", chkTLiqAcuDiasTrab.getCaption(), true);
      chkTLiqAcuDiasTrab.setCheckedValue( "false" );
      A1076TLiqAcuDiasTrab = GXutil.strtobool( GXutil.booltostr( A1076TLiqAcuDiasTrab)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1076TLiqAcuDiasTrab", A1076TLiqAcuDiasTrab);
      chkTliqSAC.setName( "TLIQSAC" );
      chkTliqSAC.setWebtags( "" );
      chkTliqSAC.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkTliqSAC.getInternalname(), "TitleCaption", chkTliqSAC.getCaption(), true);
      chkTliqSAC.setCheckedValue( "false" );
      A1211TliqSAC = GXutil.strtobool( GXutil.booltostr( A1211TliqSAC)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1211TliqSAC", A1211TliqSAC);
      GXCCtl = "TLIQMODTRA_" + sGXsfl_45_idx ;
      cmbTLiqModTra.setName( GXCCtl );
      cmbTLiqModTra.setWebtags( "" );
      cmbTLiqModTra.addItem("E", httpContext.getMessage( "Empleado", ""), (short)(0));
      cmbTLiqModTra.addItem("I", httpContext.getMessage( "Independiente", ""), (short)(0));
      if ( cmbTLiqModTra.getItemCount() > 0 )
      {
         A2408TLiqModTra = cmbTLiqModTra.getValidValue(A2408TLiqModTra) ;
      }
      GXCCtl = "TLIQFRECPAG_" + sGXsfl_45_idx ;
      cmbTLiqFrecPag.setName( GXCCtl );
      cmbTLiqFrecPag.setWebtags( "" );
      cmbTLiqFrecPag.addItem("1", httpContext.getMessage( "Mensual", ""), (short)(0));
      cmbTLiqFrecPag.addItem("2", httpContext.getMessage( "Quincenal", ""), (short)(0));
      cmbTLiqFrecPag.addItem("3", httpContext.getMessage( "Semanal", ""), (short)(0));
      cmbTLiqFrecPag.addItem("4", httpContext.getMessage( "Diaria", ""), (short)(0));
      if ( cmbTLiqFrecPag.getItemCount() > 0 )
      {
         A2412TLiqFrecPag = (byte)(GXutil.lval( cmbTLiqFrecPag.getValidValue(GXutil.trim( GXutil.str( A2412TLiqFrecPag, 1, 0))))) ;
      }
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
      /* Using cursor T001E25 */
      pr_default.execute(23, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(23) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(23);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV7TLiqCod',fld:'vTLIQCOD',pic:'',hsh:true},{av:'A1076TLiqAcuDiasTrab',fld:'TLIQACUDIASTRAB',pic:''},{av:'A1211TliqSAC',fld:'TLIQSAC',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'A1076TLiqAcuDiasTrab',fld:'TLIQACUDIASTRAB',pic:''},{av:'A1211TliqSAC',fld:'TLIQSAC',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV7TLiqCod',fld:'vTLIQCOD',pic:'',hsh:true},{av:'A341TLiqHabilitada',fld:'TLIQHABILITADA',pic:''},{av:'A1817TLiqOrd',fld:'TLIQORD',pic:'ZZZ9'},{av:'A1076TLiqAcuDiasTrab',fld:'TLIQACUDIASTRAB',pic:''},{av:'A1211TliqSAC',fld:'TLIQSAC',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'A1076TLiqAcuDiasTrab',fld:'TLIQACUDIASTRAB',pic:''},{av:'A1211TliqSAC',fld:'TLIQSAC',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e121E2',iparms:[{av:'A1076TLiqAcuDiasTrab',fld:'TLIQACUDIASTRAB',pic:''},{av:'A1211TliqSAC',fld:'TLIQSAC',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'A1076TLiqAcuDiasTrab',fld:'TLIQACUDIASTRAB',pic:''},{av:'A1211TliqSAC',fld:'TLIQSAC',pic:''}]}");
      setEventMetadata("VALID_TLIQCOD","{handler:'valid_Tliqcod',iparms:[{av:'A1076TLiqAcuDiasTrab',fld:'TLIQACUDIASTRAB',pic:''},{av:'A1211TliqSAC',fld:'TLIQSAC',pic:''}]");
      setEventMetadata("VALID_TLIQCOD",",oparms:[{av:'A1076TLiqAcuDiasTrab',fld:'TLIQACUDIASTRAB',pic:''},{av:'A1211TliqSAC',fld:'TLIQSAC',pic:''}]}");
      setEventMetadata("VALID_TLIQDESC","{handler:'valid_Tliqdesc',iparms:[{av:'A1076TLiqAcuDiasTrab',fld:'TLIQACUDIASTRAB',pic:''},{av:'A1211TliqSAC',fld:'TLIQSAC',pic:''}]");
      setEventMetadata("VALID_TLIQDESC",",oparms:[{av:'A1076TLiqAcuDiasTrab',fld:'TLIQACUDIASTRAB',pic:''},{av:'A1211TliqSAC',fld:'TLIQSAC',pic:''}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1076TLiqAcuDiasTrab',fld:'TLIQACUDIASTRAB',pic:''},{av:'A1211TliqSAC',fld:'TLIQSAC',pic:''}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'A1076TLiqAcuDiasTrab',fld:'TLIQACUDIASTRAB',pic:''},{av:'A1211TliqSAC',fld:'TLIQSAC',pic:''}]}");
      setEventMetadata("VALID_TLIQMODTRA","{handler:'valid_Tliqmodtra',iparms:[{av:'A1076TLiqAcuDiasTrab',fld:'TLIQACUDIASTRAB',pic:''},{av:'A1211TliqSAC',fld:'TLIQSAC',pic:''}]");
      setEventMetadata("VALID_TLIQMODTRA",",oparms:[{av:'A1076TLiqAcuDiasTrab',fld:'TLIQACUDIASTRAB',pic:''},{av:'A1211TliqSAC',fld:'TLIQSAC',pic:''}]}");
      setEventMetadata("VALID_TLIQFRECPAG","{handler:'valid_Tliqfrecpag',iparms:[{av:'A1076TLiqAcuDiasTrab',fld:'TLIQACUDIASTRAB',pic:''},{av:'A1211TliqSAC',fld:'TLIQSAC',pic:''}]");
      setEventMetadata("VALID_TLIQFRECPAG",",oparms:[{av:'A1076TLiqAcuDiasTrab',fld:'TLIQACUDIASTRAB',pic:''},{av:'A1211TliqSAC',fld:'TLIQSAC',pic:''}]}");
      setEventMetadata("NULL","{handler:'valid_Tliqdescauxfrec',iparms:[{av:'A1076TLiqAcuDiasTrab',fld:'TLIQACUDIASTRAB',pic:''},{av:'A1211TliqSAC',fld:'TLIQSAC',pic:''}]");
      setEventMetadata("NULL",",oparms:[{av:'A1076TLiqAcuDiasTrab',fld:'TLIQACUDIASTRAB',pic:''},{av:'A1211TliqSAC',fld:'TLIQSAC',pic:''}]}");
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
      return "tipoliquidacion_Execute";
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
      pr_default.close(23);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV7TLiqCod = "" ;
      Z32TLiqCod = "" ;
      Z340TliqDesc = "" ;
      Z2091TLiqCodFor = "" ;
      Z2408TLiqModTra = "" ;
      Z2413TLiqDescAuxFrec = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      AV7TLiqCod = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A32TLiqCod = "" ;
      A340TliqDesc = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A2091TLiqCodFor = "" ;
      Gridlevel1Container = new com.genexus.webpanels.GXWebGrid(context);
      sMode300 = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV20Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode47 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      GXCCtl = "" ;
      A2408TLiqModTra = "" ;
      A2413TLiqDescAuxFrec = "" ;
      AV8WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV9TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10WebSession = httpContext.getWebSession();
      T001E7_A32TLiqCod = new String[] {""} ;
      T001E7_n32TLiqCod = new boolean[] {false} ;
      T001E7_A340TliqDesc = new String[] {""} ;
      T001E7_A341TLiqHabilitada = new boolean[] {false} ;
      T001E7_A1076TLiqAcuDiasTrab = new boolean[] {false} ;
      T001E7_A1211TliqSAC = new boolean[] {false} ;
      T001E7_A1817TLiqOrd = new short[1] ;
      T001E7_A2091TLiqCodFor = new String[] {""} ;
      T001E7_A3CliCod = new int[1] ;
      T001E6_A3CliCod = new int[1] ;
      T001E8_A3CliCod = new int[1] ;
      T001E9_A3CliCod = new int[1] ;
      T001E9_A32TLiqCod = new String[] {""} ;
      T001E9_n32TLiqCod = new boolean[] {false} ;
      T001E5_A32TLiqCod = new String[] {""} ;
      T001E5_n32TLiqCod = new boolean[] {false} ;
      T001E5_A340TliqDesc = new String[] {""} ;
      T001E5_A341TLiqHabilitada = new boolean[] {false} ;
      T001E5_A1076TLiqAcuDiasTrab = new boolean[] {false} ;
      T001E5_A1211TliqSAC = new boolean[] {false} ;
      T001E5_A1817TLiqOrd = new short[1] ;
      T001E5_A2091TLiqCodFor = new String[] {""} ;
      T001E5_A3CliCod = new int[1] ;
      T001E10_A3CliCod = new int[1] ;
      T001E10_A32TLiqCod = new String[] {""} ;
      T001E10_n32TLiqCod = new boolean[] {false} ;
      T001E11_A3CliCod = new int[1] ;
      T001E11_A32TLiqCod = new String[] {""} ;
      T001E11_n32TLiqCod = new boolean[] {false} ;
      T001E4_A32TLiqCod = new String[] {""} ;
      T001E4_n32TLiqCod = new boolean[] {false} ;
      T001E4_A340TliqDesc = new String[] {""} ;
      T001E4_A341TLiqHabilitada = new boolean[] {false} ;
      T001E4_A1076TLiqAcuDiasTrab = new boolean[] {false} ;
      T001E4_A1211TliqSAC = new boolean[] {false} ;
      T001E4_A1817TLiqOrd = new short[1] ;
      T001E4_A2091TLiqCodFor = new String[] {""} ;
      T001E4_A3CliCod = new int[1] ;
      T001E15_A3CliCod = new int[1] ;
      T001E15_A1EmpCod = new short[1] ;
      T001E15_A6LegNumero = new int[1] ;
      T001E15_A1829PreliqTLiqCod = new String[] {""} ;
      T001E15_A1830PreliqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      T001E16_A3CliCod = new int[1] ;
      T001E16_A1EmpCod = new short[1] ;
      T001E16_A31LiqNro = new int[1] ;
      T001E17_A3CliCod = new int[1] ;
      T001E17_A26ConCodigo = new String[] {""} ;
      T001E17_A32TLiqCod = new String[] {""} ;
      T001E17_n32TLiqCod = new boolean[] {false} ;
      T001E18_A3CliCod = new int[1] ;
      T001E18_A32TLiqCod = new String[] {""} ;
      T001E18_n32TLiqCod = new boolean[] {false} ;
      T001E19_A3CliCod = new int[1] ;
      T001E19_A32TLiqCod = new String[] {""} ;
      T001E19_n32TLiqCod = new boolean[] {false} ;
      T001E19_A2408TLiqModTra = new String[] {""} ;
      T001E19_A2412TLiqFrecPag = new byte[1] ;
      T001E19_A2413TLiqDescAuxFrec = new String[] {""} ;
      T001E20_A3CliCod = new int[1] ;
      T001E20_A32TLiqCod = new String[] {""} ;
      T001E20_n32TLiqCod = new boolean[] {false} ;
      T001E20_A2408TLiqModTra = new String[] {""} ;
      T001E20_A2412TLiqFrecPag = new byte[1] ;
      T001E3_A3CliCod = new int[1] ;
      T001E3_A32TLiqCod = new String[] {""} ;
      T001E3_n32TLiqCod = new boolean[] {false} ;
      T001E3_A2408TLiqModTra = new String[] {""} ;
      T001E3_A2412TLiqFrecPag = new byte[1] ;
      T001E3_A2413TLiqDescAuxFrec = new String[] {""} ;
      T001E2_A3CliCod = new int[1] ;
      T001E2_A32TLiqCod = new String[] {""} ;
      T001E2_n32TLiqCod = new boolean[] {false} ;
      T001E2_A2408TLiqModTra = new String[] {""} ;
      T001E2_A2412TLiqFrecPag = new byte[1] ;
      T001E2_A2413TLiqDescAuxFrec = new String[] {""} ;
      T001E24_A3CliCod = new int[1] ;
      T001E24_A32TLiqCod = new String[] {""} ;
      T001E24_n32TLiqCod = new boolean[] {false} ;
      T001E24_A2408TLiqModTra = new String[] {""} ;
      T001E24_A2412TLiqFrecPag = new byte[1] ;
      Gridlevel1Row = new com.genexus.webpanels.GXWebRow();
      subGridlevel1_Linesclass = "" ;
      ROClassString = "" ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      Gridlevel1Column = new com.genexus.webpanels.GXWebColumn();
      GXv_int5 = new int[1] ;
      T001E25_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.tipoliquidacion__default(),
         new Object[] {
             new Object[] {
            T001E2_A3CliCod, T001E2_A32TLiqCod, T001E2_A2408TLiqModTra, T001E2_A2412TLiqFrecPag, T001E2_A2413TLiqDescAuxFrec
            }
            , new Object[] {
            T001E3_A3CliCod, T001E3_A32TLiqCod, T001E3_A2408TLiqModTra, T001E3_A2412TLiqFrecPag, T001E3_A2413TLiqDescAuxFrec
            }
            , new Object[] {
            T001E4_A32TLiqCod, T001E4_A340TliqDesc, T001E4_A341TLiqHabilitada, T001E4_A1076TLiqAcuDiasTrab, T001E4_A1211TliqSAC, T001E4_A1817TLiqOrd, T001E4_A2091TLiqCodFor, T001E4_A3CliCod
            }
            , new Object[] {
            T001E5_A32TLiqCod, T001E5_A340TliqDesc, T001E5_A341TLiqHabilitada, T001E5_A1076TLiqAcuDiasTrab, T001E5_A1211TliqSAC, T001E5_A1817TLiqOrd, T001E5_A2091TLiqCodFor, T001E5_A3CliCod
            }
            , new Object[] {
            T001E6_A3CliCod
            }
            , new Object[] {
            T001E7_A32TLiqCod, T001E7_A340TliqDesc, T001E7_A341TLiqHabilitada, T001E7_A1076TLiqAcuDiasTrab, T001E7_A1211TliqSAC, T001E7_A1817TLiqOrd, T001E7_A2091TLiqCodFor, T001E7_A3CliCod
            }
            , new Object[] {
            T001E8_A3CliCod
            }
            , new Object[] {
            T001E9_A3CliCod, T001E9_A32TLiqCod
            }
            , new Object[] {
            T001E10_A3CliCod, T001E10_A32TLiqCod
            }
            , new Object[] {
            T001E11_A3CliCod, T001E11_A32TLiqCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001E15_A3CliCod, T001E15_A1EmpCod, T001E15_A6LegNumero, T001E15_A1829PreliqTLiqCod, T001E15_A1830PreliqPeriodo
            }
            , new Object[] {
            T001E16_A3CliCod, T001E16_A1EmpCod, T001E16_A31LiqNro
            }
            , new Object[] {
            T001E17_A3CliCod, T001E17_A26ConCodigo, T001E17_A32TLiqCod
            }
            , new Object[] {
            T001E18_A3CliCod, T001E18_A32TLiqCod
            }
            , new Object[] {
            T001E19_A3CliCod, T001E19_A32TLiqCod, T001E19_A2408TLiqModTra, T001E19_A2412TLiqFrecPag, T001E19_A2413TLiqDescAuxFrec
            }
            , new Object[] {
            T001E20_A3CliCod, T001E20_A32TLiqCod, T001E20_A2408TLiqModTra, T001E20_A2412TLiqFrecPag
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001E24_A3CliCod, T001E24_A32TLiqCod, T001E24_A2408TLiqModTra, T001E24_A2412TLiqFrecPag
            }
            , new Object[] {
            T001E25_A3CliCod
            }
         }
      );
      AV20Pgmname = "TipoLiquidacion" ;
      Z341TLiqHabilitada = true ;
      A341TLiqHabilitada = true ;
      i341TLiqHabilitada = true ;
   }

   private byte Z2412TLiqFrecPag ;
   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte A2412TLiqFrecPag ;
   private byte subGridlevel1_Backcolorstyle ;
   private byte subGridlevel1_Backstyle ;
   private byte gxajaxcallmode ;
   private byte subGridlevel1_Allowselection ;
   private byte subGridlevel1_Allowhovering ;
   private byte subGridlevel1_Allowcollapsing ;
   private byte subGridlevel1_Collapsed ;
   private short Z1817TLiqOrd ;
   private short nRcdDeleted_300 ;
   private short nRcdExists_300 ;
   private short nIsMod_300 ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short nBlankRcdCount300 ;
   private short RcdFound300 ;
   private short nBlankRcdUsr300 ;
   private short A1817TLiqOrd ;
   private short RcdFound47 ;
   private short nIsDirty_47 ;
   private short nIsDirty_300 ;
   private int wcpOAV11CliCod ;
   private int Z3CliCod ;
   private int nRC_GXsfl_45 ;
   private int nGXsfl_45_idx=1 ;
   private int AV11CliCod ;
   private int A3CliCod ;
   private int trnEnded ;
   private int edtTLiqCod_Enabled ;
   private int edtTliqDesc_Enabled ;
   private int edtTLiqCodFor_Enabled ;
   private int edtTLiqDescAuxFrec_Enabled ;
   private int fRowAdded ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int subGridlevel1_Backcolor ;
   private int subGridlevel1_Allbackcolor ;
   private int defcmbTLiqFrecPag_Enabled ;
   private int defcmbTLiqModTra_Enabled ;
   private int idxLst ;
   private int subGridlevel1_Selectedindex ;
   private int subGridlevel1_Selectioncolor ;
   private int subGridlevel1_Hoveringcolor ;
   private int GXt_int4 ;
   private int GXv_int5[] ;
   private long GRIDLEVEL1_nFirstRecordOnPage ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV7TLiqCod ;
   private String Z32TLiqCod ;
   private String Z2091TLiqCodFor ;
   private String Z2408TLiqModTra ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String AV7TLiqCod ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtTLiqCod_Internalname ;
   private String sGXsfl_45_idx="0001" ;
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
   private String A32TLiqCod ;
   private String edtTLiqCod_Jsonclick ;
   private String edtTliqDesc_Internalname ;
   private String edtTliqDesc_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String edtTLiqCodFor_Internalname ;
   private String A2091TLiqCodFor ;
   private String edtTLiqCodFor_Jsonclick ;
   private String sMode300 ;
   private String edtTLiqDescAuxFrec_Internalname ;
   private String subGridlevel1_Internalname ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String AV20Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode47 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXCCtl ;
   private String A2408TLiqModTra ;
   private String sGXsfl_45_fel_idx="0001" ;
   private String subGridlevel1_Class ;
   private String subGridlevel1_Linesclass ;
   private String ROClassString ;
   private String edtTLiqDescAuxFrec_Jsonclick ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String subGridlevel1_Header ;
   private boolean Z341TLiqHabilitada ;
   private boolean Z1076TLiqAcuDiasTrab ;
   private boolean Z1211TliqSAC ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean A1076TLiqAcuDiasTrab ;
   private boolean A1211TliqSAC ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean bGXsfl_45_Refreshing=false ;
   private boolean A341TLiqHabilitada ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean n32TLiqCod ;
   private boolean returnInSub ;
   private boolean AV13IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean Gx_longc ;
   private boolean i341TLiqHabilitada ;
   private String Z340TliqDesc ;
   private String Z2413TLiqDescAuxFrec ;
   private String A340TliqDesc ;
   private String A2413TLiqDescAuxFrec ;
   private com.genexus.webpanels.GXWebGrid Gridlevel1Container ;
   private com.genexus.webpanels.GXWebRow Gridlevel1Row ;
   private com.genexus.webpanels.GXWebColumn Gridlevel1Column ;
   private com.genexus.webpanels.WebSession AV10WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private ICheckbox chkTLiqAcuDiasTrab ;
   private ICheckbox chkTliqSAC ;
   private HTMLChoice cmbTLiqModTra ;
   private HTMLChoice cmbTLiqFrecPag ;
   private IDataStoreProvider pr_default ;
   private String[] T001E7_A32TLiqCod ;
   private boolean[] T001E7_n32TLiqCod ;
   private String[] T001E7_A340TliqDesc ;
   private boolean[] T001E7_A341TLiqHabilitada ;
   private boolean[] T001E7_A1076TLiqAcuDiasTrab ;
   private boolean[] T001E7_A1211TliqSAC ;
   private short[] T001E7_A1817TLiqOrd ;
   private String[] T001E7_A2091TLiqCodFor ;
   private int[] T001E7_A3CliCod ;
   private int[] T001E6_A3CliCod ;
   private int[] T001E8_A3CliCod ;
   private int[] T001E9_A3CliCod ;
   private String[] T001E9_A32TLiqCod ;
   private boolean[] T001E9_n32TLiqCod ;
   private String[] T001E5_A32TLiqCod ;
   private boolean[] T001E5_n32TLiqCod ;
   private String[] T001E5_A340TliqDesc ;
   private boolean[] T001E5_A341TLiqHabilitada ;
   private boolean[] T001E5_A1076TLiqAcuDiasTrab ;
   private boolean[] T001E5_A1211TliqSAC ;
   private short[] T001E5_A1817TLiqOrd ;
   private String[] T001E5_A2091TLiqCodFor ;
   private int[] T001E5_A3CliCod ;
   private int[] T001E10_A3CliCod ;
   private String[] T001E10_A32TLiqCod ;
   private boolean[] T001E10_n32TLiqCod ;
   private int[] T001E11_A3CliCod ;
   private String[] T001E11_A32TLiqCod ;
   private boolean[] T001E11_n32TLiqCod ;
   private String[] T001E4_A32TLiqCod ;
   private boolean[] T001E4_n32TLiqCod ;
   private String[] T001E4_A340TliqDesc ;
   private boolean[] T001E4_A341TLiqHabilitada ;
   private boolean[] T001E4_A1076TLiqAcuDiasTrab ;
   private boolean[] T001E4_A1211TliqSAC ;
   private short[] T001E4_A1817TLiqOrd ;
   private String[] T001E4_A2091TLiqCodFor ;
   private int[] T001E4_A3CliCod ;
   private int[] T001E15_A3CliCod ;
   private short[] T001E15_A1EmpCod ;
   private int[] T001E15_A6LegNumero ;
   private String[] T001E15_A1829PreliqTLiqCod ;
   private java.util.Date[] T001E15_A1830PreliqPeriodo ;
   private int[] T001E16_A3CliCod ;
   private short[] T001E16_A1EmpCod ;
   private int[] T001E16_A31LiqNro ;
   private int[] T001E17_A3CliCod ;
   private String[] T001E17_A26ConCodigo ;
   private String[] T001E17_A32TLiqCod ;
   private boolean[] T001E17_n32TLiqCod ;
   private int[] T001E18_A3CliCod ;
   private String[] T001E18_A32TLiqCod ;
   private boolean[] T001E18_n32TLiqCod ;
   private int[] T001E19_A3CliCod ;
   private String[] T001E19_A32TLiqCod ;
   private boolean[] T001E19_n32TLiqCod ;
   private String[] T001E19_A2408TLiqModTra ;
   private byte[] T001E19_A2412TLiqFrecPag ;
   private String[] T001E19_A2413TLiqDescAuxFrec ;
   private int[] T001E20_A3CliCod ;
   private String[] T001E20_A32TLiqCod ;
   private boolean[] T001E20_n32TLiqCod ;
   private String[] T001E20_A2408TLiqModTra ;
   private byte[] T001E20_A2412TLiqFrecPag ;
   private int[] T001E3_A3CliCod ;
   private String[] T001E3_A32TLiqCod ;
   private boolean[] T001E3_n32TLiqCod ;
   private String[] T001E3_A2408TLiqModTra ;
   private byte[] T001E3_A2412TLiqFrecPag ;
   private String[] T001E3_A2413TLiqDescAuxFrec ;
   private int[] T001E2_A3CliCod ;
   private String[] T001E2_A32TLiqCod ;
   private boolean[] T001E2_n32TLiqCod ;
   private String[] T001E2_A2408TLiqModTra ;
   private byte[] T001E2_A2412TLiqFrecPag ;
   private String[] T001E2_A2413TLiqDescAuxFrec ;
   private int[] T001E24_A3CliCod ;
   private String[] T001E24_A32TLiqCod ;
   private boolean[] T001E24_n32TLiqCod ;
   private String[] T001E24_A2408TLiqModTra ;
   private byte[] T001E24_A2412TLiqFrecPag ;
   private int[] T001E25_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
}

final  class tipoliquidacion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T001E2", "SELECT CliCod, TLiqCod, TLiqModTra, TLiqFrecPag, TLiqDescAuxFrec FROM TipoLiquidacionmodo_frec WHERE CliCod = ? AND TLiqCod = ? AND TLiqModTra = ? AND TLiqFrecPag = ?  FOR UPDATE OF TipoLiquidacionmodo_frec NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001E3", "SELECT CliCod, TLiqCod, TLiqModTra, TLiqFrecPag, TLiqDescAuxFrec FROM TipoLiquidacionmodo_frec WHERE CliCod = ? AND TLiqCod = ? AND TLiqModTra = ? AND TLiqFrecPag = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001E4", "SELECT TLiqCod, TliqDesc, TLiqHabilitada, TLiqAcuDiasTrab, TliqSAC, TLiqOrd, TLiqCodFor, CliCod FROM TipoLiquidacion WHERE CliCod = ? AND TLiqCod = ?  FOR UPDATE OF TipoLiquidacion NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001E5", "SELECT TLiqCod, TliqDesc, TLiqHabilitada, TLiqAcuDiasTrab, TliqSAC, TLiqOrd, TLiqCodFor, CliCod FROM TipoLiquidacion WHERE CliCod = ? AND TLiqCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001E6", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001E7", "SELECT TM1.TLiqCod, TM1.TliqDesc, TM1.TLiqHabilitada, TM1.TLiqAcuDiasTrab, TM1.TliqSAC, TM1.TLiqOrd, TM1.TLiqCodFor, TM1.CliCod FROM TipoLiquidacion TM1 WHERE TM1.CliCod = ? and TM1.TLiqCod = ( ?) ORDER BY TM1.CliCod, TM1.TLiqCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001E8", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001E9", "SELECT CliCod, TLiqCod FROM TipoLiquidacion WHERE CliCod = ? AND TLiqCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001E10", "SELECT CliCod, TLiqCod FROM TipoLiquidacion WHERE ( CliCod > ? or CliCod = ? and TLiqCod > ( ?)) ORDER BY CliCod, TLiqCod  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001E11", "SELECT CliCod, TLiqCod FROM TipoLiquidacion WHERE ( CliCod < ? or CliCod = ? and TLiqCod < ( ?)) ORDER BY CliCod DESC, TLiqCod DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T001E12", "SAVEPOINT gxupdate;INSERT INTO TipoLiquidacion(TLiqCod, TliqDesc, TLiqHabilitada, TLiqAcuDiasTrab, TliqSAC, TLiqOrd, TLiqCodFor, CliCod) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001E13", "SAVEPOINT gxupdate;UPDATE TipoLiquidacion SET TliqDesc=?, TLiqHabilitada=?, TLiqAcuDiasTrab=?, TliqSAC=?, TLiqOrd=?, TLiqCodFor=?  WHERE CliCod = ? AND TLiqCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001E14", "SAVEPOINT gxupdate;DELETE FROM TipoLiquidacion  WHERE CliCod = ? AND TLiqCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T001E15", "SELECT CliCod, EmpCod, LegNumero, PreliqTLiqCod, PreliqPeriodo FROM LegPreliqCab WHERE CliCod = ? AND PreliqTLiqCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001E16", "SELECT CliCod, EmpCod, LiqNro FROM Liquidacion WHERE CliCod = ? AND TLiqCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001E17", "SELECT CliCod, ConCodigo, TLiqCod FROM ConceptoTipoLiquidacion WHERE CliCod = ? AND TLiqCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001E18", "SELECT CliCod, TLiqCod FROM TipoLiquidacion ORDER BY CliCod, TLiqCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001E19", "SELECT CliCod, TLiqCod, TLiqModTra, TLiqFrecPag, TLiqDescAuxFrec FROM TipoLiquidacionmodo_frec WHERE CliCod = ? and TLiqCod = ( ?) and TLiqModTra = ( ?) and TLiqFrecPag = ? ORDER BY CliCod, TLiqCod, TLiqModTra, TLiqFrecPag ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001E20", "SELECT CliCod, TLiqCod, TLiqModTra, TLiqFrecPag FROM TipoLiquidacionmodo_frec WHERE CliCod = ? AND TLiqCod = ? AND TLiqModTra = ? AND TLiqFrecPag = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T001E21", "SAVEPOINT gxupdate;INSERT INTO TipoLiquidacionmodo_frec(CliCod, TLiqCod, TLiqModTra, TLiqFrecPag, TLiqDescAuxFrec) VALUES(?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001E22", "SAVEPOINT gxupdate;UPDATE TipoLiquidacionmodo_frec SET TLiqDescAuxFrec=?  WHERE CliCod = ? AND TLiqCod = ? AND TLiqModTra = ? AND TLiqFrecPag = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001E23", "SAVEPOINT gxupdate;DELETE FROM TipoLiquidacionmodo_frec  WHERE CliCod = ? AND TLiqCod = ? AND TLiqModTra = ? AND TLiqFrecPag = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T001E24", "SELECT CliCod, TLiqCod, TLiqModTra, TLiqFrecPag FROM TipoLiquidacionmodo_frec WHERE CliCod = ? and TLiqCod = ( ?) ORDER BY CliCod, TLiqCod, TLiqModTra, TLiqFrecPag ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001E25", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 17 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 18 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               return;
            case 22 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               return;
            case 23 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
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
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               stmt.setString(3, (String)parms[3], 1);
               stmt.setByte(4, ((Number) parms[4]).byteValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               stmt.setString(3, (String)parms[3], 1);
               stmt.setByte(4, ((Number) parms[4]).byteValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[3], 20);
               }
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[3], 20);
               }
               return;
            case 10 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               stmt.setVarchar(2, (String)parms[2], 30, false);
               stmt.setBoolean(3, ((Boolean) parms[3]).booleanValue());
               stmt.setBoolean(4, ((Boolean) parms[4]).booleanValue());
               stmt.setBoolean(5, ((Boolean) parms[5]).booleanValue());
               stmt.setShort(6, ((Number) parms[6]).shortValue());
               stmt.setString(7, (String)parms[7], 20);
               stmt.setInt(8, ((Number) parms[8]).intValue());
               return;
            case 11 :
               stmt.setVarchar(1, (String)parms[0], 30, false);
               stmt.setBoolean(2, ((Boolean) parms[1]).booleanValue());
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setInt(7, ((Number) parms[6]).intValue());
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(8, (String)parms[8], 20);
               }
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               stmt.setString(3, (String)parms[3], 1);
               stmt.setByte(4, ((Number) parms[4]).byteValue());
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               stmt.setString(3, (String)parms[3], 1);
               stmt.setByte(4, ((Number) parms[4]).byteValue());
               return;
            case 19 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               stmt.setString(3, (String)parms[3], 1);
               stmt.setByte(4, ((Number) parms[4]).byteValue());
               stmt.setVarchar(5, (String)parms[5], 30, false);
               return;
            case 20 :
               stmt.setVarchar(1, (String)parms[0], 30, false);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[3], 20);
               }
               stmt.setString(4, (String)parms[4], 1);
               stmt.setByte(5, ((Number) parms[5]).byteValue());
               return;
            case 21 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               stmt.setString(3, (String)parms[3], 1);
               stmt.setByte(4, ((Number) parms[4]).byteValue());
               return;
            case 22 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 23 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

