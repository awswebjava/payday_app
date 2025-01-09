package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class empresa_horasextras_pordiawwexport extends GXProcedure
{
   public empresa_horasextras_pordiawwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empresa_horasextras_pordiawwexport.class ), "" );
   }

   public empresa_horasextras_pordiawwexport( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      empresa_horasextras_pordiawwexport.this.aP1 = new String[] {""};
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
      empresa_horasextras_pordiawwexport.this.aP0 = aP0;
      empresa_horasextras_pordiawwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresa_horasextras_porDia", GXv_boolean2) ;
      empresa_horasextras_pordiawwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
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
      AV12Filename = "Empresa_horasextras_porDiaWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV38TFEmpHsPDiaTipTra_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo de trabajo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresa_horasextras_pordiawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV51i = 1 ;
         AV61GXV1 = 1 ;
         while ( AV61GXV1 <= AV38TFEmpHsPDiaTipTra_Sels.size() )
         {
            AV39TFEmpHsPDiaTipTra_Sel = (String)AV38TFEmpHsPDiaTipTra_Sels.elementAt(-1+AV61GXV1) ;
            if ( AV51i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaintipo_trabajo.getDescription(httpContext,(String)AV39TFEmpHsPDiaTipTra_Sel), "") );
            AV51i = (long)(AV51i+1) ;
            AV61GXV1 = (int)(AV61GXV1+1) ;
         }
      }
      if ( ! ( ( AV41TFEmpHsPDiaDia_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Día", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresa_horasextras_pordiawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV51i = 1 ;
         AV62GXV2 = 1 ;
         while ( AV62GXV2 <= AV41TFEmpHsPDiaDia_Sels.size() )
         {
            AV42TFEmpHsPDiaDia_Sel = ((Number) AV41TFEmpHsPDiaDia_Sels.elementAt(-1+AV62GXV2)).byteValue() ;
            if ( AV51i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaindia_tra.getDescription(httpContext,(byte)AV42TFEmpHsPDiaDia_Sel), "") );
            AV51i = (long)(AV51i+1) ;
            AV62GXV2 = (int)(AV62GXV2+1) ;
         }
      }
      if ( ! ( ( AV45TFEmpHsPDiaDesde_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Hora desde", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresa_horasextras_pordiawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV51i = 1 ;
         AV63GXV3 = 1 ;
         while ( AV63GXV3 <= AV45TFEmpHsPDiaDesde_Sels.size() )
         {
            AV46TFEmpHsPDiaDesde_Sel = (String)AV45TFEmpHsPDiaDesde_Sels.elementAt(-1+AV63GXV3) ;
            if ( AV51i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV46TFEmpHsPDiaDesde_Sel, GXv_char7) ;
            empresa_horasextras_pordiawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV51i = (long)(AV51i+1) ;
            AV63GXV3 = (int)(AV63GXV3+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV44TFEmpHsPDiaDesde)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Hora desde", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            empresa_horasextras_pordiawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV44TFEmpHsPDiaDesde, GXv_char7) ;
            empresa_horasextras_pordiawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV47TFEmpTarifaPDia)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV48TFEmpTarifaPDia_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Aumento de horas extras sobre hora normal", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresa_horasextras_pordiawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV47TFEmpTarifaPDia)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresa_horasextras_pordiawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV48TFEmpTarifaPDia_To)) );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV49TFEmpTarfaPDRec)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV50TFEmpTarfaPDRec_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Recargo a hora normal diurna", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresa_horasextras_pordiawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV49TFEmpTarfaPDRec)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresa_horasextras_pordiawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV50TFEmpTarfaPDRec_To)) );
      }
      if ( ! ( ( AV56TFEmpTarifaPDCri_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Criterio", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresa_horasextras_pordiawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV51i = 1 ;
         AV64GXV4 = 1 ;
         while ( AV64GXV4 <= AV56TFEmpTarifaPDCri_Sels.size() )
         {
            AV57TFEmpTarifaPDCri_Sel = (String)AV56TFEmpTarifaPDCri_Sels.elementAt(-1+AV64GXV4) ;
            if ( AV51i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaincriterio_horaextra.getDescription(httpContext,(String)AV57TFEmpTarifaPDCri_Sel), "") );
            AV51i = (long)(AV51i+1) ;
            AV64GXV4 = (int)(AV64GXV4+1) ;
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("Empresa_horasextras_porDiaWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("Empresa_horasextras_porDiaWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV65GXV5 = 1 ;
      while ( AV65GXV5 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV65GXV5));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV65GXV5 = (int)(AV65GXV5+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV67Empresa_horasextras_pordiawwds_1_tfemphspdiatiptra_sels = AV38TFEmpHsPDiaTipTra_Sels ;
      AV68Empresa_horasextras_pordiawwds_2_tfemphspdiadia_sels = AV41TFEmpHsPDiaDia_Sels ;
      AV69Empresa_horasextras_pordiawwds_3_tfemphspdiadesde = AV44TFEmpHsPDiaDesde ;
      AV70Empresa_horasextras_pordiawwds_4_tfemphspdiadesde_sels = AV45TFEmpHsPDiaDesde_Sels ;
      AV71Empresa_horasextras_pordiawwds_5_tfemptarifapdia = AV47TFEmpTarifaPDia ;
      AV72Empresa_horasextras_pordiawwds_6_tfemptarifapdia_to = AV48TFEmpTarifaPDia_To ;
      AV73Empresa_horasextras_pordiawwds_7_tfemptarfapdrec = AV49TFEmpTarfaPDRec ;
      AV74Empresa_horasextras_pordiawwds_8_tfemptarfapdrec_to = AV50TFEmpTarfaPDRec_To ;
      AV75Empresa_horasextras_pordiawwds_9_tfemptarifapdcri_sels = AV56TFEmpTarifaPDCri_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1339EmpHsPDiaTipTra ,
                                           AV67Empresa_horasextras_pordiawwds_1_tfemphspdiatiptra_sels ,
                                           Byte.valueOf(A1341EmpHsPDiaDia) ,
                                           AV68Empresa_horasextras_pordiawwds_2_tfemphspdiadia_sels ,
                                           A1342EmpHsPDiaDesde ,
                                           AV70Empresa_horasextras_pordiawwds_4_tfemphspdiadesde_sels ,
                                           A2433EmpTarifaPDCri ,
                                           AV75Empresa_horasextras_pordiawwds_9_tfemptarifapdcri_sels ,
                                           Integer.valueOf(AV67Empresa_horasextras_pordiawwds_1_tfemphspdiatiptra_sels.size()) ,
                                           Integer.valueOf(AV68Empresa_horasextras_pordiawwds_2_tfemphspdiadia_sels.size()) ,
                                           Integer.valueOf(AV70Empresa_horasextras_pordiawwds_4_tfemphspdiadesde_sels.size()) ,
                                           AV69Empresa_horasextras_pordiawwds_3_tfemphspdiadesde ,
                                           AV71Empresa_horasextras_pordiawwds_5_tfemptarifapdia ,
                                           AV72Empresa_horasextras_pordiawwds_6_tfemptarifapdia_to ,
                                           AV73Empresa_horasextras_pordiawwds_7_tfemptarfapdrec ,
                                           AV74Empresa_horasextras_pordiawwds_8_tfemptarfapdrec_to ,
                                           Integer.valueOf(AV75Empresa_horasextras_pordiawwds_9_tfemptarifapdcri_sels.size()) ,
                                           A1343EmpTarifaPDia ,
                                           A1351EmpTarfaPDRec ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Integer.valueOf(AV52CliCod) ,
                                           Short.valueOf(AV53EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV69Empresa_horasextras_pordiawwds_3_tfemphspdiadesde = GXutil.padr( GXutil.rtrim( AV69Empresa_horasextras_pordiawwds_3_tfemphspdiadesde), 5, "%") ;
      /* Using cursor P01SP2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV52CliCod), Short.valueOf(AV53EmpCod), lV69Empresa_horasextras_pordiawwds_3_tfemphspdiadesde, AV71Empresa_horasextras_pordiawwds_5_tfemptarifapdia, AV72Empresa_horasextras_pordiawwds_6_tfemptarifapdia_to, AV73Empresa_horasextras_pordiawwds_7_tfemptarfapdrec, AV74Empresa_horasextras_pordiawwds_8_tfemptarfapdrec_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1EmpCod = P01SP2_A1EmpCod[0] ;
         A3CliCod = P01SP2_A3CliCod[0] ;
         A2433EmpTarifaPDCri = P01SP2_A2433EmpTarifaPDCri[0] ;
         A1351EmpTarfaPDRec = P01SP2_A1351EmpTarfaPDRec[0] ;
         A1343EmpTarifaPDia = P01SP2_A1343EmpTarifaPDia[0] ;
         A1342EmpHsPDiaDesde = P01SP2_A1342EmpHsPDiaDesde[0] ;
         n1342EmpHsPDiaDesde = P01SP2_n1342EmpHsPDiaDesde[0] ;
         A1341EmpHsPDiaDia = P01SP2_A1341EmpHsPDiaDia[0] ;
         A1339EmpHsPDiaTipTra = P01SP2_A1339EmpHsPDiaTipTra[0] ;
         A1340EmpHsExSec = P01SP2_A1340EmpHsExSec[0] ;
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
         AV76GXV6 = 1 ;
         while ( AV76GXV6 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV76GXV6));
            if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmpHsPDiaTipTra") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaintipo_trabajo.getDescription(httpContext,(String)A1339EmpHsPDiaTipTra), "") );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmpHsPDiaDia") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaindia_tra.getDescription(httpContext,(byte)A1341EmpHsPDiaDia), "") );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmpHsPDiaDesde") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1342EmpHsPDiaDesde, GXv_char7) ;
                  empresa_horasextras_pordiawwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmpTarifaPDia") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1343EmpTarifaPDia)) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmpTarfaPDRec") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1351EmpTarfaPDRec)) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmpTarifaPDCri") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaincriterio_horaextra.getDescription(httpContext,(String)A2433EmpTarifaPDCri), "") );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
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
      AV24ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EmpHsPDiaTipTra", "", "Tipo de trabajo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EmpHsPDiaDia", "", "Día", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&Default", "", "Default", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EmpHsPDiaDesde", "", "Hora desde", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EmpTarifaPDia", "", "Aumento de horas extras sobre hora normal", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EmpTarfaPDRec", "", "Recargo a hora normal diurna", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EmpTarifaPDCri", "", "Criterio", true, "") ;
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
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "Empresa_horasextras_porDiaWWColumnsSelector", GXv_char7) ;
      empresa_horasextras_pordiawwexport.this.GXt_char6 = GXv_char7[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("Empresa_horasextras_porDiaWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "Empresa_horasextras_porDiaWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("Empresa_horasextras_porDiaWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV77GXV7 = 1 ;
      while ( AV77GXV7 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV77GXV7));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPHSPDIATIPTRA_SEL") == 0 )
         {
            AV37TFEmpHsPDiaTipTra_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV38TFEmpHsPDiaTipTra_Sels.fromJSonString(AV37TFEmpHsPDiaTipTra_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPHSPDIADIA_SEL") == 0 )
         {
            AV40TFEmpHsPDiaDia_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV41TFEmpHsPDiaDia_Sels.fromJSonString(AV40TFEmpHsPDiaDia_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPHSPDIADESDE") == 0 )
         {
            AV44TFEmpHsPDiaDesde = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPHSPDIADESDE_SEL") == 0 )
         {
            AV43TFEmpHsPDiaDesde_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV45TFEmpHsPDiaDesde_Sels.fromJSonString(AV43TFEmpHsPDiaDesde_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPTARIFAPDIA") == 0 )
         {
            AV47TFEmpTarifaPDia = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV48TFEmpTarifaPDia_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPTARFAPDREC") == 0 )
         {
            AV49TFEmpTarfaPDRec = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV50TFEmpTarfaPDRec_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPTARIFAPDCRI_SEL") == 0 )
         {
            AV55TFEmpTarifaPDCri_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV56TFEmpTarifaPDCri_Sels.fromJSonString(AV55TFEmpTarifaPDCri_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV54MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
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
      this.aP0[0] = empresa_horasextras_pordiawwexport.this.AV12Filename;
      this.aP1[0] = empresa_horasextras_pordiawwexport.this.AV13ErrorMessage;
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
      AV38TFEmpHsPDiaTipTra_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV39TFEmpHsPDiaTipTra_Sel = "" ;
      AV41TFEmpHsPDiaDia_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV45TFEmpHsPDiaDesde_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV46TFEmpHsPDiaDesde_Sel = "" ;
      AV44TFEmpHsPDiaDesde = "" ;
      AV47TFEmpTarifaPDia = DecimalUtil.ZERO ;
      AV48TFEmpTarifaPDia_To = DecimalUtil.ZERO ;
      AV49TFEmpTarfaPDRec = DecimalUtil.ZERO ;
      AV50TFEmpTarfaPDRec_To = DecimalUtil.ZERO ;
      AV56TFEmpTarifaPDCri_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV57TFEmpTarifaPDCri_Sel = "" ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A1339EmpHsPDiaTipTra = "" ;
      A1342EmpHsPDiaDesde = "" ;
      A1343EmpTarifaPDia = DecimalUtil.ZERO ;
      A1351EmpTarfaPDRec = DecimalUtil.ZERO ;
      A2433EmpTarifaPDCri = "" ;
      AV67Empresa_horasextras_pordiawwds_1_tfemphspdiatiptra_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV68Empresa_horasextras_pordiawwds_2_tfemphspdiadia_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV69Empresa_horasextras_pordiawwds_3_tfemphspdiadesde = "" ;
      AV70Empresa_horasextras_pordiawwds_4_tfemphspdiadesde_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV71Empresa_horasextras_pordiawwds_5_tfemptarifapdia = DecimalUtil.ZERO ;
      AV72Empresa_horasextras_pordiawwds_6_tfemptarifapdia_to = DecimalUtil.ZERO ;
      AV73Empresa_horasextras_pordiawwds_7_tfemptarfapdrec = DecimalUtil.ZERO ;
      AV74Empresa_horasextras_pordiawwds_8_tfemptarfapdrec_to = DecimalUtil.ZERO ;
      AV75Empresa_horasextras_pordiawwds_9_tfemptarifapdcri_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV69Empresa_horasextras_pordiawwds_3_tfemphspdiadesde = "" ;
      P01SP2_A1EmpCod = new short[1] ;
      P01SP2_A3CliCod = new int[1] ;
      P01SP2_A2433EmpTarifaPDCri = new String[] {""} ;
      P01SP2_A1351EmpTarfaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01SP2_A1343EmpTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01SP2_A1342EmpHsPDiaDesde = new String[] {""} ;
      P01SP2_n1342EmpHsPDiaDesde = new boolean[] {false} ;
      P01SP2_A1341EmpHsPDiaDia = new byte[1] ;
      P01SP2_A1339EmpHsPDiaTipTra = new String[] {""} ;
      P01SP2_A1340EmpHsExSec = new short[1] ;
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV37TFEmpHsPDiaTipTra_SelsJson = "" ;
      AV40TFEmpHsPDiaDia_SelsJson = "" ;
      AV43TFEmpHsPDiaDesde_SelsJson = "" ;
      AV55TFEmpTarifaPDCri_SelsJson = "" ;
      AV54MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empresa_horasextras_pordiawwexport__default(),
         new Object[] {
             new Object[] {
            P01SP2_A1EmpCod, P01SP2_A3CliCod, P01SP2_A2433EmpTarifaPDCri, P01SP2_A1351EmpTarfaPDRec, P01SP2_A1343EmpTarifaPDia, P01SP2_A1342EmpHsPDiaDesde, P01SP2_n1342EmpHsPDiaDesde, P01SP2_A1341EmpHsPDiaDia, P01SP2_A1339EmpHsPDiaTipTra, P01SP2_A1340EmpHsExSec
            }
         }
      );
      AV60Pgmname = "Empresa_horasextras_porDiaWWExport" ;
      /* GeneXus formulas. */
      AV60Pgmname = "Empresa_horasextras_porDiaWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV42TFEmpHsPDiaDia_Sel ;
   private byte A1341EmpHsPDiaDia ;
   private short GXv_int5[] ;
   private short AV18OrderedBy ;
   private short AV53EmpCod ;
   private short A1EmpCod ;
   private short A1340EmpHsExSec ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV61GXV1 ;
   private int AV62GXV2 ;
   private int AV63GXV3 ;
   private int AV64GXV4 ;
   private int AV65GXV5 ;
   private int AV67Empresa_horasextras_pordiawwds_1_tfemphspdiatiptra_sels_size ;
   private int AV68Empresa_horasextras_pordiawwds_2_tfemphspdiadia_sels_size ;
   private int AV70Empresa_horasextras_pordiawwds_4_tfemphspdiadesde_sels_size ;
   private int AV75Empresa_horasextras_pordiawwds_9_tfemptarifapdcri_sels_size ;
   private int AV52CliCod ;
   private int A3CliCod ;
   private int AV76GXV6 ;
   private int AV77GXV7 ;
   private long AV51i ;
   private long AV32VisibleColumnCount ;
   private java.math.BigDecimal AV47TFEmpTarifaPDia ;
   private java.math.BigDecimal AV48TFEmpTarifaPDia_To ;
   private java.math.BigDecimal AV49TFEmpTarfaPDRec ;
   private java.math.BigDecimal AV50TFEmpTarfaPDRec_To ;
   private java.math.BigDecimal A1343EmpTarifaPDia ;
   private java.math.BigDecimal A1351EmpTarfaPDRec ;
   private java.math.BigDecimal AV71Empresa_horasextras_pordiawwds_5_tfemptarifapdia ;
   private java.math.BigDecimal AV72Empresa_horasextras_pordiawwds_6_tfemptarifapdia_to ;
   private java.math.BigDecimal AV73Empresa_horasextras_pordiawwds_7_tfemptarfapdrec ;
   private java.math.BigDecimal AV74Empresa_horasextras_pordiawwds_8_tfemptarfapdrec_to ;
   private String AV60Pgmname ;
   private String AV39TFEmpHsPDiaTipTra_Sel ;
   private String AV46TFEmpHsPDiaDesde_Sel ;
   private String AV44TFEmpHsPDiaDesde ;
   private String AV57TFEmpTarifaPDCri_Sel ;
   private String A1339EmpHsPDiaTipTra ;
   private String A1342EmpHsPDiaDesde ;
   private String A2433EmpTarifaPDCri ;
   private String AV69Empresa_horasextras_pordiawwds_3_tfemphspdiadesde ;
   private String scmdbuf ;
   private String lV69Empresa_horasextras_pordiawwds_3_tfemphspdiadesde ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV19OrderedDsc ;
   private boolean n1342EmpHsPDiaDesde ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV37TFEmpHsPDiaTipTra_SelsJson ;
   private String AV40TFEmpHsPDiaDia_SelsJson ;
   private String AV43TFEmpHsPDiaDesde_SelsJson ;
   private String AV55TFEmpTarifaPDCri_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV54MenuOpcCod ;
   private GXSimpleCollection<Byte> AV41TFEmpHsPDiaDia_Sels ;
   private GXSimpleCollection<Byte> AV68Empresa_horasextras_pordiawwds_2_tfemphspdiadia_sels ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV38TFEmpHsPDiaTipTra_Sels ;
   private GXSimpleCollection<String> AV45TFEmpHsPDiaDesde_Sels ;
   private GXSimpleCollection<String> AV56TFEmpTarifaPDCri_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private short[] P01SP2_A1EmpCod ;
   private int[] P01SP2_A3CliCod ;
   private String[] P01SP2_A2433EmpTarifaPDCri ;
   private java.math.BigDecimal[] P01SP2_A1351EmpTarfaPDRec ;
   private java.math.BigDecimal[] P01SP2_A1343EmpTarifaPDia ;
   private String[] P01SP2_A1342EmpHsPDiaDesde ;
   private boolean[] P01SP2_n1342EmpHsPDiaDesde ;
   private byte[] P01SP2_A1341EmpHsPDiaDia ;
   private String[] P01SP2_A1339EmpHsPDiaTipTra ;
   private short[] P01SP2_A1340EmpHsExSec ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV67Empresa_horasextras_pordiawwds_1_tfemphspdiatiptra_sels ;
   private GXSimpleCollection<String> AV70Empresa_horasextras_pordiawwds_4_tfemphspdiadesde_sels ;
   private GXSimpleCollection<String> AV75Empresa_horasextras_pordiawwds_9_tfemptarifapdcri_sels ;
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

final  class empresa_horasextras_pordiawwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01SP2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1339EmpHsPDiaTipTra ,
                                          GXSimpleCollection<String> AV67Empresa_horasextras_pordiawwds_1_tfemphspdiatiptra_sels ,
                                          byte A1341EmpHsPDiaDia ,
                                          GXSimpleCollection<Byte> AV68Empresa_horasextras_pordiawwds_2_tfemphspdiadia_sels ,
                                          String A1342EmpHsPDiaDesde ,
                                          GXSimpleCollection<String> AV70Empresa_horasextras_pordiawwds_4_tfemphspdiadesde_sels ,
                                          String A2433EmpTarifaPDCri ,
                                          GXSimpleCollection<String> AV75Empresa_horasextras_pordiawwds_9_tfemptarifapdcri_sels ,
                                          int AV67Empresa_horasextras_pordiawwds_1_tfemphspdiatiptra_sels_size ,
                                          int AV68Empresa_horasextras_pordiawwds_2_tfemphspdiadia_sels_size ,
                                          int AV70Empresa_horasextras_pordiawwds_4_tfemphspdiadesde_sels_size ,
                                          String AV69Empresa_horasextras_pordiawwds_3_tfemphspdiadesde ,
                                          java.math.BigDecimal AV71Empresa_horasextras_pordiawwds_5_tfemptarifapdia ,
                                          java.math.BigDecimal AV72Empresa_horasextras_pordiawwds_6_tfemptarifapdia_to ,
                                          java.math.BigDecimal AV73Empresa_horasextras_pordiawwds_7_tfemptarfapdrec ,
                                          java.math.BigDecimal AV74Empresa_horasextras_pordiawwds_8_tfemptarfapdrec_to ,
                                          int AV75Empresa_horasextras_pordiawwds_9_tfemptarifapdcri_sels_size ,
                                          java.math.BigDecimal A1343EmpTarifaPDia ,
                                          java.math.BigDecimal A1351EmpTarfaPDRec ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          int AV52CliCod ,
                                          short AV53EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[7];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT EmpCod, CliCod, EmpTarifaPDCri, EmpTarfaPDRec, EmpTarifaPDia, EmpHsPDiaDesde, EmpHsPDiaDia, EmpHsPDiaTipTra, EmpHsExSec FROM Empresahorasextras_pordia" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      if ( AV67Empresa_horasextras_pordiawwds_1_tfemphspdiatiptra_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV67Empresa_horasextras_pordiawwds_1_tfemphspdiatiptra_sels, "EmpHsPDiaTipTra IN (", ")")+")");
      }
      if ( AV68Empresa_horasextras_pordiawwds_2_tfemphspdiadia_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV68Empresa_horasextras_pordiawwds_2_tfemphspdiadia_sels, "EmpHsPDiaDia IN (", ")")+")");
      }
      if ( ( AV70Empresa_horasextras_pordiawwds_4_tfemphspdiadesde_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV69Empresa_horasextras_pordiawwds_3_tfemphspdiadesde)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(EmpHsPDiaDesde) like LOWER(?))");
      }
      else
      {
         GXv_int10[2] = (byte)(1) ;
      }
      if ( AV70Empresa_horasextras_pordiawwds_4_tfemphspdiadesde_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV70Empresa_horasextras_pordiawwds_4_tfemphspdiadesde_sels, "EmpHsPDiaDesde IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV71Empresa_horasextras_pordiawwds_5_tfemptarifapdia)==0) )
      {
         addWhere(sWhereString, "(EmpTarifaPDia >= ?)");
      }
      else
      {
         GXv_int10[3] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV72Empresa_horasextras_pordiawwds_6_tfemptarifapdia_to)==0) )
      {
         addWhere(sWhereString, "(EmpTarifaPDia <= ?)");
      }
      else
      {
         GXv_int10[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV73Empresa_horasextras_pordiawwds_7_tfemptarfapdrec)==0) )
      {
         addWhere(sWhereString, "(EmpTarfaPDRec >= ?)");
      }
      else
      {
         GXv_int10[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV74Empresa_horasextras_pordiawwds_8_tfemptarfapdrec_to)==0) )
      {
         addWhere(sWhereString, "(EmpTarfaPDRec <= ?)");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      if ( AV75Empresa_horasextras_pordiawwds_9_tfemptarifapdcri_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV75Empresa_horasextras_pordiawwds_9_tfemptarifapdcri_sels, "EmpTarifaPDCri IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY EmpHsPDiaTipTra" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EmpHsPDiaTipTra DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY EmpHsPDiaDia" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EmpHsPDiaDia DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY EmpHsPDiaDesde" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EmpHsPDiaDesde DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY EmpTarifaPDia" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EmpTarifaPDia DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY EmpTarfaPDRec" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EmpTarfaPDRec DESC" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY EmpTarifaPDCri" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EmpTarifaPDCri DESC" ;
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
                  return conditional_P01SP2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , (java.math.BigDecimal)dynConstraints[14] , (java.math.BigDecimal)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , ((Number) dynConstraints[19]).shortValue() , ((Boolean) dynConstraints[20]).booleanValue() , ((Number) dynConstraints[21]).intValue() , ((Number) dynConstraints[22]).shortValue() , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01SP2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((String[]) buf[5])[0] = rslt.getString(6, 5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((byte[]) buf[7])[0] = rslt.getByte(7);
               ((String[]) buf[8])[0] = rslt.getString(8, 20);
               ((short[]) buf[9])[0] = rslt.getShort(9);
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
                  stmt.setShort(sIdx, ((Number) parms[8]).shortValue());
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

