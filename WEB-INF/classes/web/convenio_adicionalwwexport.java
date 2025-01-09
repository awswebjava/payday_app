package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class convenio_adicionalwwexport extends GXProcedure
{
   public convenio_adicionalwwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( convenio_adicionalwwexport.class ), "" );
   }

   public convenio_adicionalwwexport( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      convenio_adicionalwwexport.this.aP1 = new String[] {""};
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
      convenio_adicionalwwexport.this.aP0 = aP0;
      convenio_adicionalwwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWconvenio_adicional", GXv_boolean2) ;
      convenio_adicionalwwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV61Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "convenio_adicionalWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Adicional", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_adicionalwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV54i = 1 ;
         AV62GXV1 = 1 ;
         while ( AV62GXV1 <= AV37TFConveAdicod_Sels.size() )
         {
            AV38TFConveAdicod_Sel = (String)AV37TFConveAdicod_Sels.elementAt(-1+AV62GXV1) ;
            if ( AV54i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFConveAdicod_Sel, GXv_char7) ;
            convenio_adicionalwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV54i = (long)(AV54i+1) ;
            AV62GXV1 = (int)(AV62GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV36TFConveAdicod)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Adicional", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            convenio_adicionalwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV36TFConveAdicod, GXv_char7) ;
            convenio_adicionalwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV41TFConveAdiDescri_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Adicional", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_adicionalwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV54i = 1 ;
         AV63GXV2 = 1 ;
         while ( AV63GXV2 <= AV41TFConveAdiDescri_Sels.size() )
         {
            AV42TFConveAdiDescri_Sel = (String)AV41TFConveAdiDescri_Sels.elementAt(-1+AV63GXV2) ;
            if ( AV54i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV42TFConveAdiDescri_Sel, GXv_char7) ;
            convenio_adicionalwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV54i = (long)(AV54i+1) ;
            AV63GXV2 = (int)(AV63GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV40TFConveAdiDescri)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Adicional", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            convenio_adicionalwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFConveAdiDescri, GXv_char7) ;
            convenio_adicionalwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV43TFConveAdiAli)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV44TFConveAdiAli_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Alícuota", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_adicionalwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV43TFConveAdiAli)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_adicionalwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV44TFConveAdiAli_To)) );
      }
      if ( ! ( ( AV47TFConveAdiInfo_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Información adicional", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_adicionalwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV54i = 1 ;
         AV64GXV3 = 1 ;
         while ( AV64GXV3 <= AV47TFConveAdiInfo_Sels.size() )
         {
            AV48TFConveAdiInfo_Sel = (String)AV47TFConveAdiInfo_Sels.elementAt(-1+AV64GXV3) ;
            if ( AV54i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV48TFConveAdiInfo_Sel, 1, 1000), GXv_char7) ;
            convenio_adicionalwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV54i = (long)(AV54i+1) ;
            AV64GXV3 = (int)(AV64GXV3+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV46TFConveAdiInfo)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Información adicional", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            convenio_adicionalwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV46TFConveAdiInfo, 1, 1000), GXv_char7) ;
            convenio_adicionalwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV50TFConveAdiTipo_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_adicionalwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV54i = 1 ;
         AV65GXV4 = 1 ;
         while ( AV65GXV4 <= AV50TFConveAdiTipo_Sels.size() )
         {
            AV51TFConveAdiTipo_Sel = (String)AV50TFConveAdiTipo_Sels.elementAt(-1+AV65GXV4) ;
            if ( AV54i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaintipo_adicional.getDescription(httpContext,(String)AV51TFConveAdiTipo_Sel), "") );
            AV54i = (long)(AV54i+1) ;
            AV65GXV4 = (int)(AV65GXV4+1) ;
         }
      }
      if ( ! ( (0==AV52TFConveAdiRelSec) && (0==AV53TFConveAdiRelSec_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Liberación", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_adicionalwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV52TFConveAdiRelSec );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_adicionalwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV53TFConveAdiRelSec_To );
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("convenio_adicionalWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("convenio_adicionalWWColumnsSelector") ;
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
      AV66GXV5 = 1 ;
      while ( AV66GXV5 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV66GXV5));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV66GXV5 = (int)(AV66GXV5+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV68Convenio_adicionalwwds_1_tfconveadicod = AV36TFConveAdicod ;
      AV69Convenio_adicionalwwds_2_tfconveadicod_sels = AV37TFConveAdicod_Sels ;
      AV70Convenio_adicionalwwds_3_tfconveadidescri = AV40TFConveAdiDescri ;
      AV71Convenio_adicionalwwds_4_tfconveadidescri_sels = AV41TFConveAdiDescri_Sels ;
      AV72Convenio_adicionalwwds_5_tfconveadiali = AV43TFConveAdiAli ;
      AV73Convenio_adicionalwwds_6_tfconveadiali_to = AV44TFConveAdiAli_To ;
      AV74Convenio_adicionalwwds_7_tfconveadiinfo = AV46TFConveAdiInfo ;
      AV75Convenio_adicionalwwds_8_tfconveadiinfo_sels = AV47TFConveAdiInfo_Sels ;
      AV76Convenio_adicionalwwds_9_tfconveaditipo_sels = AV50TFConveAdiTipo_Sels ;
      AV77Convenio_adicionalwwds_10_tfconveadirelsec = AV52TFConveAdiRelSec ;
      AV78Convenio_adicionalwwds_11_tfconveadirelsec_to = AV53TFConveAdiRelSec_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A996ConveAdicod ,
                                           AV69Convenio_adicionalwwds_2_tfconveadicod_sels ,
                                           A997ConveAdiDescri ,
                                           AV71Convenio_adicionalwwds_4_tfconveadidescri_sels ,
                                           A1019ConveAdiInfo ,
                                           AV75Convenio_adicionalwwds_8_tfconveadiinfo_sels ,
                                           A1803ConveAdiTipo ,
                                           AV76Convenio_adicionalwwds_9_tfconveaditipo_sels ,
                                           Integer.valueOf(AV69Convenio_adicionalwwds_2_tfconveadicod_sels.size()) ,
                                           AV68Convenio_adicionalwwds_1_tfconveadicod ,
                                           Integer.valueOf(AV71Convenio_adicionalwwds_4_tfconveadidescri_sels.size()) ,
                                           AV70Convenio_adicionalwwds_3_tfconveadidescri ,
                                           AV72Convenio_adicionalwwds_5_tfconveadiali ,
                                           AV73Convenio_adicionalwwds_6_tfconveadiali_to ,
                                           Integer.valueOf(AV75Convenio_adicionalwwds_8_tfconveadiinfo_sels.size()) ,
                                           AV74Convenio_adicionalwwds_7_tfconveadiinfo ,
                                           Integer.valueOf(AV76Convenio_adicionalwwds_9_tfconveaditipo_sels.size()) ,
                                           Integer.valueOf(AV77Convenio_adicionalwwds_10_tfconveadirelsec) ,
                                           Integer.valueOf(AV78Convenio_adicionalwwds_11_tfconveadirelsec_to) ,
                                           A998ConveAdiAli ,
                                           Integer.valueOf(A1901ConveAdiRelSec) ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Integer.valueOf(AV55CliCod) ,
                                           Short.valueOf(AV57PaiCod) ,
                                           AV58ConveCodigo ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1564CliPaiConve) ,
                                           A1565CliConvenio } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.SHORT,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING
                                           }
      });
      lV68Convenio_adicionalwwds_1_tfconveadicod = GXutil.padr( GXutil.rtrim( AV68Convenio_adicionalwwds_1_tfconveadicod), 20, "%") ;
      lV70Convenio_adicionalwwds_3_tfconveadidescri = GXutil.concat( GXutil.rtrim( AV70Convenio_adicionalwwds_3_tfconveadidescri), "%", "") ;
      lV74Convenio_adicionalwwds_7_tfconveadiinfo = GXutil.concat( GXutil.rtrim( AV74Convenio_adicionalwwds_7_tfconveadiinfo), "%", "") ;
      /* Using cursor P02FG2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV55CliCod), Short.valueOf(AV57PaiCod), AV58ConveCodigo, lV68Convenio_adicionalwwds_1_tfconveadicod, lV70Convenio_adicionalwwds_3_tfconveadidescri, AV72Convenio_adicionalwwds_5_tfconveadiali, AV73Convenio_adicionalwwds_6_tfconveadiali_to, lV74Convenio_adicionalwwds_7_tfconveadiinfo, Integer.valueOf(AV77Convenio_adicionalwwds_10_tfconveadirelsec), Integer.valueOf(AV78Convenio_adicionalwwds_11_tfconveadirelsec_to)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1565CliConvenio = P02FG2_A1565CliConvenio[0] ;
         A1564CliPaiConve = P02FG2_A1564CliPaiConve[0] ;
         A3CliCod = P02FG2_A3CliCod[0] ;
         A1901ConveAdiRelSec = P02FG2_A1901ConveAdiRelSec[0] ;
         n1901ConveAdiRelSec = P02FG2_n1901ConveAdiRelSec[0] ;
         A1803ConveAdiTipo = P02FG2_A1803ConveAdiTipo[0] ;
         A1019ConveAdiInfo = P02FG2_A1019ConveAdiInfo[0] ;
         n1019ConveAdiInfo = P02FG2_n1019ConveAdiInfo[0] ;
         A998ConveAdiAli = P02FG2_A998ConveAdiAli[0] ;
         A997ConveAdiDescri = P02FG2_A997ConveAdiDescri[0] ;
         A996ConveAdicod = P02FG2_A996ConveAdicod[0] ;
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
         AV79GXV6 = 1 ;
         while ( AV79GXV6 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV79GXV6));
            if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveAdicod") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A996ConveAdicod, GXv_char7) ;
                  convenio_adicionalwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveAdiDescri") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A997ConveAdiDescri, GXv_char7) ;
                  convenio_adicionalwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveAdiAli") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A998ConveAdiAli)) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveAdiInfo") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( A1019ConveAdiInfo, 1, 1000), GXv_char7) ;
                  convenio_adicionalwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveAdiTipo") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaintipo_adicional.getDescription(httpContext,(String)A1803ConveAdiTipo), "") );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveAdiRelSec") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1901ConveAdiRelSec );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV79GXV6 = (int)(AV79GXV6+1) ;
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
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConveAdicod", "", "Adicional", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConveAdiDescri", "", "Adicional", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConveAdiAli", "", "Alícuota", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConveAdiInfo", "", "Información adicional", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConveAdiTipo", "", "Tipo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConveAdiRelSec", "", "Liberación", true, "") ;
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
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "convenio_adicionalWWColumnsSelector", GXv_char7) ;
      convenio_adicionalwwexport.this.GXt_char6 = GXv_char7[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("convenio_adicionalWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "convenio_adicionalWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("convenio_adicionalWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV80GXV7 = 1 ;
      while ( AV80GXV7 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV80GXV7));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADICOD") == 0 )
         {
            AV36TFConveAdicod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADICOD_SEL") == 0 )
         {
            AV35TFConveAdicod_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV37TFConveAdicod_Sels.fromJSonString(AV35TFConveAdicod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADIDESCRI") == 0 )
         {
            AV40TFConveAdiDescri = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADIDESCRI_SEL") == 0 )
         {
            AV39TFConveAdiDescri_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV41TFConveAdiDescri_Sels.fromJSonString(AV39TFConveAdiDescri_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADIALI") == 0 )
         {
            AV43TFConveAdiAli = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV44TFConveAdiAli_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADIINFO") == 0 )
         {
            AV46TFConveAdiInfo = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADIINFO_SEL") == 0 )
         {
            AV45TFConveAdiInfo_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV47TFConveAdiInfo_Sels.fromJSonString(AV45TFConveAdiInfo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADITIPO_SEL") == 0 )
         {
            AV49TFConveAdiTipo_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV50TFConveAdiTipo_Sels.fromJSonString(AV49TFConveAdiTipo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADIRELSEC") == 0 )
         {
            AV52TFConveAdiRelSec = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV53TFConveAdiRelSec_To = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV17MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV80GXV7 = (int)(AV80GXV7+1) ;
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
      this.aP0[0] = convenio_adicionalwwexport.this.AV12Filename;
      this.aP1[0] = convenio_adicionalwwexport.this.AV13ErrorMessage;
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
      AV61Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV37TFConveAdicod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV38TFConveAdicod_Sel = "" ;
      AV36TFConveAdicod = "" ;
      AV41TFConveAdiDescri_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42TFConveAdiDescri_Sel = "" ;
      AV40TFConveAdiDescri = "" ;
      AV43TFConveAdiAli = DecimalUtil.ZERO ;
      AV44TFConveAdiAli_To = DecimalUtil.ZERO ;
      AV47TFConveAdiInfo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV48TFConveAdiInfo_Sel = "" ;
      AV46TFConveAdiInfo = "" ;
      AV50TFConveAdiTipo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV51TFConveAdiTipo_Sel = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A996ConveAdicod = "" ;
      A997ConveAdiDescri = "" ;
      A998ConveAdiAli = DecimalUtil.ZERO ;
      A1019ConveAdiInfo = "" ;
      A1803ConveAdiTipo = "" ;
      AV68Convenio_adicionalwwds_1_tfconveadicod = "" ;
      AV69Convenio_adicionalwwds_2_tfconveadicod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV70Convenio_adicionalwwds_3_tfconveadidescri = "" ;
      AV71Convenio_adicionalwwds_4_tfconveadidescri_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV72Convenio_adicionalwwds_5_tfconveadiali = DecimalUtil.ZERO ;
      AV73Convenio_adicionalwwds_6_tfconveadiali_to = DecimalUtil.ZERO ;
      AV74Convenio_adicionalwwds_7_tfconveadiinfo = "" ;
      AV75Convenio_adicionalwwds_8_tfconveadiinfo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV76Convenio_adicionalwwds_9_tfconveaditipo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV68Convenio_adicionalwwds_1_tfconveadicod = "" ;
      lV70Convenio_adicionalwwds_3_tfconveadidescri = "" ;
      lV74Convenio_adicionalwwds_7_tfconveadiinfo = "" ;
      AV58ConveCodigo = "" ;
      A1565CliConvenio = "" ;
      P02FG2_A1565CliConvenio = new String[] {""} ;
      P02FG2_A1564CliPaiConve = new short[1] ;
      P02FG2_A3CliCod = new int[1] ;
      P02FG2_A1901ConveAdiRelSec = new int[1] ;
      P02FG2_n1901ConveAdiRelSec = new boolean[] {false} ;
      P02FG2_A1803ConveAdiTipo = new String[] {""} ;
      P02FG2_A1019ConveAdiInfo = new String[] {""} ;
      P02FG2_n1019ConveAdiInfo = new boolean[] {false} ;
      P02FG2_A998ConveAdiAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02FG2_A997ConveAdiDescri = new String[] {""} ;
      P02FG2_A996ConveAdicod = new String[] {""} ;
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV35TFConveAdicod_SelsJson = "" ;
      AV39TFConveAdiDescri_SelsJson = "" ;
      AV45TFConveAdiInfo_SelsJson = "" ;
      AV49TFConveAdiTipo_SelsJson = "" ;
      AV17MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.convenio_adicionalwwexport__default(),
         new Object[] {
             new Object[] {
            P02FG2_A1565CliConvenio, P02FG2_A1564CliPaiConve, P02FG2_A3CliCod, P02FG2_A1901ConveAdiRelSec, P02FG2_n1901ConveAdiRelSec, P02FG2_A1803ConveAdiTipo, P02FG2_A1019ConveAdiInfo, P02FG2_n1019ConveAdiInfo, P02FG2_A998ConveAdiAli, P02FG2_A997ConveAdiDescri,
            P02FG2_A996ConveAdicod
            }
         }
      );
      AV61Pgmname = "convenio_adicionalWWExport" ;
      /* GeneXus formulas. */
      AV61Pgmname = "convenio_adicionalWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short GXv_int5[] ;
   private short AV18OrderedBy ;
   private short AV57PaiCod ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV62GXV1 ;
   private int AV63GXV2 ;
   private int AV64GXV3 ;
   private int AV65GXV4 ;
   private int AV52TFConveAdiRelSec ;
   private int AV53TFConveAdiRelSec_To ;
   private int AV66GXV5 ;
   private int A1901ConveAdiRelSec ;
   private int AV77Convenio_adicionalwwds_10_tfconveadirelsec ;
   private int AV78Convenio_adicionalwwds_11_tfconveadirelsec_to ;
   private int AV69Convenio_adicionalwwds_2_tfconveadicod_sels_size ;
   private int AV71Convenio_adicionalwwds_4_tfconveadidescri_sels_size ;
   private int AV75Convenio_adicionalwwds_8_tfconveadiinfo_sels_size ;
   private int AV76Convenio_adicionalwwds_9_tfconveaditipo_sels_size ;
   private int AV55CliCod ;
   private int A3CliCod ;
   private int AV79GXV6 ;
   private int AV80GXV7 ;
   private long AV54i ;
   private long AV32VisibleColumnCount ;
   private java.math.BigDecimal AV43TFConveAdiAli ;
   private java.math.BigDecimal AV44TFConveAdiAli_To ;
   private java.math.BigDecimal A998ConveAdiAli ;
   private java.math.BigDecimal AV72Convenio_adicionalwwds_5_tfconveadiali ;
   private java.math.BigDecimal AV73Convenio_adicionalwwds_6_tfconveadiali_to ;
   private String AV61Pgmname ;
   private String AV38TFConveAdicod_Sel ;
   private String AV36TFConveAdicod ;
   private String AV51TFConveAdiTipo_Sel ;
   private String A996ConveAdicod ;
   private String A1803ConveAdiTipo ;
   private String AV68Convenio_adicionalwwds_1_tfconveadicod ;
   private String scmdbuf ;
   private String lV68Convenio_adicionalwwds_1_tfconveadicod ;
   private String AV58ConveCodigo ;
   private String A1565CliConvenio ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV19OrderedDsc ;
   private boolean n1901ConveAdiRelSec ;
   private boolean n1019ConveAdiInfo ;
   private String AV27ColumnsSelectorXML ;
   private String A1019ConveAdiInfo ;
   private String AV28UserCustomValue ;
   private String AV35TFConveAdicod_SelsJson ;
   private String AV39TFConveAdiDescri_SelsJson ;
   private String AV45TFConveAdiInfo_SelsJson ;
   private String AV49TFConveAdiTipo_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV42TFConveAdiDescri_Sel ;
   private String AV40TFConveAdiDescri ;
   private String AV48TFConveAdiInfo_Sel ;
   private String AV46TFConveAdiInfo ;
   private String A997ConveAdiDescri ;
   private String AV70Convenio_adicionalwwds_3_tfconveadidescri ;
   private String AV74Convenio_adicionalwwds_7_tfconveadiinfo ;
   private String lV70Convenio_adicionalwwds_3_tfconveadidescri ;
   private String lV74Convenio_adicionalwwds_7_tfconveadiinfo ;
   private String AV17MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV37TFConveAdicod_Sels ;
   private GXSimpleCollection<String> AV50TFConveAdiTipo_Sels ;
   private GXSimpleCollection<String> AV41TFConveAdiDescri_Sels ;
   private GXSimpleCollection<String> AV47TFConveAdiInfo_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] P02FG2_A1565CliConvenio ;
   private short[] P02FG2_A1564CliPaiConve ;
   private int[] P02FG2_A3CliCod ;
   private int[] P02FG2_A1901ConveAdiRelSec ;
   private boolean[] P02FG2_n1901ConveAdiRelSec ;
   private String[] P02FG2_A1803ConveAdiTipo ;
   private String[] P02FG2_A1019ConveAdiInfo ;
   private boolean[] P02FG2_n1019ConveAdiInfo ;
   private java.math.BigDecimal[] P02FG2_A998ConveAdiAli ;
   private String[] P02FG2_A997ConveAdiDescri ;
   private String[] P02FG2_A996ConveAdicod ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV69Convenio_adicionalwwds_2_tfconveadicod_sels ;
   private GXSimpleCollection<String> AV76Convenio_adicionalwwds_9_tfconveaditipo_sels ;
   private GXSimpleCollection<String> AV71Convenio_adicionalwwds_4_tfconveadidescri_sels ;
   private GXSimpleCollection<String> AV75Convenio_adicionalwwds_8_tfconveadiinfo_sels ;
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

final  class convenio_adicionalwwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02FG2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A996ConveAdicod ,
                                          GXSimpleCollection<String> AV69Convenio_adicionalwwds_2_tfconveadicod_sels ,
                                          String A997ConveAdiDescri ,
                                          GXSimpleCollection<String> AV71Convenio_adicionalwwds_4_tfconveadidescri_sels ,
                                          String A1019ConveAdiInfo ,
                                          GXSimpleCollection<String> AV75Convenio_adicionalwwds_8_tfconveadiinfo_sels ,
                                          String A1803ConveAdiTipo ,
                                          GXSimpleCollection<String> AV76Convenio_adicionalwwds_9_tfconveaditipo_sels ,
                                          int AV69Convenio_adicionalwwds_2_tfconveadicod_sels_size ,
                                          String AV68Convenio_adicionalwwds_1_tfconveadicod ,
                                          int AV71Convenio_adicionalwwds_4_tfconveadidescri_sels_size ,
                                          String AV70Convenio_adicionalwwds_3_tfconveadidescri ,
                                          java.math.BigDecimal AV72Convenio_adicionalwwds_5_tfconveadiali ,
                                          java.math.BigDecimal AV73Convenio_adicionalwwds_6_tfconveadiali_to ,
                                          int AV75Convenio_adicionalwwds_8_tfconveadiinfo_sels_size ,
                                          String AV74Convenio_adicionalwwds_7_tfconveadiinfo ,
                                          int AV76Convenio_adicionalwwds_9_tfconveaditipo_sels_size ,
                                          int AV77Convenio_adicionalwwds_10_tfconveadirelsec ,
                                          int AV78Convenio_adicionalwwds_11_tfconveadirelsec_to ,
                                          java.math.BigDecimal A998ConveAdiAli ,
                                          int A1901ConveAdiRelSec ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          int AV55CliCod ,
                                          short AV57PaiCod ,
                                          String AV58ConveCodigo ,
                                          int A3CliCod ,
                                          short A1564CliPaiConve ,
                                          String A1565CliConvenio )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[10];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT CliConvenio, CliPaiConve, CliCod, ConveAdiRelSec, ConveAdiTipo, ConveAdiInfo, ConveAdiAli, ConveAdiDescri, ConveAdicod FROM convenio_adicional" ;
      addWhere(sWhereString, "(CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?))");
      if ( ( AV69Convenio_adicionalwwds_2_tfconveadicod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV68Convenio_adicionalwwds_1_tfconveadicod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveAdicod) like LOWER(?))");
      }
      else
      {
         GXv_int10[3] = (byte)(1) ;
      }
      if ( AV69Convenio_adicionalwwds_2_tfconveadicod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV69Convenio_adicionalwwds_2_tfconveadicod_sels, "ConveAdicod IN (", ")")+")");
      }
      if ( ( AV71Convenio_adicionalwwds_4_tfconveadidescri_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV70Convenio_adicionalwwds_3_tfconveadidescri)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveAdiDescri) like LOWER(?))");
      }
      else
      {
         GXv_int10[4] = (byte)(1) ;
      }
      if ( AV71Convenio_adicionalwwds_4_tfconveadidescri_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV71Convenio_adicionalwwds_4_tfconveadidescri_sels, "ConveAdiDescri IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV72Convenio_adicionalwwds_5_tfconveadiali)==0) )
      {
         addWhere(sWhereString, "(ConveAdiAli >= ?)");
      }
      else
      {
         GXv_int10[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV73Convenio_adicionalwwds_6_tfconveadiali_to)==0) )
      {
         addWhere(sWhereString, "(ConveAdiAli <= ?)");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      if ( ( AV75Convenio_adicionalwwds_8_tfconveadiinfo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV74Convenio_adicionalwwds_7_tfconveadiinfo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveAdiInfo) like LOWER(?))");
      }
      else
      {
         GXv_int10[7] = (byte)(1) ;
      }
      if ( AV75Convenio_adicionalwwds_8_tfconveadiinfo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV75Convenio_adicionalwwds_8_tfconveadiinfo_sels, "ConveAdiInfo IN (", ")")+")");
      }
      if ( AV76Convenio_adicionalwwds_9_tfconveaditipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV76Convenio_adicionalwwds_9_tfconveaditipo_sels, "ConveAdiTipo IN (", ")")+")");
      }
      if ( ! (0==AV77Convenio_adicionalwwds_10_tfconveadirelsec) )
      {
         addWhere(sWhereString, "(ConveAdiRelSec >= ?)");
      }
      else
      {
         GXv_int10[8] = (byte)(1) ;
      }
      if ( ! (0==AV78Convenio_adicionalwwds_11_tfconveadirelsec_to) )
      {
         addWhere(sWhereString, "(ConveAdiRelSec <= ?)");
      }
      else
      {
         GXv_int10[9] = (byte)(1) ;
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
         scmdbuf += " ORDER BY ConveAdiDescri" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveAdiDescri DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveAdiAli" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveAdiAli DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveAdiInfo" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveAdiInfo DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveAdiTipo" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveAdiTipo DESC" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveAdiRelSec" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveAdiRelSec DESC" ;
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
                  return conditional_P02FG2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).intValue() , ((Number) dynConstraints[18]).intValue() , (java.math.BigDecimal)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).shortValue() , ((Boolean) dynConstraints[22]).booleanValue() , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).shortValue() , (String)dynConstraints[25] , ((Number) dynConstraints[26]).intValue() , ((Number) dynConstraints[27]).shortValue() , (String)dynConstraints[28] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02FG2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(5, 20);
               ((String[]) buf[6])[0] = rslt.getLongVarchar(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(7,4);
               ((String[]) buf[9])[0] = rslt.getVarchar(8);
               ((String[]) buf[10])[0] = rslt.getString(9, 20);
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
                  stmt.setVarchar(sIdx, (String)parms[14], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[15], 4);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[16], 4);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 200);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[18]).intValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[19]).intValue());
               }
               return;
      }
   }

}
