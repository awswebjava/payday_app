package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class convenio_tiposdetrabajowwexport extends GXProcedure
{
   public convenio_tiposdetrabajowwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( convenio_tiposdetrabajowwexport.class ), "" );
   }

   public convenio_tiposdetrabajowwexport( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      convenio_tiposdetrabajowwexport.this.aP1 = new String[] {""};
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
      convenio_tiposdetrabajowwexport.this.aP0 = aP0;
      convenio_tiposdetrabajowwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV56CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      convenio_tiposdetrabajowwexport.this.GXt_int1 = GXv_int2[0] ;
      AV56CliCod = GXt_int1 ;
      GXv_int3[0] = AV58PaiCod ;
      new web.clientegetpais(remoteHandle, context).execute( AV56CliCod, GXv_int3) ;
      convenio_tiposdetrabajowwexport.this.AV58PaiCod = GXv_int3[0] ;
      GXv_char4[0] = AV59CliConvenio ;
      new web.getconvecodsesion(remoteHandle, context).execute( GXv_char4) ;
      convenio_tiposdetrabajowwexport.this.AV59CliConvenio = GXv_char4[0] ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWconvenio_tiposdetrabajo", GXv_boolean6) ;
      convenio_tiposdetrabajowwexport.this.GXt_boolean5 = GXv_boolean6[0] ;
      AV8IsAuthorized = GXt_boolean5 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV71Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext7[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext7) ;
         AV9WWPContext = GXv_SdtWWPContext7[0] ;
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
      AV12Filename = "convenio_tiposdetrabajoWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo de Trabajo", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         convenio_tiposdetrabajowwexport.this.AV14CellRow = GXv_int3[0] ;
         AV55i = 1 ;
         AV72GXV1 = 1 ;
         while ( AV72GXV1 <= AV36TFPaiTipoTraId_Sels.size() )
         {
            AV37TFPaiTipoTraId_Sel = (String)AV36TFPaiTipoTraId_Sels.elementAt(-1+AV72GXV1) ;
            if ( AV55i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaintipo_trabajo.getDescription(httpContext,(String)AV37TFPaiTipoTraId_Sel), "") );
            AV55i = (long)(AV55i+1) ;
            AV72GXV1 = (int)(AV72GXV1+1) ;
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV38TFConveHsDia)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV39TFConveHsDia_To)==0) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Límite de horas normales por día", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         convenio_tiposdetrabajowwexport.this.AV14CellRow = GXv_int3[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV38TFConveHsDia)) );
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, false, GXv_int3, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         convenio_tiposdetrabajowwexport.this.AV14CellRow = GXv_int3[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV39TFConveHsDia_To)) );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV40TFConveHsSem)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV41TFConveHsSem_To)==0) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Límite de horas normales por semana", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         convenio_tiposdetrabajowwexport.this.AV14CellRow = GXv_int3[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV40TFConveHsSem)) );
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, false, GXv_int3, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         convenio_tiposdetrabajowwexport.this.AV14CellRow = GXv_int3[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV41TFConveHsSem_To)) );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV46TFConveHsMaxDia)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV47TFConveHsMaxDia_To)==0) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Máximo de horas extras por día", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         convenio_tiposdetrabajowwexport.this.AV14CellRow = GXv_int3[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV46TFConveHsMaxDia)) );
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, false, GXv_int3, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         convenio_tiposdetrabajowwexport.this.AV14CellRow = GXv_int3[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV47TFConveHsMaxDia_To)) );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV48TFConveHsMaxSem)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV49TFConveHsMaxSem_To)==0) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Máximo de horas extras por semana", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         convenio_tiposdetrabajowwexport.this.AV14CellRow = GXv_int3[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV48TFConveHsMaxSem)) );
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, false, GXv_int3, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         convenio_tiposdetrabajowwexport.this.AV14CellRow = GXv_int3[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV49TFConveHsMaxSem_To)) );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV60TFConveHsMaxMes)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV61TFConveHsMaxMes_To)==0) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Máximo de horas extras por mes", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         convenio_tiposdetrabajowwexport.this.AV14CellRow = GXv_int3[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV60TFConveHsMaxMes)) );
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, false, GXv_int3, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         convenio_tiposdetrabajowwexport.this.AV14CellRow = GXv_int3[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV61TFConveHsMaxMes_To)) );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV53TFConveHsMaxAnu)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV54TFConveHsMaxAnu_To)==0) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Máximo de horas extras por año", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         convenio_tiposdetrabajowwexport.this.AV14CellRow = GXv_int3[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV53TFConveHsMaxAnu)) );
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, false, GXv_int3, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         convenio_tiposdetrabajowwexport.this.AV14CellRow = GXv_int3[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV54TFConveHsMaxAnu_To)) );
      }
      if ( ! ( ( AV67TFConveHsRelRef_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Liberación", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         convenio_tiposdetrabajowwexport.this.AV14CellRow = GXv_int3[0] ;
         AV55i = 1 ;
         AV73GXV2 = 1 ;
         while ( AV73GXV2 <= AV67TFConveHsRelRef_Sels.size() )
         {
            AV68TFConveHsRelRef_Sel = (String)AV67TFConveHsRelRef_Sels.elementAt(-1+AV73GXV2) ;
            if ( AV55i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char9 = "" ;
            GXv_char4[0] = GXt_char9 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV68TFConveHsRelRef_Sel, GXv_char4) ;
            convenio_tiposdetrabajowwexport.this.GXt_char9 = GXv_char4[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char9 );
            AV55i = (long)(AV55i+1) ;
            AV73GXV2 = (int)(AV73GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV66TFConveHsRelRef)==0) ) )
         {
            GXv_exceldoc8[0] = AV11ExcelDocument ;
            GXv_int3[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "Liberación", "")) ;
            AV11ExcelDocument = GXv_exceldoc8[0] ;
            convenio_tiposdetrabajowwexport.this.AV14CellRow = GXv_int3[0] ;
            GXt_char9 = "" ;
            GXv_char4[0] = GXt_char9 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV66TFConveHsRelRef, GXv_char4) ;
            convenio_tiposdetrabajowwexport.this.GXt_char9 = GXv_char4[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char9 );
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("convenio_tiposdetrabajoWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("convenio_tiposdetrabajoWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Isvisible( true );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Columnname( "CliCod" );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Displayname( httpContext.getMessage( "Cod", "") );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Order( (short)(AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size()+1) );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().add(AV26ColumnsSelector_Column, 0);
      AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Isvisible( true );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Columnname( "CliPaiConve" );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Displayname( httpContext.getMessage( "Pai Conve", "") );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Order( (short)(AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size()+1) );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().add(AV26ColumnsSelector_Column, 0);
      AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Isvisible( true );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Columnname( "CliConvenio" );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Displayname( httpContext.getMessage( "Convenio", "") );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Order( (short)(AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size()+1) );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().add(AV26ColumnsSelector_Column, 0);
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( (boolean)((AV63IsAuthorizedConveHsRelRef&&((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible())) );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV74GXV3 = 1 ;
      while ( AV74GXV3 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV74GXV3));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV74GXV3 = (int)(AV74GXV3+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV76Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels = AV36TFPaiTipoTraId_Sels ;
      AV77Convenio_tiposdetrabajowwds_2_tfconvehsdia = AV38TFConveHsDia ;
      AV78Convenio_tiposdetrabajowwds_3_tfconvehsdia_to = AV39TFConveHsDia_To ;
      AV79Convenio_tiposdetrabajowwds_4_tfconvehssem = AV40TFConveHsSem ;
      AV80Convenio_tiposdetrabajowwds_5_tfconvehssem_to = AV41TFConveHsSem_To ;
      AV81Convenio_tiposdetrabajowwds_6_tfconvehsmaxdia = AV46TFConveHsMaxDia ;
      AV82Convenio_tiposdetrabajowwds_7_tfconvehsmaxdia_to = AV47TFConveHsMaxDia_To ;
      AV83Convenio_tiposdetrabajowwds_8_tfconvehsmaxsem = AV48TFConveHsMaxSem ;
      AV84Convenio_tiposdetrabajowwds_9_tfconvehsmaxsem_to = AV49TFConveHsMaxSem_To ;
      AV85Convenio_tiposdetrabajowwds_10_tfconvehsmaxmes = AV60TFConveHsMaxMes ;
      AV86Convenio_tiposdetrabajowwds_11_tfconvehsmaxmes_to = AV61TFConveHsMaxMes_To ;
      AV87Convenio_tiposdetrabajowwds_12_tfconvehsmaxanu = AV53TFConveHsMaxAnu ;
      AV88Convenio_tiposdetrabajowwds_13_tfconvehsmaxanu_to = AV54TFConveHsMaxAnu_To ;
      AV89Convenio_tiposdetrabajowwds_14_tfconvehsrelref = AV66TFConveHsRelRef ;
      AV90Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels = AV67TFConveHsRelRef_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1294PaiTipoTraId ,
                                           AV76Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels ,
                                           A2064ConveHsRelRef ,
                                           AV90Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels ,
                                           Integer.valueOf(AV76Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels.size()) ,
                                           AV77Convenio_tiposdetrabajowwds_2_tfconvehsdia ,
                                           AV78Convenio_tiposdetrabajowwds_3_tfconvehsdia_to ,
                                           AV79Convenio_tiposdetrabajowwds_4_tfconvehssem ,
                                           AV80Convenio_tiposdetrabajowwds_5_tfconvehssem_to ,
                                           AV81Convenio_tiposdetrabajowwds_6_tfconvehsmaxdia ,
                                           AV82Convenio_tiposdetrabajowwds_7_tfconvehsmaxdia_to ,
                                           AV83Convenio_tiposdetrabajowwds_8_tfconvehsmaxsem ,
                                           AV84Convenio_tiposdetrabajowwds_9_tfconvehsmaxsem_to ,
                                           AV85Convenio_tiposdetrabajowwds_10_tfconvehsmaxmes ,
                                           AV86Convenio_tiposdetrabajowwds_11_tfconvehsmaxmes_to ,
                                           AV87Convenio_tiposdetrabajowwds_12_tfconvehsmaxanu ,
                                           AV88Convenio_tiposdetrabajowwds_13_tfconvehsmaxanu_to ,
                                           Integer.valueOf(AV90Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels.size()) ,
                                           AV89Convenio_tiposdetrabajowwds_14_tfconvehsrelref ,
                                           A1323ConveHsDia ,
                                           A1324ConveHsSem ,
                                           A1391ConveHsMaxDia ,
                                           A1392ConveHsMaxSem ,
                                           A1393ConveHsMaxMes ,
                                           A1394ConveHsMaxAnu ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Integer.valueOf(AV56CliCod) ,
                                           Short.valueOf(AV58PaiCod) ,
                                           AV59CliConvenio ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1564CliPaiConve) ,
                                           A1565CliConvenio } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.STRING
                                           }
      });
      lV89Convenio_tiposdetrabajowwds_14_tfconvehsrelref = GXutil.concat( GXutil.rtrim( AV89Convenio_tiposdetrabajowwds_14_tfconvehsrelref), "%", "") ;
      /* Using cursor P01KZ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV56CliCod), Short.valueOf(AV58PaiCod), AV59CliConvenio, AV77Convenio_tiposdetrabajowwds_2_tfconvehsdia, AV78Convenio_tiposdetrabajowwds_3_tfconvehsdia_to, AV79Convenio_tiposdetrabajowwds_4_tfconvehssem, AV80Convenio_tiposdetrabajowwds_5_tfconvehssem_to, AV81Convenio_tiposdetrabajowwds_6_tfconvehsmaxdia, AV82Convenio_tiposdetrabajowwds_7_tfconvehsmaxdia_to, AV83Convenio_tiposdetrabajowwds_8_tfconvehsmaxsem, AV84Convenio_tiposdetrabajowwds_9_tfconvehsmaxsem_to, AV85Convenio_tiposdetrabajowwds_10_tfconvehsmaxmes, AV86Convenio_tiposdetrabajowwds_11_tfconvehsmaxmes_to, AV87Convenio_tiposdetrabajowwds_12_tfconvehsmaxanu, AV88Convenio_tiposdetrabajowwds_13_tfconvehsmaxanu_to, lV89Convenio_tiposdetrabajowwds_14_tfconvehsrelref});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P01KZ2_A3CliCod[0] ;
         A1565CliConvenio = P01KZ2_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01KZ2_A1564CliPaiConve[0] ;
         A2064ConveHsRelRef = P01KZ2_A2064ConveHsRelRef[0] ;
         A1394ConveHsMaxAnu = P01KZ2_A1394ConveHsMaxAnu[0] ;
         A1393ConveHsMaxMes = P01KZ2_A1393ConveHsMaxMes[0] ;
         A1392ConveHsMaxSem = P01KZ2_A1392ConveHsMaxSem[0] ;
         A1391ConveHsMaxDia = P01KZ2_A1391ConveHsMaxDia[0] ;
         A1324ConveHsSem = P01KZ2_A1324ConveHsSem[0] ;
         A1323ConveHsDia = P01KZ2_A1323ConveHsDia[0] ;
         A1294PaiTipoTraId = P01KZ2_A1294PaiTipoTraId[0] ;
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
         AV91GXV4 = 1 ;
         while ( AV91GXV4 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV91GXV4));
            if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliCod") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A3CliCod );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliPaiConve") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1564CliPaiConve );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliConvenio") == 0 )
               {
                  GXt_char9 = "" ;
                  GXv_char4[0] = GXt_char9 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1565CliConvenio, GXv_char4) ;
                  convenio_tiposdetrabajowwexport.this.GXt_char9 = GXv_char4[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char9 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiTipoTraId") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaintipo_trabajo.getDescription(httpContext,(String)A1294PaiTipoTraId), "") );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveHsDia") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1323ConveHsDia)) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveHsSem") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1324ConveHsSem)) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveHsMaxDia") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1391ConveHsMaxDia)) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveHsMaxSem") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1392ConveHsMaxSem)) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveHsMaxMes") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1393ConveHsMaxMes)) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveHsMaxAnu") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1394ConveHsMaxAnu)) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveHsRelRef") == 0 )
               {
                  GXt_char9 = "" ;
                  GXv_char4[0] = GXt_char9 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A2064ConveHsRelRef, GXv_char4) ;
                  convenio_tiposdetrabajowwexport.this.GXt_char9 = GXv_char4[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char9 );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV91GXV4 = (int)(AV91GXV4+1) ;
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
      GXt_boolean5 = AV63IsAuthorizedConveHsRelRef ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV56CliCod, GXv_boolean6) ;
      convenio_tiposdetrabajowwexport.this.GXt_boolean5 = GXv_boolean6[0] ;
      AV63IsAuthorizedConveHsRelRef = (boolean)((!GXt_boolean5)) ;
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
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "PaiTipoTraId", "", "Tipo de Trabajo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConveHsDia", "", "Límite de horas normales por día", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConveHsSem", "", "Límite de horas normales por semana", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConveHsMaxDia", "", "Máximo de horas extras por día", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConveHsMaxSem", "", "Máximo de horas extras por semana", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConveHsMaxMes", "", "Máximo de horas extras por mes", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConveHsMaxAnu", "", "Máximo de horas extras por año", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      if ( ! new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).executeUdp( AV56CliCod) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConveHsRelRef", "", "Liberación", true, "") ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "", "", "", false, "") ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      }
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&VerSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&ModificarSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&EliminarSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXt_char9 = AV28UserCustomValue ;
      GXv_char4[0] = GXt_char9 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "convenio_tiposdetrabajoWWColumnsSelector", GXv_char4) ;
      convenio_tiposdetrabajowwexport.this.GXt_char9 = GXv_char4[0] ;
      AV28UserCustomValue = GXt_char9 ;
      if ( ! ( (GXutil.strcmp("", AV28UserCustomValue)==0) ) )
      {
         AV25ColumnsSelectorAux.fromxml(AV28UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector10[0] = AV25ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector11[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, GXv_SdtWWPColumnsSelector11) ;
         AV25ColumnsSelectorAux = GXv_SdtWWPColumnsSelector10[0] ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      }
   }

   public void S211( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("convenio_tiposdetrabajoWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "convenio_tiposdetrabajoWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("convenio_tiposdetrabajoWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV92GXV5 = 1 ;
      while ( AV92GXV5 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV92GXV5));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAITIPOTRAID_SEL") == 0 )
         {
            AV35TFPaiTipoTraId_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV36TFPaiTipoTraId_Sels.fromJSonString(AV35TFPaiTipoTraId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSDIA") == 0 )
         {
            AV38TFConveHsDia = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV39TFConveHsDia_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSSEM") == 0 )
         {
            AV40TFConveHsSem = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV41TFConveHsSem_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSMAXDIA") == 0 )
         {
            AV46TFConveHsMaxDia = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV47TFConveHsMaxDia_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSMAXSEM") == 0 )
         {
            AV48TFConveHsMaxSem = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV49TFConveHsMaxSem_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSMAXMES") == 0 )
         {
            AV60TFConveHsMaxMes = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV61TFConveHsMaxMes_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSMAXANU") == 0 )
         {
            AV53TFConveHsMaxAnu = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV54TFConveHsMaxAnu_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSRELREF") == 0 )
         {
            AV66TFConveHsRelRef = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSRELREF_SEL") == 0 )
         {
            AV65TFConveHsRelRef_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV67TFConveHsRelRef_Sels.fromJSonString(AV65TFConveHsRelRef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV62MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV92GXV5 = (int)(AV92GXV5+1) ;
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
      this.aP0[0] = convenio_tiposdetrabajowwexport.this.AV12Filename;
      this.aP1[0] = convenio_tiposdetrabajowwexport.this.AV13ErrorMessage;
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
      GXv_int2 = new int[1] ;
      AV59CliConvenio = "" ;
      AV71Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV36TFPaiTipoTraId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV37TFPaiTipoTraId_Sel = "" ;
      AV38TFConveHsDia = DecimalUtil.ZERO ;
      AV39TFConveHsDia_To = DecimalUtil.ZERO ;
      AV40TFConveHsSem = DecimalUtil.ZERO ;
      AV41TFConveHsSem_To = DecimalUtil.ZERO ;
      AV46TFConveHsMaxDia = DecimalUtil.ZERO ;
      AV47TFConveHsMaxDia_To = DecimalUtil.ZERO ;
      AV48TFConveHsMaxSem = DecimalUtil.ZERO ;
      AV49TFConveHsMaxSem_To = DecimalUtil.ZERO ;
      AV60TFConveHsMaxMes = DecimalUtil.ZERO ;
      AV61TFConveHsMaxMes_To = DecimalUtil.ZERO ;
      AV53TFConveHsMaxAnu = DecimalUtil.ZERO ;
      AV54TFConveHsMaxAnu_To = DecimalUtil.ZERO ;
      AV67TFConveHsRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV68TFConveHsRelRef_Sel = "" ;
      AV66TFConveHsRelRef = "" ;
      GXv_exceldoc8 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int3 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A1565CliConvenio = "" ;
      A1294PaiTipoTraId = "" ;
      A1323ConveHsDia = DecimalUtil.ZERO ;
      A1324ConveHsSem = DecimalUtil.ZERO ;
      A1391ConveHsMaxDia = DecimalUtil.ZERO ;
      A1392ConveHsMaxSem = DecimalUtil.ZERO ;
      A1393ConveHsMaxMes = DecimalUtil.ZERO ;
      A1394ConveHsMaxAnu = DecimalUtil.ZERO ;
      A2064ConveHsRelRef = "" ;
      AV76Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV77Convenio_tiposdetrabajowwds_2_tfconvehsdia = DecimalUtil.ZERO ;
      AV78Convenio_tiposdetrabajowwds_3_tfconvehsdia_to = DecimalUtil.ZERO ;
      AV79Convenio_tiposdetrabajowwds_4_tfconvehssem = DecimalUtil.ZERO ;
      AV80Convenio_tiposdetrabajowwds_5_tfconvehssem_to = DecimalUtil.ZERO ;
      AV81Convenio_tiposdetrabajowwds_6_tfconvehsmaxdia = DecimalUtil.ZERO ;
      AV82Convenio_tiposdetrabajowwds_7_tfconvehsmaxdia_to = DecimalUtil.ZERO ;
      AV83Convenio_tiposdetrabajowwds_8_tfconvehsmaxsem = DecimalUtil.ZERO ;
      AV84Convenio_tiposdetrabajowwds_9_tfconvehsmaxsem_to = DecimalUtil.ZERO ;
      AV85Convenio_tiposdetrabajowwds_10_tfconvehsmaxmes = DecimalUtil.ZERO ;
      AV86Convenio_tiposdetrabajowwds_11_tfconvehsmaxmes_to = DecimalUtil.ZERO ;
      AV87Convenio_tiposdetrabajowwds_12_tfconvehsmaxanu = DecimalUtil.ZERO ;
      AV88Convenio_tiposdetrabajowwds_13_tfconvehsmaxanu_to = DecimalUtil.ZERO ;
      AV89Convenio_tiposdetrabajowwds_14_tfconvehsrelref = "" ;
      AV90Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV89Convenio_tiposdetrabajowwds_14_tfconvehsrelref = "" ;
      P01KZ2_A3CliCod = new int[1] ;
      P01KZ2_A1565CliConvenio = new String[] {""} ;
      P01KZ2_A1564CliPaiConve = new short[1] ;
      P01KZ2_A2064ConveHsRelRef = new String[] {""} ;
      P01KZ2_A1394ConveHsMaxAnu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01KZ2_A1393ConveHsMaxMes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01KZ2_A1392ConveHsMaxSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01KZ2_A1391ConveHsMaxDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01KZ2_A1324ConveHsSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01KZ2_A1323ConveHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01KZ2_A1294PaiTipoTraId = new String[] {""} ;
      GXv_boolean6 = new boolean[1] ;
      AV28UserCustomValue = "" ;
      GXt_char9 = "" ;
      GXv_char4 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector10 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector11 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV35TFPaiTipoTraId_SelsJson = "" ;
      AV65TFConveHsRelRef_SelsJson = "" ;
      AV62MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.convenio_tiposdetrabajowwexport__default(),
         new Object[] {
             new Object[] {
            P01KZ2_A3CliCod, P01KZ2_A1565CliConvenio, P01KZ2_A1564CliPaiConve, P01KZ2_A2064ConveHsRelRef, P01KZ2_A1394ConveHsMaxAnu, P01KZ2_A1393ConveHsMaxMes, P01KZ2_A1392ConveHsMaxSem, P01KZ2_A1391ConveHsMaxDia, P01KZ2_A1324ConveHsSem, P01KZ2_A1323ConveHsDia,
            P01KZ2_A1294PaiTipoTraId
            }
         }
      );
      AV71Pgmname = "convenio_tiposdetrabajoWWExport" ;
      /* GeneXus formulas. */
      AV71Pgmname = "convenio_tiposdetrabajoWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short AV58PaiCod ;
   private short GXv_int3[] ;
   private short A1564CliPaiConve ;
   private short AV18OrderedBy ;
   private short Gx_err ;
   private int AV56CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV72GXV1 ;
   private int AV73GXV2 ;
   private int AV74GXV3 ;
   private int A3CliCod ;
   private int AV76Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels_size ;
   private int AV90Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels_size ;
   private int AV91GXV4 ;
   private int AV92GXV5 ;
   private long AV55i ;
   private long AV32VisibleColumnCount ;
   private java.math.BigDecimal AV38TFConveHsDia ;
   private java.math.BigDecimal AV39TFConveHsDia_To ;
   private java.math.BigDecimal AV40TFConveHsSem ;
   private java.math.BigDecimal AV41TFConveHsSem_To ;
   private java.math.BigDecimal AV46TFConveHsMaxDia ;
   private java.math.BigDecimal AV47TFConveHsMaxDia_To ;
   private java.math.BigDecimal AV48TFConveHsMaxSem ;
   private java.math.BigDecimal AV49TFConveHsMaxSem_To ;
   private java.math.BigDecimal AV60TFConveHsMaxMes ;
   private java.math.BigDecimal AV61TFConveHsMaxMes_To ;
   private java.math.BigDecimal AV53TFConveHsMaxAnu ;
   private java.math.BigDecimal AV54TFConveHsMaxAnu_To ;
   private java.math.BigDecimal A1323ConveHsDia ;
   private java.math.BigDecimal A1324ConveHsSem ;
   private java.math.BigDecimal A1391ConveHsMaxDia ;
   private java.math.BigDecimal A1392ConveHsMaxSem ;
   private java.math.BigDecimal A1393ConveHsMaxMes ;
   private java.math.BigDecimal A1394ConveHsMaxAnu ;
   private java.math.BigDecimal AV77Convenio_tiposdetrabajowwds_2_tfconvehsdia ;
   private java.math.BigDecimal AV78Convenio_tiposdetrabajowwds_3_tfconvehsdia_to ;
   private java.math.BigDecimal AV79Convenio_tiposdetrabajowwds_4_tfconvehssem ;
   private java.math.BigDecimal AV80Convenio_tiposdetrabajowwds_5_tfconvehssem_to ;
   private java.math.BigDecimal AV81Convenio_tiposdetrabajowwds_6_tfconvehsmaxdia ;
   private java.math.BigDecimal AV82Convenio_tiposdetrabajowwds_7_tfconvehsmaxdia_to ;
   private java.math.BigDecimal AV83Convenio_tiposdetrabajowwds_8_tfconvehsmaxsem ;
   private java.math.BigDecimal AV84Convenio_tiposdetrabajowwds_9_tfconvehsmaxsem_to ;
   private java.math.BigDecimal AV85Convenio_tiposdetrabajowwds_10_tfconvehsmaxmes ;
   private java.math.BigDecimal AV86Convenio_tiposdetrabajowwds_11_tfconvehsmaxmes_to ;
   private java.math.BigDecimal AV87Convenio_tiposdetrabajowwds_12_tfconvehsmaxanu ;
   private java.math.BigDecimal AV88Convenio_tiposdetrabajowwds_13_tfconvehsmaxanu_to ;
   private String AV59CliConvenio ;
   private String AV71Pgmname ;
   private String AV37TFPaiTipoTraId_Sel ;
   private String A1565CliConvenio ;
   private String A1294PaiTipoTraId ;
   private String scmdbuf ;
   private String GXt_char9 ;
   private String GXv_char4[] ;
   private boolean AV8IsAuthorized ;
   private boolean returnInSub ;
   private boolean AV63IsAuthorizedConveHsRelRef ;
   private boolean AV19OrderedDsc ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean Cond_result ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV35TFPaiTipoTraId_SelsJson ;
   private String AV65TFConveHsRelRef_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV68TFConveHsRelRef_Sel ;
   private String AV66TFConveHsRelRef ;
   private String A2064ConveHsRelRef ;
   private String AV89Convenio_tiposdetrabajowwds_14_tfconvehsrelref ;
   private String lV89Convenio_tiposdetrabajowwds_14_tfconvehsrelref ;
   private String AV62MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV36TFPaiTipoTraId_Sels ;
   private GXSimpleCollection<String> AV67TFConveHsRelRef_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private int[] P01KZ2_A3CliCod ;
   private String[] P01KZ2_A1565CliConvenio ;
   private short[] P01KZ2_A1564CliPaiConve ;
   private String[] P01KZ2_A2064ConveHsRelRef ;
   private java.math.BigDecimal[] P01KZ2_A1394ConveHsMaxAnu ;
   private java.math.BigDecimal[] P01KZ2_A1393ConveHsMaxMes ;
   private java.math.BigDecimal[] P01KZ2_A1392ConveHsMaxSem ;
   private java.math.BigDecimal[] P01KZ2_A1391ConveHsMaxDia ;
   private java.math.BigDecimal[] P01KZ2_A1324ConveHsSem ;
   private java.math.BigDecimal[] P01KZ2_A1323ConveHsDia ;
   private String[] P01KZ2_A1294PaiTipoTraId ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc8[] ;
   private GXSimpleCollection<String> AV76Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels ;
   private GXSimpleCollection<String> AV90Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV24ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV25ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector10[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector11[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV26ColumnsSelector_Column ;
}

final  class convenio_tiposdetrabajowwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01KZ2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1294PaiTipoTraId ,
                                          GXSimpleCollection<String> AV76Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels ,
                                          String A2064ConveHsRelRef ,
                                          GXSimpleCollection<String> AV90Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels ,
                                          int AV76Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels_size ,
                                          java.math.BigDecimal AV77Convenio_tiposdetrabajowwds_2_tfconvehsdia ,
                                          java.math.BigDecimal AV78Convenio_tiposdetrabajowwds_3_tfconvehsdia_to ,
                                          java.math.BigDecimal AV79Convenio_tiposdetrabajowwds_4_tfconvehssem ,
                                          java.math.BigDecimal AV80Convenio_tiposdetrabajowwds_5_tfconvehssem_to ,
                                          java.math.BigDecimal AV81Convenio_tiposdetrabajowwds_6_tfconvehsmaxdia ,
                                          java.math.BigDecimal AV82Convenio_tiposdetrabajowwds_7_tfconvehsmaxdia_to ,
                                          java.math.BigDecimal AV83Convenio_tiposdetrabajowwds_8_tfconvehsmaxsem ,
                                          java.math.BigDecimal AV84Convenio_tiposdetrabajowwds_9_tfconvehsmaxsem_to ,
                                          java.math.BigDecimal AV85Convenio_tiposdetrabajowwds_10_tfconvehsmaxmes ,
                                          java.math.BigDecimal AV86Convenio_tiposdetrabajowwds_11_tfconvehsmaxmes_to ,
                                          java.math.BigDecimal AV87Convenio_tiposdetrabajowwds_12_tfconvehsmaxanu ,
                                          java.math.BigDecimal AV88Convenio_tiposdetrabajowwds_13_tfconvehsmaxanu_to ,
                                          int AV90Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels_size ,
                                          String AV89Convenio_tiposdetrabajowwds_14_tfconvehsrelref ,
                                          java.math.BigDecimal A1323ConveHsDia ,
                                          java.math.BigDecimal A1324ConveHsSem ,
                                          java.math.BigDecimal A1391ConveHsMaxDia ,
                                          java.math.BigDecimal A1392ConveHsMaxSem ,
                                          java.math.BigDecimal A1393ConveHsMaxMes ,
                                          java.math.BigDecimal A1394ConveHsMaxAnu ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          int AV56CliCod ,
                                          short AV58PaiCod ,
                                          String AV59CliConvenio ,
                                          int A3CliCod ,
                                          short A1564CliPaiConve ,
                                          String A1565CliConvenio )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int12 = new byte[16];
      Object[] GXv_Object13 = new Object[2];
      scmdbuf = "SELECT CliCod, CliConvenio, CliPaiConve, ConveHsRelRef, ConveHsMaxAnu, ConveHsMaxMes, ConveHsMaxSem, ConveHsMaxDia, ConveHsSem, ConveHsDia, PaiTipoTraId FROM convenio_tiposdetrabajo" ;
      addWhere(sWhereString, "(CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?))");
      if ( AV76Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV76Convenio_tiposdetrabajowwds_1_tfpaitipotraid_sels, "PaiTipoTraId IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV77Convenio_tiposdetrabajowwds_2_tfconvehsdia)==0) )
      {
         addWhere(sWhereString, "(ConveHsDia >= ?)");
      }
      else
      {
         GXv_int12[3] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV78Convenio_tiposdetrabajowwds_3_tfconvehsdia_to)==0) )
      {
         addWhere(sWhereString, "(ConveHsDia <= ?)");
      }
      else
      {
         GXv_int12[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV79Convenio_tiposdetrabajowwds_4_tfconvehssem)==0) )
      {
         addWhere(sWhereString, "(ConveHsSem >= ?)");
      }
      else
      {
         GXv_int12[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV80Convenio_tiposdetrabajowwds_5_tfconvehssem_to)==0) )
      {
         addWhere(sWhereString, "(ConveHsSem <= ?)");
      }
      else
      {
         GXv_int12[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV81Convenio_tiposdetrabajowwds_6_tfconvehsmaxdia)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxDia >= ?)");
      }
      else
      {
         GXv_int12[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV82Convenio_tiposdetrabajowwds_7_tfconvehsmaxdia_to)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxDia <= ?)");
      }
      else
      {
         GXv_int12[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV83Convenio_tiposdetrabajowwds_8_tfconvehsmaxsem)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxSem >= ?)");
      }
      else
      {
         GXv_int12[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV84Convenio_tiposdetrabajowwds_9_tfconvehsmaxsem_to)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxSem <= ?)");
      }
      else
      {
         GXv_int12[10] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV85Convenio_tiposdetrabajowwds_10_tfconvehsmaxmes)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxMes >= ?)");
      }
      else
      {
         GXv_int12[11] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV86Convenio_tiposdetrabajowwds_11_tfconvehsmaxmes_to)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxMes <= ?)");
      }
      else
      {
         GXv_int12[12] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV87Convenio_tiposdetrabajowwds_12_tfconvehsmaxanu)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxAnu >= ?)");
      }
      else
      {
         GXv_int12[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV88Convenio_tiposdetrabajowwds_13_tfconvehsmaxanu_to)==0) )
      {
         addWhere(sWhereString, "(ConveHsMaxAnu <= ?)");
      }
      else
      {
         GXv_int12[14] = (byte)(1) ;
      }
      if ( ( AV90Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV89Convenio_tiposdetrabajowwds_14_tfconvehsrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveHsRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int12[15] = (byte)(1) ;
      }
      if ( AV90Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV90Convenio_tiposdetrabajowwds_15_tfconvehsrelref_sels, "ConveHsRelRef IN (", ")")+")");
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
         scmdbuf += " ORDER BY ConveHsDia" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveHsDia DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveHsSem" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveHsSem DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveHsMaxDia" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveHsMaxDia DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveHsMaxSem" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveHsMaxSem DESC" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveHsMaxMes" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveHsMaxMes DESC" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveHsMaxAnu" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveHsMaxAnu DESC" ;
      }
      else if ( ( AV18OrderedBy == 8 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveHsRelRef" ;
      }
      else if ( ( AV18OrderedBy == 8 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveHsRelRef DESC" ;
      }
      GXv_Object13[0] = scmdbuf ;
      GXv_Object13[1] = GXv_int12 ;
      return GXv_Object13 ;
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
                  return conditional_P01KZ2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (java.math.BigDecimal)dynConstraints[5] , (java.math.BigDecimal)dynConstraints[6] , (java.math.BigDecimal)dynConstraints[7] , (java.math.BigDecimal)dynConstraints[8] , (java.math.BigDecimal)dynConstraints[9] , (java.math.BigDecimal)dynConstraints[10] , (java.math.BigDecimal)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , (java.math.BigDecimal)dynConstraints[14] , (java.math.BigDecimal)dynConstraints[15] , (java.math.BigDecimal)dynConstraints[16] , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , (java.math.BigDecimal)dynConstraints[20] , (java.math.BigDecimal)dynConstraints[21] , (java.math.BigDecimal)dynConstraints[22] , (java.math.BigDecimal)dynConstraints[23] , (java.math.BigDecimal)dynConstraints[24] , ((Number) dynConstraints[25]).shortValue() , ((Boolean) dynConstraints[26]).booleanValue() , ((Number) dynConstraints[27]).intValue() , ((Number) dynConstraints[28]).shortValue() , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).shortValue() , (String)dynConstraints[32] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01KZ2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,1);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,1);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,1);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,1);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,1);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,1);
               ((String[]) buf[10])[0] = rslt.getString(11, 20);
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
                  stmt.setInt(sIdx, ((Number) parms[16]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[17]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[18], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 1);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[20], 1);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[21], 1);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[22], 1);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[23], 1);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[24], 1);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 1);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[26], 1);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[27], 1);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[28], 1);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[29], 1);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[30], 1);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 40);
               }
               return;
      }
   }

}

