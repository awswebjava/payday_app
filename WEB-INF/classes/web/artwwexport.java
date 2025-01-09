package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class artwwexport extends GXProcedure
{
   public artwwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( artwwexport.class ), "" );
   }

   public artwwexport( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      artwwexport.this.aP1 = new String[] {""};
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
      artwwexport.this.aP0 = aP0;
      artwwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWART", GXv_boolean2) ;
      artwwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
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
         S211 ();
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
         /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
         S191 ();
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
         S201 ();
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
      AV12Filename = "ARTWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV40TFARTNom_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Nombre", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         artwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV50i = 1 ;
         AV60GXV1 = 1 ;
         while ( AV60GXV1 <= AV40TFARTNom_Sels.size() )
         {
            AV41TFARTNom_Sel = (String)AV40TFARTNom_Sels.elementAt(-1+AV60GXV1) ;
            if ( AV50i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV41TFARTNom_Sel, GXv_char7) ;
            artwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV50i = (long)(AV50i+1) ;
            AV60GXV1 = (int)(AV60GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV39TFARTNom)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Nombre", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            artwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV39TFARTNom, GXv_char7) ;
            artwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV42TFARTPaiCod) && (0==AV43TFARTPaiCod_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         artwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV42TFARTPaiCod );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         artwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV43TFARTPaiCod_To );
      }
      if ( ! ( ( AV46TFARTPaiNom_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Nom", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         artwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV50i = 1 ;
         AV61GXV2 = 1 ;
         while ( AV61GXV2 <= AV46TFARTPaiNom_Sels.size() )
         {
            AV47TFARTPaiNom_Sel = (String)AV46TFARTPaiNom_Sels.elementAt(-1+AV61GXV2) ;
            if ( AV50i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV47TFARTPaiNom_Sel, GXv_char7) ;
            artwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV50i = (long)(AV50i+1) ;
            AV61GXV2 = (int)(AV61GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV45TFARTPaiNom)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Nom", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            artwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV45TFARTPaiNom, GXv_char7) ;
            artwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV48TFARTAli)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV49TFARTAli_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Alìcuota", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         artwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV48TFARTAli)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         artwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV49TFARTAli_To)) );
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV35VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("ARTWWColumnsSelector"), "") != 0 )
      {
         AV30ColumnsSelectorXML = AV20Session.getValue("ARTWWColumnsSelector") ;
         AV27ColumnsSelector.fromxml(AV30ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( (boolean)((AV24IsAuthorizedARTPaiCod&&((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible())) );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( (boolean)((AV26IsAuthorizedARTPaiNom&&((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible())) );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV62GXV3 = 1 ;
      while ( AV62GXV3 <= AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV29ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV62GXV3));
         if ( AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV35VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV35VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV35VisibleColumnCount), 1, 1).setColor( 11 );
            AV35VisibleColumnCount = (long)(AV35VisibleColumnCount+1) ;
         }
         AV62GXV3 = (int)(AV62GXV3+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV64Artwwds_1_tfartnom = AV39TFARTNom ;
      AV65Artwwds_2_tfartnom_sels = AV40TFARTNom_Sels ;
      AV66Artwwds_3_tfartpaicod = AV42TFARTPaiCod ;
      AV67Artwwds_4_tfartpaicod_to = AV43TFARTPaiCod_To ;
      AV68Artwwds_5_tfartpainom = AV45TFARTPaiNom ;
      AV69Artwwds_6_tfartpainom_sels = AV46TFARTPaiNom_Sels ;
      AV70Artwwds_7_tfartali = AV48TFARTAli ;
      AV71Artwwds_8_tfartali_to = AV49TFARTAli_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1152ARTNom ,
                                           AV65Artwwds_2_tfartnom_sels ,
                                           A1150ARTPaiNom ,
                                           AV69Artwwds_6_tfartpainom_sels ,
                                           Integer.valueOf(AV65Artwwds_2_tfartnom_sels.size()) ,
                                           AV64Artwwds_1_tfartnom ,
                                           Short.valueOf(AV66Artwwds_3_tfartpaicod) ,
                                           Short.valueOf(AV67Artwwds_4_tfartpaicod_to) ,
                                           Integer.valueOf(AV69Artwwds_6_tfartpainom_sels.size()) ,
                                           AV68Artwwds_5_tfartpainom ,
                                           AV70Artwwds_7_tfartali ,
                                           AV71Artwwds_8_tfartali_to ,
                                           Short.valueOf(AV53PaiCod) ,
                                           Short.valueOf(A1149ARTPaiCod) ,
                                           A1153ARTAli ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV64Artwwds_1_tfartnom = GXutil.concat( GXutil.rtrim( AV64Artwwds_1_tfartnom), "%", "") ;
      lV68Artwwds_5_tfartpainom = GXutil.concat( GXutil.rtrim( AV68Artwwds_5_tfartpainom), "%", "") ;
      /* Using cursor P01IG2 */
      pr_default.execute(0, new Object[] {lV64Artwwds_1_tfartnom, Short.valueOf(AV66Artwwds_3_tfartpaicod), Short.valueOf(AV67Artwwds_4_tfartpaicod_to), lV68Artwwds_5_tfartpainom, AV70Artwwds_7_tfartali, AV71Artwwds_8_tfartali_to, Short.valueOf(AV53PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1153ARTAli = P01IG2_A1153ARTAli[0] ;
         A1150ARTPaiNom = P01IG2_A1150ARTPaiNom[0] ;
         A1149ARTPaiCod = P01IG2_A1149ARTPaiCod[0] ;
         A1152ARTNom = P01IG2_A1152ARTNom[0] ;
         A1151ARTSec = P01IG2_A1151ARTSec[0] ;
         A1150ARTPaiNom = P01IG2_A1150ARTPaiNom[0] ;
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
         AV35VisibleColumnCount = 0 ;
         AV72GXV4 = 1 ;
         while ( AV72GXV4 <= AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV29ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV72GXV4));
            if ( AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ARTNom") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1152ARTNom, GXv_char7) ;
                  artwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV35VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ARTPaiCod") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV35VisibleColumnCount), 1, 1).setNumber( A1149ARTPaiCod );
               }
               else if ( GXutil.strcmp(AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ARTPaiNom") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1150ARTPaiNom, GXv_char7) ;
                  artwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV35VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ARTAli") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV35VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1153ARTAli)) );
               }
               AV35VisibleColumnCount = (long)(AV35VisibleColumnCount+1) ;
            }
            AV72GXV4 = (int)(AV72GXV4+1) ;
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
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      AV24IsAuthorizedARTPaiCod = (boolean)(((AV73Esconceptosdefault.doubleValue()==(1)))) ;
      AV26IsAuthorizedARTPaiNom = (boolean)(((AV73Esconceptosdefault.doubleValue()==(1)))) ;
   }

   public void S201( )
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
      AV27ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ARTNom", "", "Nombre", true, "") ;
      AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      if ( ( ( AV73Esconceptosdefault.doubleValue() == ( 1 )) ) )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ARTPaiCod", "", "", true, "") ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      if ( ( ( AV73Esconceptosdefault.doubleValue() == ( 1 )) ) )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ARTPaiNom", "", "Nom", true, "") ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ARTAli", "", "Alìcuota", true, "") ;
      AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&VerSVG", "", "", true, "") ;
      AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      if ( ( ( AV73Esconceptosdefault.doubleValue() == ( 1 )) ) )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&ModificarSVG", "", "", true, "") ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      if ( ( ( AV73Esconceptosdefault.doubleValue() == ( 1 )) ) )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&EliminarSVG", "", "", true, "") ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      GXt_char6 = AV31UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "ARTWWColumnsSelector", GXv_char7) ;
      artwwexport.this.GXt_char6 = GXv_char7[0] ;
      AV31UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV31UserCustomValue)==0) ) )
      {
         AV28ColumnsSelectorAux.fromxml(AV31UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector9[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, GXv_SdtWWPColumnsSelector9) ;
         AV28ColumnsSelectorAux = GXv_SdtWWPColumnsSelector8[0] ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
   }

   public void S211( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("ARTWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ARTWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("ARTWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV74GXV5 = 1 ;
      while ( AV74GXV5 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV74GXV5));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFARTNOM") == 0 )
         {
            AV39TFARTNom = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFARTNOM_SEL") == 0 )
         {
            AV38TFARTNom_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV40TFARTNom_Sels.fromJSonString(AV38TFARTNom_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFARTPAICOD") == 0 )
         {
            AV42TFARTPaiCod = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV43TFARTPaiCod_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFARTPAINOM") == 0 )
         {
            AV45TFARTPaiNom = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFARTPAINOM_SEL") == 0 )
         {
            AV44TFARTPaiNom_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV46TFARTPaiNom_Sels.fromJSonString(AV44TFARTPaiNom_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFARTALI") == 0 )
         {
            AV48TFARTAli = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV49TFARTAli_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV54MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV74GXV5 = (int)(AV74GXV5+1) ;
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
      this.aP0[0] = artwwexport.this.AV12Filename;
      this.aP1[0] = artwwexport.this.AV13ErrorMessage;
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
      AV40TFARTNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV41TFARTNom_Sel = "" ;
      AV39TFARTNom = "" ;
      AV46TFARTPaiNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV47TFARTPaiNom_Sel = "" ;
      AV45TFARTPaiNom = "" ;
      AV48TFARTAli = DecimalUtil.ZERO ;
      AV49TFARTAli_To = DecimalUtil.ZERO ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV30ColumnsSelectorXML = "" ;
      AV27ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV29ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A1152ARTNom = "" ;
      A1150ARTPaiNom = "" ;
      A1153ARTAli = DecimalUtil.ZERO ;
      AV64Artwwds_1_tfartnom = "" ;
      AV65Artwwds_2_tfartnom_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV68Artwwds_5_tfartpainom = "" ;
      AV69Artwwds_6_tfartpainom_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV70Artwwds_7_tfartali = DecimalUtil.ZERO ;
      AV71Artwwds_8_tfartali_to = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      lV64Artwwds_1_tfartnom = "" ;
      lV68Artwwds_5_tfartpainom = "" ;
      P01IG2_A1153ARTAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01IG2_A1150ARTPaiNom = new String[] {""} ;
      P01IG2_A1149ARTPaiCod = new short[1] ;
      P01IG2_A1152ARTNom = new String[] {""} ;
      P01IG2_A1151ARTSec = new short[1] ;
      AV73Esconceptosdefault = DecimalUtil.ZERO ;
      AV31UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV28ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV38TFARTNom_SelsJson = "" ;
      AV44TFARTPaiNom_SelsJson = "" ;
      AV54MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.artwwexport__default(),
         new Object[] {
             new Object[] {
            P01IG2_A1153ARTAli, P01IG2_A1150ARTPaiNom, P01IG2_A1149ARTPaiCod, P01IG2_A1152ARTNom, P01IG2_A1151ARTSec
            }
         }
      );
      AV59Pgmname = "ARTWWExport" ;
      /* GeneXus formulas. */
      AV59Pgmname = "ARTWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short AV42TFARTPaiCod ;
   private short AV43TFARTPaiCod_To ;
   private short GXv_int5[] ;
   private short A1149ARTPaiCod ;
   private short AV66Artwwds_3_tfartpaicod ;
   private short AV67Artwwds_4_tfartpaicod_to ;
   private short AV53PaiCod ;
   private short AV18OrderedBy ;
   private short A1151ARTSec ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV60GXV1 ;
   private int AV61GXV2 ;
   private int AV62GXV3 ;
   private int AV65Artwwds_2_tfartnom_sels_size ;
   private int AV69Artwwds_6_tfartpainom_sels_size ;
   private int AV72GXV4 ;
   private int AV74GXV5 ;
   private long AV50i ;
   private long AV35VisibleColumnCount ;
   private java.math.BigDecimal AV48TFARTAli ;
   private java.math.BigDecimal AV49TFARTAli_To ;
   private java.math.BigDecimal A1153ARTAli ;
   private java.math.BigDecimal AV70Artwwds_7_tfartali ;
   private java.math.BigDecimal AV71Artwwds_8_tfartali_to ;
   private java.math.BigDecimal AV73Esconceptosdefault ;
   private String AV59Pgmname ;
   private String scmdbuf ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV24IsAuthorizedARTPaiCod ;
   private boolean AV26IsAuthorizedARTPaiNom ;
   private boolean AV19OrderedDsc ;
   private String AV30ColumnsSelectorXML ;
   private String AV31UserCustomValue ;
   private String AV38TFARTNom_SelsJson ;
   private String AV44TFARTPaiNom_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV41TFARTNom_Sel ;
   private String AV39TFARTNom ;
   private String AV47TFARTPaiNom_Sel ;
   private String AV45TFARTPaiNom ;
   private String A1152ARTNom ;
   private String A1150ARTPaiNom ;
   private String AV64Artwwds_1_tfartnom ;
   private String AV68Artwwds_5_tfartpainom ;
   private String lV64Artwwds_1_tfartnom ;
   private String lV68Artwwds_5_tfartpainom ;
   private String AV54MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV40TFARTNom_Sels ;
   private GXSimpleCollection<String> AV46TFARTPaiNom_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] P01IG2_A1153ARTAli ;
   private String[] P01IG2_A1150ARTPaiNom ;
   private short[] P01IG2_A1149ARTPaiCod ;
   private String[] P01IG2_A1152ARTNom ;
   private short[] P01IG2_A1151ARTSec ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV65Artwwds_2_tfartnom_sels ;
   private GXSimpleCollection<String> AV69Artwwds_6_tfartpainom_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV27ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV28ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV29ColumnsSelector_Column ;
}

final  class artwwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01IG2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1152ARTNom ,
                                          GXSimpleCollection<String> AV65Artwwds_2_tfartnom_sels ,
                                          String A1150ARTPaiNom ,
                                          GXSimpleCollection<String> AV69Artwwds_6_tfartpainom_sels ,
                                          int AV65Artwwds_2_tfartnom_sels_size ,
                                          String AV64Artwwds_1_tfartnom ,
                                          short AV66Artwwds_3_tfartpaicod ,
                                          short AV67Artwwds_4_tfartpaicod_to ,
                                          int AV69Artwwds_6_tfartpainom_sels_size ,
                                          String AV68Artwwds_5_tfartpainom ,
                                          java.math.BigDecimal AV70Artwwds_7_tfartali ,
                                          java.math.BigDecimal AV71Artwwds_8_tfartali_to ,
                                          short AV53PaiCod ,
                                          short A1149ARTPaiCod ,
                                          java.math.BigDecimal A1153ARTAli ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[7];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT T1.ARTAli, T2.PaiNom AS ARTPaiNom, T1.ARTPaiCod AS ARTPaiCod, T1.ARTNom, T1.ARTSec FROM (ART T1 INNER JOIN Pais T2 ON T2.PaiCod = T1.ARTPaiCod)" ;
      if ( ( AV65Artwwds_2_tfartnom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV64Artwwds_1_tfartnom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ARTNom) like LOWER(?))");
      }
      else
      {
         GXv_int10[0] = (byte)(1) ;
      }
      if ( AV65Artwwds_2_tfartnom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65Artwwds_2_tfartnom_sels, "T1.ARTNom IN (", ")")+")");
      }
      if ( ! (0==AV66Artwwds_3_tfartpaicod) )
      {
         addWhere(sWhereString, "(T1.ARTPaiCod >= ?)");
      }
      else
      {
         GXv_int10[1] = (byte)(1) ;
      }
      if ( ! (0==AV67Artwwds_4_tfartpaicod_to) )
      {
         addWhere(sWhereString, "(T1.ARTPaiCod <= ?)");
      }
      else
      {
         GXv_int10[2] = (byte)(1) ;
      }
      if ( ( AV69Artwwds_6_tfartpainom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV68Artwwds_5_tfartpainom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.PaiNom) like LOWER(?))");
      }
      else
      {
         GXv_int10[3] = (byte)(1) ;
      }
      if ( AV69Artwwds_6_tfartpainom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV69Artwwds_6_tfartpainom_sels, "T2.PaiNom IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV70Artwwds_7_tfartali)==0) )
      {
         addWhere(sWhereString, "(T1.ARTAli >= ?)");
      }
      else
      {
         GXv_int10[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV71Artwwds_8_tfartali_to)==0) )
      {
         addWhere(sWhereString, "(T1.ARTAli <= ?)");
      }
      else
      {
         GXv_int10[5] = (byte)(1) ;
      }
      if ( ! (0==AV53PaiCod) )
      {
         addWhere(sWhereString, "(T1.ARTPaiCod = ?)");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.ARTNom" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.ARTNom DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.ARTPaiCod" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.ARTPaiCod DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.PaiNom" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.PaiNom DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.ARTAli" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.ARTAli DESC" ;
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
                  return conditional_P01IG2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , (java.math.BigDecimal)dynConstraints[10] , (java.math.BigDecimal)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).shortValue() , (java.math.BigDecimal)dynConstraints[14] , ((Number) dynConstraints[15]).shortValue() , ((Boolean) dynConstraints[16]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01IG2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,4);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
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
                  stmt.setVarchar(sIdx, (String)parms[7], 400);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[8]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 30);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[11], 4);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[12], 4);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               return;
      }
   }

}

