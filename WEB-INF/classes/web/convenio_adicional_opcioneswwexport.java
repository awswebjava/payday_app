package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class convenio_adicional_opcioneswwexport extends GXProcedure
{
   public convenio_adicional_opcioneswwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( convenio_adicional_opcioneswwexport.class ), "" );
   }

   public convenio_adicional_opcioneswwexport( int remoteHandle ,
                                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      convenio_adicional_opcioneswwexport.this.aP1 = new String[] {""};
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
      convenio_adicional_opcioneswwexport.this.aP0 = aP0;
      convenio_adicional_opcioneswwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV52CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      convenio_adicional_opcioneswwexport.this.GXt_int1 = GXv_int2[0] ;
      AV52CliCod = GXt_int1 ;
      GXv_char3[0] = AV55ConveCodigo ;
      new web.getconvecodsesion(remoteHandle, context).execute( GXv_char3) ;
      convenio_adicional_opcioneswwexport.this.AV55ConveCodigo = GXv_char3[0] ;
      GXv_int4[0] = AV54PaiCod ;
      new web.clientegetpais(remoteHandle, context).execute( AV52CliCod, GXv_int4) ;
      convenio_adicional_opcioneswwexport.this.AV54PaiCod = GXv_int4[0] ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWconvenio_adicional_opciones", GXv_boolean6) ;
      convenio_adicional_opcioneswwexport.this.GXt_boolean5 = GXv_boolean6[0] ;
      AV8IsAuthorized = GXt_boolean5 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV66Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "convenio_adicional_opcionesWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV37TFConveAdicod_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Adicional", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         convenio_adicional_opcioneswwexport.this.AV14CellRow = GXv_int4[0] ;
         AV51i = 1 ;
         AV67GXV1 = 1 ;
         while ( AV67GXV1 <= AV37TFConveAdicod_Sels.size() )
         {
            AV38TFConveAdicod_Sel = (String)AV37TFConveAdicod_Sels.elementAt(-1+AV67GXV1) ;
            if ( AV51i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char9 = "" ;
            GXv_char3[0] = GXt_char9 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFConveAdicod_Sel, GXv_char3) ;
            convenio_adicional_opcioneswwexport.this.GXt_char9 = GXv_char3[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char9 );
            AV51i = (long)(AV51i+1) ;
            AV67GXV1 = (int)(AV67GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV36TFConveAdicod)==0) ) )
         {
            GXv_exceldoc8[0] = AV11ExcelDocument ;
            GXv_int4[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Adicional", "")) ;
            AV11ExcelDocument = GXv_exceldoc8[0] ;
            convenio_adicional_opcioneswwexport.this.AV14CellRow = GXv_int4[0] ;
            GXt_char9 = "" ;
            GXv_char3[0] = GXt_char9 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV36TFConveAdicod, GXv_char3) ;
            convenio_adicional_opcioneswwexport.this.GXt_char9 = GXv_char3[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char9 );
         }
      }
      if ( ! ( (0==AV39TFConveAdiOpcCod) && (0==AV40TFConveAdiOpcCod_To) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Opción Nro.", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         convenio_adicional_opcioneswwexport.this.AV14CellRow = GXv_int4[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV39TFConveAdiOpcCod );
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, false, GXv_int4, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         convenio_adicional_opcioneswwexport.this.AV14CellRow = GXv_int4[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV40TFConveAdiOpcCod_To );
      }
      if ( ! ( ( AV43TFConveAdiOpcFor_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Opción código", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         convenio_adicional_opcioneswwexport.this.AV14CellRow = GXv_int4[0] ;
         AV51i = 1 ;
         AV68GXV2 = 1 ;
         while ( AV68GXV2 <= AV43TFConveAdiOpcFor_Sels.size() )
         {
            AV44TFConveAdiOpcFor_Sel = (String)AV43TFConveAdiOpcFor_Sels.elementAt(-1+AV68GXV2) ;
            if ( AV51i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char9 = "" ;
            GXv_char3[0] = GXt_char9 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV44TFConveAdiOpcFor_Sel, GXv_char3) ;
            convenio_adicional_opcioneswwexport.this.GXt_char9 = GXv_char3[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char9 );
            AV51i = (long)(AV51i+1) ;
            AV68GXV2 = (int)(AV68GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV42TFConveAdiOpcFor)==0) ) )
         {
            GXv_exceldoc8[0] = AV11ExcelDocument ;
            GXv_int4[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Opción código", "")) ;
            AV11ExcelDocument = GXv_exceldoc8[0] ;
            convenio_adicional_opcioneswwexport.this.AV14CellRow = GXv_int4[0] ;
            GXt_char9 = "" ;
            GXv_char3[0] = GXt_char9 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV42TFConveAdiOpcFor, GXv_char3) ;
            convenio_adicional_opcioneswwexport.this.GXt_char9 = GXv_char3[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char9 );
         }
      }
      if ( ! ( ( AV47TFConveAdiOpcDes_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Opción Descripción", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         convenio_adicional_opcioneswwexport.this.AV14CellRow = GXv_int4[0] ;
         AV51i = 1 ;
         AV69GXV3 = 1 ;
         while ( AV69GXV3 <= AV47TFConveAdiOpcDes_Sels.size() )
         {
            AV48TFConveAdiOpcDes_Sel = (String)AV47TFConveAdiOpcDes_Sels.elementAt(-1+AV69GXV3) ;
            if ( AV51i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char9 = "" ;
            GXv_char3[0] = GXt_char9 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV48TFConveAdiOpcDes_Sel, GXv_char3) ;
            convenio_adicional_opcioneswwexport.this.GXt_char9 = GXv_char3[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char9 );
            AV51i = (long)(AV51i+1) ;
            AV69GXV3 = (int)(AV69GXV3+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV46TFConveAdiOpcDes)==0) ) )
         {
            GXv_exceldoc8[0] = AV11ExcelDocument ;
            GXv_int4[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Opción Descripción", "")) ;
            AV11ExcelDocument = GXv_exceldoc8[0] ;
            convenio_adicional_opcioneswwexport.this.AV14CellRow = GXv_int4[0] ;
            GXt_char9 = "" ;
            GXv_char3[0] = GXt_char9 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV46TFConveAdiOpcDes, GXv_char3) ;
            convenio_adicional_opcioneswwexport.this.GXt_char9 = GXv_char3[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char9 );
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV49TFConveAdiOpcAli)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV50TFConveAdiOpcAli_To)==0) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Alícuota", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         convenio_adicional_opcioneswwexport.this.AV14CellRow = GXv_int4[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV49TFConveAdiOpcAli)) );
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, false, GXv_int4, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         convenio_adicional_opcioneswwexport.this.AV14CellRow = GXv_int4[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV50TFConveAdiOpcAli_To)) );
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("convenio_adicional_opcionesWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("convenio_adicional_opcionesWWColumnsSelector") ;
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
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
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
      AV72Convenio_adicional_opcioneswwds_1_tfconveadicod = AV36TFConveAdicod ;
      AV73Convenio_adicional_opcioneswwds_2_tfconveadicod_sels = AV37TFConveAdicod_Sels ;
      AV74Convenio_adicional_opcioneswwds_3_tfconveadiopccod = AV39TFConveAdiOpcCod ;
      AV75Convenio_adicional_opcioneswwds_4_tfconveadiopccod_to = AV40TFConveAdiOpcCod_To ;
      AV76Convenio_adicional_opcioneswwds_5_tfconveadiopcfor = AV42TFConveAdiOpcFor ;
      AV77Convenio_adicional_opcioneswwds_6_tfconveadiopcfor_sels = AV43TFConveAdiOpcFor_Sels ;
      AV78Convenio_adicional_opcioneswwds_7_tfconveadiopcdes = AV46TFConveAdiOpcDes ;
      AV79Convenio_adicional_opcioneswwds_8_tfconveadiopcdes_sels = AV47TFConveAdiOpcDes_Sels ;
      AV80Convenio_adicional_opcioneswwds_9_tfconveadiopcali = AV49TFConveAdiOpcAli ;
      AV81Convenio_adicional_opcioneswwds_10_tfconveadiopcali_to = AV50TFConveAdiOpcAli_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A996ConveAdicod ,
                                           AV73Convenio_adicional_opcioneswwds_2_tfconveadicod_sels ,
                                           A1021ConveAdiOpcFor ,
                                           AV77Convenio_adicional_opcioneswwds_6_tfconveadiopcfor_sels ,
                                           A1012ConveAdiOpcDes ,
                                           AV79Convenio_adicional_opcioneswwds_8_tfconveadiopcdes_sels ,
                                           Integer.valueOf(AV73Convenio_adicional_opcioneswwds_2_tfconveadicod_sels.size()) ,
                                           AV72Convenio_adicional_opcioneswwds_1_tfconveadicod ,
                                           Short.valueOf(AV74Convenio_adicional_opcioneswwds_3_tfconveadiopccod) ,
                                           Short.valueOf(AV75Convenio_adicional_opcioneswwds_4_tfconveadiopccod_to) ,
                                           Integer.valueOf(AV77Convenio_adicional_opcioneswwds_6_tfconveadiopcfor_sels.size()) ,
                                           AV76Convenio_adicional_opcioneswwds_5_tfconveadiopcfor ,
                                           Integer.valueOf(AV79Convenio_adicional_opcioneswwds_8_tfconveadiopcdes_sels.size()) ,
                                           AV78Convenio_adicional_opcioneswwds_7_tfconveadiopcdes ,
                                           AV80Convenio_adicional_opcioneswwds_9_tfconveadiopcali ,
                                           AV81Convenio_adicional_opcioneswwds_10_tfconveadiopcali_to ,
                                           Short.valueOf(A1011ConveAdiOpcCod) ,
                                           A1013ConveAdiOpcAli ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Integer.valueOf(AV52CliCod) ,
                                           Short.valueOf(AV54PaiCod) ,
                                           AV55ConveCodigo ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1564CliPaiConve) ,
                                           A1565CliConvenio } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING
                                           }
      });
      lV72Convenio_adicional_opcioneswwds_1_tfconveadicod = GXutil.padr( GXutil.rtrim( AV72Convenio_adicional_opcioneswwds_1_tfconveadicod), 20, "%") ;
      lV76Convenio_adicional_opcioneswwds_5_tfconveadiopcfor = GXutil.padr( GXutil.rtrim( AV76Convenio_adicional_opcioneswwds_5_tfconveadiopcfor), 20, "%") ;
      lV78Convenio_adicional_opcioneswwds_7_tfconveadiopcdes = GXutil.concat( GXutil.rtrim( AV78Convenio_adicional_opcioneswwds_7_tfconveadiopcdes), "%", "") ;
      /* Using cursor P01KY2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV52CliCod), Short.valueOf(AV54PaiCod), AV55ConveCodigo, lV72Convenio_adicional_opcioneswwds_1_tfconveadicod, Short.valueOf(AV74Convenio_adicional_opcioneswwds_3_tfconveadiopccod), Short.valueOf(AV75Convenio_adicional_opcioneswwds_4_tfconveadiopccod_to), lV76Convenio_adicional_opcioneswwds_5_tfconveadiopcfor, lV78Convenio_adicional_opcioneswwds_7_tfconveadiopcdes, AV80Convenio_adicional_opcioneswwds_9_tfconveadiopcali, AV81Convenio_adicional_opcioneswwds_10_tfconveadiopcali_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1565CliConvenio = P01KY2_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01KY2_A1564CliPaiConve[0] ;
         A3CliCod = P01KY2_A3CliCod[0] ;
         A1013ConveAdiOpcAli = P01KY2_A1013ConveAdiOpcAli[0] ;
         A1012ConveAdiOpcDes = P01KY2_A1012ConveAdiOpcDes[0] ;
         A1021ConveAdiOpcFor = P01KY2_A1021ConveAdiOpcFor[0] ;
         A1011ConveAdiOpcCod = P01KY2_A1011ConveAdiOpcCod[0] ;
         A996ConveAdicod = P01KY2_A996ConveAdicod[0] ;
         A1900ConveAdiOpcRelSec = P01KY2_A1900ConveAdiOpcRelSec[0] ;
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
         AV82GXV5 = 1 ;
         while ( AV82GXV5 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV82GXV5));
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
                  GXv_char3[0] = GXt_char9 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1565CliConvenio, GXv_char3) ;
                  convenio_adicional_opcioneswwexport.this.GXt_char9 = GXv_char3[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char9 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveAdicod") == 0 )
               {
                  GXt_char9 = "" ;
                  GXv_char3[0] = GXt_char9 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A996ConveAdicod, GXv_char3) ;
                  convenio_adicional_opcioneswwexport.this.GXt_char9 = GXv_char3[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char9 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveAdiOpcCod") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1011ConveAdiOpcCod );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveAdiOpcFor") == 0 )
               {
                  GXt_char9 = "" ;
                  GXv_char3[0] = GXt_char9 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1021ConveAdiOpcFor, GXv_char3) ;
                  convenio_adicional_opcioneswwexport.this.GXt_char9 = GXv_char3[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char9 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveAdiOpcDes") == 0 )
               {
                  GXt_char9 = "" ;
                  GXv_char3[0] = GXt_char9 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1012ConveAdiOpcDes, GXv_char3) ;
                  convenio_adicional_opcioneswwexport.this.GXt_char9 = GXv_char3[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char9 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveAdiOpcAli") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1013ConveAdiOpcAli)) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "&CliReDTChar") == 0 )
               {
                  GXt_char9 = AV62CliReDTChar ;
                  GXv_char3[0] = GXt_char9 ;
                  new web.getreleasedtchar(remoteHandle, context).execute( A3CliCod, A1900ConveAdiOpcRelSec, GXv_char3) ;
                  convenio_adicional_opcioneswwexport.this.GXt_char9 = GXv_char3[0] ;
                  AV62CliReDTChar = GXt_char9 ;
                  GXt_char9 = "" ;
                  GXv_char3[0] = GXt_char9 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV62CliReDTChar, GXv_char3) ;
                  convenio_adicional_opcioneswwexport.this.GXt_char9 = GXv_char3[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char9 );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV82GXV5 = (int)(AV82GXV5+1) ;
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
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConveAdicod", "", "Adicional", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConveAdiOpcCod", "", "Opción Nro.", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConveAdiOpcFor", "", "Opción código", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConveAdiOpcDes", "", "Opción Descripción", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConveAdiOpcAli", "", "Alícuota", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&VerSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&ModificarSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&EliminarSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&CliReDTChar", "", "Fecha/hora de liberación", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXt_char9 = AV28UserCustomValue ;
      GXv_char3[0] = GXt_char9 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "convenio_adicional_opcionesWWColumnsSelector", GXv_char3) ;
      convenio_adicional_opcioneswwexport.this.GXt_char9 = GXv_char3[0] ;
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

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("convenio_adicional_opcionesWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "convenio_adicional_opcionesWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("convenio_adicional_opcionesWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV83GXV6 = 1 ;
      while ( AV83GXV6 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV83GXV6));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADICOD") == 0 )
         {
            AV36TFConveAdicod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADICOD_SEL") == 0 )
         {
            AV35TFConveAdicod_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV37TFConveAdicod_Sels.fromJSonString(AV35TFConveAdicod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADIOPCCOD") == 0 )
         {
            AV39TFConveAdiOpcCod = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV40TFConveAdiOpcCod_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADIOPCFOR") == 0 )
         {
            AV42TFConveAdiOpcFor = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADIOPCFOR_SEL") == 0 )
         {
            AV41TFConveAdiOpcFor_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV43TFConveAdiOpcFor_Sels.fromJSonString(AV41TFConveAdiOpcFor_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADIOPCDES") == 0 )
         {
            AV46TFConveAdiOpcDes = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADIOPCDES_SEL") == 0 )
         {
            AV45TFConveAdiOpcDes_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV47TFConveAdiOpcDes_Sels.fromJSonString(AV45TFConveAdiOpcDes_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADIOPCALI") == 0 )
         {
            AV49TFConveAdiOpcAli = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV50TFConveAdiOpcAli_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV63MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV83GXV6 = (int)(AV83GXV6+1) ;
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
      this.aP0[0] = convenio_adicional_opcioneswwexport.this.AV12Filename;
      this.aP1[0] = convenio_adicional_opcioneswwexport.this.AV13ErrorMessage;
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
      AV55ConveCodigo = "" ;
      GXv_boolean6 = new boolean[1] ;
      AV66Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV37TFConveAdicod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV38TFConveAdicod_Sel = "" ;
      AV36TFConveAdicod = "" ;
      AV43TFConveAdiOpcFor_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV44TFConveAdiOpcFor_Sel = "" ;
      AV42TFConveAdiOpcFor = "" ;
      AV47TFConveAdiOpcDes_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV48TFConveAdiOpcDes_Sel = "" ;
      AV46TFConveAdiOpcDes = "" ;
      AV49TFConveAdiOpcAli = DecimalUtil.ZERO ;
      AV50TFConveAdiOpcAli_To = DecimalUtil.ZERO ;
      GXv_exceldoc8 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int4 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A1565CliConvenio = "" ;
      A996ConveAdicod = "" ;
      A1021ConveAdiOpcFor = "" ;
      A1012ConveAdiOpcDes = "" ;
      A1013ConveAdiOpcAli = DecimalUtil.ZERO ;
      AV72Convenio_adicional_opcioneswwds_1_tfconveadicod = "" ;
      AV73Convenio_adicional_opcioneswwds_2_tfconveadicod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV76Convenio_adicional_opcioneswwds_5_tfconveadiopcfor = "" ;
      AV77Convenio_adicional_opcioneswwds_6_tfconveadiopcfor_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV78Convenio_adicional_opcioneswwds_7_tfconveadiopcdes = "" ;
      AV79Convenio_adicional_opcioneswwds_8_tfconveadiopcdes_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV80Convenio_adicional_opcioneswwds_9_tfconveadiopcali = DecimalUtil.ZERO ;
      AV81Convenio_adicional_opcioneswwds_10_tfconveadiopcali_to = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      lV72Convenio_adicional_opcioneswwds_1_tfconveadicod = "" ;
      lV76Convenio_adicional_opcioneswwds_5_tfconveadiopcfor = "" ;
      lV78Convenio_adicional_opcioneswwds_7_tfconveadiopcdes = "" ;
      P01KY2_A1565CliConvenio = new String[] {""} ;
      P01KY2_A1564CliPaiConve = new short[1] ;
      P01KY2_A3CliCod = new int[1] ;
      P01KY2_A1013ConveAdiOpcAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01KY2_A1012ConveAdiOpcDes = new String[] {""} ;
      P01KY2_A1021ConveAdiOpcFor = new String[] {""} ;
      P01KY2_A1011ConveAdiOpcCod = new short[1] ;
      P01KY2_A996ConveAdicod = new String[] {""} ;
      P01KY2_A1900ConveAdiOpcRelSec = new int[1] ;
      AV62CliReDTChar = "" ;
      AV28UserCustomValue = "" ;
      GXt_char9 = "" ;
      GXv_char3 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector10 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector11 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV35TFConveAdicod_SelsJson = "" ;
      AV41TFConveAdiOpcFor_SelsJson = "" ;
      AV45TFConveAdiOpcDes_SelsJson = "" ;
      AV63MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.convenio_adicional_opcioneswwexport__default(),
         new Object[] {
             new Object[] {
            P01KY2_A1565CliConvenio, P01KY2_A1564CliPaiConve, P01KY2_A3CliCod, P01KY2_A1013ConveAdiOpcAli, P01KY2_A1012ConveAdiOpcDes, P01KY2_A1021ConveAdiOpcFor, P01KY2_A1011ConveAdiOpcCod, P01KY2_A996ConveAdicod, P01KY2_A1900ConveAdiOpcRelSec
            }
         }
      );
      AV66Pgmname = "convenio_adicional_opcionesWWExport" ;
      /* GeneXus formulas. */
      AV66Pgmname = "convenio_adicional_opcionesWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short AV54PaiCod ;
   private short AV39TFConveAdiOpcCod ;
   private short AV40TFConveAdiOpcCod_To ;
   private short GXv_int4[] ;
   private short A1564CliPaiConve ;
   private short A1011ConveAdiOpcCod ;
   private short AV74Convenio_adicional_opcioneswwds_3_tfconveadiopccod ;
   private short AV75Convenio_adicional_opcioneswwds_4_tfconveadiopccod_to ;
   private short AV18OrderedBy ;
   private short Gx_err ;
   private int AV52CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV67GXV1 ;
   private int AV68GXV2 ;
   private int AV69GXV3 ;
   private int AV70GXV4 ;
   private int A3CliCod ;
   private int A1900ConveAdiOpcRelSec ;
   private int AV73Convenio_adicional_opcioneswwds_2_tfconveadicod_sels_size ;
   private int AV77Convenio_adicional_opcioneswwds_6_tfconveadiopcfor_sels_size ;
   private int AV79Convenio_adicional_opcioneswwds_8_tfconveadiopcdes_sels_size ;
   private int AV82GXV5 ;
   private int AV83GXV6 ;
   private long AV51i ;
   private long AV32VisibleColumnCount ;
   private java.math.BigDecimal AV49TFConveAdiOpcAli ;
   private java.math.BigDecimal AV50TFConveAdiOpcAli_To ;
   private java.math.BigDecimal A1013ConveAdiOpcAli ;
   private java.math.BigDecimal AV80Convenio_adicional_opcioneswwds_9_tfconveadiopcali ;
   private java.math.BigDecimal AV81Convenio_adicional_opcioneswwds_10_tfconveadiopcali_to ;
   private String AV55ConveCodigo ;
   private String AV66Pgmname ;
   private String AV38TFConveAdicod_Sel ;
   private String AV36TFConveAdicod ;
   private String AV44TFConveAdiOpcFor_Sel ;
   private String AV42TFConveAdiOpcFor ;
   private String A1565CliConvenio ;
   private String A996ConveAdicod ;
   private String A1021ConveAdiOpcFor ;
   private String AV72Convenio_adicional_opcioneswwds_1_tfconveadicod ;
   private String AV76Convenio_adicional_opcioneswwds_5_tfconveadiopcfor ;
   private String scmdbuf ;
   private String lV72Convenio_adicional_opcioneswwds_1_tfconveadicod ;
   private String lV76Convenio_adicional_opcioneswwds_5_tfconveadiopcfor ;
   private String GXt_char9 ;
   private String GXv_char3[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean AV19OrderedDsc ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV35TFConveAdicod_SelsJson ;
   private String AV41TFConveAdiOpcFor_SelsJson ;
   private String AV45TFConveAdiOpcDes_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV48TFConveAdiOpcDes_Sel ;
   private String AV46TFConveAdiOpcDes ;
   private String A1012ConveAdiOpcDes ;
   private String AV78Convenio_adicional_opcioneswwds_7_tfconveadiopcdes ;
   private String lV78Convenio_adicional_opcioneswwds_7_tfconveadiopcdes ;
   private String AV62CliReDTChar ;
   private String AV63MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV37TFConveAdicod_Sels ;
   private GXSimpleCollection<String> AV43TFConveAdiOpcFor_Sels ;
   private GXSimpleCollection<String> AV47TFConveAdiOpcDes_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] P01KY2_A1565CliConvenio ;
   private short[] P01KY2_A1564CliPaiConve ;
   private int[] P01KY2_A3CliCod ;
   private java.math.BigDecimal[] P01KY2_A1013ConveAdiOpcAli ;
   private String[] P01KY2_A1012ConveAdiOpcDes ;
   private String[] P01KY2_A1021ConveAdiOpcFor ;
   private short[] P01KY2_A1011ConveAdiOpcCod ;
   private String[] P01KY2_A996ConveAdicod ;
   private int[] P01KY2_A1900ConveAdiOpcRelSec ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc8[] ;
   private GXSimpleCollection<String> AV73Convenio_adicional_opcioneswwds_2_tfconveadicod_sels ;
   private GXSimpleCollection<String> AV77Convenio_adicional_opcioneswwds_6_tfconveadiopcfor_sels ;
   private GXSimpleCollection<String> AV79Convenio_adicional_opcioneswwds_8_tfconveadiopcdes_sels ;
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

final  class convenio_adicional_opcioneswwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01KY2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A996ConveAdicod ,
                                          GXSimpleCollection<String> AV73Convenio_adicional_opcioneswwds_2_tfconveadicod_sels ,
                                          String A1021ConveAdiOpcFor ,
                                          GXSimpleCollection<String> AV77Convenio_adicional_opcioneswwds_6_tfconveadiopcfor_sels ,
                                          String A1012ConveAdiOpcDes ,
                                          GXSimpleCollection<String> AV79Convenio_adicional_opcioneswwds_8_tfconveadiopcdes_sels ,
                                          int AV73Convenio_adicional_opcioneswwds_2_tfconveadicod_sels_size ,
                                          String AV72Convenio_adicional_opcioneswwds_1_tfconveadicod ,
                                          short AV74Convenio_adicional_opcioneswwds_3_tfconveadiopccod ,
                                          short AV75Convenio_adicional_opcioneswwds_4_tfconveadiopccod_to ,
                                          int AV77Convenio_adicional_opcioneswwds_6_tfconveadiopcfor_sels_size ,
                                          String AV76Convenio_adicional_opcioneswwds_5_tfconveadiopcfor ,
                                          int AV79Convenio_adicional_opcioneswwds_8_tfconveadiopcdes_sels_size ,
                                          String AV78Convenio_adicional_opcioneswwds_7_tfconveadiopcdes ,
                                          java.math.BigDecimal AV80Convenio_adicional_opcioneswwds_9_tfconveadiopcali ,
                                          java.math.BigDecimal AV81Convenio_adicional_opcioneswwds_10_tfconveadiopcali_to ,
                                          short A1011ConveAdiOpcCod ,
                                          java.math.BigDecimal A1013ConveAdiOpcAli ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          int AV52CliCod ,
                                          short AV54PaiCod ,
                                          String AV55ConveCodigo ,
                                          int A3CliCod ,
                                          short A1564CliPaiConve ,
                                          String A1565CliConvenio )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int12 = new byte[10];
      Object[] GXv_Object13 = new Object[2];
      scmdbuf = "SELECT CliConvenio, CliPaiConve, CliCod, ConveAdiOpcAli, ConveAdiOpcDes, ConveAdiOpcFor, ConveAdiOpcCod, ConveAdicod, ConveAdiOpcRelSec FROM convenio_adicionalalicuotas" ;
      addWhere(sWhereString, "(CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?))");
      if ( ( AV73Convenio_adicional_opcioneswwds_2_tfconveadicod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV72Convenio_adicional_opcioneswwds_1_tfconveadicod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveAdicod) like LOWER(?))");
      }
      else
      {
         GXv_int12[3] = (byte)(1) ;
      }
      if ( AV73Convenio_adicional_opcioneswwds_2_tfconveadicod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV73Convenio_adicional_opcioneswwds_2_tfconveadicod_sels, "ConveAdicod IN (", ")")+")");
      }
      if ( ! (0==AV74Convenio_adicional_opcioneswwds_3_tfconveadiopccod) )
      {
         addWhere(sWhereString, "(ConveAdiOpcCod >= ?)");
      }
      else
      {
         GXv_int12[4] = (byte)(1) ;
      }
      if ( ! (0==AV75Convenio_adicional_opcioneswwds_4_tfconveadiopccod_to) )
      {
         addWhere(sWhereString, "(ConveAdiOpcCod <= ?)");
      }
      else
      {
         GXv_int12[5] = (byte)(1) ;
      }
      if ( ( AV77Convenio_adicional_opcioneswwds_6_tfconveadiopcfor_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV76Convenio_adicional_opcioneswwds_5_tfconveadiopcfor)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveAdiOpcFor) like LOWER(?))");
      }
      else
      {
         GXv_int12[6] = (byte)(1) ;
      }
      if ( AV77Convenio_adicional_opcioneswwds_6_tfconveadiopcfor_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV77Convenio_adicional_opcioneswwds_6_tfconveadiopcfor_sels, "ConveAdiOpcFor IN (", ")")+")");
      }
      if ( ( AV79Convenio_adicional_opcioneswwds_8_tfconveadiopcdes_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV78Convenio_adicional_opcioneswwds_7_tfconveadiopcdes)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveAdiOpcDes) like LOWER(?))");
      }
      else
      {
         GXv_int12[7] = (byte)(1) ;
      }
      if ( AV79Convenio_adicional_opcioneswwds_8_tfconveadiopcdes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV79Convenio_adicional_opcioneswwds_8_tfconveadiopcdes_sels, "ConveAdiOpcDes IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV80Convenio_adicional_opcioneswwds_9_tfconveadiopcali)==0) )
      {
         addWhere(sWhereString, "(ConveAdiOpcAli >= ?)");
      }
      else
      {
         GXv_int12[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV81Convenio_adicional_opcioneswwds_10_tfconveadiopcali_to)==0) )
      {
         addWhere(sWhereString, "(ConveAdiOpcAli <= ?)");
      }
      else
      {
         GXv_int12[9] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveAdicod" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveAdicod DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveAdiOpcCod" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveAdiOpcCod DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveAdiOpcFor" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveAdiOpcFor DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveAdiOpcDes" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveAdiOpcDes DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveAdiOpcAli" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveAdiOpcAli DESC" ;
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
                  return conditional_P01KY2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , (java.math.BigDecimal)dynConstraints[14] , (java.math.BigDecimal)dynConstraints[15] , ((Number) dynConstraints[16]).shortValue() , (java.math.BigDecimal)dynConstraints[17] , ((Number) dynConstraints[18]).shortValue() , ((Boolean) dynConstraints[19]).booleanValue() , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).shortValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).shortValue() , (String)dynConstraints[25] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01KY2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((int[]) buf[8])[0] = rslt.getInt(9);
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
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[12], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[15]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[16], 20);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[18], 4);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 4);
               }
               return;
      }
   }

}

