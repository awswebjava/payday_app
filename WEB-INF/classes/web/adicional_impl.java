package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class adicional_impl extends GXDataArea
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
         A46PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_13( A46PaiCod) ;
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel_opc") == 0 )
      {
         gxnrgridlevel_opc_newrow_invoke( ) ;
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
            AV7PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7PaiCod), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7PaiCod), "ZZZ9")));
            AV8AdicionalCod = httpContext.GetPar( "AdicionalCod") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8AdicionalCod", AV8AdicionalCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vADICIONALCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8AdicionalCod, ""))));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Adicional", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtAdicionalCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrgridlevel_opc_newrow_invoke( )
   {
      nRC_GXsfl_41 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_41"))) ;
      nGXsfl_41_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_41_idx"))) ;
      sGXsfl_41_idx = httpContext.GetPar( "sGXsfl_41_idx") ;
      Gx_mode = httpContext.GetPar( "Mode") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel_opc_newrow( ) ;
      /* End function gxnrGridlevel_opc_newrow_invoke */
   }

   public adicional_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public adicional_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( adicional_impl.class ));
   }

   public adicional_impl( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbAdicionalReservado = new HTMLChoice();
      chkAdicionalOpcEsRango = UIFactory.getCheckbox(this);
      cmbAdicionalTipo = new HTMLChoice();
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
      if ( cmbAdicionalReservado.getItemCount() > 0 )
      {
         A1784AdicionalReservado = cmbAdicionalReservado.getValidValue(A1784AdicionalReservado) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1784AdicionalReservado", A1784AdicionalReservado);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbAdicionalReservado.setValue( GXutil.rtrim( A1784AdicionalReservado) );
         httpContext.ajax_rsp_assign_prop("", false, cmbAdicionalReservado.getInternalname(), "Values", cmbAdicionalReservado.ToJavascriptSource(), true);
      }
      if ( cmbAdicionalTipo.getItemCount() > 0 )
      {
         A992AdicionalTipo = cmbAdicionalTipo.getValidValue(A992AdicionalTipo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A992AdicionalTipo", A992AdicionalTipo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbAdicionalTipo.setValue( GXutil.rtrim( A992AdicionalTipo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbAdicionalTipo.getInternalname(), "Values", cmbAdicionalTipo.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtAdicionalCod_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtAdicionalCod_Internalname, httpContext.getMessage( "Adicional código", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtAdicionalCod_Internalname, GXutil.rtrim( A988AdicionalCod), GXutil.rtrim( localUtil.format( A988AdicionalCod, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtAdicionalCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtAdicionalCod_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Adicional.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtAdicionalDescrip_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtAdicionalDescrip_Internalname, httpContext.getMessage( "Adicional descripción", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtAdicionalDescrip_Internalname, A989AdicionalDescrip, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", (short)(0), 1, edtAdicionalDescrip_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "Descrip", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Adicional.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbAdicionalReservado.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbAdicionalReservado.getInternalname(), httpContext.getMessage( "Relacionado a adicional genérico", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbAdicionalReservado, cmbAdicionalReservado.getInternalname(), GXutil.rtrim( A1784AdicionalReservado), 1, cmbAdicionalReservado.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbAdicionalReservado.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", "", true, (byte)(0), "HLP_Adicional.htm");
      cmbAdicionalReservado.setValue( GXutil.rtrim( A1784AdicionalReservado) );
      httpContext.ajax_rsp_assign_prop("", false, cmbAdicionalReservado.getInternalname(), "Values", cmbAdicionalReservado.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, divTableleaflevel_opc_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell", "left", "top", "", "", "div");
      /*  Grid Control  */
      startgridcontrol41( ) ;
      nGXsfl_41_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount116 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_116 = (short)(1) ;
            scanStart2U116( ) ;
            while ( RcdFound116 != 0 )
            {
               init_level_properties116( ) ;
               getByPrimaryKey2U116( ) ;
               addRow2U116( ) ;
               scanNext2U116( ) ;
            }
            scanEnd2U116( ) ;
            nBlankRcdCount116 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         standaloneNotModal2U116( ) ;
         standaloneModal2U116( ) ;
         sMode116 = Gx_mode ;
         while ( nGXsfl_41_idx < nRC_GXsfl_41 )
         {
            bGXsfl_41_Refreshing = true ;
            readRow2U116( ) ;
            edtAdicionalOpcCod_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ADICIONALOPCCOD_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtAdicionalOpcCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAdicionalOpcCod_Enabled), 5, 0), !bGXsfl_41_Refreshing);
            edtAdicionalOpcDescrip_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ADICIONALOPCDESCRIP_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtAdicionalOpcDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAdicionalOpcDescrip_Enabled), 5, 0), !bGXsfl_41_Refreshing);
            chkAdicionalOpcEsRango.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "ADICIONALOPCESRANGO_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
            httpContext.ajax_rsp_assign_prop("", false, chkAdicionalOpcEsRango.getInternalname(), "Enabled", GXutil.ltrimstr( chkAdicionalOpcEsRango.getEnabled(), 5, 0), !bGXsfl_41_Refreshing);
            edtAdicionalOpcDesde_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ADICIONALOPCDESDE_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtAdicionalOpcDesde_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAdicionalOpcDesde_Enabled), 5, 0), !bGXsfl_41_Refreshing);
            edtAdicionalOpcHasta_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ADICIONALOPCHASTA_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtAdicionalOpcHasta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAdicionalOpcHasta_Enabled), 5, 0), !bGXsfl_41_Refreshing);
            if ( ( nRcdExists_116 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal2U116( ) ;
            }
            sendRow2U116( ) ;
            bGXsfl_41_Refreshing = false ;
         }
         Gx_mode = sMode116 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount116 = (short)(5) ;
         nRcdExists_116 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart2U116( ) ;
            while ( RcdFound116 != 0 )
            {
               sGXsfl_41_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_41_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_41116( ) ;
               init_level_properties116( ) ;
               standaloneNotModal2U116( ) ;
               getByPrimaryKey2U116( ) ;
               standaloneModal2U116( ) ;
               addRow2U116( ) ;
               scanNext2U116( ) ;
            }
            scanEnd2U116( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode116 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_41_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_41_idx+1), 4, 0), (short)(4), "0") ;
         subsflControlProps_41116( ) ;
         initAll2U116( ) ;
         init_level_properties116( ) ;
         nRcdExists_116 = (short)(0) ;
         nIsMod_116 = (short)(0) ;
         nRcdDeleted_116 = (short)(0) ;
         nBlankRcdCount116 = (short)(nBlankRcdUsr116+nBlankRcdCount116) ;
         fRowAdded = 0 ;
         while ( nBlankRcdCount116 > 0 )
         {
            standaloneNotModal2U116( ) ;
            standaloneModal2U116( ) ;
            addRow2U116( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = edtAdicionalOpcCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount116 = (short)(nBlankRcdCount116-1) ;
         }
         Gx_mode = sMode116 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridlevel_opcContainer"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridlevel_opc", Gridlevel_opcContainer, subGridlevel_opc_Internalname);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_opcContainerData", Gridlevel_opcContainer.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_opcContainerData"+"V", Gridlevel_opcContainer.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel_opcContainerData"+"V"+"\" value='"+Gridlevel_opcContainer.GridValuesHidden()+"'/>") ;
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 51,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Adicional.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Adicional.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 55,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Adicional.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiCod_Internalname, GXutil.ltrim( localUtil.ntoc( A46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A46PaiCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,59);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiCod_Jsonclick, 0, "Attribute", "", "", "", "", edtPaiCod_Visible, edtPaiCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_Adicional.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 60,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtAdicionalUniMed_Internalname, GXutil.rtrim( A991AdicionalUniMed), GXutil.rtrim( localUtil.format( A991AdicionalUniMed, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,60);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtAdicionalUniMed_Jsonclick, 0, "Attribute", "", "", "", "", edtAdicionalUniMed_Visible, edtAdicionalUniMed_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Adicional.htm");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 61,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbAdicionalTipo, cmbAdicionalTipo.getInternalname(), GXutil.rtrim( A992AdicionalTipo), 1, cmbAdicionalTipo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", cmbAdicionalTipo.getVisible(), cmbAdicionalTipo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,61);\"", "", true, (byte)(0), "HLP_Adicional.htm");
      cmbAdicionalTipo.setValue( GXutil.rtrim( A992AdicionalTipo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbAdicionalTipo.getInternalname(), "Values", cmbAdicionalTipo.ToJavascriptSource(), true);
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
      e112U2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z46PaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z988AdicionalCod = httpContext.cgiGet( "Z988AdicionalCod") ;
            Z989AdicionalDescrip = httpContext.cgiGet( "Z989AdicionalDescrip") ;
            Z991AdicionalUniMed = httpContext.cgiGet( "Z991AdicionalUniMed") ;
            Z992AdicionalTipo = httpContext.cgiGet( "Z992AdicionalTipo") ;
            Z1784AdicionalReservado = httpContext.cgiGet( "Z1784AdicionalReservado") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            nRC_GXsfl_41 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_41"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV7PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "vPAICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8AdicionalCod = httpContext.cgiGet( "vADICIONALCOD") ;
            AV14Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            A988AdicionalCod = httpContext.cgiGet( edtAdicionalCod_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A988AdicionalCod", A988AdicionalCod);
            A989AdicionalDescrip = httpContext.cgiGet( edtAdicionalDescrip_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A989AdicionalDescrip", A989AdicionalDescrip);
            cmbAdicionalReservado.setName( cmbAdicionalReservado.getInternalname() );
            cmbAdicionalReservado.setValue( httpContext.cgiGet( cmbAdicionalReservado.getInternalname()) );
            A1784AdicionalReservado = httpContext.cgiGet( cmbAdicionalReservado.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1784AdicionalReservado", A1784AdicionalReservado);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PAICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A46PaiCod = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            }
            else
            {
               A46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( edtPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            }
            A991AdicionalUniMed = httpContext.cgiGet( edtAdicionalUniMed_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A991AdicionalUniMed", A991AdicionalUniMed);
            cmbAdicionalTipo.setName( cmbAdicionalTipo.getInternalname() );
            cmbAdicionalTipo.setValue( httpContext.cgiGet( cmbAdicionalTipo.getInternalname()) );
            A992AdicionalTipo = httpContext.cgiGet( cmbAdicionalTipo.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A992AdicionalTipo", A992AdicionalTipo);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Adicional");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A46PaiCod != Z46PaiCod ) || ( GXutil.strcmp(A988AdicionalCod, Z988AdicionalCod) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("adicional:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A46PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
               A988AdicionalCod = httpContext.GetPar( "AdicionalCod") ;
               httpContext.ajax_rsp_assign_attri("", false, "A988AdicionalCod", A988AdicionalCod);
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
                  sMode112 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode112 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound112 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_2U0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "PAICOD");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtPaiCod_Internalname ;
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
                        e112U2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e122U2 ();
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
         e122U2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll2U112( ) ;
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
         disableAttributes2U112( ) ;
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

   public void confirm_2U0( )
   {
      beforeValidate2U112( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls2U112( ) ;
         }
         else
         {
            checkExtendedTable2U112( ) ;
            closeExtendedTableCursors2U112( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode112 = Gx_mode ;
         confirm_2U116( ) ;
         if ( AnyError == 0 )
         {
            /* Restore parent mode. */
            Gx_mode = sMode112 ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            IsConfirmed = (short)(1) ;
            httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
         }
         /* Restore parent mode. */
         Gx_mode = sMode112 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
   }

   public void confirm_2U116( )
   {
      nGXsfl_41_idx = 0 ;
      while ( nGXsfl_41_idx < nRC_GXsfl_41 )
      {
         readRow2U116( ) ;
         if ( ( nRcdExists_116 != 0 ) || ( nIsMod_116 != 0 ) )
         {
            getKey2U116( ) ;
            if ( ( nRcdExists_116 == 0 ) && ( nRcdDeleted_116 == 0 ) )
            {
               if ( RcdFound116 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate2U116( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable2U116( ) ;
                     closeExtendedTableCursors2U116( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "ADICIONALOPCCOD_" + sGXsfl_41_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtAdicionalOpcCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound116 != 0 )
               {
                  if ( nRcdDeleted_116 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey2U116( ) ;
                     load2U116( ) ;
                     beforeValidate2U116( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls2U116( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_116 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate2U116( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable2U116( ) ;
                           closeExtendedTableCursors2U116( ) ;
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
                  if ( nRcdDeleted_116 == 0 )
                  {
                     GXCCtl = "ADICIONALOPCCOD_" + sGXsfl_41_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtAdicionalOpcCod_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtAdicionalOpcCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1004AdicionalOpcCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtAdicionalOpcDescrip_Internalname, A1005AdicionalOpcDescrip) ;
         httpContext.changePostValue( chkAdicionalOpcEsRango.getInternalname(), GXutil.booltostr( A1008AdicionalOpcEsRango)) ;
         httpContext.changePostValue( edtAdicionalOpcDesde_Internalname, GXutil.ltrim( localUtil.ntoc( A1009AdicionalOpcDesde, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtAdicionalOpcHasta_Internalname, GXutil.ltrim( localUtil.ntoc( A1010AdicionalOpcHasta, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1004AdicionalOpcCod_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( Z1004AdicionalOpcCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1005AdicionalOpcDescrip_"+sGXsfl_41_idx, Z1005AdicionalOpcDescrip) ;
         httpContext.changePostValue( "ZT_"+"Z1008AdicionalOpcEsRango_"+sGXsfl_41_idx, GXutil.booltostr( Z1008AdicionalOpcEsRango)) ;
         httpContext.changePostValue( "ZT_"+"Z1009AdicionalOpcDesde_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( Z1009AdicionalOpcDesde, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1010AdicionalOpcHasta_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( Z1010AdicionalOpcHasta, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_116_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_116, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_116_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_116, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_116_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_116, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_116 != 0 )
         {
            httpContext.changePostValue( "ADICIONALOPCCOD_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtAdicionalOpcCod_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ADICIONALOPCDESCRIP_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtAdicionalOpcDescrip_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ADICIONALOPCESRANGO_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( chkAdicionalOpcEsRango.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ADICIONALOPCDESDE_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtAdicionalOpcDesde_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ADICIONALOPCHASTA_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtAdicionalOpcHasta_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void resetCaption2U0( )
   {
   }

   public void e112U2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV9WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV9WWPContext = GXv_SdtWWPContext1[0] ;
      AV10IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV10IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWAdicional_Insert", GXv_boolean3) ;
         adicional_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV10IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV10IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWAdicional_Update", GXv_boolean3) ;
         adicional_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV10IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV10IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWAdicional_Delete", GXv_boolean3) ;
         adicional_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV10IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( ! AV10IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV14Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV12TrnContext.fromxml(AV13WebSession.getValue("TrnContext"), null, null);
      edtPaiCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Visible), 5, 0), true);
      edtAdicionalUniMed_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAdicionalUniMed_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAdicionalUniMed_Visible), 5, 0), true);
      cmbAdicionalTipo.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbAdicionalTipo.getInternalname(), "Visible", GXutil.ltrimstr( cmbAdicionalTipo.getVisible(), 5, 0), true);
   }

   public void e122U2( )
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

   public void zm2U112( int GX_JID )
   {
      if ( ( GX_JID == 12 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z989AdicionalDescrip = T002U5_A989AdicionalDescrip[0] ;
            Z991AdicionalUniMed = T002U5_A991AdicionalUniMed[0] ;
            Z992AdicionalTipo = T002U5_A992AdicionalTipo[0] ;
            Z1784AdicionalReservado = T002U5_A1784AdicionalReservado[0] ;
         }
         else
         {
            Z989AdicionalDescrip = A989AdicionalDescrip ;
            Z991AdicionalUniMed = A991AdicionalUniMed ;
            Z992AdicionalTipo = A992AdicionalTipo ;
            Z1784AdicionalReservado = A1784AdicionalReservado ;
         }
      }
      if ( GX_JID == -12 )
      {
         Z988AdicionalCod = A988AdicionalCod ;
         Z989AdicionalDescrip = A989AdicionalDescrip ;
         Z991AdicionalUniMed = A991AdicionalUniMed ;
         Z992AdicionalTipo = A992AdicionalTipo ;
         Z1784AdicionalReservado = A1784AdicionalReservado ;
         Z46PaiCod = A46PaiCod ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7PaiCod) )
      {
         A46PaiCod = AV7PaiCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      }
      if ( ! (0==AV7PaiCod) )
      {
         edtPaiCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Enabled), 5, 0), true);
      }
      else
      {
         edtPaiCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV7PaiCod) )
      {
         edtPaiCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV8AdicionalCod)==0) )
      {
         A988AdicionalCod = AV8AdicionalCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A988AdicionalCod", A988AdicionalCod);
      }
      if ( ! (GXutil.strcmp("", AV8AdicionalCod)==0) )
      {
         edtAdicionalCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtAdicionalCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAdicionalCod_Enabled), 5, 0), true);
      }
      else
      {
         edtAdicionalCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtAdicionalCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAdicionalCod_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV8AdicionalCod)==0) )
      {
         edtAdicionalCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtAdicionalCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAdicionalCod_Enabled), 5, 0), true);
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
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV14Pgmname = "Adicional" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14Pgmname", AV14Pgmname);
      }
   }

   public void load2U112( )
   {
      /* Using cursor T002U7 */
      pr_default.execute(5, new Object[] {Short.valueOf(A46PaiCod), A988AdicionalCod});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound112 = (short)(1) ;
         A989AdicionalDescrip = T002U7_A989AdicionalDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A989AdicionalDescrip", A989AdicionalDescrip);
         A991AdicionalUniMed = T002U7_A991AdicionalUniMed[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A991AdicionalUniMed", A991AdicionalUniMed);
         A992AdicionalTipo = T002U7_A992AdicionalTipo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A992AdicionalTipo", A992AdicionalTipo);
         A1784AdicionalReservado = T002U7_A1784AdicionalReservado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1784AdicionalReservado", A1784AdicionalReservado);
         zm2U112( -12) ;
      }
      pr_default.close(5);
      onLoadActions2U112( ) ;
   }

   public void onLoadActions2U112( )
   {
      AV14Pgmname = "Adicional" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14Pgmname", AV14Pgmname);
   }

   public void checkExtendedTable2U112( )
   {
      nIsDirty_112 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV14Pgmname = "Adicional" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14Pgmname", AV14Pgmname);
      /* Using cursor T002U6 */
      pr_default.execute(4, new Object[] {Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(4);
      if ( ! ( ( GXutil.strcmp(A992AdicionalTipo, "NUM") == 0 ) || ( GXutil.strcmp(A992AdicionalTipo, "STR") == 0 ) || ( GXutil.strcmp(A992AdicionalTipo, "BOOL") == 0 ) || ( GXutil.strcmp(A992AdicionalTipo, "DATE") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Adicional Tipo (borrar)", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "ADICIONALTIPO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbAdicionalTipo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A1784AdicionalReservado, "antiguedad") == 0 ) || ( GXutil.strcmp(A1784AdicionalReservado, "presentismo") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Relacionado a adicional genérico", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "ADICIONALRESERVADO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbAdicionalReservado.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors2U112( )
   {
      pr_default.close(4);
   }

   public void enableDisable( )
   {
   }

   public void gxload_13( short A46PaiCod )
   {
      /* Using cursor T002U8 */
      pr_default.execute(6, new Object[] {Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
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

   public void getKey2U112( )
   {
      /* Using cursor T002U9 */
      pr_default.execute(7, new Object[] {Short.valueOf(A46PaiCod), A988AdicionalCod});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound112 = (short)(1) ;
      }
      else
      {
         RcdFound112 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T002U5 */
      pr_default.execute(3, new Object[] {Short.valueOf(A46PaiCod), A988AdicionalCod});
      if ( (pr_default.getStatus(3) != 101) )
      {
         zm2U112( 12) ;
         RcdFound112 = (short)(1) ;
         A988AdicionalCod = T002U5_A988AdicionalCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A988AdicionalCod", A988AdicionalCod);
         A989AdicionalDescrip = T002U5_A989AdicionalDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A989AdicionalDescrip", A989AdicionalDescrip);
         A991AdicionalUniMed = T002U5_A991AdicionalUniMed[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A991AdicionalUniMed", A991AdicionalUniMed);
         A992AdicionalTipo = T002U5_A992AdicionalTipo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A992AdicionalTipo", A992AdicionalTipo);
         A1784AdicionalReservado = T002U5_A1784AdicionalReservado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1784AdicionalReservado", A1784AdicionalReservado);
         A46PaiCod = T002U5_A46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         Z46PaiCod = A46PaiCod ;
         Z988AdicionalCod = A988AdicionalCod ;
         sMode112 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load2U112( ) ;
         if ( AnyError == 1 )
         {
            RcdFound112 = (short)(0) ;
            initializeNonKey2U112( ) ;
         }
         Gx_mode = sMode112 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound112 = (short)(0) ;
         initializeNonKey2U112( ) ;
         sMode112 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode112 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(3);
   }

   public void getEqualNoModal( )
   {
      getKey2U112( ) ;
      if ( RcdFound112 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound112 = (short)(0) ;
      /* Using cursor T002U10 */
      pr_default.execute(8, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A46PaiCod), A988AdicionalCod});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T002U10_A46PaiCod[0] < A46PaiCod ) || ( T002U10_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T002U10_A988AdicionalCod[0], A988AdicionalCod) < 0 ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T002U10_A46PaiCod[0] > A46PaiCod ) || ( T002U10_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T002U10_A988AdicionalCod[0], A988AdicionalCod) > 0 ) ) )
         {
            A46PaiCod = T002U10_A46PaiCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            A988AdicionalCod = T002U10_A988AdicionalCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A988AdicionalCod", A988AdicionalCod);
            RcdFound112 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound112 = (short)(0) ;
      /* Using cursor T002U11 */
      pr_default.execute(9, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A46PaiCod), A988AdicionalCod});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T002U11_A46PaiCod[0] > A46PaiCod ) || ( T002U11_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T002U11_A988AdicionalCod[0], A988AdicionalCod) > 0 ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T002U11_A46PaiCod[0] < A46PaiCod ) || ( T002U11_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T002U11_A988AdicionalCod[0], A988AdicionalCod) < 0 ) ) )
         {
            A46PaiCod = T002U11_A46PaiCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            A988AdicionalCod = T002U11_A988AdicionalCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A988AdicionalCod", A988AdicionalCod);
            RcdFound112 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey2U112( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtAdicionalCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert2U112( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound112 == 1 )
         {
            if ( ( A46PaiCod != Z46PaiCod ) || ( GXutil.strcmp(A988AdicionalCod, Z988AdicionalCod) != 0 ) )
            {
               A46PaiCod = Z46PaiCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
               A988AdicionalCod = Z988AdicionalCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A988AdicionalCod", A988AdicionalCod);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "PAICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtAdicionalCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update2U112( ) ;
               GX_FocusControl = edtAdicionalCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A46PaiCod != Z46PaiCod ) || ( GXutil.strcmp(A988AdicionalCod, Z988AdicionalCod) != 0 ) )
            {
               /* Insert record */
               GX_FocusControl = edtAdicionalCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert2U112( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "PAICOD");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtPaiCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtAdicionalCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert2U112( ) ;
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
      if ( ( A46PaiCod != Z46PaiCod ) || ( GXutil.strcmp(A988AdicionalCod, Z988AdicionalCod) != 0 ) )
      {
         A46PaiCod = Z46PaiCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A988AdicionalCod = Z988AdicionalCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A988AdicionalCod", A988AdicionalCod);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "PAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtAdicionalCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency2U112( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T002U4 */
         pr_default.execute(2, new Object[] {Short.valueOf(A46PaiCod), A988AdicionalCod});
         if ( (pr_default.getStatus(2) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Adicional"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(2) == 101) || ( GXutil.strcmp(Z989AdicionalDescrip, T002U4_A989AdicionalDescrip[0]) != 0 ) || ( GXutil.strcmp(Z991AdicionalUniMed, T002U4_A991AdicionalUniMed[0]) != 0 ) || ( GXutil.strcmp(Z992AdicionalTipo, T002U4_A992AdicionalTipo[0]) != 0 ) || ( GXutil.strcmp(Z1784AdicionalReservado, T002U4_A1784AdicionalReservado[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z989AdicionalDescrip, T002U4_A989AdicionalDescrip[0]) != 0 )
            {
               GXutil.writeLogln("adicional:[seudo value changed for attri]"+"AdicionalDescrip");
               GXutil.writeLogRaw("Old: ",Z989AdicionalDescrip);
               GXutil.writeLogRaw("Current: ",T002U4_A989AdicionalDescrip[0]);
            }
            if ( GXutil.strcmp(Z991AdicionalUniMed, T002U4_A991AdicionalUniMed[0]) != 0 )
            {
               GXutil.writeLogln("adicional:[seudo value changed for attri]"+"AdicionalUniMed");
               GXutil.writeLogRaw("Old: ",Z991AdicionalUniMed);
               GXutil.writeLogRaw("Current: ",T002U4_A991AdicionalUniMed[0]);
            }
            if ( GXutil.strcmp(Z992AdicionalTipo, T002U4_A992AdicionalTipo[0]) != 0 )
            {
               GXutil.writeLogln("adicional:[seudo value changed for attri]"+"AdicionalTipo");
               GXutil.writeLogRaw("Old: ",Z992AdicionalTipo);
               GXutil.writeLogRaw("Current: ",T002U4_A992AdicionalTipo[0]);
            }
            if ( GXutil.strcmp(Z1784AdicionalReservado, T002U4_A1784AdicionalReservado[0]) != 0 )
            {
               GXutil.writeLogln("adicional:[seudo value changed for attri]"+"AdicionalReservado");
               GXutil.writeLogRaw("Old: ",Z1784AdicionalReservado);
               GXutil.writeLogRaw("Current: ",T002U4_A1784AdicionalReservado[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Adicional"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert2U112( )
   {
      beforeValidate2U112( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2U112( ) ;
      }
      if ( AnyError == 0 )
      {
         zm2U112( 0) ;
         checkOptimisticConcurrency2U112( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2U112( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert2U112( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002U12 */
                  pr_default.execute(10, new Object[] {A988AdicionalCod, A989AdicionalDescrip, A991AdicionalUniMed, A992AdicionalTipo, A1784AdicionalReservado, Short.valueOf(A46PaiCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Adicional");
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
                        processLevel2U112( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                           resetCaption2U0( ) ;
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
            load2U112( ) ;
         }
         endLevel2U112( ) ;
      }
      closeExtendedTableCursors2U112( ) ;
   }

   public void update2U112( )
   {
      beforeValidate2U112( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2U112( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2U112( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2U112( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate2U112( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002U13 */
                  pr_default.execute(11, new Object[] {A989AdicionalDescrip, A991AdicionalUniMed, A992AdicionalTipo, A1784AdicionalReservado, Short.valueOf(A46PaiCod), A988AdicionalCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Adicional");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Adicional"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate2U112( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel2U112( ) ;
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
         endLevel2U112( ) ;
      }
      closeExtendedTableCursors2U112( ) ;
   }

   public void deferredUpdate2U112( )
   {
   }

   public void delete( )
   {
      beforeValidate2U112( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2U112( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls2U112( ) ;
         afterConfirm2U112( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete2U112( ) ;
            if ( AnyError == 0 )
            {
               scanStart2U116( ) ;
               while ( RcdFound116 != 0 )
               {
                  getByPrimaryKey2U116( ) ;
                  delete2U116( ) ;
                  scanNext2U116( ) ;
               }
               scanEnd2U116( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002U14 */
                  pr_default.execute(12, new Object[] {Short.valueOf(A46PaiCod), A988AdicionalCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Adicional");
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
      sMode112 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel2U112( ) ;
      Gx_mode = sMode112 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls2U112( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV14Pgmname = "Adicional" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14Pgmname", AV14Pgmname);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T002U15 */
         pr_default.execute(13, new Object[] {Short.valueOf(A46PaiCod), A988AdicionalCod});
         if ( (pr_default.getStatus(13) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "adicional_actividad", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
      }
   }

   public void processNestedLevel2U116( )
   {
      nGXsfl_41_idx = 0 ;
      while ( nGXsfl_41_idx < nRC_GXsfl_41 )
      {
         readRow2U116( ) ;
         if ( ( nRcdExists_116 != 0 ) || ( nIsMod_116 != 0 ) )
         {
            standaloneNotModal2U116( ) ;
            getKey2U116( ) ;
            if ( ( nRcdExists_116 == 0 ) && ( nRcdDeleted_116 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert2U116( ) ;
            }
            else
            {
               if ( RcdFound116 != 0 )
               {
                  if ( ( nRcdDeleted_116 != 0 ) && ( nRcdExists_116 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete2U116( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_116 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update2U116( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_116 == 0 )
                  {
                     GXCCtl = "ADICIONALOPCCOD_" + sGXsfl_41_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtAdicionalOpcCod_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtAdicionalOpcCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1004AdicionalOpcCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtAdicionalOpcDescrip_Internalname, A1005AdicionalOpcDescrip) ;
         httpContext.changePostValue( chkAdicionalOpcEsRango.getInternalname(), GXutil.booltostr( A1008AdicionalOpcEsRango)) ;
         httpContext.changePostValue( edtAdicionalOpcDesde_Internalname, GXutil.ltrim( localUtil.ntoc( A1009AdicionalOpcDesde, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtAdicionalOpcHasta_Internalname, GXutil.ltrim( localUtil.ntoc( A1010AdicionalOpcHasta, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1004AdicionalOpcCod_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( Z1004AdicionalOpcCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1005AdicionalOpcDescrip_"+sGXsfl_41_idx, Z1005AdicionalOpcDescrip) ;
         httpContext.changePostValue( "ZT_"+"Z1008AdicionalOpcEsRango_"+sGXsfl_41_idx, GXutil.booltostr( Z1008AdicionalOpcEsRango)) ;
         httpContext.changePostValue( "ZT_"+"Z1009AdicionalOpcDesde_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( Z1009AdicionalOpcDesde, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1010AdicionalOpcHasta_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( Z1010AdicionalOpcHasta, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_116_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_116, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_116_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_116, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_116_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_116, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_116 != 0 )
         {
            httpContext.changePostValue( "ADICIONALOPCCOD_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtAdicionalOpcCod_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ADICIONALOPCDESCRIP_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtAdicionalOpcDescrip_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ADICIONALOPCESRANGO_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( chkAdicionalOpcEsRango.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ADICIONALOPCDESDE_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtAdicionalOpcDesde_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ADICIONALOPCHASTA_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtAdicionalOpcHasta_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll2U116( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_116 = (short)(0) ;
      nIsMod_116 = (short)(0) ;
      nRcdDeleted_116 = (short)(0) ;
   }

   public void processLevel2U112( )
   {
      /* Save parent mode. */
      sMode112 = Gx_mode ;
      processNestedLevel2U116( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode112 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
   }

   public void endLevel2U112( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(2);
      }
      if ( AnyError == 0 )
      {
         beforeComplete2U112( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "adicional");
         if ( AnyError == 0 )
         {
            confirmValues2U0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "adicional");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart2U112( )
   {
      /* Scan By routine */
      /* Using cursor T002U16 */
      pr_default.execute(14);
      RcdFound112 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound112 = (short)(1) ;
         A46PaiCod = T002U16_A46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A988AdicionalCod = T002U16_A988AdicionalCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A988AdicionalCod", A988AdicionalCod);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext2U112( )
   {
      /* Scan next routine */
      pr_default.readNext(14);
      RcdFound112 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound112 = (short)(1) ;
         A46PaiCod = T002U16_A46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A988AdicionalCod = T002U16_A988AdicionalCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A988AdicionalCod", A988AdicionalCod);
      }
   }

   public void scanEnd2U112( )
   {
      pr_default.close(14);
   }

   public void afterConfirm2U112( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert2U112( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate2U112( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete2U112( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete2U112( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate2U112( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes2U112( )
   {
      edtAdicionalCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAdicionalCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAdicionalCod_Enabled), 5, 0), true);
      edtAdicionalDescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAdicionalDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAdicionalDescrip_Enabled), 5, 0), true);
      cmbAdicionalReservado.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbAdicionalReservado.getInternalname(), "Enabled", GXutil.ltrimstr( cmbAdicionalReservado.getEnabled(), 5, 0), true);
      edtPaiCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Enabled), 5, 0), true);
      edtAdicionalUniMed_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAdicionalUniMed_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAdicionalUniMed_Enabled), 5, 0), true);
      cmbAdicionalTipo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbAdicionalTipo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbAdicionalTipo.getEnabled(), 5, 0), true);
   }

   public void zm2U116( int GX_JID )
   {
      if ( ( GX_JID == 14 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1005AdicionalOpcDescrip = T002U3_A1005AdicionalOpcDescrip[0] ;
            Z1008AdicionalOpcEsRango = T002U3_A1008AdicionalOpcEsRango[0] ;
            Z1009AdicionalOpcDesde = T002U3_A1009AdicionalOpcDesde[0] ;
            Z1010AdicionalOpcHasta = T002U3_A1010AdicionalOpcHasta[0] ;
         }
         else
         {
            Z1005AdicionalOpcDescrip = A1005AdicionalOpcDescrip ;
            Z1008AdicionalOpcEsRango = A1008AdicionalOpcEsRango ;
            Z1009AdicionalOpcDesde = A1009AdicionalOpcDesde ;
            Z1010AdicionalOpcHasta = A1010AdicionalOpcHasta ;
         }
      }
      if ( GX_JID == -14 )
      {
         Z46PaiCod = A46PaiCod ;
         Z988AdicionalCod = A988AdicionalCod ;
         Z1004AdicionalOpcCod = A1004AdicionalOpcCod ;
         Z1005AdicionalOpcDescrip = A1005AdicionalOpcDescrip ;
         Z1008AdicionalOpcEsRango = A1008AdicionalOpcEsRango ;
         Z1009AdicionalOpcDesde = A1009AdicionalOpcDesde ;
         Z1010AdicionalOpcHasta = A1010AdicionalOpcHasta ;
      }
   }

   public void standaloneNotModal2U116( )
   {
      chkAdicionalOpcEsRango.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkAdicionalOpcEsRango.getInternalname(), "Enabled", GXutil.ltrimstr( chkAdicionalOpcEsRango.getEnabled(), 5, 0), !bGXsfl_41_Refreshing);
      edtAdicionalOpcDesde_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAdicionalOpcDesde_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAdicionalOpcDesde_Enabled), 5, 0), !bGXsfl_41_Refreshing);
      edtAdicionalOpcHasta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAdicionalOpcHasta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAdicionalOpcHasta_Enabled), 5, 0), !bGXsfl_41_Refreshing);
   }

   public void standaloneModal2U116( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtAdicionalOpcCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtAdicionalOpcCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAdicionalOpcCod_Enabled), 5, 0), !bGXsfl_41_Refreshing);
      }
      else
      {
         edtAdicionalOpcCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtAdicionalOpcCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAdicionalOpcCod_Enabled), 5, 0), !bGXsfl_41_Refreshing);
      }
   }

   public void load2U116( )
   {
      /* Using cursor T002U17 */
      pr_default.execute(15, new Object[] {Short.valueOf(A46PaiCod), A988AdicionalCod, Short.valueOf(A1004AdicionalOpcCod)});
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound116 = (short)(1) ;
         A1005AdicionalOpcDescrip = T002U17_A1005AdicionalOpcDescrip[0] ;
         A1008AdicionalOpcEsRango = T002U17_A1008AdicionalOpcEsRango[0] ;
         A1009AdicionalOpcDesde = T002U17_A1009AdicionalOpcDesde[0] ;
         A1010AdicionalOpcHasta = T002U17_A1010AdicionalOpcHasta[0] ;
         zm2U116( -14) ;
      }
      pr_default.close(15);
      onLoadActions2U116( ) ;
   }

   public void onLoadActions2U116( )
   {
   }

   public void checkExtendedTable2U116( )
   {
      nIsDirty_116 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal2U116( ) ;
   }

   public void closeExtendedTableCursors2U116( )
   {
   }

   public void enableDisable2U116( )
   {
   }

   public void getKey2U116( )
   {
      /* Using cursor T002U18 */
      pr_default.execute(16, new Object[] {Short.valueOf(A46PaiCod), A988AdicionalCod, Short.valueOf(A1004AdicionalOpcCod)});
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound116 = (short)(1) ;
      }
      else
      {
         RcdFound116 = (short)(0) ;
      }
      pr_default.close(16);
   }

   public void getByPrimaryKey2U116( )
   {
      /* Using cursor T002U3 */
      pr_default.execute(1, new Object[] {Short.valueOf(A46PaiCod), A988AdicionalCod, Short.valueOf(A1004AdicionalOpcCod)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm2U116( 14) ;
         RcdFound116 = (short)(1) ;
         initializeNonKey2U116( ) ;
         A1004AdicionalOpcCod = T002U3_A1004AdicionalOpcCod[0] ;
         A1005AdicionalOpcDescrip = T002U3_A1005AdicionalOpcDescrip[0] ;
         A1008AdicionalOpcEsRango = T002U3_A1008AdicionalOpcEsRango[0] ;
         A1009AdicionalOpcDesde = T002U3_A1009AdicionalOpcDesde[0] ;
         A1010AdicionalOpcHasta = T002U3_A1010AdicionalOpcHasta[0] ;
         Z46PaiCod = A46PaiCod ;
         Z988AdicionalCod = A988AdicionalCod ;
         Z1004AdicionalOpcCod = A1004AdicionalOpcCod ;
         sMode116 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load2U116( ) ;
         Gx_mode = sMode116 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound116 = (short)(0) ;
         initializeNonKey2U116( ) ;
         sMode116 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal2U116( ) ;
         Gx_mode = sMode116 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes2U116( ) ;
      }
      pr_default.close(1);
   }

   public void checkOptimisticConcurrency2U116( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T002U2 */
         pr_default.execute(0, new Object[] {Short.valueOf(A46PaiCod), A988AdicionalCod, Short.valueOf(A1004AdicionalOpcCod)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"adicional_opciones"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z1005AdicionalOpcDescrip, T002U2_A1005AdicionalOpcDescrip[0]) != 0 ) || ( Z1008AdicionalOpcEsRango != T002U2_A1008AdicionalOpcEsRango[0] ) || ( Z1009AdicionalOpcDesde != T002U2_A1009AdicionalOpcDesde[0] ) || ( Z1010AdicionalOpcHasta != T002U2_A1010AdicionalOpcHasta[0] ) )
         {
            if ( GXutil.strcmp(Z1005AdicionalOpcDescrip, T002U2_A1005AdicionalOpcDescrip[0]) != 0 )
            {
               GXutil.writeLogln("adicional:[seudo value changed for attri]"+"AdicionalOpcDescrip");
               GXutil.writeLogRaw("Old: ",Z1005AdicionalOpcDescrip);
               GXutil.writeLogRaw("Current: ",T002U2_A1005AdicionalOpcDescrip[0]);
            }
            if ( Z1008AdicionalOpcEsRango != T002U2_A1008AdicionalOpcEsRango[0] )
            {
               GXutil.writeLogln("adicional:[seudo value changed for attri]"+"AdicionalOpcEsRango");
               GXutil.writeLogRaw("Old: ",Z1008AdicionalOpcEsRango);
               GXutil.writeLogRaw("Current: ",T002U2_A1008AdicionalOpcEsRango[0]);
            }
            if ( Z1009AdicionalOpcDesde != T002U2_A1009AdicionalOpcDesde[0] )
            {
               GXutil.writeLogln("adicional:[seudo value changed for attri]"+"AdicionalOpcDesde");
               GXutil.writeLogRaw("Old: ",Z1009AdicionalOpcDesde);
               GXutil.writeLogRaw("Current: ",T002U2_A1009AdicionalOpcDesde[0]);
            }
            if ( Z1010AdicionalOpcHasta != T002U2_A1010AdicionalOpcHasta[0] )
            {
               GXutil.writeLogln("adicional:[seudo value changed for attri]"+"AdicionalOpcHasta");
               GXutil.writeLogRaw("Old: ",Z1010AdicionalOpcHasta);
               GXutil.writeLogRaw("Current: ",T002U2_A1010AdicionalOpcHasta[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"adicional_opciones"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert2U116( )
   {
      beforeValidate2U116( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2U116( ) ;
      }
      if ( AnyError == 0 )
      {
         zm2U116( 0) ;
         checkOptimisticConcurrency2U116( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2U116( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert2U116( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002U19 */
                  pr_default.execute(17, new Object[] {Short.valueOf(A46PaiCod), A988AdicionalCod, Short.valueOf(A1004AdicionalOpcCod), A1005AdicionalOpcDescrip, Boolean.valueOf(A1008AdicionalOpcEsRango), Integer.valueOf(A1009AdicionalOpcDesde), Integer.valueOf(A1010AdicionalOpcHasta)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("adicional_opciones");
                  if ( (pr_default.getStatus(17) == 1) )
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
            load2U116( ) ;
         }
         endLevel2U116( ) ;
      }
      closeExtendedTableCursors2U116( ) ;
   }

   public void update2U116( )
   {
      beforeValidate2U116( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2U116( ) ;
      }
      if ( ( nIsMod_116 != 0 ) || ( nIsDirty_116 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency2U116( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm2U116( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate2U116( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T002U20 */
                     pr_default.execute(18, new Object[] {A1005AdicionalOpcDescrip, Boolean.valueOf(A1008AdicionalOpcEsRango), Integer.valueOf(A1009AdicionalOpcDesde), Integer.valueOf(A1010AdicionalOpcHasta), Short.valueOf(A46PaiCod), A988AdicionalCod, Short.valueOf(A1004AdicionalOpcCod)});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("adicional_opciones");
                     if ( (pr_default.getStatus(18) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"adicional_opciones"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate2U116( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey2U116( ) ;
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
            endLevel2U116( ) ;
         }
      }
      closeExtendedTableCursors2U116( ) ;
   }

   public void deferredUpdate2U116( )
   {
   }

   public void delete2U116( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate2U116( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2U116( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls2U116( ) ;
         afterConfirm2U116( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete2U116( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T002U21 */
               pr_default.execute(19, new Object[] {Short.valueOf(A46PaiCod), A988AdicionalCod, Short.valueOf(A1004AdicionalOpcCod)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("adicional_opciones");
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
      sMode116 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel2U116( ) ;
      Gx_mode = sMode116 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls2U116( )
   {
      standaloneModal2U116( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel2U116( )
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

   public void scanStart2U116( )
   {
      /* Scan By routine */
      /* Using cursor T002U22 */
      pr_default.execute(20, new Object[] {Short.valueOf(A46PaiCod), A988AdicionalCod});
      RcdFound116 = (short)(0) ;
      if ( (pr_default.getStatus(20) != 101) )
      {
         RcdFound116 = (short)(1) ;
         A1004AdicionalOpcCod = T002U22_A1004AdicionalOpcCod[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext2U116( )
   {
      /* Scan next routine */
      pr_default.readNext(20);
      RcdFound116 = (short)(0) ;
      if ( (pr_default.getStatus(20) != 101) )
      {
         RcdFound116 = (short)(1) ;
         A1004AdicionalOpcCod = T002U22_A1004AdicionalOpcCod[0] ;
      }
   }

   public void scanEnd2U116( )
   {
      pr_default.close(20);
   }

   public void afterConfirm2U116( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert2U116( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate2U116( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete2U116( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete2U116( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate2U116( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes2U116( )
   {
      edtAdicionalOpcCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAdicionalOpcCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAdicionalOpcCod_Enabled), 5, 0), !bGXsfl_41_Refreshing);
      edtAdicionalOpcDescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAdicionalOpcDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAdicionalOpcDescrip_Enabled), 5, 0), !bGXsfl_41_Refreshing);
      chkAdicionalOpcEsRango.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkAdicionalOpcEsRango.getInternalname(), "Enabled", GXutil.ltrimstr( chkAdicionalOpcEsRango.getEnabled(), 5, 0), !bGXsfl_41_Refreshing);
      edtAdicionalOpcDesde_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAdicionalOpcDesde_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAdicionalOpcDesde_Enabled), 5, 0), !bGXsfl_41_Refreshing);
      edtAdicionalOpcHasta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAdicionalOpcHasta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAdicionalOpcHasta_Enabled), 5, 0), !bGXsfl_41_Refreshing);
   }

   public void send_integrity_lvl_hashes2U116( )
   {
   }

   public void send_integrity_lvl_hashes2U112( )
   {
   }

   public void subsflControlProps_41116( )
   {
      edtAdicionalOpcCod_Internalname = "ADICIONALOPCCOD_"+sGXsfl_41_idx ;
      edtAdicionalOpcDescrip_Internalname = "ADICIONALOPCDESCRIP_"+sGXsfl_41_idx ;
      chkAdicionalOpcEsRango.setInternalname( "ADICIONALOPCESRANGO_"+sGXsfl_41_idx );
      edtAdicionalOpcDesde_Internalname = "ADICIONALOPCDESDE_"+sGXsfl_41_idx ;
      edtAdicionalOpcHasta_Internalname = "ADICIONALOPCHASTA_"+sGXsfl_41_idx ;
   }

   public void subsflControlProps_fel_41116( )
   {
      edtAdicionalOpcCod_Internalname = "ADICIONALOPCCOD_"+sGXsfl_41_fel_idx ;
      edtAdicionalOpcDescrip_Internalname = "ADICIONALOPCDESCRIP_"+sGXsfl_41_fel_idx ;
      chkAdicionalOpcEsRango.setInternalname( "ADICIONALOPCESRANGO_"+sGXsfl_41_fel_idx );
      edtAdicionalOpcDesde_Internalname = "ADICIONALOPCDESDE_"+sGXsfl_41_fel_idx ;
      edtAdicionalOpcHasta_Internalname = "ADICIONALOPCHASTA_"+sGXsfl_41_fel_idx ;
   }

   public void addRow2U116( )
   {
      nGXsfl_41_idx = (int)(nGXsfl_41_idx+1) ;
      sGXsfl_41_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_41_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_41116( ) ;
      sendRow2U116( ) ;
   }

   public void sendRow2U116( )
   {
      Gridlevel_opcRow = GXWebRow.GetNew(context) ;
      if ( subGridlevel_opc_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridlevel_opc_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridlevel_opc_Class, "") != 0 )
         {
            subGridlevel_opc_Linesclass = subGridlevel_opc_Class+"Odd" ;
         }
      }
      else if ( subGridlevel_opc_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridlevel_opc_Backstyle = (byte)(0) ;
         subGridlevel_opc_Backcolor = subGridlevel_opc_Allbackcolor ;
         if ( GXutil.strcmp(subGridlevel_opc_Class, "") != 0 )
         {
            subGridlevel_opc_Linesclass = subGridlevel_opc_Class+"Uniform" ;
         }
      }
      else if ( subGridlevel_opc_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridlevel_opc_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridlevel_opc_Class, "") != 0 )
         {
            subGridlevel_opc_Linesclass = subGridlevel_opc_Class+"Odd" ;
         }
         subGridlevel_opc_Backcolor = (int)(0x0) ;
      }
      else if ( subGridlevel_opc_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridlevel_opc_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_41_idx) % (2))) == 0 )
         {
            subGridlevel_opc_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_opc_Class, "") != 0 )
            {
               subGridlevel_opc_Linesclass = subGridlevel_opc_Class+"Even" ;
            }
         }
         else
         {
            subGridlevel_opc_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_opc_Class, "") != 0 )
            {
               subGridlevel_opc_Linesclass = subGridlevel_opc_Class+"Odd" ;
            }
         }
      }
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_116_" + sGXsfl_41_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 42,'',false,'" + sGXsfl_41_idx + "',41)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel_opcRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtAdicionalOpcCod_Internalname,GXutil.ltrim( localUtil.ntoc( A1004AdicionalOpcCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1004AdicionalOpcCod), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,42);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtAdicionalOpcCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtAdicionalOpcCod_Enabled),Integer.valueOf(1),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(41),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_116_" + sGXsfl_41_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 43,'',false,'" + sGXsfl_41_idx + "',41)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel_opcRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtAdicionalOpcDescrip_Internalname,A1005AdicionalOpcDescrip,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,43);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtAdicionalOpcDescrip_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtAdicionalOpcDescrip_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(41),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"Descrip","left",Boolean.valueOf(true),""});
      /* Subfile cell */
      /* Check box */
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      GXCCtl = "ADICIONALOPCESRANGO_" + sGXsfl_41_idx ;
      chkAdicionalOpcEsRango.setName( GXCCtl );
      chkAdicionalOpcEsRango.setWebtags( "" );
      chkAdicionalOpcEsRango.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkAdicionalOpcEsRango.getInternalname(), "TitleCaption", chkAdicionalOpcEsRango.getCaption(), !bGXsfl_41_Refreshing);
      chkAdicionalOpcEsRango.setCheckedValue( "false" );
      A1008AdicionalOpcEsRango = GXutil.strtobool( GXutil.booltostr( A1008AdicionalOpcEsRango)) ;
      Gridlevel_opcRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkAdicionalOpcEsRango.getInternalname(),GXutil.booltostr( A1008AdicionalOpcEsRango),"","",Integer.valueOf(0),Integer.valueOf(chkAdicionalOpcEsRango.getEnabled()),"true","",StyleString,ClassString,"TrnColumn","",""});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "Attribute" ;
      Gridlevel_opcRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtAdicionalOpcDesde_Internalname,GXutil.ltrim( localUtil.ntoc( A1009AdicionalOpcDesde, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtAdicionalOpcDesde_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1009AdicionalOpcDesde), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1009AdicionalOpcDesde), "ZZZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtAdicionalOpcDesde_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(0),Integer.valueOf(edtAdicionalOpcDesde_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(41),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "Attribute" ;
      Gridlevel_opcRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtAdicionalOpcHasta_Internalname,GXutil.ltrim( localUtil.ntoc( A1010AdicionalOpcHasta, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtAdicionalOpcHasta_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1010AdicionalOpcHasta), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1010AdicionalOpcHasta), "ZZZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtAdicionalOpcHasta_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(0),Integer.valueOf(edtAdicionalOpcHasta_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(41),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      httpContext.ajax_sending_grid_row(Gridlevel_opcRow);
      send_integrity_lvl_hashes2U116( ) ;
      GXCCtl = "Z1004AdicionalOpcCod_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z1004AdicionalOpcCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z1005AdicionalOpcDescrip_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, Z1005AdicionalOpcDescrip);
      GXCCtl = "Z1008AdicionalOpcEsRango_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_boolean_hidden_field( httpContext, GXCCtl, Z1008AdicionalOpcEsRango);
      GXCCtl = "Z1009AdicionalOpcDesde_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z1009AdicionalOpcDesde, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z1010AdicionalOpcHasta_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z1010AdicionalOpcHasta, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdDeleted_116_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_116, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdExists_116_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_116, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nIsMod_116_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_116, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vMODE_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Gx_mode));
      GXCCtl = "vPAICOD_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV7PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vADICIONALCOD_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( AV8AdicionalCod));
      web.GxWebStd.gx_hidden_field( httpContext, "ADICIONALOPCCOD_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtAdicionalOpcCod_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "ADICIONALOPCDESCRIP_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtAdicionalOpcDescrip_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "ADICIONALOPCESRANGO_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( chkAdicionalOpcEsRango.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "ADICIONALOPCDESDE_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtAdicionalOpcDesde_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "ADICIONALOPCHASTA_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtAdicionalOpcHasta_Enabled, (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridlevel_opcContainer.AddRow(Gridlevel_opcRow);
   }

   public void readRow2U116( )
   {
      nGXsfl_41_idx = (int)(nGXsfl_41_idx+1) ;
      sGXsfl_41_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_41_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_41116( ) ;
      edtAdicionalOpcCod_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ADICIONALOPCCOD_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtAdicionalOpcDescrip_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ADICIONALOPCDESCRIP_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      chkAdicionalOpcEsRango.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "ADICIONALOPCESRANGO_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
      edtAdicionalOpcDesde_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ADICIONALOPCDESDE_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtAdicionalOpcHasta_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ADICIONALOPCHASTA_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtAdicionalOpcCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtAdicionalOpcCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
      {
         GXCCtl = "ADICIONALOPCCOD_" + sGXsfl_41_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtAdicionalOpcCod_Internalname ;
         wbErr = true ;
         A1004AdicionalOpcCod = (short)(0) ;
      }
      else
      {
         A1004AdicionalOpcCod = (short)(localUtil.ctol( httpContext.cgiGet( edtAdicionalOpcCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      A1005AdicionalOpcDescrip = httpContext.cgiGet( edtAdicionalOpcDescrip_Internalname) ;
      A1008AdicionalOpcEsRango = GXutil.strtobool( httpContext.cgiGet( chkAdicionalOpcEsRango.getInternalname())) ;
      A1009AdicionalOpcDesde = (int)(localUtil.ctol( httpContext.cgiGet( edtAdicionalOpcDesde_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      A1010AdicionalOpcHasta = (int)(localUtil.ctol( httpContext.cgiGet( edtAdicionalOpcHasta_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z1004AdicionalOpcCod_" + sGXsfl_41_idx ;
      Z1004AdicionalOpcCod = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z1005AdicionalOpcDescrip_" + sGXsfl_41_idx ;
      Z1005AdicionalOpcDescrip = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z1008AdicionalOpcEsRango_" + sGXsfl_41_idx ;
      Z1008AdicionalOpcEsRango = GXutil.strtobool( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "Z1009AdicionalOpcDesde_" + sGXsfl_41_idx ;
      Z1009AdicionalOpcDesde = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z1010AdicionalOpcHasta_" + sGXsfl_41_idx ;
      Z1010AdicionalOpcHasta = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdDeleted_116_" + sGXsfl_41_idx ;
      nRcdDeleted_116 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdExists_116_" + sGXsfl_41_idx ;
      nRcdExists_116 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nIsMod_116_" + sGXsfl_41_idx ;
      nIsMod_116 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
   }

   public void assign_properties_default( )
   {
      defedtAdicionalOpcHasta_Enabled = edtAdicionalOpcHasta_Enabled ;
      defedtAdicionalOpcDesde_Enabled = edtAdicionalOpcDesde_Enabled ;
      defchkAdicionalOpcEsRango_Enabled = chkAdicionalOpcEsRango.getEnabled() ;
      defedtAdicionalOpcCod_Enabled = edtAdicionalOpcCod_Enabled ;
   }

   public void confirmValues2U0( )
   {
      nGXsfl_41_idx = 0 ;
      sGXsfl_41_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_41_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_41116( ) ;
      while ( nGXsfl_41_idx < nRC_GXsfl_41 )
      {
         nGXsfl_41_idx = (int)(nGXsfl_41_idx+1) ;
         sGXsfl_41_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_41_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_41116( ) ;
         httpContext.changePostValue( "Z1004AdicionalOpcCod_"+sGXsfl_41_idx, httpContext.cgiGet( "ZT_"+"Z1004AdicionalOpcCod_"+sGXsfl_41_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1004AdicionalOpcCod_"+sGXsfl_41_idx) ;
         httpContext.changePostValue( "Z1005AdicionalOpcDescrip_"+sGXsfl_41_idx, httpContext.cgiGet( "ZT_"+"Z1005AdicionalOpcDescrip_"+sGXsfl_41_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1005AdicionalOpcDescrip_"+sGXsfl_41_idx) ;
         httpContext.changePostValue( "Z1008AdicionalOpcEsRango_"+sGXsfl_41_idx, httpContext.cgiGet( "ZT_"+"Z1008AdicionalOpcEsRango_"+sGXsfl_41_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1008AdicionalOpcEsRango_"+sGXsfl_41_idx) ;
         httpContext.changePostValue( "Z1009AdicionalOpcDesde_"+sGXsfl_41_idx, httpContext.cgiGet( "ZT_"+"Z1009AdicionalOpcDesde_"+sGXsfl_41_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1009AdicionalOpcDesde_"+sGXsfl_41_idx) ;
         httpContext.changePostValue( "Z1010AdicionalOpcHasta_"+sGXsfl_41_idx, httpContext.cgiGet( "ZT_"+"Z1010AdicionalOpcHasta_"+sGXsfl_41_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1010AdicionalOpcHasta_"+sGXsfl_41_idx) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.adicional", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7PaiCod,4,0)),GXutil.URLEncode(GXutil.rtrim(AV8AdicionalCod))}, new String[] {"Gx_mode","PaiCod","AdicionalCod"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Adicional");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("adicional:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z46PaiCod", GXutil.ltrim( localUtil.ntoc( Z46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z988AdicionalCod", GXutil.rtrim( Z988AdicionalCod));
      web.GxWebStd.gx_hidden_field( httpContext, "Z989AdicionalDescrip", Z989AdicionalDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "Z991AdicionalUniMed", GXutil.rtrim( Z991AdicionalUniMed));
      web.GxWebStd.gx_hidden_field( httpContext, "Z992AdicionalTipo", GXutil.rtrim( Z992AdicionalTipo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1784AdicionalReservado", GXutil.rtrim( Z1784AdicionalReservado));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_41", GXutil.ltrim( localUtil.ntoc( nGXsfl_41_idx, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vPAICOD", GXutil.ltrim( localUtil.ntoc( AV7PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vADICIONALCOD", GXutil.rtrim( AV8AdicionalCod));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vADICIONALCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8AdicionalCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV14Pgmname));
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
      return formatLink("web.adicional", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7PaiCod,4,0)),GXutil.URLEncode(GXutil.rtrim(AV8AdicionalCod))}, new String[] {"Gx_mode","PaiCod","AdicionalCod"})  ;
   }

   public String getPgmname( )
   {
      return "Adicional" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Adicional", "") ;
   }

   public void initializeNonKey2U112( )
   {
      A989AdicionalDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A989AdicionalDescrip", A989AdicionalDescrip);
      A991AdicionalUniMed = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A991AdicionalUniMed", A991AdicionalUniMed);
      A992AdicionalTipo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A992AdicionalTipo", A992AdicionalTipo);
      A1784AdicionalReservado = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1784AdicionalReservado", A1784AdicionalReservado);
      Z989AdicionalDescrip = "" ;
      Z991AdicionalUniMed = "" ;
      Z992AdicionalTipo = "" ;
      Z1784AdicionalReservado = "" ;
   }

   public void initAll2U112( )
   {
      A46PaiCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      A988AdicionalCod = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A988AdicionalCod", A988AdicionalCod);
      initializeNonKey2U112( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void initializeNonKey2U116( )
   {
      A1005AdicionalOpcDescrip = "" ;
      A1008AdicionalOpcEsRango = false ;
      A1009AdicionalOpcDesde = 0 ;
      A1010AdicionalOpcHasta = 0 ;
      Z1005AdicionalOpcDescrip = "" ;
      Z1008AdicionalOpcEsRango = false ;
      Z1009AdicionalOpcDesde = 0 ;
      Z1010AdicionalOpcHasta = 0 ;
   }

   public void initAll2U116( )
   {
      A1004AdicionalOpcCod = (short)(0) ;
      initializeNonKey2U116( ) ;
   }

   public void standaloneModalInsert2U116( )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20241220194089", true, true);
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
      httpContext.AddJavascriptSource("adicional.js", "?202412201940810", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_level_properties116( )
   {
      edtAdicionalOpcHasta_Enabled = defedtAdicionalOpcHasta_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtAdicionalOpcHasta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAdicionalOpcHasta_Enabled), 5, 0), !bGXsfl_41_Refreshing);
      edtAdicionalOpcDesde_Enabled = defedtAdicionalOpcDesde_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtAdicionalOpcDesde_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAdicionalOpcDesde_Enabled), 5, 0), !bGXsfl_41_Refreshing);
      chkAdicionalOpcEsRango.setEnabled( defchkAdicionalOpcEsRango_Enabled );
      httpContext.ajax_rsp_assign_prop("", false, chkAdicionalOpcEsRango.getInternalname(), "Enabled", GXutil.ltrimstr( chkAdicionalOpcEsRango.getEnabled(), 5, 0), !bGXsfl_41_Refreshing);
      edtAdicionalOpcCod_Enabled = defedtAdicionalOpcCod_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtAdicionalOpcCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAdicionalOpcCod_Enabled), 5, 0), !bGXsfl_41_Refreshing);
   }

   public void startgridcontrol41( )
   {
      Gridlevel_opcContainer.AddObjectProperty("GridName", "Gridlevel_opc");
      Gridlevel_opcContainer.AddObjectProperty("Header", subGridlevel_opc_Header);
      Gridlevel_opcContainer.AddObjectProperty("Class", "WorkWith");
      Gridlevel_opcContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_opcContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_opcContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_opc_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_opcContainer.AddObjectProperty("CmpContext", "");
      Gridlevel_opcContainer.AddObjectProperty("InMasterPage", "false");
      Gridlevel_opcColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_opcColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1004AdicionalOpcCod, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_opcColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtAdicionalOpcCod_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_opcContainer.AddColumnProperties(Gridlevel_opcColumn);
      Gridlevel_opcColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_opcColumn.AddObjectProperty("Value", A1005AdicionalOpcDescrip);
      Gridlevel_opcColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtAdicionalOpcDescrip_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_opcContainer.AddColumnProperties(Gridlevel_opcColumn);
      Gridlevel_opcColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_opcColumn.AddObjectProperty("Value", GXutil.booltostr( A1008AdicionalOpcEsRango));
      Gridlevel_opcColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( chkAdicionalOpcEsRango.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      Gridlevel_opcContainer.AddColumnProperties(Gridlevel_opcColumn);
      Gridlevel_opcColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_opcColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1009AdicionalOpcDesde, (byte)(8), (byte)(0), ".", "")));
      Gridlevel_opcColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtAdicionalOpcDesde_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_opcContainer.AddColumnProperties(Gridlevel_opcColumn);
      Gridlevel_opcColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_opcColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1010AdicionalOpcHasta, (byte)(8), (byte)(0), ".", "")));
      Gridlevel_opcColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtAdicionalOpcHasta_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_opcContainer.AddColumnProperties(Gridlevel_opcColumn);
      Gridlevel_opcContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel_opc_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_opcContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel_opc_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_opcContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_opc_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_opcContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel_opc_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_opcContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_opc_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_opcContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel_opc_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_opcContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel_opc_Collapsed, (byte)(1), (byte)(0), ".", "")));
   }

   public void init_default_properties( )
   {
      edtAdicionalCod_Internalname = "ADICIONALCOD" ;
      edtAdicionalDescrip_Internalname = "ADICIONALDESCRIP" ;
      cmbAdicionalReservado.setInternalname( "ADICIONALRESERVADO" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      edtAdicionalOpcCod_Internalname = "ADICIONALOPCCOD" ;
      edtAdicionalOpcDescrip_Internalname = "ADICIONALOPCDESCRIP" ;
      chkAdicionalOpcEsRango.setInternalname( "ADICIONALOPCESRANGO" );
      edtAdicionalOpcDesde_Internalname = "ADICIONALOPCDESDE" ;
      edtAdicionalOpcHasta_Internalname = "ADICIONALOPCHASTA" ;
      divTableleaflevel_opc_Internalname = "TABLELEAFLEVEL_OPC" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtPaiCod_Internalname = "PAICOD" ;
      edtAdicionalUniMed_Internalname = "ADICIONALUNIMED" ;
      cmbAdicionalTipo.setInternalname( "ADICIONALTIPO" );
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridlevel_opc_Internalname = "GRIDLEVEL_OPC" ;
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
      subGridlevel_opc_Allowcollapsing = (byte)(0) ;
      subGridlevel_opc_Allowselection = (byte)(0) ;
      subGridlevel_opc_Header = "" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Adicional", "") );
      edtAdicionalOpcHasta_Jsonclick = "" ;
      edtAdicionalOpcDesde_Jsonclick = "" ;
      chkAdicionalOpcEsRango.setCaption( "" );
      edtAdicionalOpcDescrip_Jsonclick = "" ;
      edtAdicionalOpcCod_Jsonclick = "" ;
      subGridlevel_opc_Class = "WorkWith" ;
      subGridlevel_opc_Backcolorstyle = (byte)(0) ;
      cmbAdicionalTipo.setJsonclick( "" );
      cmbAdicionalTipo.setVisible( 1 );
      cmbAdicionalTipo.setEnabled( 1 );
      edtAdicionalUniMed_Jsonclick = "" ;
      edtAdicionalUniMed_Enabled = 1 ;
      edtAdicionalUniMed_Visible = 1 ;
      edtPaiCod_Jsonclick = "" ;
      edtPaiCod_Enabled = 1 ;
      edtPaiCod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtAdicionalOpcHasta_Enabled = 0 ;
      edtAdicionalOpcDesde_Enabled = 0 ;
      chkAdicionalOpcEsRango.setEnabled( 0 );
      edtAdicionalOpcDescrip_Enabled = 1 ;
      edtAdicionalOpcCod_Enabled = 1 ;
      cmbAdicionalReservado.setJsonclick( "" );
      cmbAdicionalReservado.setEnabled( 1 );
      edtAdicionalDescrip_Enabled = 1 ;
      edtAdicionalCod_Jsonclick = "" ;
      edtAdicionalCod_Enabled = 1 ;
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

   public void gxnrgridlevel_opc_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_41116( ) ;
      while ( nGXsfl_41_idx <= nRC_GXsfl_41 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal2U116( ) ;
         standaloneModal2U116( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow2U116( ) ;
         nGXsfl_41_idx = (int)(nGXsfl_41_idx+1) ;
         sGXsfl_41_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_41_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_41116( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel_opcContainer)) ;
      /* End function gxnrGridlevel_opc_newrow */
   }

   public void init_web_controls( )
   {
      cmbAdicionalReservado.setName( "ADICIONALRESERVADO" );
      cmbAdicionalReservado.setWebtags( "" );
      cmbAdicionalReservado.addItem("antiguedad", httpContext.getMessage( "Antiguedad", ""), (short)(0));
      cmbAdicionalReservado.addItem("presentismo", httpContext.getMessage( "Presentismo", ""), (short)(0));
      if ( cmbAdicionalReservado.getItemCount() > 0 )
      {
         A1784AdicionalReservado = cmbAdicionalReservado.getValidValue(A1784AdicionalReservado) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1784AdicionalReservado", A1784AdicionalReservado);
      }
      GXCCtl = "ADICIONALOPCESRANGO_" + sGXsfl_41_idx ;
      chkAdicionalOpcEsRango.setName( GXCCtl );
      chkAdicionalOpcEsRango.setWebtags( "" );
      chkAdicionalOpcEsRango.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkAdicionalOpcEsRango.getInternalname(), "TitleCaption", chkAdicionalOpcEsRango.getCaption(), !bGXsfl_41_Refreshing);
      chkAdicionalOpcEsRango.setCheckedValue( "false" );
      A1008AdicionalOpcEsRango = GXutil.strtobool( GXutil.booltostr( A1008AdicionalOpcEsRango)) ;
      cmbAdicionalTipo.setName( "ADICIONALTIPO" );
      cmbAdicionalTipo.setWebtags( "" );
      cmbAdicionalTipo.addItem("NUM", httpContext.getMessage( "Numérico", ""), (short)(0));
      cmbAdicionalTipo.addItem("STR", httpContext.getMessage( "Texto", ""), (short)(0));
      cmbAdicionalTipo.addItem("BOOL", httpContext.getMessage( "Boolean", ""), (short)(0));
      cmbAdicionalTipo.addItem("DATE", httpContext.getMessage( "Fecha", ""), (short)(0));
      if ( cmbAdicionalTipo.getItemCount() > 0 )
      {
         A992AdicionalTipo = cmbAdicionalTipo.getValidValue(A992AdicionalTipo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A992AdicionalTipo", A992AdicionalTipo);
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

   public void valid_Paicod( )
   {
      /* Using cursor T002U23 */
      pr_default.execute(21, new Object[] {Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(21) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
      }
      pr_default.close(21);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV8AdicionalCod',fld:'vADICIONALCOD',pic:'',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV8AdicionalCod',fld:'vADICIONALCOD',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e122U2',iparms:[]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_ADICIONALCOD","{handler:'valid_Adicionalcod',iparms:[]");
      setEventMetadata("VALID_ADICIONALCOD",",oparms:[]}");
      setEventMetadata("VALID_ADICIONALRESERVADO","{handler:'valid_Adicionalreservado',iparms:[]");
      setEventMetadata("VALID_ADICIONALRESERVADO",",oparms:[]}");
      setEventMetadata("VALID_PAICOD","{handler:'valid_Paicod',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'}]");
      setEventMetadata("VALID_PAICOD",",oparms:[]}");
      setEventMetadata("VALID_ADICIONALTIPO","{handler:'valid_Adicionaltipo',iparms:[]");
      setEventMetadata("VALID_ADICIONALTIPO",",oparms:[]}");
      setEventMetadata("VALID_ADICIONALOPCCOD","{handler:'valid_Adicionalopccod',iparms:[]");
      setEventMetadata("VALID_ADICIONALOPCCOD",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Adicionalopchasta',iparms:[]");
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
      pr_default.close(21);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV8AdicionalCod = "" ;
      Z988AdicionalCod = "" ;
      Z989AdicionalDescrip = "" ;
      Z991AdicionalUniMed = "" ;
      Z992AdicionalTipo = "" ;
      Z1784AdicionalReservado = "" ;
      Z1005AdicionalOpcDescrip = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      AV8AdicionalCod = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A1784AdicionalReservado = "" ;
      A992AdicionalTipo = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A988AdicionalCod = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A989AdicionalDescrip = "" ;
      Gridlevel_opcContainer = new com.genexus.webpanels.GXWebGrid(context);
      sMode116 = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A991AdicionalUniMed = "" ;
      AV14Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode112 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      GXCCtl = "" ;
      A1005AdicionalOpcDescrip = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV12TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV13WebSession = httpContext.getWebSession();
      T002U7_A988AdicionalCod = new String[] {""} ;
      T002U7_A989AdicionalDescrip = new String[] {""} ;
      T002U7_A991AdicionalUniMed = new String[] {""} ;
      T002U7_A992AdicionalTipo = new String[] {""} ;
      T002U7_A1784AdicionalReservado = new String[] {""} ;
      T002U7_A46PaiCod = new short[1] ;
      T002U6_A46PaiCod = new short[1] ;
      T002U8_A46PaiCod = new short[1] ;
      T002U9_A46PaiCod = new short[1] ;
      T002U9_A988AdicionalCod = new String[] {""} ;
      T002U5_A988AdicionalCod = new String[] {""} ;
      T002U5_A989AdicionalDescrip = new String[] {""} ;
      T002U5_A991AdicionalUniMed = new String[] {""} ;
      T002U5_A992AdicionalTipo = new String[] {""} ;
      T002U5_A1784AdicionalReservado = new String[] {""} ;
      T002U5_A46PaiCod = new short[1] ;
      T002U10_A46PaiCod = new short[1] ;
      T002U10_A988AdicionalCod = new String[] {""} ;
      T002U11_A46PaiCod = new short[1] ;
      T002U11_A988AdicionalCod = new String[] {""} ;
      T002U4_A988AdicionalCod = new String[] {""} ;
      T002U4_A989AdicionalDescrip = new String[] {""} ;
      T002U4_A991AdicionalUniMed = new String[] {""} ;
      T002U4_A992AdicionalTipo = new String[] {""} ;
      T002U4_A1784AdicionalReservado = new String[] {""} ;
      T002U4_A46PaiCod = new short[1] ;
      T002U15_A903ActComCodigo = new String[] {""} ;
      T002U15_A993ActComAdiPai = new short[1] ;
      T002U15_A994ActComAdiCod = new String[] {""} ;
      T002U16_A46PaiCod = new short[1] ;
      T002U16_A988AdicionalCod = new String[] {""} ;
      T002U17_A46PaiCod = new short[1] ;
      T002U17_A988AdicionalCod = new String[] {""} ;
      T002U17_A1004AdicionalOpcCod = new short[1] ;
      T002U17_A1005AdicionalOpcDescrip = new String[] {""} ;
      T002U17_A1008AdicionalOpcEsRango = new boolean[] {false} ;
      T002U17_A1009AdicionalOpcDesde = new int[1] ;
      T002U17_A1010AdicionalOpcHasta = new int[1] ;
      T002U18_A46PaiCod = new short[1] ;
      T002U18_A988AdicionalCod = new String[] {""} ;
      T002U18_A1004AdicionalOpcCod = new short[1] ;
      T002U3_A46PaiCod = new short[1] ;
      T002U3_A988AdicionalCod = new String[] {""} ;
      T002U3_A1004AdicionalOpcCod = new short[1] ;
      T002U3_A1005AdicionalOpcDescrip = new String[] {""} ;
      T002U3_A1008AdicionalOpcEsRango = new boolean[] {false} ;
      T002U3_A1009AdicionalOpcDesde = new int[1] ;
      T002U3_A1010AdicionalOpcHasta = new int[1] ;
      T002U2_A46PaiCod = new short[1] ;
      T002U2_A988AdicionalCod = new String[] {""} ;
      T002U2_A1004AdicionalOpcCod = new short[1] ;
      T002U2_A1005AdicionalOpcDescrip = new String[] {""} ;
      T002U2_A1008AdicionalOpcEsRango = new boolean[] {false} ;
      T002U2_A1009AdicionalOpcDesde = new int[1] ;
      T002U2_A1010AdicionalOpcHasta = new int[1] ;
      T002U22_A46PaiCod = new short[1] ;
      T002U22_A988AdicionalCod = new String[] {""} ;
      T002U22_A1004AdicionalOpcCod = new short[1] ;
      Gridlevel_opcRow = new com.genexus.webpanels.GXWebRow();
      subGridlevel_opc_Linesclass = "" ;
      ROClassString = "" ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      Gridlevel_opcColumn = new com.genexus.webpanels.GXWebColumn();
      T002U23_A46PaiCod = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.adicional__default(),
         new Object[] {
             new Object[] {
            T002U2_A46PaiCod, T002U2_A988AdicionalCod, T002U2_A1004AdicionalOpcCod, T002U2_A1005AdicionalOpcDescrip, T002U2_A1008AdicionalOpcEsRango, T002U2_A1009AdicionalOpcDesde, T002U2_A1010AdicionalOpcHasta
            }
            , new Object[] {
            T002U3_A46PaiCod, T002U3_A988AdicionalCod, T002U3_A1004AdicionalOpcCod, T002U3_A1005AdicionalOpcDescrip, T002U3_A1008AdicionalOpcEsRango, T002U3_A1009AdicionalOpcDesde, T002U3_A1010AdicionalOpcHasta
            }
            , new Object[] {
            T002U4_A988AdicionalCod, T002U4_A989AdicionalDescrip, T002U4_A991AdicionalUniMed, T002U4_A992AdicionalTipo, T002U4_A1784AdicionalReservado, T002U4_A46PaiCod
            }
            , new Object[] {
            T002U5_A988AdicionalCod, T002U5_A989AdicionalDescrip, T002U5_A991AdicionalUniMed, T002U5_A992AdicionalTipo, T002U5_A1784AdicionalReservado, T002U5_A46PaiCod
            }
            , new Object[] {
            T002U6_A46PaiCod
            }
            , new Object[] {
            T002U7_A988AdicionalCod, T002U7_A989AdicionalDescrip, T002U7_A991AdicionalUniMed, T002U7_A992AdicionalTipo, T002U7_A1784AdicionalReservado, T002U7_A46PaiCod
            }
            , new Object[] {
            T002U8_A46PaiCod
            }
            , new Object[] {
            T002U9_A46PaiCod, T002U9_A988AdicionalCod
            }
            , new Object[] {
            T002U10_A46PaiCod, T002U10_A988AdicionalCod
            }
            , new Object[] {
            T002U11_A46PaiCod, T002U11_A988AdicionalCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T002U15_A903ActComCodigo, T002U15_A993ActComAdiPai, T002U15_A994ActComAdiCod
            }
            , new Object[] {
            T002U16_A46PaiCod, T002U16_A988AdicionalCod
            }
            , new Object[] {
            T002U17_A46PaiCod, T002U17_A988AdicionalCod, T002U17_A1004AdicionalOpcCod, T002U17_A1005AdicionalOpcDescrip, T002U17_A1008AdicionalOpcEsRango, T002U17_A1009AdicionalOpcDesde, T002U17_A1010AdicionalOpcHasta
            }
            , new Object[] {
            T002U18_A46PaiCod, T002U18_A988AdicionalCod, T002U18_A1004AdicionalOpcCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T002U22_A46PaiCod, T002U22_A988AdicionalCod, T002U22_A1004AdicionalOpcCod
            }
            , new Object[] {
            T002U23_A46PaiCod
            }
         }
      );
      AV14Pgmname = "Adicional" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte subGridlevel_opc_Backcolorstyle ;
   private byte subGridlevel_opc_Backstyle ;
   private byte gxajaxcallmode ;
   private byte subGridlevel_opc_Allowselection ;
   private byte subGridlevel_opc_Allowhovering ;
   private byte subGridlevel_opc_Allowcollapsing ;
   private byte subGridlevel_opc_Collapsed ;
   private short wcpOAV7PaiCod ;
   private short Z46PaiCod ;
   private short Z1004AdicionalOpcCod ;
   private short nRcdDeleted_116 ;
   private short nRcdExists_116 ;
   private short nIsMod_116 ;
   private short A46PaiCod ;
   private short AV7PaiCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short nBlankRcdCount116 ;
   private short RcdFound116 ;
   private short nBlankRcdUsr116 ;
   private short RcdFound112 ;
   private short A1004AdicionalOpcCod ;
   private short nIsDirty_112 ;
   private short nIsDirty_116 ;
   private int nRC_GXsfl_41 ;
   private int nGXsfl_41_idx=1 ;
   private int Z1009AdicionalOpcDesde ;
   private int Z1010AdicionalOpcHasta ;
   private int trnEnded ;
   private int edtAdicionalCod_Enabled ;
   private int edtAdicionalDescrip_Enabled ;
   private int edtAdicionalOpcCod_Enabled ;
   private int edtAdicionalOpcDescrip_Enabled ;
   private int edtAdicionalOpcDesde_Enabled ;
   private int edtAdicionalOpcHasta_Enabled ;
   private int fRowAdded ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtPaiCod_Visible ;
   private int edtPaiCod_Enabled ;
   private int edtAdicionalUniMed_Visible ;
   private int edtAdicionalUniMed_Enabled ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int A1009AdicionalOpcDesde ;
   private int A1010AdicionalOpcHasta ;
   private int GX_JID ;
   private int subGridlevel_opc_Backcolor ;
   private int subGridlevel_opc_Allbackcolor ;
   private int defedtAdicionalOpcHasta_Enabled ;
   private int defedtAdicionalOpcDesde_Enabled ;
   private int defchkAdicionalOpcEsRango_Enabled ;
   private int defedtAdicionalOpcCod_Enabled ;
   private int idxLst ;
   private int subGridlevel_opc_Selectedindex ;
   private int subGridlevel_opc_Selectioncolor ;
   private int subGridlevel_opc_Hoveringcolor ;
   private long GRIDLEVEL_OPC_nFirstRecordOnPage ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV8AdicionalCod ;
   private String Z988AdicionalCod ;
   private String Z991AdicionalUniMed ;
   private String Z992AdicionalTipo ;
   private String Z1784AdicionalReservado ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String AV8AdicionalCod ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtAdicionalCod_Internalname ;
   private String sGXsfl_41_idx="0001" ;
   private String A1784AdicionalReservado ;
   private String A992AdicionalTipo ;
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
   private String A988AdicionalCod ;
   private String edtAdicionalCod_Jsonclick ;
   private String edtAdicionalDescrip_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTableleaflevel_opc_Internalname ;
   private String sMode116 ;
   private String edtAdicionalOpcCod_Internalname ;
   private String edtAdicionalOpcDescrip_Internalname ;
   private String edtAdicionalOpcDesde_Internalname ;
   private String edtAdicionalOpcHasta_Internalname ;
   private String subGridlevel_opc_Internalname ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtPaiCod_Internalname ;
   private String edtPaiCod_Jsonclick ;
   private String edtAdicionalUniMed_Internalname ;
   private String A991AdicionalUniMed ;
   private String edtAdicionalUniMed_Jsonclick ;
   private String AV14Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode112 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXCCtl ;
   private String sGXsfl_41_fel_idx="0001" ;
   private String subGridlevel_opc_Class ;
   private String subGridlevel_opc_Linesclass ;
   private String ROClassString ;
   private String edtAdicionalOpcCod_Jsonclick ;
   private String edtAdicionalOpcDescrip_Jsonclick ;
   private String edtAdicionalOpcDesde_Jsonclick ;
   private String edtAdicionalOpcHasta_Jsonclick ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String subGridlevel_opc_Header ;
   private boolean Z1008AdicionalOpcEsRango ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean bGXsfl_41_Refreshing=false ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean A1008AdicionalOpcEsRango ;
   private boolean returnInSub ;
   private boolean AV10IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private String Z989AdicionalDescrip ;
   private String Z1005AdicionalOpcDescrip ;
   private String A989AdicionalDescrip ;
   private String A1005AdicionalOpcDescrip ;
   private com.genexus.webpanels.GXWebGrid Gridlevel_opcContainer ;
   private com.genexus.webpanels.GXWebRow Gridlevel_opcRow ;
   private com.genexus.webpanels.GXWebColumn Gridlevel_opcColumn ;
   private com.genexus.webpanels.WebSession AV13WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbAdicionalReservado ;
   private ICheckbox chkAdicionalOpcEsRango ;
   private HTMLChoice cmbAdicionalTipo ;
   private IDataStoreProvider pr_default ;
   private String[] T002U7_A988AdicionalCod ;
   private String[] T002U7_A989AdicionalDescrip ;
   private String[] T002U7_A991AdicionalUniMed ;
   private String[] T002U7_A992AdicionalTipo ;
   private String[] T002U7_A1784AdicionalReservado ;
   private short[] T002U7_A46PaiCod ;
   private short[] T002U6_A46PaiCod ;
   private short[] T002U8_A46PaiCod ;
   private short[] T002U9_A46PaiCod ;
   private String[] T002U9_A988AdicionalCod ;
   private String[] T002U5_A988AdicionalCod ;
   private String[] T002U5_A989AdicionalDescrip ;
   private String[] T002U5_A991AdicionalUniMed ;
   private String[] T002U5_A992AdicionalTipo ;
   private String[] T002U5_A1784AdicionalReservado ;
   private short[] T002U5_A46PaiCod ;
   private short[] T002U10_A46PaiCod ;
   private String[] T002U10_A988AdicionalCod ;
   private short[] T002U11_A46PaiCod ;
   private String[] T002U11_A988AdicionalCod ;
   private String[] T002U4_A988AdicionalCod ;
   private String[] T002U4_A989AdicionalDescrip ;
   private String[] T002U4_A991AdicionalUniMed ;
   private String[] T002U4_A992AdicionalTipo ;
   private String[] T002U4_A1784AdicionalReservado ;
   private short[] T002U4_A46PaiCod ;
   private String[] T002U15_A903ActComCodigo ;
   private short[] T002U15_A993ActComAdiPai ;
   private String[] T002U15_A994ActComAdiCod ;
   private short[] T002U16_A46PaiCod ;
   private String[] T002U16_A988AdicionalCod ;
   private short[] T002U17_A46PaiCod ;
   private String[] T002U17_A988AdicionalCod ;
   private short[] T002U17_A1004AdicionalOpcCod ;
   private String[] T002U17_A1005AdicionalOpcDescrip ;
   private boolean[] T002U17_A1008AdicionalOpcEsRango ;
   private int[] T002U17_A1009AdicionalOpcDesde ;
   private int[] T002U17_A1010AdicionalOpcHasta ;
   private short[] T002U18_A46PaiCod ;
   private String[] T002U18_A988AdicionalCod ;
   private short[] T002U18_A1004AdicionalOpcCod ;
   private short[] T002U3_A46PaiCod ;
   private String[] T002U3_A988AdicionalCod ;
   private short[] T002U3_A1004AdicionalOpcCod ;
   private String[] T002U3_A1005AdicionalOpcDescrip ;
   private boolean[] T002U3_A1008AdicionalOpcEsRango ;
   private int[] T002U3_A1009AdicionalOpcDesde ;
   private int[] T002U3_A1010AdicionalOpcHasta ;
   private short[] T002U2_A46PaiCod ;
   private String[] T002U2_A988AdicionalCod ;
   private short[] T002U2_A1004AdicionalOpcCod ;
   private String[] T002U2_A1005AdicionalOpcDescrip ;
   private boolean[] T002U2_A1008AdicionalOpcEsRango ;
   private int[] T002U2_A1009AdicionalOpcDesde ;
   private int[] T002U2_A1010AdicionalOpcHasta ;
   private short[] T002U22_A46PaiCod ;
   private String[] T002U22_A988AdicionalCod ;
   private short[] T002U22_A1004AdicionalOpcCod ;
   private short[] T002U23_A46PaiCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV12TrnContext ;
}

final  class adicional__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T002U2", "SELECT PaiCod, AdicionalCod, AdicionalOpcCod, AdicionalOpcDescrip, AdicionalOpcEsRango, AdicionalOpcDesde, AdicionalOpcHasta FROM adicional_opciones WHERE PaiCod = ? AND AdicionalCod = ? AND AdicionalOpcCod = ?  FOR UPDATE OF adicional_opciones NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002U3", "SELECT PaiCod, AdicionalCod, AdicionalOpcCod, AdicionalOpcDescrip, AdicionalOpcEsRango, AdicionalOpcDesde, AdicionalOpcHasta FROM adicional_opciones WHERE PaiCod = ? AND AdicionalCod = ? AND AdicionalOpcCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002U4", "SELECT AdicionalCod, AdicionalDescrip, AdicionalUniMed, AdicionalTipo, AdicionalReservado, PaiCod FROM Adicional WHERE PaiCod = ? AND AdicionalCod = ?  FOR UPDATE OF Adicional NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002U5", "SELECT AdicionalCod, AdicionalDescrip, AdicionalUniMed, AdicionalTipo, AdicionalReservado, PaiCod FROM Adicional WHERE PaiCod = ? AND AdicionalCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002U6", "SELECT PaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002U7", "SELECT TM1.AdicionalCod, TM1.AdicionalDescrip, TM1.AdicionalUniMed, TM1.AdicionalTipo, TM1.AdicionalReservado, TM1.PaiCod FROM Adicional TM1 WHERE TM1.PaiCod = ? and TM1.AdicionalCod = ( ?) ORDER BY TM1.PaiCod, TM1.AdicionalCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002U8", "SELECT PaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002U9", "SELECT PaiCod, AdicionalCod FROM Adicional WHERE PaiCod = ? AND AdicionalCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002U10", "SELECT PaiCod, AdicionalCod FROM Adicional WHERE ( PaiCod > ? or PaiCod = ? and AdicionalCod > ( ?)) ORDER BY PaiCod, AdicionalCod  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002U11", "SELECT PaiCod, AdicionalCod FROM Adicional WHERE ( PaiCod < ? or PaiCod = ? and AdicionalCod < ( ?)) ORDER BY PaiCod DESC, AdicionalCod DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T002U12", "SAVEPOINT gxupdate;INSERT INTO Adicional(AdicionalCod, AdicionalDescrip, AdicionalUniMed, AdicionalTipo, AdicionalReservado, PaiCod) VALUES(?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002U13", "SAVEPOINT gxupdate;UPDATE Adicional SET AdicionalDescrip=?, AdicionalUniMed=?, AdicionalTipo=?, AdicionalReservado=?  WHERE PaiCod = ? AND AdicionalCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002U14", "SAVEPOINT gxupdate;DELETE FROM Adicional  WHERE PaiCod = ? AND AdicionalCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T002U15", "SELECT ActComCodigo, ActComAdiPai, ActComAdiCod FROM adicional_actividad WHERE ActComAdiPai = ? AND ActComAdiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002U16", "SELECT PaiCod, AdicionalCod FROM Adicional ORDER BY PaiCod, AdicionalCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002U17", "SELECT PaiCod, AdicionalCod, AdicionalOpcCod, AdicionalOpcDescrip, AdicionalOpcEsRango, AdicionalOpcDesde, AdicionalOpcHasta FROM adicional_opciones WHERE PaiCod = ? and AdicionalCod = ( ?) and AdicionalOpcCod = ? ORDER BY PaiCod, AdicionalCod, AdicionalOpcCod ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002U18", "SELECT PaiCod, AdicionalCod, AdicionalOpcCod FROM adicional_opciones WHERE PaiCod = ? AND AdicionalCod = ? AND AdicionalOpcCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T002U19", "SAVEPOINT gxupdate;INSERT INTO adicional_opciones(PaiCod, AdicionalCod, AdicionalOpcCod, AdicionalOpcDescrip, AdicionalOpcEsRango, AdicionalOpcDesde, AdicionalOpcHasta, AdiOpcCodFor) VALUES(?, ?, ?, ?, ?, ?, ?, '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002U20", "SAVEPOINT gxupdate;UPDATE adicional_opciones SET AdicionalOpcDescrip=?, AdicionalOpcEsRango=?, AdicionalOpcDesde=?, AdicionalOpcHasta=?  WHERE PaiCod = ? AND AdicionalCod = ? AND AdicionalOpcCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002U21", "SAVEPOINT gxupdate;DELETE FROM adicional_opciones  WHERE PaiCod = ? AND AdicionalCod = ? AND AdicionalOpcCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T002U22", "SELECT PaiCod, AdicionalCod, AdicionalOpcCod FROM adicional_opciones WHERE PaiCod = ? and AdicionalCod = ( ?) ORDER BY PaiCod, AdicionalCod, AdicionalOpcCod ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002U23", "SELECT PaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 8 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 9 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 14 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 15 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               return;
            case 16 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 20 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 21 :
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 9 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 10 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 11 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setString(6, (String)parms[5], 20);
               return;
            case 12 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 13 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 16 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 17 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setBoolean(5, ((Boolean) parms[4]).booleanValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               return;
            case 18 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setBoolean(2, ((Boolean) parms[1]).booleanValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               return;
            case 19 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 20 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 21 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

