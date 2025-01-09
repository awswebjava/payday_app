package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class clienteconvenio_particularidadeswwexport extends GXProcedure
{
   public clienteconvenio_particularidadeswwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( clienteconvenio_particularidadeswwexport.class ), "" );
   }

   public clienteconvenio_particularidadeswwexport( int remoteHandle ,
                                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      clienteconvenio_particularidadeswwexport.this.aP1 = new String[] {""};
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
      clienteconvenio_particularidadeswwexport.this.aP0 = aP0;
      clienteconvenio_particularidadeswwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV58CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      clienteconvenio_particularidadeswwexport.this.GXt_int1 = GXv_int2[0] ;
      AV58CliCod = GXt_int1 ;
      GXv_char3[0] = AV61ConveCodigo ;
      new web.getconvecodsesion(remoteHandle, context).execute( GXv_char3) ;
      clienteconvenio_particularidadeswwexport.this.AV61ConveCodigo = GXv_char3[0] ;
      GXv_int4[0] = AV60PaiCod ;
      new web.clientegetpais(remoteHandle, context).execute( AV58CliCod, GXv_int4) ;
      clienteconvenio_particularidadeswwexport.this.AV60PaiCod = GXv_int4[0] ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClienteConvenio_Particularidades", GXv_boolean6) ;
      clienteconvenio_particularidadeswwexport.this.GXt_boolean5 = GXv_boolean6[0] ;
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
      AV12Filename = "ClienteConvenio_ParticularidadesWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV35TFCliConveVig)) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV36TFCliConveVig_To)) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Fecha de vigencia", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         clienteconvenio_particularidadeswwexport.this.AV14CellRow = GXv_int4[0] ;
         GXt_dtime9 = GXutil.resetTime( AV35TFCliConveVig );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( GXt_dtime9 );
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, false, GXv_int4, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         clienteconvenio_particularidadeswwexport.this.AV14CellRow = GXv_int4[0] ;
         GXt_dtime9 = GXutil.resetTime( AV36TFCliConveVig_To );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setDate( GXt_dtime9 );
      }
      if ( ! ( (0==AV37TFConveInterDiasJor) && (0==AV38TFConveInterDiasJor_To) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Intervalo de jornadas trabajadas para x días de vacación", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         clienteconvenio_particularidadeswwexport.this.AV14CellRow = GXv_int4[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV37TFConveInterDiasJor );
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, false, GXv_int4, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         clienteconvenio_particularidadeswwexport.this.AV14CellRow = GXv_int4[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV38TFConveInterDiasJor_To );
      }
      if ( ! ( (0==AV39TFConveMinMesesVac) && (0==AV40TFConveMinMesesVac_To) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Antiguedad en meses mínima para acumular días fijos de vacaciones", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         clienteconvenio_particularidadeswwexport.this.AV14CellRow = GXv_int4[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV39TFConveMinMesesVac );
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, false, GXv_int4, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         clienteconvenio_particularidadeswwexport.this.AV14CellRow = GXv_int4[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV40TFConveMinMesesVac_To );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV41TFConveMesHsPExt)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV42TFConveMesHsPExt_To)==0) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Cantidad de horas del mes para calcular horas extras", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         clienteconvenio_particularidadeswwexport.this.AV14CellRow = GXv_int4[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV41TFConveMesHsPExt)) );
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, false, GXv_int4, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         clienteconvenio_particularidadeswwexport.this.AV14CellRow = GXv_int4[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV42TFConveMesHsPExt_To)) );
      }
      if ( ! ( ( AV44TFConveDiaHsPExt_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Algoritmo para cantidad de días del mes para cálculo de horas extras", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         clienteconvenio_particularidadeswwexport.this.AV14CellRow = GXv_int4[0] ;
         AV57i = 1 ;
         AV72GXV1 = 1 ;
         while ( AV72GXV1 <= AV44TFConveDiaHsPExt_Sels.size() )
         {
            AV45TFConveDiaHsPExt_Sel = (String)AV44TFConveDiaHsPExt_Sels.elementAt(-1+AV72GXV1) ;
            if ( AV57i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomainalgoritmodiasmeshsext.getDescription(httpContext,(String)AV45TFConveDiaHsPExt_Sel), "") );
            AV57i = (long)(AV57i+1) ;
            AV72GXV1 = (int)(AV72GXV1+1) ;
         }
      }
      if ( ! ( (0==AV46TFConveFondoCese_Sel) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Maneja fondo de cese laboral (no liquida indemnizacion por antiguedad ni sustitutiva del preaviso)", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         clienteconvenio_particularidadeswwexport.this.AV14CellRow = GXv_int4[0] ;
         if ( AV46TFConveFondoCese_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV46TFConveFondoCese_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( (0==AV53TFConveGuarEdadMin) && (0==AV54TFConveGuarEdadMin_To) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Edad del hijo/hija mínima en meses para gozar de beneficio de guardería", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         clienteconvenio_particularidadeswwexport.this.AV14CellRow = GXv_int4[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV53TFConveGuarEdadMin );
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, false, GXv_int4, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         clienteconvenio_particularidadeswwexport.this.AV14CellRow = GXv_int4[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV54TFConveGuarEdadMin_To );
      }
      if ( ! ( (0==AV55TFConveGuarEdadMax) && (0==AV56TFConveGuarEdadMax_To) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Edad máxima en años del hijo/hija hasta la que puede gozar el beneficio de guardería", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         clienteconvenio_particularidadeswwexport.this.AV14CellRow = GXv_int4[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV55TFConveGuarEdadMax );
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, false, GXv_int4, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         clienteconvenio_particularidadeswwexport.this.AV14CellRow = GXv_int4[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV56TFConveGuarEdadMax_To );
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("ClienteConvenio_ParticularidadesWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("ClienteConvenio_ParticularidadesWWColumnsSelector") ;
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
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV73GXV2 = 1 ;
      while ( AV73GXV2 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV73GXV2));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV73GXV2 = (int)(AV73GXV2+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV75Clienteconvenio_particularidadeswwds_1_tfcliconvevig = AV35TFCliConveVig ;
      AV76Clienteconvenio_particularidadeswwds_2_tfcliconvevig_to = AV36TFCliConveVig_To ;
      AV77Clienteconvenio_particularidadeswwds_3_tfconveinterdiasjor = AV37TFConveInterDiasJor ;
      AV78Clienteconvenio_particularidadeswwds_4_tfconveinterdiasjor_to = AV38TFConveInterDiasJor_To ;
      AV79Clienteconvenio_particularidadeswwds_5_tfconveminmesesvac = AV39TFConveMinMesesVac ;
      AV80Clienteconvenio_particularidadeswwds_6_tfconveminmesesvac_to = AV40TFConveMinMesesVac_To ;
      AV81Clienteconvenio_particularidadeswwds_7_tfconvemeshspext = AV41TFConveMesHsPExt ;
      AV82Clienteconvenio_particularidadeswwds_8_tfconvemeshspext_to = AV42TFConveMesHsPExt_To ;
      AV83Clienteconvenio_particularidadeswwds_9_tfconvediahspext_sels = AV44TFConveDiaHsPExt_Sels ;
      AV84Clienteconvenio_particularidadeswwds_10_tfconvefondocese_sel = AV46TFConveFondoCese_Sel ;
      AV85Clienteconvenio_particularidadeswwds_11_tfconveguaredadmin = AV53TFConveGuarEdadMin ;
      AV86Clienteconvenio_particularidadeswwds_12_tfconveguaredadmin_to = AV54TFConveGuarEdadMin_To ;
      AV87Clienteconvenio_particularidadeswwds_13_tfconveguaredadmax = AV55TFConveGuarEdadMax ;
      AV88Clienteconvenio_particularidadeswwds_14_tfconveguaredadmax_to = AV56TFConveGuarEdadMax_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1270ConveDiaHsPExt ,
                                           AV83Clienteconvenio_particularidadeswwds_9_tfconvediahspext_sels ,
                                           AV75Clienteconvenio_particularidadeswwds_1_tfcliconvevig ,
                                           AV76Clienteconvenio_particularidadeswwds_2_tfcliconvevig_to ,
                                           Short.valueOf(AV77Clienteconvenio_particularidadeswwds_3_tfconveinterdiasjor) ,
                                           Short.valueOf(AV78Clienteconvenio_particularidadeswwds_4_tfconveinterdiasjor_to) ,
                                           Byte.valueOf(AV79Clienteconvenio_particularidadeswwds_5_tfconveminmesesvac) ,
                                           Byte.valueOf(AV80Clienteconvenio_particularidadeswwds_6_tfconveminmesesvac_to) ,
                                           AV81Clienteconvenio_particularidadeswwds_7_tfconvemeshspext ,
                                           AV82Clienteconvenio_particularidadeswwds_8_tfconvemeshspext_to ,
                                           Integer.valueOf(AV83Clienteconvenio_particularidadeswwds_9_tfconvediahspext_sels.size()) ,
                                           Byte.valueOf(AV84Clienteconvenio_particularidadeswwds_10_tfconvefondocese_sel) ,
                                           Byte.valueOf(AV85Clienteconvenio_particularidadeswwds_11_tfconveguaredadmin) ,
                                           Byte.valueOf(AV86Clienteconvenio_particularidadeswwds_12_tfconveguaredadmin_to) ,
                                           Byte.valueOf(AV87Clienteconvenio_particularidadeswwds_13_tfconveguaredadmax) ,
                                           Byte.valueOf(AV88Clienteconvenio_particularidadeswwds_14_tfconveguaredadmax_to) ,
                                           A1575CliConveVig ,
                                           Short.valueOf(A1043ConveInterDiasJor) ,
                                           Byte.valueOf(A1046ConveMinMesesVac) ,
                                           A1269ConveMesHsPExt ,
                                           Boolean.valueOf(A1401ConveFondoCese) ,
                                           Byte.valueOf(A1627ConveGuarEdadMin) ,
                                           Byte.valueOf(A1628ConveGuarEdadMax) ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Integer.valueOf(AV58CliCod) ,
                                           Short.valueOf(AV60PaiCod) ,
                                           AV61ConveCodigo ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1564CliPaiConve) ,
                                           A1565CliConvenio } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.INT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.DECIMAL,
                                           TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING
                                           }
      });
      /* Using cursor P01LL2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV58CliCod), Short.valueOf(AV60PaiCod), AV61ConveCodigo, AV75Clienteconvenio_particularidadeswwds_1_tfcliconvevig, AV76Clienteconvenio_particularidadeswwds_2_tfcliconvevig_to, Short.valueOf(AV77Clienteconvenio_particularidadeswwds_3_tfconveinterdiasjor), Short.valueOf(AV78Clienteconvenio_particularidadeswwds_4_tfconveinterdiasjor_to), Byte.valueOf(AV79Clienteconvenio_particularidadeswwds_5_tfconveminmesesvac), Byte.valueOf(AV80Clienteconvenio_particularidadeswwds_6_tfconveminmesesvac_to), AV81Clienteconvenio_particularidadeswwds_7_tfconvemeshspext, AV82Clienteconvenio_particularidadeswwds_8_tfconvemeshspext_to, Byte.valueOf(AV85Clienteconvenio_particularidadeswwds_11_tfconveguaredadmin), Byte.valueOf(AV86Clienteconvenio_particularidadeswwds_12_tfconveguaredadmin_to), Byte.valueOf(AV87Clienteconvenio_particularidadeswwds_13_tfconveguaredadmax), Byte.valueOf(AV88Clienteconvenio_particularidadeswwds_14_tfconveguaredadmax_to)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1565CliConvenio = P01LL2_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01LL2_A1564CliPaiConve[0] ;
         A3CliCod = P01LL2_A3CliCod[0] ;
         A1628ConveGuarEdadMax = P01LL2_A1628ConveGuarEdadMax[0] ;
         n1628ConveGuarEdadMax = P01LL2_n1628ConveGuarEdadMax[0] ;
         A1627ConveGuarEdadMin = P01LL2_A1627ConveGuarEdadMin[0] ;
         n1627ConveGuarEdadMin = P01LL2_n1627ConveGuarEdadMin[0] ;
         A1401ConveFondoCese = P01LL2_A1401ConveFondoCese[0] ;
         A1270ConveDiaHsPExt = P01LL2_A1270ConveDiaHsPExt[0] ;
         n1270ConveDiaHsPExt = P01LL2_n1270ConveDiaHsPExt[0] ;
         A1269ConveMesHsPExt = P01LL2_A1269ConveMesHsPExt[0] ;
         A1046ConveMinMesesVac = P01LL2_A1046ConveMinMesesVac[0] ;
         A1043ConveInterDiasJor = P01LL2_A1043ConveInterDiasJor[0] ;
         A1575CliConveVig = P01LL2_A1575CliConveVig[0] ;
         A1897ConveRelSec = P01LL2_A1897ConveRelSec[0] ;
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
         AV89GXV3 = 1 ;
         while ( AV89GXV3 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV89GXV3));
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
                  GXt_char10 = "" ;
                  GXv_char3[0] = GXt_char10 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1565CliConvenio, GXv_char3) ;
                  clienteconvenio_particularidadeswwexport.this.GXt_char10 = GXv_char3[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char10 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliConveVig") == 0 )
               {
                  GXt_dtime9 = GXutil.resetTime( A1575CliConveVig );
                  AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setDate( GXt_dtime9 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveInterDiasJor") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1043ConveInterDiasJor );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveMinMesesVac") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1046ConveMinMesesVac );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveMesHsPExt") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1269ConveMesHsPExt)) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveDiaHsPExt") == 0 )
               {
                  if ( ! (GXutil.strcmp("", A1270ConveDiaHsPExt)==0) )
                  {
                     AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomainalgoritmodiasmeshsext.getDescription(httpContext,(String)A1270ConveDiaHsPExt), "") );
                  }
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveFondoCese") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1401ConveFondoCese) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveGuarEdadMin") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1627ConveGuarEdadMin );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveGuarEdadMax") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1628ConveGuarEdadMax );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "&CliReDTChar") == 0 )
               {
                  GXt_char10 = AV67CliReDTChar ;
                  GXv_char3[0] = GXt_char10 ;
                  new web.getreleasedtchar(remoteHandle, context).execute( A3CliCod, A1897ConveRelSec, GXv_char3) ;
                  clienteconvenio_particularidadeswwexport.this.GXt_char10 = GXv_char3[0] ;
                  AV67CliReDTChar = GXt_char10 ;
                  GXt_char10 = "" ;
                  GXv_char3[0] = GXt_char10 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV67CliReDTChar, GXv_char3) ;
                  clienteconvenio_particularidadeswwexport.this.GXt_char10 = GXv_char3[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char10 );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV89GXV3 = (int)(AV89GXV3+1) ;
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
      GXv_SdtWWPColumnsSelector11[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, "CliConveVig", "", "Fecha de vigencia", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      GXv_SdtWWPColumnsSelector11[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, "ConveInterDiasJor", "", "Intervalo de jornadas trabajadas para x días de vacación", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      GXv_SdtWWPColumnsSelector11[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, "ConveMinMesesVac", "", "Antiguedad en meses mínima para acumular días fijos de vacaciones", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      GXv_SdtWWPColumnsSelector11[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, "ConveMesHsPExt", "", "Cantidad de horas del mes para calcular horas extras", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      GXv_SdtWWPColumnsSelector11[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, "ConveDiaHsPExt", "", "Algoritmo para cantidad de días del mes para cálculo de horas extras", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      GXv_SdtWWPColumnsSelector11[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, "ConveFondoCese", "", "Maneja fondo de cese laboral (no liquida indemnizacion por antiguedad ni sustitutiva del preaviso)", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      GXv_SdtWWPColumnsSelector11[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, "ConveGuarEdadMin", "", "Edad del hijo/hija mínima en meses para gozar de beneficio de guardería", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      GXv_SdtWWPColumnsSelector11[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, "ConveGuarEdadMax", "", "Edad máxima en años del hijo/hija hasta la que puede gozar el beneficio de guardería", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      GXv_SdtWWPColumnsSelector11[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, "&VerSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      GXv_SdtWWPColumnsSelector11[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, "&ModificarSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      GXv_SdtWWPColumnsSelector11[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, "&EliminarSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      GXv_SdtWWPColumnsSelector11[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, "&CliReDTChar", "", "Fecha/hora de liberación", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      GXt_char10 = AV28UserCustomValue ;
      GXv_char3[0] = GXt_char10 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "ClienteConvenio_ParticularidadesWWColumnsSelector", GXv_char3) ;
      clienteconvenio_particularidadeswwexport.this.GXt_char10 = GXv_char3[0] ;
      AV28UserCustomValue = GXt_char10 ;
      if ( ! ( (GXutil.strcmp("", AV28UserCustomValue)==0) ) )
      {
         AV25ColumnsSelectorAux.fromxml(AV28UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector11[0] = AV25ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector12[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, GXv_SdtWWPColumnsSelector12) ;
         AV25ColumnsSelectorAux = GXv_SdtWWPColumnsSelector11[0] ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("ClienteConvenio_ParticularidadesWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ClienteConvenio_ParticularidadesWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("ClienteConvenio_ParticularidadesWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV90GXV4 = 1 ;
      while ( AV90GXV4 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV90GXV4));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICONVEVIG") == 0 )
         {
            AV35TFCliConveVig = localUtil.ctod( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV36TFCliConveVig_To = localUtil.ctod( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEINTERDIASJOR") == 0 )
         {
            AV37TFConveInterDiasJor = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV38TFConveInterDiasJor_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEMINMESESVAC") == 0 )
         {
            AV39TFConveMinMesesVac = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV40TFConveMinMesesVac_To = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEMESHSPEXT") == 0 )
         {
            AV41TFConveMesHsPExt = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV42TFConveMesHsPExt_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEDIAHSPEXT_SEL") == 0 )
         {
            AV43TFConveDiaHsPExt_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV44TFConveDiaHsPExt_Sels.fromJSonString(AV43TFConveDiaHsPExt_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEFONDOCESE_SEL") == 0 )
         {
            AV46TFConveFondoCese_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEGUAREDADMIN") == 0 )
         {
            AV53TFConveGuarEdadMin = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV54TFConveGuarEdadMin_To = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEGUAREDADMAX") == 0 )
         {
            AV55TFConveGuarEdadMax = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV56TFConveGuarEdadMax_To = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV68MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV90GXV4 = (int)(AV90GXV4+1) ;
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
      this.aP0[0] = clienteconvenio_particularidadeswwexport.this.AV12Filename;
      this.aP1[0] = clienteconvenio_particularidadeswwexport.this.AV13ErrorMessage;
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
      AV61ConveCodigo = "" ;
      GXv_boolean6 = new boolean[1] ;
      AV71Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV35TFCliConveVig = GXutil.nullDate() ;
      AV36TFCliConveVig_To = GXutil.nullDate() ;
      AV41TFConveMesHsPExt = DecimalUtil.ZERO ;
      AV42TFConveMesHsPExt_To = DecimalUtil.ZERO ;
      AV44TFConveDiaHsPExt_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV45TFConveDiaHsPExt_Sel = "" ;
      GXv_exceldoc8 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int4 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A1565CliConvenio = "" ;
      A1575CliConveVig = GXutil.nullDate() ;
      A1269ConveMesHsPExt = DecimalUtil.ZERO ;
      A1270ConveDiaHsPExt = "" ;
      AV75Clienteconvenio_particularidadeswwds_1_tfcliconvevig = GXutil.nullDate() ;
      AV76Clienteconvenio_particularidadeswwds_2_tfcliconvevig_to = GXutil.nullDate() ;
      AV81Clienteconvenio_particularidadeswwds_7_tfconvemeshspext = DecimalUtil.ZERO ;
      AV82Clienteconvenio_particularidadeswwds_8_tfconvemeshspext_to = DecimalUtil.ZERO ;
      AV83Clienteconvenio_particularidadeswwds_9_tfconvediahspext_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      P01LL2_A1565CliConvenio = new String[] {""} ;
      P01LL2_A1564CliPaiConve = new short[1] ;
      P01LL2_A3CliCod = new int[1] ;
      P01LL2_A1628ConveGuarEdadMax = new byte[1] ;
      P01LL2_n1628ConveGuarEdadMax = new boolean[] {false} ;
      P01LL2_A1627ConveGuarEdadMin = new byte[1] ;
      P01LL2_n1627ConveGuarEdadMin = new boolean[] {false} ;
      P01LL2_A1401ConveFondoCese = new boolean[] {false} ;
      P01LL2_A1270ConveDiaHsPExt = new String[] {""} ;
      P01LL2_n1270ConveDiaHsPExt = new boolean[] {false} ;
      P01LL2_A1269ConveMesHsPExt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01LL2_A1046ConveMinMesesVac = new byte[1] ;
      P01LL2_A1043ConveInterDiasJor = new short[1] ;
      P01LL2_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      P01LL2_A1897ConveRelSec = new int[1] ;
      GXt_dtime9 = GXutil.resetTime( GXutil.nullDate() );
      AV67CliReDTChar = "" ;
      AV28UserCustomValue = "" ;
      GXt_char10 = "" ;
      GXv_char3 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector11 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector12 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV43TFConveDiaHsPExt_SelsJson = "" ;
      AV68MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.clienteconvenio_particularidadeswwexport__default(),
         new Object[] {
             new Object[] {
            P01LL2_A1565CliConvenio, P01LL2_A1564CliPaiConve, P01LL2_A3CliCod, P01LL2_A1628ConveGuarEdadMax, P01LL2_n1628ConveGuarEdadMax, P01LL2_A1627ConveGuarEdadMin, P01LL2_n1627ConveGuarEdadMin, P01LL2_A1401ConveFondoCese, P01LL2_A1270ConveDiaHsPExt, P01LL2_n1270ConveDiaHsPExt,
            P01LL2_A1269ConveMesHsPExt, P01LL2_A1046ConveMinMesesVac, P01LL2_A1043ConveInterDiasJor, P01LL2_A1575CliConveVig, P01LL2_A1897ConveRelSec
            }
         }
      );
      AV71Pgmname = "ClienteConvenio_ParticularidadesWWExport" ;
      /* GeneXus formulas. */
      AV71Pgmname = "ClienteConvenio_ParticularidadesWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV39TFConveMinMesesVac ;
   private byte AV40TFConveMinMesesVac_To ;
   private byte AV46TFConveFondoCese_Sel ;
   private byte AV53TFConveGuarEdadMin ;
   private byte AV54TFConveGuarEdadMin_To ;
   private byte AV55TFConveGuarEdadMax ;
   private byte AV56TFConveGuarEdadMax_To ;
   private byte A1046ConveMinMesesVac ;
   private byte A1627ConveGuarEdadMin ;
   private byte A1628ConveGuarEdadMax ;
   private byte AV79Clienteconvenio_particularidadeswwds_5_tfconveminmesesvac ;
   private byte AV80Clienteconvenio_particularidadeswwds_6_tfconveminmesesvac_to ;
   private byte AV84Clienteconvenio_particularidadeswwds_10_tfconvefondocese_sel ;
   private byte AV85Clienteconvenio_particularidadeswwds_11_tfconveguaredadmin ;
   private byte AV86Clienteconvenio_particularidadeswwds_12_tfconveguaredadmin_to ;
   private byte AV87Clienteconvenio_particularidadeswwds_13_tfconveguaredadmax ;
   private byte AV88Clienteconvenio_particularidadeswwds_14_tfconveguaredadmax_to ;
   private short AV60PaiCod ;
   private short AV37TFConveInterDiasJor ;
   private short AV38TFConveInterDiasJor_To ;
   private short GXv_int4[] ;
   private short A1564CliPaiConve ;
   private short A1043ConveInterDiasJor ;
   private short AV77Clienteconvenio_particularidadeswwds_3_tfconveinterdiasjor ;
   private short AV78Clienteconvenio_particularidadeswwds_4_tfconveinterdiasjor_to ;
   private short AV18OrderedBy ;
   private short Gx_err ;
   private int AV58CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV72GXV1 ;
   private int AV73GXV2 ;
   private int A3CliCod ;
   private int A1897ConveRelSec ;
   private int AV83Clienteconvenio_particularidadeswwds_9_tfconvediahspext_sels_size ;
   private int AV89GXV3 ;
   private int AV90GXV4 ;
   private long AV57i ;
   private long AV32VisibleColumnCount ;
   private java.math.BigDecimal AV41TFConveMesHsPExt ;
   private java.math.BigDecimal AV42TFConveMesHsPExt_To ;
   private java.math.BigDecimal A1269ConveMesHsPExt ;
   private java.math.BigDecimal AV81Clienteconvenio_particularidadeswwds_7_tfconvemeshspext ;
   private java.math.BigDecimal AV82Clienteconvenio_particularidadeswwds_8_tfconvemeshspext_to ;
   private String AV61ConveCodigo ;
   private String AV71Pgmname ;
   private String AV45TFConveDiaHsPExt_Sel ;
   private String A1565CliConvenio ;
   private String A1270ConveDiaHsPExt ;
   private String scmdbuf ;
   private String GXt_char10 ;
   private String GXv_char3[] ;
   private java.util.Date GXt_dtime9 ;
   private java.util.Date AV35TFCliConveVig ;
   private java.util.Date AV36TFCliConveVig_To ;
   private java.util.Date A1575CliConveVig ;
   private java.util.Date AV75Clienteconvenio_particularidadeswwds_1_tfcliconvevig ;
   private java.util.Date AV76Clienteconvenio_particularidadeswwds_2_tfcliconvevig_to ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean A1401ConveFondoCese ;
   private boolean AV19OrderedDsc ;
   private boolean n1628ConveGuarEdadMax ;
   private boolean n1627ConveGuarEdadMin ;
   private boolean n1270ConveDiaHsPExt ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV43TFConveDiaHsPExt_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV67CliReDTChar ;
   private String AV68MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV44TFConveDiaHsPExt_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] P01LL2_A1565CliConvenio ;
   private short[] P01LL2_A1564CliPaiConve ;
   private int[] P01LL2_A3CliCod ;
   private byte[] P01LL2_A1628ConveGuarEdadMax ;
   private boolean[] P01LL2_n1628ConveGuarEdadMax ;
   private byte[] P01LL2_A1627ConveGuarEdadMin ;
   private boolean[] P01LL2_n1627ConveGuarEdadMin ;
   private boolean[] P01LL2_A1401ConveFondoCese ;
   private String[] P01LL2_A1270ConveDiaHsPExt ;
   private boolean[] P01LL2_n1270ConveDiaHsPExt ;
   private java.math.BigDecimal[] P01LL2_A1269ConveMesHsPExt ;
   private byte[] P01LL2_A1046ConveMinMesesVac ;
   private short[] P01LL2_A1043ConveInterDiasJor ;
   private java.util.Date[] P01LL2_A1575CliConveVig ;
   private int[] P01LL2_A1897ConveRelSec ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc8[] ;
   private GXSimpleCollection<String> AV83Clienteconvenio_particularidadeswwds_9_tfconvediahspext_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV24ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV25ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector11[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector12[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV26ColumnsSelector_Column ;
}

final  class clienteconvenio_particularidadeswwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01LL2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1270ConveDiaHsPExt ,
                                          GXSimpleCollection<String> AV83Clienteconvenio_particularidadeswwds_9_tfconvediahspext_sels ,
                                          java.util.Date AV75Clienteconvenio_particularidadeswwds_1_tfcliconvevig ,
                                          java.util.Date AV76Clienteconvenio_particularidadeswwds_2_tfcliconvevig_to ,
                                          short AV77Clienteconvenio_particularidadeswwds_3_tfconveinterdiasjor ,
                                          short AV78Clienteconvenio_particularidadeswwds_4_tfconveinterdiasjor_to ,
                                          byte AV79Clienteconvenio_particularidadeswwds_5_tfconveminmesesvac ,
                                          byte AV80Clienteconvenio_particularidadeswwds_6_tfconveminmesesvac_to ,
                                          java.math.BigDecimal AV81Clienteconvenio_particularidadeswwds_7_tfconvemeshspext ,
                                          java.math.BigDecimal AV82Clienteconvenio_particularidadeswwds_8_tfconvemeshspext_to ,
                                          int AV83Clienteconvenio_particularidadeswwds_9_tfconvediahspext_sels_size ,
                                          byte AV84Clienteconvenio_particularidadeswwds_10_tfconvefondocese_sel ,
                                          byte AV85Clienteconvenio_particularidadeswwds_11_tfconveguaredadmin ,
                                          byte AV86Clienteconvenio_particularidadeswwds_12_tfconveguaredadmin_to ,
                                          byte AV87Clienteconvenio_particularidadeswwds_13_tfconveguaredadmax ,
                                          byte AV88Clienteconvenio_particularidadeswwds_14_tfconveguaredadmax_to ,
                                          java.util.Date A1575CliConveVig ,
                                          short A1043ConveInterDiasJor ,
                                          byte A1046ConveMinMesesVac ,
                                          java.math.BigDecimal A1269ConveMesHsPExt ,
                                          boolean A1401ConveFondoCese ,
                                          byte A1627ConveGuarEdadMin ,
                                          byte A1628ConveGuarEdadMax ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          int AV58CliCod ,
                                          short AV60PaiCod ,
                                          String AV61ConveCodigo ,
                                          int A3CliCod ,
                                          short A1564CliPaiConve ,
                                          String A1565CliConvenio )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int13 = new byte[15];
      Object[] GXv_Object14 = new Object[2];
      scmdbuf = "SELECT CliConvenio, CliPaiConve, CliCod, ConveGuarEdadMax, ConveGuarEdadMin, ConveFondoCese, ConveDiaHsPExt, ConveMesHsPExt, ConveMinMesesVac, ConveInterDiasJor," ;
      scmdbuf += " CliConveVig, ConveRelSec FROM ClienteConvenio_Particularidades" ;
      addWhere(sWhereString, "(CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?))");
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV75Clienteconvenio_particularidadeswwds_1_tfcliconvevig)) )
      {
         addWhere(sWhereString, "(CliConveVig >= ?)");
      }
      else
      {
         GXv_int13[3] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV76Clienteconvenio_particularidadeswwds_2_tfcliconvevig_to)) )
      {
         addWhere(sWhereString, "(CliConveVig <= ?)");
      }
      else
      {
         GXv_int13[4] = (byte)(1) ;
      }
      if ( ! (0==AV77Clienteconvenio_particularidadeswwds_3_tfconveinterdiasjor) )
      {
         addWhere(sWhereString, "(ConveInterDiasJor >= ?)");
      }
      else
      {
         GXv_int13[5] = (byte)(1) ;
      }
      if ( ! (0==AV78Clienteconvenio_particularidadeswwds_4_tfconveinterdiasjor_to) )
      {
         addWhere(sWhereString, "(ConveInterDiasJor <= ?)");
      }
      else
      {
         GXv_int13[6] = (byte)(1) ;
      }
      if ( ! (0==AV79Clienteconvenio_particularidadeswwds_5_tfconveminmesesvac) )
      {
         addWhere(sWhereString, "(ConveMinMesesVac >= ?)");
      }
      else
      {
         GXv_int13[7] = (byte)(1) ;
      }
      if ( ! (0==AV80Clienteconvenio_particularidadeswwds_6_tfconveminmesesvac_to) )
      {
         addWhere(sWhereString, "(ConveMinMesesVac <= ?)");
      }
      else
      {
         GXv_int13[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV81Clienteconvenio_particularidadeswwds_7_tfconvemeshspext)==0) )
      {
         addWhere(sWhereString, "(ConveMesHsPExt >= ?)");
      }
      else
      {
         GXv_int13[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV82Clienteconvenio_particularidadeswwds_8_tfconvemeshspext_to)==0) )
      {
         addWhere(sWhereString, "(ConveMesHsPExt <= ?)");
      }
      else
      {
         GXv_int13[10] = (byte)(1) ;
      }
      if ( AV83Clienteconvenio_particularidadeswwds_9_tfconvediahspext_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV83Clienteconvenio_particularidadeswwds_9_tfconvediahspext_sels, "ConveDiaHsPExt IN (", ")")+")");
      }
      if ( AV84Clienteconvenio_particularidadeswwds_10_tfconvefondocese_sel == 1 )
      {
         addWhere(sWhereString, "(ConveFondoCese = TRUE)");
      }
      if ( AV84Clienteconvenio_particularidadeswwds_10_tfconvefondocese_sel == 2 )
      {
         addWhere(sWhereString, "(ConveFondoCese = FALSE)");
      }
      if ( ! (0==AV85Clienteconvenio_particularidadeswwds_11_tfconveguaredadmin) )
      {
         addWhere(sWhereString, "(ConveGuarEdadMin >= ?)");
      }
      else
      {
         GXv_int13[11] = (byte)(1) ;
      }
      if ( ! (0==AV86Clienteconvenio_particularidadeswwds_12_tfconveguaredadmin_to) )
      {
         addWhere(sWhereString, "(ConveGuarEdadMin <= ?)");
      }
      else
      {
         GXv_int13[12] = (byte)(1) ;
      }
      if ( ! (0==AV87Clienteconvenio_particularidadeswwds_13_tfconveguaredadmax) )
      {
         addWhere(sWhereString, "(ConveGuarEdadMax >= ?)");
      }
      else
      {
         GXv_int13[13] = (byte)(1) ;
      }
      if ( ! (0==AV88Clienteconvenio_particularidadeswwds_14_tfconveguaredadmax_to) )
      {
         addWhere(sWhereString, "(ConveGuarEdadMax <= ?)");
      }
      else
      {
         GXv_int13[14] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CliConveVig" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CliConveVig DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveInterDiasJor" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveInterDiasJor DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveMinMesesVac" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveMinMesesVac DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveMesHsPExt" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveMesHsPExt DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveDiaHsPExt" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveDiaHsPExt DESC" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveFondoCese" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveFondoCese DESC" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveGuarEdadMin" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveGuarEdadMin DESC" ;
      }
      else if ( ( AV18OrderedBy == 8 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveGuarEdadMax" ;
      }
      else if ( ( AV18OrderedBy == 8 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveGuarEdadMax DESC" ;
      }
      GXv_Object14[0] = scmdbuf ;
      GXv_Object14[1] = GXv_int13 ;
      return GXv_Object14 ;
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
                  return conditional_P01LL2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (java.util.Date)dynConstraints[2] , (java.util.Date)dynConstraints[3] , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).byteValue() , ((Number) dynConstraints[7]).byteValue() , (java.math.BigDecimal)dynConstraints[8] , (java.math.BigDecimal)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).byteValue() , ((Number) dynConstraints[12]).byteValue() , ((Number) dynConstraints[13]).byteValue() , ((Number) dynConstraints[14]).byteValue() , ((Number) dynConstraints[15]).byteValue() , (java.util.Date)dynConstraints[16] , ((Number) dynConstraints[17]).shortValue() , ((Number) dynConstraints[18]).byteValue() , (java.math.BigDecimal)dynConstraints[19] , ((Boolean) dynConstraints[20]).booleanValue() , ((Number) dynConstraints[21]).byteValue() , ((Number) dynConstraints[22]).byteValue() , ((Number) dynConstraints[23]).shortValue() , ((Boolean) dynConstraints[24]).booleanValue() , ((Number) dynConstraints[25]).intValue() , ((Number) dynConstraints[26]).shortValue() , (String)dynConstraints[27] , ((Number) dynConstraints[28]).intValue() , ((Number) dynConstraints[29]).shortValue() , (String)dynConstraints[30] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01LL2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((byte[]) buf[5])[0] = rslt.getByte(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((boolean[]) buf[7])[0] = rslt.getBoolean(6);
               ((String[]) buf[8])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(8,1);
               ((byte[]) buf[11])[0] = rslt.getByte(9);
               ((short[]) buf[12])[0] = rslt.getShort(10);
               ((java.util.Date[]) buf[13])[0] = rslt.getGXDate(11);
               ((int[]) buf[14])[0] = rslt.getInt(12);
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
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[18]);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[19]);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[20]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[21]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[22]).byteValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[23]).byteValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[24], 1);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 1);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[26]).byteValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[27]).byteValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[28]).byteValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[29]).byteValue());
               }
               return;
      }
   }

}

