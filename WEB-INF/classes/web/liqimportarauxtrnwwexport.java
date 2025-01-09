package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class liqimportarauxtrnwwexport extends GXProcedure
{
   public liqimportarauxtrnwwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liqimportarauxtrnwwexport.class ), "" );
   }

   public liqimportarauxtrnwwexport( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      liqimportarauxtrnwwexport.this.aP1 = new String[] {""};
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
      liqimportarauxtrnwwexport.this.aP0 = aP0;
      liqimportarauxtrnwwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLiqImportarAuxTrn", GXv_boolean2) ;
      liqimportarauxtrnwwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV47Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "LiqImportarAuxTrnWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( (0==AV34TFCliCod) && (0==AV35TFCliCod_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Cod", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liqimportarauxtrnwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV34TFCliCod );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liqimportarauxtrnwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV35TFCliCod_To );
      }
      if ( ! ( (0==AV36TFEmpCod) && (0==AV37TFEmpCod_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Empresa", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liqimportarauxtrnwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV36TFEmpCod );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liqimportarauxtrnwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV37TFEmpCod_To );
      }
      if ( ! ( ( AV40TFEmpNom_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Nombre", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liqimportarauxtrnwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV42i = 1 ;
         AV48GXV1 = 1 ;
         while ( AV48GXV1 <= AV40TFEmpNom_Sels.size() )
         {
            AV41TFEmpNom_Sel = (String)AV40TFEmpNom_Sels.elementAt(-1+AV48GXV1) ;
            if ( AV42i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV41TFEmpNom_Sel, GXv_char7) ;
            liqimportarauxtrnwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV42i = (long)(AV42i+1) ;
            AV48GXV1 = (int)(AV48GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV39TFEmpNom)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Nombre", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            liqimportarauxtrnwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV39TFEmpNom, GXv_char7) ;
            liqimportarauxtrnwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV31VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV19Session.getValue("LiqImportarAuxTrnWWColumnsSelector"), "") != 0 )
      {
         AV26ColumnsSelectorXML = AV19Session.getValue("LiqImportarAuxTrnWWColumnsSelector") ;
         AV23ColumnsSelector.fromxml(AV26ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      AV23ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV49GXV2 = 1 ;
      while ( AV49GXV2 <= AV23ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV25ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV23ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV49GXV2));
         if ( AV25ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV31VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV25ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV25ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV25ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV31VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV31VisibleColumnCount), 1, 1).setColor( 11 );
            AV31VisibleColumnCount = (long)(AV31VisibleColumnCount+1) ;
         }
         AV49GXV2 = (int)(AV49GXV2+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV51Liqimportarauxtrnwwds_1_tfclicod = AV34TFCliCod ;
      AV52Liqimportarauxtrnwwds_2_tfclicod_to = AV35TFCliCod_To ;
      AV53Liqimportarauxtrnwwds_3_tfempcod = AV36TFEmpCod ;
      AV54Liqimportarauxtrnwwds_4_tfempcod_to = AV37TFEmpCod_To ;
      AV55Liqimportarauxtrnwwds_5_tfempnom = AV39TFEmpNom ;
      AV56Liqimportarauxtrnwwds_6_tfempnom_sels = AV40TFEmpNom_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A2EmpNom ,
                                           AV56Liqimportarauxtrnwwds_6_tfempnom_sels ,
                                           Integer.valueOf(AV51Liqimportarauxtrnwwds_1_tfclicod) ,
                                           Integer.valueOf(AV52Liqimportarauxtrnwwds_2_tfclicod_to) ,
                                           Short.valueOf(AV53Liqimportarauxtrnwwds_3_tfempcod) ,
                                           Short.valueOf(AV54Liqimportarauxtrnwwds_4_tfempcod_to) ,
                                           Integer.valueOf(AV56Liqimportarauxtrnwwds_6_tfempnom_sels.size()) ,
                                           AV55Liqimportarauxtrnwwds_5_tfempnom ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV17OrderedBy) ,
                                           Boolean.valueOf(AV18OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.BOOLEAN
                                           }
      });
      lV55Liqimportarauxtrnwwds_5_tfempnom = GXutil.concat( GXutil.rtrim( AV55Liqimportarauxtrnwwds_5_tfempnom), "%", "") ;
      /* Using cursor P00NO2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV51Liqimportarauxtrnwwds_1_tfclicod), Integer.valueOf(AV52Liqimportarauxtrnwwds_2_tfclicod_to), Short.valueOf(AV53Liqimportarauxtrnwwds_3_tfempcod), Short.valueOf(AV54Liqimportarauxtrnwwds_4_tfempcod_to), lV55Liqimportarauxtrnwwds_5_tfempnom});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2EmpNom = P00NO2_A2EmpNom[0] ;
         A1EmpCod = P00NO2_A1EmpCod[0] ;
         A3CliCod = P00NO2_A3CliCod[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV31VisibleColumnCount = 0 ;
         AV57GXV3 = 1 ;
         while ( AV57GXV3 <= AV23ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV25ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV23ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV57GXV3));
            if ( AV25ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV25ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliCod") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV31VisibleColumnCount), 1, 1).setNumber( A3CliCod );
               }
               else if ( GXutil.strcmp(AV25ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmpCod") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV31VisibleColumnCount), 1, 1).setNumber( A1EmpCod );
               }
               else if ( GXutil.strcmp(AV25ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmpNom") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A2EmpNom, GXv_char7) ;
                  liqimportarauxtrnwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV31VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               AV31VisibleColumnCount = (long)(AV31VisibleColumnCount+1) ;
            }
            AV57GXV3 = (int)(AV57GXV3+1) ;
         }
         /* Execute user subroutine: 'AFTERWRITELINE' */
         S182 ();
         if ( returnInSub )
         {
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
      AV23ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8[0] = AV23ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "CliCod", "", "Cod", true, "") ;
      AV23ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV23ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EmpCod", "", "Empresa", true, "") ;
      AV23ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV23ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EmpNom", "", "Nombre", true, "") ;
      AV23ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV27UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "LiqImportarAuxTrnWWColumnsSelector", GXv_char7) ;
      liqimportarauxtrnwwexport.this.GXt_char6 = GXv_char7[0] ;
      AV27UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV27UserCustomValue)==0) ) )
      {
         AV24ColumnsSelectorAux.fromxml(AV27UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector9[0] = AV23ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, GXv_SdtWWPColumnsSelector9) ;
         AV24ColumnsSelectorAux = GXv_SdtWWPColumnsSelector8[0] ;
         AV23ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV19Session.getValue("LiqImportarAuxTrnWWGridState"), "") == 0 )
      {
         AV21GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "LiqImportarAuxTrnWWGridState"), null, null);
      }
      else
      {
         AV21GridState.fromxml(AV19Session.getValue("LiqImportarAuxTrnWWGridState"), null, null);
      }
      AV17OrderedBy = AV21GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV18OrderedDsc = AV21GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV58GXV4 = 1 ;
      while ( AV58GXV4 <= AV21GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV22GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV21GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV58GXV4));
         if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICOD") == 0 )
         {
            AV34TFCliCod = (int)(GXutil.lval( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV35TFCliCod_To = (int)(GXutil.lval( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPCOD") == 0 )
         {
            AV36TFEmpCod = (short)(GXutil.lval( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV37TFEmpCod_To = (short)(GXutil.lval( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPNOM") == 0 )
         {
            AV39TFEmpNom = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPNOM_SEL") == 0 )
         {
            AV38TFEmpNom_SelsJson = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV40TFEmpNom_Sels.fromJSonString(AV38TFEmpNom_SelsJson, null);
         }
         AV58GXV4 = (int)(AV58GXV4+1) ;
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
      this.aP0[0] = liqimportarauxtrnwwexport.this.AV12Filename;
      this.aP1[0] = liqimportarauxtrnwwexport.this.AV13ErrorMessage;
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
      AV47Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV40TFEmpNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV41TFEmpNom_Sel = "" ;
      AV39TFEmpNom = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV19Session = httpContext.getWebSession();
      AV26ColumnsSelectorXML = "" ;
      AV23ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV25ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A2EmpNom = "" ;
      AV55Liqimportarauxtrnwwds_5_tfempnom = "" ;
      AV56Liqimportarauxtrnwwds_6_tfempnom_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV55Liqimportarauxtrnwwds_5_tfempnom = "" ;
      P00NO2_A2EmpNom = new String[] {""} ;
      P00NO2_A1EmpCod = new short[1] ;
      P00NO2_A3CliCod = new int[1] ;
      AV27UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV24ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV21GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV22GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV38TFEmpNom_SelsJson = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liqimportarauxtrnwwexport__default(),
         new Object[] {
             new Object[] {
            P00NO2_A2EmpNom, P00NO2_A1EmpCod, P00NO2_A3CliCod
            }
         }
      );
      AV47Pgmname = "LiqImportarAuxTrnWWExport" ;
      /* GeneXus formulas. */
      AV47Pgmname = "LiqImportarAuxTrnWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short AV36TFEmpCod ;
   private short AV37TFEmpCod_To ;
   private short GXv_int5[] ;
   private short A1EmpCod ;
   private short AV53Liqimportarauxtrnwwds_3_tfempcod ;
   private short AV54Liqimportarauxtrnwwds_4_tfempcod_to ;
   private short AV17OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV34TFCliCod ;
   private int AV35TFCliCod_To ;
   private int AV48GXV1 ;
   private int AV49GXV2 ;
   private int A3CliCod ;
   private int AV51Liqimportarauxtrnwwds_1_tfclicod ;
   private int AV52Liqimportarauxtrnwwds_2_tfclicod_to ;
   private int AV56Liqimportarauxtrnwwds_6_tfempnom_sels_size ;
   private int AV57GXV3 ;
   private int AV58GXV4 ;
   private long AV42i ;
   private long AV31VisibleColumnCount ;
   private String AV47Pgmname ;
   private String scmdbuf ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV18OrderedDsc ;
   private String AV26ColumnsSelectorXML ;
   private String AV27UserCustomValue ;
   private String AV38TFEmpNom_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV41TFEmpNom_Sel ;
   private String AV39TFEmpNom ;
   private String A2EmpNom ;
   private String AV55Liqimportarauxtrnwwds_5_tfempnom ;
   private String lV55Liqimportarauxtrnwwds_5_tfempnom ;
   private com.genexus.webpanels.WebSession AV19Session ;
   private GXSimpleCollection<String> AV40TFEmpNom_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] P00NO2_A2EmpNom ;
   private short[] P00NO2_A1EmpCod ;
   private int[] P00NO2_A3CliCod ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV56Liqimportarauxtrnwwds_6_tfempnom_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV21GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV22GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV23ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV24ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV25ColumnsSelector_Column ;
}

final  class liqimportarauxtrnwwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00NO2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A2EmpNom ,
                                          GXSimpleCollection<String> AV56Liqimportarauxtrnwwds_6_tfempnom_sels ,
                                          int AV51Liqimportarauxtrnwwds_1_tfclicod ,
                                          int AV52Liqimportarauxtrnwwds_2_tfclicod_to ,
                                          short AV53Liqimportarauxtrnwwds_3_tfempcod ,
                                          short AV54Liqimportarauxtrnwwds_4_tfempcod_to ,
                                          int AV56Liqimportarauxtrnwwds_6_tfempnom_sels_size ,
                                          String AV55Liqimportarauxtrnwwds_5_tfempnom ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[5];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT EmpNom, EmpCod, CliCod FROM Empresa" ;
      if ( ! (0==AV51Liqimportarauxtrnwwds_1_tfclicod) )
      {
         addWhere(sWhereString, "(CliCod >= ?)");
      }
      else
      {
         GXv_int10[0] = (byte)(1) ;
      }
      if ( ! (0==AV52Liqimportarauxtrnwwds_2_tfclicod_to) )
      {
         addWhere(sWhereString, "(CliCod <= ?)");
      }
      else
      {
         GXv_int10[1] = (byte)(1) ;
      }
      if ( ! (0==AV53Liqimportarauxtrnwwds_3_tfempcod) )
      {
         addWhere(sWhereString, "(EmpCod >= ?)");
      }
      else
      {
         GXv_int10[2] = (byte)(1) ;
      }
      if ( ! (0==AV54Liqimportarauxtrnwwds_4_tfempcod_to) )
      {
         addWhere(sWhereString, "(EmpCod <= ?)");
      }
      else
      {
         GXv_int10[3] = (byte)(1) ;
      }
      if ( ( AV56Liqimportarauxtrnwwds_6_tfempnom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55Liqimportarauxtrnwwds_5_tfempnom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(EmpNom) like LOWER(?))");
      }
      else
      {
         GXv_int10[4] = (byte)(1) ;
      }
      if ( AV56Liqimportarauxtrnwwds_6_tfempnom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56Liqimportarauxtrnwwds_6_tfempnom_sels, "EmpNom IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV17OrderedBy == 1 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY CliCod" ;
      }
      else if ( ( AV17OrderedBy == 1 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CliCod DESC" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY EmpCod" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EmpCod DESC" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY EmpNom" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EmpNom DESC" ;
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
                  return conditional_P00NO2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).shortValue() , ((Boolean) dynConstraints[11]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00NO2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
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
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[7]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[8]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 40);
               }
               return;
      }
   }

}

