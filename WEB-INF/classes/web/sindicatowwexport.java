package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class sindicatowwexport extends GXProcedure
{
   public sindicatowwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( sindicatowwexport.class ), "" );
   }

   public sindicatowwexport( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      sindicatowwexport.this.aP1 = new String[] {""};
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
      sindicatowwexport.this.aP0 = aP0;
      sindicatowwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSindicato", GXv_boolean2) ;
      sindicatowwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV57Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "SindicatoWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV37TFSinCod_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Código", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         sindicatowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV45i = 1 ;
         AV58GXV1 = 1 ;
         while ( AV58GXV1 <= AV37TFSinCod_Sels.size() )
         {
            AV38TFSinCod_Sel = (String)AV37TFSinCod_Sels.elementAt(-1+AV58GXV1) ;
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
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFSinCod_Sel, GXv_char7) ;
            sindicatowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV45i = (long)(AV45i+1) ;
            AV58GXV1 = (int)(AV58GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV36TFSinCod)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Código", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            sindicatowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV36TFSinCod, GXv_char7) ;
            sindicatowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV41TFSinDescrip_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         sindicatowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV45i = 1 ;
         AV59GXV2 = 1 ;
         while ( AV59GXV2 <= AV41TFSinDescrip_Sels.size() )
         {
            AV42TFSinDescrip_Sel = (String)AV41TFSinDescrip_Sels.elementAt(-1+AV59GXV2) ;
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
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV42TFSinDescrip_Sel, GXv_char7) ;
            sindicatowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV45i = (long)(AV45i+1) ;
            AV59GXV2 = (int)(AV59GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV40TFSinDescrip)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            sindicatowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFSinDescrip, GXv_char7) ;
            sindicatowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV43TFSinCuotaAli)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV44TFSinCuotaAli_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Alícuota Cuota Sindical", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         sindicatowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV43TFSinCuotaAli)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         sindicatowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV44TFSinCuotaAli_To)) );
      }
      if ( ! ( (0==AV53TFSinDefault_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Default", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         sindicatowwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV53TFSinDefault_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV53TFSinDefault_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("SindicatoWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("SindicatoWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( (boolean)((AV54IsAuthorizedSinDefault&&((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible())) );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV60GXV3 = 1 ;
      while ( AV60GXV3 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV60GXV3));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV60GXV3 = (int)(AV60GXV3+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV62Sindicatowwds_1_tfsincod = AV36TFSinCod ;
      AV63Sindicatowwds_2_tfsincod_sels = AV37TFSinCod_Sels ;
      AV64Sindicatowwds_3_tfsindescrip = AV40TFSinDescrip ;
      AV65Sindicatowwds_4_tfsindescrip_sels = AV41TFSinDescrip_Sels ;
      AV66Sindicatowwds_5_tfsincuotaali = AV43TFSinCuotaAli ;
      AV67Sindicatowwds_6_tfsincuotaali_to = AV44TFSinCuotaAli_To ;
      AV68Sindicatowwds_7_tfsindefault_sel = AV53TFSinDefault_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A14SinCod ,
                                           AV63Sindicatowwds_2_tfsincod_sels ,
                                           A331SinDescrip ,
                                           AV65Sindicatowwds_4_tfsindescrip_sels ,
                                           Integer.valueOf(AV63Sindicatowwds_2_tfsincod_sels.size()) ,
                                           AV62Sindicatowwds_1_tfsincod ,
                                           Integer.valueOf(AV65Sindicatowwds_4_tfsindescrip_sels.size()) ,
                                           AV64Sindicatowwds_3_tfsindescrip ,
                                           AV66Sindicatowwds_5_tfsincuotaali ,
                                           AV67Sindicatowwds_6_tfsincuotaali_to ,
                                           Byte.valueOf(AV68Sindicatowwds_7_tfsindefault_sel) ,
                                           Short.valueOf(AV48PaiCod) ,
                                           A930SinCuotaAli ,
                                           Boolean.valueOf(A906SinDefault) ,
                                           Short.valueOf(A46PaiCod) ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BYTE, TypeConstants.SHORT,
                                           TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV62Sindicatowwds_1_tfsincod = GXutil.padr( GXutil.rtrim( AV62Sindicatowwds_1_tfsincod), 20, "%") ;
      lV64Sindicatowwds_3_tfsindescrip = GXutil.concat( GXutil.rtrim( AV64Sindicatowwds_3_tfsindescrip), "%", "") ;
      /* Using cursor P01IF2 */
      pr_default.execute(0, new Object[] {lV62Sindicatowwds_1_tfsincod, lV64Sindicatowwds_3_tfsindescrip, AV66Sindicatowwds_5_tfsincuotaali, AV67Sindicatowwds_6_tfsincuotaali_to, Short.valueOf(AV48PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A46PaiCod = P01IF2_A46PaiCod[0] ;
         A906SinDefault = P01IF2_A906SinDefault[0] ;
         A930SinCuotaAli = P01IF2_A930SinCuotaAli[0] ;
         A331SinDescrip = P01IF2_A331SinDescrip[0] ;
         A14SinCod = P01IF2_A14SinCod[0] ;
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
         AV69GXV4 = 1 ;
         while ( AV69GXV4 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV69GXV4));
            if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SinCod") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A14SinCod, GXv_char7) ;
                  sindicatowwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SinDescrip") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A331SinDescrip, GXv_char7) ;
                  sindicatowwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SinCuotaAli") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A930SinCuotaAli)) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SinDefault") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A906SinDefault) );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV69GXV4 = (int)(AV69GXV4+1) ;
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
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      GXt_boolean1 = AV54IsAuthorizedSinDefault ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.esconceptosdefault(remoteHandle, context).execute( GXv_boolean2) ;
      sindicatowwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV54IsAuthorizedSinDefault = (boolean)((GXt_boolean1)) ;
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
      AV24ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SinCod", "", "Código", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SinDescrip", "", "Descripción", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SinCuotaAli", "", "Alícuota Cuota Sindical", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      if ( new web.esconceptosdefault(remoteHandle, context).executeUdp( ) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SinDefault", "", "Default", true, "") ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&VerSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      if ( new web.esconceptosdefault(remoteHandle, context).executeUdp( ) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&ModificarSVG", "", "", true, "") ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      if ( new web.esconceptosdefault(remoteHandle, context).executeUdp( ) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&EliminarSVG", "", "", true, "") ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      GXt_char6 = AV28UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "SindicatoWWColumnsSelector", GXv_char7) ;
      sindicatowwexport.this.GXt_char6 = GXv_char7[0] ;
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

   public void S211( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("SindicatoWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "SindicatoWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("SindicatoWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV70GXV5 = 1 ;
      while ( AV70GXV5 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV70GXV5));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSINCOD") == 0 )
         {
            AV36TFSinCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSINCOD_SEL") == 0 )
         {
            AV35TFSinCod_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV37TFSinCod_Sels.fromJSonString(AV35TFSinCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSINDESCRIP") == 0 )
         {
            AV40TFSinDescrip = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSINDESCRIP_SEL") == 0 )
         {
            AV39TFSinDescrip_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV41TFSinDescrip_Sels.fromJSonString(AV39TFSinDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSINCUOTAALI") == 0 )
         {
            AV43TFSinCuotaAli = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV44TFSinCuotaAli_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSINDEFAULT_SEL") == 0 )
         {
            AV53TFSinDefault_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV49MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV70GXV5 = (int)(AV70GXV5+1) ;
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
      this.aP0[0] = sindicatowwexport.this.AV12Filename;
      this.aP1[0] = sindicatowwexport.this.AV13ErrorMessage;
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
      AV57Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV37TFSinCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV38TFSinCod_Sel = "" ;
      AV36TFSinCod = "" ;
      AV41TFSinDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42TFSinDescrip_Sel = "" ;
      AV40TFSinDescrip = "" ;
      AV43TFSinCuotaAli = DecimalUtil.ZERO ;
      AV44TFSinCuotaAli_To = DecimalUtil.ZERO ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A14SinCod = "" ;
      A331SinDescrip = "" ;
      A930SinCuotaAli = DecimalUtil.ZERO ;
      AV62Sindicatowwds_1_tfsincod = "" ;
      AV63Sindicatowwds_2_tfsincod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV64Sindicatowwds_3_tfsindescrip = "" ;
      AV65Sindicatowwds_4_tfsindescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV66Sindicatowwds_5_tfsincuotaali = DecimalUtil.ZERO ;
      AV67Sindicatowwds_6_tfsincuotaali_to = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      lV62Sindicatowwds_1_tfsincod = "" ;
      lV64Sindicatowwds_3_tfsindescrip = "" ;
      P01IF2_A46PaiCod = new short[1] ;
      P01IF2_A906SinDefault = new boolean[] {false} ;
      P01IF2_A930SinCuotaAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01IF2_A331SinDescrip = new String[] {""} ;
      P01IF2_A14SinCod = new String[] {""} ;
      GXv_boolean2 = new boolean[1] ;
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV35TFSinCod_SelsJson = "" ;
      AV39TFSinDescrip_SelsJson = "" ;
      AV49MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.sindicatowwexport__default(),
         new Object[] {
             new Object[] {
            P01IF2_A46PaiCod, P01IF2_A906SinDefault, P01IF2_A930SinCuotaAli, P01IF2_A331SinDescrip, P01IF2_A14SinCod
            }
         }
      );
      AV57Pgmname = "SindicatoWWExport" ;
      /* GeneXus formulas. */
      AV57Pgmname = "SindicatoWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV53TFSinDefault_Sel ;
   private byte AV68Sindicatowwds_7_tfsindefault_sel ;
   private short GXv_int5[] ;
   private short AV48PaiCod ;
   private short A46PaiCod ;
   private short AV18OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV58GXV1 ;
   private int AV59GXV2 ;
   private int AV60GXV3 ;
   private int AV63Sindicatowwds_2_tfsincod_sels_size ;
   private int AV65Sindicatowwds_4_tfsindescrip_sels_size ;
   private int AV69GXV4 ;
   private int AV70GXV5 ;
   private long AV45i ;
   private long AV32VisibleColumnCount ;
   private java.math.BigDecimal AV43TFSinCuotaAli ;
   private java.math.BigDecimal AV44TFSinCuotaAli_To ;
   private java.math.BigDecimal A930SinCuotaAli ;
   private java.math.BigDecimal AV66Sindicatowwds_5_tfsincuotaali ;
   private java.math.BigDecimal AV67Sindicatowwds_6_tfsincuotaali_to ;
   private String AV57Pgmname ;
   private String AV38TFSinCod_Sel ;
   private String AV36TFSinCod ;
   private String A14SinCod ;
   private String AV62Sindicatowwds_1_tfsincod ;
   private String scmdbuf ;
   private String lV62Sindicatowwds_1_tfsincod ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean returnInSub ;
   private boolean AV54IsAuthorizedSinDefault ;
   private boolean A906SinDefault ;
   private boolean AV19OrderedDsc ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean Cond_result ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV35TFSinCod_SelsJson ;
   private String AV39TFSinDescrip_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV42TFSinDescrip_Sel ;
   private String AV40TFSinDescrip ;
   private String A331SinDescrip ;
   private String AV64Sindicatowwds_3_tfsindescrip ;
   private String lV64Sindicatowwds_3_tfsindescrip ;
   private String AV49MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV37TFSinCod_Sels ;
   private GXSimpleCollection<String> AV41TFSinDescrip_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private short[] P01IF2_A46PaiCod ;
   private boolean[] P01IF2_A906SinDefault ;
   private java.math.BigDecimal[] P01IF2_A930SinCuotaAli ;
   private String[] P01IF2_A331SinDescrip ;
   private String[] P01IF2_A14SinCod ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV63Sindicatowwds_2_tfsincod_sels ;
   private GXSimpleCollection<String> AV65Sindicatowwds_4_tfsindescrip_sels ;
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

final  class sindicatowwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01IF2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A14SinCod ,
                                          GXSimpleCollection<String> AV63Sindicatowwds_2_tfsincod_sels ,
                                          String A331SinDescrip ,
                                          GXSimpleCollection<String> AV65Sindicatowwds_4_tfsindescrip_sels ,
                                          int AV63Sindicatowwds_2_tfsincod_sels_size ,
                                          String AV62Sindicatowwds_1_tfsincod ,
                                          int AV65Sindicatowwds_4_tfsindescrip_sels_size ,
                                          String AV64Sindicatowwds_3_tfsindescrip ,
                                          java.math.BigDecimal AV66Sindicatowwds_5_tfsincuotaali ,
                                          java.math.BigDecimal AV67Sindicatowwds_6_tfsincuotaali_to ,
                                          byte AV68Sindicatowwds_7_tfsindefault_sel ,
                                          short AV48PaiCod ,
                                          java.math.BigDecimal A930SinCuotaAli ,
                                          boolean A906SinDefault ,
                                          short A46PaiCod ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[5];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT PaiCod, SinDefault, SinCuotaAli, SinDescrip, SinCod FROM Sindicato" ;
      if ( ( AV63Sindicatowwds_2_tfsincod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV62Sindicatowwds_1_tfsincod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SinCod) like LOWER(?))");
      }
      else
      {
         GXv_int10[0] = (byte)(1) ;
      }
      if ( AV63Sindicatowwds_2_tfsincod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV63Sindicatowwds_2_tfsincod_sels, "SinCod IN (", ")")+")");
      }
      if ( ( AV65Sindicatowwds_4_tfsindescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV64Sindicatowwds_3_tfsindescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SinDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int10[1] = (byte)(1) ;
      }
      if ( AV65Sindicatowwds_4_tfsindescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65Sindicatowwds_4_tfsindescrip_sels, "SinDescrip IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66Sindicatowwds_5_tfsincuotaali)==0) )
      {
         addWhere(sWhereString, "(SinCuotaAli >= ?)");
      }
      else
      {
         GXv_int10[2] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67Sindicatowwds_6_tfsincuotaali_to)==0) )
      {
         addWhere(sWhereString, "(SinCuotaAli <= ?)");
      }
      else
      {
         GXv_int10[3] = (byte)(1) ;
      }
      if ( AV68Sindicatowwds_7_tfsindefault_sel == 1 )
      {
         addWhere(sWhereString, "(SinDefault = TRUE)");
      }
      if ( AV68Sindicatowwds_7_tfsindefault_sel == 2 )
      {
         addWhere(sWhereString, "(SinDefault = FALSE)");
      }
      if ( ! (0==AV48PaiCod) )
      {
         addWhere(sWhereString, "(PaiCod = ?)");
      }
      else
      {
         GXv_int10[4] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY SinCod" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY SinCod DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY SinDescrip" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY SinDescrip DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY SinCuotaAli" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY SinCuotaAli DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY SinDefault" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY SinDefault DESC" ;
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
                  return conditional_P01IF2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , (java.math.BigDecimal)dynConstraints[8] , (java.math.BigDecimal)dynConstraints[9] , ((Number) dynConstraints[10]).byteValue() , ((Number) dynConstraints[11]).shortValue() , (java.math.BigDecimal)dynConstraints[12] , ((Boolean) dynConstraints[13]).booleanValue() , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , ((Boolean) dynConstraints[16]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01IF2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
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
                  stmt.setString(sIdx, (String)parms[5], 20);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 400);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[7], 4);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[8], 4);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               return;
      }
   }

}

