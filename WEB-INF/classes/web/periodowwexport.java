package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class periodowwexport extends GXProcedure
{
   public periodowwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( periodowwexport.class ), "" );
   }

   public periodowwexport( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      periodowwexport.this.aP1 = new String[] {""};
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
      periodowwexport.this.aP0 = aP0;
      periodowwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPeriodo", GXv_boolean2) ;
      periodowwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
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
      AV12Filename = "PeriodoWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( (0==AV35TFPeriodoAnio) && (0==AV36TFPeriodoAnio_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Año", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         periodowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV35TFPeriodoAnio );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         periodowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV36TFPeriodoAnio_To );
      }
      if ( ! ( ( AV39TFPeriodoDescrip_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Periodo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         periodowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV43i = 1 ;
         AV49GXV1 = 1 ;
         while ( AV49GXV1 <= AV39TFPeriodoDescrip_Sels.size() )
         {
            AV40TFPeriodoDescrip_Sel = (String)AV39TFPeriodoDescrip_Sels.elementAt(-1+AV49GXV1) ;
            if ( AV43i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFPeriodoDescrip_Sel, GXv_char7) ;
            periodowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV43i = (long)(AV43i+1) ;
            AV49GXV1 = (int)(AV49GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV38TFPeriodoDescrip)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Periodo", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            periodowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFPeriodoDescrip, GXv_char7) ;
            periodowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV41TFPeriodoCntLiq) && (0==AV42TFPeriodoCntLiq_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Cantidad de liquidaciones", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         periodowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV41TFPeriodoCntLiq );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         periodowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV42TFPeriodoCntLiq_To );
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("PeriodoWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("PeriodoWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV50GXV2 = 1 ;
      while ( AV50GXV2 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV50GXV2));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV50GXV2 = (int)(AV50GXV2+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV52Periodowwds_1_tfperiodoanio = AV35TFPeriodoAnio ;
      AV53Periodowwds_2_tfperiodoanio_to = AV36TFPeriodoAnio_To ;
      AV54Periodowwds_3_tfperiododescrip = AV38TFPeriodoDescrip ;
      AV55Periodowwds_4_tfperiododescrip_sels = AV39TFPeriodoDescrip_Sels ;
      AV56Periodowwds_5_tfperiodocntliq = AV41TFPeriodoCntLiq ;
      AV57Periodowwds_6_tfperiodocntliq_to = AV42TFPeriodoCntLiq_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1732PeriodoDescrip ,
                                           AV55Periodowwds_4_tfperiododescrip_sels ,
                                           Short.valueOf(AV52Periodowwds_1_tfperiodoanio) ,
                                           Short.valueOf(AV53Periodowwds_2_tfperiodoanio_to) ,
                                           Integer.valueOf(AV55Periodowwds_4_tfperiododescrip_sels.size()) ,
                                           AV54Periodowwds_3_tfperiododescrip ,
                                           Short.valueOf(A1730PeriodoAnio) ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Short.valueOf(AV56Periodowwds_5_tfperiodocntliq) ,
                                           Short.valueOf(A1735PeriodoCntLiq) ,
                                           Short.valueOf(AV57Periodowwds_6_tfperiodocntliq_to) ,
                                           Integer.valueOf(AV44CliCod) ,
                                           Short.valueOf(AV45EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV54Periodowwds_3_tfperiododescrip = GXutil.concat( GXutil.rtrim( AV54Periodowwds_3_tfperiododescrip), "%", "") ;
      /* Using cursor P02EW2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV44CliCod), Short.valueOf(AV45EmpCod), Short.valueOf(AV52Periodowwds_1_tfperiodoanio), Short.valueOf(AV53Periodowwds_2_tfperiodoanio_to), lV54Periodowwds_3_tfperiododescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1732PeriodoDescrip = P02EW2_A1732PeriodoDescrip[0] ;
         A1730PeriodoAnio = P02EW2_A1730PeriodoAnio[0] ;
         A1729PeriodoLiq = P02EW2_A1729PeriodoLiq[0] ;
         A1EmpCod = P02EW2_A1EmpCod[0] ;
         A3CliCod = P02EW2_A3CliCod[0] ;
         GXt_int8 = A1735PeriodoCntLiq ;
         GXv_int5[0] = GXt_int8 ;
         new web.periodocantliq(remoteHandle, context).execute( A3CliCod, A1EmpCod, A1729PeriodoLiq, GXv_int5) ;
         periodowwexport.this.GXt_int8 = GXv_int5[0] ;
         A1735PeriodoCntLiq = GXt_int8 ;
         if ( (0==AV56Periodowwds_5_tfperiodocntliq) || ( ( A1735PeriodoCntLiq >= AV56Periodowwds_5_tfperiodocntliq ) ) )
         {
            if ( (0==AV57Periodowwds_6_tfperiodocntliq_to) || ( ( A1735PeriodoCntLiq <= AV57Periodowwds_6_tfperiodocntliq_to ) ) )
            {
               AV14CellRow = (int)(AV14CellRow+1) ;
               /* Execute user subroutine: 'BEFOREWRITELINE' */
               S172 ();
               if ( returnInSub )
               {
                  pr_default.close(0);
                  returnInSub = true;
                  if (true) return;
               }
               AV32VisibleColumnCount = 0 ;
               AV58GXV3 = 1 ;
               while ( AV58GXV3 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
               {
                  AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV58GXV3));
                  if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
                  {
                     if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PeriodoAnio") == 0 )
                     {
                        AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1730PeriodoAnio );
                     }
                     else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PeriodoDescrip") == 0 )
                     {
                        GXt_char6 = "" ;
                        GXv_char7[0] = GXt_char6 ;
                        new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1732PeriodoDescrip, GXv_char7) ;
                        periodowwexport.this.GXt_char6 = GXv_char7[0] ;
                        AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
                     }
                     else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PeriodoCntLiq") == 0 )
                     {
                        AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1735PeriodoCntLiq );
                     }
                     AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
                  }
                  AV58GXV3 = (int)(AV58GXV3+1) ;
               }
               /* Execute user subroutine: 'AFTERWRITELINE' */
               S182 ();
               if ( returnInSub )
               {
                  pr_default.close(0);
                  returnInSub = true;
                  if (true) return;
               }
            }
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
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PeriodoAnio", "", "Año", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PeriodoDescrip", "", "Periodo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PeriodoCntLiq", "", "Cantidad de liquidaciones", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "&VerSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "&Estado", "", "Estado", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXt_char6 = AV28UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "PeriodoWWColumnsSelector", GXv_char7) ;
      periodowwexport.this.GXt_char6 = GXv_char7[0] ;
      AV28UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV28UserCustomValue)==0) ) )
      {
         AV25ColumnsSelectorAux.fromxml(AV28UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, GXv_SdtWWPColumnsSelector10) ;
         AV25ColumnsSelectorAux = GXv_SdtWWPColumnsSelector9[0] ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("PeriodoWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "PeriodoWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("PeriodoWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV59GXV4 = 1 ;
      while ( AV59GXV4 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV59GXV4));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPERIODOANIO") == 0 )
         {
            AV35TFPeriodoAnio = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV36TFPeriodoAnio_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPERIODODESCRIP") == 0 )
         {
            AV38TFPeriodoDescrip = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPERIODODESCRIP_SEL") == 0 )
         {
            AV37TFPeriodoDescrip_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV39TFPeriodoDescrip_Sels.fromJSonString(AV37TFPeriodoDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPERIODOCNTLIQ") == 0 )
         {
            AV41TFPeriodoCntLiq = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV42TFPeriodoCntLiq_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV17MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV59GXV4 = (int)(AV59GXV4+1) ;
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
      this.aP0[0] = periodowwexport.this.AV12Filename;
      this.aP1[0] = periodowwexport.this.AV13ErrorMessage;
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
      AV39TFPeriodoDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV40TFPeriodoDescrip_Sel = "" ;
      AV38TFPeriodoDescrip = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A1732PeriodoDescrip = "" ;
      AV54Periodowwds_3_tfperiododescrip = "" ;
      AV55Periodowwds_4_tfperiododescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV54Periodowwds_3_tfperiododescrip = "" ;
      P02EW2_A1732PeriodoDescrip = new String[] {""} ;
      P02EW2_A1730PeriodoAnio = new short[1] ;
      P02EW2_A1729PeriodoLiq = new java.util.Date[] {GXutil.nullDate()} ;
      P02EW2_A1EmpCod = new short[1] ;
      P02EW2_A3CliCod = new int[1] ;
      A1729PeriodoLiq = GXutil.nullDate() ;
      GXv_int5 = new short[1] ;
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector10 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV37TFPeriodoDescrip_SelsJson = "" ;
      AV17MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.periodowwexport__default(),
         new Object[] {
             new Object[] {
            P02EW2_A1732PeriodoDescrip, P02EW2_A1730PeriodoAnio, P02EW2_A1729PeriodoLiq, P02EW2_A1EmpCod, P02EW2_A3CliCod
            }
         }
      );
      AV48Pgmname = "PeriodoWWExport" ;
      /* GeneXus formulas. */
      AV48Pgmname = "PeriodoWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short AV35TFPeriodoAnio ;
   private short AV36TFPeriodoAnio_To ;
   private short AV41TFPeriodoCntLiq ;
   private short AV42TFPeriodoCntLiq_To ;
   private short A1730PeriodoAnio ;
   private short A1735PeriodoCntLiq ;
   private short AV52Periodowwds_1_tfperiodoanio ;
   private short AV53Periodowwds_2_tfperiodoanio_to ;
   private short AV56Periodowwds_5_tfperiodocntliq ;
   private short AV57Periodowwds_6_tfperiodocntliq_to ;
   private short AV18OrderedBy ;
   private short AV45EmpCod ;
   private short A1EmpCod ;
   private short GXt_int8 ;
   private short GXv_int5[] ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV49GXV1 ;
   private int AV50GXV2 ;
   private int AV55Periodowwds_4_tfperiododescrip_sels_size ;
   private int AV44CliCod ;
   private int A3CliCod ;
   private int AV58GXV3 ;
   private int AV59GXV4 ;
   private long AV43i ;
   private long AV32VisibleColumnCount ;
   private String AV48Pgmname ;
   private String scmdbuf ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private java.util.Date A1729PeriodoLiq ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV19OrderedDsc ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV37TFPeriodoDescrip_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV40TFPeriodoDescrip_Sel ;
   private String AV38TFPeriodoDescrip ;
   private String A1732PeriodoDescrip ;
   private String AV54Periodowwds_3_tfperiododescrip ;
   private String lV54Periodowwds_3_tfperiododescrip ;
   private String AV17MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV39TFPeriodoDescrip_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] P02EW2_A1732PeriodoDescrip ;
   private short[] P02EW2_A1730PeriodoAnio ;
   private java.util.Date[] P02EW2_A1729PeriodoLiq ;
   private short[] P02EW2_A1EmpCod ;
   private int[] P02EW2_A3CliCod ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV55Periodowwds_4_tfperiododescrip_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV24ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV25ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector10[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV26ColumnsSelector_Column ;
}

final  class periodowwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02EW2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1732PeriodoDescrip ,
                                          GXSimpleCollection<String> AV55Periodowwds_4_tfperiododescrip_sels ,
                                          short AV52Periodowwds_1_tfperiodoanio ,
                                          short AV53Periodowwds_2_tfperiodoanio_to ,
                                          int AV55Periodowwds_4_tfperiododescrip_sels_size ,
                                          String AV54Periodowwds_3_tfperiododescrip ,
                                          short A1730PeriodoAnio ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          short AV56Periodowwds_5_tfperiodocntliq ,
                                          short A1735PeriodoCntLiq ,
                                          short AV57Periodowwds_6_tfperiodocntliq_to ,
                                          int AV44CliCod ,
                                          short AV45EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[5];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT PeriodoDescrip, PeriodoAnio, PeriodoLiq, EmpCod, CliCod FROM Periodo" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      if ( ! (0==AV52Periodowwds_1_tfperiodoanio) )
      {
         addWhere(sWhereString, "(PeriodoAnio >= ?)");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( ! (0==AV53Periodowwds_2_tfperiodoanio_to) )
      {
         addWhere(sWhereString, "(PeriodoAnio <= ?)");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( ( AV55Periodowwds_4_tfperiododescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV54Periodowwds_3_tfperiododescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(PeriodoDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( AV55Periodowwds_4_tfperiododescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV55Periodowwds_4_tfperiododescrip_sels, "PeriodoDescrip IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( AV18OrderedBy == 1 )
      {
         scmdbuf += " ORDER BY CliCod, EmpCod, PeriodoLiq DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY PeriodoAnio" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PeriodoAnio DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY PeriodoDescrip" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PeriodoDescrip DESC" ;
      }
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
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
                  return conditional_P02EW2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Boolean) dynConstraints[8]).booleanValue() , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02EW2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
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
                  stmt.setShort(sIdx, ((Number) parms[6]).shortValue());
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
                  stmt.setVarchar(sIdx, (String)parms[9], 400);
               }
               return;
      }
   }

}

