package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class feriadowwexport extends GXProcedure
{
   public feriadowwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( feriadowwexport.class ), "" );
   }

   public feriadowwexport( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      feriadowwexport.this.aP1 = new String[] {""};
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
      feriadowwexport.this.aP0 = aP0;
      feriadowwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWferiado", GXv_boolean2) ;
      feriadowwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV70Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "feriadoWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV37TFFerId_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Id", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         feriadowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV63i = 1 ;
         AV71GXV1 = 1 ;
         while ( AV71GXV1 <= AV37TFFerId_Sels.size() )
         {
            AV38TFFerId_Sel = (String)AV37TFFerId_Sels.elementAt(-1+AV71GXV1) ;
            if ( AV63i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFFerId_Sel, GXv_char7) ;
            feriadowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV63i = (long)(AV63i+1) ;
            AV71GXV1 = (int)(AV71GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV36TFFerId)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Id", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            feriadowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV36TFFerId, GXv_char7) ;
            feriadowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV40TFFeriadoTipo_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         feriadowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV63i = 1 ;
         AV72GXV2 = 1 ;
         while ( AV72GXV2 <= AV40TFFeriadoTipo_Sels.size() )
         {
            AV41TFFeriadoTipo_Sel = (String)AV40TFFeriadoTipo_Sels.elementAt(-1+AV72GXV2) ;
            if ( AV63i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaintipo_feriado.getDescription(httpContext,(String)AV41TFFeriadoTipo_Sel), "") );
            AV63i = (long)(AV63i+1) ;
            AV72GXV2 = (int)(AV72GXV2+1) ;
         }
      }
      if ( ! ( ( AV49TFFerDescrip_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         feriadowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV63i = 1 ;
         AV73GXV3 = 1 ;
         while ( AV73GXV3 <= AV49TFFerDescrip_Sels.size() )
         {
            AV50TFFerDescrip_Sel = (String)AV49TFFerDescrip_Sels.elementAt(-1+AV73GXV3) ;
            if ( AV63i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV50TFFerDescrip_Sel, GXv_char7) ;
            feriadowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV63i = (long)(AV63i+1) ;
            AV73GXV3 = (int)(AV73GXV3+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV48TFFerDescrip)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            feriadowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV48TFFerDescrip, GXv_char7) ;
            feriadowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV53TFFerReligId_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Religión", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         feriadowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV63i = 1 ;
         AV74GXV4 = 1 ;
         while ( AV74GXV4 <= AV53TFFerReligId_Sels.size() )
         {
            AV54TFFerReligId_Sel = (String)AV53TFFerReligId_Sels.elementAt(-1+AV74GXV4) ;
            if ( AV63i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV54TFFerReligId_Sel, GXv_char7) ;
            feriadowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV63i = (long)(AV63i+1) ;
            AV74GXV4 = (int)(AV74GXV4+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV52TFFerReligId)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Religión", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            feriadowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV52TFFerReligId, GXv_char7) ;
            feriadowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV57TFFerOrigId_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Origen", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         feriadowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV63i = 1 ;
         AV75GXV5 = 1 ;
         while ( AV75GXV5 <= AV57TFFerOrigId_Sels.size() )
         {
            AV58TFFerOrigId_Sel = (String)AV57TFFerOrigId_Sels.elementAt(-1+AV75GXV5) ;
            if ( AV63i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV58TFFerOrigId_Sel, GXv_char7) ;
            feriadowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV63i = (long)(AV63i+1) ;
            AV75GXV5 = (int)(AV75GXV5+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV56TFFerOrigId)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Origen", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            feriadowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV56TFFerOrigId, GXv_char7) ;
            feriadowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV61TFFeriadoConvenio_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Convenio", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         feriadowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV63i = 1 ;
         AV76GXV6 = 1 ;
         while ( AV76GXV6 <= AV61TFFeriadoConvenio_Sels.size() )
         {
            AV62TFFeriadoConvenio_Sel = (String)AV61TFFeriadoConvenio_Sels.elementAt(-1+AV76GXV6) ;
            if ( AV63i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV62TFFeriadoConvenio_Sel, GXv_char7) ;
            feriadowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV63i = (long)(AV63i+1) ;
            AV76GXV6 = (int)(AV76GXV6+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV60TFFeriadoConvenio)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Convenio", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            feriadowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV60TFFeriadoConvenio, GXv_char7) ;
            feriadowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("feriadoWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("feriadoWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV77GXV7 = 1 ;
      while ( AV77GXV7 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV77GXV7));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV77GXV7 = (int)(AV77GXV7+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV79Feriadowwds_1_tfferid = AV36TFFerId ;
      AV80Feriadowwds_2_tfferid_sels = AV37TFFerId_Sels ;
      AV81Feriadowwds_3_tfferiadotipo_sels = AV40TFFeriadoTipo_Sels ;
      AV82Feriadowwds_4_tfferdescrip = AV48TFFerDescrip ;
      AV83Feriadowwds_5_tfferdescrip_sels = AV49TFFerDescrip_Sels ;
      AV84Feriadowwds_6_tfferreligid = AV52TFFerReligId ;
      AV85Feriadowwds_7_tfferreligid_sels = AV53TFFerReligId_Sels ;
      AV86Feriadowwds_8_tfferorigid = AV56TFFerOrigId ;
      AV87Feriadowwds_9_tfferorigid_sels = AV57TFFerOrigId_Sels ;
      AV88Feriadowwds_10_tfferiadoconvenio = AV60TFFeriadoConvenio ;
      AV89Feriadowwds_11_tfferiadoconvenio_sels = AV61TFFeriadoConvenio_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1223FerId ,
                                           AV80Feriadowwds_2_tfferid_sels ,
                                           A1233FeriadoTipo ,
                                           AV81Feriadowwds_3_tfferiadotipo_sels ,
                                           A1228FerDescrip ,
                                           AV83Feriadowwds_5_tfferdescrip_sels ,
                                           A1230FerReligId ,
                                           AV85Feriadowwds_7_tfferreligid_sels ,
                                           A1232FerOrigId ,
                                           AV87Feriadowwds_9_tfferorigid_sels ,
                                           A1234FeriadoConvenio ,
                                           AV89Feriadowwds_11_tfferiadoconvenio_sels ,
                                           Integer.valueOf(AV80Feriadowwds_2_tfferid_sels.size()) ,
                                           AV79Feriadowwds_1_tfferid ,
                                           Integer.valueOf(AV81Feriadowwds_3_tfferiadotipo_sels.size()) ,
                                           Integer.valueOf(AV83Feriadowwds_5_tfferdescrip_sels.size()) ,
                                           AV82Feriadowwds_4_tfferdescrip ,
                                           Integer.valueOf(AV85Feriadowwds_7_tfferreligid_sels.size()) ,
                                           AV84Feriadowwds_6_tfferreligid ,
                                           Integer.valueOf(AV87Feriadowwds_9_tfferorigid_sels.size()) ,
                                           AV86Feriadowwds_8_tfferorigid ,
                                           Integer.valueOf(AV89Feriadowwds_11_tfferiadoconvenio_sels.size()) ,
                                           AV88Feriadowwds_10_tfferiadoconvenio ,
                                           Short.valueOf(AV66PaiCod) ,
                                           Short.valueOf(A46PaiCod) ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV79Feriadowwds_1_tfferid = GXutil.padr( GXutil.rtrim( AV79Feriadowwds_1_tfferid), 40, "%") ;
      lV82Feriadowwds_4_tfferdescrip = GXutil.concat( GXutil.rtrim( AV82Feriadowwds_4_tfferdescrip), "%", "") ;
      lV84Feriadowwds_6_tfferreligid = GXutil.padr( GXutil.rtrim( AV84Feriadowwds_6_tfferreligid), 20, "%") ;
      lV86Feriadowwds_8_tfferorigid = GXutil.padr( GXutil.rtrim( AV86Feriadowwds_8_tfferorigid), 20, "%") ;
      lV88Feriadowwds_10_tfferiadoconvenio = GXutil.padr( GXutil.rtrim( AV88Feriadowwds_10_tfferiadoconvenio), 20, "%") ;
      /* Using cursor P01IB2 */
      pr_default.execute(0, new Object[] {lV79Feriadowwds_1_tfferid, lV82Feriadowwds_4_tfferdescrip, lV84Feriadowwds_6_tfferreligid, lV86Feriadowwds_8_tfferorigid, lV88Feriadowwds_10_tfferiadoconvenio, Short.valueOf(AV66PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A46PaiCod = P01IB2_A46PaiCod[0] ;
         A1234FeriadoConvenio = P01IB2_A1234FeriadoConvenio[0] ;
         n1234FeriadoConvenio = P01IB2_n1234FeriadoConvenio[0] ;
         A1232FerOrigId = P01IB2_A1232FerOrigId[0] ;
         n1232FerOrigId = P01IB2_n1232FerOrigId[0] ;
         A1230FerReligId = P01IB2_A1230FerReligId[0] ;
         n1230FerReligId = P01IB2_n1230FerReligId[0] ;
         A1228FerDescrip = P01IB2_A1228FerDescrip[0] ;
         A1233FeriadoTipo = P01IB2_A1233FeriadoTipo[0] ;
         A1223FerId = P01IB2_A1223FerId[0] ;
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
         AV90GXV8 = 1 ;
         while ( AV90GXV8 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV90GXV8));
            if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "FerId") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1223FerId, GXv_char7) ;
                  feriadowwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "FeriadoTipo") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaintipo_feriado.getDescription(httpContext,(String)A1233FeriadoTipo), "") );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "FerDescrip") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1228FerDescrip, GXv_char7) ;
                  feriadowwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "FerReligId") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1230FerReligId, GXv_char7) ;
                  feriadowwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "FerOrigId") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1232FerOrigId, GXv_char7) ;
                  feriadowwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "FeriadoConvenio") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1234FeriadoConvenio, GXv_char7) ;
                  feriadowwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV90GXV8 = (int)(AV90GXV8+1) ;
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
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "FerId", "", "Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "FeriadoTipo", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "FerDescrip", "", "Descripción", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "FerReligId", "", "Religión", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "FerOrigId", "", "Origen", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "FeriadoConvenio", "", "Convenio", true, "") ;
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
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "feriadoWWColumnsSelector", GXv_char7) ;
      feriadowwexport.this.GXt_char6 = GXv_char7[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("feriadoWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "feriadoWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("feriadoWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV91GXV9 = 1 ;
      while ( AV91GXV9 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV91GXV9));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERID") == 0 )
         {
            AV36TFFerId = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERID_SEL") == 0 )
         {
            AV35TFFerId_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV37TFFerId_Sels.fromJSonString(AV35TFFerId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERIADOTIPO_SEL") == 0 )
         {
            AV39TFFeriadoTipo_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV40TFFeriadoTipo_Sels.fromJSonString(AV39TFFeriadoTipo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERDESCRIP") == 0 )
         {
            AV48TFFerDescrip = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERDESCRIP_SEL") == 0 )
         {
            AV47TFFerDescrip_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV49TFFerDescrip_Sels.fromJSonString(AV47TFFerDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERRELIGID") == 0 )
         {
            AV52TFFerReligId = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERRELIGID_SEL") == 0 )
         {
            AV51TFFerReligId_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV53TFFerReligId_Sels.fromJSonString(AV51TFFerReligId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERORIGID") == 0 )
         {
            AV56TFFerOrigId = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERORIGID_SEL") == 0 )
         {
            AV55TFFerOrigId_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV57TFFerOrigId_Sels.fromJSonString(AV55TFFerOrigId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERIADOCONVENIO") == 0 )
         {
            AV60TFFeriadoConvenio = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERIADOCONVENIO_SEL") == 0 )
         {
            AV59TFFeriadoConvenio_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV61TFFeriadoConvenio_Sels.fromJSonString(AV59TFFeriadoConvenio_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV67MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV91GXV9 = (int)(AV91GXV9+1) ;
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
      this.aP0[0] = feriadowwexport.this.AV12Filename;
      this.aP1[0] = feriadowwexport.this.AV13ErrorMessage;
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
      AV70Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV37TFFerId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV38TFFerId_Sel = "" ;
      AV36TFFerId = "" ;
      AV40TFFeriadoTipo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV41TFFeriadoTipo_Sel = "" ;
      AV49TFFerDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV50TFFerDescrip_Sel = "" ;
      AV48TFFerDescrip = "" ;
      AV53TFFerReligId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV54TFFerReligId_Sel = "" ;
      AV52TFFerReligId = "" ;
      AV57TFFerOrigId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV58TFFerOrigId_Sel = "" ;
      AV56TFFerOrigId = "" ;
      AV61TFFeriadoConvenio_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV62TFFeriadoConvenio_Sel = "" ;
      AV60TFFeriadoConvenio = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A1223FerId = "" ;
      A1233FeriadoTipo = "" ;
      A1228FerDescrip = "" ;
      A1230FerReligId = "" ;
      A1232FerOrigId = "" ;
      A1234FeriadoConvenio = "" ;
      AV79Feriadowwds_1_tfferid = "" ;
      AV80Feriadowwds_2_tfferid_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV81Feriadowwds_3_tfferiadotipo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV82Feriadowwds_4_tfferdescrip = "" ;
      AV83Feriadowwds_5_tfferdescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV84Feriadowwds_6_tfferreligid = "" ;
      AV85Feriadowwds_7_tfferreligid_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV86Feriadowwds_8_tfferorigid = "" ;
      AV87Feriadowwds_9_tfferorigid_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV88Feriadowwds_10_tfferiadoconvenio = "" ;
      AV89Feriadowwds_11_tfferiadoconvenio_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV79Feriadowwds_1_tfferid = "" ;
      lV82Feriadowwds_4_tfferdescrip = "" ;
      lV84Feriadowwds_6_tfferreligid = "" ;
      lV86Feriadowwds_8_tfferorigid = "" ;
      lV88Feriadowwds_10_tfferiadoconvenio = "" ;
      P01IB2_A46PaiCod = new short[1] ;
      P01IB2_A1234FeriadoConvenio = new String[] {""} ;
      P01IB2_n1234FeriadoConvenio = new boolean[] {false} ;
      P01IB2_A1232FerOrigId = new String[] {""} ;
      P01IB2_n1232FerOrigId = new boolean[] {false} ;
      P01IB2_A1230FerReligId = new String[] {""} ;
      P01IB2_n1230FerReligId = new boolean[] {false} ;
      P01IB2_A1228FerDescrip = new String[] {""} ;
      P01IB2_A1233FeriadoTipo = new String[] {""} ;
      P01IB2_A1223FerId = new String[] {""} ;
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV35TFFerId_SelsJson = "" ;
      AV39TFFeriadoTipo_SelsJson = "" ;
      AV47TFFerDescrip_SelsJson = "" ;
      AV51TFFerReligId_SelsJson = "" ;
      AV55TFFerOrigId_SelsJson = "" ;
      AV59TFFeriadoConvenio_SelsJson = "" ;
      AV67MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.feriadowwexport__default(),
         new Object[] {
             new Object[] {
            P01IB2_A46PaiCod, P01IB2_A1234FeriadoConvenio, P01IB2_n1234FeriadoConvenio, P01IB2_A1232FerOrigId, P01IB2_n1232FerOrigId, P01IB2_A1230FerReligId, P01IB2_n1230FerReligId, P01IB2_A1228FerDescrip, P01IB2_A1233FeriadoTipo, P01IB2_A1223FerId
            }
         }
      );
      AV70Pgmname = "feriadoWWExport" ;
      /* GeneXus formulas. */
      AV70Pgmname = "feriadoWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short GXv_int5[] ;
   private short AV66PaiCod ;
   private short A46PaiCod ;
   private short AV18OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV71GXV1 ;
   private int AV72GXV2 ;
   private int AV73GXV3 ;
   private int AV74GXV4 ;
   private int AV75GXV5 ;
   private int AV76GXV6 ;
   private int AV77GXV7 ;
   private int AV80Feriadowwds_2_tfferid_sels_size ;
   private int AV81Feriadowwds_3_tfferiadotipo_sels_size ;
   private int AV83Feriadowwds_5_tfferdescrip_sels_size ;
   private int AV85Feriadowwds_7_tfferreligid_sels_size ;
   private int AV87Feriadowwds_9_tfferorigid_sels_size ;
   private int AV89Feriadowwds_11_tfferiadoconvenio_sels_size ;
   private int AV90GXV8 ;
   private int AV91GXV9 ;
   private long AV63i ;
   private long AV32VisibleColumnCount ;
   private String AV70Pgmname ;
   private String AV38TFFerId_Sel ;
   private String AV36TFFerId ;
   private String AV41TFFeriadoTipo_Sel ;
   private String AV54TFFerReligId_Sel ;
   private String AV52TFFerReligId ;
   private String AV58TFFerOrigId_Sel ;
   private String AV56TFFerOrigId ;
   private String AV62TFFeriadoConvenio_Sel ;
   private String AV60TFFeriadoConvenio ;
   private String A1223FerId ;
   private String A1233FeriadoTipo ;
   private String A1230FerReligId ;
   private String A1232FerOrigId ;
   private String A1234FeriadoConvenio ;
   private String AV79Feriadowwds_1_tfferid ;
   private String AV84Feriadowwds_6_tfferreligid ;
   private String AV86Feriadowwds_8_tfferorigid ;
   private String AV88Feriadowwds_10_tfferiadoconvenio ;
   private String scmdbuf ;
   private String lV79Feriadowwds_1_tfferid ;
   private String lV84Feriadowwds_6_tfferreligid ;
   private String lV86Feriadowwds_8_tfferorigid ;
   private String lV88Feriadowwds_10_tfferiadoconvenio ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV19OrderedDsc ;
   private boolean n1234FeriadoConvenio ;
   private boolean n1232FerOrigId ;
   private boolean n1230FerReligId ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV35TFFerId_SelsJson ;
   private String AV39TFFeriadoTipo_SelsJson ;
   private String AV47TFFerDescrip_SelsJson ;
   private String AV51TFFerReligId_SelsJson ;
   private String AV55TFFerOrigId_SelsJson ;
   private String AV59TFFeriadoConvenio_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV50TFFerDescrip_Sel ;
   private String AV48TFFerDescrip ;
   private String A1228FerDescrip ;
   private String AV82Feriadowwds_4_tfferdescrip ;
   private String lV82Feriadowwds_4_tfferdescrip ;
   private String AV67MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV37TFFerId_Sels ;
   private GXSimpleCollection<String> AV40TFFeriadoTipo_Sels ;
   private GXSimpleCollection<String> AV53TFFerReligId_Sels ;
   private GXSimpleCollection<String> AV57TFFerOrigId_Sels ;
   private GXSimpleCollection<String> AV61TFFeriadoConvenio_Sels ;
   private GXSimpleCollection<String> AV49TFFerDescrip_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private short[] P01IB2_A46PaiCod ;
   private String[] P01IB2_A1234FeriadoConvenio ;
   private boolean[] P01IB2_n1234FeriadoConvenio ;
   private String[] P01IB2_A1232FerOrigId ;
   private boolean[] P01IB2_n1232FerOrigId ;
   private String[] P01IB2_A1230FerReligId ;
   private boolean[] P01IB2_n1230FerReligId ;
   private String[] P01IB2_A1228FerDescrip ;
   private String[] P01IB2_A1233FeriadoTipo ;
   private String[] P01IB2_A1223FerId ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV80Feriadowwds_2_tfferid_sels ;
   private GXSimpleCollection<String> AV81Feriadowwds_3_tfferiadotipo_sels ;
   private GXSimpleCollection<String> AV85Feriadowwds_7_tfferreligid_sels ;
   private GXSimpleCollection<String> AV87Feriadowwds_9_tfferorigid_sels ;
   private GXSimpleCollection<String> AV89Feriadowwds_11_tfferiadoconvenio_sels ;
   private GXSimpleCollection<String> AV83Feriadowwds_5_tfferdescrip_sels ;
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

final  class feriadowwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01IB2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1223FerId ,
                                          GXSimpleCollection<String> AV80Feriadowwds_2_tfferid_sels ,
                                          String A1233FeriadoTipo ,
                                          GXSimpleCollection<String> AV81Feriadowwds_3_tfferiadotipo_sels ,
                                          String A1228FerDescrip ,
                                          GXSimpleCollection<String> AV83Feriadowwds_5_tfferdescrip_sels ,
                                          String A1230FerReligId ,
                                          GXSimpleCollection<String> AV85Feriadowwds_7_tfferreligid_sels ,
                                          String A1232FerOrigId ,
                                          GXSimpleCollection<String> AV87Feriadowwds_9_tfferorigid_sels ,
                                          String A1234FeriadoConvenio ,
                                          GXSimpleCollection<String> AV89Feriadowwds_11_tfferiadoconvenio_sels ,
                                          int AV80Feriadowwds_2_tfferid_sels_size ,
                                          String AV79Feriadowwds_1_tfferid ,
                                          int AV81Feriadowwds_3_tfferiadotipo_sels_size ,
                                          int AV83Feriadowwds_5_tfferdescrip_sels_size ,
                                          String AV82Feriadowwds_4_tfferdescrip ,
                                          int AV85Feriadowwds_7_tfferreligid_sels_size ,
                                          String AV84Feriadowwds_6_tfferreligid ,
                                          int AV87Feriadowwds_9_tfferorigid_sels_size ,
                                          String AV86Feriadowwds_8_tfferorigid ,
                                          int AV89Feriadowwds_11_tfferiadoconvenio_sels_size ,
                                          String AV88Feriadowwds_10_tfferiadoconvenio ,
                                          short AV66PaiCod ,
                                          short A46PaiCod ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[6];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT PaiCod, FeriadoConvenio, FerOrigId, FerReligId, FerDescrip, FeriadoTipo, FerId FROM feriado" ;
      if ( ( AV80Feriadowwds_2_tfferid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV79Feriadowwds_1_tfferid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(FerId) like LOWER(?))");
      }
      else
      {
         GXv_int10[0] = (byte)(1) ;
      }
      if ( AV80Feriadowwds_2_tfferid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV80Feriadowwds_2_tfferid_sels, "FerId IN (", ")")+")");
      }
      if ( AV81Feriadowwds_3_tfferiadotipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV81Feriadowwds_3_tfferiadotipo_sels, "FeriadoTipo IN (", ")")+")");
      }
      if ( ( AV83Feriadowwds_5_tfferdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV82Feriadowwds_4_tfferdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(FerDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int10[1] = (byte)(1) ;
      }
      if ( AV83Feriadowwds_5_tfferdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV83Feriadowwds_5_tfferdescrip_sels, "FerDescrip IN (", ")")+")");
      }
      if ( ( AV85Feriadowwds_7_tfferreligid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV84Feriadowwds_6_tfferreligid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(FerReligId) like LOWER(?))");
      }
      else
      {
         GXv_int10[2] = (byte)(1) ;
      }
      if ( AV85Feriadowwds_7_tfferreligid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV85Feriadowwds_7_tfferreligid_sels, "FerReligId IN (", ")")+")");
      }
      if ( ( AV87Feriadowwds_9_tfferorigid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV86Feriadowwds_8_tfferorigid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(FerOrigId) like LOWER(?))");
      }
      else
      {
         GXv_int10[3] = (byte)(1) ;
      }
      if ( AV87Feriadowwds_9_tfferorigid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV87Feriadowwds_9_tfferorigid_sels, "FerOrigId IN (", ")")+")");
      }
      if ( ( AV89Feriadowwds_11_tfferiadoconvenio_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV88Feriadowwds_10_tfferiadoconvenio)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(FeriadoConvenio) like LOWER(?))");
      }
      else
      {
         GXv_int10[4] = (byte)(1) ;
      }
      if ( AV89Feriadowwds_11_tfferiadoconvenio_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV89Feriadowwds_11_tfferiadoconvenio_sels, "FeriadoConvenio IN (", ")")+")");
      }
      if ( ! (0==AV66PaiCod) )
      {
         addWhere(sWhereString, "(PaiCod = ?)");
      }
      else
      {
         GXv_int10[5] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY FerId" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY FerId DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY FeriadoTipo" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY FeriadoTipo DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY FerDescrip" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY FerDescrip DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY FerReligId" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY FerReligId DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY FerOrigId" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY FerOrigId DESC" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY FeriadoConvenio" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY FeriadoConvenio DESC" ;
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
                  return conditional_P01IB2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).shortValue() , ((Number) dynConstraints[24]).shortValue() , ((Number) dynConstraints[25]).shortValue() , ((Boolean) dynConstraints[26]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01IB2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(5);
               ((String[]) buf[8])[0] = rslt.getString(6, 20);
               ((String[]) buf[9])[0] = rslt.getString(7, 40);
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
                  stmt.setString(sIdx, (String)parms[6], 40);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 400);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[8], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[9], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[10], 20);
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

