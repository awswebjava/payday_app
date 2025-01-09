package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class empresabancoswwexport extends GXProcedure
{
   public empresabancoswwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empresabancoswwexport.class ), "" );
   }

   public empresabancoswwexport( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      empresabancoswwexport.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String[] aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String[] aP0 ,
                             String[] aP1 )
   {
      empresabancoswwexport.this.aP0 = aP0;
      empresabancoswwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresaBancos", GXv_boolean2) ;
      empresabancoswwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV59Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         /* Execute user subroutine: 'OPENDOCUMENT' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV14CellRow = 1 ;
         AV15FirstColumn = 1 ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S201 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'WRITEFILTERS' */
         S131 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'WRITECOLUMNTITLES' */
         S141 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'WRITEDATA' */
         S161 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'CLOSEDOCUMENT' */
         S191 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'OPENDOCUMENT' Routine */
      returnInSub = false ;
      AV16Random = (int)(GXutil.random( )*10000) ;
      AV12Filename = "EmpresaBancosWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
      AV11ExcelDocument.Open(AV12Filename);
      /* Execute user subroutine: 'CHECKSTATUS' */
      S121 ();
      if (returnInSub) return;
      AV11ExcelDocument.Clear();
   }

   public void S131( )
   {
      /* 'WRITEFILTERS' Routine */
      returnInSub = false ;
      if ( ! ( ( AV37TFEmpBanDescrip_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Banco", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresabancoswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV54i = 1 ;
         AV60GXV1 = 1 ;
         while ( AV60GXV1 <= AV37TFEmpBanDescrip_Sels.size() )
         {
            AV38TFEmpBanDescrip_Sel = (String)AV37TFEmpBanDescrip_Sels.elementAt(-1+AV60GXV1) ;
            if ( AV54i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFEmpBanDescrip_Sel, GXv_char7) ;
            empresabancoswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV54i = (long)(AV54i+1) ;
            AV60GXV1 = (int)(AV60GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV36TFEmpBanDescrip)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Banco", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            empresabancoswwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV36TFEmpBanDescrip, GXv_char7) ;
            empresabancoswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV41TFEmpBanCBU_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "CBU", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresabancoswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV54i = 1 ;
         AV61GXV2 = 1 ;
         while ( AV61GXV2 <= AV41TFEmpBanCBU_Sels.size() )
         {
            AV42TFEmpBanCBU_Sel = (String)AV41TFEmpBanCBU_Sels.elementAt(-1+AV61GXV2) ;
            if ( AV54i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV42TFEmpBanCBU_Sel, GXv_char7) ;
            empresabancoswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV54i = (long)(AV54i+1) ;
            AV61GXV2 = (int)(AV61GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV40TFEmpBanCBU)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "CBU", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            empresabancoswwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFEmpBanCBU, GXv_char7) ;
            empresabancoswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV45TFEmpBanSuc_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Sucursal", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresabancoswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV54i = 1 ;
         AV62GXV3 = 1 ;
         while ( AV62GXV3 <= AV45TFEmpBanSuc_Sels.size() )
         {
            AV46TFEmpBanSuc_Sel = (String)AV45TFEmpBanSuc_Sels.elementAt(-1+AV62GXV3) ;
            if ( AV54i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV46TFEmpBanSuc_Sel, GXv_char7) ;
            empresabancoswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV54i = (long)(AV54i+1) ;
            AV62GXV3 = (int)(AV62GXV3+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV44TFEmpBanSuc)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Sucursal", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            empresabancoswwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV44TFEmpBanSuc, GXv_char7) ;
            empresabancoswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV48TFEmpBanTipCuen_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo de cuenta", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresabancoswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV54i = 1 ;
         AV63GXV4 = 1 ;
         while ( AV63GXV4 <= AV48TFEmpBanTipCuen_Sels.size() )
         {
            AV49TFEmpBanTipCuen_Sel = (String)AV48TFEmpBanTipCuen_Sels.elementAt(-1+AV63GXV4) ;
            if ( AV54i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaintipocuentabanco.getDescription(httpContext,(String)AV49TFEmpBanTipCuen_Sel), "") );
            AV54i = (long)(AV54i+1) ;
            AV63GXV4 = (int)(AV63GXV4+1) ;
         }
      }
      if ( ! ( ( AV52TFEmpCuentaBanc_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Cta. Bancaria", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresabancoswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV54i = 1 ;
         AV64GXV5 = 1 ;
         while ( AV64GXV5 <= AV52TFEmpCuentaBanc_Sels.size() )
         {
            AV53TFEmpCuentaBanc_Sel = (String)AV52TFEmpCuentaBanc_Sels.elementAt(-1+AV64GXV5) ;
            if ( AV54i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV53TFEmpCuentaBanc_Sel, GXv_char7) ;
            empresabancoswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV54i = (long)(AV54i+1) ;
            AV64GXV5 = (int)(AV64GXV5+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV51TFEmpCuentaBanc)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Cta. Bancaria", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            empresabancoswwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV51TFEmpCuentaBanc, GXv_char7) ;
            empresabancoswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("EmpresaBancosWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("EmpresaBancosWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV65GXV6 = 1 ;
      while ( AV65GXV6 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV65GXV6));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV65GXV6 = (int)(AV65GXV6+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV67Empresabancoswwds_1_tfempbandescrip = AV36TFEmpBanDescrip ;
      AV68Empresabancoswwds_2_tfempbandescrip_sels = AV37TFEmpBanDescrip_Sels ;
      AV69Empresabancoswwds_3_tfempbancbu = AV40TFEmpBanCBU ;
      AV70Empresabancoswwds_4_tfempbancbu_sels = AV41TFEmpBanCBU_Sels ;
      AV71Empresabancoswwds_5_tfempbansuc = AV44TFEmpBanSuc ;
      AV72Empresabancoswwds_6_tfempbansuc_sels = AV45TFEmpBanSuc_Sels ;
      AV73Empresabancoswwds_7_tfempbantipcuen_sels = AV48TFEmpBanTipCuen_Sels ;
      AV74Empresabancoswwds_8_tfempcuentabanc = AV51TFEmpCuentaBanc ;
      AV75Empresabancoswwds_9_tfempcuentabanc_sels = AV52TFEmpCuentaBanc_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1967EmpBanDescrip ,
                                           AV68Empresabancoswwds_2_tfempbandescrip_sels ,
                                           A1968EmpBanCBU ,
                                           AV70Empresabancoswwds_4_tfempbancbu_sels ,
                                           A1969EmpBanSuc ,
                                           AV72Empresabancoswwds_6_tfempbansuc_sels ,
                                           A1970EmpBanTipCuen ,
                                           AV73Empresabancoswwds_7_tfempbantipcuen_sels ,
                                           A1971EmpCuentaBanc ,
                                           AV75Empresabancoswwds_9_tfempcuentabanc_sels ,
                                           Integer.valueOf(AV68Empresabancoswwds_2_tfempbandescrip_sels.size()) ,
                                           AV67Empresabancoswwds_1_tfempbandescrip ,
                                           Integer.valueOf(AV70Empresabancoswwds_4_tfempbancbu_sels.size()) ,
                                           AV69Empresabancoswwds_3_tfempbancbu ,
                                           Integer.valueOf(AV72Empresabancoswwds_6_tfempbansuc_sels.size()) ,
                                           AV71Empresabancoswwds_5_tfempbansuc ,
                                           Integer.valueOf(AV73Empresabancoswwds_7_tfempbantipcuen_sels.size()) ,
                                           Integer.valueOf(AV75Empresabancoswwds_9_tfempcuentabanc_sels.size()) ,
                                           AV74Empresabancoswwds_8_tfempcuentabanc ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Integer.valueOf(AV55CliCod) ,
                                           Short.valueOf(AV56EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV67Empresabancoswwds_1_tfempbandescrip = GXutil.concat( GXutil.rtrim( AV67Empresabancoswwds_1_tfempbandescrip), "%", "") ;
      lV69Empresabancoswwds_3_tfempbancbu = GXutil.concat( GXutil.rtrim( AV69Empresabancoswwds_3_tfempbancbu), "%", "") ;
      lV71Empresabancoswwds_5_tfempbansuc = GXutil.concat( GXutil.rtrim( AV71Empresabancoswwds_5_tfempbansuc), "%", "") ;
      lV74Empresabancoswwds_8_tfempcuentabanc = GXutil.concat( GXutil.rtrim( AV74Empresabancoswwds_8_tfempcuentabanc), "%", "") ;
      /* Using cursor P02FX2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV55CliCod), Short.valueOf(AV56EmpCod), lV67Empresabancoswwds_1_tfempbandescrip, lV69Empresabancoswwds_3_tfempbancbu, lV71Empresabancoswwds_5_tfempbansuc, lV74Empresabancoswwds_8_tfempcuentabanc});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1966EmpBanCod = P02FX2_A1966EmpBanCod[0] ;
         A1EmpCod = P02FX2_A1EmpCod[0] ;
         A3CliCod = P02FX2_A3CliCod[0] ;
         A1971EmpCuentaBanc = P02FX2_A1971EmpCuentaBanc[0] ;
         A1970EmpBanTipCuen = P02FX2_A1970EmpBanTipCuen[0] ;
         A1969EmpBanSuc = P02FX2_A1969EmpBanSuc[0] ;
         A1968EmpBanCBU = P02FX2_A1968EmpBanCBU[0] ;
         A1967EmpBanDescrip = P02FX2_A1967EmpBanDescrip[0] ;
         A1967EmpBanDescrip = P02FX2_A1967EmpBanDescrip[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV32VisibleColumnCount = 0 ;
         AV76GXV7 = 1 ;
         while ( AV76GXV7 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV76GXV7));
            if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmpBanDescrip") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1967EmpBanDescrip, GXv_char7) ;
                  empresabancoswwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmpBanCBU") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1968EmpBanCBU, GXv_char7) ;
                  empresabancoswwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmpBanSuc") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1969EmpBanSuc, GXv_char7) ;
                  empresabancoswwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmpBanTipCuen") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaintipocuentabanco.getDescription(httpContext,(String)A1970EmpBanTipCuen), "") );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmpCuentaBanc") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1971EmpCuentaBanc, GXv_char7) ;
                  empresabancoswwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV76GXV7 = (int)(AV76GXV7+1) ;
         }
         /* Execute user subroutine: 'AFTERWRITELINE' */
         S182 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void S191( )
   {
      /* 'CLOSEDOCUMENT' Routine */
      returnInSub = false ;
      AV11ExcelDocument.Save();
      /* Execute user subroutine: 'CHECKSTATUS' */
      S121 ();
      if (returnInSub) return;
      AV11ExcelDocument.Close();
   }

   public void S121( )
   {
      /* 'CHECKSTATUS' Routine */
      returnInSub = false ;
      if ( AV11ExcelDocument.getErrCode() != 0 )
      {
         AV12Filename = "" ;
         AV13ErrorMessage = AV11ExcelDocument.getErrDescription() ;
         AV11ExcelDocument.Close();
         returnInSub = true;
         if (true) return;
      }
   }

   public void S151( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      AV24ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EmpBanDescrip", "", "Banco", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EmpBanCBU", "", "CBU", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EmpBanSuc", "", "Sucursal", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EmpBanTipCuen", "", "Tipo de cuenta", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EmpCuentaBanc", "", "Cta. Bancaria", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&VerSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&ModificarSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&EliminarSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV28UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "EmpresaBancosWWColumnsSelector", GXv_char7) ;
      empresabancoswwexport.this.GXt_char6 = GXv_char7[0] ;
      AV28UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV28UserCustomValue)==0) ) )
      {
         AV25ColumnsSelectorAux.fromxml(AV28UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, GXv_SdtWWPColumnsSelector9) ;
         AV25ColumnsSelectorAux = GXv_SdtWWPColumnsSelector8[0] ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("EmpresaBancosWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "EmpresaBancosWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("EmpresaBancosWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV77GXV8 = 1 ;
      while ( AV77GXV8 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV77GXV8));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPBANDESCRIP") == 0 )
         {
            AV36TFEmpBanDescrip = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPBANDESCRIP_SEL") == 0 )
         {
            AV35TFEmpBanDescrip_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV37TFEmpBanDescrip_Sels.fromJSonString(AV35TFEmpBanDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPBANCBU") == 0 )
         {
            AV40TFEmpBanCBU = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPBANCBU_SEL") == 0 )
         {
            AV39TFEmpBanCBU_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV41TFEmpBanCBU_Sels.fromJSonString(AV39TFEmpBanCBU_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPBANSUC") == 0 )
         {
            AV44TFEmpBanSuc = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPBANSUC_SEL") == 0 )
         {
            AV43TFEmpBanSuc_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV45TFEmpBanSuc_Sels.fromJSonString(AV43TFEmpBanSuc_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPBANTIPCUEN_SEL") == 0 )
         {
            AV47TFEmpBanTipCuen_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV48TFEmpBanTipCuen_Sels.fromJSonString(AV47TFEmpBanTipCuen_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPCUENTABANC") == 0 )
         {
            AV51TFEmpCuentaBanc = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPCUENTABANC_SEL") == 0 )
         {
            AV50TFEmpCuentaBanc_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV52TFEmpCuentaBanc_Sels.fromJSonString(AV50TFEmpCuentaBanc_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV17MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV77GXV8 = (int)(AV77GXV8+1) ;
      }
   }

   public void S172( )
   {
      /* 'BEFOREWRITELINE' Routine */
      returnInSub = false ;
   }

   public void S182( )
   {
      /* 'AFTERWRITELINE' Routine */
      returnInSub = false ;
   }

   protected void cleanup( )
   {
      this.aP0[0] = empresabancoswwexport.this.AV12Filename;
      this.aP1[0] = empresabancoswwexport.this.AV13ErrorMessage;
      CloseOpenCursors();
      AV11ExcelDocument.cleanup();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12Filename = "" ;
      AV13ErrorMessage = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV59Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV37TFEmpBanDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV38TFEmpBanDescrip_Sel = "" ;
      AV36TFEmpBanDescrip = "" ;
      AV41TFEmpBanCBU_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42TFEmpBanCBU_Sel = "" ;
      AV40TFEmpBanCBU = "" ;
      AV45TFEmpBanSuc_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV46TFEmpBanSuc_Sel = "" ;
      AV44TFEmpBanSuc = "" ;
      AV48TFEmpBanTipCuen_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV49TFEmpBanTipCuen_Sel = "" ;
      AV52TFEmpCuentaBanc_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV53TFEmpCuentaBanc_Sel = "" ;
      AV51TFEmpCuentaBanc = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A1967EmpBanDescrip = "" ;
      A1968EmpBanCBU = "" ;
      A1969EmpBanSuc = "" ;
      A1970EmpBanTipCuen = "" ;
      A1971EmpCuentaBanc = "" ;
      AV67Empresabancoswwds_1_tfempbandescrip = "" ;
      AV68Empresabancoswwds_2_tfempbandescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV69Empresabancoswwds_3_tfempbancbu = "" ;
      AV70Empresabancoswwds_4_tfempbancbu_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV71Empresabancoswwds_5_tfempbansuc = "" ;
      AV72Empresabancoswwds_6_tfempbansuc_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV73Empresabancoswwds_7_tfempbantipcuen_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV74Empresabancoswwds_8_tfempcuentabanc = "" ;
      AV75Empresabancoswwds_9_tfempcuentabanc_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV67Empresabancoswwds_1_tfempbandescrip = "" ;
      lV69Empresabancoswwds_3_tfempbancbu = "" ;
      lV71Empresabancoswwds_5_tfempbansuc = "" ;
      lV74Empresabancoswwds_8_tfempcuentabanc = "" ;
      P02FX2_A1966EmpBanCod = new String[] {""} ;
      P02FX2_A1EmpCod = new short[1] ;
      P02FX2_A3CliCod = new int[1] ;
      P02FX2_A1971EmpCuentaBanc = new String[] {""} ;
      P02FX2_A1970EmpBanTipCuen = new String[] {""} ;
      P02FX2_A1969EmpBanSuc = new String[] {""} ;
      P02FX2_A1968EmpBanCBU = new String[] {""} ;
      P02FX2_A1967EmpBanDescrip = new String[] {""} ;
      A1966EmpBanCod = "" ;
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV35TFEmpBanDescrip_SelsJson = "" ;
      AV39TFEmpBanCBU_SelsJson = "" ;
      AV43TFEmpBanSuc_SelsJson = "" ;
      AV47TFEmpBanTipCuen_SelsJson = "" ;
      AV50TFEmpCuentaBanc_SelsJson = "" ;
      AV17MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empresabancoswwexport__default(),
         new Object[] {
             new Object[] {
            P02FX2_A1966EmpBanCod, P02FX2_A1EmpCod, P02FX2_A3CliCod, P02FX2_A1971EmpCuentaBanc, P02FX2_A1970EmpBanTipCuen, P02FX2_A1969EmpBanSuc, P02FX2_A1968EmpBanCBU, P02FX2_A1967EmpBanDescrip
            }
         }
      );
      AV59Pgmname = "EmpresaBancosWWExport" ;
      /* GeneXus formulas. */
      AV59Pgmname = "EmpresaBancosWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short GXv_int5[] ;
   private short AV18OrderedBy ;
   private short AV56EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV60GXV1 ;
   private int AV61GXV2 ;
   private int AV62GXV3 ;
   private int AV63GXV4 ;
   private int AV64GXV5 ;
   private int AV65GXV6 ;
   private int AV68Empresabancoswwds_2_tfempbandescrip_sels_size ;
   private int AV70Empresabancoswwds_4_tfempbancbu_sels_size ;
   private int AV72Empresabancoswwds_6_tfempbansuc_sels_size ;
   private int AV73Empresabancoswwds_7_tfempbantipcuen_sels_size ;
   private int AV75Empresabancoswwds_9_tfempcuentabanc_sels_size ;
   private int AV55CliCod ;
   private int A3CliCod ;
   private int AV76GXV7 ;
   private int AV77GXV8 ;
   private long AV54i ;
   private long AV32VisibleColumnCount ;
   private String AV59Pgmname ;
   private String AV49TFEmpBanTipCuen_Sel ;
   private String A1970EmpBanTipCuen ;
   private String scmdbuf ;
   private String A1966EmpBanCod ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV19OrderedDsc ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV35TFEmpBanDescrip_SelsJson ;
   private String AV39TFEmpBanCBU_SelsJson ;
   private String AV43TFEmpBanSuc_SelsJson ;
   private String AV47TFEmpBanTipCuen_SelsJson ;
   private String AV50TFEmpCuentaBanc_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV38TFEmpBanDescrip_Sel ;
   private String AV36TFEmpBanDescrip ;
   private String AV42TFEmpBanCBU_Sel ;
   private String AV40TFEmpBanCBU ;
   private String AV46TFEmpBanSuc_Sel ;
   private String AV44TFEmpBanSuc ;
   private String AV53TFEmpCuentaBanc_Sel ;
   private String AV51TFEmpCuentaBanc ;
   private String A1967EmpBanDescrip ;
   private String A1968EmpBanCBU ;
   private String A1969EmpBanSuc ;
   private String A1971EmpCuentaBanc ;
   private String AV67Empresabancoswwds_1_tfempbandescrip ;
   private String AV69Empresabancoswwds_3_tfempbancbu ;
   private String AV71Empresabancoswwds_5_tfempbansuc ;
   private String AV74Empresabancoswwds_8_tfempcuentabanc ;
   private String lV67Empresabancoswwds_1_tfempbandescrip ;
   private String lV69Empresabancoswwds_3_tfempbancbu ;
   private String lV71Empresabancoswwds_5_tfempbansuc ;
   private String lV74Empresabancoswwds_8_tfempcuentabanc ;
   private String AV17MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV48TFEmpBanTipCuen_Sels ;
   private GXSimpleCollection<String> AV37TFEmpBanDescrip_Sels ;
   private GXSimpleCollection<String> AV41TFEmpBanCBU_Sels ;
   private GXSimpleCollection<String> AV45TFEmpBanSuc_Sels ;
   private GXSimpleCollection<String> AV52TFEmpCuentaBanc_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] P02FX2_A1966EmpBanCod ;
   private short[] P02FX2_A1EmpCod ;
   private int[] P02FX2_A3CliCod ;
   private String[] P02FX2_A1971EmpCuentaBanc ;
   private String[] P02FX2_A1970EmpBanTipCuen ;
   private String[] P02FX2_A1969EmpBanSuc ;
   private String[] P02FX2_A1968EmpBanCBU ;
   private String[] P02FX2_A1967EmpBanDescrip ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV73Empresabancoswwds_7_tfempbantipcuen_sels ;
   private GXSimpleCollection<String> AV68Empresabancoswwds_2_tfempbandescrip_sels ;
   private GXSimpleCollection<String> AV70Empresabancoswwds_4_tfempbancbu_sels ;
   private GXSimpleCollection<String> AV72Empresabancoswwds_6_tfempbansuc_sels ;
   private GXSimpleCollection<String> AV75Empresabancoswwds_9_tfempcuentabanc_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV24ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV25ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV26ColumnsSelector_Column ;
}

final  class empresabancoswwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02FX2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1967EmpBanDescrip ,
                                          GXSimpleCollection<String> AV68Empresabancoswwds_2_tfempbandescrip_sels ,
                                          String A1968EmpBanCBU ,
                                          GXSimpleCollection<String> AV70Empresabancoswwds_4_tfempbancbu_sels ,
                                          String A1969EmpBanSuc ,
                                          GXSimpleCollection<String> AV72Empresabancoswwds_6_tfempbansuc_sels ,
                                          String A1970EmpBanTipCuen ,
                                          GXSimpleCollection<String> AV73Empresabancoswwds_7_tfempbantipcuen_sels ,
                                          String A1971EmpCuentaBanc ,
                                          GXSimpleCollection<String> AV75Empresabancoswwds_9_tfempcuentabanc_sels ,
                                          int AV68Empresabancoswwds_2_tfempbandescrip_sels_size ,
                                          String AV67Empresabancoswwds_1_tfempbandescrip ,
                                          int AV70Empresabancoswwds_4_tfempbancbu_sels_size ,
                                          String AV69Empresabancoswwds_3_tfempbancbu ,
                                          int AV72Empresabancoswwds_6_tfempbansuc_sels_size ,
                                          String AV71Empresabancoswwds_5_tfempbansuc ,
                                          int AV73Empresabancoswwds_7_tfempbantipcuen_sels_size ,
                                          int AV75Empresabancoswwds_9_tfempcuentabanc_sels_size ,
                                          String AV74Empresabancoswwds_8_tfempcuentabanc ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          int AV55CliCod ,
                                          short AV56EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[6];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT T1.EmpBanCod AS EmpBanCod, T1.EmpCod, T1.CliCod, T1.EmpCuentaBanc, T1.EmpBanTipCuen, T1.EmpBanSuc, T1.EmpBanCBU, T2.BanDescrip AS EmpBanDescrip FROM (EmpresaBancos" ;
      scmdbuf += " T1 INNER JOIN Banco T2 ON T2.CliCod = T1.CliCod AND T2.BanCod = T1.EmpBanCod)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      if ( ( AV68Empresabancoswwds_2_tfempbandescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV67Empresabancoswwds_1_tfempbandescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.BanDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int10[2] = (byte)(1) ;
      }
      if ( AV68Empresabancoswwds_2_tfempbandescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV68Empresabancoswwds_2_tfempbandescrip_sels, "T2.BanDescrip IN (", ")")+")");
      }
      if ( ( AV70Empresabancoswwds_4_tfempbancbu_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV69Empresabancoswwds_3_tfempbancbu)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.EmpBanCBU) like LOWER(?))");
      }
      else
      {
         GXv_int10[3] = (byte)(1) ;
      }
      if ( AV70Empresabancoswwds_4_tfempbancbu_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV70Empresabancoswwds_4_tfempbancbu_sels, "T1.EmpBanCBU IN (", ")")+")");
      }
      if ( ( AV72Empresabancoswwds_6_tfempbansuc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV71Empresabancoswwds_5_tfempbansuc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.EmpBanSuc) like LOWER(?))");
      }
      else
      {
         GXv_int10[4] = (byte)(1) ;
      }
      if ( AV72Empresabancoswwds_6_tfempbansuc_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV72Empresabancoswwds_6_tfempbansuc_sels, "T1.EmpBanSuc IN (", ")")+")");
      }
      if ( AV73Empresabancoswwds_7_tfempbantipcuen_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV73Empresabancoswwds_7_tfempbantipcuen_sels, "T1.EmpBanTipCuen IN (", ")")+")");
      }
      if ( ( AV75Empresabancoswwds_9_tfempcuentabanc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV74Empresabancoswwds_8_tfempcuentabanc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.EmpCuentaBanc) like LOWER(?))");
      }
      else
      {
         GXv_int10[5] = (byte)(1) ;
      }
      if ( AV75Empresabancoswwds_9_tfempcuentabanc_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV75Empresabancoswwds_9_tfempcuentabanc_sels, "T1.EmpCuentaBanc IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.BanDescrip" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.BanDescrip DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.EmpBanCBU" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.EmpBanCBU DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.EmpBanSuc" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.EmpBanSuc DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.EmpBanTipCuen" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.EmpBanTipCuen DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.EmpCuentaBanc" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.EmpCuentaBanc DESC" ;
      }
      GXv_Object11[0] = scmdbuf ;
      GXv_Object11[1] = GXv_int10 ;
      return GXv_Object11 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P02FX2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).shortValue() , ((Boolean) dynConstraints[20]).booleanValue() , ((Number) dynConstraints[21]).intValue() , ((Number) dynConstraints[22]).shortValue() , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02FX2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 6);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[7]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 22);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 30);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 20);
               }
               return;
      }
   }

}

