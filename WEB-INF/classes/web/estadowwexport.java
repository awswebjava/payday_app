package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class estadowwexport extends GXProcedure
{
   public estadowwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( estadowwexport.class ), "" );
   }

   public estadowwexport( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      estadowwexport.this.aP1 = new String[] {""};
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
      estadowwexport.this.aP0 = aP0;
      estadowwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV54CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      estadowwexport.this.GXt_int1 = GXv_int2[0] ;
      AV54CliCod = GXt_int1 ;
      GXt_boolean3 = AV8IsAuthorized ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSituacion", GXv_boolean4) ;
      estadowwexport.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV8IsAuthorized = GXt_boolean3 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV66Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext5[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext5) ;
         AV9WWPContext = GXv_SdtWWPContext5[0] ;
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
      AV12Filename = "EstadoWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV37TFSitCodigo_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Código", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         estadowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV53i = 1 ;
         AV67GXV1 = 1 ;
         while ( AV67GXV1 <= AV37TFSitCodigo_Sels.size() )
         {
            AV38TFSitCodigo_Sel = (String)AV37TFSitCodigo_Sels.elementAt(-1+AV67GXV1) ;
            if ( AV53i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFSitCodigo_Sel, GXv_char9) ;
            estadowwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV53i = (long)(AV53i+1) ;
            AV67GXV1 = (int)(AV67GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV36TFSitCodigo)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Código", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            estadowwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV36TFSitCodigo, GXv_char9) ;
            estadowwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( ( AV41TFSitDescrip_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         estadowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV53i = 1 ;
         AV68GXV2 = 1 ;
         while ( AV68GXV2 <= AV41TFSitDescrip_Sels.size() )
         {
            AV42TFSitDescrip_Sel = (String)AV41TFSitDescrip_Sels.elementAt(-1+AV68GXV2) ;
            if ( AV53i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV42TFSitDescrip_Sel, GXv_char9) ;
            estadowwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV53i = (long)(AV53i+1) ;
            AV68GXV2 = (int)(AV68GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV40TFSitDescrip)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            estadowwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFSitDescrip, GXv_char9) ;
            estadowwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( (0==AV43TFSitEsLicencia_Sel) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Es Licencia", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         estadowwexport.this.AV14CellRow = GXv_int7[0] ;
         if ( AV43TFSitEsLicencia_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV43TFSitEsLicencia_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( (0==AV44TFSitLicCuentaTrab_Sel) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Es remunerada", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         estadowwexport.this.AV14CellRow = GXv_int7[0] ;
         if ( AV44TFSitLicCuentaTrab_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV44TFSitLicCuentaTrab_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( (0==AV45TFSitEsAusencia_Sel) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Es Ausencia", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         estadowwexport.this.AV14CellRow = GXv_int7[0] ;
         if ( AV45TFSitEsAusencia_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV45TFSitEsAusencia_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( (0==AV46TFSitAbsorbeFer_Sel) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Absorbe feriado", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         estadowwexport.this.AV14CellRow = GXv_int7[0] ;
         if ( AV46TFSitAbsorbeFer_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV46TFSitAbsorbeFer_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( (0==AV47TFEstadoSitRevista) && (0==AV48TFEstadoSitRevista_To) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Situación de revista AFIP", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         estadowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV47TFEstadoSitRevista );
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, false, GXv_int7, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         estadowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV48TFEstadoSitRevista_To );
      }
      if ( ! ( ( AV51TFEstadoSiniestro_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Siniestrado AFIP", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         estadowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV53i = 1 ;
         AV69GXV3 = 1 ;
         while ( AV69GXV3 <= AV51TFEstadoSiniestro_Sels.size() )
         {
            AV52TFEstadoSiniestro_Sel = (String)AV51TFEstadoSiniestro_Sels.elementAt(-1+AV69GXV3) ;
            if ( AV53i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV52TFEstadoSiniestro_Sel, GXv_char9) ;
            estadowwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV53i = (long)(AV53i+1) ;
            AV69GXV3 = (int)(AV69GXV3+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV50TFEstadoSiniestro)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Siniestrado AFIP", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            estadowwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV50TFEstadoSiniestro, GXv_char9) ;
            estadowwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( (0==AV57TFEstadoCanPresen_Sel) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Cancela presentismo (para fuera de convenio)", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         estadowwexport.this.AV14CellRow = GXv_int7[0] ;
         if ( AV57TFEstadoCanPresen_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV57TFEstadoCanPresen_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( (0==AV58TFEstadoRemCorr_Sel) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Remunera días corridos para jornales", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         estadowwexport.this.AV14CellRow = GXv_int7[0] ;
         if ( AV58TFEstadoRemCorr_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV58TFEstadoRemCorr_Sel == 2 )
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
      if ( GXutil.strcmp(AV20Session.getValue("EstadoWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("EstadoWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV70GXV4 = 1 ;
      while ( AV70GXV4 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV70GXV4));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV70GXV4 = (int)(AV70GXV4+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV72Estadowwds_1_tfsitcodigo = AV36TFSitCodigo ;
      AV73Estadowwds_2_tfsitcodigo_sels = AV37TFSitCodigo_Sels ;
      AV74Estadowwds_3_tfsitdescrip = AV40TFSitDescrip ;
      AV75Estadowwds_4_tfsitdescrip_sels = AV41TFSitDescrip_Sels ;
      AV76Estadowwds_5_tfsiteslicencia_sel = AV43TFSitEsLicencia_Sel ;
      AV77Estadowwds_6_tfsitliccuentatrab_sel = AV44TFSitLicCuentaTrab_Sel ;
      AV78Estadowwds_7_tfsitesausencia_sel = AV45TFSitEsAusencia_Sel ;
      AV79Estadowwds_8_tfsitabsorbefer_sel = AV46TFSitAbsorbeFer_Sel ;
      AV80Estadowwds_9_tfestadositrevista = AV47TFEstadoSitRevista ;
      AV81Estadowwds_10_tfestadositrevista_to = AV48TFEstadoSitRevista_To ;
      AV82Estadowwds_11_tfestadosiniestro = AV50TFEstadoSiniestro ;
      AV83Estadowwds_12_tfestadosiniestro_sels = AV51TFEstadoSiniestro_Sels ;
      AV84Estadowwds_13_tfestadocanpresen_sel = AV57TFEstadoCanPresen_Sel ;
      AV85Estadowwds_14_tfestadoremcorr_sel = AV58TFEstadoRemCorr_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A16SitCodigo ,
                                           AV73Estadowwds_2_tfsitcodigo_sels ,
                                           A334SitDescrip ,
                                           AV75Estadowwds_4_tfsitdescrip_sels ,
                                           A1600EstadoSiniestro ,
                                           AV83Estadowwds_12_tfestadosiniestro_sels ,
                                           Integer.valueOf(AV73Estadowwds_2_tfsitcodigo_sels.size()) ,
                                           AV72Estadowwds_1_tfsitcodigo ,
                                           Integer.valueOf(AV75Estadowwds_4_tfsitdescrip_sels.size()) ,
                                           AV74Estadowwds_3_tfsitdescrip ,
                                           Byte.valueOf(AV76Estadowwds_5_tfsiteslicencia_sel) ,
                                           Byte.valueOf(AV77Estadowwds_6_tfsitliccuentatrab_sel) ,
                                           Byte.valueOf(AV78Estadowwds_7_tfsitesausencia_sel) ,
                                           Byte.valueOf(AV79Estadowwds_8_tfsitabsorbefer_sel) ,
                                           Short.valueOf(AV80Estadowwds_9_tfestadositrevista) ,
                                           Short.valueOf(AV81Estadowwds_10_tfestadositrevista_to) ,
                                           Integer.valueOf(AV83Estadowwds_12_tfestadosiniestro_sels.size()) ,
                                           AV82Estadowwds_11_tfestadosiniestro ,
                                           Byte.valueOf(AV84Estadowwds_13_tfestadocanpresen_sel) ,
                                           Byte.valueOf(AV85Estadowwds_14_tfestadoremcorr_sel) ,
                                           Short.valueOf(AV56PaiCod) ,
                                           Boolean.valueOf(A738SitEsLicencia) ,
                                           Boolean.valueOf(A739SitLicCuentaTrab) ,
                                           Boolean.valueOf(A916SitEsAusencia) ,
                                           Boolean.valueOf(A1220SitAbsorbeFer) ,
                                           Short.valueOf(A1598EstadoSitRevista) ,
                                           Boolean.valueOf(A1807EstadoCanPresen) ,
                                           Boolean.valueOf(A1809EstadoRemCorr) ,
                                           Short.valueOf(A1593SitPaiCod) ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.BOOLEAN,
                                           TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.SHORT,
                                           TypeConstants.BOOLEAN
                                           }
      });
      lV72Estadowwds_1_tfsitcodigo = GXutil.padr( GXutil.rtrim( AV72Estadowwds_1_tfsitcodigo), 4, "%") ;
      lV74Estadowwds_3_tfsitdescrip = GXutil.concat( GXutil.rtrim( AV74Estadowwds_3_tfsitdescrip), "%", "") ;
      lV82Estadowwds_11_tfestadosiniestro = GXutil.padr( GXutil.rtrim( AV82Estadowwds_11_tfestadosiniestro), 4, "%") ;
      /* Using cursor P01K02 */
      pr_default.execute(0, new Object[] {lV72Estadowwds_1_tfsitcodigo, lV74Estadowwds_3_tfsitdescrip, Short.valueOf(AV80Estadowwds_9_tfestadositrevista), Short.valueOf(AV81Estadowwds_10_tfestadositrevista_to), lV82Estadowwds_11_tfestadosiniestro, Short.valueOf(AV56PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1593SitPaiCod = P01K02_A1593SitPaiCod[0] ;
         n1593SitPaiCod = P01K02_n1593SitPaiCod[0] ;
         A1809EstadoRemCorr = P01K02_A1809EstadoRemCorr[0] ;
         A1807EstadoCanPresen = P01K02_A1807EstadoCanPresen[0] ;
         A1600EstadoSiniestro = P01K02_A1600EstadoSiniestro[0] ;
         n1600EstadoSiniestro = P01K02_n1600EstadoSiniestro[0] ;
         A1598EstadoSitRevista = P01K02_A1598EstadoSitRevista[0] ;
         n1598EstadoSitRevista = P01K02_n1598EstadoSitRevista[0] ;
         A1220SitAbsorbeFer = P01K02_A1220SitAbsorbeFer[0] ;
         A916SitEsAusencia = P01K02_A916SitEsAusencia[0] ;
         A739SitLicCuentaTrab = P01K02_A739SitLicCuentaTrab[0] ;
         A738SitEsLicencia = P01K02_A738SitEsLicencia[0] ;
         A334SitDescrip = P01K02_A334SitDescrip[0] ;
         A16SitCodigo = P01K02_A16SitCodigo[0] ;
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
         AV86GXV5 = 1 ;
         while ( AV86GXV5 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV86GXV5));
            if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SitCodigo") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A16SitCodigo, GXv_char9) ;
                  estadowwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SitDescrip") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A334SitDescrip, GXv_char9) ;
                  estadowwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SitEsLicencia") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A738SitEsLicencia) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SitLicCuentaTrab") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A739SitLicCuentaTrab) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SitEsAusencia") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A916SitEsAusencia) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SitAbsorbeFer") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1220SitAbsorbeFer) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EstadoSitRevista") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1598EstadoSitRevista );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EstadoSiniestro") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1600EstadoSiniestro, GXv_char9) ;
                  estadowwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EstadoCanPresen") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1807EstadoCanPresen) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EstadoRemCorr") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1809EstadoRemCorr) );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV86GXV5 = (int)(AV86GXV5+1) ;
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
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "SitCodigo", "", "Código", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "SitDescrip", "", "Descripción", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "SitEsLicencia", "", "Es Licencia", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "SitLicCuentaTrab", "", "Es remunerada", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "SitEsAusencia", "", "Es Ausencia", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "SitAbsorbeFer", "", "Absorbe feriado", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "EstadoSitRevista", "", "Situación de revista AFIP", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "EstadoSiniestro", "", "Siniestrado AFIP", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "EstadoCanPresen", "", "Cancela presentismo (para fuera de convenio)", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "EstadoRemCorr", "", "Remunera días corridos para jornales", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      if ( ( ( AV87Esconceptosdefault.doubleValue() == ( 1 )) ) )
      {
         GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&VerSVG", "", "", true, "") ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "", "", "", false, "") ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      }
      if ( ( ( AV88Paises.doubleValue() == ( 1 )) ) )
      {
         GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&ModificarSVG", "", "", true, "") ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "", "", "", false, "") ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      }
      if ( ( ( AV88Paises.doubleValue() == ( 1 )) ) )
      {
         GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&EliminarSVG", "", "", true, "") ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "", "", "", false, "") ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      }
      GXt_char8 = AV28UserCustomValue ;
      GXv_char9[0] = GXt_char8 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "EstadoWWColumnsSelector", GXv_char9) ;
      estadowwexport.this.GXt_char8 = GXv_char9[0] ;
      AV28UserCustomValue = GXt_char8 ;
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

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("EstadoWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "EstadoWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("EstadoWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV89GXV6 = 1 ;
      while ( AV89GXV6 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV89GXV6));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSITCODIGO") == 0 )
         {
            AV36TFSitCodigo = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSITCODIGO_SEL") == 0 )
         {
            AV35TFSitCodigo_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV37TFSitCodigo_Sels.fromJSonString(AV35TFSitCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSITDESCRIP") == 0 )
         {
            AV40TFSitDescrip = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSITDESCRIP_SEL") == 0 )
         {
            AV39TFSitDescrip_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV41TFSitDescrip_Sels.fromJSonString(AV39TFSitDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSITESLICENCIA_SEL") == 0 )
         {
            AV43TFSitEsLicencia_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSITLICCUENTATRAB_SEL") == 0 )
         {
            AV44TFSitLicCuentaTrab_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSITESAUSENCIA_SEL") == 0 )
         {
            AV45TFSitEsAusencia_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSITABSORBEFER_SEL") == 0 )
         {
            AV46TFSitAbsorbeFer_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESTADOSITREVISTA") == 0 )
         {
            AV47TFEstadoSitRevista = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV48TFEstadoSitRevista_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESTADOSINIESTRO") == 0 )
         {
            AV50TFEstadoSiniestro = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESTADOSINIESTRO_SEL") == 0 )
         {
            AV49TFEstadoSiniestro_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV51TFEstadoSiniestro_Sels.fromJSonString(AV49TFEstadoSiniestro_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESTADOCANPRESEN_SEL") == 0 )
         {
            AV57TFEstadoCanPresen_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESTADOREMCORR_SEL") == 0 )
         {
            AV58TFEstadoRemCorr_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV61MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV89GXV6 = (int)(AV89GXV6+1) ;
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
      this.aP0[0] = estadowwexport.this.AV12Filename;
      this.aP1[0] = estadowwexport.this.AV13ErrorMessage;
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
      GXv_boolean4 = new boolean[1] ;
      AV66Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV37TFSitCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV38TFSitCodigo_Sel = "" ;
      AV36TFSitCodigo = "" ;
      AV41TFSitDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42TFSitDescrip_Sel = "" ;
      AV40TFSitDescrip = "" ;
      AV51TFEstadoSiniestro_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV52TFEstadoSiniestro_Sel = "" ;
      AV50TFEstadoSiniestro = "" ;
      GXv_exceldoc6 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int7 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A16SitCodigo = "" ;
      A334SitDescrip = "" ;
      A1600EstadoSiniestro = "" ;
      AV72Estadowwds_1_tfsitcodigo = "" ;
      AV73Estadowwds_2_tfsitcodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV74Estadowwds_3_tfsitdescrip = "" ;
      AV75Estadowwds_4_tfsitdescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV82Estadowwds_11_tfestadosiniestro = "" ;
      AV83Estadowwds_12_tfestadosiniestro_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV72Estadowwds_1_tfsitcodigo = "" ;
      lV74Estadowwds_3_tfsitdescrip = "" ;
      lV82Estadowwds_11_tfestadosiniestro = "" ;
      P01K02_A1593SitPaiCod = new short[1] ;
      P01K02_n1593SitPaiCod = new boolean[] {false} ;
      P01K02_A1809EstadoRemCorr = new boolean[] {false} ;
      P01K02_A1807EstadoCanPresen = new boolean[] {false} ;
      P01K02_A1600EstadoSiniestro = new String[] {""} ;
      P01K02_n1600EstadoSiniestro = new boolean[] {false} ;
      P01K02_A1598EstadoSitRevista = new short[1] ;
      P01K02_n1598EstadoSitRevista = new boolean[] {false} ;
      P01K02_A1220SitAbsorbeFer = new boolean[] {false} ;
      P01K02_A916SitEsAusencia = new boolean[] {false} ;
      P01K02_A739SitLicCuentaTrab = new boolean[] {false} ;
      P01K02_A738SitEsLicencia = new boolean[] {false} ;
      P01K02_A334SitDescrip = new String[] {""} ;
      P01K02_A16SitCodigo = new String[] {""} ;
      AV87Esconceptosdefault = DecimalUtil.ZERO ;
      AV88Paises = DecimalUtil.ZERO ;
      AV28UserCustomValue = "" ;
      GXt_char8 = "" ;
      GXv_char9 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector10 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector11 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV35TFSitCodigo_SelsJson = "" ;
      AV39TFSitDescrip_SelsJson = "" ;
      AV49TFEstadoSiniestro_SelsJson = "" ;
      AV61MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.estadowwexport__default(),
         new Object[] {
             new Object[] {
            P01K02_A1593SitPaiCod, P01K02_n1593SitPaiCod, P01K02_A1809EstadoRemCorr, P01K02_A1807EstadoCanPresen, P01K02_A1600EstadoSiniestro, P01K02_n1600EstadoSiniestro, P01K02_A1598EstadoSitRevista, P01K02_n1598EstadoSitRevista, P01K02_A1220SitAbsorbeFer, P01K02_A916SitEsAusencia,
            P01K02_A739SitLicCuentaTrab, P01K02_A738SitEsLicencia, P01K02_A334SitDescrip, P01K02_A16SitCodigo
            }
         }
      );
      AV66Pgmname = "EstadoWWExport" ;
      /* GeneXus formulas. */
      AV66Pgmname = "EstadoWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV43TFSitEsLicencia_Sel ;
   private byte AV44TFSitLicCuentaTrab_Sel ;
   private byte AV45TFSitEsAusencia_Sel ;
   private byte AV46TFSitAbsorbeFer_Sel ;
   private byte AV57TFEstadoCanPresen_Sel ;
   private byte AV58TFEstadoRemCorr_Sel ;
   private byte AV76Estadowwds_5_tfsiteslicencia_sel ;
   private byte AV77Estadowwds_6_tfsitliccuentatrab_sel ;
   private byte AV78Estadowwds_7_tfsitesausencia_sel ;
   private byte AV79Estadowwds_8_tfsitabsorbefer_sel ;
   private byte AV84Estadowwds_13_tfestadocanpresen_sel ;
   private byte AV85Estadowwds_14_tfestadoremcorr_sel ;
   private short AV47TFEstadoSitRevista ;
   private short AV48TFEstadoSitRevista_To ;
   private short GXv_int7[] ;
   private short A1598EstadoSitRevista ;
   private short AV80Estadowwds_9_tfestadositrevista ;
   private short AV81Estadowwds_10_tfestadositrevista_to ;
   private short AV56PaiCod ;
   private short A1593SitPaiCod ;
   private short AV18OrderedBy ;
   private short Gx_err ;
   private int AV54CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV67GXV1 ;
   private int AV68GXV2 ;
   private int AV69GXV3 ;
   private int AV70GXV4 ;
   private int AV73Estadowwds_2_tfsitcodigo_sels_size ;
   private int AV75Estadowwds_4_tfsitdescrip_sels_size ;
   private int AV83Estadowwds_12_tfestadosiniestro_sels_size ;
   private int AV86GXV5 ;
   private int AV89GXV6 ;
   private long AV53i ;
   private long AV32VisibleColumnCount ;
   private java.math.BigDecimal AV87Esconceptosdefault ;
   private java.math.BigDecimal AV88Paises ;
   private String AV66Pgmname ;
   private String AV38TFSitCodigo_Sel ;
   private String AV36TFSitCodigo ;
   private String AV52TFEstadoSiniestro_Sel ;
   private String AV50TFEstadoSiniestro ;
   private String A16SitCodigo ;
   private String A1600EstadoSiniestro ;
   private String AV72Estadowwds_1_tfsitcodigo ;
   private String AV82Estadowwds_11_tfestadosiniestro ;
   private String scmdbuf ;
   private String lV72Estadowwds_1_tfsitcodigo ;
   private String lV82Estadowwds_11_tfestadosiniestro ;
   private String GXt_char8 ;
   private String GXv_char9[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean3 ;
   private boolean GXv_boolean4[] ;
   private boolean returnInSub ;
   private boolean A738SitEsLicencia ;
   private boolean A739SitLicCuentaTrab ;
   private boolean A916SitEsAusencia ;
   private boolean A1220SitAbsorbeFer ;
   private boolean A1807EstadoCanPresen ;
   private boolean A1809EstadoRemCorr ;
   private boolean AV19OrderedDsc ;
   private boolean n1593SitPaiCod ;
   private boolean n1600EstadoSiniestro ;
   private boolean n1598EstadoSitRevista ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV35TFSitCodigo_SelsJson ;
   private String AV39TFSitDescrip_SelsJson ;
   private String AV49TFEstadoSiniestro_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV42TFSitDescrip_Sel ;
   private String AV40TFSitDescrip ;
   private String A334SitDescrip ;
   private String AV74Estadowwds_3_tfsitdescrip ;
   private String lV74Estadowwds_3_tfsitdescrip ;
   private String AV61MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV37TFSitCodigo_Sels ;
   private GXSimpleCollection<String> AV51TFEstadoSiniestro_Sels ;
   private GXSimpleCollection<String> AV41TFSitDescrip_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private short[] P01K02_A1593SitPaiCod ;
   private boolean[] P01K02_n1593SitPaiCod ;
   private boolean[] P01K02_A1809EstadoRemCorr ;
   private boolean[] P01K02_A1807EstadoCanPresen ;
   private String[] P01K02_A1600EstadoSiniestro ;
   private boolean[] P01K02_n1600EstadoSiniestro ;
   private short[] P01K02_A1598EstadoSitRevista ;
   private boolean[] P01K02_n1598EstadoSitRevista ;
   private boolean[] P01K02_A1220SitAbsorbeFer ;
   private boolean[] P01K02_A916SitEsAusencia ;
   private boolean[] P01K02_A739SitLicCuentaTrab ;
   private boolean[] P01K02_A738SitEsLicencia ;
   private String[] P01K02_A334SitDescrip ;
   private String[] P01K02_A16SitCodigo ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc6[] ;
   private GXSimpleCollection<String> AV73Estadowwds_2_tfsitcodigo_sels ;
   private GXSimpleCollection<String> AV83Estadowwds_12_tfestadosiniestro_sels ;
   private GXSimpleCollection<String> AV75Estadowwds_4_tfsitdescrip_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV24ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV25ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector10[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector11[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV26ColumnsSelector_Column ;
}

final  class estadowwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01K02( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A16SitCodigo ,
                                          GXSimpleCollection<String> AV73Estadowwds_2_tfsitcodigo_sels ,
                                          String A334SitDescrip ,
                                          GXSimpleCollection<String> AV75Estadowwds_4_tfsitdescrip_sels ,
                                          String A1600EstadoSiniestro ,
                                          GXSimpleCollection<String> AV83Estadowwds_12_tfestadosiniestro_sels ,
                                          int AV73Estadowwds_2_tfsitcodigo_sels_size ,
                                          String AV72Estadowwds_1_tfsitcodigo ,
                                          int AV75Estadowwds_4_tfsitdescrip_sels_size ,
                                          String AV74Estadowwds_3_tfsitdescrip ,
                                          byte AV76Estadowwds_5_tfsiteslicencia_sel ,
                                          byte AV77Estadowwds_6_tfsitliccuentatrab_sel ,
                                          byte AV78Estadowwds_7_tfsitesausencia_sel ,
                                          byte AV79Estadowwds_8_tfsitabsorbefer_sel ,
                                          short AV80Estadowwds_9_tfestadositrevista ,
                                          short AV81Estadowwds_10_tfestadositrevista_to ,
                                          int AV83Estadowwds_12_tfestadosiniestro_sels_size ,
                                          String AV82Estadowwds_11_tfestadosiniestro ,
                                          byte AV84Estadowwds_13_tfestadocanpresen_sel ,
                                          byte AV85Estadowwds_14_tfestadoremcorr_sel ,
                                          short AV56PaiCod ,
                                          boolean A738SitEsLicencia ,
                                          boolean A739SitLicCuentaTrab ,
                                          boolean A916SitEsAusencia ,
                                          boolean A1220SitAbsorbeFer ,
                                          short A1598EstadoSitRevista ,
                                          boolean A1807EstadoCanPresen ,
                                          boolean A1809EstadoRemCorr ,
                                          short A1593SitPaiCod ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int12 = new byte[6];
      Object[] GXv_Object13 = new Object[2];
      scmdbuf = "SELECT SitPaiCod, EstadoRemCorr, EstadoCanPresen, EstadoSiniestro, EstadoSitRevista, SitAbsorbeFer, SitEsAusencia, SitLicCuentaTrab, SitEsLicencia, SitDescrip, SitCodigo" ;
      scmdbuf += " FROM Estado" ;
      if ( ( AV73Estadowwds_2_tfsitcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV72Estadowwds_1_tfsitcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SitCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int12[0] = (byte)(1) ;
      }
      if ( AV73Estadowwds_2_tfsitcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV73Estadowwds_2_tfsitcodigo_sels, "SitCodigo IN (", ")")+")");
      }
      if ( ( AV75Estadowwds_4_tfsitdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV74Estadowwds_3_tfsitdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SitDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int12[1] = (byte)(1) ;
      }
      if ( AV75Estadowwds_4_tfsitdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV75Estadowwds_4_tfsitdescrip_sels, "SitDescrip IN (", ")")+")");
      }
      if ( AV76Estadowwds_5_tfsiteslicencia_sel == 1 )
      {
         addWhere(sWhereString, "(SitEsLicencia = TRUE)");
      }
      if ( AV76Estadowwds_5_tfsiteslicencia_sel == 2 )
      {
         addWhere(sWhereString, "(SitEsLicencia = FALSE)");
      }
      if ( AV77Estadowwds_6_tfsitliccuentatrab_sel == 1 )
      {
         addWhere(sWhereString, "(SitLicCuentaTrab = TRUE)");
      }
      if ( AV77Estadowwds_6_tfsitliccuentatrab_sel == 2 )
      {
         addWhere(sWhereString, "(SitLicCuentaTrab = FALSE)");
      }
      if ( AV78Estadowwds_7_tfsitesausencia_sel == 1 )
      {
         addWhere(sWhereString, "(SitEsAusencia = TRUE)");
      }
      if ( AV78Estadowwds_7_tfsitesausencia_sel == 2 )
      {
         addWhere(sWhereString, "(SitEsAusencia = FALSE)");
      }
      if ( AV79Estadowwds_8_tfsitabsorbefer_sel == 1 )
      {
         addWhere(sWhereString, "(SitAbsorbeFer = TRUE)");
      }
      if ( AV79Estadowwds_8_tfsitabsorbefer_sel == 2 )
      {
         addWhere(sWhereString, "(SitAbsorbeFer = FALSE)");
      }
      if ( ! (0==AV80Estadowwds_9_tfestadositrevista) )
      {
         addWhere(sWhereString, "(EstadoSitRevista >= ?)");
      }
      else
      {
         GXv_int12[2] = (byte)(1) ;
      }
      if ( ! (0==AV81Estadowwds_10_tfestadositrevista_to) )
      {
         addWhere(sWhereString, "(EstadoSitRevista <= ?)");
      }
      else
      {
         GXv_int12[3] = (byte)(1) ;
      }
      if ( ( AV83Estadowwds_12_tfestadosiniestro_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV82Estadowwds_11_tfestadosiniestro)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(EstadoSiniestro) like LOWER(?))");
      }
      else
      {
         GXv_int12[4] = (byte)(1) ;
      }
      if ( AV83Estadowwds_12_tfestadosiniestro_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV83Estadowwds_12_tfestadosiniestro_sels, "EstadoSiniestro IN (", ")")+")");
      }
      if ( AV84Estadowwds_13_tfestadocanpresen_sel == 1 )
      {
         addWhere(sWhereString, "(EstadoCanPresen = TRUE)");
      }
      if ( AV84Estadowwds_13_tfestadocanpresen_sel == 2 )
      {
         addWhere(sWhereString, "(EstadoCanPresen = FALSE)");
      }
      if ( AV85Estadowwds_14_tfestadoremcorr_sel == 1 )
      {
         addWhere(sWhereString, "(EstadoRemCorr = TRUE)");
      }
      if ( AV85Estadowwds_14_tfestadoremcorr_sel == 2 )
      {
         addWhere(sWhereString, "(EstadoRemCorr = FALSE)");
      }
      if ( ! (0==AV56PaiCod) )
      {
         addWhere(sWhereString, "(SitPaiCod = ?)");
      }
      else
      {
         GXv_int12[5] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY SitCodigo" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY SitCodigo DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY SitDescrip" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY SitDescrip DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY SitEsLicencia" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY SitEsLicencia DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY SitLicCuentaTrab" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY SitLicCuentaTrab DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY SitEsAusencia" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY SitEsAusencia DESC" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY SitAbsorbeFer" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY SitAbsorbeFer DESC" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY EstadoSitRevista" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EstadoSitRevista DESC" ;
      }
      else if ( ( AV18OrderedBy == 8 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY EstadoSiniestro" ;
      }
      else if ( ( AV18OrderedBy == 8 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EstadoSiniestro DESC" ;
      }
      else if ( ( AV18OrderedBy == 9 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY EstadoCanPresen" ;
      }
      else if ( ( AV18OrderedBy == 9 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EstadoCanPresen DESC" ;
      }
      else if ( ( AV18OrderedBy == 10 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY EstadoRemCorr" ;
      }
      else if ( ( AV18OrderedBy == 10 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EstadoRemCorr DESC" ;
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
                  return conditional_P01K02(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).byteValue() , ((Number) dynConstraints[11]).byteValue() , ((Number) dynConstraints[12]).byteValue() , ((Number) dynConstraints[13]).byteValue() , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).byteValue() , ((Number) dynConstraints[19]).byteValue() , ((Number) dynConstraints[20]).shortValue() , ((Boolean) dynConstraints[21]).booleanValue() , ((Boolean) dynConstraints[22]).booleanValue() , ((Boolean) dynConstraints[23]).booleanValue() , ((Boolean) dynConstraints[24]).booleanValue() , ((Number) dynConstraints[25]).shortValue() , ((Boolean) dynConstraints[26]).booleanValue() , ((Boolean) dynConstraints[27]).booleanValue() , ((Number) dynConstraints[28]).shortValue() , ((Number) dynConstraints[29]).shortValue() , ((Boolean) dynConstraints[30]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01K02", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((boolean[]) buf[2])[0] = rslt.getBoolean(2);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(3);
               ((String[]) buf[4])[0] = rslt.getString(4, 4);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((short[]) buf[6])[0] = rslt.getShort(5);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((boolean[]) buf[8])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(8);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(9);
               ((String[]) buf[12])[0] = rslt.getVarchar(10);
               ((String[]) buf[13])[0] = rslt.getString(11, 4);
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
                  stmt.setString(sIdx, (String)parms[6], 4);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[8]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[10], 4);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               return;
      }
   }

}

