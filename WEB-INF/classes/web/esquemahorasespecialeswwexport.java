package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class esquemahorasespecialeswwexport extends GXProcedure
{
   public esquemahorasespecialeswwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( esquemahorasespecialeswwexport.class ), "" );
   }

   public esquemahorasespecialeswwexport( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      esquemahorasespecialeswwexport.this.aP1 = new String[] {""};
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
      esquemahorasespecialeswwexport.this.aP0 = aP0;
      esquemahorasespecialeswwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEsquemaHorasEspeciales", GXv_boolean2) ;
      esquemahorasespecialeswwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV60Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "EsquemaHorasEspecialesWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV39TFConvHsPDiaTipTra_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo de trabajo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         esquemahorasespecialeswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV52i = 1 ;
         AV61GXV1 = 1 ;
         while ( AV61GXV1 <= AV39TFConvHsPDiaTipTra_Sels.size() )
         {
            AV40TFConvHsPDiaTipTra_Sel = (String)AV39TFConvHsPDiaTipTra_Sels.elementAt(-1+AV61GXV1) ;
            if ( AV52i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaintipo_trabajo.getDescription(httpContext,(String)AV40TFConvHsPDiaTipTra_Sel), "") );
            AV52i = (long)(AV52i+1) ;
            AV61GXV1 = (int)(AV61GXV1+1) ;
         }
      }
      if ( ! ( ( AV42TFConveHsPDiaDia_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Día", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         esquemahorasespecialeswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV52i = 1 ;
         AV62GXV2 = 1 ;
         while ( AV62GXV2 <= AV42TFConveHsPDiaDia_Sels.size() )
         {
            AV43TFConveHsPDiaDia_Sel = ((Number) AV42TFConveHsPDiaDia_Sels.elementAt(-1+AV62GXV2)).byteValue() ;
            if ( AV52i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaindia_tra.getDescription(httpContext,(byte)AV43TFConveHsPDiaDia_Sel), "") );
            AV52i = (long)(AV52i+1) ;
            AV62GXV2 = (int)(AV62GXV2+1) ;
         }
      }
      if ( ! ( ( AV46TFConveHsPDiaDesde_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Hora desde", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         esquemahorasespecialeswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV52i = 1 ;
         AV63GXV3 = 1 ;
         while ( AV63GXV3 <= AV46TFConveHsPDiaDesde_Sels.size() )
         {
            AV47TFConveHsPDiaDesde_Sel = (String)AV46TFConveHsPDiaDesde_Sels.elementAt(-1+AV63GXV3) ;
            if ( AV52i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV47TFConveHsPDiaDesde_Sel, GXv_char7) ;
            esquemahorasespecialeswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV52i = (long)(AV52i+1) ;
            AV63GXV3 = (int)(AV63GXV3+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV45TFConveHsPDiaDesde)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Hora desde", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            esquemahorasespecialeswwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV45TFConveHsPDiaDesde, GXv_char7) ;
            esquemahorasespecialeswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV48TFConveTarifaPDia)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV49TFConveTarifaPDia_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Aumento de horas extras sobre hora normal", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         esquemahorasespecialeswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV48TFConveTarifaPDia)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         esquemahorasespecialeswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV49TFConveTarifaPDia_To)) );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV50TFConveTarifaPDRec)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV51TFConveTarifaPDRec_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Recargo a hora normal diurna", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         esquemahorasespecialeswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV50TFConveTarifaPDRec)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         esquemahorasespecialeswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV51TFConveTarifaPDRec_To)) );
      }
      if ( ! ( ( AV56TFConveTarifaPDCri_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Criterio de aplicación", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         esquemahorasespecialeswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV52i = 1 ;
         AV64GXV4 = 1 ;
         while ( AV64GXV4 <= AV56TFConveTarifaPDCri_Sels.size() )
         {
            AV57TFConveTarifaPDCri_Sel = (String)AV56TFConveTarifaPDCri_Sels.elementAt(-1+AV64GXV4) ;
            if ( AV52i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaincriterio_horaextra.getDescription(httpContext,(String)AV57TFConveTarifaPDCri_Sel), "") );
            AV52i = (long)(AV52i+1) ;
            AV64GXV4 = (int)(AV64GXV4+1) ;
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV33VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV21Session.getValue("EsquemaHorasEspecialesWWColumnsSelector"), "") != 0 )
      {
         AV28ColumnsSelectorXML = AV21Session.getValue("EsquemaHorasEspecialesWWColumnsSelector") ;
         AV25ColumnsSelector.fromxml(AV28ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV65GXV5 = 1 ;
      while ( AV65GXV5 <= AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV27ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV65GXV5));
         if ( AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setColor( 11 );
            AV33VisibleColumnCount = (long)(AV33VisibleColumnCount+1) ;
         }
         AV65GXV5 = (int)(AV65GXV5+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV67Esquemahorasespecialeswwds_1_tfconvhspdiatiptra_sels = AV39TFConvHsPDiaTipTra_Sels ;
      AV68Esquemahorasespecialeswwds_2_tfconvehspdiadia_sels = AV42TFConveHsPDiaDia_Sels ;
      AV69Esquemahorasespecialeswwds_3_tfconvehspdiadesde = AV45TFConveHsPDiaDesde ;
      AV70Esquemahorasespecialeswwds_4_tfconvehspdiadesde_sels = AV46TFConveHsPDiaDesde_Sels ;
      AV71Esquemahorasespecialeswwds_5_tfconvetarifapdia = AV48TFConveTarifaPDia ;
      AV72Esquemahorasespecialeswwds_6_tfconvetarifapdia_to = AV49TFConveTarifaPDia_To ;
      AV73Esquemahorasespecialeswwds_7_tfconvetarifapdrec = AV50TFConveTarifaPDRec ;
      AV74Esquemahorasespecialeswwds_8_tfconvetarifapdrec_to = AV51TFConveTarifaPDRec_To ;
      AV75Esquemahorasespecialeswwds_9_tfconvetarifapdcri_sels = AV56TFConveTarifaPDCri_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1326ConvHsPDiaTipTra ,
                                           AV67Esquemahorasespecialeswwds_1_tfconvhspdiatiptra_sels ,
                                           Byte.valueOf(A1328ConveHsPDiaDia) ,
                                           AV68Esquemahorasespecialeswwds_2_tfconvehspdiadia_sels ,
                                           A1329ConveHsPDiaDesde ,
                                           AV70Esquemahorasespecialeswwds_4_tfconvehspdiadesde_sels ,
                                           A2432ConveTarifaPDCri ,
                                           AV75Esquemahorasespecialeswwds_9_tfconvetarifapdcri_sels ,
                                           Integer.valueOf(AV67Esquemahorasespecialeswwds_1_tfconvhspdiatiptra_sels.size()) ,
                                           Integer.valueOf(AV68Esquemahorasespecialeswwds_2_tfconvehspdiadia_sels.size()) ,
                                           Integer.valueOf(AV70Esquemahorasespecialeswwds_4_tfconvehspdiadesde_sels.size()) ,
                                           AV69Esquemahorasespecialeswwds_3_tfconvehspdiadesde ,
                                           AV71Esquemahorasespecialeswwds_5_tfconvetarifapdia ,
                                           AV72Esquemahorasespecialeswwds_6_tfconvetarifapdia_to ,
                                           AV73Esquemahorasespecialeswwds_7_tfconvetarifapdrec ,
                                           AV74Esquemahorasespecialeswwds_8_tfconvetarifapdrec_to ,
                                           Integer.valueOf(AV75Esquemahorasespecialeswwds_9_tfconvetarifapdcri_sels.size()) ,
                                           A1330ConveTarifaPDia ,
                                           A1350ConveTarifaPDRec ,
                                           Short.valueOf(AV19OrderedBy) ,
                                           Boolean.valueOf(AV20OrderedDsc) ,
                                           A1565CliConvenio ,
                                           AV18CliConvenio ,
                                           Integer.valueOf(AV53CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV69Esquemahorasespecialeswwds_3_tfconvehspdiadesde = GXutil.padr( GXutil.rtrim( AV69Esquemahorasespecialeswwds_3_tfconvehspdiadesde), 5, "%") ;
      /* Using cursor P02M42 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV53CliCod), AV18CliConvenio, lV69Esquemahorasespecialeswwds_3_tfconvehspdiadesde, AV71Esquemahorasespecialeswwds_5_tfconvetarifapdia, AV72Esquemahorasespecialeswwds_6_tfconvetarifapdia_to, AV73Esquemahorasespecialeswwds_7_tfconvetarifapdrec, AV74Esquemahorasespecialeswwds_8_tfconvetarifapdrec_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1565CliConvenio = P02M42_A1565CliConvenio[0] ;
         A3CliCod = P02M42_A3CliCod[0] ;
         A2432ConveTarifaPDCri = P02M42_A2432ConveTarifaPDCri[0] ;
         A1350ConveTarifaPDRec = P02M42_A1350ConveTarifaPDRec[0] ;
         A1330ConveTarifaPDia = P02M42_A1330ConveTarifaPDia[0] ;
         A1329ConveHsPDiaDesde = P02M42_A1329ConveHsPDiaDesde[0] ;
         n1329ConveHsPDiaDesde = P02M42_n1329ConveHsPDiaDesde[0] ;
         A1328ConveHsPDiaDia = P02M42_A1328ConveHsPDiaDia[0] ;
         A1326ConvHsPDiaTipTra = P02M42_A1326ConvHsPDiaTipTra[0] ;
         A1564CliPaiConve = P02M42_A1564CliPaiConve[0] ;
         A1327ConveHsExSec = P02M42_A1327ConveHsExSec[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV33VisibleColumnCount = 0 ;
         AV76GXV6 = 1 ;
         while ( AV76GXV6 <= AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV27ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV76GXV6));
            if ( AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConvHsPDiaTipTra") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaintipo_trabajo.getDescription(httpContext,(String)A1326ConvHsPDiaTipTra), "") );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveHsPDiaDia") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaindia_tra.getDescription(httpContext,(byte)A1328ConveHsPDiaDia), "") );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveHsPDiaDesde") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1329ConveHsPDiaDesde, GXv_char7) ;
                  esquemahorasespecialeswwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveTarifaPDia") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1330ConveTarifaPDia)) );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveTarifaPDRec") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1350ConveTarifaPDRec)) );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveTarifaPDCri") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaincriterio_horaextra.getDescription(httpContext,(String)A2432ConveTarifaPDCri), "") );
               }
               AV33VisibleColumnCount = (long)(AV33VisibleColumnCount+1) ;
            }
            AV76GXV6 = (int)(AV76GXV6+1) ;
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
      AV25ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConvHsPDiaTipTra", "", "Tipo de trabajo", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConveHsPDiaDia", "", "Día", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConveHsPDiaDesde", "", "Hora desde", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConveTarifaPDia", "", "Aumento de horas extras sobre hora normal", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConveTarifaPDRec", "", "Recargo a hora normal diurna", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConveTarifaPDCri", "", "Criterio de aplicación", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&VerSVG", "", "", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&ModificarSVG", "", "", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&EliminarSVG", "", "", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV29UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "EsquemaHorasEspecialesWWColumnsSelector", GXv_char7) ;
      esquemahorasespecialeswwexport.this.GXt_char6 = GXv_char7[0] ;
      AV29UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV29UserCustomValue)==0) ) )
      {
         AV26ColumnsSelectorAux.fromxml(AV29UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, GXv_SdtWWPColumnsSelector9) ;
         AV26ColumnsSelectorAux = GXv_SdtWWPColumnsSelector8[0] ;
         AV25ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV21Session.getValue("EsquemaHorasEspecialesWWGridState"), "") == 0 )
      {
         AV23GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "EsquemaHorasEspecialesWWGridState"), null, null);
      }
      else
      {
         AV23GridState.fromxml(AV21Session.getValue("EsquemaHorasEspecialesWWGridState"), null, null);
      }
      AV19OrderedBy = AV23GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV20OrderedDsc = AV23GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV77GXV7 = 1 ;
      while ( AV77GXV7 <= AV23GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV24GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV23GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV77GXV7));
         if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVHSPDIATIPTRA_SEL") == 0 )
         {
            AV38TFConvHsPDiaTipTra_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV39TFConvHsPDiaTipTra_Sels.fromJSonString(AV38TFConvHsPDiaTipTra_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSPDIADIA_SEL") == 0 )
         {
            AV41TFConveHsPDiaDia_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV42TFConveHsPDiaDia_Sels.fromJSonString(AV41TFConveHsPDiaDia_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSPDIADESDE") == 0 )
         {
            AV45TFConveHsPDiaDesde = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSPDIADESDE_SEL") == 0 )
         {
            AV44TFConveHsPDiaDesde_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV46TFConveHsPDiaDesde_Sels.fromJSonString(AV44TFConveHsPDiaDesde_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVETARIFAPDIA") == 0 )
         {
            AV48TFConveTarifaPDia = CommonUtil.decimalVal( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV49TFConveTarifaPDia_To = CommonUtil.decimalVal( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVETARIFAPDREC") == 0 )
         {
            AV50TFConveTarifaPDRec = CommonUtil.decimalVal( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV51TFConveTarifaPDRec_To = CommonUtil.decimalVal( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVETARIFAPDCRI_SEL") == 0 )
         {
            AV55TFConveTarifaPDCri_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV56TFConveTarifaPDCri_Sels.fromJSonString(AV55TFConveTarifaPDCri_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV17MenuOpcCod = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&CLICONVENIO") == 0 )
         {
            AV18CliConvenio = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV77GXV7 = (int)(AV77GXV7+1) ;
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
      this.aP0[0] = esquemahorasespecialeswwexport.this.AV12Filename;
      this.aP1[0] = esquemahorasespecialeswwexport.this.AV13ErrorMessage;
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
      AV60Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV39TFConvHsPDiaTipTra_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV40TFConvHsPDiaTipTra_Sel = "" ;
      AV42TFConveHsPDiaDia_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV46TFConveHsPDiaDesde_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV47TFConveHsPDiaDesde_Sel = "" ;
      AV45TFConveHsPDiaDesde = "" ;
      AV48TFConveTarifaPDia = DecimalUtil.ZERO ;
      AV49TFConveTarifaPDia_To = DecimalUtil.ZERO ;
      AV50TFConveTarifaPDRec = DecimalUtil.ZERO ;
      AV51TFConveTarifaPDRec_To = DecimalUtil.ZERO ;
      AV56TFConveTarifaPDCri_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV57TFConveTarifaPDCri_Sel = "" ;
      AV21Session = httpContext.getWebSession();
      AV28ColumnsSelectorXML = "" ;
      AV25ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV27ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A1326ConvHsPDiaTipTra = "" ;
      A1329ConveHsPDiaDesde = "" ;
      A1330ConveTarifaPDia = DecimalUtil.ZERO ;
      A1350ConveTarifaPDRec = DecimalUtil.ZERO ;
      A2432ConveTarifaPDCri = "" ;
      AV67Esquemahorasespecialeswwds_1_tfconvhspdiatiptra_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV68Esquemahorasespecialeswwds_2_tfconvehspdiadia_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV69Esquemahorasespecialeswwds_3_tfconvehspdiadesde = "" ;
      AV70Esquemahorasespecialeswwds_4_tfconvehspdiadesde_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV71Esquemahorasespecialeswwds_5_tfconvetarifapdia = DecimalUtil.ZERO ;
      AV72Esquemahorasespecialeswwds_6_tfconvetarifapdia_to = DecimalUtil.ZERO ;
      AV73Esquemahorasespecialeswwds_7_tfconvetarifapdrec = DecimalUtil.ZERO ;
      AV74Esquemahorasespecialeswwds_8_tfconvetarifapdrec_to = DecimalUtil.ZERO ;
      AV75Esquemahorasespecialeswwds_9_tfconvetarifapdcri_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV69Esquemahorasespecialeswwds_3_tfconvehspdiadesde = "" ;
      A1565CliConvenio = "" ;
      AV18CliConvenio = "" ;
      P02M42_A1565CliConvenio = new String[] {""} ;
      P02M42_A3CliCod = new int[1] ;
      P02M42_A2432ConveTarifaPDCri = new String[] {""} ;
      P02M42_A1350ConveTarifaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02M42_A1330ConveTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02M42_A1329ConveHsPDiaDesde = new String[] {""} ;
      P02M42_n1329ConveHsPDiaDesde = new boolean[] {false} ;
      P02M42_A1328ConveHsPDiaDia = new byte[1] ;
      P02M42_A1326ConvHsPDiaTipTra = new String[] {""} ;
      P02M42_A1564CliPaiConve = new short[1] ;
      P02M42_A1327ConveHsExSec = new short[1] ;
      AV29UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV26ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV23GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV24GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV38TFConvHsPDiaTipTra_SelsJson = "" ;
      AV41TFConveHsPDiaDia_SelsJson = "" ;
      AV44TFConveHsPDiaDesde_SelsJson = "" ;
      AV55TFConveTarifaPDCri_SelsJson = "" ;
      AV17MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.esquemahorasespecialeswwexport__default(),
         new Object[] {
             new Object[] {
            P02M42_A1565CliConvenio, P02M42_A3CliCod, P02M42_A2432ConveTarifaPDCri, P02M42_A1350ConveTarifaPDRec, P02M42_A1330ConveTarifaPDia, P02M42_A1329ConveHsPDiaDesde, P02M42_n1329ConveHsPDiaDesde, P02M42_A1328ConveHsPDiaDia, P02M42_A1326ConvHsPDiaTipTra, P02M42_A1564CliPaiConve,
            P02M42_A1327ConveHsExSec
            }
         }
      );
      AV60Pgmname = "EsquemaHorasEspecialesWWExport" ;
      /* GeneXus formulas. */
      AV60Pgmname = "EsquemaHorasEspecialesWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV43TFConveHsPDiaDia_Sel ;
   private byte A1328ConveHsPDiaDia ;
   private short GXv_int5[] ;
   private short AV19OrderedBy ;
   private short A1564CliPaiConve ;
   private short A1327ConveHsExSec ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV61GXV1 ;
   private int AV62GXV2 ;
   private int AV63GXV3 ;
   private int AV64GXV4 ;
   private int AV65GXV5 ;
   private int AV67Esquemahorasespecialeswwds_1_tfconvhspdiatiptra_sels_size ;
   private int AV68Esquemahorasespecialeswwds_2_tfconvehspdiadia_sels_size ;
   private int AV70Esquemahorasespecialeswwds_4_tfconvehspdiadesde_sels_size ;
   private int AV75Esquemahorasespecialeswwds_9_tfconvetarifapdcri_sels_size ;
   private int AV53CliCod ;
   private int A3CliCod ;
   private int AV76GXV6 ;
   private int AV77GXV7 ;
   private long AV52i ;
   private long AV33VisibleColumnCount ;
   private java.math.BigDecimal AV48TFConveTarifaPDia ;
   private java.math.BigDecimal AV49TFConveTarifaPDia_To ;
   private java.math.BigDecimal AV50TFConveTarifaPDRec ;
   private java.math.BigDecimal AV51TFConveTarifaPDRec_To ;
   private java.math.BigDecimal A1330ConveTarifaPDia ;
   private java.math.BigDecimal A1350ConveTarifaPDRec ;
   private java.math.BigDecimal AV71Esquemahorasespecialeswwds_5_tfconvetarifapdia ;
   private java.math.BigDecimal AV72Esquemahorasespecialeswwds_6_tfconvetarifapdia_to ;
   private java.math.BigDecimal AV73Esquemahorasespecialeswwds_7_tfconvetarifapdrec ;
   private java.math.BigDecimal AV74Esquemahorasespecialeswwds_8_tfconvetarifapdrec_to ;
   private String AV60Pgmname ;
   private String AV40TFConvHsPDiaTipTra_Sel ;
   private String AV47TFConveHsPDiaDesde_Sel ;
   private String AV45TFConveHsPDiaDesde ;
   private String AV57TFConveTarifaPDCri_Sel ;
   private String A1326ConvHsPDiaTipTra ;
   private String A1329ConveHsPDiaDesde ;
   private String A2432ConveTarifaPDCri ;
   private String AV69Esquemahorasespecialeswwds_3_tfconvehspdiadesde ;
   private String scmdbuf ;
   private String lV69Esquemahorasespecialeswwds_3_tfconvehspdiadesde ;
   private String A1565CliConvenio ;
   private String AV18CliConvenio ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV20OrderedDsc ;
   private boolean n1329ConveHsPDiaDesde ;
   private String AV28ColumnsSelectorXML ;
   private String AV29UserCustomValue ;
   private String AV38TFConvHsPDiaTipTra_SelsJson ;
   private String AV41TFConveHsPDiaDia_SelsJson ;
   private String AV44TFConveHsPDiaDesde_SelsJson ;
   private String AV55TFConveTarifaPDCri_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV17MenuOpcCod ;
   private GXSimpleCollection<Byte> AV42TFConveHsPDiaDia_Sels ;
   private GXSimpleCollection<Byte> AV68Esquemahorasespecialeswwds_2_tfconvehspdiadia_sels ;
   private com.genexus.webpanels.WebSession AV21Session ;
   private GXSimpleCollection<String> AV39TFConvHsPDiaTipTra_Sels ;
   private GXSimpleCollection<String> AV46TFConveHsPDiaDesde_Sels ;
   private GXSimpleCollection<String> AV56TFConveTarifaPDCri_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] P02M42_A1565CliConvenio ;
   private int[] P02M42_A3CliCod ;
   private String[] P02M42_A2432ConveTarifaPDCri ;
   private java.math.BigDecimal[] P02M42_A1350ConveTarifaPDRec ;
   private java.math.BigDecimal[] P02M42_A1330ConveTarifaPDia ;
   private String[] P02M42_A1329ConveHsPDiaDesde ;
   private boolean[] P02M42_n1329ConveHsPDiaDesde ;
   private byte[] P02M42_A1328ConveHsPDiaDia ;
   private String[] P02M42_A1326ConvHsPDiaTipTra ;
   private short[] P02M42_A1564CliPaiConve ;
   private short[] P02M42_A1327ConveHsExSec ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV67Esquemahorasespecialeswwds_1_tfconvhspdiatiptra_sels ;
   private GXSimpleCollection<String> AV70Esquemahorasespecialeswwds_4_tfconvehspdiadesde_sels ;
   private GXSimpleCollection<String> AV75Esquemahorasespecialeswwds_9_tfconvetarifapdcri_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV23GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV24GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV25ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV26ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV27ColumnsSelector_Column ;
}

final  class esquemahorasespecialeswwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02M42( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1326ConvHsPDiaTipTra ,
                                          GXSimpleCollection<String> AV67Esquemahorasespecialeswwds_1_tfconvhspdiatiptra_sels ,
                                          byte A1328ConveHsPDiaDia ,
                                          GXSimpleCollection<Byte> AV68Esquemahorasespecialeswwds_2_tfconvehspdiadia_sels ,
                                          String A1329ConveHsPDiaDesde ,
                                          GXSimpleCollection<String> AV70Esquemahorasespecialeswwds_4_tfconvehspdiadesde_sels ,
                                          String A2432ConveTarifaPDCri ,
                                          GXSimpleCollection<String> AV75Esquemahorasespecialeswwds_9_tfconvetarifapdcri_sels ,
                                          int AV67Esquemahorasespecialeswwds_1_tfconvhspdiatiptra_sels_size ,
                                          int AV68Esquemahorasespecialeswwds_2_tfconvehspdiadia_sels_size ,
                                          int AV70Esquemahorasespecialeswwds_4_tfconvehspdiadesde_sels_size ,
                                          String AV69Esquemahorasespecialeswwds_3_tfconvehspdiadesde ,
                                          java.math.BigDecimal AV71Esquemahorasespecialeswwds_5_tfconvetarifapdia ,
                                          java.math.BigDecimal AV72Esquemahorasespecialeswwds_6_tfconvetarifapdia_to ,
                                          java.math.BigDecimal AV73Esquemahorasespecialeswwds_7_tfconvetarifapdrec ,
                                          java.math.BigDecimal AV74Esquemahorasespecialeswwds_8_tfconvetarifapdrec_to ,
                                          int AV75Esquemahorasespecialeswwds_9_tfconvetarifapdcri_sels_size ,
                                          java.math.BigDecimal A1330ConveTarifaPDia ,
                                          java.math.BigDecimal A1350ConveTarifaPDRec ,
                                          short AV19OrderedBy ,
                                          boolean AV20OrderedDsc ,
                                          String A1565CliConvenio ,
                                          String AV18CliConvenio ,
                                          int AV53CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[7];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT CliConvenio, CliCod, ConveTarifaPDCri, ConveTarifaPDRec, ConveTarifaPDia, ConveHsPDiaDesde, ConveHsPDiaDia, ConvHsPDiaTipTra, CliPaiConve, ConveHsExSec FROM" ;
      scmdbuf += " Convenio_horasextras_porDia" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(CliConvenio = ( ?))");
      if ( AV67Esquemahorasespecialeswwds_1_tfconvhspdiatiptra_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV67Esquemahorasespecialeswwds_1_tfconvhspdiatiptra_sels, "ConvHsPDiaTipTra IN (", ")")+")");
      }
      if ( AV68Esquemahorasespecialeswwds_2_tfconvehspdiadia_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV68Esquemahorasespecialeswwds_2_tfconvehspdiadia_sels, "ConveHsPDiaDia IN (", ")")+")");
      }
      if ( ( AV70Esquemahorasespecialeswwds_4_tfconvehspdiadesde_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV69Esquemahorasespecialeswwds_3_tfconvehspdiadesde)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveHsPDiaDesde) like LOWER(?))");
      }
      else
      {
         GXv_int10[2] = (byte)(1) ;
      }
      if ( AV70Esquemahorasespecialeswwds_4_tfconvehspdiadesde_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV70Esquemahorasespecialeswwds_4_tfconvehspdiadesde_sels, "ConveHsPDiaDesde IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV71Esquemahorasespecialeswwds_5_tfconvetarifapdia)==0) )
      {
         addWhere(sWhereString, "(ConveTarifaPDia >= ?)");
      }
      else
      {
         GXv_int10[3] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV72Esquemahorasespecialeswwds_6_tfconvetarifapdia_to)==0) )
      {
         addWhere(sWhereString, "(ConveTarifaPDia <= ?)");
      }
      else
      {
         GXv_int10[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV73Esquemahorasespecialeswwds_7_tfconvetarifapdrec)==0) )
      {
         addWhere(sWhereString, "(ConveTarifaPDRec >= ?)");
      }
      else
      {
         GXv_int10[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV74Esquemahorasespecialeswwds_8_tfconvetarifapdrec_to)==0) )
      {
         addWhere(sWhereString, "(ConveTarifaPDRec <= ?)");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      if ( AV75Esquemahorasespecialeswwds_9_tfconvetarifapdcri_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV75Esquemahorasespecialeswwds_9_tfconvetarifapdcri_sels, "ConveTarifaPDCri IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV19OrderedBy == 1 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY ConvHsPDiaTipTra" ;
      }
      else if ( ( AV19OrderedBy == 1 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConvHsPDiaTipTra DESC" ;
      }
      else if ( ( AV19OrderedBy == 2 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveHsPDiaDia" ;
      }
      else if ( ( AV19OrderedBy == 2 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveHsPDiaDia DESC" ;
      }
      else if ( ( AV19OrderedBy == 3 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveHsPDiaDesde" ;
      }
      else if ( ( AV19OrderedBy == 3 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveHsPDiaDesde DESC" ;
      }
      else if ( ( AV19OrderedBy == 4 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveTarifaPDia" ;
      }
      else if ( ( AV19OrderedBy == 4 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveTarifaPDia DESC" ;
      }
      else if ( ( AV19OrderedBy == 5 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveTarifaPDRec" ;
      }
      else if ( ( AV19OrderedBy == 5 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveTarifaPDRec DESC" ;
      }
      else if ( ( AV19OrderedBy == 6 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveTarifaPDCri" ;
      }
      else if ( ( AV19OrderedBy == 6 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveTarifaPDCri DESC" ;
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
                  return conditional_P02M42(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , (java.math.BigDecimal)dynConstraints[14] , (java.math.BigDecimal)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , ((Number) dynConstraints[19]).shortValue() , ((Boolean) dynConstraints[20]).booleanValue() , (String)dynConstraints[21] , (String)dynConstraints[22] , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02M42", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((String[]) buf[5])[0] = rslt.getString(6, 5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((byte[]) buf[7])[0] = rslt.getByte(7);
               ((String[]) buf[8])[0] = rslt.getString(8, 20);
               ((short[]) buf[9])[0] = rslt.getShort(9);
               ((short[]) buf[10])[0] = rslt.getShort(10);
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
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[8], 20);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[9], 5);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[10], 4);
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
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[13], 4);
               }
               return;
      }
   }

}

