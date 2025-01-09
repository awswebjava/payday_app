package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class empresa_tiposdetrabajowwexport extends GXProcedure
{
   public empresa_tiposdetrabajowwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empresa_tiposdetrabajowwexport.class ), "" );
   }

   public empresa_tiposdetrabajowwexport( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      empresa_tiposdetrabajowwexport.this.aP1 = new String[] {""};
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
      empresa_tiposdetrabajowwexport.this.aP0 = aP0;
      empresa_tiposdetrabajowwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWempresa_tiposdetrabajo", GXv_boolean2) ;
      empresa_tiposdetrabajowwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
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
      AV12Filename = "empresa_tiposdetrabajoWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV36TFPaiTipoTraId_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo de Trabajo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresa_tiposdetrabajowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV54i = 1 ;
         AV61GXV1 = 1 ;
         while ( AV61GXV1 <= AV36TFPaiTipoTraId_Sels.size() )
         {
            AV37TFPaiTipoTraId_Sel = (String)AV36TFPaiTipoTraId_Sels.elementAt(-1+AV61GXV1) ;
            if ( AV54i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaintipo_trabajo.getDescription(httpContext,(String)AV37TFPaiTipoTraId_Sel), "") );
            AV54i = (long)(AV54i+1) ;
            AV61GXV1 = (int)(AV61GXV1+1) ;
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV38TFEmpHsDia)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV39TFEmpHsDia_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Límite de horas normales por día", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresa_tiposdetrabajowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV38TFEmpHsDia)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresa_tiposdetrabajowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV39TFEmpHsDia_To)) );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV40TFEmpHsSem)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV41TFEmpHsSem_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Límite de horas normales por semana", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresa_tiposdetrabajowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV40TFEmpHsSem)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresa_tiposdetrabajowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV41TFEmpHsSem_To)) );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV46TFEmpHsMaxDia)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV47TFEmpHsMaxDia_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Máximo de horas extras por día", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresa_tiposdetrabajowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV46TFEmpHsMaxDia)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresa_tiposdetrabajowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV47TFEmpHsMaxDia_To)) );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV48TFEmpHsMaxSem)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV49TFEmpHsMaxSem_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Máximo de horas extras por semana", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresa_tiposdetrabajowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV48TFEmpHsMaxSem)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresa_tiposdetrabajowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV49TFEmpHsMaxSem_To)) );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV50TFEmpHsMaxMes)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV51TFEmpHsMaxMes_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Máximo de horas extras por mes", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresa_tiposdetrabajowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV50TFEmpHsMaxMes)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresa_tiposdetrabajowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV51TFEmpHsMaxMes_To)) );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV52TFEmpHsMaxAnu)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV53TFEmpHsMaxAnu_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Máximo de horas extras por año", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresa_tiposdetrabajowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV52TFEmpHsMaxAnu)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresa_tiposdetrabajowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV53TFEmpHsMaxAnu_To)) );
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("empresa_tiposdetrabajoWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("empresa_tiposdetrabajoWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV62GXV2 = 1 ;
      while ( AV62GXV2 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV62GXV2));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV62GXV2 = (int)(AV62GXV2+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV64Empresa_tiposdetrabajowwds_1_tfpaitipotraid_sels = AV36TFPaiTipoTraId_Sels ;
      AV65Empresa_tiposdetrabajowwds_2_tfemphsdia = AV38TFEmpHsDia ;
      AV66Empresa_tiposdetrabajowwds_3_tfemphsdia_to = AV39TFEmpHsDia_To ;
      AV67Empresa_tiposdetrabajowwds_4_tfemphssem = AV40TFEmpHsSem ;
      AV68Empresa_tiposdetrabajowwds_5_tfemphssem_to = AV41TFEmpHsSem_To ;
      AV69Empresa_tiposdetrabajowwds_6_tfemphsmaxdia = AV46TFEmpHsMaxDia ;
      AV70Empresa_tiposdetrabajowwds_7_tfemphsmaxdia_to = AV47TFEmpHsMaxDia_To ;
      AV71Empresa_tiposdetrabajowwds_8_tfemphsmaxsem = AV48TFEmpHsMaxSem ;
      AV72Empresa_tiposdetrabajowwds_9_tfemphsmaxsem_to = AV49TFEmpHsMaxSem_To ;
      AV73Empresa_tiposdetrabajowwds_10_tfemphsmaxmes = AV50TFEmpHsMaxMes ;
      AV74Empresa_tiposdetrabajowwds_11_tfemphsmaxmes_to = AV51TFEmpHsMaxMes_To ;
      AV75Empresa_tiposdetrabajowwds_12_tfemphsmaxanu = AV52TFEmpHsMaxAnu ;
      AV76Empresa_tiposdetrabajowwds_13_tfemphsmaxanu_to = AV53TFEmpHsMaxAnu_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1294PaiTipoTraId ,
                                           AV64Empresa_tiposdetrabajowwds_1_tfpaitipotraid_sels ,
                                           Integer.valueOf(AV64Empresa_tiposdetrabajowwds_1_tfpaitipotraid_sels.size()) ,
                                           AV65Empresa_tiposdetrabajowwds_2_tfemphsdia ,
                                           AV66Empresa_tiposdetrabajowwds_3_tfemphsdia_to ,
                                           AV67Empresa_tiposdetrabajowwds_4_tfemphssem ,
                                           AV68Empresa_tiposdetrabajowwds_5_tfemphssem_to ,
                                           AV69Empresa_tiposdetrabajowwds_6_tfemphsmaxdia ,
                                           AV70Empresa_tiposdetrabajowwds_7_tfemphsmaxdia_to ,
                                           AV71Empresa_tiposdetrabajowwds_8_tfemphsmaxsem ,
                                           AV72Empresa_tiposdetrabajowwds_9_tfemphsmaxsem_to ,
                                           AV73Empresa_tiposdetrabajowwds_10_tfemphsmaxmes ,
                                           AV74Empresa_tiposdetrabajowwds_11_tfemphsmaxmes_to ,
                                           AV75Empresa_tiposdetrabajowwds_12_tfemphsmaxanu ,
                                           AV76Empresa_tiposdetrabajowwds_13_tfemphsmaxanu_to ,
                                           A1344EmpHsDia ,
                                           A1345EmpHsSem ,
                                           A1386EmpHsMaxDia ,
                                           A1387EmpHsMaxSem ,
                                           A1388EmpHsMaxMes ,
                                           A1389EmpHsMaxAnu ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Integer.valueOf(AV55CliCod) ,
                                           Short.valueOf(AV56EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P01SN2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV55CliCod), Short.valueOf(AV56EmpCod), AV65Empresa_tiposdetrabajowwds_2_tfemphsdia, AV66Empresa_tiposdetrabajowwds_3_tfemphsdia_to, AV67Empresa_tiposdetrabajowwds_4_tfemphssem, AV68Empresa_tiposdetrabajowwds_5_tfemphssem_to, AV69Empresa_tiposdetrabajowwds_6_tfemphsmaxdia, AV70Empresa_tiposdetrabajowwds_7_tfemphsmaxdia_to, AV71Empresa_tiposdetrabajowwds_8_tfemphsmaxsem, AV72Empresa_tiposdetrabajowwds_9_tfemphsmaxsem_to, AV73Empresa_tiposdetrabajowwds_10_tfemphsmaxmes, AV74Empresa_tiposdetrabajowwds_11_tfemphsmaxmes_to, AV75Empresa_tiposdetrabajowwds_12_tfemphsmaxanu, AV76Empresa_tiposdetrabajowwds_13_tfemphsmaxanu_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1EmpCod = P01SN2_A1EmpCod[0] ;
         A3CliCod = P01SN2_A3CliCod[0] ;
         A1389EmpHsMaxAnu = P01SN2_A1389EmpHsMaxAnu[0] ;
         A1388EmpHsMaxMes = P01SN2_A1388EmpHsMaxMes[0] ;
         A1387EmpHsMaxSem = P01SN2_A1387EmpHsMaxSem[0] ;
         A1386EmpHsMaxDia = P01SN2_A1386EmpHsMaxDia[0] ;
         A1345EmpHsSem = P01SN2_A1345EmpHsSem[0] ;
         A1344EmpHsDia = P01SN2_A1344EmpHsDia[0] ;
         A1294PaiTipoTraId = P01SN2_A1294PaiTipoTraId[0] ;
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
         AV77GXV3 = 1 ;
         while ( AV77GXV3 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV77GXV3));
            if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiTipoTraId") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaintipo_trabajo.getDescription(httpContext,(String)A1294PaiTipoTraId), "") );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmpHsDia") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1344EmpHsDia)) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmpHsSem") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1345EmpHsSem)) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmpHsMaxDia") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1386EmpHsMaxDia)) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmpHsMaxSem") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1387EmpHsMaxSem)) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmpHsMaxMes") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1388EmpHsMaxMes)) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmpHsMaxAnu") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1389EmpHsMaxAnu)) );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV77GXV3 = (int)(AV77GXV3+1) ;
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
      GXv_SdtWWPColumnsSelector6[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector6, "PaiTipoTraId", "", "Tipo de Trabajo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector6[0] ;
      GXv_SdtWWPColumnsSelector6[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector6, "&Default", "", "Default", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector6[0] ;
      GXv_SdtWWPColumnsSelector6[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector6, "EmpHsDia", "", "Límite de horas normales por día", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector6[0] ;
      GXv_SdtWWPColumnsSelector6[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector6, "EmpHsSem", "", "Límite de horas normales por semana", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector6[0] ;
      GXv_SdtWWPColumnsSelector6[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector6, "EmpHsMaxDia", "", "Máximo de horas extras por día", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector6[0] ;
      GXv_SdtWWPColumnsSelector6[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector6, "EmpHsMaxSem", "", "Máximo de horas extras por semana", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector6[0] ;
      GXv_SdtWWPColumnsSelector6[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector6, "EmpHsMaxMes", "", "Máximo de horas extras por mes", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector6[0] ;
      GXv_SdtWWPColumnsSelector6[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector6, "EmpHsMaxAnu", "", "Máximo de horas extras por año", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector6[0] ;
      GXv_SdtWWPColumnsSelector6[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector6, "&VerSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector6[0] ;
      GXv_SdtWWPColumnsSelector6[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector6, "&ModificarSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector6[0] ;
      GXt_char7 = AV28UserCustomValue ;
      GXv_char8[0] = GXt_char7 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "empresa_tiposdetrabajoWWColumnsSelector", GXv_char8) ;
      empresa_tiposdetrabajowwexport.this.GXt_char7 = GXv_char8[0] ;
      AV28UserCustomValue = GXt_char7 ;
      if ( ! ( (GXutil.strcmp("", AV28UserCustomValue)==0) ) )
      {
         AV25ColumnsSelectorAux.fromxml(AV28UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector6[0] = AV25ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector6, GXv_SdtWWPColumnsSelector9) ;
         AV25ColumnsSelectorAux = GXv_SdtWWPColumnsSelector6[0] ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("empresa_tiposdetrabajoWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "empresa_tiposdetrabajoWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("empresa_tiposdetrabajoWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV78GXV4 = 1 ;
      while ( AV78GXV4 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV78GXV4));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAITIPOTRAID_SEL") == 0 )
         {
            AV35TFPaiTipoTraId_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV36TFPaiTipoTraId_Sels.fromJSonString(AV35TFPaiTipoTraId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPHSDIA") == 0 )
         {
            AV38TFEmpHsDia = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV39TFEmpHsDia_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPHSSEM") == 0 )
         {
            AV40TFEmpHsSem = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV41TFEmpHsSem_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPHSMAXDIA") == 0 )
         {
            AV46TFEmpHsMaxDia = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV47TFEmpHsMaxDia_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPHSMAXSEM") == 0 )
         {
            AV48TFEmpHsMaxSem = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV49TFEmpHsMaxSem_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPHSMAXMES") == 0 )
         {
            AV50TFEmpHsMaxMes = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV51TFEmpHsMaxMes_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPHSMAXANU") == 0 )
         {
            AV52TFEmpHsMaxAnu = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV53TFEmpHsMaxAnu_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV57MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV78GXV4 = (int)(AV78GXV4+1) ;
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
      this.aP0[0] = empresa_tiposdetrabajowwexport.this.AV12Filename;
      this.aP1[0] = empresa_tiposdetrabajowwexport.this.AV13ErrorMessage;
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
      AV36TFPaiTipoTraId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV37TFPaiTipoTraId_Sel = "" ;
      AV38TFEmpHsDia = DecimalUtil.ZERO ;
      AV39TFEmpHsDia_To = DecimalUtil.ZERO ;
      AV40TFEmpHsSem = DecimalUtil.ZERO ;
      AV41TFEmpHsSem_To = DecimalUtil.ZERO ;
      AV46TFEmpHsMaxDia = DecimalUtil.ZERO ;
      AV47TFEmpHsMaxDia_To = DecimalUtil.ZERO ;
      AV48TFEmpHsMaxSem = DecimalUtil.ZERO ;
      AV49TFEmpHsMaxSem_To = DecimalUtil.ZERO ;
      AV50TFEmpHsMaxMes = DecimalUtil.ZERO ;
      AV51TFEmpHsMaxMes_To = DecimalUtil.ZERO ;
      AV52TFEmpHsMaxAnu = DecimalUtil.ZERO ;
      AV53TFEmpHsMaxAnu_To = DecimalUtil.ZERO ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A1294PaiTipoTraId = "" ;
      A1344EmpHsDia = DecimalUtil.ZERO ;
      A1345EmpHsSem = DecimalUtil.ZERO ;
      A1386EmpHsMaxDia = DecimalUtil.ZERO ;
      A1387EmpHsMaxSem = DecimalUtil.ZERO ;
      A1388EmpHsMaxMes = DecimalUtil.ZERO ;
      A1389EmpHsMaxAnu = DecimalUtil.ZERO ;
      AV64Empresa_tiposdetrabajowwds_1_tfpaitipotraid_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV65Empresa_tiposdetrabajowwds_2_tfemphsdia = DecimalUtil.ZERO ;
      AV66Empresa_tiposdetrabajowwds_3_tfemphsdia_to = DecimalUtil.ZERO ;
      AV67Empresa_tiposdetrabajowwds_4_tfemphssem = DecimalUtil.ZERO ;
      AV68Empresa_tiposdetrabajowwds_5_tfemphssem_to = DecimalUtil.ZERO ;
      AV69Empresa_tiposdetrabajowwds_6_tfemphsmaxdia = DecimalUtil.ZERO ;
      AV70Empresa_tiposdetrabajowwds_7_tfemphsmaxdia_to = DecimalUtil.ZERO ;
      AV71Empresa_tiposdetrabajowwds_8_tfemphsmaxsem = DecimalUtil.ZERO ;
      AV72Empresa_tiposdetrabajowwds_9_tfemphsmaxsem_to = DecimalUtil.ZERO ;
      AV73Empresa_tiposdetrabajowwds_10_tfemphsmaxmes = DecimalUtil.ZERO ;
      AV74Empresa_tiposdetrabajowwds_11_tfemphsmaxmes_to = DecimalUtil.ZERO ;
      AV75Empresa_tiposdetrabajowwds_12_tfemphsmaxanu = DecimalUtil.ZERO ;
      AV76Empresa_tiposdetrabajowwds_13_tfemphsmaxanu_to = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P01SN2_A1EmpCod = new short[1] ;
      P01SN2_A3CliCod = new int[1] ;
      P01SN2_A1389EmpHsMaxAnu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01SN2_A1388EmpHsMaxMes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01SN2_A1387EmpHsMaxSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01SN2_A1386EmpHsMaxDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01SN2_A1345EmpHsSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01SN2_A1344EmpHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01SN2_A1294PaiTipoTraId = new String[] {""} ;
      AV28UserCustomValue = "" ;
      GXt_char7 = "" ;
      GXv_char8 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector6 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV35TFPaiTipoTraId_SelsJson = "" ;
      AV57MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empresa_tiposdetrabajowwexport__default(),
         new Object[] {
             new Object[] {
            P01SN2_A1EmpCod, P01SN2_A3CliCod, P01SN2_A1389EmpHsMaxAnu, P01SN2_A1388EmpHsMaxMes, P01SN2_A1387EmpHsMaxSem, P01SN2_A1386EmpHsMaxDia, P01SN2_A1345EmpHsSem, P01SN2_A1344EmpHsDia, P01SN2_A1294PaiTipoTraId
            }
         }
      );
      AV60Pgmname = "empresa_tiposdetrabajoWWExport" ;
      /* GeneXus formulas. */
      AV60Pgmname = "empresa_tiposdetrabajoWWExport" ;
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
   private int AV61GXV1 ;
   private int AV62GXV2 ;
   private int AV64Empresa_tiposdetrabajowwds_1_tfpaitipotraid_sels_size ;
   private int AV55CliCod ;
   private int A3CliCod ;
   private int AV77GXV3 ;
   private int AV78GXV4 ;
   private long AV54i ;
   private long AV32VisibleColumnCount ;
   private java.math.BigDecimal AV38TFEmpHsDia ;
   private java.math.BigDecimal AV39TFEmpHsDia_To ;
   private java.math.BigDecimal AV40TFEmpHsSem ;
   private java.math.BigDecimal AV41TFEmpHsSem_To ;
   private java.math.BigDecimal AV46TFEmpHsMaxDia ;
   private java.math.BigDecimal AV47TFEmpHsMaxDia_To ;
   private java.math.BigDecimal AV48TFEmpHsMaxSem ;
   private java.math.BigDecimal AV49TFEmpHsMaxSem_To ;
   private java.math.BigDecimal AV50TFEmpHsMaxMes ;
   private java.math.BigDecimal AV51TFEmpHsMaxMes_To ;
   private java.math.BigDecimal AV52TFEmpHsMaxAnu ;
   private java.math.BigDecimal AV53TFEmpHsMaxAnu_To ;
   private java.math.BigDecimal A1344EmpHsDia ;
   private java.math.BigDecimal A1345EmpHsSem ;
   private java.math.BigDecimal A1386EmpHsMaxDia ;
   private java.math.BigDecimal A1387EmpHsMaxSem ;
   private java.math.BigDecimal A1388EmpHsMaxMes ;
   private java.math.BigDecimal A1389EmpHsMaxAnu ;
   private java.math.BigDecimal AV65Empresa_tiposdetrabajowwds_2_tfemphsdia ;
   private java.math.BigDecimal AV66Empresa_tiposdetrabajowwds_3_tfemphsdia_to ;
   private java.math.BigDecimal AV67Empresa_tiposdetrabajowwds_4_tfemphssem ;
   private java.math.BigDecimal AV68Empresa_tiposdetrabajowwds_5_tfemphssem_to ;
   private java.math.BigDecimal AV69Empresa_tiposdetrabajowwds_6_tfemphsmaxdia ;
   private java.math.BigDecimal AV70Empresa_tiposdetrabajowwds_7_tfemphsmaxdia_to ;
   private java.math.BigDecimal AV71Empresa_tiposdetrabajowwds_8_tfemphsmaxsem ;
   private java.math.BigDecimal AV72Empresa_tiposdetrabajowwds_9_tfemphsmaxsem_to ;
   private java.math.BigDecimal AV73Empresa_tiposdetrabajowwds_10_tfemphsmaxmes ;
   private java.math.BigDecimal AV74Empresa_tiposdetrabajowwds_11_tfemphsmaxmes_to ;
   private java.math.BigDecimal AV75Empresa_tiposdetrabajowwds_12_tfemphsmaxanu ;
   private java.math.BigDecimal AV76Empresa_tiposdetrabajowwds_13_tfemphsmaxanu_to ;
   private String AV60Pgmname ;
   private String AV37TFPaiTipoTraId_Sel ;
   private String A1294PaiTipoTraId ;
   private String scmdbuf ;
   private String GXt_char7 ;
   private String GXv_char8[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV19OrderedDsc ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV35TFPaiTipoTraId_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV57MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV36TFPaiTipoTraId_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private short[] P01SN2_A1EmpCod ;
   private int[] P01SN2_A3CliCod ;
   private java.math.BigDecimal[] P01SN2_A1389EmpHsMaxAnu ;
   private java.math.BigDecimal[] P01SN2_A1388EmpHsMaxMes ;
   private java.math.BigDecimal[] P01SN2_A1387EmpHsMaxSem ;
   private java.math.BigDecimal[] P01SN2_A1386EmpHsMaxDia ;
   private java.math.BigDecimal[] P01SN2_A1345EmpHsSem ;
   private java.math.BigDecimal[] P01SN2_A1344EmpHsDia ;
   private String[] P01SN2_A1294PaiTipoTraId ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV64Empresa_tiposdetrabajowwds_1_tfpaitipotraid_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV24ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV25ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector6[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV26ColumnsSelector_Column ;
}

final  class empresa_tiposdetrabajowwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01SN2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1294PaiTipoTraId ,
                                          GXSimpleCollection<String> AV64Empresa_tiposdetrabajowwds_1_tfpaitipotraid_sels ,
                                          int AV64Empresa_tiposdetrabajowwds_1_tfpaitipotraid_sels_size ,
                                          java.math.BigDecimal AV65Empresa_tiposdetrabajowwds_2_tfemphsdia ,
                                          java.math.BigDecimal AV66Empresa_tiposdetrabajowwds_3_tfemphsdia_to ,
                                          java.math.BigDecimal AV67Empresa_tiposdetrabajowwds_4_tfemphssem ,
                                          java.math.BigDecimal AV68Empresa_tiposdetrabajowwds_5_tfemphssem_to ,
                                          java.math.BigDecimal AV69Empresa_tiposdetrabajowwds_6_tfemphsmaxdia ,
                                          java.math.BigDecimal AV70Empresa_tiposdetrabajowwds_7_tfemphsmaxdia_to ,
                                          java.math.BigDecimal AV71Empresa_tiposdetrabajowwds_8_tfemphsmaxsem ,
                                          java.math.BigDecimal AV72Empresa_tiposdetrabajowwds_9_tfemphsmaxsem_to ,
                                          java.math.BigDecimal AV73Empresa_tiposdetrabajowwds_10_tfemphsmaxmes ,
                                          java.math.BigDecimal AV74Empresa_tiposdetrabajowwds_11_tfemphsmaxmes_to ,
                                          java.math.BigDecimal AV75Empresa_tiposdetrabajowwds_12_tfemphsmaxanu ,
                                          java.math.BigDecimal AV76Empresa_tiposdetrabajowwds_13_tfemphsmaxanu_to ,
                                          java.math.BigDecimal A1344EmpHsDia ,
                                          java.math.BigDecimal A1345EmpHsSem ,
                                          java.math.BigDecimal A1386EmpHsMaxDia ,
                                          java.math.BigDecimal A1387EmpHsMaxSem ,
                                          java.math.BigDecimal A1388EmpHsMaxMes ,
                                          java.math.BigDecimal A1389EmpHsMaxAnu ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          int AV55CliCod ,
                                          short AV56EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[14];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT EmpCod, CliCod, EmpHsMaxAnu, EmpHsMaxMes, EmpHsMaxSem, EmpHsMaxDia, EmpHsSem, EmpHsDia, PaiTipoTraId FROM Empresatipo_trabajo" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      if ( AV64Empresa_tiposdetrabajowwds_1_tfpaitipotraid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV64Empresa_tiposdetrabajowwds_1_tfpaitipotraid_sels, "PaiTipoTraId IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV65Empresa_tiposdetrabajowwds_2_tfemphsdia)==0) )
      {
         addWhere(sWhereString, "(EmpHsDia >= ?)");
      }
      else
      {
         GXv_int10[2] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66Empresa_tiposdetrabajowwds_3_tfemphsdia_to)==0) )
      {
         addWhere(sWhereString, "(EmpHsDia <= ?)");
      }
      else
      {
         GXv_int10[3] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67Empresa_tiposdetrabajowwds_4_tfemphssem)==0) )
      {
         addWhere(sWhereString, "(EmpHsSem >= ?)");
      }
      else
      {
         GXv_int10[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV68Empresa_tiposdetrabajowwds_5_tfemphssem_to)==0) )
      {
         addWhere(sWhereString, "(EmpHsSem <= ?)");
      }
      else
      {
         GXv_int10[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV69Empresa_tiposdetrabajowwds_6_tfemphsmaxdia)==0) )
      {
         addWhere(sWhereString, "(EmpHsMaxDia >= ?)");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV70Empresa_tiposdetrabajowwds_7_tfemphsmaxdia_to)==0) )
      {
         addWhere(sWhereString, "(EmpHsMaxDia <= ?)");
      }
      else
      {
         GXv_int10[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV71Empresa_tiposdetrabajowwds_8_tfemphsmaxsem)==0) )
      {
         addWhere(sWhereString, "(EmpHsMaxSem >= ?)");
      }
      else
      {
         GXv_int10[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV72Empresa_tiposdetrabajowwds_9_tfemphsmaxsem_to)==0) )
      {
         addWhere(sWhereString, "(EmpHsMaxSem <= ?)");
      }
      else
      {
         GXv_int10[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV73Empresa_tiposdetrabajowwds_10_tfemphsmaxmes)==0) )
      {
         addWhere(sWhereString, "(EmpHsMaxMes >= ?)");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV74Empresa_tiposdetrabajowwds_11_tfemphsmaxmes_to)==0) )
      {
         addWhere(sWhereString, "(EmpHsMaxMes <= ?)");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV75Empresa_tiposdetrabajowwds_12_tfemphsmaxanu)==0) )
      {
         addWhere(sWhereString, "(EmpHsMaxAnu >= ?)");
      }
      else
      {
         GXv_int10[12] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV76Empresa_tiposdetrabajowwds_13_tfemphsmaxanu_to)==0) )
      {
         addWhere(sWhereString, "(EmpHsMaxAnu <= ?)");
      }
      else
      {
         GXv_int10[13] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiTipoTraId" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiTipoTraId DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY EmpHsDia" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EmpHsDia DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY EmpHsSem" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EmpHsSem DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY EmpHsMaxDia" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EmpHsMaxDia DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY EmpHsMaxSem" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EmpHsMaxSem DESC" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY EmpHsMaxMes" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EmpHsMaxMes DESC" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY EmpHsMaxAnu" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EmpHsMaxAnu DESC" ;
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
                  return conditional_P01SN2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , (java.math.BigDecimal)dynConstraints[3] , (java.math.BigDecimal)dynConstraints[4] , (java.math.BigDecimal)dynConstraints[5] , (java.math.BigDecimal)dynConstraints[6] , (java.math.BigDecimal)dynConstraints[7] , (java.math.BigDecimal)dynConstraints[8] , (java.math.BigDecimal)dynConstraints[9] , (java.math.BigDecimal)dynConstraints[10] , (java.math.BigDecimal)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , (java.math.BigDecimal)dynConstraints[14] , (java.math.BigDecimal)dynConstraints[15] , (java.math.BigDecimal)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , (java.math.BigDecimal)dynConstraints[20] , ((Number) dynConstraints[21]).shortValue() , ((Boolean) dynConstraints[22]).booleanValue() , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).shortValue() , ((Number) dynConstraints[25]).intValue() , ((Number) dynConstraints[26]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01SN2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,1);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,1);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,1);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,1);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,1);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,1);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
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
                  stmt.setInt(sIdx, ((Number) parms[14]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[15]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[16], 1);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[17], 1);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[18], 1);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 1);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[20], 1);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[21], 1);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[22], 1);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[23], 1);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[24], 1);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 1);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[26], 1);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[27], 1);
               }
               return;
      }
   }

}

