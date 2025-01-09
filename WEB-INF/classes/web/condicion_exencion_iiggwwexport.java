package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class condicion_exencion_iiggwwexport extends GXProcedure
{
   public condicion_exencion_iiggwwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( condicion_exencion_iiggwwexport.class ), "" );
   }

   public condicion_exencion_iiggwwexport( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      condicion_exencion_iiggwwexport.this.aP1 = new String[] {""};
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
      condicion_exencion_iiggwwexport.this.aP0 = aP0;
      condicion_exencion_iiggwwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWcondicion_exencion_iigg", GXv_boolean2) ;
      condicion_exencion_iiggwwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV63Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "condicion_exencion_iiggWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV41TFCondExenIIGG_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Código", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         condicion_exencion_iiggwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV58i = 1 ;
         AV64GXV1 = 1 ;
         while ( AV64GXV1 <= AV41TFCondExenIIGG_Sels.size() )
         {
            AV42TFCondExenIIGG_Sel = (String)AV41TFCondExenIIGG_Sels.elementAt(-1+AV64GXV1) ;
            if ( AV58i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV42TFCondExenIIGG_Sel, GXv_char7) ;
            condicion_exencion_iiggwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV58i = (long)(AV58i+1) ;
            AV64GXV1 = (int)(AV64GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV40TFCondExenIIGG)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Código", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            condicion_exencion_iiggwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFCondExenIIGG, GXv_char7) ;
            condicion_exencion_iiggwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV43TFCondExenIIGGAcu_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Acumulado", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         condicion_exencion_iiggwwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV43TFCondExenIIGGAcu_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV43TFCondExenIIGGAcu_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( (0==AV44TFCondExenIIGGProm_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Promedio", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         condicion_exencion_iiggwwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV44TFCondExenIIGGProm_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV44TFCondExenIIGGProm_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV45TFCondExenIIGGVFi)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV46TFCondExenIIGGVFi_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Valor fijo a comparar", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         condicion_exencion_iiggwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV45TFCondExenIIGGVFi)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         condicion_exencion_iiggwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV46TFCondExenIIGGVFi_To)) );
      }
      if ( ! ( ( AV48TFCondExenIIGGOpe_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Operador de comparación", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         condicion_exencion_iiggwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV58i = 1 ;
         AV65GXV2 = 1 ;
         while ( AV65GXV2 <= AV48TFCondExenIIGGOpe_Sels.size() )
         {
            AV49TFCondExenIIGGOpe_Sel = (String)AV48TFCondExenIIGGOpe_Sels.elementAt(-1+AV65GXV2) ;
            if ( AV58i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomainoperador_comparacion.getDescription(httpContext,(String)AV49TFCondExenIIGGOpe_Sel), "") );
            AV58i = (long)(AV58i+1) ;
            AV65GXV2 = (int)(AV65GXV2+1) ;
         }
      }
      if ( ! ( ( AV52TFCondexenIIGGNom_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         condicion_exencion_iiggwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV58i = 1 ;
         AV66GXV3 = 1 ;
         while ( AV66GXV3 <= AV52TFCondexenIIGGNom_Sels.size() )
         {
            AV53TFCondexenIIGGNom_Sel = (String)AV52TFCondexenIIGGNom_Sels.elementAt(-1+AV66GXV3) ;
            if ( AV58i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV53TFCondexenIIGGNom_Sel, GXv_char7) ;
            condicion_exencion_iiggwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV58i = (long)(AV58i+1) ;
            AV66GXV3 = (int)(AV66GXV3+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV51TFCondexenIIGGNom)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            condicion_exencion_iiggwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV51TFCondexenIIGGNom, GXv_char7) ;
            condicion_exencion_iiggwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV56TFCondExenRelRef_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Liberación", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         condicion_exencion_iiggwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV58i = 1 ;
         AV67GXV4 = 1 ;
         while ( AV67GXV4 <= AV56TFCondExenRelRef_Sels.size() )
         {
            AV57TFCondExenRelRef_Sel = (String)AV56TFCondExenRelRef_Sels.elementAt(-1+AV67GXV4) ;
            if ( AV58i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV57TFCondExenRelRef_Sel, GXv_char7) ;
            condicion_exencion_iiggwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV58i = (long)(AV58i+1) ;
            AV67GXV4 = (int)(AV67GXV4+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV55TFCondExenRelRef)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Liberación", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            condicion_exencion_iiggwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV55TFCondExenRelRef, GXv_char7) ;
            condicion_exencion_iiggwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV36VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("condicion_exencion_iiggWWColumnsSelector"), "") != 0 )
      {
         AV31ColumnsSelectorXML = AV20Session.getValue("condicion_exencion_iiggWWColumnsSelector") ;
         AV28ColumnsSelector.fromxml(AV31ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( (boolean)((AV24IsAuthorizedCondExenRelRef&&((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible())) );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV68GXV5 = 1 ;
      while ( AV68GXV5 <= AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV30ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV68GXV5));
         if ( AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setColor( 11 );
            AV36VisibleColumnCount = (long)(AV36VisibleColumnCount+1) ;
         }
         AV68GXV5 = (int)(AV68GXV5+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV70Condicion_exencion_iiggwwds_1_tfcondexeniigg = AV40TFCondExenIIGG ;
      AV71Condicion_exencion_iiggwwds_2_tfcondexeniigg_sels = AV41TFCondExenIIGG_Sels ;
      AV72Condicion_exencion_iiggwwds_3_tfcondexeniiggacu_sel = AV43TFCondExenIIGGAcu_Sel ;
      AV73Condicion_exencion_iiggwwds_4_tfcondexeniiggprom_sel = AV44TFCondExenIIGGProm_Sel ;
      AV74Condicion_exencion_iiggwwds_5_tfcondexeniiggvfi = AV45TFCondExenIIGGVFi ;
      AV75Condicion_exencion_iiggwwds_6_tfcondexeniiggvfi_to = AV46TFCondExenIIGGVFi_To ;
      AV76Condicion_exencion_iiggwwds_7_tfcondexeniiggope_sels = AV48TFCondExenIIGGOpe_Sels ;
      AV77Condicion_exencion_iiggwwds_8_tfcondexeniiggnom = AV51TFCondexenIIGGNom ;
      AV78Condicion_exencion_iiggwwds_9_tfcondexeniiggnom_sels = AV52TFCondexenIIGGNom_Sels ;
      AV79Condicion_exencion_iiggwwds_10_tfcondexenrelref = AV55TFCondExenRelRef ;
      AV80Condicion_exencion_iiggwwds_11_tfcondexenrelref_sels = AV56TFCondExenRelRef_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1105CondExenIIGG ,
                                           AV71Condicion_exencion_iiggwwds_2_tfcondexeniigg_sels ,
                                           A2238CondExenIIGGOpe ,
                                           AV76Condicion_exencion_iiggwwds_7_tfcondexeniiggope_sels ,
                                           A1108CondexenIIGGNom ,
                                           AV78Condicion_exencion_iiggwwds_9_tfcondexeniiggnom_sels ,
                                           A2021CondExenRelRef ,
                                           AV80Condicion_exencion_iiggwwds_11_tfcondexenrelref_sels ,
                                           Integer.valueOf(AV71Condicion_exencion_iiggwwds_2_tfcondexeniigg_sels.size()) ,
                                           AV70Condicion_exencion_iiggwwds_1_tfcondexeniigg ,
                                           Byte.valueOf(AV72Condicion_exencion_iiggwwds_3_tfcondexeniiggacu_sel) ,
                                           Byte.valueOf(AV73Condicion_exencion_iiggwwds_4_tfcondexeniiggprom_sel) ,
                                           AV74Condicion_exencion_iiggwwds_5_tfcondexeniiggvfi ,
                                           AV75Condicion_exencion_iiggwwds_6_tfcondexeniiggvfi_to ,
                                           Integer.valueOf(AV76Condicion_exencion_iiggwwds_7_tfcondexeniiggope_sels.size()) ,
                                           Integer.valueOf(AV78Condicion_exencion_iiggwwds_9_tfcondexeniiggnom_sels.size()) ,
                                           AV77Condicion_exencion_iiggwwds_8_tfcondexeniiggnom ,
                                           Integer.valueOf(AV80Condicion_exencion_iiggwwds_11_tfcondexenrelref_sels.size()) ,
                                           AV79Condicion_exencion_iiggwwds_10_tfcondexenrelref ,
                                           Boolean.valueOf(A1106CondExenIIGGAcu) ,
                                           Boolean.valueOf(A1107CondExenIIGGProm) ,
                                           A2237CondExenIIGGVFi ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Integer.valueOf(AV59CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN,
                                           TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV70Condicion_exencion_iiggwwds_1_tfcondexeniigg = GXutil.padr( GXutil.rtrim( AV70Condicion_exencion_iiggwwds_1_tfcondexeniigg), 20, "%") ;
      lV77Condicion_exencion_iiggwwds_8_tfcondexeniiggnom = GXutil.concat( GXutil.rtrim( AV77Condicion_exencion_iiggwwds_8_tfcondexeniiggnom), "%", "") ;
      lV79Condicion_exencion_iiggwwds_10_tfcondexenrelref = GXutil.concat( GXutil.rtrim( AV79Condicion_exencion_iiggwwds_10_tfcondexenrelref), "%", "") ;
      /* Using cursor P02FB2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV59CliCod), lV70Condicion_exencion_iiggwwds_1_tfcondexeniigg, AV74Condicion_exencion_iiggwwds_5_tfcondexeniiggvfi, AV75Condicion_exencion_iiggwwds_6_tfcondexeniiggvfi_to, lV77Condicion_exencion_iiggwwds_8_tfcondexeniiggnom, lV79Condicion_exencion_iiggwwds_10_tfcondexenrelref});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P02FB2_A3CliCod[0] ;
         A2021CondExenRelRef = P02FB2_A2021CondExenRelRef[0] ;
         A1108CondexenIIGGNom = P02FB2_A1108CondexenIIGGNom[0] ;
         A2238CondExenIIGGOpe = P02FB2_A2238CondExenIIGGOpe[0] ;
         A2237CondExenIIGGVFi = P02FB2_A2237CondExenIIGGVFi[0] ;
         A1107CondExenIIGGProm = P02FB2_A1107CondExenIIGGProm[0] ;
         A1106CondExenIIGGAcu = P02FB2_A1106CondExenIIGGAcu[0] ;
         A1105CondExenIIGG = P02FB2_A1105CondExenIIGG[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV36VisibleColumnCount = 0 ;
         AV81GXV6 = 1 ;
         while ( AV81GXV6 <= AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV30ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV81GXV6));
            if ( AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CondExenIIGG") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1105CondExenIIGG, GXv_char7) ;
                  condicion_exencion_iiggwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CondExenIIGGAcu") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1106CondExenIIGGAcu) );
               }
               else if ( GXutil.strcmp(AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CondExenIIGGProm") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1107CondExenIIGGProm) );
               }
               else if ( GXutil.strcmp(AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CondExenIIGGVFi") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A2237CondExenIIGGVFi)) );
               }
               else if ( GXutil.strcmp(AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CondExenIIGGOpe") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomainoperador_comparacion.getDescription(httpContext,(String)A2238CondExenIIGGOpe), "") );
               }
               else if ( GXutil.strcmp(AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CondexenIIGGNom") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1108CondexenIIGGNom, GXv_char7) ;
                  condicion_exencion_iiggwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CondExenRelRef") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A2021CondExenRelRef, GXv_char7) ;
                  condicion_exencion_iiggwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               AV36VisibleColumnCount = (long)(AV36VisibleColumnCount+1) ;
            }
            AV81GXV6 = (int)(AV81GXV6+1) ;
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
      GXt_boolean1 = AV24IsAuthorizedCondExenRelRef ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV59CliCod, GXv_boolean2) ;
      condicion_exencion_iiggwwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV24IsAuthorizedCondExenRelRef = (boolean)((!GXt_boolean1)) ;
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
      AV28ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "CondExenIIGG", "", "Código", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&ConDescrip", "", "Concepto a evaluar", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "CondExenIIGGAcu", "", "Acumulado", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "CondExenIIGGProm", "", "Promedio", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&OpeCliDescrip", "", "Variable a comparar", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "CondExenIIGGVFi", "", "Valor fijo a comparar", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "CondExenIIGGOpe", "", "Operador de comparación", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "CondexenIIGGNom", "", "Descripción", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      if ( ! new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).executeUdp( AV59CliCod) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "CondExenRelRef", "", "Liberación", true, "") ;
         AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&VerSVG", "", "", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
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
         GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&ModificarSVG", "", "", true, "") ;
         AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
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
         GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&EliminarSVG", "", "", true, "") ;
         AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      GXt_char6 = AV32UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "condicion_exencion_iiggWWColumnsSelector", GXv_char7) ;
      condicion_exencion_iiggwwexport.this.GXt_char6 = GXv_char7[0] ;
      AV32UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV32UserCustomValue)==0) ) )
      {
         AV29ColumnsSelectorAux.fromxml(AV32UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector8[0] = AV29ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector9[0] = AV28ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, GXv_SdtWWPColumnsSelector9) ;
         AV29ColumnsSelectorAux = GXv_SdtWWPColumnsSelector8[0] ;
         AV28ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
   }

   public void S211( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("condicion_exencion_iiggWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "condicion_exencion_iiggWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("condicion_exencion_iiggWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV82GXV7 = 1 ;
      while ( AV82GXV7 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV82GXV7));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDEXENIIGG") == 0 )
         {
            AV40TFCondExenIIGG = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDEXENIIGG_SEL") == 0 )
         {
            AV39TFCondExenIIGG_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV41TFCondExenIIGG_Sels.fromJSonString(AV39TFCondExenIIGG_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDEXENIIGGACU_SEL") == 0 )
         {
            AV43TFCondExenIIGGAcu_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDEXENIIGGPROM_SEL") == 0 )
         {
            AV44TFCondExenIIGGProm_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDEXENIIGGVFI") == 0 )
         {
            AV45TFCondExenIIGGVFi = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV46TFCondExenIIGGVFi_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDEXENIIGGOPE_SEL") == 0 )
         {
            AV47TFCondExenIIGGOpe_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV48TFCondExenIIGGOpe_Sels.fromJSonString(AV47TFCondExenIIGGOpe_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDEXENIIGGNOM") == 0 )
         {
            AV51TFCondexenIIGGNom = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDEXENIIGGNOM_SEL") == 0 )
         {
            AV50TFCondexenIIGGNom_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV52TFCondexenIIGGNom_Sels.fromJSonString(AV50TFCondexenIIGGNom_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDEXENRELREF") == 0 )
         {
            AV55TFCondExenRelRef = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDEXENRELREF_SEL") == 0 )
         {
            AV54TFCondExenRelRef_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV56TFCondExenRelRef_Sels.fromJSonString(AV54TFCondExenRelRef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV17MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV82GXV7 = (int)(AV82GXV7+1) ;
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
      this.aP0[0] = condicion_exencion_iiggwwexport.this.AV12Filename;
      this.aP1[0] = condicion_exencion_iiggwwexport.this.AV13ErrorMessage;
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
      AV63Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV41TFCondExenIIGG_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42TFCondExenIIGG_Sel = "" ;
      AV40TFCondExenIIGG = "" ;
      AV45TFCondExenIIGGVFi = DecimalUtil.ZERO ;
      AV46TFCondExenIIGGVFi_To = DecimalUtil.ZERO ;
      AV48TFCondExenIIGGOpe_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV49TFCondExenIIGGOpe_Sel = "" ;
      AV52TFCondexenIIGGNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV53TFCondexenIIGGNom_Sel = "" ;
      AV51TFCondexenIIGGNom = "" ;
      AV56TFCondExenRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV57TFCondExenRelRef_Sel = "" ;
      AV55TFCondExenRelRef = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV31ColumnsSelectorXML = "" ;
      AV28ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV30ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A1105CondExenIIGG = "" ;
      A2237CondExenIIGGVFi = DecimalUtil.ZERO ;
      A2238CondExenIIGGOpe = "" ;
      A1108CondexenIIGGNom = "" ;
      A2021CondExenRelRef = "" ;
      AV70Condicion_exencion_iiggwwds_1_tfcondexeniigg = "" ;
      AV71Condicion_exencion_iiggwwds_2_tfcondexeniigg_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV74Condicion_exencion_iiggwwds_5_tfcondexeniiggvfi = DecimalUtil.ZERO ;
      AV75Condicion_exencion_iiggwwds_6_tfcondexeniiggvfi_to = DecimalUtil.ZERO ;
      AV76Condicion_exencion_iiggwwds_7_tfcondexeniiggope_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV77Condicion_exencion_iiggwwds_8_tfcondexeniiggnom = "" ;
      AV78Condicion_exencion_iiggwwds_9_tfcondexeniiggnom_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV79Condicion_exencion_iiggwwds_10_tfcondexenrelref = "" ;
      AV80Condicion_exencion_iiggwwds_11_tfcondexenrelref_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV70Condicion_exencion_iiggwwds_1_tfcondexeniigg = "" ;
      lV77Condicion_exencion_iiggwwds_8_tfcondexeniiggnom = "" ;
      lV79Condicion_exencion_iiggwwds_10_tfcondexenrelref = "" ;
      P02FB2_A3CliCod = new int[1] ;
      P02FB2_A2021CondExenRelRef = new String[] {""} ;
      P02FB2_A1108CondexenIIGGNom = new String[] {""} ;
      P02FB2_A2238CondExenIIGGOpe = new String[] {""} ;
      P02FB2_A2237CondExenIIGGVFi = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02FB2_A1107CondExenIIGGProm = new boolean[] {false} ;
      P02FB2_A1106CondExenIIGGAcu = new boolean[] {false} ;
      P02FB2_A1105CondExenIIGG = new String[] {""} ;
      GXv_boolean2 = new boolean[1] ;
      AV32UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV29ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV39TFCondExenIIGG_SelsJson = "" ;
      AV47TFCondExenIIGGOpe_SelsJson = "" ;
      AV50TFCondexenIIGGNom_SelsJson = "" ;
      AV54TFCondExenRelRef_SelsJson = "" ;
      AV17MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.condicion_exencion_iiggwwexport__default(),
         new Object[] {
             new Object[] {
            P02FB2_A3CliCod, P02FB2_A2021CondExenRelRef, P02FB2_A1108CondexenIIGGNom, P02FB2_A2238CondExenIIGGOpe, P02FB2_A2237CondExenIIGGVFi, P02FB2_A1107CondExenIIGGProm, P02FB2_A1106CondExenIIGGAcu, P02FB2_A1105CondExenIIGG
            }
         }
      );
      AV63Pgmname = "condicion_exencion_iiggWWExport" ;
      /* GeneXus formulas. */
      AV63Pgmname = "condicion_exencion_iiggWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV43TFCondExenIIGGAcu_Sel ;
   private byte AV44TFCondExenIIGGProm_Sel ;
   private byte AV72Condicion_exencion_iiggwwds_3_tfcondexeniiggacu_sel ;
   private byte AV73Condicion_exencion_iiggwwds_4_tfcondexeniiggprom_sel ;
   private short GXv_int5[] ;
   private short AV18OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV64GXV1 ;
   private int AV65GXV2 ;
   private int AV66GXV3 ;
   private int AV67GXV4 ;
   private int AV68GXV5 ;
   private int AV71Condicion_exencion_iiggwwds_2_tfcondexeniigg_sels_size ;
   private int AV76Condicion_exencion_iiggwwds_7_tfcondexeniiggope_sels_size ;
   private int AV78Condicion_exencion_iiggwwds_9_tfcondexeniiggnom_sels_size ;
   private int AV80Condicion_exencion_iiggwwds_11_tfcondexenrelref_sels_size ;
   private int AV59CliCod ;
   private int A3CliCod ;
   private int AV81GXV6 ;
   private int AV82GXV7 ;
   private long AV58i ;
   private long AV36VisibleColumnCount ;
   private java.math.BigDecimal AV45TFCondExenIIGGVFi ;
   private java.math.BigDecimal AV46TFCondExenIIGGVFi_To ;
   private java.math.BigDecimal A2237CondExenIIGGVFi ;
   private java.math.BigDecimal AV74Condicion_exencion_iiggwwds_5_tfcondexeniiggvfi ;
   private java.math.BigDecimal AV75Condicion_exencion_iiggwwds_6_tfcondexeniiggvfi_to ;
   private String AV63Pgmname ;
   private String AV42TFCondExenIIGG_Sel ;
   private String AV40TFCondExenIIGG ;
   private String AV49TFCondExenIIGGOpe_Sel ;
   private String A1105CondExenIIGG ;
   private String A2238CondExenIIGGOpe ;
   private String AV70Condicion_exencion_iiggwwds_1_tfcondexeniigg ;
   private String scmdbuf ;
   private String lV70Condicion_exencion_iiggwwds_1_tfcondexeniigg ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean returnInSub ;
   private boolean AV24IsAuthorizedCondExenRelRef ;
   private boolean A1106CondExenIIGGAcu ;
   private boolean A1107CondExenIIGGProm ;
   private boolean AV19OrderedDsc ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean Cond_result ;
   private String AV31ColumnsSelectorXML ;
   private String AV32UserCustomValue ;
   private String AV39TFCondExenIIGG_SelsJson ;
   private String AV47TFCondExenIIGGOpe_SelsJson ;
   private String AV50TFCondexenIIGGNom_SelsJson ;
   private String AV54TFCondExenRelRef_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV53TFCondexenIIGGNom_Sel ;
   private String AV51TFCondexenIIGGNom ;
   private String AV57TFCondExenRelRef_Sel ;
   private String AV55TFCondExenRelRef ;
   private String A1108CondexenIIGGNom ;
   private String A2021CondExenRelRef ;
   private String AV77Condicion_exencion_iiggwwds_8_tfcondexeniiggnom ;
   private String AV79Condicion_exencion_iiggwwds_10_tfcondexenrelref ;
   private String lV77Condicion_exencion_iiggwwds_8_tfcondexeniiggnom ;
   private String lV79Condicion_exencion_iiggwwds_10_tfcondexenrelref ;
   private String AV17MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV41TFCondExenIIGG_Sels ;
   private GXSimpleCollection<String> AV48TFCondExenIIGGOpe_Sels ;
   private GXSimpleCollection<String> AV52TFCondexenIIGGNom_Sels ;
   private GXSimpleCollection<String> AV56TFCondExenRelRef_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private int[] P02FB2_A3CliCod ;
   private String[] P02FB2_A2021CondExenRelRef ;
   private String[] P02FB2_A1108CondexenIIGGNom ;
   private String[] P02FB2_A2238CondExenIIGGOpe ;
   private java.math.BigDecimal[] P02FB2_A2237CondExenIIGGVFi ;
   private boolean[] P02FB2_A1107CondExenIIGGProm ;
   private boolean[] P02FB2_A1106CondExenIIGGAcu ;
   private String[] P02FB2_A1105CondExenIIGG ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV71Condicion_exencion_iiggwwds_2_tfcondexeniigg_sels ;
   private GXSimpleCollection<String> AV76Condicion_exencion_iiggwwds_7_tfcondexeniiggope_sels ;
   private GXSimpleCollection<String> AV78Condicion_exencion_iiggwwds_9_tfcondexeniiggnom_sels ;
   private GXSimpleCollection<String> AV80Condicion_exencion_iiggwwds_11_tfcondexenrelref_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV28ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV29ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV30ColumnsSelector_Column ;
}

final  class condicion_exencion_iiggwwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02FB2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1105CondExenIIGG ,
                                          GXSimpleCollection<String> AV71Condicion_exencion_iiggwwds_2_tfcondexeniigg_sels ,
                                          String A2238CondExenIIGGOpe ,
                                          GXSimpleCollection<String> AV76Condicion_exencion_iiggwwds_7_tfcondexeniiggope_sels ,
                                          String A1108CondexenIIGGNom ,
                                          GXSimpleCollection<String> AV78Condicion_exencion_iiggwwds_9_tfcondexeniiggnom_sels ,
                                          String A2021CondExenRelRef ,
                                          GXSimpleCollection<String> AV80Condicion_exencion_iiggwwds_11_tfcondexenrelref_sels ,
                                          int AV71Condicion_exencion_iiggwwds_2_tfcondexeniigg_sels_size ,
                                          String AV70Condicion_exencion_iiggwwds_1_tfcondexeniigg ,
                                          byte AV72Condicion_exencion_iiggwwds_3_tfcondexeniiggacu_sel ,
                                          byte AV73Condicion_exencion_iiggwwds_4_tfcondexeniiggprom_sel ,
                                          java.math.BigDecimal AV74Condicion_exencion_iiggwwds_5_tfcondexeniiggvfi ,
                                          java.math.BigDecimal AV75Condicion_exencion_iiggwwds_6_tfcondexeniiggvfi_to ,
                                          int AV76Condicion_exencion_iiggwwds_7_tfcondexeniiggope_sels_size ,
                                          int AV78Condicion_exencion_iiggwwds_9_tfcondexeniiggnom_sels_size ,
                                          String AV77Condicion_exencion_iiggwwds_8_tfcondexeniiggnom ,
                                          int AV80Condicion_exencion_iiggwwds_11_tfcondexenrelref_sels_size ,
                                          String AV79Condicion_exencion_iiggwwds_10_tfcondexenrelref ,
                                          boolean A1106CondExenIIGGAcu ,
                                          boolean A1107CondExenIIGGProm ,
                                          java.math.BigDecimal A2237CondExenIIGGVFi ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          int AV59CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[6];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT CliCod, CondExenRelRef, CondexenIIGGNom, CondExenIIGGOpe, CondExenIIGGVFi, CondExenIIGGProm, CondExenIIGGAcu, CondExenIIGG FROM condicion_exencion_iigg" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV71Condicion_exencion_iiggwwds_2_tfcondexeniigg_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV70Condicion_exencion_iiggwwds_1_tfcondexeniigg)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CondExenIIGG) like LOWER(?))");
      }
      else
      {
         GXv_int10[1] = (byte)(1) ;
      }
      if ( AV71Condicion_exencion_iiggwwds_2_tfcondexeniigg_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV71Condicion_exencion_iiggwwds_2_tfcondexeniigg_sels, "CondExenIIGG IN (", ")")+")");
      }
      if ( AV72Condicion_exencion_iiggwwds_3_tfcondexeniiggacu_sel == 1 )
      {
         addWhere(sWhereString, "(CondExenIIGGAcu = TRUE)");
      }
      if ( AV72Condicion_exencion_iiggwwds_3_tfcondexeniiggacu_sel == 2 )
      {
         addWhere(sWhereString, "(CondExenIIGGAcu = FALSE)");
      }
      if ( AV73Condicion_exencion_iiggwwds_4_tfcondexeniiggprom_sel == 1 )
      {
         addWhere(sWhereString, "(CondExenIIGGProm = TRUE)");
      }
      if ( AV73Condicion_exencion_iiggwwds_4_tfcondexeniiggprom_sel == 2 )
      {
         addWhere(sWhereString, "(CondExenIIGGProm = FALSE)");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV74Condicion_exencion_iiggwwds_5_tfcondexeniiggvfi)==0) )
      {
         addWhere(sWhereString, "(CondExenIIGGVFi >= ?)");
      }
      else
      {
         GXv_int10[2] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV75Condicion_exencion_iiggwwds_6_tfcondexeniiggvfi_to)==0) )
      {
         addWhere(sWhereString, "(CondExenIIGGVFi <= ?)");
      }
      else
      {
         GXv_int10[3] = (byte)(1) ;
      }
      if ( AV76Condicion_exencion_iiggwwds_7_tfcondexeniiggope_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV76Condicion_exencion_iiggwwds_7_tfcondexeniiggope_sels, "CondExenIIGGOpe IN (", ")")+")");
      }
      if ( ( AV78Condicion_exencion_iiggwwds_9_tfcondexeniiggnom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV77Condicion_exencion_iiggwwds_8_tfcondexeniiggnom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CondexenIIGGNom) like LOWER(?))");
      }
      else
      {
         GXv_int10[4] = (byte)(1) ;
      }
      if ( AV78Condicion_exencion_iiggwwds_9_tfcondexeniiggnom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV78Condicion_exencion_iiggwwds_9_tfcondexeniiggnom_sels, "CondexenIIGGNom IN (", ")")+")");
      }
      if ( ( AV80Condicion_exencion_iiggwwds_11_tfcondexenrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV79Condicion_exencion_iiggwwds_10_tfcondexenrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CondExenRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int10[5] = (byte)(1) ;
      }
      if ( AV80Condicion_exencion_iiggwwds_11_tfcondexenrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV80Condicion_exencion_iiggwwds_11_tfcondexenrelref_sels, "CondExenRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CondExenIIGG" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CondExenIIGG DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CondExenIIGGAcu" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CondExenIIGGAcu DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CondExenIIGGProm" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CondExenIIGGProm DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CondExenIIGGVFi" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CondExenIIGGVFi DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CondExenIIGGOpe" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CondExenIIGGOpe DESC" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CondexenIIGGNom" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CondexenIIGGNom DESC" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CondExenRelRef" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CondExenRelRef DESC" ;
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
                  return conditional_P02FB2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).byteValue() , ((Number) dynConstraints[11]).byteValue() , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Boolean) dynConstraints[19]).booleanValue() , ((Boolean) dynConstraints[20]).booleanValue() , (java.math.BigDecimal)dynConstraints[21] , ((Number) dynConstraints[22]).shortValue() , ((Boolean) dynConstraints[23]).booleanValue() , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02FB2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
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
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[7], 20);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[8], 2);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[9], 2);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 40);
               }
               return;
      }
   }

}

