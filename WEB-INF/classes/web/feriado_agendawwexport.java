package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class feriado_agendawwexport extends GXProcedure
{
   public feriado_agendawwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( feriado_agendawwexport.class ), "" );
   }

   public feriado_agendawwexport( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      feriado_agendawwexport.this.aP1 = new String[] {""};
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
      feriado_agendawwexport.this.aP0 = aP0;
      feriado_agendawwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWferiado_agenda", GXv_boolean2) ;
      feriado_agendawwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV81Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "feriado_agendaWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV77TFFerId_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Id", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         feriado_agendawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV59i = 1 ;
         AV82GXV1 = 1 ;
         while ( AV82GXV1 <= AV77TFFerId_Sels.size() )
         {
            AV78TFFerId_Sel = (String)AV77TFFerId_Sels.elementAt(-1+AV82GXV1) ;
            if ( AV59i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV78TFFerId_Sel, GXv_char7) ;
            feriado_agendawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV59i = (long)(AV59i+1) ;
            AV82GXV1 = (int)(AV82GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV76TFFerId)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Id", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            feriado_agendawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV76TFFerId, GXv_char7) ;
            feriado_agendawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV38TFFerDescrip_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         feriado_agendawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV59i = 1 ;
         AV83GXV2 = 1 ;
         while ( AV83GXV2 <= AV38TFFerDescrip_Sels.size() )
         {
            AV39TFFerDescrip_Sel = (String)AV38TFFerDescrip_Sels.elementAt(-1+AV83GXV2) ;
            if ( AV59i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV39TFFerDescrip_Sel, GXv_char7) ;
            feriado_agendawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV59i = (long)(AV59i+1) ;
            AV83GXV2 = (int)(AV83GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV37TFFerDescrip)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            feriado_agendawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV37TFFerDescrip, GXv_char7) ;
            feriado_agendawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV40TFFerAnio) && (0==AV41TFFerAnio_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Año", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         feriado_agendawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV40TFFerAnio );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         feriado_agendawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV41TFFerAnio_To );
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV42TFFerFecha)) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV43TFFerFecha_To)) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Fecha", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         feriado_agendawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime8 = GXutil.resetTime( AV42TFFerFecha );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( GXt_dtime8 );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         feriado_agendawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime8 = GXutil.resetTime( AV43TFFerFecha_To );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setDate( GXt_dtime8 );
      }
      if ( ! ( ( AV45TFFeriadoTipo_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         feriado_agendawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV59i = 1 ;
         AV84GXV3 = 1 ;
         while ( AV84GXV3 <= AV45TFFeriadoTipo_Sels.size() )
         {
            AV46TFFeriadoTipo_Sel = (String)AV45TFFeriadoTipo_Sels.elementAt(-1+AV84GXV3) ;
            if ( AV59i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaintipo_feriado.getDescription(httpContext,(String)AV46TFFeriadoTipo_Sel), "") );
            AV59i = (long)(AV59i+1) ;
            AV84GXV3 = (int)(AV84GXV3+1) ;
         }
      }
      if ( ! ( ( AV57TFFeriadoConvenio_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Convenio", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         feriado_agendawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV59i = 1 ;
         AV85GXV4 = 1 ;
         while ( AV85GXV4 <= AV57TFFeriadoConvenio_Sels.size() )
         {
            AV58TFFeriadoConvenio_Sel = (String)AV57TFFeriadoConvenio_Sels.elementAt(-1+AV85GXV4) ;
            if ( AV59i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV58TFFeriadoConvenio_Sel, GXv_char7) ;
            feriado_agendawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV59i = (long)(AV59i+1) ;
            AV85GXV4 = (int)(AV85GXV4+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV56TFFeriadoConvenio)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Convenio", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            feriado_agendawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV56TFFeriadoConvenio, GXv_char7) ;
            feriado_agendawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV33VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV21Session.getValue("feriado_agendaWWColumnsSelector"), "") != 0 )
      {
         AV28ColumnsSelectorXML = AV21Session.getValue("feriado_agendaWWColumnsSelector") ;
         AV25ColumnsSelector.fromxml(AV28ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      AV27ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      AV27ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Isvisible( true );
      AV27ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Columnname( "PaiCod" );
      AV27ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Displayname( httpContext.getMessage( "Cod. Pais", "") );
      AV27ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Order( (short)(AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size()+1) );
      AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().add(AV27ColumnsSelector_Column, 0);
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV86GXV5 = 1 ;
      while ( AV86GXV5 <= AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV27ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV86GXV5));
         if ( AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setColor( 11 );
            AV33VisibleColumnCount = (long)(AV33VisibleColumnCount+1) ;
         }
         AV86GXV5 = (int)(AV86GXV5+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV88Feriado_agendawwds_1_tfferid = AV76TFFerId ;
      AV89Feriado_agendawwds_2_tfferid_sels = AV77TFFerId_Sels ;
      AV90Feriado_agendawwds_3_tfferdescrip = AV37TFFerDescrip ;
      AV91Feriado_agendawwds_4_tfferdescrip_sels = AV38TFFerDescrip_Sels ;
      AV92Feriado_agendawwds_5_tfferanio = AV40TFFerAnio ;
      AV93Feriado_agendawwds_6_tfferanio_to = AV41TFFerAnio_To ;
      AV94Feriado_agendawwds_7_tfferfecha = AV42TFFerFecha ;
      AV95Feriado_agendawwds_8_tfferfecha_to = AV43TFFerFecha_To ;
      AV96Feriado_agendawwds_9_tfferiadotipo_sels = AV45TFFeriadoTipo_Sels ;
      AV97Feriado_agendawwds_10_tfferiadoconvenio = AV56TFFeriadoConvenio ;
      AV98Feriado_agendawwds_11_tfferiadoconvenio_sels = AV57TFFeriadoConvenio_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1223FerId ,
                                           AV89Feriado_agendawwds_2_tfferid_sels ,
                                           A1228FerDescrip ,
                                           AV91Feriado_agendawwds_4_tfferdescrip_sels ,
                                           A1233FeriadoTipo ,
                                           AV96Feriado_agendawwds_9_tfferiadotipo_sels ,
                                           A1234FeriadoConvenio ,
                                           AV98Feriado_agendawwds_11_tfferiadoconvenio_sels ,
                                           Integer.valueOf(AV89Feriado_agendawwds_2_tfferid_sels.size()) ,
                                           AV88Feriado_agendawwds_1_tfferid ,
                                           Integer.valueOf(AV91Feriado_agendawwds_4_tfferdescrip_sels.size()) ,
                                           AV90Feriado_agendawwds_3_tfferdescrip ,
                                           Short.valueOf(AV92Feriado_agendawwds_5_tfferanio) ,
                                           Short.valueOf(AV93Feriado_agendawwds_6_tfferanio_to) ,
                                           AV94Feriado_agendawwds_7_tfferfecha ,
                                           AV95Feriado_agendawwds_8_tfferfecha_to ,
                                           Integer.valueOf(AV96Feriado_agendawwds_9_tfferiadotipo_sels.size()) ,
                                           Integer.valueOf(AV98Feriado_agendawwds_11_tfferiadoconvenio_sels.size()) ,
                                           AV97Feriado_agendawwds_10_tfferiadoconvenio ,
                                           Short.valueOf(AV62PaiCod) ,
                                           Short.valueOf(A1226FerAnio) ,
                                           A1227FerFecha ,
                                           Short.valueOf(A46PaiCod) ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DATE, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV88Feriado_agendawwds_1_tfferid = GXutil.padr( GXutil.rtrim( AV88Feriado_agendawwds_1_tfferid), 40, "%") ;
      lV90Feriado_agendawwds_3_tfferdescrip = GXutil.concat( GXutil.rtrim( AV90Feriado_agendawwds_3_tfferdescrip), "%", "") ;
      lV97Feriado_agendawwds_10_tfferiadoconvenio = GXutil.padr( GXutil.rtrim( AV97Feriado_agendawwds_10_tfferiadoconvenio), 20, "%") ;
      /* Using cursor P01IC2 */
      pr_default.execute(0, new Object[] {lV88Feriado_agendawwds_1_tfferid, lV90Feriado_agendawwds_3_tfferdescrip, Short.valueOf(AV92Feriado_agendawwds_5_tfferanio), Short.valueOf(AV93Feriado_agendawwds_6_tfferanio_to), AV94Feriado_agendawwds_7_tfferfecha, AV95Feriado_agendawwds_8_tfferfecha_to, lV97Feriado_agendawwds_10_tfferiadoconvenio, Short.valueOf(AV62PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A46PaiCod = P01IC2_A46PaiCod[0] ;
         A1234FeriadoConvenio = P01IC2_A1234FeriadoConvenio[0] ;
         n1234FeriadoConvenio = P01IC2_n1234FeriadoConvenio[0] ;
         A1233FeriadoTipo = P01IC2_A1233FeriadoTipo[0] ;
         A1227FerFecha = P01IC2_A1227FerFecha[0] ;
         A1226FerAnio = P01IC2_A1226FerAnio[0] ;
         A1228FerDescrip = P01IC2_A1228FerDescrip[0] ;
         A1223FerId = P01IC2_A1223FerId[0] ;
         A1234FeriadoConvenio = P01IC2_A1234FeriadoConvenio[0] ;
         n1234FeriadoConvenio = P01IC2_n1234FeriadoConvenio[0] ;
         A1233FeriadoTipo = P01IC2_A1233FeriadoTipo[0] ;
         A1228FerDescrip = P01IC2_A1228FerDescrip[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV33VisibleColumnCount = 0 ;
         AV99GXV6 = 1 ;
         while ( AV99GXV6 <= AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV27ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV99GXV6));
            if ( AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiCod") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setNumber( A46PaiCod );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "FerId") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1223FerId, GXv_char7) ;
                  feriado_agendawwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "FerDescrip") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1228FerDescrip, GXv_char7) ;
                  feriado_agendawwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "FerAnio") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setNumber( A1226FerAnio );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "FerFecha") == 0 )
               {
                  GXt_dtime8 = GXutil.resetTime( A1227FerFecha );
                  AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setDate( GXt_dtime8 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "FeriadoTipo") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaintipo_feriado.getDescription(httpContext,(String)A1233FeriadoTipo), "") );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "FeriadoConvenio") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1234FeriadoConvenio, GXv_char7) ;
                  feriado_agendawwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               AV33VisibleColumnCount = (long)(AV33VisibleColumnCount+1) ;
            }
            AV99GXV6 = (int)(AV99GXV6+1) ;
         }
         /* Execute user subroutine: 'AFTERWRITELINE' */
         S182 ();
         if ( returnInSub )
         {
            pr_default.close(0);
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
      AV25ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "FerId", "", "Id", false, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "FerDescrip", "", "Descripción", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "FerAnio", "", "Año", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "FerFecha", "", "Fecha", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "FeriadoTipo", "", "", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "&ReligNombre", "", "Religión", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "&OrigNombre", "", "Origen", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "FeriadoConvenio", "", "Convenio", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "&VerSVG", "", "", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      if ( ( ( AV100Paises.doubleValue() == ( 1 )) ) )
      {
         GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "&ModificarSVG", "", "", true, "") ;
         AV25ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "", "", "", false, "") ;
         AV25ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
      if ( ( ( AV100Paises.doubleValue() == ( 1 )) ) )
      {
         GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "&EliminarSVG", "", "", true, "") ;
         AV25ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "", "", "", false, "") ;
         AV25ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
      GXt_char6 = AV29UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "feriado_agendaWWColumnsSelector", GXv_char7) ;
      feriado_agendawwexport.this.GXt_char6 = GXv_char7[0] ;
      AV29UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV29UserCustomValue)==0) ) )
      {
         AV26ColumnsSelectorAux.fromxml(AV29UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector9[0] = AV26ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector10[0] = AV25ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, GXv_SdtWWPColumnsSelector10) ;
         AV26ColumnsSelectorAux = GXv_SdtWWPColumnsSelector9[0] ;
         AV25ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV21Session.getValue("feriado_agendaWWGridState"), "") == 0 )
      {
         AV23GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "feriado_agendaWWGridState"), null, null);
      }
      else
      {
         AV23GridState.fromxml(AV21Session.getValue("feriado_agendaWWGridState"), null, null);
      }
      AV18OrderedBy = AV23GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV23GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV101GXV7 = 1 ;
      while ( AV101GXV7 <= AV23GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV24GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV23GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV101GXV7));
         if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERID") == 0 )
         {
            AV76TFFerId = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERID_SEL") == 0 )
         {
            AV75TFFerId_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV77TFFerId_Sels.fromJSonString(AV75TFFerId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERDESCRIP") == 0 )
         {
            AV37TFFerDescrip = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERDESCRIP_SEL") == 0 )
         {
            AV36TFFerDescrip_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV38TFFerDescrip_Sels.fromJSonString(AV36TFFerDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERANIO") == 0 )
         {
            AV40TFFerAnio = (short)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV41TFFerAnio_To = (short)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERFECHA") == 0 )
         {
            AV42TFFerFecha = localUtil.ctod( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV43TFFerFecha_To = localUtil.ctod( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERIADOTIPO_SEL") == 0 )
         {
            AV44TFFeriadoTipo_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV45TFFeriadoTipo_Sels.fromJSonString(AV44TFFeriadoTipo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERIADOCONVENIO") == 0 )
         {
            AV56TFFeriadoConvenio = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFERIADOCONVENIO_SEL") == 0 )
         {
            AV55TFFeriadoConvenio_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV57TFFeriadoConvenio_Sels.fromJSonString(AV55TFFeriadoConvenio_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV71MenuOpcCod = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
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
      this.aP0[0] = feriado_agendawwexport.this.AV12Filename;
      this.aP1[0] = feriado_agendawwexport.this.AV13ErrorMessage;
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
      AV81Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV77TFFerId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV78TFFerId_Sel = "" ;
      AV76TFFerId = "" ;
      AV38TFFerDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV39TFFerDescrip_Sel = "" ;
      AV37TFFerDescrip = "" ;
      AV42TFFerFecha = GXutil.nullDate() ;
      AV43TFFerFecha_To = GXutil.nullDate() ;
      AV45TFFeriadoTipo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV46TFFeriadoTipo_Sel = "" ;
      AV57TFFeriadoConvenio_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV58TFFeriadoConvenio_Sel = "" ;
      AV56TFFeriadoConvenio = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV21Session = httpContext.getWebSession();
      AV28ColumnsSelectorXML = "" ;
      AV25ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV27ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A1223FerId = "" ;
      A1228FerDescrip = "" ;
      A1227FerFecha = GXutil.nullDate() ;
      A1233FeriadoTipo = "" ;
      A1234FeriadoConvenio = "" ;
      AV88Feriado_agendawwds_1_tfferid = "" ;
      AV89Feriado_agendawwds_2_tfferid_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV90Feriado_agendawwds_3_tfferdescrip = "" ;
      AV91Feriado_agendawwds_4_tfferdescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV94Feriado_agendawwds_7_tfferfecha = GXutil.nullDate() ;
      AV95Feriado_agendawwds_8_tfferfecha_to = GXutil.nullDate() ;
      AV96Feriado_agendawwds_9_tfferiadotipo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV97Feriado_agendawwds_10_tfferiadoconvenio = "" ;
      AV98Feriado_agendawwds_11_tfferiadoconvenio_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV88Feriado_agendawwds_1_tfferid = "" ;
      lV90Feriado_agendawwds_3_tfferdescrip = "" ;
      lV97Feriado_agendawwds_10_tfferiadoconvenio = "" ;
      P01IC2_A46PaiCod = new short[1] ;
      P01IC2_A1234FeriadoConvenio = new String[] {""} ;
      P01IC2_n1234FeriadoConvenio = new boolean[] {false} ;
      P01IC2_A1233FeriadoTipo = new String[] {""} ;
      P01IC2_A1227FerFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P01IC2_A1226FerAnio = new short[1] ;
      P01IC2_A1228FerDescrip = new String[] {""} ;
      P01IC2_A1223FerId = new String[] {""} ;
      GXt_dtime8 = GXutil.resetTime( GXutil.nullDate() );
      AV100Paises = DecimalUtil.ZERO ;
      AV29UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV26ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector10 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV23GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV24GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV75TFFerId_SelsJson = "" ;
      AV36TFFerDescrip_SelsJson = "" ;
      AV44TFFeriadoTipo_SelsJson = "" ;
      AV55TFFeriadoConvenio_SelsJson = "" ;
      AV71MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.feriado_agendawwexport__default(),
         new Object[] {
             new Object[] {
            P01IC2_A46PaiCod, P01IC2_A1234FeriadoConvenio, P01IC2_n1234FeriadoConvenio, P01IC2_A1233FeriadoTipo, P01IC2_A1227FerFecha, P01IC2_A1226FerAnio, P01IC2_A1228FerDescrip, P01IC2_A1223FerId
            }
         }
      );
      AV81Pgmname = "feriado_agendaWWExport" ;
      /* GeneXus formulas. */
      AV81Pgmname = "feriado_agendaWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short AV40TFFerAnio ;
   private short AV41TFFerAnio_To ;
   private short GXv_int5[] ;
   private short A46PaiCod ;
   private short A1226FerAnio ;
   private short AV92Feriado_agendawwds_5_tfferanio ;
   private short AV93Feriado_agendawwds_6_tfferanio_to ;
   private short AV62PaiCod ;
   private short AV18OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV82GXV1 ;
   private int AV83GXV2 ;
   private int AV84GXV3 ;
   private int AV85GXV4 ;
   private int AV86GXV5 ;
   private int AV89Feriado_agendawwds_2_tfferid_sels_size ;
   private int AV91Feriado_agendawwds_4_tfferdescrip_sels_size ;
   private int AV96Feriado_agendawwds_9_tfferiadotipo_sels_size ;
   private int AV98Feriado_agendawwds_11_tfferiadoconvenio_sels_size ;
   private int AV99GXV6 ;
   private int AV101GXV7 ;
   private long AV59i ;
   private long AV33VisibleColumnCount ;
   private java.math.BigDecimal AV100Paises ;
   private String AV81Pgmname ;
   private String AV78TFFerId_Sel ;
   private String AV76TFFerId ;
   private String AV46TFFeriadoTipo_Sel ;
   private String AV58TFFeriadoConvenio_Sel ;
   private String AV56TFFeriadoConvenio ;
   private String A1223FerId ;
   private String A1233FeriadoTipo ;
   private String A1234FeriadoConvenio ;
   private String AV88Feriado_agendawwds_1_tfferid ;
   private String AV97Feriado_agendawwds_10_tfferiadoconvenio ;
   private String scmdbuf ;
   private String lV88Feriado_agendawwds_1_tfferid ;
   private String lV97Feriado_agendawwds_10_tfferiadoconvenio ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private java.util.Date GXt_dtime8 ;
   private java.util.Date AV42TFFerFecha ;
   private java.util.Date AV43TFFerFecha_To ;
   private java.util.Date A1227FerFecha ;
   private java.util.Date AV94Feriado_agendawwds_7_tfferfecha ;
   private java.util.Date AV95Feriado_agendawwds_8_tfferfecha_to ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV19OrderedDsc ;
   private boolean n1234FeriadoConvenio ;
   private String AV28ColumnsSelectorXML ;
   private String AV29UserCustomValue ;
   private String AV75TFFerId_SelsJson ;
   private String AV36TFFerDescrip_SelsJson ;
   private String AV44TFFeriadoTipo_SelsJson ;
   private String AV55TFFeriadoConvenio_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV39TFFerDescrip_Sel ;
   private String AV37TFFerDescrip ;
   private String A1228FerDescrip ;
   private String AV90Feriado_agendawwds_3_tfferdescrip ;
   private String lV90Feriado_agendawwds_3_tfferdescrip ;
   private String AV71MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV21Session ;
   private GXSimpleCollection<String> AV77TFFerId_Sels ;
   private GXSimpleCollection<String> AV45TFFeriadoTipo_Sels ;
   private GXSimpleCollection<String> AV57TFFeriadoConvenio_Sels ;
   private GXSimpleCollection<String> AV38TFFerDescrip_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private short[] P01IC2_A46PaiCod ;
   private String[] P01IC2_A1234FeriadoConvenio ;
   private boolean[] P01IC2_n1234FeriadoConvenio ;
   private String[] P01IC2_A1233FeriadoTipo ;
   private java.util.Date[] P01IC2_A1227FerFecha ;
   private short[] P01IC2_A1226FerAnio ;
   private String[] P01IC2_A1228FerDescrip ;
   private String[] P01IC2_A1223FerId ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV89Feriado_agendawwds_2_tfferid_sels ;
   private GXSimpleCollection<String> AV96Feriado_agendawwds_9_tfferiadotipo_sels ;
   private GXSimpleCollection<String> AV98Feriado_agendawwds_11_tfferiadoconvenio_sels ;
   private GXSimpleCollection<String> AV91Feriado_agendawwds_4_tfferdescrip_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV23GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV24GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV25ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV26ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector10[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV27ColumnsSelector_Column ;
}

final  class feriado_agendawwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01IC2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1223FerId ,
                                          GXSimpleCollection<String> AV89Feriado_agendawwds_2_tfferid_sels ,
                                          String A1228FerDescrip ,
                                          GXSimpleCollection<String> AV91Feriado_agendawwds_4_tfferdescrip_sels ,
                                          String A1233FeriadoTipo ,
                                          GXSimpleCollection<String> AV96Feriado_agendawwds_9_tfferiadotipo_sels ,
                                          String A1234FeriadoConvenio ,
                                          GXSimpleCollection<String> AV98Feriado_agendawwds_11_tfferiadoconvenio_sels ,
                                          int AV89Feriado_agendawwds_2_tfferid_sels_size ,
                                          String AV88Feriado_agendawwds_1_tfferid ,
                                          int AV91Feriado_agendawwds_4_tfferdescrip_sels_size ,
                                          String AV90Feriado_agendawwds_3_tfferdescrip ,
                                          short AV92Feriado_agendawwds_5_tfferanio ,
                                          short AV93Feriado_agendawwds_6_tfferanio_to ,
                                          java.util.Date AV94Feriado_agendawwds_7_tfferfecha ,
                                          java.util.Date AV95Feriado_agendawwds_8_tfferfecha_to ,
                                          int AV96Feriado_agendawwds_9_tfferiadotipo_sels_size ,
                                          int AV98Feriado_agendawwds_11_tfferiadoconvenio_sels_size ,
                                          String AV97Feriado_agendawwds_10_tfferiadoconvenio ,
                                          short AV62PaiCod ,
                                          short A1226FerAnio ,
                                          java.util.Date A1227FerFecha ,
                                          short A46PaiCod ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[8];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT T1.PaiCod, T2.FeriadoConvenio, T2.FeriadoTipo, T1.FerFecha, T1.FerAnio, T2.FerDescrip, T1.FerId FROM (feriado_agenda T1 INNER JOIN feriado T2 ON T2.PaiCod" ;
      scmdbuf += " = T1.PaiCod AND T2.FerId = T1.FerId)" ;
      if ( ( AV89Feriado_agendawwds_2_tfferid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV88Feriado_agendawwds_1_tfferid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.FerId) like LOWER(?))");
      }
      else
      {
         GXv_int11[0] = (byte)(1) ;
      }
      if ( AV89Feriado_agendawwds_2_tfferid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV89Feriado_agendawwds_2_tfferid_sels, "T1.FerId IN (", ")")+")");
      }
      if ( ( AV91Feriado_agendawwds_4_tfferdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV90Feriado_agendawwds_3_tfferdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.FerDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( AV91Feriado_agendawwds_4_tfferdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV91Feriado_agendawwds_4_tfferdescrip_sels, "T2.FerDescrip IN (", ")")+")");
      }
      if ( ! (0==AV92Feriado_agendawwds_5_tfferanio) )
      {
         addWhere(sWhereString, "(T1.FerAnio >= ?)");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( ! (0==AV93Feriado_agendawwds_6_tfferanio_to) )
      {
         addWhere(sWhereString, "(T1.FerAnio <= ?)");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV94Feriado_agendawwds_7_tfferfecha)) )
      {
         addWhere(sWhereString, "(T1.FerFecha >= ?)");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV95Feriado_agendawwds_8_tfferfecha_to)) )
      {
         addWhere(sWhereString, "(T1.FerFecha <= ?)");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( AV96Feriado_agendawwds_9_tfferiadotipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV96Feriado_agendawwds_9_tfferiadotipo_sels, "T2.FeriadoTipo IN (", ")")+")");
      }
      if ( ( AV98Feriado_agendawwds_11_tfferiadoconvenio_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV97Feriado_agendawwds_10_tfferiadoconvenio)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.FeriadoConvenio) like LOWER(?))");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      if ( AV98Feriado_agendawwds_11_tfferiadoconvenio_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV98Feriado_agendawwds_11_tfferiadoconvenio_sels, "T2.FeriadoConvenio IN (", ")")+")");
      }
      if ( ! (0==AV62PaiCod) )
      {
         addWhere(sWhereString, "(T1.PaiCod = ?)");
      }
      else
      {
         GXv_int11[7] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.FerId" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.FerId DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.FerDescrip" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.FerDescrip DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.FerAnio" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.FerAnio DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.FerFecha" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.FerFecha DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.FeriadoTipo" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.FeriadoTipo DESC" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.FeriadoConvenio" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.FeriadoConvenio DESC" ;
      }
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
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
                  return conditional_P01IC2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).shortValue() , (java.util.Date)dynConstraints[14] , (java.util.Date)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).shortValue() , ((Number) dynConstraints[20]).shortValue() , (java.util.Date)dynConstraints[21] , ((Number) dynConstraints[22]).shortValue() , ((Number) dynConstraints[23]).shortValue() , ((Boolean) dynConstraints[24]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01IC2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(4);
               ((short[]) buf[5])[0] = rslt.getShort(5);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 40);
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
                  stmt.setString(sIdx, (String)parms[8], 40);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 400);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[10]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[12]);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[13]);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[14], 20);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[15]).shortValue());
               }
               return;
      }
   }

}

