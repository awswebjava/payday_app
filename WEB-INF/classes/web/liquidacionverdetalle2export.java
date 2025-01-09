package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class liquidacionverdetalle2export extends GXProcedure
{
   public liquidacionverdetalle2export( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liquidacionverdetalle2export.class ), "" );
   }

   public liquidacionverdetalle2export( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      liquidacionverdetalle2export.this.aP1 = new String[] {""};
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
      liquidacionverdetalle2export.this.aP0 = aP0;
      liquidacionverdetalle2export.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV27IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "LiquidacionVerDetalle", GXv_boolean2) ;
      liquidacionverdetalle2export.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV27IsAuthorized = GXt_boolean1 ;
      if ( ! AV27IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV189Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      if ( AV27IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV109WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV109WWPContext = GXv_SdtWWPContext3[0] ;
         /* Execute user subroutine: 'OPENDOCUMENT' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV8CellRow = 1 ;
         AV22FirstColumn = 1 ;
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
      AV33Random = (int)(GXutil.random( )*10000) ;
      AV21Filename = "LiquidacionVerDetalle2Export-" + GXutil.trim( GXutil.str( AV33Random, 8, 0)) + ".xlsx" ;
      AV20ExcelDocument.Open(AV21Filename);
      /* Execute user subroutine: 'CHECKSTATUS' */
      S121 ();
      if (returnInSub) return;
      AV20ExcelDocument.Clear();
   }

   public void S131( )
   {
      /* 'WRITEFILTERS' Routine */
      returnInSub = false ;
      if ( ! ( (GXutil.strcmp("", AV180Mostrar)==0) ) )
      {
         AV20ExcelDocument.Cells(AV8CellRow, AV22FirstColumn+0, 1, 1).setText( "" );
         if ( GXutil.strcmp(GXutil.trim( AV180Mostrar), httpContext.getMessage( "RECIBO", "")) == 0 )
         {
            AV20ExcelDocument.Cells(AV8CellRow, AV22FirstColumn+0, 1, 1).setText( httpContext.getMessage( "Conceptos del recibo", "") );
         }
         else if ( GXutil.strcmp(GXutil.trim( AV180Mostrar), httpContext.getMessage( "TODOS", "")) == 0 )
         {
            AV20ExcelDocument.Cells(AV8CellRow, AV22FirstColumn+0, 1, 1).setText( httpContext.getMessage( "Todos", "") );
         }
      }
      if ( ! ( ( AV115TFDTipoConCod_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV20ExcelDocument ;
         GXv_int5[0] = (short)(AV8CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV22FirstColumn), httpContext.getMessage( "Tipo", "")) ;
         AV20ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionverdetalle2export.this.AV8CellRow = GXv_int5[0] ;
         AV26i = 1 ;
         AV190GXV1 = 1 ;
         while ( AV190GXV1 <= AV115TFDTipoConCod_Sels.size() )
         {
            AV116TFDTipoConCod_Sel = (String)AV115TFDTipoConCod_Sels.elementAt(-1+AV190GXV1) ;
            if ( AV26i == 1 )
            {
               AV20ExcelDocument.Cells(AV8CellRow, AV22FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV20ExcelDocument.Cells(AV8CellRow, AV22FirstColumn+1, 1, 1).setText( AV20ExcelDocument.Cells(AV8CellRow, AV22FirstColumn+1, 1, 1).getText()+", " );
            }
            AV20ExcelDocument.Cells(AV8CellRow, AV22FirstColumn+1, 1, 1).setText( AV20ExcelDocument.Cells(AV8CellRow, AV22FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomainconceptotipo.getDescription(httpContext,(String)AV116TFDTipoConCod_Sel), "") );
            AV26i = (long)(AV26i+1) ;
            AV190GXV1 = (int)(AV190GXV1+1) ;
         }
      }
      if ( ! ( ( AV184TFLiqDClasifAux_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV20ExcelDocument ;
         GXv_int5[0] = (short)(AV8CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV22FirstColumn), httpContext.getMessage( "Clasificación", "")) ;
         AV20ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionverdetalle2export.this.AV8CellRow = GXv_int5[0] ;
         AV26i = 1 ;
         AV191GXV2 = 1 ;
         while ( AV191GXV2 <= AV184TFLiqDClasifAux_Sels.size() )
         {
            AV185TFLiqDClasifAux_Sel = (String)AV184TFLiqDClasifAux_Sels.elementAt(-1+AV191GXV2) ;
            if ( AV26i == 1 )
            {
               AV20ExcelDocument.Cells(AV8CellRow, AV22FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV20ExcelDocument.Cells(AV8CellRow, AV22FirstColumn+1, 1, 1).setText( AV20ExcelDocument.Cells(AV8CellRow, AV22FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV185TFLiqDClasifAux_Sel, GXv_char7) ;
            liquidacionverdetalle2export.this.GXt_char6 = GXv_char7[0] ;
            AV20ExcelDocument.Cells(AV8CellRow, AV22FirstColumn+1, 1, 1).setText( AV20ExcelDocument.Cells(AV8CellRow, AV22FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV26i = (long)(AV26i+1) ;
            AV191GXV2 = (int)(AV191GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV183TFLiqDClasifAux)==0) ) )
         {
            GXv_exceldoc4[0] = AV20ExcelDocument ;
            GXv_int5[0] = (short)(AV8CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV22FirstColumn), httpContext.getMessage( "Clasificación", "")) ;
            AV20ExcelDocument = GXv_exceldoc4[0] ;
            liquidacionverdetalle2export.this.AV8CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV183TFLiqDClasifAux, GXv_char7) ;
            liquidacionverdetalle2export.this.GXt_char6 = GXv_char7[0] ;
            AV20ExcelDocument.Cells(AV8CellRow, AV22FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV119TFDConCodigo_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV20ExcelDocument ;
         GXv_int5[0] = (short)(AV8CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV22FirstColumn), httpContext.getMessage( "Código", "")) ;
         AV20ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionverdetalle2export.this.AV8CellRow = GXv_int5[0] ;
         AV26i = 1 ;
         AV192GXV3 = 1 ;
         while ( AV192GXV3 <= AV119TFDConCodigo_Sels.size() )
         {
            AV120TFDConCodigo_Sel = (String)AV119TFDConCodigo_Sels.elementAt(-1+AV192GXV3) ;
            if ( AV26i == 1 )
            {
               AV20ExcelDocument.Cells(AV8CellRow, AV22FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV20ExcelDocument.Cells(AV8CellRow, AV22FirstColumn+1, 1, 1).setText( AV20ExcelDocument.Cells(AV8CellRow, AV22FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV120TFDConCodigo_Sel, GXv_char7) ;
            liquidacionverdetalle2export.this.GXt_char6 = GXv_char7[0] ;
            AV20ExcelDocument.Cells(AV8CellRow, AV22FirstColumn+1, 1, 1).setText( AV20ExcelDocument.Cells(AV8CellRow, AV22FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV26i = (long)(AV26i+1) ;
            AV192GXV3 = (int)(AV192GXV3+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV118TFDConCodigo)==0) ) )
         {
            GXv_exceldoc4[0] = AV20ExcelDocument ;
            GXv_int5[0] = (short)(AV8CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV22FirstColumn), httpContext.getMessage( "Código", "")) ;
            AV20ExcelDocument = GXv_exceldoc4[0] ;
            liquidacionverdetalle2export.this.AV8CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV118TFDConCodigo, GXv_char7) ;
            liquidacionverdetalle2export.this.GXt_char6 = GXv_char7[0] ;
            AV20ExcelDocument.Cells(AV8CellRow, AV22FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV112TFDConDescrip_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV20ExcelDocument ;
         GXv_int5[0] = (short)(AV8CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV22FirstColumn), httpContext.getMessage( "Descripción", "")) ;
         AV20ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionverdetalle2export.this.AV8CellRow = GXv_int5[0] ;
         AV26i = 1 ;
         AV193GXV4 = 1 ;
         while ( AV193GXV4 <= AV112TFDConDescrip_Sels.size() )
         {
            AV113TFDConDescrip_Sel = (String)AV112TFDConDescrip_Sels.elementAt(-1+AV193GXV4) ;
            if ( AV26i == 1 )
            {
               AV20ExcelDocument.Cells(AV8CellRow, AV22FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV20ExcelDocument.Cells(AV8CellRow, AV22FirstColumn+1, 1, 1).setText( AV20ExcelDocument.Cells(AV8CellRow, AV22FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV113TFDConDescrip_Sel, GXv_char7) ;
            liquidacionverdetalle2export.this.GXt_char6 = GXv_char7[0] ;
            AV20ExcelDocument.Cells(AV8CellRow, AV22FirstColumn+1, 1, 1).setText( AV20ExcelDocument.Cells(AV8CellRow, AV22FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV26i = (long)(AV26i+1) ;
            AV193GXV4 = (int)(AV193GXV4+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV111TFDConDescrip)==0) ) )
         {
            GXv_exceldoc4[0] = AV20ExcelDocument ;
            GXv_int5[0] = (short)(AV8CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV22FirstColumn), httpContext.getMessage( "Descripción", "")) ;
            AV20ExcelDocument = GXv_exceldoc4[0] ;
            liquidacionverdetalle2export.this.AV8CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV111TFDConDescrip, GXv_char7) ;
            liquidacionverdetalle2export.this.GXt_char6 = GXv_char7[0] ;
            AV20ExcelDocument.Cells(AV8CellRow, AV22FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV121TFLiqDValUni)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV122TFLiqDValUni_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV20ExcelDocument ;
         GXv_int5[0] = (short)(AV8CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV22FirstColumn), httpContext.getMessage( "Base", "")) ;
         AV20ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionverdetalle2export.this.AV8CellRow = GXv_int5[0] ;
         AV20ExcelDocument.Cells(AV8CellRow, AV22FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV121TFLiqDValUni)) );
         GXv_exceldoc4[0] = AV20ExcelDocument ;
         GXv_int5[0] = (short)(AV8CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV22FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV20ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionverdetalle2export.this.AV8CellRow = GXv_int5[0] ;
         AV20ExcelDocument.Cells(AV8CellRow, AV22FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV122TFLiqDValUni_To)) );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV141TFLiqDImpReCalcu)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV142TFLiqDImpReCalcu_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV20ExcelDocument ;
         GXv_int5[0] = (short)(AV8CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV22FirstColumn), httpContext.getMessage( "Importe", "")) ;
         AV20ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionverdetalle2export.this.AV8CellRow = GXv_int5[0] ;
         AV20ExcelDocument.Cells(AV8CellRow, AV22FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV141TFLiqDImpReCalcu)) );
         GXv_exceldoc4[0] = AV20ExcelDocument ;
         GXv_int5[0] = (short)(AV8CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV22FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV20ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionverdetalle2export.this.AV8CellRow = GXv_int5[0] ;
         AV20ExcelDocument.Cells(AV8CellRow, AV22FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV142TFLiqDImpReCalcu_To)) );
      }
      if ( ! ( ( AV131TFLiqDErrorDesc_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV20ExcelDocument ;
         GXv_int5[0] = (short)(AV8CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV22FirstColumn), httpContext.getMessage( "Error", "")) ;
         AV20ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionverdetalle2export.this.AV8CellRow = GXv_int5[0] ;
         AV26i = 1 ;
         AV194GXV5 = 1 ;
         while ( AV194GXV5 <= AV131TFLiqDErrorDesc_Sels.size() )
         {
            AV132TFLiqDErrorDesc_Sel = (String)AV131TFLiqDErrorDesc_Sels.elementAt(-1+AV194GXV5) ;
            if ( AV26i == 1 )
            {
               AV20ExcelDocument.Cells(AV8CellRow, AV22FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV20ExcelDocument.Cells(AV8CellRow, AV22FirstColumn+1, 1, 1).setText( AV20ExcelDocument.Cells(AV8CellRow, AV22FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV132TFLiqDErrorDesc_Sel, GXv_char7) ;
            liquidacionverdetalle2export.this.GXt_char6 = GXv_char7[0] ;
            AV20ExcelDocument.Cells(AV8CellRow, AV22FirstColumn+1, 1, 1).setText( AV20ExcelDocument.Cells(AV8CellRow, AV22FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV26i = (long)(AV26i+1) ;
            AV194GXV5 = (int)(AV194GXV5+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV130TFLiqDErrorDesc)==0) ) )
         {
            GXv_exceldoc4[0] = AV20ExcelDocument ;
            GXv_int5[0] = (short)(AV8CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV22FirstColumn), httpContext.getMessage( "Error", "")) ;
            AV20ExcelDocument = GXv_exceldoc4[0] ;
            liquidacionverdetalle2export.this.AV8CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV130TFLiqDErrorDesc, GXv_char7) ;
            liquidacionverdetalle2export.this.GXt_char6 = GXv_char7[0] ;
            AV20ExcelDocument.Cells(AV8CellRow, AV22FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      AV8CellRow = (int)(AV8CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV108VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV35Session.getValue("LiquidacionVerDetalle2ColumnsSelector"), "") != 0 )
      {
         AV14ColumnsSelectorXML = AV35Session.getValue("LiquidacionVerDetalle2ColumnsSelector") ;
         AV11ColumnsSelector.fromxml(AV14ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      AV11ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV195GXV6 = 1 ;
      while ( AV195GXV6 <= AV11ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV12ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV11ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV195GXV6));
         if ( AV12ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV20ExcelDocument.Cells(AV8CellRow, (int)(AV22FirstColumn+AV108VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV12ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV12ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV12ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV20ExcelDocument.Cells(AV8CellRow, (int)(AV22FirstColumn+AV108VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV20ExcelDocument.Cells(AV8CellRow, (int)(AV22FirstColumn+AV108VisibleColumnCount), 1, 1).setColor( 11 );
            AV108VisibleColumnCount = (long)(AV108VisibleColumnCount+1) ;
         }
         AV195GXV6 = (int)(AV195GXV6+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV147FirstDataCellRow = (int)(AV8CellRow+1) ;
      AV197Liquidacionverdetalle2ds_1_mostrar = AV180Mostrar ;
      AV198Liquidacionverdetalle2ds_2_tfdtipoconcod_sels = AV115TFDTipoConCod_Sels ;
      AV199Liquidacionverdetalle2ds_3_tfliqdclasifaux = AV183TFLiqDClasifAux ;
      AV200Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels = AV184TFLiqDClasifAux_Sels ;
      AV201Liquidacionverdetalle2ds_5_tfdconcodigo = AV118TFDConCodigo ;
      AV202Liquidacionverdetalle2ds_6_tfdconcodigo_sels = AV119TFDConCodigo_Sels ;
      AV203Liquidacionverdetalle2ds_7_tfdcondescrip = AV111TFDConDescrip ;
      AV204Liquidacionverdetalle2ds_8_tfdcondescrip_sels = AV112TFDConDescrip_Sels ;
      AV205Liquidacionverdetalle2ds_9_tfliqdvaluni = AV121TFLiqDValUni ;
      AV206Liquidacionverdetalle2ds_10_tfliqdvaluni_to = AV122TFLiqDValUni_To ;
      AV207Liquidacionverdetalle2ds_11_tfliqdimprecalcu = AV141TFLiqDImpReCalcu ;
      AV208Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to = AV142TFLiqDImpReCalcu_To ;
      AV209Liquidacionverdetalle2ds_13_tfliqderrordesc = AV130TFLiqDErrorDesc ;
      AV210Liquidacionverdetalle2ds_14_tfliqderrordesc_sels = AV131TFLiqDErrorDesc_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A464DTipoConCod ,
                                           AV198Liquidacionverdetalle2ds_2_tfdtipoconcod_sels ,
                                           A2149LiqDClasifAux ,
                                           AV200Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels ,
                                           A394DConCodigo ,
                                           AV202Liquidacionverdetalle2ds_6_tfdconcodigo_sels ,
                                           A393DConDescrip ,
                                           AV204Liquidacionverdetalle2ds_8_tfdcondescrip_sels ,
                                           A270LiqDErrorDesc ,
                                           AV210Liquidacionverdetalle2ds_14_tfliqderrordesc_sels ,
                                           AV197Liquidacionverdetalle2ds_1_mostrar ,
                                           Integer.valueOf(AV198Liquidacionverdetalle2ds_2_tfdtipoconcod_sels.size()) ,
                                           Integer.valueOf(AV200Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels.size()) ,
                                           AV199Liquidacionverdetalle2ds_3_tfliqdclasifaux ,
                                           Integer.valueOf(AV202Liquidacionverdetalle2ds_6_tfdconcodigo_sels.size()) ,
                                           AV201Liquidacionverdetalle2ds_5_tfdconcodigo ,
                                           Integer.valueOf(AV204Liquidacionverdetalle2ds_8_tfdcondescrip_sels.size()) ,
                                           AV203Liquidacionverdetalle2ds_7_tfdcondescrip ,
                                           AV205Liquidacionverdetalle2ds_9_tfliqdvaluni ,
                                           AV206Liquidacionverdetalle2ds_10_tfliqdvaluni_to ,
                                           AV207Liquidacionverdetalle2ds_11_tfliqdimprecalcu ,
                                           AV208Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to ,
                                           Integer.valueOf(AV210Liquidacionverdetalle2ds_14_tfliqderrordesc_sels.size()) ,
                                           AV209Liquidacionverdetalle2ds_13_tfliqderrordesc ,
                                           Byte.valueOf(A502LiqDMostrar) ,
                                           A277LiqDValUni ,
                                           A764LiqDImpReCalcu ,
                                           Short.valueOf(AV31OrderedBy) ,
                                           Boolean.valueOf(AV32OrderedDsc) ,
                                           Integer.valueOf(AV9CliCod) ,
                                           Short.valueOf(AV18EmpCod) ,
                                           Integer.valueOf(AV29LiqNro) ,
                                           Integer.valueOf(AV28LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A31LiqNro) ,
                                           Integer.valueOf(A6LegNumero) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV199Liquidacionverdetalle2ds_3_tfliqdclasifaux = GXutil.concat( GXutil.rtrim( AV199Liquidacionverdetalle2ds_3_tfliqdclasifaux), "%", "") ;
      lV201Liquidacionverdetalle2ds_5_tfdconcodigo = GXutil.padr( GXutil.rtrim( AV201Liquidacionverdetalle2ds_5_tfdconcodigo), 10, "%") ;
      lV203Liquidacionverdetalle2ds_7_tfdcondescrip = GXutil.concat( GXutil.rtrim( AV203Liquidacionverdetalle2ds_7_tfdcondescrip), "%", "") ;
      lV209Liquidacionverdetalle2ds_13_tfliqderrordesc = GXutil.concat( GXutil.rtrim( AV209Liquidacionverdetalle2ds_13_tfliqderrordesc), "%", "") ;
      /* Using cursor P01JA2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV18EmpCod), Integer.valueOf(AV29LiqNro), Integer.valueOf(AV28LegNumero), lV199Liquidacionverdetalle2ds_3_tfliqdclasifaux, lV201Liquidacionverdetalle2ds_5_tfdconcodigo, lV203Liquidacionverdetalle2ds_7_tfdcondescrip, AV205Liquidacionverdetalle2ds_9_tfliqdvaluni, AV206Liquidacionverdetalle2ds_10_tfliqdvaluni_to, AV207Liquidacionverdetalle2ds_11_tfliqdimprecalcu, AV208Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to, lV209Liquidacionverdetalle2ds_13_tfliqderrordesc});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P01JA2_A3CliCod[0] ;
         A6LegNumero = P01JA2_A6LegNumero[0] ;
         A31LiqNro = P01JA2_A31LiqNro[0] ;
         A1EmpCod = P01JA2_A1EmpCod[0] ;
         A270LiqDErrorDesc = P01JA2_A270LiqDErrorDesc[0] ;
         n270LiqDErrorDesc = P01JA2_n270LiqDErrorDesc[0] ;
         A764LiqDImpReCalcu = P01JA2_A764LiqDImpReCalcu[0] ;
         A277LiqDValUni = P01JA2_A277LiqDValUni[0] ;
         n277LiqDValUni = P01JA2_n277LiqDValUni[0] ;
         A393DConDescrip = P01JA2_A393DConDescrip[0] ;
         A394DConCodigo = P01JA2_A394DConCodigo[0] ;
         A2149LiqDClasifAux = P01JA2_A2149LiqDClasifAux[0] ;
         A464DTipoConCod = P01JA2_A464DTipoConCod[0] ;
         A502LiqDMostrar = P01JA2_A502LiqDMostrar[0] ;
         A269LiqDCanti = P01JA2_A269LiqDCanti[0] ;
         n269LiqDCanti = P01JA2_n269LiqDCanti[0] ;
         A876LiqDReFormulaHTML = P01JA2_A876LiqDReFormulaHTML[0] ;
         n876LiqDReFormulaHTML = P01JA2_n876LiqDReFormulaHTML[0] ;
         A1072LiqDLogRecal = P01JA2_A1072LiqDLogRecal[0] ;
         A1134LiqDOrdVis = P01JA2_A1134LiqDOrdVis[0] ;
         A81LiqDSecuencial = P01JA2_A81LiqDSecuencial[0] ;
         AV8CellRow = (int)(AV8CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV108VisibleColumnCount = 0 ;
         AV211GXV7 = 1 ;
         while ( AV211GXV7 <= AV11ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV12ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV11ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV211GXV7));
            if ( AV12ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV12ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "DTipoConCod") == 0 )
               {
                  AV20ExcelDocument.Cells(AV8CellRow, (int)(AV22FirstColumn+AV108VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomainconceptotipo.getDescription(httpContext,(String)A464DTipoConCod), "") );
               }
               else if ( GXutil.strcmp(AV12ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqDClasifAux") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A2149LiqDClasifAux, GXv_char7) ;
                  liquidacionverdetalle2export.this.GXt_char6 = GXv_char7[0] ;
                  AV20ExcelDocument.Cells(AV8CellRow, (int)(AV22FirstColumn+AV108VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV12ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "DConCodigo") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A394DConCodigo, GXv_char7) ;
                  liquidacionverdetalle2export.this.GXt_char6 = GXv_char7[0] ;
                  AV20ExcelDocument.Cells(AV8CellRow, (int)(AV22FirstColumn+AV108VisibleColumnCount), 1, 1).setText( GXt_char6 );
                  if ( ! (GXutil.strcmp("", A270LiqDErrorDesc)==0) )
                  {
                     AV20ExcelDocument.Cells(AV8CellRow, (int)(AV22FirstColumn+AV108VisibleColumnCount), 1, 1).setColor( GXutil.getColor( 251, 110, 82) );
                  }
               }
               else if ( GXutil.strcmp(AV12ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "DConDescrip") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A393DConDescrip, GXv_char7) ;
                  liquidacionverdetalle2export.this.GXt_char6 = GXv_char7[0] ;
                  AV20ExcelDocument.Cells(AV8CellRow, (int)(AV22FirstColumn+AV108VisibleColumnCount), 1, 1).setText( GXt_char6 );
                  if ( ! (GXutil.strcmp("", A270LiqDErrorDesc)==0) )
                  {
                     AV20ExcelDocument.Cells(AV8CellRow, (int)(AV22FirstColumn+AV108VisibleColumnCount), 1, 1).setColor( GXutil.getColor( 251, 110, 82) );
                  }
               }
               else if ( GXutil.strcmp(AV12ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqDValUni") == 0 )
               {
                  AV20ExcelDocument.Cells(AV8CellRow, (int)(AV22FirstColumn+AV108VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A277LiqDValUni)) );
               }
               else if ( GXutil.strcmp(AV12ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqDCanti") == 0 )
               {
                  AV20ExcelDocument.Cells(AV8CellRow, (int)(AV22FirstColumn+AV108VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A269LiqDCanti)) );
               }
               else if ( GXutil.strcmp(AV12ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqDImpReCalcu") == 0 )
               {
                  AV20ExcelDocument.Cells(AV8CellRow, (int)(AV22FirstColumn+AV108VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A764LiqDImpReCalcu)) );
                  if ( ! (GXutil.strcmp("", A270LiqDErrorDesc)==0) )
                  {
                     AV20ExcelDocument.Cells(AV8CellRow, (int)(AV22FirstColumn+AV108VisibleColumnCount), 1, 1).setColor( GXutil.getColor( 221, 75, 57) );
                  }
               }
               else if ( GXutil.strcmp(AV12ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqDReFormulaHTML") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( A876LiqDReFormulaHTML, 1, 1000), GXv_char7) ;
                  liquidacionverdetalle2export.this.GXt_char6 = GXv_char7[0] ;
                  AV20ExcelDocument.Cells(AV8CellRow, (int)(AV22FirstColumn+AV108VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV12ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqDErrorDesc") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A270LiqDErrorDesc, GXv_char7) ;
                  liquidacionverdetalle2export.this.GXt_char6 = GXv_char7[0] ;
                  AV20ExcelDocument.Cells(AV8CellRow, (int)(AV22FirstColumn+AV108VisibleColumnCount), 1, 1).setText( GXt_char6 );
                  if ( ! (GXutil.strcmp("", A270LiqDErrorDesc)==0) )
                  {
                     AV20ExcelDocument.Cells(AV8CellRow, (int)(AV22FirstColumn+AV108VisibleColumnCount), 1, 1).setColor( GXutil.getColor( 221, 75, 57) );
                  }
               }
               else if ( GXutil.strcmp(AV12ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqDLogRecal") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( A1072LiqDLogRecal, 1, 1000), GXv_char7) ;
                  liquidacionverdetalle2export.this.GXt_char6 = GXv_char7[0] ;
                  AV20ExcelDocument.Cells(AV8CellRow, (int)(AV22FirstColumn+AV108VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               AV108VisibleColumnCount = (long)(AV108VisibleColumnCount+1) ;
            }
            AV211GXV7 = (int)(AV211GXV7+1) ;
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
      /* Execute user subroutine: 'WRITETOTALIZERS' */
      S191 ();
      if (returnInSub) return;
   }

   public void S191( )
   {
      /* 'WRITETOTALIZERS' Routine */
      returnInSub = false ;
      AV108VisibleColumnCount = 0 ;
      AV212GXV8 = 1 ;
      while ( AV212GXV8 <= AV11ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV12ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV11ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV212GXV8));
         if ( AV12ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            if ( GXutil.strcmp(AV12ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqDImpReCalcu") == 0 )
            {
               AV20ExcelDocument.Cells(AV8CellRow+1, (int)(AV22FirstColumn+AV108VisibleColumnCount), 1, 1).setText( GXutil.format( "=SUM(%1%2:%1%3)", GXutil.chr( (short)(GXutil.asc( "A")+AV108VisibleColumnCount)), GXutil.trim( GXutil.str( AV147FirstDataCellRow, 8, 0)), GXutil.trim( GXutil.str( AV8CellRow, 8, 0)), "", "", "", "", "", "") );
            }
            AV108VisibleColumnCount = (long)(AV108VisibleColumnCount+1) ;
         }
         AV212GXV8 = (int)(AV212GXV8+1) ;
      }
      AV20ExcelDocument.Cells(AV8CellRow+1, AV22FirstColumn, 1, (int)(AV108VisibleColumnCount)).setItalic( (short)(1) );
      AV20ExcelDocument.Cells(AV8CellRow+1, AV22FirstColumn, 1, (int)(AV108VisibleColumnCount)).setBold( (short)(1) );
   }

   public void S201( )
   {
      /* 'CLOSEDOCUMENT' Routine */
      returnInSub = false ;
      AV20ExcelDocument.Save();
      /* Execute user subroutine: 'CHECKSTATUS' */
      S121 ();
      if (returnInSub) return;
      AV20ExcelDocument.Close();
   }

   public void S121( )
   {
      /* 'CHECKSTATUS' Routine */
      returnInSub = false ;
      if ( AV20ExcelDocument.getErrCode() != 0 )
      {
         AV21Filename = "" ;
         AV19ErrorMessage = AV20ExcelDocument.getErrDescription() ;
         AV20ExcelDocument.Close();
         returnInSub = true;
         if (true) return;
      }
   }

   public void S151( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      AV11ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8[0] = AV11ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "DTipoConCod", "", "Tipo", true, "") ;
      AV11ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV11ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LiqDClasifAux", "", "Clasificación", true, "") ;
      AV11ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV11ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "DConCodigo", "", "Código", true, "") ;
      AV11ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV11ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "DConDescrip", "", "Descripción", true, "") ;
      AV11ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV11ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LiqDValUni", "", "Base", false, "") ;
      AV11ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV11ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LiqDCanti", "", "Cantidad", true, "") ;
      AV11ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV11ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LiqDImpReCalcu", "", "Importe", true, "") ;
      AV11ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV11ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LiqDReFormulaHTML", "", "Fórmula", false, "") ;
      AV11ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV11ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LiqDErrorDesc", "", "Error", false, "") ;
      AV11ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV11ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LiqDLogRecal", "", "Log", true, "") ;
      AV11ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV107UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "LiquidacionVerDetalle2ColumnsSelector", GXv_char7) ;
      liquidacionverdetalle2export.this.GXt_char6 = GXv_char7[0] ;
      AV107UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV107UserCustomValue)==0) ) )
      {
         AV13ColumnsSelectorAux.fromxml(AV107UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector8[0] = AV13ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector9[0] = AV11ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, GXv_SdtWWPColumnsSelector9) ;
         AV13ColumnsSelectorAux = GXv_SdtWWPColumnsSelector8[0] ;
         AV11ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
   }

   public void S211( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV35Session.getValue("LiquidacionVerDetalle2GridState"), "") == 0 )
      {
         AV23GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "LiquidacionVerDetalle2GridState"), null, null);
      }
      else
      {
         AV23GridState.fromxml(AV35Session.getValue("LiquidacionVerDetalle2GridState"), null, null);
      }
      AV31OrderedBy = AV23GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV32OrderedDsc = AV23GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV213GXV9 = 1 ;
      while ( AV213GXV9 <= AV23GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV24GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV23GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV213GXV9));
         if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "MOSTRAR") == 0 )
         {
            AV180Mostrar = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDTIPOCONCOD_SEL") == 0 )
         {
            AV114TFDTipoConCod_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV115TFDTipoConCod_Sels.fromJSonString(AV114TFDTipoConCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDCLASIFAUX") == 0 )
         {
            AV183TFLiqDClasifAux = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDCLASIFAUX_SEL") == 0 )
         {
            AV182TFLiqDClasifAux_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV184TFLiqDClasifAux_Sels.fromJSonString(AV182TFLiqDClasifAux_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDCONCODIGO") == 0 )
         {
            AV118TFDConCodigo = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDCONCODIGO_SEL") == 0 )
         {
            AV117TFDConCodigo_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV119TFDConCodigo_Sels.fromJSonString(AV117TFDConCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDCONDESCRIP") == 0 )
         {
            AV111TFDConDescrip = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDCONDESCRIP_SEL") == 0 )
         {
            AV110TFDConDescrip_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV112TFDConDescrip_Sels.fromJSonString(AV110TFDConDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDVALUNI") == 0 )
         {
            AV121TFLiqDValUni = CommonUtil.decimalVal( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV122TFLiqDValUni_To = CommonUtil.decimalVal( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDIMPRECALCU") == 0 )
         {
            AV141TFLiqDImpReCalcu = CommonUtil.decimalVal( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV142TFLiqDImpReCalcu_To = CommonUtil.decimalVal( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDERRORDESC") == 0 )
         {
            AV130TFLiqDErrorDesc = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDERRORDESC_SEL") == 0 )
         {
            AV129TFLiqDErrorDesc_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV131TFLiqDErrorDesc_Sels.fromJSonString(AV129TFLiqDErrorDesc_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&AUXMENUOPCCOD") == 0 )
         {
            AV186auxMenuOpcCod = (short)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&CLICOD") == 0 )
         {
            AV9CliCod = (int)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&EMPCOD") == 0 )
         {
            AV18EmpCod = (short)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&LIQNRO") == 0 )
         {
            AV29LiqNro = (int)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&LEGNUMERO") == 0 )
         {
            AV28LegNumero = (int)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         AV213GXV9 = (int)(AV213GXV9+1) ;
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
      this.aP0[0] = liquidacionverdetalle2export.this.AV21Filename;
      this.aP1[0] = liquidacionverdetalle2export.this.AV19ErrorMessage;
      CloseOpenCursors();
      AV20ExcelDocument.cleanup();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV21Filename = "" ;
      AV19ErrorMessage = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV189Pgmname = "" ;
      AV109WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV20ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV180Mostrar = "" ;
      AV115TFDTipoConCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV116TFDTipoConCod_Sel = "" ;
      AV184TFLiqDClasifAux_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV185TFLiqDClasifAux_Sel = "" ;
      AV183TFLiqDClasifAux = "" ;
      AV119TFDConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV120TFDConCodigo_Sel = "" ;
      AV118TFDConCodigo = "" ;
      AV112TFDConDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV113TFDConDescrip_Sel = "" ;
      AV111TFDConDescrip = "" ;
      AV121TFLiqDValUni = DecimalUtil.ZERO ;
      AV122TFLiqDValUni_To = DecimalUtil.ZERO ;
      AV141TFLiqDImpReCalcu = DecimalUtil.ZERO ;
      AV142TFLiqDImpReCalcu_To = DecimalUtil.ZERO ;
      AV131TFLiqDErrorDesc_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV132TFLiqDErrorDesc_Sel = "" ;
      AV130TFLiqDErrorDesc = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV35Session = httpContext.getWebSession();
      AV14ColumnsSelectorXML = "" ;
      AV11ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV12ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A464DTipoConCod = "" ;
      A2149LiqDClasifAux = "" ;
      A394DConCodigo = "" ;
      A270LiqDErrorDesc = "" ;
      A393DConDescrip = "" ;
      A277LiqDValUni = DecimalUtil.ZERO ;
      A269LiqDCanti = DecimalUtil.ZERO ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      A876LiqDReFormulaHTML = "" ;
      A1072LiqDLogRecal = "" ;
      AV197Liquidacionverdetalle2ds_1_mostrar = "" ;
      AV198Liquidacionverdetalle2ds_2_tfdtipoconcod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV199Liquidacionverdetalle2ds_3_tfliqdclasifaux = "" ;
      AV200Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV201Liquidacionverdetalle2ds_5_tfdconcodigo = "" ;
      AV202Liquidacionverdetalle2ds_6_tfdconcodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV203Liquidacionverdetalle2ds_7_tfdcondescrip = "" ;
      AV204Liquidacionverdetalle2ds_8_tfdcondescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV205Liquidacionverdetalle2ds_9_tfliqdvaluni = DecimalUtil.ZERO ;
      AV206Liquidacionverdetalle2ds_10_tfliqdvaluni_to = DecimalUtil.ZERO ;
      AV207Liquidacionverdetalle2ds_11_tfliqdimprecalcu = DecimalUtil.ZERO ;
      AV208Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to = DecimalUtil.ZERO ;
      AV209Liquidacionverdetalle2ds_13_tfliqderrordesc = "" ;
      AV210Liquidacionverdetalle2ds_14_tfliqderrordesc_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV199Liquidacionverdetalle2ds_3_tfliqdclasifaux = "" ;
      lV201Liquidacionverdetalle2ds_5_tfdconcodigo = "" ;
      lV203Liquidacionverdetalle2ds_7_tfdcondescrip = "" ;
      lV209Liquidacionverdetalle2ds_13_tfliqderrordesc = "" ;
      P01JA2_A3CliCod = new int[1] ;
      P01JA2_A6LegNumero = new int[1] ;
      P01JA2_A31LiqNro = new int[1] ;
      P01JA2_A1EmpCod = new short[1] ;
      P01JA2_A270LiqDErrorDesc = new String[] {""} ;
      P01JA2_n270LiqDErrorDesc = new boolean[] {false} ;
      P01JA2_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01JA2_A277LiqDValUni = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01JA2_n277LiqDValUni = new boolean[] {false} ;
      P01JA2_A393DConDescrip = new String[] {""} ;
      P01JA2_A394DConCodigo = new String[] {""} ;
      P01JA2_A2149LiqDClasifAux = new String[] {""} ;
      P01JA2_A464DTipoConCod = new String[] {""} ;
      P01JA2_A502LiqDMostrar = new byte[1] ;
      P01JA2_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01JA2_n269LiqDCanti = new boolean[] {false} ;
      P01JA2_A876LiqDReFormulaHTML = new String[] {""} ;
      P01JA2_n876LiqDReFormulaHTML = new boolean[] {false} ;
      P01JA2_A1072LiqDLogRecal = new String[] {""} ;
      P01JA2_A1134LiqDOrdVis = new short[1] ;
      P01JA2_A81LiqDSecuencial = new int[1] ;
      AV107UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV13ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV23GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV24GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV114TFDTipoConCod_SelsJson = "" ;
      AV182TFLiqDClasifAux_SelsJson = "" ;
      AV117TFDConCodigo_SelsJson = "" ;
      AV110TFDConDescrip_SelsJson = "" ;
      AV129TFLiqDErrorDesc_SelsJson = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liquidacionverdetalle2export__default(),
         new Object[] {
             new Object[] {
            P01JA2_A3CliCod, P01JA2_A6LegNumero, P01JA2_A31LiqNro, P01JA2_A1EmpCod, P01JA2_A270LiqDErrorDesc, P01JA2_n270LiqDErrorDesc, P01JA2_A764LiqDImpReCalcu, P01JA2_A277LiqDValUni, P01JA2_n277LiqDValUni, P01JA2_A393DConDescrip,
            P01JA2_A394DConCodigo, P01JA2_A2149LiqDClasifAux, P01JA2_A464DTipoConCod, P01JA2_A502LiqDMostrar, P01JA2_A269LiqDCanti, P01JA2_n269LiqDCanti, P01JA2_A876LiqDReFormulaHTML, P01JA2_n876LiqDReFormulaHTML, P01JA2_A1072LiqDLogRecal, P01JA2_A1134LiqDOrdVis,
            P01JA2_A81LiqDSecuencial
            }
         }
      );
      AV189Pgmname = "LiquidacionVerDetalle2Export" ;
      /* GeneXus formulas. */
      AV189Pgmname = "LiquidacionVerDetalle2Export" ;
      Gx_err = (short)(0) ;
   }

   private byte A502LiqDMostrar ;
   private short GXv_int5[] ;
   private short AV31OrderedBy ;
   private short AV18EmpCod ;
   private short A1EmpCod ;
   private short A1134LiqDOrdVis ;
   private short AV186auxMenuOpcCod ;
   private short Gx_err ;
   private int AV8CellRow ;
   private int AV22FirstColumn ;
   private int AV33Random ;
   private int AV190GXV1 ;
   private int AV191GXV2 ;
   private int AV192GXV3 ;
   private int AV193GXV4 ;
   private int AV194GXV5 ;
   private int AV195GXV6 ;
   private int AV147FirstDataCellRow ;
   private int AV198Liquidacionverdetalle2ds_2_tfdtipoconcod_sels_size ;
   private int AV200Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels_size ;
   private int AV202Liquidacionverdetalle2ds_6_tfdconcodigo_sels_size ;
   private int AV204Liquidacionverdetalle2ds_8_tfdcondescrip_sels_size ;
   private int AV210Liquidacionverdetalle2ds_14_tfliqderrordesc_sels_size ;
   private int AV9CliCod ;
   private int AV29LiqNro ;
   private int AV28LegNumero ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private int A81LiqDSecuencial ;
   private int AV211GXV7 ;
   private int AV212GXV8 ;
   private int AV213GXV9 ;
   private long AV26i ;
   private long AV108VisibleColumnCount ;
   private java.math.BigDecimal AV121TFLiqDValUni ;
   private java.math.BigDecimal AV122TFLiqDValUni_To ;
   private java.math.BigDecimal AV141TFLiqDImpReCalcu ;
   private java.math.BigDecimal AV142TFLiqDImpReCalcu_To ;
   private java.math.BigDecimal A277LiqDValUni ;
   private java.math.BigDecimal A269LiqDCanti ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private java.math.BigDecimal AV205Liquidacionverdetalle2ds_9_tfliqdvaluni ;
   private java.math.BigDecimal AV206Liquidacionverdetalle2ds_10_tfliqdvaluni_to ;
   private java.math.BigDecimal AV207Liquidacionverdetalle2ds_11_tfliqdimprecalcu ;
   private java.math.BigDecimal AV208Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to ;
   private String AV189Pgmname ;
   private String AV180Mostrar ;
   private String AV116TFDTipoConCod_Sel ;
   private String AV120TFDConCodigo_Sel ;
   private String AV118TFDConCodigo ;
   private String A464DTipoConCod ;
   private String A394DConCodigo ;
   private String AV197Liquidacionverdetalle2ds_1_mostrar ;
   private String AV201Liquidacionverdetalle2ds_5_tfdconcodigo ;
   private String scmdbuf ;
   private String lV201Liquidacionverdetalle2ds_5_tfdconcodigo ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV27IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV32OrderedDsc ;
   private boolean n270LiqDErrorDesc ;
   private boolean n277LiqDValUni ;
   private boolean n269LiqDCanti ;
   private boolean n876LiqDReFormulaHTML ;
   private String AV14ColumnsSelectorXML ;
   private String A876LiqDReFormulaHTML ;
   private String A1072LiqDLogRecal ;
   private String AV107UserCustomValue ;
   private String AV114TFDTipoConCod_SelsJson ;
   private String AV182TFLiqDClasifAux_SelsJson ;
   private String AV117TFDConCodigo_SelsJson ;
   private String AV110TFDConDescrip_SelsJson ;
   private String AV129TFLiqDErrorDesc_SelsJson ;
   private String AV21Filename ;
   private String AV19ErrorMessage ;
   private String AV185TFLiqDClasifAux_Sel ;
   private String AV183TFLiqDClasifAux ;
   private String AV113TFDConDescrip_Sel ;
   private String AV111TFDConDescrip ;
   private String AV132TFLiqDErrorDesc_Sel ;
   private String AV130TFLiqDErrorDesc ;
   private String A2149LiqDClasifAux ;
   private String A270LiqDErrorDesc ;
   private String A393DConDescrip ;
   private String AV199Liquidacionverdetalle2ds_3_tfliqdclasifaux ;
   private String AV203Liquidacionverdetalle2ds_7_tfdcondescrip ;
   private String AV209Liquidacionverdetalle2ds_13_tfliqderrordesc ;
   private String lV199Liquidacionverdetalle2ds_3_tfliqdclasifaux ;
   private String lV203Liquidacionverdetalle2ds_7_tfdcondescrip ;
   private String lV209Liquidacionverdetalle2ds_13_tfliqderrordesc ;
   private com.genexus.webpanels.WebSession AV35Session ;
   private GXSimpleCollection<String> AV115TFDTipoConCod_Sels ;
   private GXSimpleCollection<String> AV119TFDConCodigo_Sels ;
   private GXSimpleCollection<String> AV184TFLiqDClasifAux_Sels ;
   private GXSimpleCollection<String> AV112TFDConDescrip_Sels ;
   private GXSimpleCollection<String> AV131TFLiqDErrorDesc_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private int[] P01JA2_A3CliCod ;
   private int[] P01JA2_A6LegNumero ;
   private int[] P01JA2_A31LiqNro ;
   private short[] P01JA2_A1EmpCod ;
   private String[] P01JA2_A270LiqDErrorDesc ;
   private boolean[] P01JA2_n270LiqDErrorDesc ;
   private java.math.BigDecimal[] P01JA2_A764LiqDImpReCalcu ;
   private java.math.BigDecimal[] P01JA2_A277LiqDValUni ;
   private boolean[] P01JA2_n277LiqDValUni ;
   private String[] P01JA2_A393DConDescrip ;
   private String[] P01JA2_A394DConCodigo ;
   private String[] P01JA2_A2149LiqDClasifAux ;
   private String[] P01JA2_A464DTipoConCod ;
   private byte[] P01JA2_A502LiqDMostrar ;
   private java.math.BigDecimal[] P01JA2_A269LiqDCanti ;
   private boolean[] P01JA2_n269LiqDCanti ;
   private String[] P01JA2_A876LiqDReFormulaHTML ;
   private boolean[] P01JA2_n876LiqDReFormulaHTML ;
   private String[] P01JA2_A1072LiqDLogRecal ;
   private short[] P01JA2_A1134LiqDOrdVis ;
   private int[] P01JA2_A81LiqDSecuencial ;
   private com.genexus.gxoffice.ExcelDoc AV20ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV198Liquidacionverdetalle2ds_2_tfdtipoconcod_sels ;
   private GXSimpleCollection<String> AV202Liquidacionverdetalle2ds_6_tfdconcodigo_sels ;
   private GXSimpleCollection<String> AV200Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels ;
   private GXSimpleCollection<String> AV204Liquidacionverdetalle2ds_8_tfdcondescrip_sels ;
   private GXSimpleCollection<String> AV210Liquidacionverdetalle2ds_14_tfliqderrordesc_sels ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV11ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV13ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV12ColumnsSelector_Column ;
   private web.wwpbaseobjects.SdtWWPGridState AV23GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV24GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPContext AV109WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
}

final  class liquidacionverdetalle2export__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01JA2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A464DTipoConCod ,
                                          GXSimpleCollection<String> AV198Liquidacionverdetalle2ds_2_tfdtipoconcod_sels ,
                                          String A2149LiqDClasifAux ,
                                          GXSimpleCollection<String> AV200Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels ,
                                          String A394DConCodigo ,
                                          GXSimpleCollection<String> AV202Liquidacionverdetalle2ds_6_tfdconcodigo_sels ,
                                          String A393DConDescrip ,
                                          GXSimpleCollection<String> AV204Liquidacionverdetalle2ds_8_tfdcondescrip_sels ,
                                          String A270LiqDErrorDesc ,
                                          GXSimpleCollection<String> AV210Liquidacionverdetalle2ds_14_tfliqderrordesc_sels ,
                                          String AV197Liquidacionverdetalle2ds_1_mostrar ,
                                          int AV198Liquidacionverdetalle2ds_2_tfdtipoconcod_sels_size ,
                                          int AV200Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels_size ,
                                          String AV199Liquidacionverdetalle2ds_3_tfliqdclasifaux ,
                                          int AV202Liquidacionverdetalle2ds_6_tfdconcodigo_sels_size ,
                                          String AV201Liquidacionverdetalle2ds_5_tfdconcodigo ,
                                          int AV204Liquidacionverdetalle2ds_8_tfdcondescrip_sels_size ,
                                          String AV203Liquidacionverdetalle2ds_7_tfdcondescrip ,
                                          java.math.BigDecimal AV205Liquidacionverdetalle2ds_9_tfliqdvaluni ,
                                          java.math.BigDecimal AV206Liquidacionverdetalle2ds_10_tfliqdvaluni_to ,
                                          java.math.BigDecimal AV207Liquidacionverdetalle2ds_11_tfliqdimprecalcu ,
                                          java.math.BigDecimal AV208Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to ,
                                          int AV210Liquidacionverdetalle2ds_14_tfliqderrordesc_sels_size ,
                                          String AV209Liquidacionverdetalle2ds_13_tfliqderrordesc ,
                                          byte A502LiqDMostrar ,
                                          java.math.BigDecimal A277LiqDValUni ,
                                          java.math.BigDecimal A764LiqDImpReCalcu ,
                                          short AV31OrderedBy ,
                                          boolean AV32OrderedDsc ,
                                          int AV9CliCod ,
                                          short AV18EmpCod ,
                                          int AV29LiqNro ,
                                          int AV28LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A31LiqNro ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[12];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT CliCod, LegNumero, LiqNro, EmpCod, LiqDErrorDesc, LiqDImpReCalcu, LiqDValUni, DConDescrip, DConCodigo, LiqDClasifAux, DTipoConCod, LiqDMostrar, LiqDCanti," ;
      scmdbuf += " LiqDReFormulaHTML, LiqDLogRecal, LiqDOrdVis, LiqDSecuencial FROM LiquidacionDetalle" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?)");
      if ( GXutil.strcmp(AV197Liquidacionverdetalle2ds_1_mostrar, httpContext.getMessage( httpContext.getMessage( "RECIBO", ""), "")) == 0 )
      {
         addWhere(sWhereString, "(LiqDMostrar = 3)");
      }
      if ( AV198Liquidacionverdetalle2ds_2_tfdtipoconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV198Liquidacionverdetalle2ds_2_tfdtipoconcod_sels, "DTipoConCod IN (", ")")+")");
      }
      if ( ( AV200Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV199Liquidacionverdetalle2ds_3_tfliqdclasifaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqDClasifAux) like LOWER(?))");
      }
      else
      {
         GXv_int10[4] = (byte)(1) ;
      }
      if ( AV200Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV200Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels, "LiqDClasifAux IN (", ")")+")");
      }
      if ( ( AV202Liquidacionverdetalle2ds_6_tfdconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV201Liquidacionverdetalle2ds_5_tfdconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(DConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int10[5] = (byte)(1) ;
      }
      if ( AV202Liquidacionverdetalle2ds_6_tfdconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV202Liquidacionverdetalle2ds_6_tfdconcodigo_sels, "DConCodigo IN (", ")")+")");
      }
      if ( ( AV204Liquidacionverdetalle2ds_8_tfdcondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV203Liquidacionverdetalle2ds_7_tfdcondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(DConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      if ( AV204Liquidacionverdetalle2ds_8_tfdcondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV204Liquidacionverdetalle2ds_8_tfdcondescrip_sels, "DConDescrip IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV205Liquidacionverdetalle2ds_9_tfliqdvaluni)==0) )
      {
         addWhere(sWhereString, "(LiqDValUni >= ?)");
      }
      else
      {
         GXv_int10[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV206Liquidacionverdetalle2ds_10_tfliqdvaluni_to)==0) )
      {
         addWhere(sWhereString, "(LiqDValUni <= ?)");
      }
      else
      {
         GXv_int10[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV207Liquidacionverdetalle2ds_11_tfliqdimprecalcu)==0) )
      {
         addWhere(sWhereString, "(LiqDImpReCalcu >= ?)");
      }
      else
      {
         GXv_int10[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV208Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to)==0) )
      {
         addWhere(sWhereString, "(LiqDImpReCalcu <= ?)");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( ( AV210Liquidacionverdetalle2ds_14_tfliqderrordesc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV209Liquidacionverdetalle2ds_13_tfliqderrordesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqDErrorDesc) like LOWER(?))");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      if ( AV210Liquidacionverdetalle2ds_14_tfliqderrordesc_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV210Liquidacionverdetalle2ds_14_tfliqderrordesc_sels, "LiqDErrorDesc IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( AV31OrderedBy == 1 )
      {
         scmdbuf += " ORDER BY CliCod, EmpCod, LiqNro, LegNumero, LiqDMostrar DESC, LiqDOrdVis" ;
      }
      else if ( ( AV31OrderedBy == 2 ) && ! AV32OrderedDsc )
      {
         scmdbuf += " ORDER BY DTipoConCod" ;
      }
      else if ( ( AV31OrderedBy == 2 ) && ( AV32OrderedDsc ) )
      {
         scmdbuf += " ORDER BY DTipoConCod DESC" ;
      }
      else if ( ( AV31OrderedBy == 3 ) && ! AV32OrderedDsc )
      {
         scmdbuf += " ORDER BY LiqDClasifAux" ;
      }
      else if ( ( AV31OrderedBy == 3 ) && ( AV32OrderedDsc ) )
      {
         scmdbuf += " ORDER BY LiqDClasifAux DESC" ;
      }
      else if ( ( AV31OrderedBy == 4 ) && ! AV32OrderedDsc )
      {
         scmdbuf += " ORDER BY DConCodigo" ;
      }
      else if ( ( AV31OrderedBy == 4 ) && ( AV32OrderedDsc ) )
      {
         scmdbuf += " ORDER BY DConCodigo DESC" ;
      }
      else if ( ( AV31OrderedBy == 5 ) && ! AV32OrderedDsc )
      {
         scmdbuf += " ORDER BY DConDescrip" ;
      }
      else if ( ( AV31OrderedBy == 5 ) && ( AV32OrderedDsc ) )
      {
         scmdbuf += " ORDER BY DConDescrip DESC" ;
      }
      else if ( ( AV31OrderedBy == 6 ) && ! AV32OrderedDsc )
      {
         scmdbuf += " ORDER BY LiqDValUni" ;
      }
      else if ( ( AV31OrderedBy == 6 ) && ( AV32OrderedDsc ) )
      {
         scmdbuf += " ORDER BY LiqDValUni DESC" ;
      }
      else if ( ( AV31OrderedBy == 7 ) && ! AV32OrderedDsc )
      {
         scmdbuf += " ORDER BY LiqDImpReCalcu" ;
      }
      else if ( ( AV31OrderedBy == 7 ) && ( AV32OrderedDsc ) )
      {
         scmdbuf += " ORDER BY LiqDImpReCalcu DESC" ;
      }
      else if ( ( AV31OrderedBy == 8 ) && ! AV32OrderedDsc )
      {
         scmdbuf += " ORDER BY LiqDLogRecal" ;
      }
      else if ( ( AV31OrderedBy == 8 ) && ( AV32OrderedDsc ) )
      {
         scmdbuf += " ORDER BY LiqDLogRecal DESC" ;
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
                  return conditional_P01JA2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , (java.math.BigDecimal)dynConstraints[20] , (java.math.BigDecimal)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , (String)dynConstraints[23] , ((Number) dynConstraints[24]).byteValue() , (java.math.BigDecimal)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , ((Number) dynConstraints[27]).shortValue() , ((Boolean) dynConstraints[28]).booleanValue() , ((Number) dynConstraints[29]).intValue() , ((Number) dynConstraints[30]).shortValue() , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).intValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).shortValue() , ((Number) dynConstraints[35]).intValue() , ((Number) dynConstraints[36]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01JA2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,2);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,2);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getVarchar(8);
               ((String[]) buf[10])[0] = rslt.getString(9, 10);
               ((String[]) buf[11])[0] = rslt.getVarchar(10);
               ((String[]) buf[12])[0] = rslt.getString(11, 20);
               ((byte[]) buf[13])[0] = rslt.getByte(12);
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(13,2);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getLongVarchar(14);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getLongVarchar(15);
               ((short[]) buf[19])[0] = rslt.getShort(16);
               ((int[]) buf[20])[0] = rslt.getInt(17);
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
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[14]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 80);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 10);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 400);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[20], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[21], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[22], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 400);
               }
               return;
      }
   }

}

