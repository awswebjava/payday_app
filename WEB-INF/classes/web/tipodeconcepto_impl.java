package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class tipodeconcepto_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_13") == 0 )
      {
         A2120TipoConPai = (short)(GXutil.lval( httpContext.GetPar( "TipoConPai"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2120TipoConPai", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2120TipoConPai), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_13( A2120TipoConPai) ;
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel_subtipo2") == 0 )
      {
         gxnrgridlevel_subtipo2_newrow_invoke( ) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Freestylelevel_subtipo1") == 0 )
      {
         gxnrfreestylelevel_subtipo1_newrow_invoke( ) ;
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
            AV7TipoConCod = httpContext.GetPar( "TipoConCod") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7TipoConCod", AV7TipoConCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTIPOCONCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV7TipoConCod, ""))));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Tipo De Concepto", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = cmbTipoConCod.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrgridlevel_subtipo2_newrow_invoke( )
   {
      nRC_GXsfl_117 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_117"))) ;
      nGXsfl_117_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_117_idx"))) ;
      sGXsfl_117_idx = httpContext.GetPar( "sGXsfl_117_idx") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel_subtipo2_newrow( ) ;
      /* End function gxnrGridlevel_subtipo2_newrow_invoke */
   }

   public void gxnrfreestylelevel_subtipo1_newrow_invoke( )
   {
      nRC_GXsfl_72 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_72"))) ;
      nGXsfl_72_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_72_idx"))) ;
      sGXsfl_72_idx = httpContext.GetPar( "sGXsfl_72_idx") ;
      Gx_mode = httpContext.GetPar( "Mode") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrfreestylelevel_subtipo1_newrow( ) ;
      /* End function gxnrFreestylelevel_subtipo1_newrow_invoke */
   }

   public tipodeconcepto_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public tipodeconcepto_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( tipodeconcepto_impl.class ));
   }

   public tipodeconcepto_impl( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbTipoConCod = new HTMLChoice();
      cmbTipoConTipo = new HTMLChoice();
      chkSubTDescuLey = UIFactory.getCheckbox(this);
      chkSubTEsAdicional = UIFactory.getCheckbox(this);
      chkSubTRestaDias = UIFactory.getCheckbox(this);
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
      if ( cmbTipoConCod.getItemCount() > 0 )
      {
         A37TipoConCod = cmbTipoConCod.getValidValue(A37TipoConCod) ;
         httpContext.ajax_rsp_assign_attri("", false, "A37TipoConCod", A37TipoConCod);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbTipoConCod.setValue( GXutil.rtrim( A37TipoConCod) );
         httpContext.ajax_rsp_assign_prop("", false, cmbTipoConCod.getInternalname(), "Values", cmbTipoConCod.ToJavascriptSource(), true);
      }
      if ( cmbTipoConTipo.getItemCount() > 0 )
      {
         A2157TipoConTipo = cmbTipoConTipo.getValidValue(A2157TipoConTipo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2157TipoConTipo", A2157TipoConTipo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbTipoConTipo.setValue( GXutil.rtrim( A2157TipoConTipo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbTipoConTipo.getInternalname(), "Values", cmbTipoConTipo.ToJavascriptSource(), true);
      }
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbTipoConCod.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbTipoConCod.getInternalname(), httpContext.getMessage( "Tipo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbTipoConCod, cmbTipoConCod.getInternalname(), GXutil.rtrim( A37TipoConCod), 1, cmbTipoConCod.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbTipoConCod.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "", true, (byte)(0), "HLP_TipoDeConcepto.htm");
      cmbTipoConCod.setValue( GXutil.rtrim( A37TipoConCod) );
      httpContext.ajax_rsp_assign_prop("", false, cmbTipoConCod.getInternalname(), "Values", cmbTipoConCod.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTipoConDescrip_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtTipoConDescrip_Internalname, httpContext.getMessage( "Descripción", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtTipoConDescrip_Internalname, A370TipoConDescrip, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", (short)(0), 1, edtTipoConDescrip_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_TipoDeConcepto.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTRangoDesde_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtTRangoDesde_Internalname, httpContext.getMessage( "Rango de códigos de AFIP Desde", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtTRangoDesde_Internalname, GXutil.ltrim( localUtil.ntoc( A377TRangoDesde, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtTRangoDesde_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A377TRangoDesde), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A377TRangoDesde), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,32);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTRangoDesde_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtTRangoDesde_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_TipoDeConcepto.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTRangoHasta_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtTRangoHasta_Internalname, httpContext.getMessage( "Rango de códigos de AFIP Hasta", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtTRangoHasta_Internalname, GXutil.ltrim( localUtil.ntoc( A378TRangoHasta, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtTRangoHasta_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A378TRangoHasta), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A378TRangoHasta), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,37);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTRangoHasta_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtTRangoHasta_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_TipoDeConcepto.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTipoConOrden_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtTipoConOrden_Internalname, httpContext.getMessage( "Orden", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtTipoConOrden_Internalname, GXutil.ltrim( localUtil.ntoc( A384TipoConOrden, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtTipoConOrden_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A384TipoConOrden), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A384TipoConOrden), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,42);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTipoConOrden_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtTipoConOrden_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_TipoDeConcepto.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTipoConPalabra_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtTipoConPalabra_Internalname, httpContext.getMessage( "Palabra para parámetro de cálculo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtTipoConPalabra_Internalname, GXutil.rtrim( A2102TipoConPalabra), GXutil.rtrim( localUtil.format( A2102TipoConPalabra, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,47);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTipoConPalabra_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtTipoConPalabra_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "palabra", "left", true, "", "HLP_TipoDeConcepto.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedtipoconpai_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktipoconpai_Internalname, httpContext.getMessage( "País", ""), "", "", lblTextblocktipoconpai_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_TipoDeConcepto.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_tipoconpai.setProperty("Caption", Combo_tipoconpai_Caption);
      ucCombo_tipoconpai.setProperty("Cls", Combo_tipoconpai_Cls);
      ucCombo_tipoconpai.setProperty("DataListProc", Combo_tipoconpai_Datalistproc);
      ucCombo_tipoconpai.setProperty("DataListProcParametersPrefix", Combo_tipoconpai_Datalistprocparametersprefix);
      ucCombo_tipoconpai.setProperty("EmptyItem", Combo_tipoconpai_Emptyitem);
      ucCombo_tipoconpai.setProperty("DropDownOptionsTitleSettingsIcons", AV16DDO_TitleSettingsIcons);
      ucCombo_tipoconpai.setProperty("DropDownOptionsData", AV15TipoConPai_Data);
      ucCombo_tipoconpai.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_tipoconpai_Internalname, "COMBO_TIPOCONPAIContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtTipoConPai_Internalname, httpContext.getMessage( "País", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 58,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtTipoConPai_Internalname, GXutil.ltrim( localUtil.ntoc( A2120TipoConPai, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A2120TipoConPai), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,58);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTipoConPai_Jsonclick, 0, "Attribute", "", "", "", "", edtTipoConPai_Visible, edtTipoConPai_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_TipoDeConcepto.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbTipoConTipo.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbTipoConTipo.getInternalname(), httpContext.getMessage( "genérico", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbTipoConTipo, cmbTipoConTipo.getInternalname(), GXutil.rtrim( A2157TipoConTipo), 1, cmbTipoConTipo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbTipoConTipo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,63);\"", "", true, (byte)(0), "HLP_TipoDeConcepto.htm");
      cmbTipoConTipo.setValue( GXutil.rtrim( A2157TipoConTipo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbTipoConTipo.getInternalname(), "Values", cmbTipoConTipo.ToJavascriptSource(), true);
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
      httpContext.writeText( "<td class='CellMarginTop'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTableintermediatelevel_subtipo1_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /*  Grid Control  */
      startgridcontrol72( ) ;
      /* Save parent mode. */
      sMode60 = Gx_mode ;
      nGXsfl_72_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount60 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_60 = (short)(1) ;
            scanStart1R60( ) ;
            while ( RcdFound60 != 0 )
            {
               init_level_properties60( ) ;
               getByPrimaryKey1R60( ) ;
               addRow1R60( ) ;
               scanNext1R60( ) ;
            }
            scanEnd1R60( ) ;
            nBlankRcdCount60 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         standaloneNotModal1R60( ) ;
         standaloneModal1R60( ) ;
         sMode60 = Gx_mode ;
         while ( nGXsfl_72_idx < nRC_GXsfl_72 )
         {
            bGXsfl_72_Refreshing = true ;
            readRow1R60( ) ;
            edtSubTipoConCod1_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SUBTIPOCONCOD1_"+sGXsfl_72_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtSubTipoConCod1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSubTipoConCod1_Enabled), 5, 0), !bGXsfl_72_Refreshing);
            edtSubTipoConDes1_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SUBTIPOCONDES1_"+sGXsfl_72_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtSubTipoConDes1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSubTipoConDes1_Enabled), 5, 0), !bGXsfl_72_Refreshing);
            edtSubTRangoDesde_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SUBTRANGODESDE_"+sGXsfl_72_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtSubTRangoDesde_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSubTRangoDesde_Enabled), 5, 0), !bGXsfl_72_Refreshing);
            edtSubTRangoHasta_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SUBTRANGOHASTA_"+sGXsfl_72_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtSubTRangoHasta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSubTRangoHasta_Enabled), 5, 0), !bGXsfl_72_Refreshing);
            chkSubTDescuLey.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "SUBTDESCULEY_"+sGXsfl_72_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
            httpContext.ajax_rsp_assign_prop("", false, chkSubTDescuLey.getInternalname(), "Enabled", GXutil.ltrimstr( chkSubTDescuLey.getEnabled(), 5, 0), !bGXsfl_72_Refreshing);
            chkSubTEsAdicional.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "SUBTESADICIONAL_"+sGXsfl_72_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
            httpContext.ajax_rsp_assign_prop("", false, chkSubTEsAdicional.getInternalname(), "Enabled", GXutil.ltrimstr( chkSubTEsAdicional.getEnabled(), 5, 0), !bGXsfl_72_Refreshing);
            chkSubTRestaDias.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "SUBTRESTADIAS_"+sGXsfl_72_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
            httpContext.ajax_rsp_assign_prop("", false, chkSubTRestaDias.getInternalname(), "Enabled", GXutil.ltrimstr( chkSubTRestaDias.getEnabled(), 5, 0), !bGXsfl_72_Refreshing);
            if ( ( nRcdExists_60 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal1R60( ) ;
            }
            sendRow1R60( ) ;
            bGXsfl_72_Refreshing = false ;
         }
         Gx_mode = sMode60 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount60 = (short)(5) ;
         nRcdExists_60 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart1R60( ) ;
            while ( RcdFound60 != 0 )
            {
               sGXsfl_72_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_72_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_7260( ) ;
               init_level_properties60( ) ;
               standaloneNotModal1R60( ) ;
               getByPrimaryKey1R60( ) ;
               standaloneModal1R60( ) ;
               addRow1R60( ) ;
               scanNext1R60( ) ;
            }
            scanEnd1R60( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode60 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_72_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_72_idx+1), 4, 0), (short)(4), "0") ;
         subsflControlProps_7260( ) ;
         initAll1R60( ) ;
         init_level_properties60( ) ;
         nRcdExists_60 = (short)(0) ;
         nIsMod_60 = (short)(0) ;
         nRcdDeleted_60 = (short)(0) ;
         nBlankRcdCount60 = (short)(nBlankRcdUsr60+nBlankRcdCount60) ;
         fRowAdded = 0 ;
         while ( nBlankRcdCount60 > 0 )
         {
            standaloneNotModal1R60( ) ;
            standaloneModal1R60( ) ;
            addRow1R60( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = edtSubTipoConCod1_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount60 = (short)(nBlankRcdCount60-1) ;
         }
         Gx_mode = sMode60 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      /* Restore parent mode. */
      Gx_mode = sMode60 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Freestylelevel_subtipo1Container"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Freestylelevel_subtipo1", Freestylelevel_subtipo1Container, subFreestylelevel_subtipo1_Internalname);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Freestylelevel_subtipo1ContainerData", Freestylelevel_subtipo1Container.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Freestylelevel_subtipo1ContainerData"+"V", Freestylelevel_subtipo1Container.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Freestylelevel_subtipo1ContainerData"+"V"+"\" value='"+Freestylelevel_subtipo1Container.GridValuesHidden()+"'/>") ;
      }
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group TableContentPadding", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 124,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_TipoDeConcepto.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 126,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_TipoDeConcepto.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 128,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_TipoDeConcepto.htm");
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
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_tipoconpai_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavCombotipoconpai_Internalname, GXutil.ltrim( localUtil.ntoc( AV20ComboTipoConPai, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavCombotipoconpai_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV20ComboTipoConPai), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV20ComboTipoConPai), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombotipoconpai_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombotipoconpai_Visible, edtavCombotipoconpai_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_TipoDeConcepto.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
      e111R2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV16DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vTIPOCONPAI_DATA"), AV15TipoConPai_Data);
            /* Read saved values. */
            Z37TipoConCod = httpContext.cgiGet( "Z37TipoConCod") ;
            Z370TipoConDescrip = httpContext.cgiGet( "Z370TipoConDescrip") ;
            Z377TRangoDesde = (int)(localUtil.ctol( httpContext.cgiGet( "Z377TRangoDesde"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z378TRangoHasta = (int)(localUtil.ctol( httpContext.cgiGet( "Z378TRangoHasta"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z384TipoConOrden = (short)(localUtil.ctol( httpContext.cgiGet( "Z384TipoConOrden"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2102TipoConPalabra = httpContext.cgiGet( "Z2102TipoConPalabra") ;
            Z2157TipoConTipo = httpContext.cgiGet( "Z2157TipoConTipo") ;
            Z2120TipoConPai = (short)(localUtil.ctol( httpContext.cgiGet( "Z2120TipoConPai"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            nRC_GXsfl_72 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_72"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            N2120TipoConPai = (short)(localUtil.ctol( httpContext.cgiGet( "N2120TipoConPai"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV7TipoConCod = httpContext.cgiGet( "vTIPOCONCOD") ;
            AV13Insert_TipoConPai = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_TIPOCONPAI"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV22Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_tipoconpai_Objectcall = httpContext.cgiGet( "COMBO_TIPOCONPAI_Objectcall") ;
            Combo_tipoconpai_Class = httpContext.cgiGet( "COMBO_TIPOCONPAI_Class") ;
            Combo_tipoconpai_Icontype = httpContext.cgiGet( "COMBO_TIPOCONPAI_Icontype") ;
            Combo_tipoconpai_Icon = httpContext.cgiGet( "COMBO_TIPOCONPAI_Icon") ;
            Combo_tipoconpai_Caption = httpContext.cgiGet( "COMBO_TIPOCONPAI_Caption") ;
            Combo_tipoconpai_Tooltip = httpContext.cgiGet( "COMBO_TIPOCONPAI_Tooltip") ;
            Combo_tipoconpai_Cls = httpContext.cgiGet( "COMBO_TIPOCONPAI_Cls") ;
            Combo_tipoconpai_Selectedvalue_set = httpContext.cgiGet( "COMBO_TIPOCONPAI_Selectedvalue_set") ;
            Combo_tipoconpai_Selectedvalue_get = httpContext.cgiGet( "COMBO_TIPOCONPAI_Selectedvalue_get") ;
            Combo_tipoconpai_Selectedtext_set = httpContext.cgiGet( "COMBO_TIPOCONPAI_Selectedtext_set") ;
            Combo_tipoconpai_Selectedtext_get = httpContext.cgiGet( "COMBO_TIPOCONPAI_Selectedtext_get") ;
            Combo_tipoconpai_Gamoauthtoken = httpContext.cgiGet( "COMBO_TIPOCONPAI_Gamoauthtoken") ;
            Combo_tipoconpai_Ddointernalname = httpContext.cgiGet( "COMBO_TIPOCONPAI_Ddointernalname") ;
            Combo_tipoconpai_Titlecontrolalign = httpContext.cgiGet( "COMBO_TIPOCONPAI_Titlecontrolalign") ;
            Combo_tipoconpai_Dropdownoptionstype = httpContext.cgiGet( "COMBO_TIPOCONPAI_Dropdownoptionstype") ;
            Combo_tipoconpai_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_TIPOCONPAI_Enabled")) ;
            Combo_tipoconpai_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_TIPOCONPAI_Visible")) ;
            Combo_tipoconpai_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_TIPOCONPAI_Titlecontrolidtoreplace") ;
            Combo_tipoconpai_Datalisttype = httpContext.cgiGet( "COMBO_TIPOCONPAI_Datalisttype") ;
            Combo_tipoconpai_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_TIPOCONPAI_Allowmultipleselection")) ;
            Combo_tipoconpai_Datalistfixedvalues = httpContext.cgiGet( "COMBO_TIPOCONPAI_Datalistfixedvalues") ;
            Combo_tipoconpai_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_TIPOCONPAI_Isgriditem")) ;
            Combo_tipoconpai_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_TIPOCONPAI_Hasdescription")) ;
            Combo_tipoconpai_Datalistproc = httpContext.cgiGet( "COMBO_TIPOCONPAI_Datalistproc") ;
            Combo_tipoconpai_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_TIPOCONPAI_Datalistprocparametersprefix") ;
            Combo_tipoconpai_Remoteservicesparameters = httpContext.cgiGet( "COMBO_TIPOCONPAI_Remoteservicesparameters") ;
            Combo_tipoconpai_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_TIPOCONPAI_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_tipoconpai_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_TIPOCONPAI_Includeonlyselectedoption")) ;
            Combo_tipoconpai_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_TIPOCONPAI_Includeselectalloption")) ;
            Combo_tipoconpai_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_TIPOCONPAI_Emptyitem")) ;
            Combo_tipoconpai_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_TIPOCONPAI_Includeaddnewoption")) ;
            Combo_tipoconpai_Htmltemplate = httpContext.cgiGet( "COMBO_TIPOCONPAI_Htmltemplate") ;
            Combo_tipoconpai_Multiplevaluestype = httpContext.cgiGet( "COMBO_TIPOCONPAI_Multiplevaluestype") ;
            Combo_tipoconpai_Loadingdata = httpContext.cgiGet( "COMBO_TIPOCONPAI_Loadingdata") ;
            Combo_tipoconpai_Noresultsfound = httpContext.cgiGet( "COMBO_TIPOCONPAI_Noresultsfound") ;
            Combo_tipoconpai_Emptyitemtext = httpContext.cgiGet( "COMBO_TIPOCONPAI_Emptyitemtext") ;
            Combo_tipoconpai_Onlyselectedvalues = httpContext.cgiGet( "COMBO_TIPOCONPAI_Onlyselectedvalues") ;
            Combo_tipoconpai_Selectalltext = httpContext.cgiGet( "COMBO_TIPOCONPAI_Selectalltext") ;
            Combo_tipoconpai_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_TIPOCONPAI_Multiplevaluesseparator") ;
            Combo_tipoconpai_Addnewoptiontext = httpContext.cgiGet( "COMBO_TIPOCONPAI_Addnewoptiontext") ;
            Combo_tipoconpai_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_TIPOCONPAI_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
            cmbTipoConCod.setName( cmbTipoConCod.getInternalname() );
            cmbTipoConCod.setValue( httpContext.cgiGet( cmbTipoConCod.getInternalname()) );
            A37TipoConCod = httpContext.cgiGet( cmbTipoConCod.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A37TipoConCod", A37TipoConCod);
            A370TipoConDescrip = httpContext.cgiGet( edtTipoConDescrip_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A370TipoConDescrip", A370TipoConDescrip);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtTRangoDesde_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtTRangoDesde_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "TRANGODESDE");
               AnyError = (short)(1) ;
               GX_FocusControl = edtTRangoDesde_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A377TRangoDesde = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A377TRangoDesde", GXutil.ltrimstr( DecimalUtil.doubleToDec(A377TRangoDesde), 8, 0));
            }
            else
            {
               A377TRangoDesde = (int)(localUtil.ctol( httpContext.cgiGet( edtTRangoDesde_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A377TRangoDesde", GXutil.ltrimstr( DecimalUtil.doubleToDec(A377TRangoDesde), 8, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtTRangoHasta_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtTRangoHasta_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "TRANGOHASTA");
               AnyError = (short)(1) ;
               GX_FocusControl = edtTRangoHasta_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A378TRangoHasta = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A378TRangoHasta", GXutil.ltrimstr( DecimalUtil.doubleToDec(A378TRangoHasta), 8, 0));
            }
            else
            {
               A378TRangoHasta = (int)(localUtil.ctol( httpContext.cgiGet( edtTRangoHasta_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A378TRangoHasta", GXutil.ltrimstr( DecimalUtil.doubleToDec(A378TRangoHasta), 8, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtTipoConOrden_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtTipoConOrden_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "TIPOCONORDEN");
               AnyError = (short)(1) ;
               GX_FocusControl = edtTipoConOrden_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A384TipoConOrden = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A384TipoConOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A384TipoConOrden), 4, 0));
            }
            else
            {
               A384TipoConOrden = (short)(localUtil.ctol( httpContext.cgiGet( edtTipoConOrden_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A384TipoConOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A384TipoConOrden), 4, 0));
            }
            A2102TipoConPalabra = httpContext.cgiGet( edtTipoConPalabra_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2102TipoConPalabra", A2102TipoConPalabra);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtTipoConPai_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtTipoConPai_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "TIPOCONPAI");
               AnyError = (short)(1) ;
               GX_FocusControl = edtTipoConPai_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A2120TipoConPai = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2120TipoConPai", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2120TipoConPai), 4, 0));
            }
            else
            {
               A2120TipoConPai = (short)(localUtil.ctol( httpContext.cgiGet( edtTipoConPai_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2120TipoConPai", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2120TipoConPai), 4, 0));
            }
            cmbTipoConTipo.setName( cmbTipoConTipo.getInternalname() );
            cmbTipoConTipo.setValue( httpContext.cgiGet( cmbTipoConTipo.getInternalname()) );
            A2157TipoConTipo = httpContext.cgiGet( cmbTipoConTipo.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2157TipoConTipo", A2157TipoConTipo);
            AV20ComboTipoConPai = (short)(localUtil.ctol( httpContext.cgiGet( edtavCombotipoconpai_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20ComboTipoConPai", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ComboTipoConPai), 4, 0));
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"TipoDeConcepto");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( GXutil.strcmp(A37TipoConCod, Z37TipoConCod) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("tipodeconcepto:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
            /* Check if conditions changed and reset current page numbers */
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
               A37TipoConCod = httpContext.GetPar( "TipoConCod") ;
               httpContext.ajax_rsp_assign_attri("", false, "A37TipoConCod", A37TipoConCod);
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
                  sMode59 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode59 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound59 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_1R0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "TIPOCONCOD");
                     AnyError = (short)(1) ;
                     GX_FocusControl = cmbTipoConCod.getInternalname() ;
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
                        e111R2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e121R2 ();
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
         e121R2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll1R59( ) ;
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
         disableAttributes1R59( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavCombotipoconpai_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombotipoconpai_Enabled), 5, 0), true);
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

   public void confirm_1R0( )
   {
      beforeValidate1R59( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1R59( ) ;
         }
         else
         {
            checkExtendedTable1R59( ) ;
            closeExtendedTableCursors1R59( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode59 = Gx_mode ;
         confirm_1R60( ) ;
         if ( AnyError == 0 )
         {
            /* Restore parent mode. */
            Gx_mode = sMode59 ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            IsConfirmed = (short)(1) ;
            httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
         }
         /* Restore parent mode. */
         Gx_mode = sMode59 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
   }

   public void confirm_1R61( )
   {
      nGXsfl_117_idx = 0 ;
      while ( nGXsfl_117_idx < nRC_GXsfl_117 )
      {
         readRow1R61( ) ;
         if ( ( nRcdExists_61 != 0 ) || ( nIsMod_61 != 0 ) )
         {
            getKey1R61( ) ;
            if ( ( nRcdExists_61 == 0 ) && ( nRcdDeleted_61 == 0 ) )
            {
               if ( RcdFound61 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate1R61( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable1R61( ) ;
                     closeExtendedTableCursors1R61( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "SUBTIPOCONCOD1_" + sGXsfl_72_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtSubTipoConCod1_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound61 != 0 )
               {
                  if ( nRcdDeleted_61 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey1R61( ) ;
                     load1R61( ) ;
                     beforeValidate1R61( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls1R61( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_61 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate1R61( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable1R61( ) ;
                           closeExtendedTableCursors1R61( ) ;
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
                  if ( nRcdDeleted_61 == 0 )
                  {
                     GXCCtl = "SUBTIPOCONCOD1_" + sGXsfl_72_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtSubTipoConCod1_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtSubTipoConCod2_Internalname, GXutil.rtrim( A39SubTipoConCod2)) ;
         httpContext.changePostValue( edtSubTipoConDes2_Internalname, A372SubTipoConDes2) ;
         httpContext.changePostValue( "ZT_"+"Z39SubTipoConCod2_"+sGXsfl_117_idx, GXutil.rtrim( Z39SubTipoConCod2)) ;
         httpContext.changePostValue( "ZT_"+"Z372SubTipoConDes2_"+sGXsfl_117_idx, Z372SubTipoConDes2) ;
         httpContext.changePostValue( "nRcdDeleted_61_"+sGXsfl_117_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_61, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_61_"+sGXsfl_117_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_61, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_61_"+sGXsfl_117_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_61, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_61 != 0 )
         {
            httpContext.changePostValue( "SUBTIPOCONCOD2_"+sGXsfl_117_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSubTipoConCod2_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "SUBTIPOCONDES2_"+sGXsfl_117_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSubTipoConDes2_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_1R60( )
   {
      nGXsfl_72_idx = 0 ;
      while ( nGXsfl_72_idx < nRC_GXsfl_72 )
      {
         readRow1R60( ) ;
         if ( ( nRcdExists_60 != 0 ) || ( nIsMod_60 != 0 ) )
         {
            getKey1R60( ) ;
            if ( ( nRcdExists_60 == 0 ) && ( nRcdDeleted_60 == 0 ) )
            {
               if ( RcdFound60 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate1R60( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable1R60( ) ;
                     closeExtendedTableCursors1R60( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Save parent mode. */
                        sMode60 = Gx_mode ;
                        confirm_1R61( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Restore parent mode. */
                           Gx_mode = sMode60 ;
                           httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                           IsConfirmed = (short)(1) ;
                           httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                        }
                        /* Restore parent mode. */
                        Gx_mode = sMode60 ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     }
                  }
               }
               else
               {
                  GXCCtl = "SUBTIPOCONCOD1_" + sGXsfl_72_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtSubTipoConCod1_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound60 != 0 )
               {
                  if ( nRcdDeleted_60 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey1R60( ) ;
                     load1R60( ) ;
                     beforeValidate1R60( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls1R60( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_60 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate1R60( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable1R60( ) ;
                           closeExtendedTableCursors1R60( ) ;
                           if ( AnyError == 0 )
                           {
                              /* Save parent mode. */
                              sMode60 = Gx_mode ;
                              confirm_1R61( ) ;
                              if ( AnyError == 0 )
                              {
                                 /* Restore parent mode. */
                                 Gx_mode = sMode60 ;
                                 httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                                 IsConfirmed = (short)(1) ;
                                 httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                              }
                              /* Restore parent mode. */
                              Gx_mode = sMode60 ;
                              httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                           }
                        }
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_60 == 0 )
                  {
                     GXCCtl = "SUBTIPOCONCOD1_" + sGXsfl_72_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtSubTipoConCod1_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtSubTipoConCod1_Internalname, GXutil.rtrim( A38SubTipoConCod1)) ;
         httpContext.changePostValue( edtSubTipoConDes1_Internalname, A371SubTipoConDes1) ;
         httpContext.changePostValue( edtSubTRangoDesde_Internalname, GXutil.ltrim( localUtil.ntoc( A375SubTRangoDesde, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtSubTRangoHasta_Internalname, GXutil.ltrim( localUtil.ntoc( A376SubTRangoHasta, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( chkSubTDescuLey.getInternalname(), GXutil.booltostr( A740SubTDescuLey)) ;
         httpContext.changePostValue( chkSubTEsAdicional.getInternalname(), GXutil.booltostr( A1027SubTEsAdicional)) ;
         httpContext.changePostValue( chkSubTRestaDias.getInternalname(), GXutil.booltostr( A2134SubTRestaDias)) ;
         httpContext.changePostValue( "ZT_"+"Z38SubTipoConCod1_"+sGXsfl_72_idx, GXutil.rtrim( Z38SubTipoConCod1)) ;
         httpContext.changePostValue( "ZT_"+"Z371SubTipoConDes1_"+sGXsfl_72_idx, Z371SubTipoConDes1) ;
         httpContext.changePostValue( "ZT_"+"Z375SubTRangoDesde_"+sGXsfl_72_idx, GXutil.ltrim( localUtil.ntoc( Z375SubTRangoDesde, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z376SubTRangoHasta_"+sGXsfl_72_idx, GXutil.ltrim( localUtil.ntoc( Z376SubTRangoHasta, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z740SubTDescuLey_"+sGXsfl_72_idx, GXutil.booltostr( Z740SubTDescuLey)) ;
         httpContext.changePostValue( "ZT_"+"Z1027SubTEsAdicional_"+sGXsfl_72_idx, GXutil.booltostr( Z1027SubTEsAdicional)) ;
         httpContext.changePostValue( "ZT_"+"Z2134SubTRestaDias_"+sGXsfl_72_idx, GXutil.booltostr( Z2134SubTRestaDias)) ;
         httpContext.changePostValue( "nRC_GXsfl_117_"+sGXsfl_72_idx, GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_117, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_60_"+sGXsfl_72_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_60, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_60_"+sGXsfl_72_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_60, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_60_"+sGXsfl_72_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_60, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_60 != 0 )
         {
            httpContext.changePostValue( "SUBTIPOCONCOD1_"+sGXsfl_72_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSubTipoConCod1_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "SUBTIPOCONDES1_"+sGXsfl_72_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSubTipoConDes1_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "SUBTRANGODESDE_"+sGXsfl_72_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSubTRangoDesde_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "SUBTRANGOHASTA_"+sGXsfl_72_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSubTRangoHasta_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "SUBTDESCULEY_"+sGXsfl_72_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( chkSubTDescuLey.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "SUBTESADICIONAL_"+sGXsfl_72_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( chkSubTEsAdicional.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "SUBTRESTADIAS_"+sGXsfl_72_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( chkSubTRestaDias.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void resetCaption1R0( )
   {
   }

   public void e111R2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV16DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV16DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      edtTipoConPai_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTipoConPai_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTipoConPai_Visible), 5, 0), true);
      AV20ComboTipoConPai = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboTipoConPai", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ComboTipoConPai), 4, 0));
      edtavCombotipoconpai_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombotipoconpai_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombotipoconpai_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOTIPOCONPAI' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(6);
         pr_default.close(5);
         pr_default.close(3);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV9IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean4 = AV9IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWTipoDeConcepto_Insert", GXv_boolean5) ;
         tipodeconcepto_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV9IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV9IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWTipoDeConcepto_Update", GXv_boolean5) ;
         tipodeconcepto_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV9IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV9IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWTipoDeConcepto_Delete", GXv_boolean5) ;
         tipodeconcepto_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV9IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( ! AV9IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV22Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV11TrnContext.fromxml(AV12WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV11TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV22Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV23GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV23GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23GXV1), 8, 0));
         while ( AV23GXV1 <= AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV14TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV23GXV1));
            if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "TipoConPai") == 0 )
            {
               AV13Insert_TipoConPai = (short)(GXutil.lval( AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV13Insert_TipoConPai", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13Insert_TipoConPai), 4, 0));
               if ( ! (0==AV13Insert_TipoConPai) )
               {
                  AV20ComboTipoConPai = AV13Insert_TipoConPai ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV20ComboTipoConPai", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ComboTipoConPai), 4, 0));
                  Combo_tipoconpai_Selectedvalue_set = GXutil.trim( GXutil.str( AV20ComboTipoConPai, 4, 0)) ;
                  ucCombo_tipoconpai.sendProperty(context, "", false, Combo_tipoconpai_Internalname, "SelectedValue_set", Combo_tipoconpai_Selectedvalue_set);
                  GXt_char6 = AV19Combo_DataJson ;
                  GXv_char7[0] = AV17ComboSelectedValue ;
                  GXv_char8[0] = AV18ComboSelectedText ;
                  GXv_char9[0] = GXt_char6 ;
                  new web.tipodeconceptoloaddvcombo(remoteHandle, context).execute( "TipoConPai", "GET", false, AV7TipoConCod, AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char7, GXv_char8, GXv_char9) ;
                  tipodeconcepto_impl.this.AV17ComboSelectedValue = GXv_char7[0] ;
                  tipodeconcepto_impl.this.AV18ComboSelectedText = GXv_char8[0] ;
                  tipodeconcepto_impl.this.GXt_char6 = GXv_char9[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV17ComboSelectedValue", AV17ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedText", AV18ComboSelectedText);
                  AV19Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV19Combo_DataJson", AV19Combo_DataJson);
                  Combo_tipoconpai_Selectedtext_set = AV18ComboSelectedText ;
                  ucCombo_tipoconpai.sendProperty(context, "", false, Combo_tipoconpai_Internalname, "SelectedText_set", Combo_tipoconpai_Selectedtext_set);
                  Combo_tipoconpai_Enabled = false ;
                  ucCombo_tipoconpai.sendProperty(context, "", false, Combo_tipoconpai_Internalname, "Enabled", GXutil.booltostr( Combo_tipoconpai_Enabled));
               }
            }
            AV23GXV1 = (int)(AV23GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23GXV1), 8, 0));
         }
      }
   }

   public void e121R2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(6);
      pr_default.close(5);
      pr_default.close(3);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void S112( )
   {
      /* 'LOADCOMBOTIPOCONPAI' Routine */
      returnInSub = false ;
      GXt_char6 = AV19Combo_DataJson ;
      GXv_char9[0] = AV17ComboSelectedValue ;
      GXv_char8[0] = AV18ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new web.tipodeconceptoloaddvcombo(remoteHandle, context).execute( "TipoConPai", Gx_mode, false, AV7TipoConCod, "", GXv_char9, GXv_char8, GXv_char7) ;
      tipodeconcepto_impl.this.AV17ComboSelectedValue = GXv_char9[0] ;
      tipodeconcepto_impl.this.AV18ComboSelectedText = GXv_char8[0] ;
      tipodeconcepto_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17ComboSelectedValue", AV17ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedText", AV18ComboSelectedText);
      AV19Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19Combo_DataJson", AV19Combo_DataJson);
      Combo_tipoconpai_Selectedvalue_set = AV17ComboSelectedValue ;
      ucCombo_tipoconpai.sendProperty(context, "", false, Combo_tipoconpai_Internalname, "SelectedValue_set", Combo_tipoconpai_Selectedvalue_set);
      Combo_tipoconpai_Selectedtext_set = AV18ComboSelectedText ;
      ucCombo_tipoconpai.sendProperty(context, "", false, Combo_tipoconpai_Internalname, "SelectedText_set", Combo_tipoconpai_Selectedtext_set);
      AV20ComboTipoConPai = (short)(GXutil.lval( AV17ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboTipoConPai", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ComboTipoConPai), 4, 0));
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_tipoconpai_Enabled = false ;
         ucCombo_tipoconpai.sendProperty(context, "", false, Combo_tipoconpai_Internalname, "Enabled", GXutil.booltostr( Combo_tipoconpai_Enabled));
      }
   }

   public void zm1R59( int GX_JID )
   {
      if ( ( GX_JID == 12 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z370TipoConDescrip = T001R7_A370TipoConDescrip[0] ;
            Z377TRangoDesde = T001R7_A377TRangoDesde[0] ;
            Z378TRangoHasta = T001R7_A378TRangoHasta[0] ;
            Z384TipoConOrden = T001R7_A384TipoConOrden[0] ;
            Z2102TipoConPalabra = T001R7_A2102TipoConPalabra[0] ;
            Z2157TipoConTipo = T001R7_A2157TipoConTipo[0] ;
            Z2120TipoConPai = T001R7_A2120TipoConPai[0] ;
         }
         else
         {
            Z370TipoConDescrip = A370TipoConDescrip ;
            Z377TRangoDesde = A377TRangoDesde ;
            Z378TRangoHasta = A378TRangoHasta ;
            Z384TipoConOrden = A384TipoConOrden ;
            Z2102TipoConPalabra = A2102TipoConPalabra ;
            Z2157TipoConTipo = A2157TipoConTipo ;
            Z2120TipoConPai = A2120TipoConPai ;
         }
      }
      if ( GX_JID == -12 )
      {
         Z37TipoConCod = A37TipoConCod ;
         Z370TipoConDescrip = A370TipoConDescrip ;
         Z377TRangoDesde = A377TRangoDesde ;
         Z378TRangoHasta = A378TRangoHasta ;
         Z384TipoConOrden = A384TipoConOrden ;
         Z2102TipoConPalabra = A2102TipoConPalabra ;
         Z2157TipoConTipo = A2157TipoConTipo ;
         Z2120TipoConPai = A2120TipoConPai ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (GXutil.strcmp("", AV7TipoConCod)==0) )
      {
         A37TipoConCod = AV7TipoConCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A37TipoConCod", A37TipoConCod);
      }
      if ( ! (GXutil.strcmp("", AV7TipoConCod)==0) )
      {
         cmbTipoConCod.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbTipoConCod.getInternalname(), "Enabled", GXutil.ltrimstr( cmbTipoConCod.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbTipoConCod.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbTipoConCod.getInternalname(), "Enabled", GXutil.ltrimstr( cmbTipoConCod.getEnabled(), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV7TipoConCod)==0) )
      {
         cmbTipoConCod.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbTipoConCod.getInternalname(), "Enabled", GXutil.ltrimstr( cmbTipoConCod.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_TipoConPai) )
      {
         edtTipoConPai_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtTipoConPai_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTipoConPai_Enabled), 5, 0), true);
      }
      else
      {
         edtTipoConPai_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtTipoConPai_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTipoConPai_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_TipoConPai) )
      {
         A2120TipoConPai = AV13Insert_TipoConPai ;
         httpContext.ajax_rsp_assign_attri("", false, "A2120TipoConPai", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2120TipoConPai), 4, 0));
      }
      else
      {
         A2120TipoConPai = AV20ComboTipoConPai ;
         httpContext.ajax_rsp_assign_attri("", false, "A2120TipoConPai", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2120TipoConPai), 4, 0));
      }
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
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV22Pgmname = "TipoDeConcepto" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
      }
   }

   public void load1R59( )
   {
      /* Using cursor T001R9 */
      pr_default.execute(7, new Object[] {A37TipoConCod});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound59 = (short)(1) ;
         A370TipoConDescrip = T001R9_A370TipoConDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A370TipoConDescrip", A370TipoConDescrip);
         A377TRangoDesde = T001R9_A377TRangoDesde[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A377TRangoDesde", GXutil.ltrimstr( DecimalUtil.doubleToDec(A377TRangoDesde), 8, 0));
         A378TRangoHasta = T001R9_A378TRangoHasta[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A378TRangoHasta", GXutil.ltrimstr( DecimalUtil.doubleToDec(A378TRangoHasta), 8, 0));
         A384TipoConOrden = T001R9_A384TipoConOrden[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A384TipoConOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A384TipoConOrden), 4, 0));
         A2102TipoConPalabra = T001R9_A2102TipoConPalabra[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2102TipoConPalabra", A2102TipoConPalabra);
         A2157TipoConTipo = T001R9_A2157TipoConTipo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2157TipoConTipo", A2157TipoConTipo);
         A2120TipoConPai = T001R9_A2120TipoConPai[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2120TipoConPai", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2120TipoConPai), 4, 0));
         zm1R59( -12) ;
      }
      pr_default.close(7);
      onLoadActions1R59( ) ;
   }

   public void onLoadActions1R59( )
   {
      AV22Pgmname = "TipoDeConcepto" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
   }

   public void checkExtendedTable1R59( )
   {
      nIsDirty_59 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV22Pgmname = "TipoDeConcepto" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
      if ( ! ( ( GXutil.strcmp(A37TipoConCod, "REM_ARG") == 0 ) || ( GXutil.strcmp(A37TipoConCod, "NRE_ARG") == 0 ) || ( GXutil.strcmp(A37TipoConCod, "DES_ARG") == 0 ) || ( GXutil.strcmp(A37TipoConCod, "CAL_ARG") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "TIPOCONCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbTipoConCod.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T001R8 */
      pr_default.execute(6, new Object[] {Short.valueOf(A2120TipoConPai)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Concepto Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPOCONPAI");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTipoConPai_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(6);
      if ( ! ( ( GXutil.strcmp(A2157TipoConTipo, "REM") == 0 ) || ( GXutil.strcmp(A2157TipoConTipo, "NRE") == 0 ) || ( GXutil.strcmp(A2157TipoConTipo, "DES") == 0 ) || ( GXutil.strcmp(A2157TipoConTipo, "CAL") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo genérico", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "TIPOCONTIPO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbTipoConTipo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors1R59( )
   {
      pr_default.close(6);
   }

   public void enableDisable( )
   {
   }

   public void gxload_13( short A2120TipoConPai )
   {
      /* Using cursor T001R10 */
      pr_default.execute(8, new Object[] {Short.valueOf(A2120TipoConPai)});
      if ( (pr_default.getStatus(8) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Concepto Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPOCONPAI");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTipoConPai_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(8) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(8);
   }

   public void getKey1R59( )
   {
      /* Using cursor T001R11 */
      pr_default.execute(9, new Object[] {A37TipoConCod});
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound59 = (short)(1) ;
      }
      else
      {
         RcdFound59 = (short)(0) ;
      }
      pr_default.close(9);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T001R7 */
      pr_default.execute(5, new Object[] {A37TipoConCod});
      if ( (pr_default.getStatus(5) != 101) )
      {
         zm1R59( 12) ;
         RcdFound59 = (short)(1) ;
         A37TipoConCod = T001R7_A37TipoConCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A37TipoConCod", A37TipoConCod);
         A370TipoConDescrip = T001R7_A370TipoConDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A370TipoConDescrip", A370TipoConDescrip);
         A377TRangoDesde = T001R7_A377TRangoDesde[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A377TRangoDesde", GXutil.ltrimstr( DecimalUtil.doubleToDec(A377TRangoDesde), 8, 0));
         A378TRangoHasta = T001R7_A378TRangoHasta[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A378TRangoHasta", GXutil.ltrimstr( DecimalUtil.doubleToDec(A378TRangoHasta), 8, 0));
         A384TipoConOrden = T001R7_A384TipoConOrden[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A384TipoConOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A384TipoConOrden), 4, 0));
         A2102TipoConPalabra = T001R7_A2102TipoConPalabra[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2102TipoConPalabra", A2102TipoConPalabra);
         A2157TipoConTipo = T001R7_A2157TipoConTipo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2157TipoConTipo", A2157TipoConTipo);
         A2120TipoConPai = T001R7_A2120TipoConPai[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2120TipoConPai", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2120TipoConPai), 4, 0));
         Z37TipoConCod = A37TipoConCod ;
         sMode59 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load1R59( ) ;
         if ( AnyError == 1 )
         {
            RcdFound59 = (short)(0) ;
            initializeNonKey1R59( ) ;
         }
         Gx_mode = sMode59 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound59 = (short)(0) ;
         initializeNonKey1R59( ) ;
         sMode59 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode59 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(5);
   }

   public void getEqualNoModal( )
   {
      getKey1R59( ) ;
      if ( RcdFound59 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound59 = (short)(0) ;
      /* Using cursor T001R12 */
      pr_default.execute(10, new Object[] {A37TipoConCod});
      if ( (pr_default.getStatus(10) != 101) )
      {
         while ( (pr_default.getStatus(10) != 101) && ( ( GXutil.strcmp(T001R12_A37TipoConCod[0], A37TipoConCod) < 0 ) ) )
         {
            pr_default.readNext(10);
         }
         if ( (pr_default.getStatus(10) != 101) && ( ( GXutil.strcmp(T001R12_A37TipoConCod[0], A37TipoConCod) > 0 ) ) )
         {
            A37TipoConCod = T001R12_A37TipoConCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A37TipoConCod", A37TipoConCod);
            RcdFound59 = (short)(1) ;
         }
      }
      pr_default.close(10);
   }

   public void move_previous( )
   {
      RcdFound59 = (short)(0) ;
      /* Using cursor T001R13 */
      pr_default.execute(11, new Object[] {A37TipoConCod});
      if ( (pr_default.getStatus(11) != 101) )
      {
         while ( (pr_default.getStatus(11) != 101) && ( ( GXutil.strcmp(T001R13_A37TipoConCod[0], A37TipoConCod) > 0 ) ) )
         {
            pr_default.readNext(11);
         }
         if ( (pr_default.getStatus(11) != 101) && ( ( GXutil.strcmp(T001R13_A37TipoConCod[0], A37TipoConCod) < 0 ) ) )
         {
            A37TipoConCod = T001R13_A37TipoConCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A37TipoConCod", A37TipoConCod);
            RcdFound59 = (short)(1) ;
         }
      }
      pr_default.close(11);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1R59( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = cmbTipoConCod.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert1R59( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound59 == 1 )
         {
            if ( GXutil.strcmp(A37TipoConCod, Z37TipoConCod) != 0 )
            {
               A37TipoConCod = Z37TipoConCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A37TipoConCod", A37TipoConCod);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "TIPOCONCOD");
               AnyError = (short)(1) ;
               GX_FocusControl = cmbTipoConCod.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = cmbTipoConCod.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update1R59( ) ;
               GX_FocusControl = cmbTipoConCod.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( GXutil.strcmp(A37TipoConCod, Z37TipoConCod) != 0 )
            {
               /* Insert record */
               GX_FocusControl = cmbTipoConCod.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert1R59( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "TIPOCONCOD");
                  AnyError = (short)(1) ;
                  GX_FocusControl = cmbTipoConCod.getInternalname() ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = cmbTipoConCod.getInternalname() ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert1R59( ) ;
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
      if ( GXutil.strcmp(A37TipoConCod, Z37TipoConCod) != 0 )
      {
         A37TipoConCod = Z37TipoConCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A37TipoConCod", A37TipoConCod);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "TIPOCONCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbTipoConCod.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = cmbTipoConCod.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency1R59( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T001R6 */
         pr_default.execute(4, new Object[] {A37TipoConCod});
         if ( (pr_default.getStatus(4) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"TipoDeConcepto"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(4) == 101) || ( GXutil.strcmp(Z370TipoConDescrip, T001R6_A370TipoConDescrip[0]) != 0 ) || ( Z377TRangoDesde != T001R6_A377TRangoDesde[0] ) || ( Z378TRangoHasta != T001R6_A378TRangoHasta[0] ) || ( Z384TipoConOrden != T001R6_A384TipoConOrden[0] ) || ( GXutil.strcmp(Z2102TipoConPalabra, T001R6_A2102TipoConPalabra[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z2157TipoConTipo, T001R6_A2157TipoConTipo[0]) != 0 ) || ( Z2120TipoConPai != T001R6_A2120TipoConPai[0] ) )
         {
            if ( GXutil.strcmp(Z370TipoConDescrip, T001R6_A370TipoConDescrip[0]) != 0 )
            {
               GXutil.writeLogln("tipodeconcepto:[seudo value changed for attri]"+"TipoConDescrip");
               GXutil.writeLogRaw("Old: ",Z370TipoConDescrip);
               GXutil.writeLogRaw("Current: ",T001R6_A370TipoConDescrip[0]);
            }
            if ( Z377TRangoDesde != T001R6_A377TRangoDesde[0] )
            {
               GXutil.writeLogln("tipodeconcepto:[seudo value changed for attri]"+"TRangoDesde");
               GXutil.writeLogRaw("Old: ",Z377TRangoDesde);
               GXutil.writeLogRaw("Current: ",T001R6_A377TRangoDesde[0]);
            }
            if ( Z378TRangoHasta != T001R6_A378TRangoHasta[0] )
            {
               GXutil.writeLogln("tipodeconcepto:[seudo value changed for attri]"+"TRangoHasta");
               GXutil.writeLogRaw("Old: ",Z378TRangoHasta);
               GXutil.writeLogRaw("Current: ",T001R6_A378TRangoHasta[0]);
            }
            if ( Z384TipoConOrden != T001R6_A384TipoConOrden[0] )
            {
               GXutil.writeLogln("tipodeconcepto:[seudo value changed for attri]"+"TipoConOrden");
               GXutil.writeLogRaw("Old: ",Z384TipoConOrden);
               GXutil.writeLogRaw("Current: ",T001R6_A384TipoConOrden[0]);
            }
            if ( GXutil.strcmp(Z2102TipoConPalabra, T001R6_A2102TipoConPalabra[0]) != 0 )
            {
               GXutil.writeLogln("tipodeconcepto:[seudo value changed for attri]"+"TipoConPalabra");
               GXutil.writeLogRaw("Old: ",Z2102TipoConPalabra);
               GXutil.writeLogRaw("Current: ",T001R6_A2102TipoConPalabra[0]);
            }
            if ( GXutil.strcmp(Z2157TipoConTipo, T001R6_A2157TipoConTipo[0]) != 0 )
            {
               GXutil.writeLogln("tipodeconcepto:[seudo value changed for attri]"+"TipoConTipo");
               GXutil.writeLogRaw("Old: ",Z2157TipoConTipo);
               GXutil.writeLogRaw("Current: ",T001R6_A2157TipoConTipo[0]);
            }
            if ( Z2120TipoConPai != T001R6_A2120TipoConPai[0] )
            {
               GXutil.writeLogln("tipodeconcepto:[seudo value changed for attri]"+"TipoConPai");
               GXutil.writeLogRaw("Old: ",Z2120TipoConPai);
               GXutil.writeLogRaw("Current: ",T001R6_A2120TipoConPai[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"TipoDeConcepto"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1R59( )
   {
      beforeValidate1R59( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1R59( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1R59( 0) ;
         checkOptimisticConcurrency1R59( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1R59( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1R59( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001R14 */
                  pr_default.execute(12, new Object[] {A37TipoConCod, A370TipoConDescrip, Integer.valueOf(A377TRangoDesde), Integer.valueOf(A378TRangoHasta), Short.valueOf(A384TipoConOrden), A2102TipoConPalabra, A2157TipoConTipo, Short.valueOf(A2120TipoConPai)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConcepto");
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
                        processLevel1R59( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                           resetCaption1R0( ) ;
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
            load1R59( ) ;
         }
         endLevel1R59( ) ;
      }
      closeExtendedTableCursors1R59( ) ;
   }

   public void update1R59( )
   {
      beforeValidate1R59( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1R59( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1R59( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1R59( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1R59( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001R15 */
                  pr_default.execute(13, new Object[] {A370TipoConDescrip, Integer.valueOf(A377TRangoDesde), Integer.valueOf(A378TRangoHasta), Short.valueOf(A384TipoConOrden), A2102TipoConPalabra, A2157TipoConTipo, Short.valueOf(A2120TipoConPai), A37TipoConCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConcepto");
                  if ( (pr_default.getStatus(13) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"TipoDeConcepto"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1R59( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel1R59( ) ;
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
         endLevel1R59( ) ;
      }
      closeExtendedTableCursors1R59( ) ;
   }

   public void deferredUpdate1R59( )
   {
   }

   public void delete( )
   {
      beforeValidate1R59( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1R59( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1R59( ) ;
         afterConfirm1R59( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1R59( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T001R16 */
               pr_default.execute(14, new Object[] {A37TipoConCod});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConcepto");
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
      sMode59 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1R59( ) ;
      Gx_mode = sMode59 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1R59( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV22Pgmname = "TipoDeConcepto" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T001R17 */
         pr_default.execute(15, new Object[] {A37TipoConCod});
         if ( (pr_default.getStatus(15) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Promedio para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(15);
         /* Using cursor T001R18 */
         pr_default.execute(16, new Object[] {A37TipoConCod});
         if ( (pr_default.getStatus(16) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Promedio para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(16);
         /* Using cursor T001R19 */
         pr_default.execute(17, new Object[] {A37TipoConCod});
         if ( (pr_default.getStatus(17) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Promedio para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(17);
         /* Using cursor T001R20 */
         pr_default.execute(18, new Object[] {A37TipoConCod});
         if ( (pr_default.getStatus(18) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Subtipo1", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(18);
      }
   }

   public void processNestedLevel1R60( )
   {
      nGXsfl_72_idx = 0 ;
      while ( nGXsfl_72_idx < nRC_GXsfl_72 )
      {
         readRow1R60( ) ;
         if ( ( nRcdExists_60 != 0 ) || ( nIsMod_60 != 0 ) )
         {
            standaloneNotModal1R60( ) ;
            getKey1R60( ) ;
            if ( ( nRcdExists_60 == 0 ) && ( nRcdDeleted_60 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert1R60( ) ;
            }
            else
            {
               if ( RcdFound60 != 0 )
               {
                  if ( ( nRcdDeleted_60 != 0 ) && ( nRcdExists_60 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete1R60( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_60 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update1R60( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_60 == 0 )
                  {
                     GXCCtl = "SUBTIPOCONCOD1_" + sGXsfl_72_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtSubTipoConCod1_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtSubTipoConCod1_Internalname, GXutil.rtrim( A38SubTipoConCod1)) ;
         httpContext.changePostValue( edtSubTipoConDes1_Internalname, A371SubTipoConDes1) ;
         httpContext.changePostValue( edtSubTRangoDesde_Internalname, GXutil.ltrim( localUtil.ntoc( A375SubTRangoDesde, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtSubTRangoHasta_Internalname, GXutil.ltrim( localUtil.ntoc( A376SubTRangoHasta, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( chkSubTDescuLey.getInternalname(), GXutil.booltostr( A740SubTDescuLey)) ;
         httpContext.changePostValue( chkSubTEsAdicional.getInternalname(), GXutil.booltostr( A1027SubTEsAdicional)) ;
         httpContext.changePostValue( chkSubTRestaDias.getInternalname(), GXutil.booltostr( A2134SubTRestaDias)) ;
         httpContext.changePostValue( "ZT_"+"Z38SubTipoConCod1_"+sGXsfl_72_idx, GXutil.rtrim( Z38SubTipoConCod1)) ;
         httpContext.changePostValue( "ZT_"+"Z371SubTipoConDes1_"+sGXsfl_72_idx, Z371SubTipoConDes1) ;
         httpContext.changePostValue( "ZT_"+"Z375SubTRangoDesde_"+sGXsfl_72_idx, GXutil.ltrim( localUtil.ntoc( Z375SubTRangoDesde, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z376SubTRangoHasta_"+sGXsfl_72_idx, GXutil.ltrim( localUtil.ntoc( Z376SubTRangoHasta, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z740SubTDescuLey_"+sGXsfl_72_idx, GXutil.booltostr( Z740SubTDescuLey)) ;
         httpContext.changePostValue( "ZT_"+"Z1027SubTEsAdicional_"+sGXsfl_72_idx, GXutil.booltostr( Z1027SubTEsAdicional)) ;
         httpContext.changePostValue( "ZT_"+"Z2134SubTRestaDias_"+sGXsfl_72_idx, GXutil.booltostr( Z2134SubTRestaDias)) ;
         httpContext.changePostValue( "nRC_GXsfl_117_"+sGXsfl_72_idx, GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_117, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_60_"+sGXsfl_72_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_60, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_60_"+sGXsfl_72_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_60, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_60_"+sGXsfl_72_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_60, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_60 != 0 )
         {
            httpContext.changePostValue( "SUBTIPOCONCOD1_"+sGXsfl_72_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSubTipoConCod1_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "SUBTIPOCONDES1_"+sGXsfl_72_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSubTipoConDes1_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "SUBTRANGODESDE_"+sGXsfl_72_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSubTRangoDesde_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "SUBTRANGOHASTA_"+sGXsfl_72_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSubTRangoHasta_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "SUBTDESCULEY_"+sGXsfl_72_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( chkSubTDescuLey.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "SUBTESADICIONAL_"+sGXsfl_72_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( chkSubTEsAdicional.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "SUBTRESTADIAS_"+sGXsfl_72_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( chkSubTRestaDias.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll1R60( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_60 = (short)(0) ;
      nIsMod_60 = (short)(0) ;
      nRcdDeleted_60 = (short)(0) ;
   }

   public void processLevel1R59( )
   {
      /* Save parent mode. */
      sMode59 = Gx_mode ;
      processNestedLevel1R60( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode59 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
   }

   public void endLevel1R59( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(4);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1R59( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "tipodeconcepto");
         if ( AnyError == 0 )
         {
            confirmValues1R0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "tipodeconcepto");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart1R59( )
   {
      /* Scan By routine */
      /* Using cursor T001R21 */
      pr_default.execute(19);
      RcdFound59 = (short)(0) ;
      if ( (pr_default.getStatus(19) != 101) )
      {
         RcdFound59 = (short)(1) ;
         A37TipoConCod = T001R21_A37TipoConCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A37TipoConCod", A37TipoConCod);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1R59( )
   {
      /* Scan next routine */
      pr_default.readNext(19);
      RcdFound59 = (short)(0) ;
      if ( (pr_default.getStatus(19) != 101) )
      {
         RcdFound59 = (short)(1) ;
         A37TipoConCod = T001R21_A37TipoConCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A37TipoConCod", A37TipoConCod);
      }
   }

   public void scanEnd1R59( )
   {
      pr_default.close(19);
   }

   public void afterConfirm1R59( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1R59( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1R59( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1R59( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1R59( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1R59( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1R59( )
   {
      cmbTipoConCod.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbTipoConCod.getInternalname(), "Enabled", GXutil.ltrimstr( cmbTipoConCod.getEnabled(), 5, 0), true);
      edtTipoConDescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTipoConDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTipoConDescrip_Enabled), 5, 0), true);
      edtTRangoDesde_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTRangoDesde_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTRangoDesde_Enabled), 5, 0), true);
      edtTRangoHasta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTRangoHasta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTRangoHasta_Enabled), 5, 0), true);
      edtTipoConOrden_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTipoConOrden_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTipoConOrden_Enabled), 5, 0), true);
      edtTipoConPalabra_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTipoConPalabra_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTipoConPalabra_Enabled), 5, 0), true);
      edtTipoConPai_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTipoConPai_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTipoConPai_Enabled), 5, 0), true);
      cmbTipoConTipo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbTipoConTipo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbTipoConTipo.getEnabled(), 5, 0), true);
      edtavCombotipoconpai_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombotipoconpai_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombotipoconpai_Enabled), 5, 0), true);
   }

   public void zm1R60( int GX_JID )
   {
      if ( ( GX_JID == 14 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z371SubTipoConDes1 = T001R5_A371SubTipoConDes1[0] ;
            Z375SubTRangoDesde = T001R5_A375SubTRangoDesde[0] ;
            Z376SubTRangoHasta = T001R5_A376SubTRangoHasta[0] ;
            Z740SubTDescuLey = T001R5_A740SubTDescuLey[0] ;
            Z1027SubTEsAdicional = T001R5_A1027SubTEsAdicional[0] ;
            Z2134SubTRestaDias = T001R5_A2134SubTRestaDias[0] ;
         }
         else
         {
            Z371SubTipoConDes1 = A371SubTipoConDes1 ;
            Z375SubTRangoDesde = A375SubTRangoDesde ;
            Z376SubTRangoHasta = A376SubTRangoHasta ;
            Z740SubTDescuLey = A740SubTDescuLey ;
            Z1027SubTEsAdicional = A1027SubTEsAdicional ;
            Z2134SubTRestaDias = A2134SubTRestaDias ;
         }
      }
      if ( GX_JID == -14 )
      {
         Z37TipoConCod = A37TipoConCod ;
         Z38SubTipoConCod1 = A38SubTipoConCod1 ;
         Z371SubTipoConDes1 = A371SubTipoConDes1 ;
         Z375SubTRangoDesde = A375SubTRangoDesde ;
         Z376SubTRangoHasta = A376SubTRangoHasta ;
         Z740SubTDescuLey = A740SubTDescuLey ;
         Z1027SubTEsAdicional = A1027SubTEsAdicional ;
         Z2134SubTRestaDias = A2134SubTRestaDias ;
      }
   }

   public void standaloneNotModal1R60( )
   {
   }

   public void standaloneModal1R60( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtSubTipoConCod1_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSubTipoConCod1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSubTipoConCod1_Enabled), 5, 0), !bGXsfl_72_Refreshing);
      }
      else
      {
         edtSubTipoConCod1_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSubTipoConCod1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSubTipoConCod1_Enabled), 5, 0), !bGXsfl_72_Refreshing);
      }
   }

   public void load1R60( )
   {
      /* Using cursor T001R22 */
      pr_default.execute(20, new Object[] {A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1});
      if ( (pr_default.getStatus(20) != 101) )
      {
         RcdFound60 = (short)(1) ;
         A371SubTipoConDes1 = T001R22_A371SubTipoConDes1[0] ;
         A375SubTRangoDesde = T001R22_A375SubTRangoDesde[0] ;
         A376SubTRangoHasta = T001R22_A376SubTRangoHasta[0] ;
         A740SubTDescuLey = T001R22_A740SubTDescuLey[0] ;
         A1027SubTEsAdicional = T001R22_A1027SubTEsAdicional[0] ;
         A2134SubTRestaDias = T001R22_A2134SubTRestaDias[0] ;
         zm1R60( -14) ;
      }
      pr_default.close(20);
      onLoadActions1R60( ) ;
   }

   public void onLoadActions1R60( )
   {
   }

   public void checkExtendedTable1R60( )
   {
      nIsDirty_60 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal1R60( ) ;
   }

   public void closeExtendedTableCursors1R60( )
   {
   }

   public void enableDisable1R60( )
   {
   }

   public void getKey1R60( )
   {
      /* Using cursor T001R23 */
      pr_default.execute(21, new Object[] {A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1});
      if ( (pr_default.getStatus(21) != 101) )
      {
         RcdFound60 = (short)(1) ;
      }
      else
      {
         RcdFound60 = (short)(0) ;
      }
      pr_default.close(21);
   }

   public void getByPrimaryKey1R60( )
   {
      /* Using cursor T001R5 */
      pr_default.execute(3, new Object[] {A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1});
      if ( (pr_default.getStatus(3) != 101) )
      {
         zm1R60( 14) ;
         RcdFound60 = (short)(1) ;
         initializeNonKey1R60( ) ;
         A38SubTipoConCod1 = T001R5_A38SubTipoConCod1[0] ;
         n38SubTipoConCod1 = T001R5_n38SubTipoConCod1[0] ;
         A371SubTipoConDes1 = T001R5_A371SubTipoConDes1[0] ;
         A375SubTRangoDesde = T001R5_A375SubTRangoDesde[0] ;
         A376SubTRangoHasta = T001R5_A376SubTRangoHasta[0] ;
         A740SubTDescuLey = T001R5_A740SubTDescuLey[0] ;
         A1027SubTEsAdicional = T001R5_A1027SubTEsAdicional[0] ;
         A2134SubTRestaDias = T001R5_A2134SubTRestaDias[0] ;
         Z37TipoConCod = A37TipoConCod ;
         Z38SubTipoConCod1 = A38SubTipoConCod1 ;
         sMode60 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load1R60( ) ;
         Gx_mode = sMode60 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound60 = (short)(0) ;
         initializeNonKey1R60( ) ;
         sMode60 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal1R60( ) ;
         Gx_mode = sMode60 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes1R60( ) ;
      }
      pr_default.close(3);
   }

   public void checkOptimisticConcurrency1R60( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T001R4 */
         pr_default.execute(2, new Object[] {A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1});
         if ( (pr_default.getStatus(2) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"TipoDeConceptoSubtipo1"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(2) == 101) || ( GXutil.strcmp(Z371SubTipoConDes1, T001R4_A371SubTipoConDes1[0]) != 0 ) || ( Z375SubTRangoDesde != T001R4_A375SubTRangoDesde[0] ) || ( Z376SubTRangoHasta != T001R4_A376SubTRangoHasta[0] ) || ( Z740SubTDescuLey != T001R4_A740SubTDescuLey[0] ) || ( Z1027SubTEsAdicional != T001R4_A1027SubTEsAdicional[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z2134SubTRestaDias != T001R4_A2134SubTRestaDias[0] ) )
         {
            if ( GXutil.strcmp(Z371SubTipoConDes1, T001R4_A371SubTipoConDes1[0]) != 0 )
            {
               GXutil.writeLogln("tipodeconcepto:[seudo value changed for attri]"+"SubTipoConDes1");
               GXutil.writeLogRaw("Old: ",Z371SubTipoConDes1);
               GXutil.writeLogRaw("Current: ",T001R4_A371SubTipoConDes1[0]);
            }
            if ( Z375SubTRangoDesde != T001R4_A375SubTRangoDesde[0] )
            {
               GXutil.writeLogln("tipodeconcepto:[seudo value changed for attri]"+"SubTRangoDesde");
               GXutil.writeLogRaw("Old: ",Z375SubTRangoDesde);
               GXutil.writeLogRaw("Current: ",T001R4_A375SubTRangoDesde[0]);
            }
            if ( Z376SubTRangoHasta != T001R4_A376SubTRangoHasta[0] )
            {
               GXutil.writeLogln("tipodeconcepto:[seudo value changed for attri]"+"SubTRangoHasta");
               GXutil.writeLogRaw("Old: ",Z376SubTRangoHasta);
               GXutil.writeLogRaw("Current: ",T001R4_A376SubTRangoHasta[0]);
            }
            if ( Z740SubTDescuLey != T001R4_A740SubTDescuLey[0] )
            {
               GXutil.writeLogln("tipodeconcepto:[seudo value changed for attri]"+"SubTDescuLey");
               GXutil.writeLogRaw("Old: ",Z740SubTDescuLey);
               GXutil.writeLogRaw("Current: ",T001R4_A740SubTDescuLey[0]);
            }
            if ( Z1027SubTEsAdicional != T001R4_A1027SubTEsAdicional[0] )
            {
               GXutil.writeLogln("tipodeconcepto:[seudo value changed for attri]"+"SubTEsAdicional");
               GXutil.writeLogRaw("Old: ",Z1027SubTEsAdicional);
               GXutil.writeLogRaw("Current: ",T001R4_A1027SubTEsAdicional[0]);
            }
            if ( Z2134SubTRestaDias != T001R4_A2134SubTRestaDias[0] )
            {
               GXutil.writeLogln("tipodeconcepto:[seudo value changed for attri]"+"SubTRestaDias");
               GXutil.writeLogRaw("Old: ",Z2134SubTRestaDias);
               GXutil.writeLogRaw("Current: ",T001R4_A2134SubTRestaDias[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"TipoDeConceptoSubtipo1"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1R60( )
   {
      beforeValidate1R60( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1R60( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1R60( 0) ;
         checkOptimisticConcurrency1R60( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1R60( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1R60( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001R24 */
                  pr_default.execute(22, new Object[] {A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1, A371SubTipoConDes1, Integer.valueOf(A375SubTRangoDesde), Integer.valueOf(A376SubTRangoHasta), Boolean.valueOf(A740SubTDescuLey), Boolean.valueOf(A1027SubTEsAdicional), Boolean.valueOf(A2134SubTRestaDias)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConceptoSubtipo1");
                  if ( (pr_default.getStatus(22) == 1) )
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
                        processLevel1R60( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
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
            load1R60( ) ;
         }
         endLevel1R60( ) ;
      }
      closeExtendedTableCursors1R60( ) ;
   }

   public void update1R60( )
   {
      beforeValidate1R60( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1R60( ) ;
      }
      if ( ( nIsMod_60 != 0 ) || ( nIsDirty_60 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency1R60( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm1R60( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate1R60( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T001R25 */
                     pr_default.execute(23, new Object[] {A371SubTipoConDes1, Integer.valueOf(A375SubTRangoDesde), Integer.valueOf(A376SubTRangoHasta), Boolean.valueOf(A740SubTDescuLey), Boolean.valueOf(A1027SubTEsAdicional), Boolean.valueOf(A2134SubTRestaDias), A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConceptoSubtipo1");
                     if ( (pr_default.getStatus(23) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"TipoDeConceptoSubtipo1"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate1R60( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           processLevel1R60( ) ;
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
            endLevel1R60( ) ;
         }
      }
      closeExtendedTableCursors1R60( ) ;
   }

   public void deferredUpdate1R60( )
   {
   }

   public void delete1R60( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate1R60( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1R60( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1R60( ) ;
         afterConfirm1R60( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1R60( ) ;
            if ( AnyError == 0 )
            {
               scanStart1R61( ) ;
               while ( RcdFound61 != 0 )
               {
                  getByPrimaryKey1R61( ) ;
                  delete1R61( ) ;
                  scanNext1R61( ) ;
               }
               scanEnd1R61( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001R26 */
                  pr_default.execute(24, new Object[] {A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConceptoSubtipo1");
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
      }
      sMode60 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1R60( ) ;
      Gx_mode = sMode60 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1R60( )
   {
      standaloneModal1R60( ) ;
      /* No delete mode formulas found. */
      if ( AnyError == 0 )
      {
         /* Using cursor T001R27 */
         pr_default.execute(25, new Object[] {A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1});
         if ( (pr_default.getStatus(25) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(25);
      }
   }

   public void processNestedLevel1R61( )
   {
      nGXsfl_117_idx = 0 ;
      while ( nGXsfl_117_idx < nRC_GXsfl_117 )
      {
         readRow1R61( ) ;
         if ( ( nRcdExists_61 != 0 ) || ( nIsMod_61 != 0 ) )
         {
            standaloneNotModal1R61( ) ;
            getKey1R61( ) ;
            if ( ( nRcdExists_61 == 0 ) && ( nRcdDeleted_61 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert1R61( ) ;
            }
            else
            {
               if ( RcdFound61 != 0 )
               {
                  if ( ( nRcdDeleted_61 != 0 ) && ( nRcdExists_61 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete1R61( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_61 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update1R61( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_61 == 0 )
                  {
                     GXCCtl = "SUBTIPOCONCOD1_" + sGXsfl_72_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtSubTipoConCod1_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtSubTipoConCod2_Internalname, GXutil.rtrim( A39SubTipoConCod2)) ;
         httpContext.changePostValue( edtSubTipoConDes2_Internalname, A372SubTipoConDes2) ;
         httpContext.changePostValue( "ZT_"+"Z39SubTipoConCod2_"+sGXsfl_117_idx, GXutil.rtrim( Z39SubTipoConCod2)) ;
         httpContext.changePostValue( "ZT_"+"Z372SubTipoConDes2_"+sGXsfl_117_idx, Z372SubTipoConDes2) ;
         httpContext.changePostValue( "nRcdDeleted_61_"+sGXsfl_117_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_61, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_61_"+sGXsfl_117_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_61, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_61_"+sGXsfl_117_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_61, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_61 != 0 )
         {
            httpContext.changePostValue( "SUBTIPOCONCOD2_"+sGXsfl_117_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSubTipoConCod2_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "SUBTIPOCONDES2_"+sGXsfl_117_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSubTipoConDes2_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll1R61( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_61 = (short)(0) ;
      nIsMod_61 = (short)(0) ;
      nRcdDeleted_61 = (short)(0) ;
   }

   public void processLevel1R60( )
   {
      /* Save parent mode. */
      sMode60 = Gx_mode ;
      processNestedLevel1R61( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode60 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
   }

   public void endLevel1R60( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(2);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart1R60( )
   {
      /* Scan By routine */
      /* Using cursor T001R28 */
      pr_default.execute(26, new Object[] {A37TipoConCod});
      RcdFound60 = (short)(0) ;
      if ( (pr_default.getStatus(26) != 101) )
      {
         RcdFound60 = (short)(1) ;
         A38SubTipoConCod1 = T001R28_A38SubTipoConCod1[0] ;
         n38SubTipoConCod1 = T001R28_n38SubTipoConCod1[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1R60( )
   {
      /* Scan next routine */
      pr_default.readNext(26);
      RcdFound60 = (short)(0) ;
      if ( (pr_default.getStatus(26) != 101) )
      {
         RcdFound60 = (short)(1) ;
         A38SubTipoConCod1 = T001R28_A38SubTipoConCod1[0] ;
         n38SubTipoConCod1 = T001R28_n38SubTipoConCod1[0] ;
      }
   }

   public void scanEnd1R60( )
   {
      pr_default.close(26);
   }

   public void afterConfirm1R60( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1R60( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1R60( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1R60( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1R60( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1R60( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1R60( )
   {
      edtSubTipoConCod1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSubTipoConCod1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSubTipoConCod1_Enabled), 5, 0), !bGXsfl_72_Refreshing);
      edtSubTipoConDes1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSubTipoConDes1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSubTipoConDes1_Enabled), 5, 0), !bGXsfl_72_Refreshing);
      edtSubTRangoDesde_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSubTRangoDesde_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSubTRangoDesde_Enabled), 5, 0), !bGXsfl_72_Refreshing);
      edtSubTRangoHasta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSubTRangoHasta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSubTRangoHasta_Enabled), 5, 0), !bGXsfl_72_Refreshing);
      chkSubTDescuLey.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkSubTDescuLey.getInternalname(), "Enabled", GXutil.ltrimstr( chkSubTDescuLey.getEnabled(), 5, 0), !bGXsfl_72_Refreshing);
      chkSubTEsAdicional.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkSubTEsAdicional.getInternalname(), "Enabled", GXutil.ltrimstr( chkSubTEsAdicional.getEnabled(), 5, 0), !bGXsfl_72_Refreshing);
      chkSubTRestaDias.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkSubTRestaDias.getInternalname(), "Enabled", GXutil.ltrimstr( chkSubTRestaDias.getEnabled(), 5, 0), !bGXsfl_72_Refreshing);
   }

   public void zm1R61( int GX_JID )
   {
      if ( ( GX_JID == 15 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z372SubTipoConDes2 = T001R3_A372SubTipoConDes2[0] ;
         }
         else
         {
            Z372SubTipoConDes2 = A372SubTipoConDes2 ;
         }
      }
      if ( GX_JID == -15 )
      {
         Z37TipoConCod = A37TipoConCod ;
         Z38SubTipoConCod1 = A38SubTipoConCod1 ;
         Z39SubTipoConCod2 = A39SubTipoConCod2 ;
         Z372SubTipoConDes2 = A372SubTipoConDes2 ;
      }
   }

   public void standaloneNotModal1R61( )
   {
      edtSubTipoConCod2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSubTipoConCod2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSubTipoConCod2_Enabled), 5, 0), !bGXsfl_117_Refreshing);
   }

   public void standaloneModal1R61( )
   {
   }

   public void load1R61( )
   {
      /* Using cursor T001R29 */
      pr_default.execute(27, new Object[] {A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1, Boolean.valueOf(n39SubTipoConCod2), A39SubTipoConCod2});
      if ( (pr_default.getStatus(27) != 101) )
      {
         RcdFound61 = (short)(1) ;
         A372SubTipoConDes2 = T001R29_A372SubTipoConDes2[0] ;
         zm1R61( -15) ;
      }
      pr_default.close(27);
      onLoadActions1R61( ) ;
   }

   public void onLoadActions1R61( )
   {
   }

   public void checkExtendedTable1R61( )
   {
      nIsDirty_61 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal1R61( ) ;
   }

   public void closeExtendedTableCursors1R61( )
   {
   }

   public void enableDisable1R61( )
   {
   }

   public void getKey1R61( )
   {
      /* Using cursor T001R30 */
      pr_default.execute(28, new Object[] {A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1, Boolean.valueOf(n39SubTipoConCod2), A39SubTipoConCod2});
      if ( (pr_default.getStatus(28) != 101) )
      {
         RcdFound61 = (short)(1) ;
      }
      else
      {
         RcdFound61 = (short)(0) ;
      }
      pr_default.close(28);
   }

   public void getByPrimaryKey1R61( )
   {
      /* Using cursor T001R3 */
      pr_default.execute(1, new Object[] {A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1, Boolean.valueOf(n39SubTipoConCod2), A39SubTipoConCod2});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm1R61( 15) ;
         RcdFound61 = (short)(1) ;
         initializeNonKey1R61( ) ;
         A39SubTipoConCod2 = T001R3_A39SubTipoConCod2[0] ;
         n39SubTipoConCod2 = T001R3_n39SubTipoConCod2[0] ;
         A372SubTipoConDes2 = T001R3_A372SubTipoConDes2[0] ;
         Z37TipoConCod = A37TipoConCod ;
         Z38SubTipoConCod1 = A38SubTipoConCod1 ;
         Z39SubTipoConCod2 = A39SubTipoConCod2 ;
         sMode61 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load1R61( ) ;
         Gx_mode = sMode61 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound61 = (short)(0) ;
         initializeNonKey1R61( ) ;
         sMode61 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal1R61( ) ;
         Gx_mode = sMode61 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes1R61( ) ;
      }
      pr_default.close(1);
   }

   public void checkOptimisticConcurrency1R61( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T001R2 */
         pr_default.execute(0, new Object[] {A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1, Boolean.valueOf(n39SubTipoConCod2), A39SubTipoConCod2});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"tipo_concepto_subtipo2"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z372SubTipoConDes2, T001R2_A372SubTipoConDes2[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z372SubTipoConDes2, T001R2_A372SubTipoConDes2[0]) != 0 )
            {
               GXutil.writeLogln("tipodeconcepto:[seudo value changed for attri]"+"SubTipoConDes2");
               GXutil.writeLogRaw("Old: ",Z372SubTipoConDes2);
               GXutil.writeLogRaw("Current: ",T001R2_A372SubTipoConDes2[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"tipo_concepto_subtipo2"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1R61( )
   {
      beforeValidate1R61( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1R61( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1R61( 0) ;
         checkOptimisticConcurrency1R61( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1R61( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1R61( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001R31 */
                  pr_default.execute(29, new Object[] {A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1, Boolean.valueOf(n39SubTipoConCod2), A39SubTipoConCod2, A372SubTipoConDes2});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("tipo_concepto_subtipo2");
                  if ( (pr_default.getStatus(29) == 1) )
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
            load1R61( ) ;
         }
         endLevel1R61( ) ;
      }
      closeExtendedTableCursors1R61( ) ;
   }

   public void update1R61( )
   {
      beforeValidate1R61( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1R61( ) ;
      }
      if ( ( nIsMod_61 != 0 ) || ( nIsDirty_61 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency1R61( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm1R61( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate1R61( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T001R32 */
                     pr_default.execute(30, new Object[] {A372SubTipoConDes2, A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1, Boolean.valueOf(n39SubTipoConCod2), A39SubTipoConCod2});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("tipo_concepto_subtipo2");
                     if ( (pr_default.getStatus(30) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"tipo_concepto_subtipo2"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate1R61( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey1R61( ) ;
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
            endLevel1R61( ) ;
         }
      }
      closeExtendedTableCursors1R61( ) ;
   }

   public void deferredUpdate1R61( )
   {
   }

   public void delete1R61( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate1R61( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1R61( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1R61( ) ;
         afterConfirm1R61( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1R61( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T001R33 */
               pr_default.execute(31, new Object[] {A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1, Boolean.valueOf(n39SubTipoConCod2), A39SubTipoConCod2});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("tipo_concepto_subtipo2");
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
      sMode61 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1R61( ) ;
      Gx_mode = sMode61 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1R61( )
   {
      standaloneModal1R61( ) ;
      /* No delete mode formulas found. */
      if ( AnyError == 0 )
      {
         /* Using cursor T001R34 */
         pr_default.execute(32, new Object[] {A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1, Boolean.valueOf(n39SubTipoConCod2), A39SubTipoConCod2});
         if ( (pr_default.getStatus(32) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(32);
      }
   }

   public void endLevel1R61( )
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

   public void scanStart1R61( )
   {
      /* Scan By routine */
      /* Using cursor T001R35 */
      pr_default.execute(33, new Object[] {A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1});
      RcdFound61 = (short)(0) ;
      if ( (pr_default.getStatus(33) != 101) )
      {
         RcdFound61 = (short)(1) ;
         A39SubTipoConCod2 = T001R35_A39SubTipoConCod2[0] ;
         n39SubTipoConCod2 = T001R35_n39SubTipoConCod2[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1R61( )
   {
      /* Scan next routine */
      pr_default.readNext(33);
      RcdFound61 = (short)(0) ;
      if ( (pr_default.getStatus(33) != 101) )
      {
         RcdFound61 = (short)(1) ;
         A39SubTipoConCod2 = T001R35_A39SubTipoConCod2[0] ;
         n39SubTipoConCod2 = T001R35_n39SubTipoConCod2[0] ;
      }
   }

   public void scanEnd1R61( )
   {
      pr_default.close(33);
   }

   public void afterConfirm1R61( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1R61( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1R61( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1R61( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1R61( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1R61( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1R61( )
   {
      edtSubTipoConCod2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSubTipoConCod2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSubTipoConCod2_Enabled), 5, 0), !bGXsfl_117_Refreshing);
      edtSubTipoConDes2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSubTipoConDes2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSubTipoConDes2_Enabled), 5, 0), !bGXsfl_117_Refreshing);
   }

   public void send_integrity_lvl_hashes1R61( )
   {
   }

   public void send_integrity_lvl_hashes1R60( )
   {
   }

   public void send_integrity_lvl_hashes1R59( )
   {
   }

   public void subsflControlProps_7260( )
   {
      edtSubTipoConCod1_Internalname = "SUBTIPOCONCOD1_"+sGXsfl_72_idx ;
      edtSubTipoConDes1_Internalname = "SUBTIPOCONDES1_"+sGXsfl_72_idx ;
      edtSubTRangoDesde_Internalname = "SUBTRANGODESDE_"+sGXsfl_72_idx ;
      edtSubTRangoHasta_Internalname = "SUBTRANGOHASTA_"+sGXsfl_72_idx ;
      chkSubTDescuLey.setInternalname( "SUBTDESCULEY_"+sGXsfl_72_idx );
      chkSubTEsAdicional.setInternalname( "SUBTESADICIONAL_"+sGXsfl_72_idx );
      chkSubTRestaDias.setInternalname( "SUBTRESTADIAS_"+sGXsfl_72_idx );
      subGridlevel_subtipo2_Internalname = "GRIDLEVEL_SUBTIPO2_"+sGXsfl_72_idx ;
   }

   public void subsflControlProps_fel_7260( )
   {
      edtSubTipoConCod1_Internalname = "SUBTIPOCONCOD1_"+sGXsfl_72_fel_idx ;
      edtSubTipoConDes1_Internalname = "SUBTIPOCONDES1_"+sGXsfl_72_fel_idx ;
      edtSubTRangoDesde_Internalname = "SUBTRANGODESDE_"+sGXsfl_72_fel_idx ;
      edtSubTRangoHasta_Internalname = "SUBTRANGOHASTA_"+sGXsfl_72_fel_idx ;
      chkSubTDescuLey.setInternalname( "SUBTDESCULEY_"+sGXsfl_72_fel_idx );
      chkSubTEsAdicional.setInternalname( "SUBTESADICIONAL_"+sGXsfl_72_fel_idx );
      chkSubTRestaDias.setInternalname( "SUBTRESTADIAS_"+sGXsfl_72_fel_idx );
      subGridlevel_subtipo2_Internalname = "GRIDLEVEL_SUBTIPO2_"+sGXsfl_72_fel_idx ;
   }

   public void addRow1R60( )
   {
      nRC_GXsfl_117 = 0 ;
      nGXsfl_72_idx = (int)(nGXsfl_72_idx+1) ;
      sGXsfl_72_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_72_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_7260( ) ;
      sendRow1R60( ) ;
   }

   public void sendRow1R60( )
   {
      Freestylelevel_subtipo1Row = GXWebRow.GetNew(context) ;
      if ( subFreestylelevel_subtipo1_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subFreestylelevel_subtipo1_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subFreestylelevel_subtipo1_Class, "") != 0 )
         {
            subFreestylelevel_subtipo1_Linesclass = subFreestylelevel_subtipo1_Class+"Odd" ;
         }
      }
      else if ( subFreestylelevel_subtipo1_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subFreestylelevel_subtipo1_Backstyle = (byte)(0) ;
         subFreestylelevel_subtipo1_Backcolor = subFreestylelevel_subtipo1_Allbackcolor ;
         if ( GXutil.strcmp(subFreestylelevel_subtipo1_Class, "") != 0 )
         {
            subFreestylelevel_subtipo1_Linesclass = subFreestylelevel_subtipo1_Class+"Uniform" ;
         }
      }
      else if ( subFreestylelevel_subtipo1_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subFreestylelevel_subtipo1_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subFreestylelevel_subtipo1_Class, "") != 0 )
         {
            subFreestylelevel_subtipo1_Linesclass = subFreestylelevel_subtipo1_Class+"Odd" ;
         }
         subFreestylelevel_subtipo1_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subFreestylelevel_subtipo1_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subFreestylelevel_subtipo1_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_72_idx) % (2))) == 0 )
         {
            subFreestylelevel_subtipo1_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subFreestylelevel_subtipo1_Class, "") != 0 )
            {
               subFreestylelevel_subtipo1_Linesclass = subFreestylelevel_subtipo1_Class+"Even" ;
            }
         }
         else
         {
            subFreestylelevel_subtipo1_Backcolor = (int)(0xFFFFFF) ;
            if ( GXutil.strcmp(subFreestylelevel_subtipo1_Class, "") != 0 )
            {
               subFreestylelevel_subtipo1_Linesclass = subFreestylelevel_subtipo1_Class+"Odd" ;
            }
         }
      }
      /* Start of Columns property logic. */
      if ( Freestylelevel_subtipo1Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<tr"+" class=\""+subFreestylelevel_subtipo1_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_72_idx+"\">") ;
      }
      if ( FREESTYLELEVEL_SUBTIPO1_IsPaging == 0 )
      {
         GXCCtl = "GRIDLEVEL_SUBTIPO2_nFirstRecordOnPage_" + sGXsfl_72_idx ;
         GRIDLEVEL_SUBTIPO2_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      }
      else
      {
         GRIDLEVEL_SUBTIPO2_nFirstRecordOnPage = 0 ;
      }
      /* Table start */
      Freestylelevel_subtipo1Row.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblUnnamedtablefsfreestylelevel_subtipo1_Internalname+"_"+sGXsfl_72_idx,Integer.valueOf(1),"Table","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
      Freestylelevel_subtipo1Row.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      Freestylelevel_subtipo1Row.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Div Control */
      Freestylelevel_subtipo1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTableintermediateinslevel_subtipo1_Internalname+"_"+sGXsfl_72_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","","div"});
      /* Div Control */
      Freestylelevel_subtipo1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Freestylelevel_subtipo1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 DataContentCell","left","top","","","div"});
      /* Div Control */
      Freestylelevel_subtipo1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtSubTipoConCod1_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      Freestylelevel_subtipo1Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtSubTipoConCod1_Internalname,httpContext.getMessage( "Clasificación", ""),"col-sm-3 AttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      Freestylelevel_subtipo1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-sm-9 gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_60_" + sGXsfl_72_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 81,'',false,'" + sGXsfl_72_idx + "',72)\"" ;
      ROClassString = "Attribute" ;
      Freestylelevel_subtipo1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSubTipoConCod1_Internalname,GXutil.rtrim( A38SubTipoConCod1),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,81);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSubTipoConCod1_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtSubTipoConCod1_Enabled),Integer.valueOf(1),"text","",Integer.valueOf(20),"chr",Integer.valueOf(1),"row",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(72),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      Freestylelevel_subtipo1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_subtipo1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_subtipo1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_subtipo1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Freestylelevel_subtipo1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Freestylelevel_subtipo1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 DataContentCell","left","top","","","div"});
      /* Div Control */
      Freestylelevel_subtipo1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtSubTipoConDes1_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      Freestylelevel_subtipo1Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtSubTipoConDes1_Internalname,httpContext.getMessage( "Descripción", ""),"col-sm-3 AttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      Freestylelevel_subtipo1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-sm-9 gx-attribute","left","top","","","div"});
      /* Multiple line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_60_" + sGXsfl_72_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 86,'',false,'" + sGXsfl_72_idx + "',72)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      Freestylelevel_subtipo1Row.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtSubTipoConDes1_Internalname,A371SubTipoConDes1,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,86);\"",Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(edtSubTipoConDes1_Enabled),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(5),"row",Integer.valueOf(0),StyleString,ClassString,"","","400",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
      Freestylelevel_subtipo1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_subtipo1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_subtipo1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_subtipo1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Freestylelevel_subtipo1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Freestylelevel_subtipo1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 DataContentCell","left","top","","","div"});
      /* Div Control */
      Freestylelevel_subtipo1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtSubTRangoDesde_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      Freestylelevel_subtipo1Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtSubTRangoDesde_Internalname,httpContext.getMessage( "Rango de códigos de AFIP Desde", ""),"col-sm-3 AttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      Freestylelevel_subtipo1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-sm-9 gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_60_" + sGXsfl_72_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 91,'',false,'" + sGXsfl_72_idx + "',72)\"" ;
      ROClassString = "Attribute" ;
      Freestylelevel_subtipo1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSubTRangoDesde_Internalname,GXutil.ltrim( localUtil.ntoc( A375SubTRangoDesde, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtSubTRangoDesde_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A375SubTRangoDesde), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A375SubTRangoDesde), "ZZZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,91);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSubTRangoDesde_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtSubTRangoDesde_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(8),"chr",Integer.valueOf(1),"row",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(72),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      Freestylelevel_subtipo1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_subtipo1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_subtipo1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_subtipo1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Freestylelevel_subtipo1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Freestylelevel_subtipo1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 DataContentCell","left","top","","","div"});
      /* Div Control */
      Freestylelevel_subtipo1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtSubTRangoHasta_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      Freestylelevel_subtipo1Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtSubTRangoHasta_Internalname,httpContext.getMessage( "Rango de códigos de AFIP Hasta", ""),"col-sm-3 AttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      Freestylelevel_subtipo1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-sm-9 gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_60_" + sGXsfl_72_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 96,'',false,'" + sGXsfl_72_idx + "',72)\"" ;
      ROClassString = "Attribute" ;
      Freestylelevel_subtipo1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSubTRangoHasta_Internalname,GXutil.ltrim( localUtil.ntoc( A376SubTRangoHasta, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtSubTRangoHasta_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A376SubTRangoHasta), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A376SubTRangoHasta), "ZZZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,96);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSubTRangoHasta_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtSubTRangoHasta_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(8),"chr",Integer.valueOf(1),"row",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(72),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      Freestylelevel_subtipo1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_subtipo1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_subtipo1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_subtipo1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Freestylelevel_subtipo1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Freestylelevel_subtipo1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 DataContentCell","left","top","","","div"});
      /* Div Control */
      Freestylelevel_subtipo1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+chkSubTDescuLey.getInternalname()+"\"","","div"});
      /* Attribute/Variable Label */
      Freestylelevel_subtipo1Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {chkSubTDescuLey.getInternalname(),httpContext.getMessage( "Descuento de Ley", ""),"col-sm-3 AttributeCheckBoxLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      Freestylelevel_subtipo1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-sm-9 gx-attribute","left","top","","","div"});
      /* Check box */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_60_" + sGXsfl_72_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 101,'',false,'" + sGXsfl_72_idx + "',72)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      GXCCtl = "SUBTDESCULEY_" + sGXsfl_72_idx ;
      chkSubTDescuLey.setName( GXCCtl );
      chkSubTDescuLey.setWebtags( "" );
      chkSubTDescuLey.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkSubTDescuLey.getInternalname(), "TitleCaption", chkSubTDescuLey.getCaption(), !bGXsfl_72_Refreshing);
      chkSubTDescuLey.setCheckedValue( "false" );
      A740SubTDescuLey = GXutil.strtobool( GXutil.booltostr( A740SubTDescuLey)) ;
      Freestylelevel_subtipo1Row.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkSubTDescuLey.getInternalname(),GXutil.booltostr( A740SubTDescuLey),"",httpContext.getMessage( "Descuento de Ley", ""),Integer.valueOf(1),Integer.valueOf(chkSubTDescuLey.getEnabled()),"true","",StyleString,ClassString,"","",TempTags+" onclick="+"\"gx.fn.checkboxClick(101, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,101);\""});
      Freestylelevel_subtipo1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_subtipo1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_subtipo1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_subtipo1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Freestylelevel_subtipo1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Freestylelevel_subtipo1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 DataContentCell","left","top","","","div"});
      /* Div Control */
      Freestylelevel_subtipo1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+chkSubTEsAdicional.getInternalname()+"\"","","div"});
      /* Attribute/Variable Label */
      Freestylelevel_subtipo1Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {chkSubTEsAdicional.getInternalname(),httpContext.getMessage( "Es adicional (no forma parte de la jornada básica)", ""),"col-sm-3 AttributeCheckBoxLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      Freestylelevel_subtipo1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-sm-9 gx-attribute","left","top","","","div"});
      /* Check box */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_60_" + sGXsfl_72_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 106,'',false,'" + sGXsfl_72_idx + "',72)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      GXCCtl = "SUBTESADICIONAL_" + sGXsfl_72_idx ;
      chkSubTEsAdicional.setName( GXCCtl );
      chkSubTEsAdicional.setWebtags( "" );
      chkSubTEsAdicional.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkSubTEsAdicional.getInternalname(), "TitleCaption", chkSubTEsAdicional.getCaption(), !bGXsfl_72_Refreshing);
      chkSubTEsAdicional.setCheckedValue( "false" );
      A1027SubTEsAdicional = GXutil.strtobool( GXutil.booltostr( A1027SubTEsAdicional)) ;
      Freestylelevel_subtipo1Row.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkSubTEsAdicional.getInternalname(),GXutil.booltostr( A1027SubTEsAdicional),"",httpContext.getMessage( "Es adicional (no forma parte de la jornada básica)", ""),Integer.valueOf(1),Integer.valueOf(chkSubTEsAdicional.getEnabled()),"true","",StyleString,ClassString,"","",TempTags+" onclick="+"\"gx.fn.checkboxClick(106, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,106);\""});
      Freestylelevel_subtipo1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_subtipo1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_subtipo1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_subtipo1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Freestylelevel_subtipo1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Freestylelevel_subtipo1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 DataContentCell","left","top","","","div"});
      /* Div Control */
      Freestylelevel_subtipo1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+chkSubTRestaDias.getInternalname()+"\"","","div"});
      /* Attribute/Variable Label */
      Freestylelevel_subtipo1Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {chkSubTRestaDias.getInternalname(),httpContext.getMessage( "Resta días trabajados cuando el importe es negativo", ""),"col-sm-3 AttributeCheckBoxLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      Freestylelevel_subtipo1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-sm-9 gx-attribute","left","top","","","div"});
      /* Check box */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_60_" + sGXsfl_72_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 111,'',false,'" + sGXsfl_72_idx + "',72)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      GXCCtl = "SUBTRESTADIAS_" + sGXsfl_72_idx ;
      chkSubTRestaDias.setName( GXCCtl );
      chkSubTRestaDias.setWebtags( "" );
      chkSubTRestaDias.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkSubTRestaDias.getInternalname(), "TitleCaption", chkSubTRestaDias.getCaption(), !bGXsfl_72_Refreshing);
      chkSubTRestaDias.setCheckedValue( "false" );
      A2134SubTRestaDias = GXutil.strtobool( GXutil.booltostr( A2134SubTRestaDias)) ;
      Freestylelevel_subtipo1Row.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkSubTRestaDias.getInternalname(),GXutil.booltostr( A2134SubTRestaDias),"",httpContext.getMessage( "Resta días trabajados cuando el importe es negativo", ""),Integer.valueOf(1),Integer.valueOf(chkSubTRestaDias.getEnabled()),"true","",StyleString,ClassString,"","",TempTags+" onclick="+"\"gx.fn.checkboxClick(111, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,111);\""});
      Freestylelevel_subtipo1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_subtipo1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_subtipo1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_subtipo1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Freestylelevel_subtipo1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Freestylelevel_subtipo1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-9 CellMarginTop","left","top","","","div"});
      /* Div Control */
      Freestylelevel_subtipo1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTableleaflevel_subtipo2_Internalname+"_"+sGXsfl_72_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","","div"});
      /* Div Control */
      Freestylelevel_subtipo1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Freestylelevel_subtipo1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 SectionGrid GridNoBorderCell","left","top","","","div"});
      /*  Child Grid Control  */
      Freestylelevel_subtipo1Row.AddColumnProperties("subfile", -1, isAjaxCallMode( ), new Object[] {"Gridlevel_subtipo2Container"});
      if ( isAjaxCallMode( ) )
      {
         Gridlevel_subtipo2Container = new com.genexus.webpanels.GXWebGrid(context);
      }
      else
      {
         Gridlevel_subtipo2Container.Clear();
      }
      startgridcontrol117( ) ;
      nGXsfl_117_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount61 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_61 = (short)(1) ;
            scanStart1R61( ) ;
            while ( RcdFound61 != 0 )
            {
               init_level_properties61( ) ;
               getByPrimaryKey1R61( ) ;
               addRow1R61( ) ;
               scanNext1R61( ) ;
            }
            scanEnd1R61( ) ;
            nBlankRcdCount61 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         standaloneNotModal1R61( ) ;
         standaloneModal1R61( ) ;
         sMode61 = Gx_mode ;
         while ( nGXsfl_117_idx < nRC_GXsfl_117 )
         {
            bGXsfl_117_Refreshing = true ;
            readRow1R61( ) ;
            edtSubTipoConCod2_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SUBTIPOCONCOD2_"+sGXsfl_117_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtSubTipoConCod2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSubTipoConCod2_Enabled), 5, 0), !bGXsfl_117_Refreshing);
            edtSubTipoConDes2_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SUBTIPOCONDES2_"+sGXsfl_117_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtSubTipoConDes2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSubTipoConDes2_Enabled), 5, 0), !bGXsfl_117_Refreshing);
            if ( ( nRcdExists_61 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal1R61( ) ;
            }
            sendRow1R61( ) ;
            bGXsfl_117_Refreshing = false ;
         }
         Gx_mode = sMode61 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount61 = (short)(5) ;
         nRcdExists_61 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart1R61( ) ;
            while ( RcdFound61 != 0 )
            {
               sGXsfl_117_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_117_idx+1), 4, 0), (short)(4), "0") + sGXsfl_72_idx ;
               subsflControlProps_11761( ) ;
               init_level_properties61( ) ;
               standaloneNotModal1R61( ) ;
               getByPrimaryKey1R61( ) ;
               standaloneModal1R61( ) ;
               addRow1R61( ) ;
               scanNext1R61( ) ;
            }
            scanEnd1R61( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode61 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_117_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_117_idx+1), 4, 0), (short)(4), "0") + sGXsfl_72_idx ;
         subsflControlProps_11761( ) ;
         initAll1R61( ) ;
         init_level_properties61( ) ;
         nRcdExists_61 = (short)(0) ;
         nIsMod_61 = (short)(0) ;
         nRcdDeleted_61 = (short)(0) ;
         if ( ( CommonUtil.decimalVal( EvtGridId, ".").add(CommonUtil.decimalVal( EvtRowId, ".")).doubleValue() == 0 ) || ( 72 == CommonUtil.decimalVal( EvtGridId, ".").doubleValue() ) && ( DecimalUtil.compareTo(CommonUtil.decimalVal( EvtRowId, "."), CommonUtil.decimalVal( sGXsfl_72_idx, ".")) == 0 ) )
         {
            nBlankRcdCount61 = (short)(nBlankRcdUsr61+nBlankRcdCount61) ;
         }
         fRowAdded = 0 ;
         while ( nBlankRcdCount61 > 0 )
         {
            standaloneNotModal1R61( ) ;
            standaloneModal1R61( ) ;
            addRow1R61( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = edtSubTipoConDes2_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount61 = (short)(nBlankRcdCount61-1) ;
         }
         Gx_mode = sMode61 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( ! isAjaxCallMode( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_subtipo2ContainerData"+"_"+sGXsfl_72_idx, Gridlevel_subtipo2Container.ToJavascriptSource());
      }
      if ( isAjaxCallMode( ) )
      {
         Freestylelevel_subtipo1Row.AddGrid("Gridlevel_subtipo2", Gridlevel_subtipo2Container);
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_subtipo2ContainerData"+"V_"+sGXsfl_72_idx, Gridlevel_subtipo2Container.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel_subtipo2ContainerData"+"V_"+sGXsfl_72_idx+"\" value='"+Gridlevel_subtipo2Container.GridValuesHidden()+"'/>") ;
      }
      Freestylelevel_subtipo1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_subtipo1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_subtipo1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_subtipo1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_subtipo1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_subtipo1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* End of table */
      httpContext.ajax_sending_grid_row(Freestylelevel_subtipo1Row);
      send_integrity_lvl_hashes1R60( ) ;
      GXCCtl = "Z38SubTipoConCod1_" + sGXsfl_72_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Z38SubTipoConCod1));
      GXCCtl = "Z371SubTipoConDes1_" + sGXsfl_72_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, Z371SubTipoConDes1);
      GXCCtl = "Z375SubTRangoDesde_" + sGXsfl_72_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z375SubTRangoDesde, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z376SubTRangoHasta_" + sGXsfl_72_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z376SubTRangoHasta, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z740SubTDescuLey_" + sGXsfl_72_idx ;
      web.GxWebStd.gx_boolean_hidden_field( httpContext, GXCCtl, Z740SubTDescuLey);
      GXCCtl = "Z1027SubTEsAdicional_" + sGXsfl_72_idx ;
      web.GxWebStd.gx_boolean_hidden_field( httpContext, GXCCtl, Z1027SubTEsAdicional);
      GXCCtl = "Z2134SubTRestaDias_" + sGXsfl_72_idx ;
      web.GxWebStd.gx_boolean_hidden_field( httpContext, GXCCtl, Z2134SubTRestaDias);
      GXCCtl = "nRC_GXsfl_117_" + sGXsfl_72_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nGXsfl_117_idx, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdDeleted_60_" + sGXsfl_72_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_60, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdExists_60_" + sGXsfl_72_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_60, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nIsMod_60_" + sGXsfl_72_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_60, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vMODE_" + sGXsfl_72_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Gx_mode));
      GXCCtl = "vTIPOCONCOD_" + sGXsfl_72_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( AV7TipoConCod));
      web.GxWebStd.gx_hidden_field( httpContext, "SUBTIPOCONCOD1_"+sGXsfl_72_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSubTipoConCod1_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "SUBTIPOCONDES1_"+sGXsfl_72_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSubTipoConDes1_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "SUBTRANGODESDE_"+sGXsfl_72_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSubTRangoDesde_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "SUBTRANGOHASTA_"+sGXsfl_72_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSubTRangoHasta_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "SUBTDESCULEY_"+sGXsfl_72_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( chkSubTDescuLey.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "SUBTESADICIONAL_"+sGXsfl_72_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( chkSubTEsAdicional.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "SUBTRESTADIAS_"+sGXsfl_72_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( chkSubTRestaDias.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      GRIDLEVEL_SUBTIPO2_nFirstRecordOnPage = 0 ;
      GRIDLEVEL_SUBTIPO2_nCurrentRecord = 0 ;
      /* End of Columns property logic. */
      Freestylelevel_subtipo1Container.AddRow(Freestylelevel_subtipo1Row);
   }

   public void readRow1R60( )
   {
      nGXsfl_72_idx = (int)(nGXsfl_72_idx+1) ;
      sGXsfl_72_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_72_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_7260( ) ;
      edtSubTipoConCod1_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SUBTIPOCONCOD1_"+sGXsfl_72_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtSubTipoConDes1_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SUBTIPOCONDES1_"+sGXsfl_72_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtSubTRangoDesde_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SUBTRANGODESDE_"+sGXsfl_72_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtSubTRangoHasta_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SUBTRANGOHASTA_"+sGXsfl_72_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      chkSubTDescuLey.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "SUBTDESCULEY_"+sGXsfl_72_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
      chkSubTEsAdicional.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "SUBTESADICIONAL_"+sGXsfl_72_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
      chkSubTRestaDias.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "SUBTRESTADIAS_"+sGXsfl_72_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
      A38SubTipoConCod1 = httpContext.cgiGet( edtSubTipoConCod1_Internalname) ;
      n38SubTipoConCod1 = false ;
      A371SubTipoConDes1 = httpContext.cgiGet( edtSubTipoConDes1_Internalname) ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtSubTRangoDesde_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtSubTRangoDesde_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
      {
         GXCCtl = "SUBTRANGODESDE_" + sGXsfl_72_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtSubTRangoDesde_Internalname ;
         wbErr = true ;
         A375SubTRangoDesde = 0 ;
      }
      else
      {
         A375SubTRangoDesde = (int)(localUtil.ctol( httpContext.cgiGet( edtSubTRangoDesde_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtSubTRangoHasta_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtSubTRangoHasta_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
      {
         GXCCtl = "SUBTRANGOHASTA_" + sGXsfl_72_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtSubTRangoHasta_Internalname ;
         wbErr = true ;
         A376SubTRangoHasta = 0 ;
      }
      else
      {
         A376SubTRangoHasta = (int)(localUtil.ctol( httpContext.cgiGet( edtSubTRangoHasta_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      A740SubTDescuLey = GXutil.strtobool( httpContext.cgiGet( chkSubTDescuLey.getInternalname())) ;
      A1027SubTEsAdicional = GXutil.strtobool( httpContext.cgiGet( chkSubTEsAdicional.getInternalname())) ;
      A2134SubTRestaDias = GXutil.strtobool( httpContext.cgiGet( chkSubTRestaDias.getInternalname())) ;
      GXCCtl = "Z38SubTipoConCod1_" + sGXsfl_72_idx ;
      Z38SubTipoConCod1 = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z371SubTipoConDes1_" + sGXsfl_72_idx ;
      Z371SubTipoConDes1 = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z375SubTRangoDesde_" + sGXsfl_72_idx ;
      Z375SubTRangoDesde = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z376SubTRangoHasta_" + sGXsfl_72_idx ;
      Z376SubTRangoHasta = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z740SubTDescuLey_" + sGXsfl_72_idx ;
      Z740SubTDescuLey = GXutil.strtobool( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "Z1027SubTEsAdicional_" + sGXsfl_72_idx ;
      Z1027SubTEsAdicional = GXutil.strtobool( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "Z2134SubTRestaDias_" + sGXsfl_72_idx ;
      Z2134SubTRestaDias = GXutil.strtobool( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "nRC_GXsfl_117_" + sGXsfl_72_idx ;
      nRC_GXsfl_117 = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdDeleted_60_" + sGXsfl_72_idx ;
      nRcdDeleted_60 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdExists_60_" + sGXsfl_72_idx ;
      nRcdExists_60 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nIsMod_60_" + sGXsfl_72_idx ;
      nIsMod_60 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRC_GXsfl_117_" + sGXsfl_72_idx ;
      nRC_GXsfl_117 = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
   }

   public void subsflControlProps_11761( )
   {
      edtSubTipoConCod2_Internalname = "SUBTIPOCONCOD2_"+sGXsfl_117_idx ;
      edtSubTipoConDes2_Internalname = "SUBTIPOCONDES2_"+sGXsfl_117_idx ;
   }

   public void subsflControlProps_fel_11761( )
   {
      edtSubTipoConCod2_Internalname = "SUBTIPOCONCOD2_"+sGXsfl_117_fel_idx ;
      edtSubTipoConDes2_Internalname = "SUBTIPOCONDES2_"+sGXsfl_117_fel_idx ;
   }

   public void addRow1R61( )
   {
      nGXsfl_117_idx = (int)(nGXsfl_117_idx+1) ;
      sGXsfl_117_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_117_idx), 4, 0), (short)(4), "0") + sGXsfl_72_idx ;
      subsflControlProps_11761( ) ;
      sendRow1R61( ) ;
   }

   public void sendRow1R61( )
   {
      Gridlevel_subtipo2Row = GXWebRow.GetNew(context) ;
      if ( subGridlevel_subtipo2_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridlevel_subtipo2_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridlevel_subtipo2_Class, "") != 0 )
         {
            subGridlevel_subtipo2_Linesclass = subGridlevel_subtipo2_Class+"Odd" ;
         }
      }
      else if ( subGridlevel_subtipo2_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridlevel_subtipo2_Backstyle = (byte)(0) ;
         subGridlevel_subtipo2_Backcolor = subGridlevel_subtipo2_Allbackcolor ;
         if ( GXutil.strcmp(subGridlevel_subtipo2_Class, "") != 0 )
         {
            subGridlevel_subtipo2_Linesclass = subGridlevel_subtipo2_Class+"Uniform" ;
         }
      }
      else if ( subGridlevel_subtipo2_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridlevel_subtipo2_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridlevel_subtipo2_Class, "") != 0 )
         {
            subGridlevel_subtipo2_Linesclass = subGridlevel_subtipo2_Class+"Odd" ;
         }
         subGridlevel_subtipo2_Backcolor = (int)(0x0) ;
      }
      else if ( subGridlevel_subtipo2_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridlevel_subtipo2_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_117_idx) % (2))) == 0 )
         {
            subGridlevel_subtipo2_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_subtipo2_Class, "") != 0 )
            {
               subGridlevel_subtipo2_Linesclass = subGridlevel_subtipo2_Class+"Even" ;
            }
         }
         else
         {
            subGridlevel_subtipo2_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_subtipo2_Class, "") != 0 )
            {
               subGridlevel_subtipo2_Linesclass = subGridlevel_subtipo2_Class+"Odd" ;
            }
         }
      }
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "Attribute" ;
      Gridlevel_subtipo2Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSubTipoConCod2_Internalname,GXutil.rtrim( A39SubTipoConCod2),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSubTipoConCod2_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(0),Integer.valueOf(edtSubTipoConCod2_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(117),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_61_" + sGXsfl_117_idx + "',1);gx.fn.setControlValue('nIsMod_60_" + sGXsfl_72_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 119,'',false,'" + sGXsfl_117_idx + "',117)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel_subtipo2Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSubTipoConDes2_Internalname,A372SubTipoConDes2,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,119);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSubTipoConDes2_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtSubTipoConDes2_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(117),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
      httpContext.ajax_sending_grid_row(Gridlevel_subtipo2Row);
      send_integrity_lvl_hashes1R61( ) ;
      GXCCtl = "Z39SubTipoConCod2_" + sGXsfl_117_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Z39SubTipoConCod2));
      GXCCtl = "Z372SubTipoConDes2_" + sGXsfl_117_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, Z372SubTipoConDes2);
      GXCCtl = "nRcdDeleted_61_" + sGXsfl_117_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_61, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdExists_61_" + sGXsfl_117_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_61, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nIsMod_61_" + sGXsfl_117_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_61, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vMODE_" + sGXsfl_117_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Gx_mode));
      GXCCtl = "vTIPOCONCOD_" + sGXsfl_117_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( AV7TipoConCod));
      web.GxWebStd.gx_hidden_field( httpContext, "SUBTIPOCONCOD2_"+sGXsfl_117_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSubTipoConCod2_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "SUBTIPOCONDES2_"+sGXsfl_117_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSubTipoConDes2_Enabled, (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridlevel_subtipo2Container.AddRow(Gridlevel_subtipo2Row);
   }

   public void readRow1R61( )
   {
      nGXsfl_117_idx = (int)(nGXsfl_117_idx+1) ;
      sGXsfl_117_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_117_idx), 4, 0), (short)(4), "0") + sGXsfl_72_idx ;
      subsflControlProps_11761( ) ;
      edtSubTipoConCod2_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SUBTIPOCONCOD2_"+sGXsfl_117_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtSubTipoConDes2_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SUBTIPOCONDES2_"+sGXsfl_117_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      A39SubTipoConCod2 = httpContext.cgiGet( edtSubTipoConCod2_Internalname) ;
      n39SubTipoConCod2 = false ;
      A372SubTipoConDes2 = httpContext.cgiGet( edtSubTipoConDes2_Internalname) ;
      GXCCtl = "Z39SubTipoConCod2_" + sGXsfl_117_idx ;
      Z39SubTipoConCod2 = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z372SubTipoConDes2_" + sGXsfl_117_idx ;
      Z372SubTipoConDes2 = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "nRcdDeleted_61_" + sGXsfl_117_idx ;
      nRcdDeleted_61 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdExists_61_" + sGXsfl_117_idx ;
      nRcdExists_61 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nIsMod_61_" + sGXsfl_117_idx ;
      nIsMod_61 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
   }

   public void assign_properties_default( )
   {
      defedtSubTipoConCod2_Enabled = edtSubTipoConCod2_Enabled ;
      defedtSubTipoConCod1_Enabled = edtSubTipoConCod1_Enabled ;
   }

   public void confirmValues1R0( )
   {
      nGXsfl_117_idx = 0 ;
      sGXsfl_117_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_117_idx), 4, 0), (short)(4), "0") + sGXsfl_72_idx ;
      subsflControlProps_11761( ) ;
      while ( nGXsfl_117_idx < nRC_GXsfl_117 )
      {
         nGXsfl_117_idx = (int)(nGXsfl_117_idx+1) ;
         sGXsfl_117_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_117_idx), 4, 0), (short)(4), "0") + sGXsfl_72_idx ;
         subsflControlProps_11761( ) ;
         httpContext.changePostValue( "Z39SubTipoConCod2_"+sGXsfl_117_idx, httpContext.cgiGet( "ZT_"+"Z39SubTipoConCod2_"+sGXsfl_117_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z39SubTipoConCod2_"+sGXsfl_117_idx) ;
         httpContext.changePostValue( "Z372SubTipoConDes2_"+sGXsfl_117_idx, httpContext.cgiGet( "ZT_"+"Z372SubTipoConDes2_"+sGXsfl_117_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z372SubTipoConDes2_"+sGXsfl_117_idx) ;
      }
      nGXsfl_72_idx = 0 ;
      sGXsfl_72_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_72_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_7260( ) ;
      while ( nGXsfl_72_idx < nRC_GXsfl_72 )
      {
         nGXsfl_72_idx = (int)(nGXsfl_72_idx+1) ;
         sGXsfl_72_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_72_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_7260( ) ;
         httpContext.changePostValue( "Z38SubTipoConCod1_"+sGXsfl_72_idx, httpContext.cgiGet( "ZT_"+"Z38SubTipoConCod1_"+sGXsfl_72_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z38SubTipoConCod1_"+sGXsfl_72_idx) ;
         httpContext.changePostValue( "Z371SubTipoConDes1_"+sGXsfl_72_idx, httpContext.cgiGet( "ZT_"+"Z371SubTipoConDes1_"+sGXsfl_72_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z371SubTipoConDes1_"+sGXsfl_72_idx) ;
         httpContext.changePostValue( "Z375SubTRangoDesde_"+sGXsfl_72_idx, httpContext.cgiGet( "ZT_"+"Z375SubTRangoDesde_"+sGXsfl_72_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z375SubTRangoDesde_"+sGXsfl_72_idx) ;
         httpContext.changePostValue( "Z376SubTRangoHasta_"+sGXsfl_72_idx, httpContext.cgiGet( "ZT_"+"Z376SubTRangoHasta_"+sGXsfl_72_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z376SubTRangoHasta_"+sGXsfl_72_idx) ;
         httpContext.changePostValue( "Z740SubTDescuLey_"+sGXsfl_72_idx, httpContext.cgiGet( "ZT_"+"Z740SubTDescuLey_"+sGXsfl_72_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z740SubTDescuLey_"+sGXsfl_72_idx) ;
         httpContext.changePostValue( "Z1027SubTEsAdicional_"+sGXsfl_72_idx, httpContext.cgiGet( "ZT_"+"Z1027SubTEsAdicional_"+sGXsfl_72_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1027SubTEsAdicional_"+sGXsfl_72_idx) ;
         httpContext.changePostValue( "Z2134SubTRestaDias_"+sGXsfl_72_idx, httpContext.cgiGet( "ZT_"+"Z2134SubTRestaDias_"+sGXsfl_72_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2134SubTRestaDias_"+sGXsfl_72_idx) ;
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.tipodeconcepto", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.rtrim(AV7TipoConCod))}, new String[] {"Gx_mode","TipoConCod"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"TipoDeConcepto");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("tipodeconcepto:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z37TipoConCod", GXutil.rtrim( Z37TipoConCod));
      web.GxWebStd.gx_hidden_field( httpContext, "Z370TipoConDescrip", Z370TipoConDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "Z377TRangoDesde", GXutil.ltrim( localUtil.ntoc( Z377TRangoDesde, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z378TRangoHasta", GXutil.ltrim( localUtil.ntoc( Z378TRangoHasta, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z384TipoConOrden", GXutil.ltrim( localUtil.ntoc( Z384TipoConOrden, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2102TipoConPalabra", GXutil.rtrim( Z2102TipoConPalabra));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2157TipoConTipo", GXutil.rtrim( Z2157TipoConTipo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2120TipoConPai", GXutil.ltrim( localUtil.ntoc( Z2120TipoConPai, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_72", GXutil.ltrim( localUtil.ntoc( nGXsfl_72_idx, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "N2120TipoConPai", GXutil.ltrim( localUtil.ntoc( A2120TipoConPai, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV16DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV16DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTIPOCONPAI_DATA", AV15TipoConPai_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTIPOCONPAI_DATA", AV15TipoConPai_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vTIPOCONCOD", GXutil.rtrim( AV7TipoConCod));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTIPOCONCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV7TipoConCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_TIPOCONPAI", GXutil.ltrim( localUtil.ntoc( AV13Insert_TipoConPai, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV22Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_TIPOCONPAI_Objectcall", GXutil.rtrim( Combo_tipoconpai_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_TIPOCONPAI_Cls", GXutil.rtrim( Combo_tipoconpai_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_TIPOCONPAI_Selectedvalue_set", GXutil.rtrim( Combo_tipoconpai_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_TIPOCONPAI_Selectedtext_set", GXutil.rtrim( Combo_tipoconpai_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_TIPOCONPAI_Enabled", GXutil.booltostr( Combo_tipoconpai_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_TIPOCONPAI_Datalistproc", GXutil.rtrim( Combo_tipoconpai_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_TIPOCONPAI_Datalistprocparametersprefix", GXutil.rtrim( Combo_tipoconpai_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_TIPOCONPAI_Emptyitem", GXutil.booltostr( Combo_tipoconpai_Emptyitem));
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
      return formatLink("web.tipodeconcepto", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.rtrim(AV7TipoConCod))}, new String[] {"Gx_mode","TipoConCod"})  ;
   }

   public String getPgmname( )
   {
      return "TipoDeConcepto" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Tipo De Concepto", "") ;
   }

   public void initializeNonKey1R59( )
   {
      A2120TipoConPai = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2120TipoConPai", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2120TipoConPai), 4, 0));
      A370TipoConDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A370TipoConDescrip", A370TipoConDescrip);
      A377TRangoDesde = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A377TRangoDesde", GXutil.ltrimstr( DecimalUtil.doubleToDec(A377TRangoDesde), 8, 0));
      A378TRangoHasta = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A378TRangoHasta", GXutil.ltrimstr( DecimalUtil.doubleToDec(A378TRangoHasta), 8, 0));
      A384TipoConOrden = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A384TipoConOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A384TipoConOrden), 4, 0));
      A2102TipoConPalabra = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2102TipoConPalabra", A2102TipoConPalabra);
      A2157TipoConTipo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2157TipoConTipo", A2157TipoConTipo);
      Z370TipoConDescrip = "" ;
      Z377TRangoDesde = 0 ;
      Z378TRangoHasta = 0 ;
      Z384TipoConOrden = (short)(0) ;
      Z2102TipoConPalabra = "" ;
      Z2157TipoConTipo = "" ;
      Z2120TipoConPai = (short)(0) ;
   }

   public void initAll1R59( )
   {
      A37TipoConCod = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A37TipoConCod", A37TipoConCod);
      initializeNonKey1R59( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void initializeNonKey1R60( )
   {
      A371SubTipoConDes1 = "" ;
      A375SubTRangoDesde = 0 ;
      A376SubTRangoHasta = 0 ;
      A740SubTDescuLey = false ;
      A1027SubTEsAdicional = false ;
      A2134SubTRestaDias = false ;
      Z371SubTipoConDes1 = "" ;
      Z375SubTRangoDesde = 0 ;
      Z376SubTRangoHasta = 0 ;
      Z740SubTDescuLey = false ;
      Z1027SubTEsAdicional = false ;
      Z2134SubTRestaDias = false ;
   }

   public void initAll1R60( )
   {
      A38SubTipoConCod1 = "" ;
      n38SubTipoConCod1 = false ;
      initializeNonKey1R60( ) ;
   }

   public void standaloneModalInsert1R60( )
   {
   }

   public void initializeNonKey1R61( )
   {
      A372SubTipoConDes2 = "" ;
      Z372SubTipoConDes2 = "" ;
   }

   public void initAll1R61( )
   {
      A39SubTipoConCod2 = "" ;
      n39SubTipoConCod2 = false ;
      initializeNonKey1R61( ) ;
   }

   public void standaloneModalInsert1R61( )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025181781061", true, true);
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
      httpContext.AddJavascriptSource("tipodeconcepto.js", "?2025181781062", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_level_properties60( )
   {
      edtSubTipoConCod1_Enabled = defedtSubTipoConCod1_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtSubTipoConCod1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSubTipoConCod1_Enabled), 5, 0), !bGXsfl_72_Refreshing);
   }

   public void init_level_properties61( )
   {
      edtSubTipoConCod2_Enabled = defedtSubTipoConCod2_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtSubTipoConCod2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSubTipoConCod2_Enabled), 5, 0), !bGXsfl_117_Refreshing);
   }

   public void startgridcontrol72( )
   {
      Freestylelevel_subtipo1Container.AddObjectProperty("GridName", "Freestylelevel_subtipo1");
      Freestylelevel_subtipo1Container.AddObjectProperty("Header", subFreestylelevel_subtipo1_Header);
      Freestylelevel_subtipo1Container.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      Freestylelevel_subtipo1Container.AddObjectProperty("Class", "FreeStyleGrid");
      Freestylelevel_subtipo1Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Freestylelevel_subtipo1Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Freestylelevel_subtipo1Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subFreestylelevel_subtipo1_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Freestylelevel_subtipo1Container.AddObjectProperty("CmpContext", "");
      Freestylelevel_subtipo1Container.AddObjectProperty("InMasterPage", "false");
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Column.AddObjectProperty("Value", GXutil.rtrim( A38SubTipoConCod1));
      Freestylelevel_subtipo1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtSubTipoConCod1_Enabled, (byte)(5), (byte)(0), ".", "")));
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Column.AddObjectProperty("Value", A371SubTipoConDes1);
      Freestylelevel_subtipo1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtSubTipoConDes1_Enabled, (byte)(5), (byte)(0), ".", "")));
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A375SubTRangoDesde, (byte)(8), (byte)(0), ".", "")));
      Freestylelevel_subtipo1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtSubTRangoDesde_Enabled, (byte)(5), (byte)(0), ".", "")));
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A376SubTRangoHasta, (byte)(8), (byte)(0), ".", "")));
      Freestylelevel_subtipo1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtSubTRangoHasta_Enabled, (byte)(5), (byte)(0), ".", "")));
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Column.AddObjectProperty("Value", GXutil.booltostr( A740SubTDescuLey));
      Freestylelevel_subtipo1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( chkSubTDescuLey.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Column.AddObjectProperty("Value", GXutil.booltostr( A1027SubTEsAdicional));
      Freestylelevel_subtipo1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( chkSubTEsAdicional.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Column.AddObjectProperty("Value", GXutil.booltostr( A2134SubTRestaDias));
      Freestylelevel_subtipo1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( chkSubTRestaDias.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Freestylelevel_subtipo1Container.AddColumnProperties(Freestylelevel_subtipo1Column);
      Freestylelevel_subtipo1Container.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subFreestylelevel_subtipo1_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Freestylelevel_subtipo1Container.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subFreestylelevel_subtipo1_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Freestylelevel_subtipo1Container.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subFreestylelevel_subtipo1_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Freestylelevel_subtipo1Container.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subFreestylelevel_subtipo1_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Freestylelevel_subtipo1Container.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subFreestylelevel_subtipo1_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Freestylelevel_subtipo1Container.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subFreestylelevel_subtipo1_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Freestylelevel_subtipo1Container.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subFreestylelevel_subtipo1_Collapsed, (byte)(1), (byte)(0), ".", "")));
   }

   public void startgridcontrol117( )
   {
      Gridlevel_subtipo2Container.AddObjectProperty("GridName", "Gridlevel_subtipo2");
      Gridlevel_subtipo2Container.AddObjectProperty("Header", subGridlevel_subtipo2_Header);
      Gridlevel_subtipo2Container.AddObjectProperty("Class", "WorkWith");
      Gridlevel_subtipo2Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_subtipo2Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_subtipo2Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_subtipo2_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_subtipo2Container.AddObjectProperty("CmpContext", "");
      Gridlevel_subtipo2Container.AddObjectProperty("InMasterPage", "false");
      Gridlevel_subtipo2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_subtipo2Column.AddObjectProperty("Value", GXutil.rtrim( A39SubTipoConCod2));
      Gridlevel_subtipo2Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtSubTipoConCod2_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_subtipo2Container.AddColumnProperties(Gridlevel_subtipo2Column);
      Gridlevel_subtipo2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_subtipo2Column.AddObjectProperty("Value", A372SubTipoConDes2);
      Gridlevel_subtipo2Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtSubTipoConDes2_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_subtipo2Container.AddColumnProperties(Gridlevel_subtipo2Column);
      Gridlevel_subtipo2Container.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel_subtipo2_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_subtipo2Container.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel_subtipo2_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_subtipo2Container.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_subtipo2_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_subtipo2Container.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel_subtipo2_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_subtipo2Container.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_subtipo2_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_subtipo2Container.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel_subtipo2_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_subtipo2Container.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel_subtipo2_Collapsed, (byte)(1), (byte)(0), ".", "")));
   }

   public void init_default_properties( )
   {
      cmbTipoConCod.setInternalname( "TIPOCONCOD" );
      edtTipoConDescrip_Internalname = "TIPOCONDESCRIP" ;
      edtTRangoDesde_Internalname = "TRANGODESDE" ;
      edtTRangoHasta_Internalname = "TRANGOHASTA" ;
      edtTipoConOrden_Internalname = "TIPOCONORDEN" ;
      edtTipoConPalabra_Internalname = "TIPOCONPALABRA" ;
      lblTextblocktipoconpai_Internalname = "TEXTBLOCKTIPOCONPAI" ;
      Combo_tipoconpai_Internalname = "COMBO_TIPOCONPAI" ;
      edtTipoConPai_Internalname = "TIPOCONPAI" ;
      divTablesplittedtipoconpai_Internalname = "TABLESPLITTEDTIPOCONPAI" ;
      cmbTipoConTipo.setInternalname( "TIPOCONTIPO" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      edtSubTipoConCod1_Internalname = "SUBTIPOCONCOD1" ;
      edtSubTipoConDes1_Internalname = "SUBTIPOCONDES1" ;
      edtSubTRangoDesde_Internalname = "SUBTRANGODESDE" ;
      edtSubTRangoHasta_Internalname = "SUBTRANGOHASTA" ;
      chkSubTDescuLey.setInternalname( "SUBTDESCULEY" );
      chkSubTEsAdicional.setInternalname( "SUBTESADICIONAL" );
      chkSubTRestaDias.setInternalname( "SUBTRESTADIAS" );
      edtSubTipoConCod2_Internalname = "SUBTIPOCONCOD2" ;
      edtSubTipoConDes2_Internalname = "SUBTIPOCONDES2" ;
      divTableleaflevel_subtipo2_Internalname = "TABLELEAFLEVEL_SUBTIPO2" ;
      divTableintermediateinslevel_subtipo1_Internalname = "TABLEINTERMEDIATEINSLEVEL_SUBTIPO1" ;
      tblUnnamedtablefsfreestylelevel_subtipo1_Internalname = "UNNAMEDTABLEFSFREESTYLELEVEL_SUBTIPO1" ;
      divTableintermediatelevel_subtipo1_Internalname = "TABLEINTERMEDIATELEVEL_SUBTIPO1" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavCombotipoconpai_Internalname = "vCOMBOTIPOCONPAI" ;
      divSectionattribute_tipoconpai_Internalname = "SECTIONATTRIBUTE_TIPOCONPAI" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridlevel_subtipo2_Internalname = "GRIDLEVEL_SUBTIPO2" ;
      subFreestylelevel_subtipo1_Internalname = "FREESTYLELEVEL_SUBTIPO1" ;
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
      subGridlevel_subtipo2_Allowcollapsing = (byte)(0) ;
      subGridlevel_subtipo2_Allowselection = (byte)(0) ;
      subGridlevel_subtipo2_Header = "" ;
      subFreestylelevel_subtipo1_Allowcollapsing = (byte)(0) ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Tipo De Concepto", "") );
      edtSubTipoConDes2_Jsonclick = "" ;
      edtSubTipoConCod2_Jsonclick = "" ;
      subGridlevel_subtipo2_Class = "WorkWith" ;
      subGridlevel_subtipo2_Backcolorstyle = (byte)(0) ;
      chkSubTRestaDias.setCaption( httpContext.getMessage( "Resta días trabajados cuando el importe es negativo", "") );
      chkSubTEsAdicional.setCaption( httpContext.getMessage( "Es adicional (no forma parte de la jornada básica)", "") );
      chkSubTDescuLey.setCaption( httpContext.getMessage( "Descuento de Ley", "") );
      edtSubTRangoHasta_Jsonclick = "" ;
      edtSubTRangoDesde_Jsonclick = "" ;
      edtSubTipoConCod1_Jsonclick = "" ;
      subFreestylelevel_subtipo1_Class = "FreeStyleGrid" ;
      subFreestylelevel_subtipo1_Backcolorstyle = (byte)(0) ;
      edtSubTipoConDes2_Enabled = 1 ;
      edtSubTipoConCod2_Enabled = 0 ;
      edtavCombotipoconpai_Jsonclick = "" ;
      edtavCombotipoconpai_Enabled = 0 ;
      edtavCombotipoconpai_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      chkSubTRestaDias.setEnabled( 1 );
      chkSubTEsAdicional.setEnabled( 1 );
      chkSubTDescuLey.setEnabled( 1 );
      edtSubTRangoHasta_Enabled = 1 ;
      edtSubTRangoDesde_Enabled = 1 ;
      edtSubTipoConDes1_Enabled = 1 ;
      edtSubTipoConCod1_Enabled = 1 ;
      cmbTipoConTipo.setJsonclick( "" );
      cmbTipoConTipo.setEnabled( 1 );
      edtTipoConPai_Jsonclick = "" ;
      edtTipoConPai_Enabled = 1 ;
      edtTipoConPai_Visible = 1 ;
      Combo_tipoconpai_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_tipoconpai_Datalistprocparametersprefix = " \"ComboName\": \"TipoConPai\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"TipoConCod\": \"\"" ;
      Combo_tipoconpai_Datalistproc = "TipoDeConceptoLoadDVCombo" ;
      Combo_tipoconpai_Cls = "ExtendedCombo Attribute" ;
      Combo_tipoconpai_Caption = "" ;
      Combo_tipoconpai_Enabled = GXutil.toBoolean( -1) ;
      edtTipoConPalabra_Jsonclick = "" ;
      edtTipoConPalabra_Enabled = 1 ;
      edtTipoConOrden_Jsonclick = "" ;
      edtTipoConOrden_Enabled = 1 ;
      edtTRangoHasta_Jsonclick = "" ;
      edtTRangoHasta_Enabled = 1 ;
      edtTRangoDesde_Jsonclick = "" ;
      edtTRangoDesde_Enabled = 1 ;
      edtTipoConDescrip_Enabled = 1 ;
      cmbTipoConCod.setJsonclick( "" );
      cmbTipoConCod.setEnabled( 1 );
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

   public void gxnrfreestylelevel_subtipo1_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_7260( ) ;
      while ( nGXsfl_72_idx <= nRC_GXsfl_72 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal1R60( ) ;
         standaloneModal1R60( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow1R60( ) ;
         Freestylelevel_subtipo1Row.AddGrid("Gridlevel_subtipo2", Gridlevel_subtipo2Container);
         nGXsfl_72_idx = (int)(nGXsfl_72_idx+1) ;
         sGXsfl_72_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_72_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_7260( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Freestylelevel_subtipo1Container)) ;
      /* End function gxnrFreestylelevel_subtipo1_newrow */
   }

   public void gxnrgridlevel_subtipo2_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_11761( ) ;
      while ( nGXsfl_117_idx <= nRC_GXsfl_117 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal1R60( ) ;
         standaloneModal1R60( ) ;
         standaloneNotModal1R61( ) ;
         standaloneModal1R61( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow1R61( ) ;
         nGXsfl_117_idx = (int)(nGXsfl_117_idx+1) ;
         sGXsfl_117_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_117_idx), 4, 0), (short)(4), "0") + sGXsfl_72_idx ;
         subsflControlProps_11761( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel_subtipo2Container)) ;
      /* End function gxnrGridlevel_subtipo2_newrow */
   }

   public void init_web_controls( )
   {
      cmbTipoConCod.setName( "TIPOCONCOD" );
      cmbTipoConCod.setWebtags( "" );
      cmbTipoConCod.addItem("REM_ARG", httpContext.getMessage( "Remunerativo", ""), (short)(0));
      cmbTipoConCod.addItem("NRE_ARG", httpContext.getMessage( "No Remunerativo", ""), (short)(0));
      cmbTipoConCod.addItem("DES_ARG", httpContext.getMessage( "Retención", ""), (short)(0));
      cmbTipoConCod.addItem("CAL_ARG", httpContext.getMessage( "Cálculo", ""), (short)(0));
      if ( cmbTipoConCod.getItemCount() > 0 )
      {
         A37TipoConCod = cmbTipoConCod.getValidValue(A37TipoConCod) ;
         httpContext.ajax_rsp_assign_attri("", false, "A37TipoConCod", A37TipoConCod);
      }
      cmbTipoConTipo.setName( "TIPOCONTIPO" );
      cmbTipoConTipo.setWebtags( "" );
      cmbTipoConTipo.addItem("REM", httpContext.getMessage( "Remunerativo", ""), (short)(0));
      cmbTipoConTipo.addItem("NRE", httpContext.getMessage( "No remunerativo", ""), (short)(0));
      cmbTipoConTipo.addItem("DES", httpContext.getMessage( "Descuento", ""), (short)(0));
      cmbTipoConTipo.addItem("CAL", httpContext.getMessage( "Cálculo", ""), (short)(0));
      if ( cmbTipoConTipo.getItemCount() > 0 )
      {
         A2157TipoConTipo = cmbTipoConTipo.getValidValue(A2157TipoConTipo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2157TipoConTipo", A2157TipoConTipo);
      }
      GXCCtl = "SUBTDESCULEY_" + sGXsfl_72_idx ;
      chkSubTDescuLey.setName( GXCCtl );
      chkSubTDescuLey.setWebtags( "" );
      chkSubTDescuLey.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkSubTDescuLey.getInternalname(), "TitleCaption", chkSubTDescuLey.getCaption(), !bGXsfl_72_Refreshing);
      chkSubTDescuLey.setCheckedValue( "false" );
      A740SubTDescuLey = GXutil.strtobool( GXutil.booltostr( A740SubTDescuLey)) ;
      GXCCtl = "SUBTESADICIONAL_" + sGXsfl_72_idx ;
      chkSubTEsAdicional.setName( GXCCtl );
      chkSubTEsAdicional.setWebtags( "" );
      chkSubTEsAdicional.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkSubTEsAdicional.getInternalname(), "TitleCaption", chkSubTEsAdicional.getCaption(), !bGXsfl_72_Refreshing);
      chkSubTEsAdicional.setCheckedValue( "false" );
      A1027SubTEsAdicional = GXutil.strtobool( GXutil.booltostr( A1027SubTEsAdicional)) ;
      GXCCtl = "SUBTRESTADIAS_" + sGXsfl_72_idx ;
      chkSubTRestaDias.setName( GXCCtl );
      chkSubTRestaDias.setWebtags( "" );
      chkSubTRestaDias.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkSubTRestaDias.getInternalname(), "TitleCaption", chkSubTRestaDias.getCaption(), !bGXsfl_72_Refreshing);
      chkSubTRestaDias.setCheckedValue( "false" );
      A2134SubTRestaDias = GXutil.strtobool( GXutil.booltostr( A2134SubTRestaDias)) ;
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

   public void valid_Tipoconpai( )
   {
      /* Using cursor T001R36 */
      pr_default.execute(34, new Object[] {Short.valueOf(A2120TipoConPai)});
      if ( (pr_default.getStatus(34) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Concepto Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPOCONPAI");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTipoConPai_Internalname ;
      }
      pr_default.close(34);
      dynload_actions( ) ;
      if ( cmbTipoConCod.getItemCount() > 0 )
      {
         A37TipoConCod = cmbTipoConCod.getValidValue(A37TipoConCod) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbTipoConCod.setValue( GXutil.rtrim( A37TipoConCod) );
      }
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7TipoConCod',fld:'vTIPOCONCOD',pic:'',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7TipoConCod',fld:'vTIPOCONCOD',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e121R2',iparms:[]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_TIPOCONCOD","{handler:'valid_Tipoconcod',iparms:[]");
      setEventMetadata("VALID_TIPOCONCOD",",oparms:[]}");
      setEventMetadata("VALID_TIPOCONPAI","{handler:'valid_Tipoconpai',iparms:[{av:'A2120TipoConPai',fld:'TIPOCONPAI',pic:'ZZZ9'}]");
      setEventMetadata("VALID_TIPOCONPAI",",oparms:[]}");
      setEventMetadata("VALID_TIPOCONTIPO","{handler:'valid_Tipocontipo',iparms:[]");
      setEventMetadata("VALID_TIPOCONTIPO",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOTIPOCONPAI","{handler:'validv_Combotipoconpai',iparms:[]");
      setEventMetadata("VALIDV_COMBOTIPOCONPAI",",oparms:[]}");
      setEventMetadata("VALID_SUBTIPOCONCOD1","{handler:'valid_Subtipoconcod1',iparms:[]");
      setEventMetadata("VALID_SUBTIPOCONCOD1",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Subtrestadias',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
      setEventMetadata("VALID_SUBTIPOCONCOD2","{handler:'valid_Subtipoconcod2',iparms:[]");
      setEventMetadata("VALID_SUBTIPOCONCOD2",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Subtipocondes2',iparms:[]");
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
      pr_default.close(34);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV7TipoConCod = "" ;
      Z37TipoConCod = "" ;
      Z370TipoConDescrip = "" ;
      Z2102TipoConPalabra = "" ;
      Z2157TipoConTipo = "" ;
      Combo_tipoconpai_Selectedvalue_get = "" ;
      Z38SubTipoConCod1 = "" ;
      Z371SubTipoConDes1 = "" ;
      Z39SubTipoConCod2 = "" ;
      Z372SubTipoConDes2 = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      AV7TipoConCod = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A37TipoConCod = "" ;
      A2157TipoConTipo = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A370TipoConDescrip = "" ;
      A2102TipoConPalabra = "" ;
      lblTextblocktipoconpai_Jsonclick = "" ;
      ucCombo_tipoconpai = new com.genexus.webpanels.GXUserControl();
      AV16DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV15TipoConPai_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      Freestylelevel_subtipo1Container = new com.genexus.webpanels.GXWebGrid(context);
      sMode60 = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV22Pgmname = "" ;
      Combo_tipoconpai_Objectcall = "" ;
      Combo_tipoconpai_Class = "" ;
      Combo_tipoconpai_Icontype = "" ;
      Combo_tipoconpai_Icon = "" ;
      Combo_tipoconpai_Tooltip = "" ;
      Combo_tipoconpai_Selectedvalue_set = "" ;
      Combo_tipoconpai_Selectedtext_set = "" ;
      Combo_tipoconpai_Selectedtext_get = "" ;
      Combo_tipoconpai_Gamoauthtoken = "" ;
      Combo_tipoconpai_Ddointernalname = "" ;
      Combo_tipoconpai_Titlecontrolalign = "" ;
      Combo_tipoconpai_Dropdownoptionstype = "" ;
      Combo_tipoconpai_Titlecontrolidtoreplace = "" ;
      Combo_tipoconpai_Datalisttype = "" ;
      Combo_tipoconpai_Datalistfixedvalues = "" ;
      Combo_tipoconpai_Remoteservicesparameters = "" ;
      Combo_tipoconpai_Htmltemplate = "" ;
      Combo_tipoconpai_Multiplevaluestype = "" ;
      Combo_tipoconpai_Loadingdata = "" ;
      Combo_tipoconpai_Noresultsfound = "" ;
      Combo_tipoconpai_Emptyitemtext = "" ;
      Combo_tipoconpai_Onlyselectedvalues = "" ;
      Combo_tipoconpai_Selectalltext = "" ;
      Combo_tipoconpai_Multiplevaluesseparator = "" ;
      Combo_tipoconpai_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode59 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      GXCCtl = "" ;
      A39SubTipoConCod2 = "" ;
      A372SubTipoConDes2 = "" ;
      A38SubTipoConCod1 = "" ;
      A371SubTipoConDes1 = "" ;
      AV8WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV11TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12WebSession = httpContext.getWebSession();
      AV14TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV19Combo_DataJson = "" ;
      AV17ComboSelectedValue = "" ;
      AV18ComboSelectedText = "" ;
      GXt_char6 = "" ;
      GXv_char9 = new String[1] ;
      GXv_char8 = new String[1] ;
      GXv_char7 = new String[1] ;
      T001R9_A37TipoConCod = new String[] {""} ;
      T001R9_A370TipoConDescrip = new String[] {""} ;
      T001R9_A377TRangoDesde = new int[1] ;
      T001R9_A378TRangoHasta = new int[1] ;
      T001R9_A384TipoConOrden = new short[1] ;
      T001R9_A2102TipoConPalabra = new String[] {""} ;
      T001R9_A2157TipoConTipo = new String[] {""} ;
      T001R9_A2120TipoConPai = new short[1] ;
      T001R8_A2120TipoConPai = new short[1] ;
      T001R10_A2120TipoConPai = new short[1] ;
      T001R11_A37TipoConCod = new String[] {""} ;
      T001R7_A37TipoConCod = new String[] {""} ;
      T001R7_A370TipoConDescrip = new String[] {""} ;
      T001R7_A377TRangoDesde = new int[1] ;
      T001R7_A378TRangoHasta = new int[1] ;
      T001R7_A384TipoConOrden = new short[1] ;
      T001R7_A2102TipoConPalabra = new String[] {""} ;
      T001R7_A2157TipoConTipo = new String[] {""} ;
      T001R7_A2120TipoConPai = new short[1] ;
      T001R12_A37TipoConCod = new String[] {""} ;
      T001R13_A37TipoConCod = new String[] {""} ;
      T001R6_A37TipoConCod = new String[] {""} ;
      T001R6_A370TipoConDescrip = new String[] {""} ;
      T001R6_A377TRangoDesde = new int[1] ;
      T001R6_A378TRangoHasta = new int[1] ;
      T001R6_A384TipoConOrden = new short[1] ;
      T001R6_A2102TipoConPalabra = new String[] {""} ;
      T001R6_A2157TipoConTipo = new String[] {""} ;
      T001R6_A2120TipoConPai = new short[1] ;
      T001R17_A3CliCod = new int[1] ;
      T001R17_A1564CliPaiConve = new short[1] ;
      T001R17_A1565CliConvenio = new String[] {""} ;
      T001R17_A37TipoConCod = new String[] {""} ;
      T001R17_A1377ConvePromFijVar = new String[] {""} ;
      T001R18_A3CliCod = new int[1] ;
      T001R18_A1EmpCod = new short[1] ;
      T001R18_A37TipoConCod = new String[] {""} ;
      T001R18_A1371EmpPromFijVar = new String[] {""} ;
      T001R19_A46PaiCod = new short[1] ;
      T001R19_A37TipoConCod = new String[] {""} ;
      T001R19_A1361PaiPromFijVar = new String[] {""} ;
      T001R20_A37TipoConCod = new String[] {""} ;
      T001R20_A38SubTipoConCod1 = new String[] {""} ;
      T001R20_n38SubTipoConCod1 = new boolean[] {false} ;
      T001R21_A37TipoConCod = new String[] {""} ;
      T001R22_A37TipoConCod = new String[] {""} ;
      T001R22_A38SubTipoConCod1 = new String[] {""} ;
      T001R22_n38SubTipoConCod1 = new boolean[] {false} ;
      T001R22_A371SubTipoConDes1 = new String[] {""} ;
      T001R22_A375SubTRangoDesde = new int[1] ;
      T001R22_A376SubTRangoHasta = new int[1] ;
      T001R22_A740SubTDescuLey = new boolean[] {false} ;
      T001R22_A1027SubTEsAdicional = new boolean[] {false} ;
      T001R22_A2134SubTRestaDias = new boolean[] {false} ;
      T001R23_A37TipoConCod = new String[] {""} ;
      T001R23_A38SubTipoConCod1 = new String[] {""} ;
      T001R23_n38SubTipoConCod1 = new boolean[] {false} ;
      T001R5_A37TipoConCod = new String[] {""} ;
      T001R5_A38SubTipoConCod1 = new String[] {""} ;
      T001R5_n38SubTipoConCod1 = new boolean[] {false} ;
      T001R5_A371SubTipoConDes1 = new String[] {""} ;
      T001R5_A375SubTRangoDesde = new int[1] ;
      T001R5_A376SubTRangoHasta = new int[1] ;
      T001R5_A740SubTDescuLey = new boolean[] {false} ;
      T001R5_A1027SubTEsAdicional = new boolean[] {false} ;
      T001R5_A2134SubTRestaDias = new boolean[] {false} ;
      T001R4_A37TipoConCod = new String[] {""} ;
      T001R4_A38SubTipoConCod1 = new String[] {""} ;
      T001R4_n38SubTipoConCod1 = new boolean[] {false} ;
      T001R4_A371SubTipoConDes1 = new String[] {""} ;
      T001R4_A375SubTRangoDesde = new int[1] ;
      T001R4_A376SubTRangoHasta = new int[1] ;
      T001R4_A740SubTDescuLey = new boolean[] {false} ;
      T001R4_A1027SubTEsAdicional = new boolean[] {false} ;
      T001R4_A2134SubTRestaDias = new boolean[] {false} ;
      T001R27_A3CliCod = new int[1] ;
      T001R27_A26ConCodigo = new String[] {""} ;
      T001R28_A37TipoConCod = new String[] {""} ;
      T001R28_A38SubTipoConCod1 = new String[] {""} ;
      T001R28_n38SubTipoConCod1 = new boolean[] {false} ;
      T001R29_A37TipoConCod = new String[] {""} ;
      T001R29_A38SubTipoConCod1 = new String[] {""} ;
      T001R29_n38SubTipoConCod1 = new boolean[] {false} ;
      T001R29_A39SubTipoConCod2 = new String[] {""} ;
      T001R29_n39SubTipoConCod2 = new boolean[] {false} ;
      T001R29_A372SubTipoConDes2 = new String[] {""} ;
      T001R30_A37TipoConCod = new String[] {""} ;
      T001R30_A38SubTipoConCod1 = new String[] {""} ;
      T001R30_n38SubTipoConCod1 = new boolean[] {false} ;
      T001R30_A39SubTipoConCod2 = new String[] {""} ;
      T001R30_n39SubTipoConCod2 = new boolean[] {false} ;
      T001R3_A37TipoConCod = new String[] {""} ;
      T001R3_A38SubTipoConCod1 = new String[] {""} ;
      T001R3_n38SubTipoConCod1 = new boolean[] {false} ;
      T001R3_A39SubTipoConCod2 = new String[] {""} ;
      T001R3_n39SubTipoConCod2 = new boolean[] {false} ;
      T001R3_A372SubTipoConDes2 = new String[] {""} ;
      sMode61 = "" ;
      T001R2_A37TipoConCod = new String[] {""} ;
      T001R2_A38SubTipoConCod1 = new String[] {""} ;
      T001R2_n38SubTipoConCod1 = new boolean[] {false} ;
      T001R2_A39SubTipoConCod2 = new String[] {""} ;
      T001R2_n39SubTipoConCod2 = new boolean[] {false} ;
      T001R2_A372SubTipoConDes2 = new String[] {""} ;
      T001R34_A3CliCod = new int[1] ;
      T001R34_A26ConCodigo = new String[] {""} ;
      T001R35_A37TipoConCod = new String[] {""} ;
      T001R35_A38SubTipoConCod1 = new String[] {""} ;
      T001R35_n38SubTipoConCod1 = new boolean[] {false} ;
      T001R35_A39SubTipoConCod2 = new String[] {""} ;
      T001R35_n39SubTipoConCod2 = new boolean[] {false} ;
      Freestylelevel_subtipo1Row = new com.genexus.webpanels.GXWebRow();
      subFreestylelevel_subtipo1_Linesclass = "" ;
      ROClassString = "" ;
      Gridlevel_subtipo2Container = new com.genexus.webpanels.GXWebGrid(context);
      Gridlevel_subtipo2Row = new com.genexus.webpanels.GXWebRow();
      subGridlevel_subtipo2_Linesclass = "" ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      subFreestylelevel_subtipo1_Header = "" ;
      Freestylelevel_subtipo1Column = new com.genexus.webpanels.GXWebColumn();
      Gridlevel_subtipo2Column = new com.genexus.webpanels.GXWebColumn();
      T001R36_A2120TipoConPai = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.tipodeconcepto__default(),
         new Object[] {
             new Object[] {
            T001R2_A37TipoConCod, T001R2_A38SubTipoConCod1, T001R2_A39SubTipoConCod2, T001R2_A372SubTipoConDes2
            }
            , new Object[] {
            T001R3_A37TipoConCod, T001R3_A38SubTipoConCod1, T001R3_A39SubTipoConCod2, T001R3_A372SubTipoConDes2
            }
            , new Object[] {
            T001R4_A37TipoConCod, T001R4_A38SubTipoConCod1, T001R4_A371SubTipoConDes1, T001R4_A375SubTRangoDesde, T001R4_A376SubTRangoHasta, T001R4_A740SubTDescuLey, T001R4_A1027SubTEsAdicional, T001R4_A2134SubTRestaDias
            }
            , new Object[] {
            T001R5_A37TipoConCod, T001R5_A38SubTipoConCod1, T001R5_A371SubTipoConDes1, T001R5_A375SubTRangoDesde, T001R5_A376SubTRangoHasta, T001R5_A740SubTDescuLey, T001R5_A1027SubTEsAdicional, T001R5_A2134SubTRestaDias
            }
            , new Object[] {
            T001R6_A37TipoConCod, T001R6_A370TipoConDescrip, T001R6_A377TRangoDesde, T001R6_A378TRangoHasta, T001R6_A384TipoConOrden, T001R6_A2102TipoConPalabra, T001R6_A2157TipoConTipo, T001R6_A2120TipoConPai
            }
            , new Object[] {
            T001R7_A37TipoConCod, T001R7_A370TipoConDescrip, T001R7_A377TRangoDesde, T001R7_A378TRangoHasta, T001R7_A384TipoConOrden, T001R7_A2102TipoConPalabra, T001R7_A2157TipoConTipo, T001R7_A2120TipoConPai
            }
            , new Object[] {
            T001R8_A2120TipoConPai
            }
            , new Object[] {
            T001R9_A37TipoConCod, T001R9_A370TipoConDescrip, T001R9_A377TRangoDesde, T001R9_A378TRangoHasta, T001R9_A384TipoConOrden, T001R9_A2102TipoConPalabra, T001R9_A2157TipoConTipo, T001R9_A2120TipoConPai
            }
            , new Object[] {
            T001R10_A2120TipoConPai
            }
            , new Object[] {
            T001R11_A37TipoConCod
            }
            , new Object[] {
            T001R12_A37TipoConCod
            }
            , new Object[] {
            T001R13_A37TipoConCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001R17_A3CliCod, T001R17_A1564CliPaiConve, T001R17_A1565CliConvenio, T001R17_A37TipoConCod, T001R17_A1377ConvePromFijVar
            }
            , new Object[] {
            T001R18_A3CliCod, T001R18_A1EmpCod, T001R18_A37TipoConCod, T001R18_A1371EmpPromFijVar
            }
            , new Object[] {
            T001R19_A46PaiCod, T001R19_A37TipoConCod, T001R19_A1361PaiPromFijVar
            }
            , new Object[] {
            T001R20_A37TipoConCod, T001R20_A38SubTipoConCod1
            }
            , new Object[] {
            T001R21_A37TipoConCod
            }
            , new Object[] {
            T001R22_A37TipoConCod, T001R22_A38SubTipoConCod1, T001R22_A371SubTipoConDes1, T001R22_A375SubTRangoDesde, T001R22_A376SubTRangoHasta, T001R22_A740SubTDescuLey, T001R22_A1027SubTEsAdicional, T001R22_A2134SubTRestaDias
            }
            , new Object[] {
            T001R23_A37TipoConCod, T001R23_A38SubTipoConCod1
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001R27_A3CliCod, T001R27_A26ConCodigo
            }
            , new Object[] {
            T001R28_A37TipoConCod, T001R28_A38SubTipoConCod1
            }
            , new Object[] {
            T001R29_A37TipoConCod, T001R29_A38SubTipoConCod1, T001R29_A39SubTipoConCod2, T001R29_A372SubTipoConDes2
            }
            , new Object[] {
            T001R30_A37TipoConCod, T001R30_A38SubTipoConCod1, T001R30_A39SubTipoConCod2
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001R34_A3CliCod, T001R34_A26ConCodigo
            }
            , new Object[] {
            T001R35_A37TipoConCod, T001R35_A38SubTipoConCod1, T001R35_A39SubTipoConCod2
            }
            , new Object[] {
            T001R36_A2120TipoConPai
            }
         }
      );
      AV22Pgmname = "TipoDeConcepto" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte subFreestylelevel_subtipo1_Backcolorstyle ;
   private byte subFreestylelevel_subtipo1_Backstyle ;
   private byte subGridlevel_subtipo2_Backcolorstyle ;
   private byte subGridlevel_subtipo2_Backstyle ;
   private byte gxajaxcallmode ;
   private byte subFreestylelevel_subtipo1_Allowselection ;
   private byte subFreestylelevel_subtipo1_Allowhovering ;
   private byte subFreestylelevel_subtipo1_Allowcollapsing ;
   private byte subFreestylelevel_subtipo1_Collapsed ;
   private byte subGridlevel_subtipo2_Allowselection ;
   private byte subGridlevel_subtipo2_Allowhovering ;
   private byte subGridlevel_subtipo2_Allowcollapsing ;
   private byte subGridlevel_subtipo2_Collapsed ;
   private short Z384TipoConOrden ;
   private short Z2120TipoConPai ;
   private short N2120TipoConPai ;
   private short nRcdDeleted_60 ;
   private short nRcdExists_60 ;
   private short nIsMod_60 ;
   private short nRcdDeleted_61 ;
   private short nRcdExists_61 ;
   private short nIsMod_61 ;
   private short A2120TipoConPai ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A384TipoConOrden ;
   private short nBlankRcdCount60 ;
   private short RcdFound60 ;
   private short nBlankRcdUsr60 ;
   private short AV20ComboTipoConPai ;
   private short AV13Insert_TipoConPai ;
   private short RcdFound59 ;
   private short RcdFound61 ;
   private short nIsDirty_59 ;
   private short nIsDirty_60 ;
   private short nIsDirty_61 ;
   private short nBlankRcdCount61 ;
   private short nBlankRcdUsr61 ;
   private int Z377TRangoDesde ;
   private int Z378TRangoHasta ;
   private int nRC_GXsfl_72 ;
   private int nGXsfl_72_idx=1 ;
   private int Z375SubTRangoDesde ;
   private int Z376SubTRangoHasta ;
   private int nRC_GXsfl_117 ;
   private int nGXsfl_117_idx=1 ;
   private int trnEnded ;
   private int edtTipoConDescrip_Enabled ;
   private int A377TRangoDesde ;
   private int edtTRangoDesde_Enabled ;
   private int A378TRangoHasta ;
   private int edtTRangoHasta_Enabled ;
   private int edtTipoConOrden_Enabled ;
   private int edtTipoConPalabra_Enabled ;
   private int edtTipoConPai_Visible ;
   private int edtTipoConPai_Enabled ;
   private int edtSubTipoConCod1_Enabled ;
   private int edtSubTipoConDes1_Enabled ;
   private int edtSubTRangoDesde_Enabled ;
   private int edtSubTRangoHasta_Enabled ;
   private int fRowAdded ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtavCombotipoconpai_Enabled ;
   private int edtavCombotipoconpai_Visible ;
   private int Combo_tipoconpai_Datalistupdateminimumcharacters ;
   private int Combo_tipoconpai_Gxcontroltype ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int edtSubTipoConCod2_Enabled ;
   private int edtSubTipoConDes2_Enabled ;
   private int A375SubTRangoDesde ;
   private int A376SubTRangoHasta ;
   private int AV23GXV1 ;
   private int GX_JID ;
   private int subFreestylelevel_subtipo1_Backcolor ;
   private int subFreestylelevel_subtipo1_Allbackcolor ;
   private int FREESTYLELEVEL_SUBTIPO1_IsPaging ;
   private int subGridlevel_subtipo2_Backcolor ;
   private int subGridlevel_subtipo2_Allbackcolor ;
   private int defedtSubTipoConCod2_Enabled ;
   private int defedtSubTipoConCod1_Enabled ;
   private int idxLst ;
   private int subFreestylelevel_subtipo1_Selectedindex ;
   private int subFreestylelevel_subtipo1_Selectioncolor ;
   private int subFreestylelevel_subtipo1_Hoveringcolor ;
   private int subGridlevel_subtipo2_Selectedindex ;
   private int subGridlevel_subtipo2_Selectioncolor ;
   private int subGridlevel_subtipo2_Hoveringcolor ;
   private long FREESTYLELEVEL_SUBTIPO1_nFirstRecordOnPage ;
   private long GRIDLEVEL_SUBTIPO2_nFirstRecordOnPage ;
   private long GRIDLEVEL_SUBTIPO2_nCurrentRecord ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV7TipoConCod ;
   private String Z37TipoConCod ;
   private String Z2102TipoConPalabra ;
   private String Z2157TipoConTipo ;
   private String Combo_tipoconpai_Selectedvalue_get ;
   private String Z38SubTipoConCod1 ;
   private String Z39SubTipoConCod2 ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String AV7TipoConCod ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String sGXsfl_117_idx="0001" ;
   private String sGXsfl_72_idx="0001" ;
   private String A37TipoConCod ;
   private String A2157TipoConTipo ;
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
   private String edtTipoConDescrip_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtTRangoDesde_Internalname ;
   private String edtTRangoDesde_Jsonclick ;
   private String edtTRangoHasta_Internalname ;
   private String edtTRangoHasta_Jsonclick ;
   private String edtTipoConOrden_Internalname ;
   private String edtTipoConOrden_Jsonclick ;
   private String edtTipoConPalabra_Internalname ;
   private String A2102TipoConPalabra ;
   private String edtTipoConPalabra_Jsonclick ;
   private String divTablesplittedtipoconpai_Internalname ;
   private String lblTextblocktipoconpai_Internalname ;
   private String lblTextblocktipoconpai_Jsonclick ;
   private String Combo_tipoconpai_Caption ;
   private String Combo_tipoconpai_Cls ;
   private String Combo_tipoconpai_Datalistproc ;
   private String Combo_tipoconpai_Datalistprocparametersprefix ;
   private String Combo_tipoconpai_Internalname ;
   private String edtTipoConPai_Internalname ;
   private String edtTipoConPai_Jsonclick ;
   private String divTableintermediatelevel_subtipo1_Internalname ;
   private String sMode60 ;
   private String edtSubTipoConCod1_Internalname ;
   private String edtSubTipoConDes1_Internalname ;
   private String edtSubTRangoDesde_Internalname ;
   private String edtSubTRangoHasta_Internalname ;
   private String subFreestylelevel_subtipo1_Internalname ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_tipoconpai_Internalname ;
   private String edtavCombotipoconpai_Internalname ;
   private String edtavCombotipoconpai_Jsonclick ;
   private String AV22Pgmname ;
   private String Combo_tipoconpai_Objectcall ;
   private String Combo_tipoconpai_Class ;
   private String Combo_tipoconpai_Icontype ;
   private String Combo_tipoconpai_Icon ;
   private String Combo_tipoconpai_Tooltip ;
   private String Combo_tipoconpai_Selectedvalue_set ;
   private String Combo_tipoconpai_Selectedtext_set ;
   private String Combo_tipoconpai_Selectedtext_get ;
   private String Combo_tipoconpai_Gamoauthtoken ;
   private String Combo_tipoconpai_Ddointernalname ;
   private String Combo_tipoconpai_Titlecontrolalign ;
   private String Combo_tipoconpai_Dropdownoptionstype ;
   private String Combo_tipoconpai_Titlecontrolidtoreplace ;
   private String Combo_tipoconpai_Datalisttype ;
   private String Combo_tipoconpai_Datalistfixedvalues ;
   private String Combo_tipoconpai_Remoteservicesparameters ;
   private String Combo_tipoconpai_Htmltemplate ;
   private String Combo_tipoconpai_Multiplevaluestype ;
   private String Combo_tipoconpai_Loadingdata ;
   private String Combo_tipoconpai_Noresultsfound ;
   private String Combo_tipoconpai_Emptyitemtext ;
   private String Combo_tipoconpai_Onlyselectedvalues ;
   private String Combo_tipoconpai_Selectalltext ;
   private String Combo_tipoconpai_Multiplevaluesseparator ;
   private String Combo_tipoconpai_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode59 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXCCtl ;
   private String edtSubTipoConCod2_Internalname ;
   private String A39SubTipoConCod2 ;
   private String edtSubTipoConDes2_Internalname ;
   private String A38SubTipoConCod1 ;
   private String GXt_char6 ;
   private String GXv_char9[] ;
   private String GXv_char8[] ;
   private String GXv_char7[] ;
   private String sMode61 ;
   private String subGridlevel_subtipo2_Internalname ;
   private String sGXsfl_72_fel_idx="0001" ;
   private String subFreestylelevel_subtipo1_Class ;
   private String subFreestylelevel_subtipo1_Linesclass ;
   private String tblUnnamedtablefsfreestylelevel_subtipo1_Internalname ;
   private String divTableintermediateinslevel_subtipo1_Internalname ;
   private String ROClassString ;
   private String edtSubTipoConCod1_Jsonclick ;
   private String edtSubTRangoDesde_Jsonclick ;
   private String edtSubTRangoHasta_Jsonclick ;
   private String divTableleaflevel_subtipo2_Internalname ;
   private String sGXsfl_117_fel_idx="0001" ;
   private String subGridlevel_subtipo2_Class ;
   private String subGridlevel_subtipo2_Linesclass ;
   private String edtSubTipoConCod2_Jsonclick ;
   private String edtSubTipoConDes2_Jsonclick ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String subFreestylelevel_subtipo1_Header ;
   private String subGridlevel_subtipo2_Header ;
   private boolean Z740SubTDescuLey ;
   private boolean Z1027SubTEsAdicional ;
   private boolean Z2134SubTRestaDias ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_tipoconpai_Emptyitem ;
   private boolean bGXsfl_72_Refreshing=false ;
   private boolean Combo_tipoconpai_Enabled ;
   private boolean Combo_tipoconpai_Visible ;
   private boolean Combo_tipoconpai_Allowmultipleselection ;
   private boolean Combo_tipoconpai_Isgriditem ;
   private boolean Combo_tipoconpai_Hasdescription ;
   private boolean Combo_tipoconpai_Includeonlyselectedoption ;
   private boolean Combo_tipoconpai_Includeselectalloption ;
   private boolean Combo_tipoconpai_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean A740SubTDescuLey ;
   private boolean A1027SubTEsAdicional ;
   private boolean A2134SubTRestaDias ;
   private boolean returnInSub ;
   private boolean AV9IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private boolean Gx_longc ;
   private boolean n38SubTipoConCod1 ;
   private boolean bGXsfl_117_Refreshing=false ;
   private boolean n39SubTipoConCod2 ;
   private String AV19Combo_DataJson ;
   private String Z370TipoConDescrip ;
   private String Z371SubTipoConDes1 ;
   private String Z372SubTipoConDes2 ;
   private String A370TipoConDescrip ;
   private String A372SubTipoConDes2 ;
   private String A371SubTipoConDes1 ;
   private String AV17ComboSelectedValue ;
   private String AV18ComboSelectedText ;
   private com.genexus.webpanels.GXWebGrid Freestylelevel_subtipo1Container ;
   private com.genexus.webpanels.GXWebGrid Gridlevel_subtipo2Container ;
   private com.genexus.webpanels.GXWebRow Freestylelevel_subtipo1Row ;
   private com.genexus.webpanels.GXWebRow Gridlevel_subtipo2Row ;
   private com.genexus.webpanels.GXWebColumn Freestylelevel_subtipo1Column ;
   private com.genexus.webpanels.GXWebColumn Gridlevel_subtipo2Column ;
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_tipoconpai ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbTipoConCod ;
   private HTMLChoice cmbTipoConTipo ;
   private ICheckbox chkSubTDescuLey ;
   private ICheckbox chkSubTEsAdicional ;
   private ICheckbox chkSubTRestaDias ;
   private IDataStoreProvider pr_default ;
   private String[] T001R9_A37TipoConCod ;
   private String[] T001R9_A370TipoConDescrip ;
   private int[] T001R9_A377TRangoDesde ;
   private int[] T001R9_A378TRangoHasta ;
   private short[] T001R9_A384TipoConOrden ;
   private String[] T001R9_A2102TipoConPalabra ;
   private String[] T001R9_A2157TipoConTipo ;
   private short[] T001R9_A2120TipoConPai ;
   private short[] T001R8_A2120TipoConPai ;
   private short[] T001R10_A2120TipoConPai ;
   private String[] T001R11_A37TipoConCod ;
   private String[] T001R7_A37TipoConCod ;
   private String[] T001R7_A370TipoConDescrip ;
   private int[] T001R7_A377TRangoDesde ;
   private int[] T001R7_A378TRangoHasta ;
   private short[] T001R7_A384TipoConOrden ;
   private String[] T001R7_A2102TipoConPalabra ;
   private String[] T001R7_A2157TipoConTipo ;
   private short[] T001R7_A2120TipoConPai ;
   private String[] T001R12_A37TipoConCod ;
   private String[] T001R13_A37TipoConCod ;
   private String[] T001R6_A37TipoConCod ;
   private String[] T001R6_A370TipoConDescrip ;
   private int[] T001R6_A377TRangoDesde ;
   private int[] T001R6_A378TRangoHasta ;
   private short[] T001R6_A384TipoConOrden ;
   private String[] T001R6_A2102TipoConPalabra ;
   private String[] T001R6_A2157TipoConTipo ;
   private short[] T001R6_A2120TipoConPai ;
   private int[] T001R17_A3CliCod ;
   private short[] T001R17_A1564CliPaiConve ;
   private String[] T001R17_A1565CliConvenio ;
   private String[] T001R17_A37TipoConCod ;
   private String[] T001R17_A1377ConvePromFijVar ;
   private int[] T001R18_A3CliCod ;
   private short[] T001R18_A1EmpCod ;
   private String[] T001R18_A37TipoConCod ;
   private String[] T001R18_A1371EmpPromFijVar ;
   private short[] T001R19_A46PaiCod ;
   private String[] T001R19_A37TipoConCod ;
   private String[] T001R19_A1361PaiPromFijVar ;
   private String[] T001R20_A37TipoConCod ;
   private String[] T001R20_A38SubTipoConCod1 ;
   private boolean[] T001R20_n38SubTipoConCod1 ;
   private String[] T001R21_A37TipoConCod ;
   private String[] T001R22_A37TipoConCod ;
   private String[] T001R22_A38SubTipoConCod1 ;
   private boolean[] T001R22_n38SubTipoConCod1 ;
   private String[] T001R22_A371SubTipoConDes1 ;
   private int[] T001R22_A375SubTRangoDesde ;
   private int[] T001R22_A376SubTRangoHasta ;
   private boolean[] T001R22_A740SubTDescuLey ;
   private boolean[] T001R22_A1027SubTEsAdicional ;
   private boolean[] T001R22_A2134SubTRestaDias ;
   private String[] T001R23_A37TipoConCod ;
   private String[] T001R23_A38SubTipoConCod1 ;
   private boolean[] T001R23_n38SubTipoConCod1 ;
   private String[] T001R5_A37TipoConCod ;
   private String[] T001R5_A38SubTipoConCod1 ;
   private boolean[] T001R5_n38SubTipoConCod1 ;
   private String[] T001R5_A371SubTipoConDes1 ;
   private int[] T001R5_A375SubTRangoDesde ;
   private int[] T001R5_A376SubTRangoHasta ;
   private boolean[] T001R5_A740SubTDescuLey ;
   private boolean[] T001R5_A1027SubTEsAdicional ;
   private boolean[] T001R5_A2134SubTRestaDias ;
   private String[] T001R4_A37TipoConCod ;
   private String[] T001R4_A38SubTipoConCod1 ;
   private boolean[] T001R4_n38SubTipoConCod1 ;
   private String[] T001R4_A371SubTipoConDes1 ;
   private int[] T001R4_A375SubTRangoDesde ;
   private int[] T001R4_A376SubTRangoHasta ;
   private boolean[] T001R4_A740SubTDescuLey ;
   private boolean[] T001R4_A1027SubTEsAdicional ;
   private boolean[] T001R4_A2134SubTRestaDias ;
   private int[] T001R27_A3CliCod ;
   private String[] T001R27_A26ConCodigo ;
   private String[] T001R28_A37TipoConCod ;
   private String[] T001R28_A38SubTipoConCod1 ;
   private boolean[] T001R28_n38SubTipoConCod1 ;
   private String[] T001R29_A37TipoConCod ;
   private String[] T001R29_A38SubTipoConCod1 ;
   private boolean[] T001R29_n38SubTipoConCod1 ;
   private String[] T001R29_A39SubTipoConCod2 ;
   private boolean[] T001R29_n39SubTipoConCod2 ;
   private String[] T001R29_A372SubTipoConDes2 ;
   private String[] T001R30_A37TipoConCod ;
   private String[] T001R30_A38SubTipoConCod1 ;
   private boolean[] T001R30_n38SubTipoConCod1 ;
   private String[] T001R30_A39SubTipoConCod2 ;
   private boolean[] T001R30_n39SubTipoConCod2 ;
   private String[] T001R3_A37TipoConCod ;
   private String[] T001R3_A38SubTipoConCod1 ;
   private boolean[] T001R3_n38SubTipoConCod1 ;
   private String[] T001R3_A39SubTipoConCod2 ;
   private boolean[] T001R3_n39SubTipoConCod2 ;
   private String[] T001R3_A372SubTipoConDes2 ;
   private String[] T001R2_A37TipoConCod ;
   private String[] T001R2_A38SubTipoConCod1 ;
   private boolean[] T001R2_n38SubTipoConCod1 ;
   private String[] T001R2_A39SubTipoConCod2 ;
   private boolean[] T001R2_n39SubTipoConCod2 ;
   private String[] T001R2_A372SubTipoConDes2 ;
   private int[] T001R34_A3CliCod ;
   private String[] T001R34_A26ConCodigo ;
   private String[] T001R35_A37TipoConCod ;
   private String[] T001R35_A38SubTipoConCod1 ;
   private boolean[] T001R35_n38SubTipoConCod1 ;
   private String[] T001R35_A39SubTipoConCod2 ;
   private boolean[] T001R35_n39SubTipoConCod2 ;
   private short[] T001R36_A2120TipoConPai ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV15TipoConPai_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV14TrnContextAtt ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV16DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class tipodeconcepto__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T001R2", "SELECT TipoConCod, SubTipoConCod1, SubTipoConCod2, SubTipoConDes2 FROM tipo_concepto_subtipo2 WHERE TipoConCod = ? AND SubTipoConCod1 = ? AND SubTipoConCod2 = ?  FOR UPDATE OF tipo_concepto_subtipo2 NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001R3", "SELECT TipoConCod, SubTipoConCod1, SubTipoConCod2, SubTipoConDes2 FROM tipo_concepto_subtipo2 WHERE TipoConCod = ? AND SubTipoConCod1 = ? AND SubTipoConCod2 = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001R4", "SELECT TipoConCod, SubTipoConCod1, SubTipoConDes1, SubTRangoDesde, SubTRangoHasta, SubTDescuLey, SubTEsAdicional, SubTRestaDias FROM TipoDeConceptoSubtipo1 WHERE TipoConCod = ? AND SubTipoConCod1 = ?  FOR UPDATE OF TipoDeConceptoSubtipo1 NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001R5", "SELECT TipoConCod, SubTipoConCod1, SubTipoConDes1, SubTRangoDesde, SubTRangoHasta, SubTDescuLey, SubTEsAdicional, SubTRestaDias FROM TipoDeConceptoSubtipo1 WHERE TipoConCod = ? AND SubTipoConCod1 = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001R6", "SELECT TipoConCod, TipoConDescrip, TRangoDesde, TRangoHasta, TipoConOrden, TipoConPalabra, TipoConTipo, TipoConPai FROM TipoDeConcepto WHERE TipoConCod = ?  FOR UPDATE OF TipoDeConcepto NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001R7", "SELECT TipoConCod, TipoConDescrip, TRangoDesde, TRangoHasta, TipoConOrden, TipoConPalabra, TipoConTipo, TipoConPai FROM TipoDeConcepto WHERE TipoConCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001R8", "SELECT PaiCod AS TipoConPai FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001R9", "SELECT TM1.TipoConCod, TM1.TipoConDescrip, TM1.TRangoDesde, TM1.TRangoHasta, TM1.TipoConOrden, TM1.TipoConPalabra, TM1.TipoConTipo, TM1.TipoConPai AS TipoConPai FROM TipoDeConcepto TM1 WHERE TM1.TipoConCod = ( ?) ORDER BY TM1.TipoConCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001R10", "SELECT PaiCod AS TipoConPai FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001R11", "SELECT TipoConCod FROM TipoDeConcepto WHERE TipoConCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001R12", "SELECT TipoConCod FROM TipoDeConcepto WHERE ( TipoConCod > ( ?)) ORDER BY TipoConCod  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001R13", "SELECT TipoConCod FROM TipoDeConcepto WHERE ( TipoConCod < ( ?)) ORDER BY TipoConCod DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T001R14", "SAVEPOINT gxupdate;INSERT INTO TipoDeConcepto(TipoConCod, TipoConDescrip, TRangoDesde, TRangoHasta, TipoConOrden, TipoConPalabra, TipoConTipo, TipoConPai) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001R15", "SAVEPOINT gxupdate;UPDATE TipoDeConcepto SET TipoConDescrip=?, TRangoDesde=?, TRangoHasta=?, TipoConOrden=?, TipoConPalabra=?, TipoConTipo=?, TipoConPai=?  WHERE TipoConCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001R16", "SAVEPOINT gxupdate;DELETE FROM TipoDeConcepto  WHERE TipoConCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T001R17", "SELECT CliCod, CliPaiConve, CliConvenio, TipoConCod, ConvePromFijVar FROM Convenio_promedio_horanormal_mensualizad WHERE TipoConCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001R18", "SELECT CliCod, EmpCod, TipoConCod, EmpPromFijVar FROM Empresapromedio_horanormal_mensualizados WHERE TipoConCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001R19", "SELECT PaiCod, TipoConCod, PaiPromFijVar FROM Paispromedio_horanormal_mensualizados WHERE TipoConCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001R20", "SELECT TipoConCod, SubTipoConCod1 FROM TipoDeConceptoSubtipo1 WHERE TipoConCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001R21", "SELECT TipoConCod FROM TipoDeConcepto ORDER BY TipoConCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001R22", "SELECT TipoConCod, SubTipoConCod1, SubTipoConDes1, SubTRangoDesde, SubTRangoHasta, SubTDescuLey, SubTEsAdicional, SubTRestaDias FROM TipoDeConceptoSubtipo1 WHERE TipoConCod = ( ?) and SubTipoConCod1 = ( ?) ORDER BY TipoConCod, SubTipoConCod1 ",true, GX_NOMASK, false, this,6, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001R23", "SELECT TipoConCod, SubTipoConCod1 FROM TipoDeConceptoSubtipo1 WHERE TipoConCod = ? AND SubTipoConCod1 = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T001R24", "SAVEPOINT gxupdate;INSERT INTO TipoDeConceptoSubtipo1(TipoConCod, SubTipoConCod1, SubTipoConDes1, SubTRangoDesde, SubTRangoHasta, SubTDescuLey, SubTEsAdicional, SubTRestaDias) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001R25", "SAVEPOINT gxupdate;UPDATE TipoDeConceptoSubtipo1 SET SubTipoConDes1=?, SubTRangoDesde=?, SubTRangoHasta=?, SubTDescuLey=?, SubTEsAdicional=?, SubTRestaDias=?  WHERE TipoConCod = ? AND SubTipoConCod1 = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001R26", "SAVEPOINT gxupdate;DELETE FROM TipoDeConceptoSubtipo1  WHERE TipoConCod = ? AND SubTipoConCod1 = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T001R27", "SELECT CliCod, ConCodigo FROM Concepto WHERE TipoConCod = ? AND SubTipoConCod1 = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001R28", "SELECT TipoConCod, SubTipoConCod1 FROM TipoDeConceptoSubtipo1 WHERE TipoConCod = ( ?) ORDER BY TipoConCod, SubTipoConCod1 ",true, GX_NOMASK, false, this,6, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001R29", "SELECT TipoConCod, SubTipoConCod1, SubTipoConCod2, SubTipoConDes2 FROM tipo_concepto_subtipo2 WHERE TipoConCod = ( ?) and SubTipoConCod1 = ( ?) and SubTipoConCod2 = ( ?) ORDER BY TipoConCod, SubTipoConCod1, SubTipoConCod2 ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001R30", "SELECT TipoConCod, SubTipoConCod1, SubTipoConCod2 FROM tipo_concepto_subtipo2 WHERE TipoConCod = ? AND SubTipoConCod1 = ? AND SubTipoConCod2 = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T001R31", "SAVEPOINT gxupdate;INSERT INTO tipo_concepto_subtipo2(TipoConCod, SubTipoConCod1, SubTipoConCod2, SubTipoConDes2) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001R32", "SAVEPOINT gxupdate;UPDATE tipo_concepto_subtipo2 SET SubTipoConDes2=?  WHERE TipoConCod = ? AND SubTipoConCod1 = ? AND SubTipoConCod2 = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001R33", "SAVEPOINT gxupdate;DELETE FROM tipo_concepto_subtipo2  WHERE TipoConCod = ? AND SubTipoConCod1 = ? AND SubTipoConCod2 = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T001R34", "SELECT CliCod, ConCodigo FROM Concepto WHERE TipoConCod = ? AND SubTipoConCod1 = ? AND SubTipoConCod2 = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001R35", "SELECT TipoConCod, SubTipoConCod1, SubTipoConCod2 FROM tipo_concepto_subtipo2 WHERE TipoConCod = ( ?) and SubTipoConCod1 = ( ?) ORDER BY TipoConCod, SubTipoConCod1, SubTipoConCod2 ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001R36", "SELECT PaiCod AS TipoConPai FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 8 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 9 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 10 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 17 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 18 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 19 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 20 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               return;
            case 21 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 25 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 26 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 27 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 28 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 32 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 33 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 34 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
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
               stmt.setString(1, (String)parms[0], 20);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[4], 20);
               }
               return;
            case 1 :
               stmt.setString(1, (String)parms[0], 20);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[4], 20);
               }
               return;
            case 2 :
               stmt.setString(1, (String)parms[0], 20);
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
               stmt.setString(1, (String)parms[0], 20);
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
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 5 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 7 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 9 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 10 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 11 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 12 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               return;
            case 13 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setString(8, (String)parms[7], 20);
               return;
            case 14 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 15 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 16 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 17 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 18 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 20 :
               stmt.setString(1, (String)parms[0], 20);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 21 :
               stmt.setString(1, (String)parms[0], 20);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 22 :
               stmt.setString(1, (String)parms[0], 20);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               stmt.setVarchar(3, (String)parms[3], 400, false);
               stmt.setInt(4, ((Number) parms[4]).intValue());
               stmt.setInt(5, ((Number) parms[5]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[6]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[7]).booleanValue());
               stmt.setBoolean(8, ((Boolean) parms[8]).booleanValue());
               return;
            case 23 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setBoolean(5, ((Boolean) parms[4]).booleanValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setString(7, (String)parms[6], 20);
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(8, (String)parms[8], 20);
               }
               return;
            case 24 :
               stmt.setString(1, (String)parms[0], 20);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 25 :
               stmt.setString(1, (String)parms[0], 20);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 26 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 27 :
               stmt.setString(1, (String)parms[0], 20);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[4], 20);
               }
               return;
            case 28 :
               stmt.setString(1, (String)parms[0], 20);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[4], 20);
               }
               return;
            case 29 :
               stmt.setString(1, (String)parms[0], 20);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[4], 20);
               }
               stmt.setVarchar(4, (String)parms[5], 400, false);
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
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setString(2, (String)parms[1], 20);
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[3], 20);
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(4, (String)parms[5], 20);
               }
               return;
            case 31 :
               stmt.setString(1, (String)parms[0], 20);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[4], 20);
               }
               return;
            case 32 :
               stmt.setString(1, (String)parms[0], 20);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[4], 20);
               }
               return;
            case 33 :
               stmt.setString(1, (String)parms[0], 20);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 34 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

