package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class paistipotrabajowwexport extends GXProcedure
{
   public paistipotrabajowwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( paistipotrabajowwexport.class ), "" );
   }

   public paistipotrabajowwexport( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      paistipotrabajowwexport.this.aP1 = new String[] {""};
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
      paistipotrabajowwexport.this.aP0 = aP0;
      paistipotrabajowwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaisTipoTrabajo", GXv_boolean2) ;
      paistipotrabajowwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV68Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "PaisTipoTrabajoWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV38TFPaiTipoTraId_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo de Trabajo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paistipotrabajowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV62i = 1 ;
         AV69GXV1 = 1 ;
         while ( AV69GXV1 <= AV38TFPaiTipoTraId_Sels.size() )
         {
            AV39TFPaiTipoTraId_Sel = (String)AV38TFPaiTipoTraId_Sels.elementAt(-1+AV69GXV1) ;
            if ( AV62i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaintipo_trabajo.getDescription(httpContext,(String)AV39TFPaiTipoTraId_Sel), "") );
            AV62i = (long)(AV62i+1) ;
            AV69GXV1 = (int)(AV69GXV1+1) ;
         }
      }
      if ( ! ( (0==AV40TFPaiTipoTraIns_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Trabajo insalubre", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paistipotrabajowwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV40TFPaiTipoTraIns_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV40TFPaiTipoTraIns_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV41TFPaiTipoHsDia)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV42TFPaiTipoHsDia_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Límite de horas normales por día", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paistipotrabajowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV41TFPaiTipoHsDia)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paistipotrabajowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV42TFPaiTipoHsDia_To)) );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV43TFPaiTipoHsSem)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV44TFPaiTipoHsSem_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Límite de horas normales por semana", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paistipotrabajowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV43TFPaiTipoHsSem)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paistipotrabajowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV44TFPaiTipoHsSem_To)) );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV49TFPaiTipoHsMaxDia)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV50TFPaiTipoHsMaxDia_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Máximo de horas extras por día", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paistipotrabajowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV49TFPaiTipoHsMaxDia)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paistipotrabajowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV50TFPaiTipoHsMaxDia_To)) );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV51TFPaiTipoHsMaxSem)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV52TFPaiTipoHsMaxSem_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Máximo de horas extras por semana", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paistipotrabajowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV51TFPaiTipoHsMaxSem)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paistipotrabajowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV52TFPaiTipoHsMaxSem_To)) );
      }
      if ( ! ( ( AV54TFPaiTipoHsMaxMes_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Máximo de horas extras por mes", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paistipotrabajowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV62i = 1 ;
         AV70GXV2 = 1 ;
         while ( AV70GXV2 <= AV54TFPaiTipoHsMaxMes_Sels.size() )
         {
            AV55TFPaiTipoHsMaxMes_Sel = AV54TFPaiTipoHsMaxMes_Sels.elementAt(-1+AV70GXV2) ;
            if ( AV62i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+localUtil.format( AV55TFPaiTipoHsMaxMes_Sel, "ZZ9.9") );
            AV62i = (long)(AV62i+1) ;
            AV70GXV2 = (int)(AV70GXV2+1) ;
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV56TFPaiTipoHsMaxAnu)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV57TFPaiTipoHsMaxAnu_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Máximoi de horas extras por año", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paistipotrabajowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV56TFPaiTipoHsMaxAnu)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paistipotrabajowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV57TFPaiTipoHsMaxAnu_To)) );
      }
      if ( ! ( ( AV60TFPaiTipoTraRelRef_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Liberación", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paistipotrabajowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV62i = 1 ;
         AV71GXV3 = 1 ;
         while ( AV71GXV3 <= AV60TFPaiTipoTraRelRef_Sels.size() )
         {
            AV61TFPaiTipoTraRelRef_Sel = (String)AV60TFPaiTipoTraRelRef_Sels.elementAt(-1+AV71GXV3) ;
            if ( AV62i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV61TFPaiTipoTraRelRef_Sel, GXv_char7) ;
            paistipotrabajowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV62i = (long)(AV62i+1) ;
            AV71GXV3 = (int)(AV71GXV3+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV59TFPaiTipoTraRelRef)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Liberación", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            paistipotrabajowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV59TFPaiTipoTraRelRef, GXv_char7) ;
            paistipotrabajowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV34VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("PaisTipoTrabajoWWColumnsSelector"), "") != 0 )
      {
         AV29ColumnsSelectorXML = AV20Session.getValue("PaisTipoTrabajoWWColumnsSelector") ;
         AV26ColumnsSelector.fromxml(AV29ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( (boolean)((AV24IsAuthorizedPaiTipoTraRelRef&&((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible())) );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV72GXV4 = 1 ;
      while ( AV72GXV4 <= AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV28ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV72GXV4));
         if ( AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setColor( 11 );
            AV34VisibleColumnCount = (long)(AV34VisibleColumnCount+1) ;
         }
         AV72GXV4 = (int)(AV72GXV4+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV74Paistipotrabajowwds_1_tfpaitipotraid_sels = AV38TFPaiTipoTraId_Sels ;
      AV75Paistipotrabajowwds_2_tfpaitipotrains_sel = AV40TFPaiTipoTraIns_Sel ;
      AV76Paistipotrabajowwds_3_tfpaitipohsdia = AV41TFPaiTipoHsDia ;
      AV77Paistipotrabajowwds_4_tfpaitipohsdia_to = AV42TFPaiTipoHsDia_To ;
      AV78Paistipotrabajowwds_5_tfpaitipohssem = AV43TFPaiTipoHsSem ;
      AV79Paistipotrabajowwds_6_tfpaitipohssem_to = AV44TFPaiTipoHsSem_To ;
      AV80Paistipotrabajowwds_7_tfpaitipohsmaxdia = AV49TFPaiTipoHsMaxDia ;
      AV81Paistipotrabajowwds_8_tfpaitipohsmaxdia_to = AV50TFPaiTipoHsMaxDia_To ;
      AV82Paistipotrabajowwds_9_tfpaitipohsmaxsem = AV51TFPaiTipoHsMaxSem ;
      AV83Paistipotrabajowwds_10_tfpaitipohsmaxsem_to = AV52TFPaiTipoHsMaxSem_To ;
      AV84Paistipotrabajowwds_11_tfpaitipohsmaxmes_sels = AV54TFPaiTipoHsMaxMes_Sels ;
      AV85Paistipotrabajowwds_12_tfpaitipohsmaxanu = AV56TFPaiTipoHsMaxAnu ;
      AV86Paistipotrabajowwds_13_tfpaitipohsmaxanu_to = AV57TFPaiTipoHsMaxAnu_To ;
      AV87Paistipotrabajowwds_14_tfpaitipotrarelref = AV59TFPaiTipoTraRelRef ;
      AV88Paistipotrabajowwds_15_tfpaitipotrarelref_sels = AV60TFPaiTipoTraRelRef_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1294PaiTipoTraId ,
                                           AV74Paistipotrabajowwds_1_tfpaitipotraid_sels ,
                                           A1385PaiTipoHsMaxMes ,
                                           AV84Paistipotrabajowwds_11_tfpaitipohsmaxmes_sels ,
                                           A2056PaiTipoTraRelRef ,
                                           AV88Paistipotrabajowwds_15_tfpaitipotrarelref_sels ,
                                           Integer.valueOf(AV74Paistipotrabajowwds_1_tfpaitipotraid_sels.size()) ,
                                           Byte.valueOf(AV75Paistipotrabajowwds_2_tfpaitipotrains_sel) ,
                                           AV76Paistipotrabajowwds_3_tfpaitipohsdia ,
                                           AV77Paistipotrabajowwds_4_tfpaitipohsdia_to ,
                                           AV78Paistipotrabajowwds_5_tfpaitipohssem ,
                                           AV79Paistipotrabajowwds_6_tfpaitipohssem_to ,
                                           AV80Paistipotrabajowwds_7_tfpaitipohsmaxdia ,
                                           AV81Paistipotrabajowwds_8_tfpaitipohsmaxdia_to ,
                                           AV82Paistipotrabajowwds_9_tfpaitipohsmaxsem ,
                                           AV83Paistipotrabajowwds_10_tfpaitipohsmaxsem_to ,
                                           Integer.valueOf(AV84Paistipotrabajowwds_11_tfpaitipohsmaxmes_sels.size()) ,
                                           AV85Paistipotrabajowwds_12_tfpaitipohsmaxanu ,
                                           AV86Paistipotrabajowwds_13_tfpaitipohsmaxanu_to ,
                                           Integer.valueOf(AV88Paistipotrabajowwds_15_tfpaitipotrarelref_sels.size()) ,
                                           AV87Paistipotrabajowwds_14_tfpaitipotrarelref ,
                                           Short.valueOf(AV65PaiCod) ,
                                           Boolean.valueOf(A1297PaiTipoTraIns) ,
                                           A1336PaiTipoHsDia ,
                                           A1337PaiTipoHsSem ,
                                           A1383PaiTipoHsMaxDia ,
                                           A1384PaiTipoHsMaxSem ,
                                           A1390PaiTipoHsMaxAnu ,
                                           Short.valueOf(A46PaiCod) ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV87Paistipotrabajowwds_14_tfpaitipotrarelref = GXutil.concat( GXutil.rtrim( AV87Paistipotrabajowwds_14_tfpaitipotrarelref), "%", "") ;
      /* Using cursor P02FL2 */
      pr_default.execute(0, new Object[] {AV76Paistipotrabajowwds_3_tfpaitipohsdia, AV77Paistipotrabajowwds_4_tfpaitipohsdia_to, AV78Paistipotrabajowwds_5_tfpaitipohssem, AV79Paistipotrabajowwds_6_tfpaitipohssem_to, AV80Paistipotrabajowwds_7_tfpaitipohsmaxdia, AV81Paistipotrabajowwds_8_tfpaitipohsmaxdia_to, AV82Paistipotrabajowwds_9_tfpaitipohsmaxsem, AV83Paistipotrabajowwds_10_tfpaitipohsmaxsem_to, AV85Paistipotrabajowwds_12_tfpaitipohsmaxanu, AV86Paistipotrabajowwds_13_tfpaitipohsmaxanu_to, lV87Paistipotrabajowwds_14_tfpaitipotrarelref, Short.valueOf(AV65PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A46PaiCod = P02FL2_A46PaiCod[0] ;
         A2056PaiTipoTraRelRef = P02FL2_A2056PaiTipoTraRelRef[0] ;
         A1390PaiTipoHsMaxAnu = P02FL2_A1390PaiTipoHsMaxAnu[0] ;
         A1385PaiTipoHsMaxMes = P02FL2_A1385PaiTipoHsMaxMes[0] ;
         A1384PaiTipoHsMaxSem = P02FL2_A1384PaiTipoHsMaxSem[0] ;
         A1383PaiTipoHsMaxDia = P02FL2_A1383PaiTipoHsMaxDia[0] ;
         A1337PaiTipoHsSem = P02FL2_A1337PaiTipoHsSem[0] ;
         A1336PaiTipoHsDia = P02FL2_A1336PaiTipoHsDia[0] ;
         A1297PaiTipoTraIns = P02FL2_A1297PaiTipoTraIns[0] ;
         A1294PaiTipoTraId = P02FL2_A1294PaiTipoTraId[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV34VisibleColumnCount = 0 ;
         AV89GXV5 = 1 ;
         while ( AV89GXV5 <= AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV28ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV89GXV5));
            if ( AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiTipoTraId") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaintipo_trabajo.getDescription(httpContext,(String)A1294PaiTipoTraId), "") );
               }
               else if ( GXutil.strcmp(AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiTipoTraIns") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1297PaiTipoTraIns) );
               }
               else if ( GXutil.strcmp(AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiTipoHsDia") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1336PaiTipoHsDia)) );
               }
               else if ( GXutil.strcmp(AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiTipoHsSem") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1337PaiTipoHsSem)) );
               }
               else if ( GXutil.strcmp(AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiTipoHsMaxDia") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1383PaiTipoHsMaxDia)) );
               }
               else if ( GXutil.strcmp(AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiTipoHsMaxSem") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1384PaiTipoHsMaxSem)) );
               }
               else if ( GXutil.strcmp(AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiTipoHsMaxMes") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1385PaiTipoHsMaxMes)) );
               }
               else if ( GXutil.strcmp(AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiTipoHsMaxAnu") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1390PaiTipoHsMaxAnu)) );
               }
               else if ( GXutil.strcmp(AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiTipoTraRelRef") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A2056PaiTipoTraRelRef, GXv_char7) ;
                  paistipotrabajowwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               AV34VisibleColumnCount = (long)(AV34VisibleColumnCount+1) ;
            }
            AV89GXV5 = (int)(AV89GXV5+1) ;
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
      GXt_boolean1 = AV24IsAuthorizedPaiTipoTraRelRef ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV63CliCod, GXv_boolean2) ;
      paistipotrabajowwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV24IsAuthorizedPaiTipoTraRelRef = (boolean)((!GXt_boolean1)) ;
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
      AV26ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiTipoTraId", "", "Tipo de Trabajo", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiTipoTraIns", "", "Trabajo insalubre", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiTipoHsDia", "", "Límite de horas normales por día", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiTipoHsSem", "", "Límite de horas normales por semana", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiTipoHsMaxDia", "", "Máximo de horas extras por día", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiTipoHsMaxSem", "", "Máximo de horas extras por semana", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiTipoHsMaxMes", "", "Máximo de horas extras por mes", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiTipoHsMaxAnu", "", "Máximoi de horas extras por año", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      if ( ! new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).executeUdp( AV63CliCod) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiTipoTraRelRef", "", "Liberación", true, "") ;
         AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&VerSVG", "", "", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&ModificarSVG", "", "", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&EliminarSVG", "", "", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV30UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "PaisTipoTrabajoWWColumnsSelector", GXv_char7) ;
      paistipotrabajowwexport.this.GXt_char6 = GXv_char7[0] ;
      AV30UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV30UserCustomValue)==0) ) )
      {
         AV27ColumnsSelectorAux.fromxml(AV30UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector9[0] = AV26ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, GXv_SdtWWPColumnsSelector9) ;
         AV27ColumnsSelectorAux = GXv_SdtWWPColumnsSelector8[0] ;
         AV26ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
   }

   public void S211( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("PaisTipoTrabajoWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "PaisTipoTrabajoWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("PaisTipoTrabajoWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV90GXV6 = 1 ;
      while ( AV90GXV6 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV90GXV6));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAITIPOTRAID_SEL") == 0 )
         {
            AV37TFPaiTipoTraId_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV38TFPaiTipoTraId_Sels.fromJSonString(AV37TFPaiTipoTraId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAITIPOTRAINS_SEL") == 0 )
         {
            AV40TFPaiTipoTraIns_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAITIPOHSDIA") == 0 )
         {
            AV41TFPaiTipoHsDia = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV42TFPaiTipoHsDia_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAITIPOHSSEM") == 0 )
         {
            AV43TFPaiTipoHsSem = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV44TFPaiTipoHsSem_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAITIPOHSMAXDIA") == 0 )
         {
            AV49TFPaiTipoHsMaxDia = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV50TFPaiTipoHsMaxDia_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAITIPOHSMAXSEM") == 0 )
         {
            AV51TFPaiTipoHsMaxSem = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV52TFPaiTipoHsMaxSem_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAITIPOHSMAXMES_SEL") == 0 )
         {
            AV53TFPaiTipoHsMaxMes_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV54TFPaiTipoHsMaxMes_Sels.fromJSonString(AV53TFPaiTipoHsMaxMes_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAITIPOHSMAXANU") == 0 )
         {
            AV56TFPaiTipoHsMaxAnu = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV57TFPaiTipoHsMaxAnu_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAITIPOTRARELREF") == 0 )
         {
            AV59TFPaiTipoTraRelRef = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAITIPOTRARELREF_SEL") == 0 )
         {
            AV58TFPaiTipoTraRelRef_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV60TFPaiTipoTraRelRef_Sels.fromJSonString(AV58TFPaiTipoTraRelRef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV17MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV90GXV6 = (int)(AV90GXV6+1) ;
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
      this.aP0[0] = paistipotrabajowwexport.this.AV12Filename;
      this.aP1[0] = paistipotrabajowwexport.this.AV13ErrorMessage;
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
      AV68Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV38TFPaiTipoTraId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV39TFPaiTipoTraId_Sel = "" ;
      AV41TFPaiTipoHsDia = DecimalUtil.ZERO ;
      AV42TFPaiTipoHsDia_To = DecimalUtil.ZERO ;
      AV43TFPaiTipoHsSem = DecimalUtil.ZERO ;
      AV44TFPaiTipoHsSem_To = DecimalUtil.ZERO ;
      AV49TFPaiTipoHsMaxDia = DecimalUtil.ZERO ;
      AV50TFPaiTipoHsMaxDia_To = DecimalUtil.ZERO ;
      AV51TFPaiTipoHsMaxSem = DecimalUtil.ZERO ;
      AV52TFPaiTipoHsMaxSem_To = DecimalUtil.ZERO ;
      AV54TFPaiTipoHsMaxMes_Sels = new GXSimpleCollection<java.math.BigDecimal>(java.math.BigDecimal.class, "internal", "");
      AV55TFPaiTipoHsMaxMes_Sel = DecimalUtil.ZERO ;
      AV56TFPaiTipoHsMaxAnu = DecimalUtil.ZERO ;
      AV57TFPaiTipoHsMaxAnu_To = DecimalUtil.ZERO ;
      AV60TFPaiTipoTraRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV61TFPaiTipoTraRelRef_Sel = "" ;
      AV59TFPaiTipoTraRelRef = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV29ColumnsSelectorXML = "" ;
      AV26ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV28ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A1294PaiTipoTraId = "" ;
      A1336PaiTipoHsDia = DecimalUtil.ZERO ;
      A1337PaiTipoHsSem = DecimalUtil.ZERO ;
      A1383PaiTipoHsMaxDia = DecimalUtil.ZERO ;
      A1384PaiTipoHsMaxSem = DecimalUtil.ZERO ;
      A1385PaiTipoHsMaxMes = DecimalUtil.ZERO ;
      A1390PaiTipoHsMaxAnu = DecimalUtil.ZERO ;
      A2056PaiTipoTraRelRef = "" ;
      AV74Paistipotrabajowwds_1_tfpaitipotraid_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV76Paistipotrabajowwds_3_tfpaitipohsdia = DecimalUtil.ZERO ;
      AV77Paistipotrabajowwds_4_tfpaitipohsdia_to = DecimalUtil.ZERO ;
      AV78Paistipotrabajowwds_5_tfpaitipohssem = DecimalUtil.ZERO ;
      AV79Paistipotrabajowwds_6_tfpaitipohssem_to = DecimalUtil.ZERO ;
      AV80Paistipotrabajowwds_7_tfpaitipohsmaxdia = DecimalUtil.ZERO ;
      AV81Paistipotrabajowwds_8_tfpaitipohsmaxdia_to = DecimalUtil.ZERO ;
      AV82Paistipotrabajowwds_9_tfpaitipohsmaxsem = DecimalUtil.ZERO ;
      AV83Paistipotrabajowwds_10_tfpaitipohsmaxsem_to = DecimalUtil.ZERO ;
      AV84Paistipotrabajowwds_11_tfpaitipohsmaxmes_sels = new GXSimpleCollection<java.math.BigDecimal>(java.math.BigDecimal.class, "internal", "");
      AV85Paistipotrabajowwds_12_tfpaitipohsmaxanu = DecimalUtil.ZERO ;
      AV86Paistipotrabajowwds_13_tfpaitipohsmaxanu_to = DecimalUtil.ZERO ;
      AV87Paistipotrabajowwds_14_tfpaitipotrarelref = "" ;
      AV88Paistipotrabajowwds_15_tfpaitipotrarelref_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV87Paistipotrabajowwds_14_tfpaitipotrarelref = "" ;
      P02FL2_A46PaiCod = new short[1] ;
      P02FL2_A2056PaiTipoTraRelRef = new String[] {""} ;
      P02FL2_A1390PaiTipoHsMaxAnu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02FL2_A1385PaiTipoHsMaxMes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02FL2_A1384PaiTipoHsMaxSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02FL2_A1383PaiTipoHsMaxDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02FL2_A1337PaiTipoHsSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02FL2_A1336PaiTipoHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02FL2_A1297PaiTipoTraIns = new boolean[] {false} ;
      P02FL2_A1294PaiTipoTraId = new String[] {""} ;
      GXv_boolean2 = new boolean[1] ;
      AV30UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV27ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV37TFPaiTipoTraId_SelsJson = "" ;
      AV53TFPaiTipoHsMaxMes_SelsJson = "" ;
      AV58TFPaiTipoTraRelRef_SelsJson = "" ;
      AV17MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.paistipotrabajowwexport__default(),
         new Object[] {
             new Object[] {
            P02FL2_A46PaiCod, P02FL2_A2056PaiTipoTraRelRef, P02FL2_A1390PaiTipoHsMaxAnu, P02FL2_A1385PaiTipoHsMaxMes, P02FL2_A1384PaiTipoHsMaxSem, P02FL2_A1383PaiTipoHsMaxDia, P02FL2_A1337PaiTipoHsSem, P02FL2_A1336PaiTipoHsDia, P02FL2_A1297PaiTipoTraIns, P02FL2_A1294PaiTipoTraId
            }
         }
      );
      AV68Pgmname = "PaisTipoTrabajoWWExport" ;
      /* GeneXus formulas. */
      AV68Pgmname = "PaisTipoTrabajoWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV40TFPaiTipoTraIns_Sel ;
   private byte AV75Paistipotrabajowwds_2_tfpaitipotrains_sel ;
   private short GXv_int5[] ;
   private short AV65PaiCod ;
   private short A46PaiCod ;
   private short AV18OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV69GXV1 ;
   private int AV70GXV2 ;
   private int AV71GXV3 ;
   private int AV72GXV4 ;
   private int AV74Paistipotrabajowwds_1_tfpaitipotraid_sels_size ;
   private int AV84Paistipotrabajowwds_11_tfpaitipohsmaxmes_sels_size ;
   private int AV88Paistipotrabajowwds_15_tfpaitipotrarelref_sels_size ;
   private int AV89GXV5 ;
   private int AV63CliCod ;
   private int AV90GXV6 ;
   private long AV62i ;
   private long AV34VisibleColumnCount ;
   private java.math.BigDecimal AV41TFPaiTipoHsDia ;
   private java.math.BigDecimal AV42TFPaiTipoHsDia_To ;
   private java.math.BigDecimal AV43TFPaiTipoHsSem ;
   private java.math.BigDecimal AV44TFPaiTipoHsSem_To ;
   private java.math.BigDecimal AV49TFPaiTipoHsMaxDia ;
   private java.math.BigDecimal AV50TFPaiTipoHsMaxDia_To ;
   private java.math.BigDecimal AV51TFPaiTipoHsMaxSem ;
   private java.math.BigDecimal AV52TFPaiTipoHsMaxSem_To ;
   private java.math.BigDecimal AV55TFPaiTipoHsMaxMes_Sel ;
   private java.math.BigDecimal AV56TFPaiTipoHsMaxAnu ;
   private java.math.BigDecimal AV57TFPaiTipoHsMaxAnu_To ;
   private java.math.BigDecimal A1336PaiTipoHsDia ;
   private java.math.BigDecimal A1337PaiTipoHsSem ;
   private java.math.BigDecimal A1383PaiTipoHsMaxDia ;
   private java.math.BigDecimal A1384PaiTipoHsMaxSem ;
   private java.math.BigDecimal A1385PaiTipoHsMaxMes ;
   private java.math.BigDecimal A1390PaiTipoHsMaxAnu ;
   private java.math.BigDecimal AV76Paistipotrabajowwds_3_tfpaitipohsdia ;
   private java.math.BigDecimal AV77Paistipotrabajowwds_4_tfpaitipohsdia_to ;
   private java.math.BigDecimal AV78Paistipotrabajowwds_5_tfpaitipohssem ;
   private java.math.BigDecimal AV79Paistipotrabajowwds_6_tfpaitipohssem_to ;
   private java.math.BigDecimal AV80Paistipotrabajowwds_7_tfpaitipohsmaxdia ;
   private java.math.BigDecimal AV81Paistipotrabajowwds_8_tfpaitipohsmaxdia_to ;
   private java.math.BigDecimal AV82Paistipotrabajowwds_9_tfpaitipohsmaxsem ;
   private java.math.BigDecimal AV83Paistipotrabajowwds_10_tfpaitipohsmaxsem_to ;
   private java.math.BigDecimal AV85Paistipotrabajowwds_12_tfpaitipohsmaxanu ;
   private java.math.BigDecimal AV86Paistipotrabajowwds_13_tfpaitipohsmaxanu_to ;
   private String AV68Pgmname ;
   private String AV39TFPaiTipoTraId_Sel ;
   private String A1294PaiTipoTraId ;
   private String scmdbuf ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean returnInSub ;
   private boolean AV24IsAuthorizedPaiTipoTraRelRef ;
   private boolean A1297PaiTipoTraIns ;
   private boolean AV19OrderedDsc ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean Cond_result ;
   private String AV29ColumnsSelectorXML ;
   private String AV30UserCustomValue ;
   private String AV37TFPaiTipoTraId_SelsJson ;
   private String AV53TFPaiTipoHsMaxMes_SelsJson ;
   private String AV58TFPaiTipoTraRelRef_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV61TFPaiTipoTraRelRef_Sel ;
   private String AV59TFPaiTipoTraRelRef ;
   private String A2056PaiTipoTraRelRef ;
   private String AV87Paistipotrabajowwds_14_tfpaitipotrarelref ;
   private String lV87Paistipotrabajowwds_14_tfpaitipotrarelref ;
   private String AV17MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<java.math.BigDecimal> AV54TFPaiTipoHsMaxMes_Sels ;
   private GXSimpleCollection<String> AV38TFPaiTipoTraId_Sels ;
   private GXSimpleCollection<String> AV60TFPaiTipoTraRelRef_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private short[] P02FL2_A46PaiCod ;
   private String[] P02FL2_A2056PaiTipoTraRelRef ;
   private java.math.BigDecimal[] P02FL2_A1390PaiTipoHsMaxAnu ;
   private java.math.BigDecimal[] P02FL2_A1385PaiTipoHsMaxMes ;
   private java.math.BigDecimal[] P02FL2_A1384PaiTipoHsMaxSem ;
   private java.math.BigDecimal[] P02FL2_A1383PaiTipoHsMaxDia ;
   private java.math.BigDecimal[] P02FL2_A1337PaiTipoHsSem ;
   private java.math.BigDecimal[] P02FL2_A1336PaiTipoHsDia ;
   private boolean[] P02FL2_A1297PaiTipoTraIns ;
   private String[] P02FL2_A1294PaiTipoTraId ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<java.math.BigDecimal> AV84Paistipotrabajowwds_11_tfpaitipohsmaxmes_sels ;
   private GXSimpleCollection<String> AV74Paistipotrabajowwds_1_tfpaitipotraid_sels ;
   private GXSimpleCollection<String> AV88Paistipotrabajowwds_15_tfpaitipotrarelref_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV26ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV27ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV28ColumnsSelector_Column ;
}

final  class paistipotrabajowwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02FL2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1294PaiTipoTraId ,
                                          GXSimpleCollection<String> AV74Paistipotrabajowwds_1_tfpaitipotraid_sels ,
                                          java.math.BigDecimal A1385PaiTipoHsMaxMes ,
                                          GXSimpleCollection<java.math.BigDecimal> AV84Paistipotrabajowwds_11_tfpaitipohsmaxmes_sels ,
                                          String A2056PaiTipoTraRelRef ,
                                          GXSimpleCollection<String> AV88Paistipotrabajowwds_15_tfpaitipotrarelref_sels ,
                                          int AV74Paistipotrabajowwds_1_tfpaitipotraid_sels_size ,
                                          byte AV75Paistipotrabajowwds_2_tfpaitipotrains_sel ,
                                          java.math.BigDecimal AV76Paistipotrabajowwds_3_tfpaitipohsdia ,
                                          java.math.BigDecimal AV77Paistipotrabajowwds_4_tfpaitipohsdia_to ,
                                          java.math.BigDecimal AV78Paistipotrabajowwds_5_tfpaitipohssem ,
                                          java.math.BigDecimal AV79Paistipotrabajowwds_6_tfpaitipohssem_to ,
                                          java.math.BigDecimal AV80Paistipotrabajowwds_7_tfpaitipohsmaxdia ,
                                          java.math.BigDecimal AV81Paistipotrabajowwds_8_tfpaitipohsmaxdia_to ,
                                          java.math.BigDecimal AV82Paistipotrabajowwds_9_tfpaitipohsmaxsem ,
                                          java.math.BigDecimal AV83Paistipotrabajowwds_10_tfpaitipohsmaxsem_to ,
                                          int AV84Paistipotrabajowwds_11_tfpaitipohsmaxmes_sels_size ,
                                          java.math.BigDecimal AV85Paistipotrabajowwds_12_tfpaitipohsmaxanu ,
                                          java.math.BigDecimal AV86Paistipotrabajowwds_13_tfpaitipohsmaxanu_to ,
                                          int AV88Paistipotrabajowwds_15_tfpaitipotrarelref_sels_size ,
                                          String AV87Paistipotrabajowwds_14_tfpaitipotrarelref ,
                                          short AV65PaiCod ,
                                          boolean A1297PaiTipoTraIns ,
                                          java.math.BigDecimal A1336PaiTipoHsDia ,
                                          java.math.BigDecimal A1337PaiTipoHsSem ,
                                          java.math.BigDecimal A1383PaiTipoHsMaxDia ,
                                          java.math.BigDecimal A1384PaiTipoHsMaxSem ,
                                          java.math.BigDecimal A1390PaiTipoHsMaxAnu ,
                                          short A46PaiCod ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[12];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT PaiCod, PaiTipoTraRelRef, PaiTipoHsMaxAnu, PaiTipoHsMaxMes, PaiTipoHsMaxSem, PaiTipoHsMaxDia, PaiTipoHsSem, PaiTipoHsDia, PaiTipoTraIns, PaiTipoTraId FROM" ;
      scmdbuf += " PaisTipoTrabajo" ;
      if ( AV74Paistipotrabajowwds_1_tfpaitipotraid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV74Paistipotrabajowwds_1_tfpaitipotraid_sels, "PaiTipoTraId IN (", ")")+")");
      }
      if ( AV75Paistipotrabajowwds_2_tfpaitipotrains_sel == 1 )
      {
         addWhere(sWhereString, "(PaiTipoTraIns = TRUE)");
      }
      if ( AV75Paistipotrabajowwds_2_tfpaitipotrains_sel == 2 )
      {
         addWhere(sWhereString, "(PaiTipoTraIns = FALSE)");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV76Paistipotrabajowwds_3_tfpaitipohsdia)==0) )
      {
         addWhere(sWhereString, "(PaiTipoHsDia >= ?)");
      }
      else
      {
         GXv_int10[0] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV77Paistipotrabajowwds_4_tfpaitipohsdia_to)==0) )
      {
         addWhere(sWhereString, "(PaiTipoHsDia <= ?)");
      }
      else
      {
         GXv_int10[1] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV78Paistipotrabajowwds_5_tfpaitipohssem)==0) )
      {
         addWhere(sWhereString, "(PaiTipoHsSem >= ?)");
      }
      else
      {
         GXv_int10[2] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV79Paistipotrabajowwds_6_tfpaitipohssem_to)==0) )
      {
         addWhere(sWhereString, "(PaiTipoHsSem <= ?)");
      }
      else
      {
         GXv_int10[3] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV80Paistipotrabajowwds_7_tfpaitipohsmaxdia)==0) )
      {
         addWhere(sWhereString, "(PaiTipoHsMaxDia >= ?)");
      }
      else
      {
         GXv_int10[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV81Paistipotrabajowwds_8_tfpaitipohsmaxdia_to)==0) )
      {
         addWhere(sWhereString, "(PaiTipoHsMaxDia <= ?)");
      }
      else
      {
         GXv_int10[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV82Paistipotrabajowwds_9_tfpaitipohsmaxsem)==0) )
      {
         addWhere(sWhereString, "(PaiTipoHsMaxSem >= ?)");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV83Paistipotrabajowwds_10_tfpaitipohsmaxsem_to)==0) )
      {
         addWhere(sWhereString, "(PaiTipoHsMaxSem <= ?)");
      }
      else
      {
         GXv_int10[7] = (byte)(1) ;
      }
      if ( AV84Paistipotrabajowwds_11_tfpaitipohsmaxmes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV84Paistipotrabajowwds_11_tfpaitipohsmaxmes_sels, "PaiTipoHsMaxMes IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV85Paistipotrabajowwds_12_tfpaitipohsmaxanu)==0) )
      {
         addWhere(sWhereString, "(PaiTipoHsMaxAnu >= ?)");
      }
      else
      {
         GXv_int10[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV86Paistipotrabajowwds_13_tfpaitipohsmaxanu_to)==0) )
      {
         addWhere(sWhereString, "(PaiTipoHsMaxAnu <= ?)");
      }
      else
      {
         GXv_int10[9] = (byte)(1) ;
      }
      if ( ( AV88Paistipotrabajowwds_15_tfpaitipotrarelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV87Paistipotrabajowwds_14_tfpaitipotrarelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(PaiTipoTraRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( AV88Paistipotrabajowwds_15_tfpaitipotrarelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV88Paistipotrabajowwds_15_tfpaitipotrarelref_sels, "PaiTipoTraRelRef IN (", ")")+")");
      }
      if ( ! (0==AV65PaiCod) )
      {
         addWhere(sWhereString, "(PaiCod = ?)");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
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
         scmdbuf += " ORDER BY PaiTipoTraIns" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiTipoTraIns DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiTipoHsDia" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiTipoHsDia DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiTipoHsSem" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiTipoHsSem DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiTipoHsMaxDia" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiTipoHsMaxDia DESC" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiTipoHsMaxSem" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiTipoHsMaxSem DESC" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiTipoHsMaxMes" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiTipoHsMaxMes DESC" ;
      }
      else if ( ( AV18OrderedBy == 8 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiTipoHsMaxAnu" ;
      }
      else if ( ( AV18OrderedBy == 8 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiTipoHsMaxAnu DESC" ;
      }
      else if ( ( AV18OrderedBy == 9 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiTipoTraRelRef" ;
      }
      else if ( ( AV18OrderedBy == 9 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiTipoTraRelRef DESC" ;
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
                  return conditional_P02FL2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (java.math.BigDecimal)dynConstraints[2] , (GXSimpleCollection<java.math.BigDecimal>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).byteValue() , (java.math.BigDecimal)dynConstraints[8] , (java.math.BigDecimal)dynConstraints[9] , (java.math.BigDecimal)dynConstraints[10] , (java.math.BigDecimal)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , (java.math.BigDecimal)dynConstraints[14] , (java.math.BigDecimal)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , ((Number) dynConstraints[21]).shortValue() , ((Boolean) dynConstraints[22]).booleanValue() , (java.math.BigDecimal)dynConstraints[23] , (java.math.BigDecimal)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , (java.math.BigDecimal)dynConstraints[27] , ((Number) dynConstraints[28]).shortValue() , ((Number) dynConstraints[29]).shortValue() , ((Boolean) dynConstraints[30]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02FL2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,1);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,1);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,1);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,1);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,1);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,1);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 20);
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
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[12], 1);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[13], 1);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[14], 1);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[15], 1);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[16], 1);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[17], 1);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[18], 1);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 1);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[20], 1);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[21], 1);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 40);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[23]).shortValue());
               }
               return;
      }
   }

}

