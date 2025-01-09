package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class liquidacionajustewwexport extends GXProcedure
{
   public liquidacionajustewwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liquidacionajustewwexport.class ), "" );
   }

   public liquidacionajustewwexport( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      liquidacionajustewwexport.this.aP1 = new String[] {""};
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
      liquidacionajustewwexport.this.aP0 = aP0;
      liquidacionajustewwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLiquidacionAjuste", GXv_boolean2) ;
      liquidacionajustewwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV48Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "LiquidacionAjusteWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( (0==AV39TFLiqAjuNro) && (0==AV40TFLiqAjuNro_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Nro. Ajuste", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionajustewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV39TFLiqAjuNro );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionajustewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV40TFLiqAjuNro_To );
      }
      if ( ! ( ( AV43TFLiqAjuObs_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Observación", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionajustewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV45i = 1 ;
         AV49GXV1 = 1 ;
         while ( AV49GXV1 <= AV43TFLiqAjuObs_Sels.size() )
         {
            AV44TFLiqAjuObs_Sel = (String)AV43TFLiqAjuObs_Sels.elementAt(-1+AV49GXV1) ;
            if ( AV45i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV44TFLiqAjuObs_Sel, 1, 1000), GXv_char7) ;
            liquidacionajustewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV45i = (long)(AV45i+1) ;
            AV49GXV1 = (int)(AV49GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV42TFLiqAjuObs)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Observación", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            liquidacionajustewwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV42TFLiqAjuObs, 1, 1000), GXv_char7) ;
            liquidacionajustewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV36VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV24Session.getValue("LiquidacionAjusteWWColumnsSelector"), "") != 0 )
      {
         AV31ColumnsSelectorXML = AV24Session.getValue("LiquidacionAjusteWWColumnsSelector") ;
         AV28ColumnsSelector.fromxml(AV31ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV50GXV2 = 1 ;
      while ( AV50GXV2 <= AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV30ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV50GXV2));
         if ( AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setColor( 11 );
            AV36VisibleColumnCount = (long)(AV36VisibleColumnCount+1) ;
         }
         AV50GXV2 = (int)(AV50GXV2+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV52Liquidacionajustewwds_1_clicod = AV18CliCod ;
      AV53Liquidacionajustewwds_2_empcod = AV19EmpCod ;
      AV54Liquidacionajustewwds_3_liqnro = AV20LiqNro ;
      AV55Liquidacionajustewwds_4_legnumero = AV21LegNumero ;
      AV56Liquidacionajustewwds_5_tfliqajunro = AV39TFLiqAjuNro ;
      AV57Liquidacionajustewwds_6_tfliqajunro_to = AV40TFLiqAjuNro_To ;
      AV58Liquidacionajustewwds_7_tfliqajuobs = AV42TFLiqAjuObs ;
      AV59Liquidacionajustewwds_8_tfliqajuobs_sels = AV43TFLiqAjuObs_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1542LiqAjuObs ,
                                           AV59Liquidacionajustewwds_8_tfliqajuobs_sels ,
                                           Short.valueOf(AV56Liquidacionajustewwds_5_tfliqajunro) ,
                                           Short.valueOf(AV57Liquidacionajustewwds_6_tfliqajunro_to) ,
                                           Integer.valueOf(AV59Liquidacionajustewwds_8_tfliqajuobs_sels.size()) ,
                                           AV58Liquidacionajustewwds_7_tfliqajuobs ,
                                           Short.valueOf(A1541LiqAjuNro) ,
                                           Short.valueOf(AV22OrderedBy) ,
                                           Boolean.valueOf(AV23OrderedDsc) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV18CliCod) ,
                                           Integer.valueOf(AV52Liquidacionajustewwds_1_clicod) ,
                                           Short.valueOf(AV53Liquidacionajustewwds_2_empcod) ,
                                           Integer.valueOf(AV54Liquidacionajustewwds_3_liqnro) ,
                                           Integer.valueOf(AV55Liquidacionajustewwds_4_legnumero) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A31LiqNro) ,
                                           Integer.valueOf(A6LegNumero) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV58Liquidacionajustewwds_7_tfliqajuobs = GXutil.concat( GXutil.rtrim( AV58Liquidacionajustewwds_7_tfliqajuobs), "%", "") ;
      /* Using cursor P02FE2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV52Liquidacionajustewwds_1_clicod), Short.valueOf(AV53Liquidacionajustewwds_2_empcod), Integer.valueOf(AV54Liquidacionajustewwds_3_liqnro), Integer.valueOf(AV55Liquidacionajustewwds_4_legnumero), Integer.valueOf(AV18CliCod), Short.valueOf(AV56Liquidacionajustewwds_5_tfliqajunro), Short.valueOf(AV57Liquidacionajustewwds_6_tfliqajunro_to), lV58Liquidacionajustewwds_7_tfliqajuobs});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1542LiqAjuObs = P02FE2_A1542LiqAjuObs[0] ;
         A1541LiqAjuNro = P02FE2_A1541LiqAjuNro[0] ;
         A6LegNumero = P02FE2_A6LegNumero[0] ;
         A31LiqNro = P02FE2_A31LiqNro[0] ;
         A1EmpCod = P02FE2_A1EmpCod[0] ;
         A3CliCod = P02FE2_A3CliCod[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV36VisibleColumnCount = 0 ;
         AV60GXV3 = 1 ;
         while ( AV60GXV3 <= AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV30ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV60GXV3));
            if ( AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqAjuNro") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setNumber( A1541LiqAjuNro );
               }
               else if ( GXutil.strcmp(AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqAjuObs") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( A1542LiqAjuObs, 1, 1000), GXv_char7) ;
                  liquidacionajustewwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               AV36VisibleColumnCount = (long)(AV36VisibleColumnCount+1) ;
            }
            AV60GXV3 = (int)(AV60GXV3+1) ;
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
      AV28ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LiqAjuNro", "", "Nro. Ajuste", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LiqAjuObs", "", "Observación", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&VerSVG", "", "", false, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&ModificarSVG", "", "", false, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&EliminarSVG", "", "", false, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV32UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "LiquidacionAjusteWWColumnsSelector", GXv_char7) ;
      liquidacionajustewwexport.this.GXt_char6 = GXv_char7[0] ;
      AV32UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV32UserCustomValue)==0) ) )
      {
         AV29ColumnsSelectorAux.fromxml(AV32UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector8[0] = AV29ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector9[0] = AV28ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, GXv_SdtWWPColumnsSelector9) ;
         AV29ColumnsSelectorAux = GXv_SdtWWPColumnsSelector8[0] ;
         AV28ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV24Session.getValue("LiquidacionAjusteWWGridState"), "") == 0 )
      {
         AV26GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "LiquidacionAjusteWWGridState"), null, null);
      }
      else
      {
         AV26GridState.fromxml(AV24Session.getValue("LiquidacionAjusteWWGridState"), null, null);
      }
      AV22OrderedBy = AV26GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV23OrderedDsc = AV26GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV61GXV4 = 1 ;
      while ( AV61GXV4 <= AV26GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV27GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV26GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV61GXV4));
         if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQAJUNRO") == 0 )
         {
            AV39TFLiqAjuNro = (short)(GXutil.lval( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV40TFLiqAjuNro_To = (short)(GXutil.lval( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQAJUOBS") == 0 )
         {
            AV42TFLiqAjuObs = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQAJUOBS_SEL") == 0 )
         {
            AV41TFLiqAjuObs_SelsJson = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV43TFLiqAjuObs_Sels.fromJSonString(AV41TFLiqAjuObs_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV17MenuOpcCod = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&CLICOD") == 0 )
         {
            AV18CliCod = (int)(GXutil.lval( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&EMPCOD") == 0 )
         {
            AV19EmpCod = (short)(GXutil.lval( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&LIQNRO") == 0 )
         {
            AV20LiqNro = (int)(GXutil.lval( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&LEGNUMERO") == 0 )
         {
            AV21LegNumero = (int)(GXutil.lval( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         AV61GXV4 = (int)(AV61GXV4+1) ;
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
      this.aP0[0] = liquidacionajustewwexport.this.AV12Filename;
      this.aP1[0] = liquidacionajustewwexport.this.AV13ErrorMessage;
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
      AV48Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV43TFLiqAjuObs_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV44TFLiqAjuObs_Sel = "" ;
      AV42TFLiqAjuObs = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV24Session = httpContext.getWebSession();
      AV31ColumnsSelectorXML = "" ;
      AV28ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV30ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A1542LiqAjuObs = "" ;
      AV58Liquidacionajustewwds_7_tfliqajuobs = "" ;
      AV59Liquidacionajustewwds_8_tfliqajuobs_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV58Liquidacionajustewwds_7_tfliqajuobs = "" ;
      P02FE2_A1542LiqAjuObs = new String[] {""} ;
      P02FE2_A1541LiqAjuNro = new short[1] ;
      P02FE2_A6LegNumero = new int[1] ;
      P02FE2_A31LiqNro = new int[1] ;
      P02FE2_A1EmpCod = new short[1] ;
      P02FE2_A3CliCod = new int[1] ;
      AV32UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV29ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV26GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV27GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV41TFLiqAjuObs_SelsJson = "" ;
      AV17MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liquidacionajustewwexport__default(),
         new Object[] {
             new Object[] {
            P02FE2_A1542LiqAjuObs, P02FE2_A1541LiqAjuNro, P02FE2_A6LegNumero, P02FE2_A31LiqNro, P02FE2_A1EmpCod, P02FE2_A3CliCod
            }
         }
      );
      AV48Pgmname = "LiquidacionAjusteWWExport" ;
      /* GeneXus formulas. */
      AV48Pgmname = "LiquidacionAjusteWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short AV39TFLiqAjuNro ;
   private short AV40TFLiqAjuNro_To ;
   private short GXv_int5[] ;
   private short A1541LiqAjuNro ;
   private short AV53Liquidacionajustewwds_2_empcod ;
   private short AV19EmpCod ;
   private short AV56Liquidacionajustewwds_5_tfliqajunro ;
   private short AV57Liquidacionajustewwds_6_tfliqajunro_to ;
   private short AV22OrderedBy ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV49GXV1 ;
   private int AV50GXV2 ;
   private int AV52Liquidacionajustewwds_1_clicod ;
   private int AV18CliCod ;
   private int AV54Liquidacionajustewwds_3_liqnro ;
   private int AV20LiqNro ;
   private int AV55Liquidacionajustewwds_4_legnumero ;
   private int AV21LegNumero ;
   private int AV59Liquidacionajustewwds_8_tfliqajuobs_sels_size ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private int AV60GXV3 ;
   private int AV61GXV4 ;
   private long AV45i ;
   private long AV36VisibleColumnCount ;
   private String AV48Pgmname ;
   private String scmdbuf ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV23OrderedDsc ;
   private String AV31ColumnsSelectorXML ;
   private String A1542LiqAjuObs ;
   private String AV32UserCustomValue ;
   private String AV41TFLiqAjuObs_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV44TFLiqAjuObs_Sel ;
   private String AV42TFLiqAjuObs ;
   private String AV58Liquidacionajustewwds_7_tfliqajuobs ;
   private String lV58Liquidacionajustewwds_7_tfliqajuobs ;
   private String AV17MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV24Session ;
   private GXSimpleCollection<String> AV43TFLiqAjuObs_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] P02FE2_A1542LiqAjuObs ;
   private short[] P02FE2_A1541LiqAjuNro ;
   private int[] P02FE2_A6LegNumero ;
   private int[] P02FE2_A31LiqNro ;
   private short[] P02FE2_A1EmpCod ;
   private int[] P02FE2_A3CliCod ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV59Liquidacionajustewwds_8_tfliqajuobs_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV26GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV27GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV28ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV29ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV30ColumnsSelector_Column ;
}

final  class liquidacionajustewwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02FE2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1542LiqAjuObs ,
                                          GXSimpleCollection<String> AV59Liquidacionajustewwds_8_tfliqajuobs_sels ,
                                          short AV56Liquidacionajustewwds_5_tfliqajunro ,
                                          short AV57Liquidacionajustewwds_6_tfliqajunro_to ,
                                          int AV59Liquidacionajustewwds_8_tfliqajuobs_sels_size ,
                                          String AV58Liquidacionajustewwds_7_tfliqajuobs ,
                                          short A1541LiqAjuNro ,
                                          short AV22OrderedBy ,
                                          boolean AV23OrderedDsc ,
                                          int A3CliCod ,
                                          int AV18CliCod ,
                                          int AV52Liquidacionajustewwds_1_clicod ,
                                          short AV53Liquidacionajustewwds_2_empcod ,
                                          int AV54Liquidacionajustewwds_3_liqnro ,
                                          int AV55Liquidacionajustewwds_4_legnumero ,
                                          short A1EmpCod ,
                                          int A31LiqNro ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[8];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT LiqAjuObs, LiqAjuNro, LegNumero, LiqNro, EmpCod, CliCod FROM LiquidacionAjuste" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?)");
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV56Liquidacionajustewwds_5_tfliqajunro) )
      {
         addWhere(sWhereString, "(LiqAjuNro >= ?)");
      }
      else
      {
         GXv_int10[5] = (byte)(1) ;
      }
      if ( ! (0==AV57Liquidacionajustewwds_6_tfliqajunro_to) )
      {
         addWhere(sWhereString, "(LiqAjuNro <= ?)");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      if ( ( AV59Liquidacionajustewwds_8_tfliqajuobs_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV58Liquidacionajustewwds_7_tfliqajuobs)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqAjuObs) like LOWER(?))");
      }
      else
      {
         GXv_int10[7] = (byte)(1) ;
      }
      if ( AV59Liquidacionajustewwds_8_tfliqajuobs_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV59Liquidacionajustewwds_8_tfliqajuobs_sels, "LiqAjuObs IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV22OrderedBy == 1 ) && ! AV23OrderedDsc )
      {
         scmdbuf += " ORDER BY CliCod, EmpCod, LiqNro, LegNumero, LiqAjuNro" ;
      }
      else if ( ( AV22OrderedBy == 1 ) && ( AV23OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CliCod DESC, EmpCod DESC, LiqNro DESC, LegNumero DESC, LiqAjuNro DESC" ;
      }
      else if ( ( AV22OrderedBy == 2 ) && ! AV23OrderedDsc )
      {
         scmdbuf += " ORDER BY CliCod, EmpCod, LiqNro, LegNumero, LiqAjuObs" ;
      }
      else if ( ( AV22OrderedBy == 2 ) && ( AV23OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CliCod DESC, EmpCod DESC, LiqNro DESC, LegNumero DESC, LiqAjuObs DESC" ;
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
                  return conditional_P02FE2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Boolean) dynConstraints[8]).booleanValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02FE2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getLongVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
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
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[11]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 200);
               }
               return;
      }
   }

}

