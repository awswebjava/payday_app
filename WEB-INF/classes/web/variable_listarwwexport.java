package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class variable_listarwwexport extends GXProcedure
{
   public variable_listarwwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( variable_listarwwexport.class ), "" );
   }

   public variable_listarwwexport( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      variable_listarwwexport.this.aP1 = new String[] {""};
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
      variable_listarwwexport.this.aP0 = aP0;
      variable_listarwwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV51CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      variable_listarwwexport.this.GXt_int1 = GXv_int2[0] ;
      AV51CliCod = GXt_int1 ;
      GXt_boolean3 = AV8IsAuthorized ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWVariable_listar", GXv_boolean4) ;
      variable_listarwwexport.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV8IsAuthorized = GXt_boolean3 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV81Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "Variable_listarWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV37TFOpeCliId_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Código", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         variable_listarwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV50i = 1 ;
         AV82GXV1 = 1 ;
         while ( AV82GXV1 <= AV37TFOpeCliId_Sels.size() )
         {
            AV38TFOpeCliId_Sel = (String)AV37TFOpeCliId_Sels.elementAt(-1+AV82GXV1) ;
            if ( AV50i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFOpeCliId_Sel, GXv_char9) ;
            variable_listarwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV50i = (long)(AV50i+1) ;
            AV82GXV1 = (int)(AV82GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV36TFOpeCliId)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Código", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            variable_listarwwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV36TFOpeCliId, GXv_char9) ;
            variable_listarwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( ( AV41TFOpeCliCodFormula_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Código", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         variable_listarwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV50i = 1 ;
         AV83GXV2 = 1 ;
         while ( AV83GXV2 <= AV41TFOpeCliCodFormula_Sels.size() )
         {
            AV42TFOpeCliCodFormula_Sel = (String)AV41TFOpeCliCodFormula_Sels.elementAt(-1+AV83GXV2) ;
            if ( AV50i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV42TFOpeCliCodFormula_Sel, GXv_char9) ;
            variable_listarwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV50i = (long)(AV50i+1) ;
            AV83GXV2 = (int)(AV83GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV40TFOpeCliCodFormula)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Código", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            variable_listarwwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFOpeCliCodFormula, GXv_char9) ;
            variable_listarwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( ( AV45TFOpeCliDescrip_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         variable_listarwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV50i = 1 ;
         AV84GXV3 = 1 ;
         while ( AV84GXV3 <= AV45TFOpeCliDescrip_Sels.size() )
         {
            AV46TFOpeCliDescrip_Sel = (String)AV45TFOpeCliDescrip_Sels.elementAt(-1+AV84GXV3) ;
            if ( AV50i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV46TFOpeCliDescrip_Sel, GXv_char9) ;
            variable_listarwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV50i = (long)(AV50i+1) ;
            AV84GXV3 = (int)(AV84GXV3+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV44TFOpeCliDescrip)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            variable_listarwwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV44TFOpeCliDescrip, GXv_char9) ;
            variable_listarwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( (0==AV48TFOpeCliEsCant_Sel) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Es cantidad", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         variable_listarwwexport.this.AV14CellRow = GXv_int7[0] ;
         if ( AV48TFOpeCliEsCant_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV48TFOpeCliEsCant_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( (0==AV49TFOpeCliAliEs_Sel) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Es alicuota", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         variable_listarwwexport.this.AV14CellRow = GXv_int7[0] ;
         if ( AV49TFOpeCliAliEs_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV49TFOpeCliAliEs_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( ( AV75TFVarRelRef_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Release", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         variable_listarwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV50i = 1 ;
         AV85GXV4 = 1 ;
         while ( AV85GXV4 <= AV75TFVarRelRef_Sels.size() )
         {
            AV76TFVarRelRef_Sel = (String)AV75TFVarRelRef_Sels.elementAt(-1+AV85GXV4) ;
            if ( AV50i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV76TFVarRelRef_Sel, GXv_char9) ;
            variable_listarwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV50i = (long)(AV50i+1) ;
            AV85GXV4 = (int)(AV85GXV4+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV74TFVarRelRef)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Release", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            variable_listarwwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV74TFVarRelRef, GXv_char9) ;
            variable_listarwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( (0==AV77TFVarFrecAct) && (0==AV78TFVarFrecAct_To) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Frecuencia de actualizaciòn", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         variable_listarwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV77TFVarFrecAct );
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, false, GXv_int7, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         variable_listarwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV78TFVarFrecAct_To );
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("Variable_listarWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("Variable_listarWWColumnsSelector") ;
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
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( (boolean)((AV72IsAuthorizedVarRelRef&&((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible())) );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV86GXV5 = 1 ;
      while ( AV86GXV5 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV86GXV5));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV86GXV5 = (int)(AV86GXV5+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV88Variable_listarwwds_1_tfopecliid = AV36TFOpeCliId ;
      AV89Variable_listarwwds_2_tfopecliid_sels = AV37TFOpeCliId_Sels ;
      AV90Variable_listarwwds_3_tfopeclicodformula = AV40TFOpeCliCodFormula ;
      AV91Variable_listarwwds_4_tfopeclicodformula_sels = AV41TFOpeCliCodFormula_Sels ;
      AV92Variable_listarwwds_5_tfopeclidescrip = AV44TFOpeCliDescrip ;
      AV93Variable_listarwwds_6_tfopeclidescrip_sels = AV45TFOpeCliDescrip_Sels ;
      AV94Variable_listarwwds_7_tfopecliescant_sel = AV48TFOpeCliEsCant_Sel ;
      AV95Variable_listarwwds_8_tfopeclialies_sel = AV49TFOpeCliAliEs_Sel ;
      AV96Variable_listarwwds_9_tfvarrelref = AV74TFVarRelRef ;
      AV97Variable_listarwwds_10_tfvarrelref_sels = AV75TFVarRelRef_Sels ;
      AV98Variable_listarwwds_11_tfvarfrecact = AV77TFVarFrecAct ;
      AV99Variable_listarwwds_12_tfvarfrecact_to = AV78TFVarFrecAct_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A82OpeCliId ,
                                           AV89Variable_listarwwds_2_tfopecliid_sels ,
                                           A549OpeCliCodFormula ,
                                           AV91Variable_listarwwds_4_tfopeclicodformula_sels ,
                                           A534OpeCliDescrip ,
                                           AV93Variable_listarwwds_6_tfopeclidescrip_sels ,
                                           A2011VarRelRef ,
                                           AV97Variable_listarwwds_10_tfvarrelref_sels ,
                                           Integer.valueOf(AV89Variable_listarwwds_2_tfopecliid_sels.size()) ,
                                           AV88Variable_listarwwds_1_tfopecliid ,
                                           Integer.valueOf(AV91Variable_listarwwds_4_tfopeclicodformula_sels.size()) ,
                                           AV90Variable_listarwwds_3_tfopeclicodformula ,
                                           Integer.valueOf(AV93Variable_listarwwds_6_tfopeclidescrip_sels.size()) ,
                                           AV92Variable_listarwwds_5_tfopeclidescrip ,
                                           Byte.valueOf(AV94Variable_listarwwds_7_tfopecliescant_sel) ,
                                           Byte.valueOf(AV95Variable_listarwwds_8_tfopeclialies_sel) ,
                                           Integer.valueOf(AV97Variable_listarwwds_10_tfvarrelref_sels.size()) ,
                                           AV96Variable_listarwwds_9_tfvarrelref ,
                                           Byte.valueOf(AV98Variable_listarwwds_11_tfvarfrecact) ,
                                           Byte.valueOf(AV99Variable_listarwwds_12_tfvarfrecact_to) ,
                                           Boolean.valueOf(A931OpeCliEsCant) ,
                                           Boolean.valueOf(A934OpeCliAliEs) ,
                                           Byte.valueOf(A1913VarFrecAct) ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Integer.valueOf(AV51CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.SHORT,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV88Variable_listarwwds_1_tfopecliid = GXutil.padr( GXutil.rtrim( AV88Variable_listarwwds_1_tfopecliid), 40, "%") ;
      lV90Variable_listarwwds_3_tfopeclicodformula = GXutil.padr( GXutil.rtrim( AV90Variable_listarwwds_3_tfopeclicodformula), 40, "%") ;
      lV92Variable_listarwwds_5_tfopeclidescrip = GXutil.concat( GXutil.rtrim( AV92Variable_listarwwds_5_tfopeclidescrip), "%", "") ;
      lV96Variable_listarwwds_9_tfvarrelref = GXutil.concat( GXutil.rtrim( AV96Variable_listarwwds_9_tfvarrelref), "%", "") ;
      /* Using cursor P01Q02 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV51CliCod), lV88Variable_listarwwds_1_tfopecliid, lV90Variable_listarwwds_3_tfopeclicodformula, lV92Variable_listarwwds_5_tfopeclidescrip, lV96Variable_listarwwds_9_tfvarrelref, Byte.valueOf(AV98Variable_listarwwds_11_tfvarfrecact), Byte.valueOf(AV99Variable_listarwwds_12_tfvarfrecact_to)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1913VarFrecAct = P01Q02_A1913VarFrecAct[0] ;
         A2011VarRelRef = P01Q02_A2011VarRelRef[0] ;
         A934OpeCliAliEs = P01Q02_A934OpeCliAliEs[0] ;
         A931OpeCliEsCant = P01Q02_A931OpeCliEsCant[0] ;
         A534OpeCliDescrip = P01Q02_A534OpeCliDescrip[0] ;
         A549OpeCliCodFormula = P01Q02_A549OpeCliCodFormula[0] ;
         A82OpeCliId = P01Q02_A82OpeCliId[0] ;
         A3CliCod = P01Q02_A3CliCod[0] ;
         GXt_date10 = A1922VarFecProx ;
         GXv_date11[0] = GXt_date10 ;
         new web.varfechaproxact(remoteHandle, context).execute( A3CliCod, A82OpeCliId, GXv_date11) ;
         variable_listarwwexport.this.GXt_date10 = GXv_date11[0] ;
         A1922VarFecProx = GXt_date10 ;
         GXt_char8 = A1828OpeCliUltVal ;
         GXv_char9[0] = GXt_char8 ;
         new web.getopeclivaloryfecha(remoteHandle, context).execute( A3CliCod, A82OpeCliId, localUtil.ymdtod( 1900, 1, 1), GXv_char9) ;
         variable_listarwwexport.this.GXt_char8 = GXv_char9[0] ;
         A1828OpeCliUltVal = GXt_char8 ;
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
         AV100GXV6 = 1 ;
         while ( AV100GXV6 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV100GXV6));
            if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliCod") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A3CliCod );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "OpeCliId") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A82OpeCliId, GXv_char9) ;
                  variable_listarwwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "OpeCliCodFormula") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A549OpeCliCodFormula, GXv_char9) ;
                  variable_listarwwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "OpeCliDescrip") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A534OpeCliDescrip, GXv_char9) ;
                  variable_listarwwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "OpeCliEsCant") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A931OpeCliEsCant) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "OpeCliAliEs") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A934OpeCliAliEs) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "OpeCliUltVal") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1828OpeCliUltVal, GXv_char9) ;
                  variable_listarwwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "VarFecProx") == 0 )
               {
                  GXt_dtime12 = GXutil.resetTime( A1922VarFecProx );
                  AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setDate( GXt_dtime12 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "VarRelRef") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A2011VarRelRef, GXv_char9) ;
                  variable_listarwwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "VarFrecAct") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1913VarFrecAct );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV100GXV6 = (int)(AV100GXV6+1) ;
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
      GXt_boolean3 = AV72IsAuthorizedVarRelRef ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV51CliCod, GXv_boolean4) ;
      variable_listarwwexport.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV72IsAuthorizedVarRelRef = (boolean)((!GXt_boolean3)) ;
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
      GXv_SdtWWPColumnsSelector13[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "OpeCliId", "", "Código", false, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "OpeCliCodFormula", "", "Código", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "OpeCliDescrip", "", "Descripción", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "OpeCliEsCant", "", "Es cantidad", false, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "OpeCliAliEs", "", "Es alicuota", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "OpeCliUltVal", "", "Ultimo valor", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "VarFecProx", "", "Fecha próx. act.", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      if ( ! new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).executeUdp( AV51CliCod) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         GXv_SdtWWPColumnsSelector13[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "VarRelRef", "", "Release", true, "") ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector13[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "", "", "", false, "") ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      }
      GXv_SdtWWPColumnsSelector13[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "VarFrecAct", "", "Frecuencia de actualizaciòn", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "&VerSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "&ModificarSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "&EliminarSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXt_char8 = AV28UserCustomValue ;
      GXv_char9[0] = GXt_char8 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "Variable_listarWWColumnsSelector", GXv_char9) ;
      variable_listarwwexport.this.GXt_char8 = GXv_char9[0] ;
      AV28UserCustomValue = GXt_char8 ;
      if ( ! ( (GXutil.strcmp("", AV28UserCustomValue)==0) ) )
      {
         AV25ColumnsSelectorAux.fromxml(AV28UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector13[0] = AV25ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector14[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, GXv_SdtWWPColumnsSelector14) ;
         AV25ColumnsSelectorAux = GXv_SdtWWPColumnsSelector13[0] ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      }
   }

   public void S211( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("Variable_listarWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "Variable_listarWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("Variable_listarWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV101GXV7 = 1 ;
      while ( AV101GXV7 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV101GXV7));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLIID") == 0 )
         {
            AV36TFOpeCliId = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLIID_SEL") == 0 )
         {
            AV35TFOpeCliId_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV37TFOpeCliId_Sels.fromJSonString(AV35TFOpeCliId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLICODFORMULA") == 0 )
         {
            AV40TFOpeCliCodFormula = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLICODFORMULA_SEL") == 0 )
         {
            AV39TFOpeCliCodFormula_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV41TFOpeCliCodFormula_Sels.fromJSonString(AV39TFOpeCliCodFormula_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLIDESCRIP") == 0 )
         {
            AV44TFOpeCliDescrip = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLIDESCRIP_SEL") == 0 )
         {
            AV43TFOpeCliDescrip_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV45TFOpeCliDescrip_Sels.fromJSonString(AV43TFOpeCliDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLIESCANT_SEL") == 0 )
         {
            AV48TFOpeCliEsCant_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLIALIES_SEL") == 0 )
         {
            AV49TFOpeCliAliEs_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFVARRELREF") == 0 )
         {
            AV74TFVarRelRef = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFVARRELREF_SEL") == 0 )
         {
            AV73TFVarRelRef_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV75TFVarRelRef_Sels.fromJSonString(AV73TFVarRelRef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFVARFRECACT") == 0 )
         {
            AV77TFVarFrecAct = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV78TFVarFrecAct_To = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV71MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV101GXV7 = (int)(AV101GXV7+1) ;
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
      this.aP0[0] = variable_listarwwexport.this.AV12Filename;
      this.aP1[0] = variable_listarwwexport.this.AV13ErrorMessage;
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
      AV81Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV37TFOpeCliId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV38TFOpeCliId_Sel = "" ;
      AV36TFOpeCliId = "" ;
      AV41TFOpeCliCodFormula_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42TFOpeCliCodFormula_Sel = "" ;
      AV40TFOpeCliCodFormula = "" ;
      AV45TFOpeCliDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV46TFOpeCliDescrip_Sel = "" ;
      AV44TFOpeCliDescrip = "" ;
      AV75TFVarRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV76TFVarRelRef_Sel = "" ;
      AV74TFVarRelRef = "" ;
      GXv_exceldoc6 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int7 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A82OpeCliId = "" ;
      A549OpeCliCodFormula = "" ;
      A534OpeCliDescrip = "" ;
      A1828OpeCliUltVal = "" ;
      A1922VarFecProx = GXutil.nullDate() ;
      A2011VarRelRef = "" ;
      AV88Variable_listarwwds_1_tfopecliid = "" ;
      AV89Variable_listarwwds_2_tfopecliid_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV90Variable_listarwwds_3_tfopeclicodformula = "" ;
      AV91Variable_listarwwds_4_tfopeclicodformula_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV92Variable_listarwwds_5_tfopeclidescrip = "" ;
      AV93Variable_listarwwds_6_tfopeclidescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV96Variable_listarwwds_9_tfvarrelref = "" ;
      AV97Variable_listarwwds_10_tfvarrelref_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV88Variable_listarwwds_1_tfopecliid = "" ;
      lV90Variable_listarwwds_3_tfopeclicodformula = "" ;
      lV92Variable_listarwwds_5_tfopeclidescrip = "" ;
      lV96Variable_listarwwds_9_tfvarrelref = "" ;
      P01Q02_A1913VarFrecAct = new byte[1] ;
      P01Q02_A2011VarRelRef = new String[] {""} ;
      P01Q02_A934OpeCliAliEs = new boolean[] {false} ;
      P01Q02_A931OpeCliEsCant = new boolean[] {false} ;
      P01Q02_A534OpeCliDescrip = new String[] {""} ;
      P01Q02_A549OpeCliCodFormula = new String[] {""} ;
      P01Q02_A82OpeCliId = new String[] {""} ;
      P01Q02_A3CliCod = new int[1] ;
      GXt_date10 = GXutil.nullDate() ;
      GXv_date11 = new java.util.Date[1] ;
      GXt_dtime12 = GXutil.resetTime( GXutil.nullDate() );
      GXv_boolean4 = new boolean[1] ;
      AV28UserCustomValue = "" ;
      GXt_char8 = "" ;
      GXv_char9 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector13 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector14 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV35TFOpeCliId_SelsJson = "" ;
      AV39TFOpeCliCodFormula_SelsJson = "" ;
      AV43TFOpeCliDescrip_SelsJson = "" ;
      AV73TFVarRelRef_SelsJson = "" ;
      AV71MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.variable_listarwwexport__default(),
         new Object[] {
             new Object[] {
            P01Q02_A1913VarFrecAct, P01Q02_A2011VarRelRef, P01Q02_A934OpeCliAliEs, P01Q02_A931OpeCliEsCant, P01Q02_A534OpeCliDescrip, P01Q02_A549OpeCliCodFormula, P01Q02_A82OpeCliId, P01Q02_A3CliCod
            }
         }
      );
      AV81Pgmname = "Variable_listarWWExport" ;
      /* GeneXus formulas. */
      AV81Pgmname = "Variable_listarWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV48TFOpeCliEsCant_Sel ;
   private byte AV49TFOpeCliAliEs_Sel ;
   private byte AV77TFVarFrecAct ;
   private byte AV78TFVarFrecAct_To ;
   private byte A1913VarFrecAct ;
   private byte AV94Variable_listarwwds_7_tfopecliescant_sel ;
   private byte AV95Variable_listarwwds_8_tfopeclialies_sel ;
   private byte AV98Variable_listarwwds_11_tfvarfrecact ;
   private byte AV99Variable_listarwwds_12_tfvarfrecact_to ;
   private short GXv_int7[] ;
   private short AV18OrderedBy ;
   private short Gx_err ;
   private int AV51CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV82GXV1 ;
   private int AV83GXV2 ;
   private int AV84GXV3 ;
   private int AV85GXV4 ;
   private int AV86GXV5 ;
   private int A3CliCod ;
   private int AV89Variable_listarwwds_2_tfopecliid_sels_size ;
   private int AV91Variable_listarwwds_4_tfopeclicodformula_sels_size ;
   private int AV93Variable_listarwwds_6_tfopeclidescrip_sels_size ;
   private int AV97Variable_listarwwds_10_tfvarrelref_sels_size ;
   private int AV100GXV6 ;
   private int AV101GXV7 ;
   private long AV50i ;
   private long AV32VisibleColumnCount ;
   private String AV81Pgmname ;
   private String AV38TFOpeCliId_Sel ;
   private String AV36TFOpeCliId ;
   private String AV42TFOpeCliCodFormula_Sel ;
   private String AV40TFOpeCliCodFormula ;
   private String A82OpeCliId ;
   private String A549OpeCliCodFormula ;
   private String AV88Variable_listarwwds_1_tfopecliid ;
   private String AV90Variable_listarwwds_3_tfopeclicodformula ;
   private String scmdbuf ;
   private String lV88Variable_listarwwds_1_tfopecliid ;
   private String lV90Variable_listarwwds_3_tfopeclicodformula ;
   private String GXt_char8 ;
   private String GXv_char9[] ;
   private java.util.Date GXt_dtime12 ;
   private java.util.Date A1922VarFecProx ;
   private java.util.Date GXt_date10 ;
   private java.util.Date GXv_date11[] ;
   private boolean AV8IsAuthorized ;
   private boolean returnInSub ;
   private boolean AV72IsAuthorizedVarRelRef ;
   private boolean A931OpeCliEsCant ;
   private boolean A934OpeCliAliEs ;
   private boolean AV19OrderedDsc ;
   private boolean GXt_boolean3 ;
   private boolean GXv_boolean4[] ;
   private boolean Cond_result ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV35TFOpeCliId_SelsJson ;
   private String AV39TFOpeCliCodFormula_SelsJson ;
   private String AV43TFOpeCliDescrip_SelsJson ;
   private String AV73TFVarRelRef_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV46TFOpeCliDescrip_Sel ;
   private String AV44TFOpeCliDescrip ;
   private String AV76TFVarRelRef_Sel ;
   private String AV74TFVarRelRef ;
   private String A534OpeCliDescrip ;
   private String A1828OpeCliUltVal ;
   private String A2011VarRelRef ;
   private String AV92Variable_listarwwds_5_tfopeclidescrip ;
   private String AV96Variable_listarwwds_9_tfvarrelref ;
   private String lV92Variable_listarwwds_5_tfopeclidescrip ;
   private String lV96Variable_listarwwds_9_tfvarrelref ;
   private String AV71MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV37TFOpeCliId_Sels ;
   private GXSimpleCollection<String> AV41TFOpeCliCodFormula_Sels ;
   private GXSimpleCollection<String> AV45TFOpeCliDescrip_Sels ;
   private GXSimpleCollection<String> AV75TFVarRelRef_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private byte[] P01Q02_A1913VarFrecAct ;
   private String[] P01Q02_A2011VarRelRef ;
   private boolean[] P01Q02_A934OpeCliAliEs ;
   private boolean[] P01Q02_A931OpeCliEsCant ;
   private String[] P01Q02_A534OpeCliDescrip ;
   private String[] P01Q02_A549OpeCliCodFormula ;
   private String[] P01Q02_A82OpeCliId ;
   private int[] P01Q02_A3CliCod ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc6[] ;
   private GXSimpleCollection<String> AV89Variable_listarwwds_2_tfopecliid_sels ;
   private GXSimpleCollection<String> AV91Variable_listarwwds_4_tfopeclicodformula_sels ;
   private GXSimpleCollection<String> AV93Variable_listarwwds_6_tfopeclidescrip_sels ;
   private GXSimpleCollection<String> AV97Variable_listarwwds_10_tfvarrelref_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV24ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV25ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector13[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector14[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV26ColumnsSelector_Column ;
}

final  class variable_listarwwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01Q02( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A82OpeCliId ,
                                          GXSimpleCollection<String> AV89Variable_listarwwds_2_tfopecliid_sels ,
                                          String A549OpeCliCodFormula ,
                                          GXSimpleCollection<String> AV91Variable_listarwwds_4_tfopeclicodformula_sels ,
                                          String A534OpeCliDescrip ,
                                          GXSimpleCollection<String> AV93Variable_listarwwds_6_tfopeclidescrip_sels ,
                                          String A2011VarRelRef ,
                                          GXSimpleCollection<String> AV97Variable_listarwwds_10_tfvarrelref_sels ,
                                          int AV89Variable_listarwwds_2_tfopecliid_sels_size ,
                                          String AV88Variable_listarwwds_1_tfopecliid ,
                                          int AV91Variable_listarwwds_4_tfopeclicodformula_sels_size ,
                                          String AV90Variable_listarwwds_3_tfopeclicodformula ,
                                          int AV93Variable_listarwwds_6_tfopeclidescrip_sels_size ,
                                          String AV92Variable_listarwwds_5_tfopeclidescrip ,
                                          byte AV94Variable_listarwwds_7_tfopecliescant_sel ,
                                          byte AV95Variable_listarwwds_8_tfopeclialies_sel ,
                                          int AV97Variable_listarwwds_10_tfvarrelref_sels_size ,
                                          String AV96Variable_listarwwds_9_tfvarrelref ,
                                          byte AV98Variable_listarwwds_11_tfvarfrecact ,
                                          byte AV99Variable_listarwwds_12_tfvarfrecact_to ,
                                          boolean A931OpeCliEsCant ,
                                          boolean A934OpeCliAliEs ,
                                          byte A1913VarFrecAct ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          int AV51CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int15 = new byte[7];
      Object[] GXv_Object16 = new Object[2];
      scmdbuf = "SELECT VarFrecAct, VarRelRef, OpeCliAliEs, OpeCliEsCant, OpeCliDescrip, OpeCliCodFormula, OpeCliId, CliCod FROM Variable" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV89Variable_listarwwds_2_tfopecliid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV88Variable_listarwwds_1_tfopecliid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OpeCliId) like LOWER(?))");
      }
      else
      {
         GXv_int15[1] = (byte)(1) ;
      }
      if ( AV89Variable_listarwwds_2_tfopecliid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV89Variable_listarwwds_2_tfopecliid_sels, "OpeCliId IN (", ")")+")");
      }
      if ( ( AV91Variable_listarwwds_4_tfopeclicodformula_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV90Variable_listarwwds_3_tfopeclicodformula)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OpeCliCodFormula) like LOWER(?))");
      }
      else
      {
         GXv_int15[2] = (byte)(1) ;
      }
      if ( AV91Variable_listarwwds_4_tfopeclicodformula_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV91Variable_listarwwds_4_tfopeclicodformula_sels, "OpeCliCodFormula IN (", ")")+")");
      }
      if ( ( AV93Variable_listarwwds_6_tfopeclidescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV92Variable_listarwwds_5_tfopeclidescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OpeCliDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int15[3] = (byte)(1) ;
      }
      if ( AV93Variable_listarwwds_6_tfopeclidescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV93Variable_listarwwds_6_tfopeclidescrip_sels, "OpeCliDescrip IN (", ")")+")");
      }
      if ( AV94Variable_listarwwds_7_tfopecliescant_sel == 1 )
      {
         addWhere(sWhereString, "(OpeCliEsCant = TRUE)");
      }
      if ( AV94Variable_listarwwds_7_tfopecliescant_sel == 2 )
      {
         addWhere(sWhereString, "(OpeCliEsCant = FALSE)");
      }
      if ( AV95Variable_listarwwds_8_tfopeclialies_sel == 1 )
      {
         addWhere(sWhereString, "(OpeCliAliEs = TRUE)");
      }
      if ( AV95Variable_listarwwds_8_tfopeclialies_sel == 2 )
      {
         addWhere(sWhereString, "(OpeCliAliEs = FALSE)");
      }
      if ( ( AV97Variable_listarwwds_10_tfvarrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV96Variable_listarwwds_9_tfvarrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(VarRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int15[4] = (byte)(1) ;
      }
      if ( AV97Variable_listarwwds_10_tfvarrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV97Variable_listarwwds_10_tfvarrelref_sels, "VarRelRef IN (", ")")+")");
      }
      if ( ! (0==AV98Variable_listarwwds_11_tfvarfrecact) )
      {
         addWhere(sWhereString, "(VarFrecAct >= ?)");
      }
      else
      {
         GXv_int15[5] = (byte)(1) ;
      }
      if ( ! (0==AV99Variable_listarwwds_12_tfvarfrecact_to) )
      {
         addWhere(sWhereString, "(VarFrecAct <= ?)");
      }
      else
      {
         GXv_int15[6] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY OpeCliId" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY OpeCliId DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY OpeCliCodFormula" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY OpeCliCodFormula DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY OpeCliDescrip" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY OpeCliDescrip DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY OpeCliEsCant" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY OpeCliEsCant DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY OpeCliAliEs" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY OpeCliAliEs DESC" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY VarRelRef" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY VarRelRef DESC" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY VarFrecAct" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY VarFrecAct DESC" ;
      }
      GXv_Object16[0] = scmdbuf ;
      GXv_Object16[1] = GXv_int15 ;
      return GXv_Object16 ;
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
                  return conditional_P01Q02(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , ((Number) dynConstraints[15]).byteValue() , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).byteValue() , ((Number) dynConstraints[19]).byteValue() , ((Boolean) dynConstraints[20]).booleanValue() , ((Boolean) dynConstraints[21]).booleanValue() , ((Number) dynConstraints[22]).byteValue() , ((Number) dynConstraints[23]).shortValue() , ((Boolean) dynConstraints[24]).booleanValue() , ((Number) dynConstraints[25]).intValue() , ((Number) dynConstraints[26]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01Q02", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 40);
               ((String[]) buf[6])[0] = rslt.getString(7, 40);
               ((int[]) buf[7])[0] = rslt.getInt(8);
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
                  stmt.setString(sIdx, (String)parms[8], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[9], 40);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 40);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[12]).byteValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[13]).byteValue());
               }
               return;
      }
   }

}

