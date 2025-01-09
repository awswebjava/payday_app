package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class clientecct_fondocesewwexport extends GXProcedure
{
   public clientecct_fondocesewwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( clientecct_fondocesewwexport.class ), "" );
   }

   public clientecct_fondocesewwexport( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      clientecct_fondocesewwexport.this.aP1 = new String[] {""};
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
      clientecct_fondocesewwexport.this.aP0 = aP0;
      clientecct_fondocesewwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClientecct_fondocese", GXv_boolean2) ;
      clientecct_fondocesewwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV52Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "Clientecct_fondoceseWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV36TFCliConveVig)) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV37TFCliConveVig_To)) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Fecha de vigencia", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clientecct_fondocesewwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime6 = GXutil.resetTime( AV36TFCliConveVig );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( GXt_dtime6 );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clientecct_fondocesewwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime6 = GXutil.resetTime( AV37TFCliConveVig_To );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setDate( GXt_dtime6 );
      }
      if ( ! ( (0==AV38TFCliConveFondoSec) && (0==AV39TFCliConveFondoSec_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Fondo Sec", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clientecct_fondocesewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV38TFCliConveFondoSec );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clientecct_fondocesewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV39TFCliConveFondoSec_To );
      }
      if ( ! ( (0==AV40TFCliConveFondoMeses) && (0==AV41TFCliConveFondoMeses_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Meses desde", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clientecct_fondocesewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV40TFCliConveFondoMeses );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clientecct_fondocesewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV41TFCliConveFondoMeses_To );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV42TFCliConveFondoPrc)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV43TFCliConveFondoPrc_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Porcentaje", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clientecct_fondocesewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV42TFCliConveFondoPrc)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clientecct_fondocesewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV43TFCliConveFondoPrc_To)) );
      }
      if ( ! ( (0==AV44TFCliConveFondoRem_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Contemplar remunerativos", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clientecct_fondocesewwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV44TFCliConveFondoRem_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV44TFCliConveFondoRem_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( (0==AV45TFCliConveFondoNre_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Contemplar no remunerativos", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clientecct_fondocesewwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV45TFCliConveFondoNre_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV45TFCliConveFondoNre_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( (0==AV46TFCliConveFondoDes_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Contemplar descuentos", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clientecct_fondocesewwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV46TFCliConveFondoDes_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV46TFCliConveFondoDes_Sel == 2 )
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
      AV33VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("Clientecct_fondoceseWWColumnsSelector"), "") != 0 )
      {
         AV28ColumnsSelectorXML = AV20Session.getValue("Clientecct_fondoceseWWColumnsSelector") ;
         AV25ColumnsSelector.fromxml(AV28ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV53GXV1 = 1 ;
      while ( AV53GXV1 <= AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV27ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV53GXV1));
         if ( AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setColor( 11 );
            AV33VisibleColumnCount = (long)(AV33VisibleColumnCount+1) ;
         }
         AV53GXV1 = (int)(AV53GXV1+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV55Clientecct_fondocesewwds_1_tfcliconvevig = AV36TFCliConveVig ;
      AV56Clientecct_fondocesewwds_2_tfcliconvevig_to = AV37TFCliConveVig_To ;
      AV57Clientecct_fondocesewwds_3_tfcliconvefondosec = AV38TFCliConveFondoSec ;
      AV58Clientecct_fondocesewwds_4_tfcliconvefondosec_to = AV39TFCliConveFondoSec_To ;
      AV59Clientecct_fondocesewwds_5_tfcliconvefondomeses = AV40TFCliConveFondoMeses ;
      AV60Clientecct_fondocesewwds_6_tfcliconvefondomeses_to = AV41TFCliConveFondoMeses_To ;
      AV61Clientecct_fondocesewwds_7_tfcliconvefondoprc = AV42TFCliConveFondoPrc ;
      AV62Clientecct_fondocesewwds_8_tfcliconvefondoprc_to = AV43TFCliConveFondoPrc_To ;
      AV63Clientecct_fondocesewwds_9_tfcliconvefondorem_sel = AV44TFCliConveFondoRem_Sel ;
      AV64Clientecct_fondocesewwds_10_tfcliconvefondonre_sel = AV45TFCliConveFondoNre_Sel ;
      AV65Clientecct_fondocesewwds_11_tfcliconvefondodes_sel = AV46TFCliConveFondoDes_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV55Clientecct_fondocesewwds_1_tfcliconvevig ,
                                           AV56Clientecct_fondocesewwds_2_tfcliconvevig_to ,
                                           Short.valueOf(AV57Clientecct_fondocesewwds_3_tfcliconvefondosec) ,
                                           Short.valueOf(AV58Clientecct_fondocesewwds_4_tfcliconvefondosec_to) ,
                                           Short.valueOf(AV59Clientecct_fondocesewwds_5_tfcliconvefondomeses) ,
                                           Short.valueOf(AV60Clientecct_fondocesewwds_6_tfcliconvefondomeses_to) ,
                                           AV61Clientecct_fondocesewwds_7_tfcliconvefondoprc ,
                                           AV62Clientecct_fondocesewwds_8_tfcliconvefondoprc_to ,
                                           Byte.valueOf(AV63Clientecct_fondocesewwds_9_tfcliconvefondorem_sel) ,
                                           Byte.valueOf(AV64Clientecct_fondocesewwds_10_tfcliconvefondonre_sel) ,
                                           Byte.valueOf(AV65Clientecct_fondocesewwds_11_tfcliconvefondodes_sel) ,
                                           A1575CliConveVig ,
                                           Short.valueOf(A2147CliConveFondoSec) ,
                                           Short.valueOf(A2148CliConveFondoMeses) ,
                                           A2150CliConveFondoPrc ,
                                           Boolean.valueOf(A2151CliConveFondoRem) ,
                                           Boolean.valueOf(A2152CliConveFondoNre) ,
                                           Boolean.valueOf(A2153CliConveFondoDes) ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Integer.valueOf(AV48CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN,
                                           TypeConstants.INT, TypeConstants.INT
                                           }
      });
      /* Using cursor P02FY2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV48CliCod), AV55Clientecct_fondocesewwds_1_tfcliconvevig, AV56Clientecct_fondocesewwds_2_tfcliconvevig_to, Short.valueOf(AV57Clientecct_fondocesewwds_3_tfcliconvefondosec), Short.valueOf(AV58Clientecct_fondocesewwds_4_tfcliconvefondosec_to), Short.valueOf(AV59Clientecct_fondocesewwds_5_tfcliconvefondomeses), Short.valueOf(AV60Clientecct_fondocesewwds_6_tfcliconvefondomeses_to), AV61Clientecct_fondocesewwds_7_tfcliconvefondoprc, AV62Clientecct_fondocesewwds_8_tfcliconvefondoprc_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P02FY2_A3CliCod[0] ;
         A2153CliConveFondoDes = P02FY2_A2153CliConveFondoDes[0] ;
         A2152CliConveFondoNre = P02FY2_A2152CliConveFondoNre[0] ;
         A2151CliConveFondoRem = P02FY2_A2151CliConveFondoRem[0] ;
         A2150CliConveFondoPrc = P02FY2_A2150CliConveFondoPrc[0] ;
         A2148CliConveFondoMeses = P02FY2_A2148CliConveFondoMeses[0] ;
         A2147CliConveFondoSec = P02FY2_A2147CliConveFondoSec[0] ;
         A1575CliConveVig = P02FY2_A1575CliConveVig[0] ;
         A2154CliConveFondoRelSec = P02FY2_A2154CliConveFondoRelSec[0] ;
         A1564CliPaiConve = P02FY2_A1564CliPaiConve[0] ;
         A1565CliConvenio = P02FY2_A1565CliConvenio[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV33VisibleColumnCount = 0 ;
         AV66GXV2 = 1 ;
         while ( AV66GXV2 <= AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV27ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV66GXV2));
            if ( AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliConveVig") == 0 )
               {
                  GXt_dtime6 = GXutil.resetTime( A1575CliConveVig );
                  AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setDate( GXt_dtime6 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliConveFondoSec") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setNumber( A2147CliConveFondoSec );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliConveFondoMeses") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setNumber( A2148CliConveFondoMeses );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliConveFondoPrc") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A2150CliConveFondoPrc)) );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliConveFondoRem") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A2151CliConveFondoRem) );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliConveFondoNre") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A2152CliConveFondoNre) );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliConveFondoDes") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A2153CliConveFondoDes) );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "&CliReDTChar") == 0 )
               {
                  GXt_char7 = AV24CliReDTChar ;
                  GXv_char8[0] = GXt_char7 ;
                  new web.getreleasedtchar(remoteHandle, context).execute( A3CliCod, A2154CliConveFondoRelSec, GXv_char8) ;
                  clientecct_fondocesewwexport.this.GXt_char7 = GXv_char8[0] ;
                  AV24CliReDTChar = GXt_char7 ;
                  GXt_char7 = "" ;
                  GXv_char8[0] = GXt_char7 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV24CliReDTChar, GXv_char8) ;
                  clientecct_fondocesewwexport.this.GXt_char7 = GXv_char8[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char7 );
               }
               AV33VisibleColumnCount = (long)(AV33VisibleColumnCount+1) ;
            }
            AV66GXV2 = (int)(AV66GXV2+1) ;
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
      AV25ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "CliConveVig", "", "Fecha de vigencia", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "CliConveFondoSec", "", "Fondo Sec", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "CliConveFondoMeses", "", "Meses desde", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "CliConveFondoPrc", "", "Porcentaje", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "CliConveFondoRem", "", "Contemplar remunerativos", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "CliConveFondoNre", "", "Contemplar no remunerativos", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "CliConveFondoDes", "", "Contemplar descuentos", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "&CliReDTChar", "", "Fecha/hora de liberación", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "&VerSVG", "", "", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "&ModificarSVG", "", "", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "&EliminarSVG", "", "", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXt_char7 = AV29UserCustomValue ;
      GXv_char8[0] = GXt_char7 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "Clientecct_fondoceseWWColumnsSelector", GXv_char8) ;
      clientecct_fondocesewwexport.this.GXt_char7 = GXv_char8[0] ;
      AV29UserCustomValue = GXt_char7 ;
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
      if ( GXutil.strcmp(AV20Session.getValue("Clientecct_fondoceseWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "Clientecct_fondoceseWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("Clientecct_fondoceseWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV67GXV3 = 1 ;
      while ( AV67GXV3 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV67GXV3));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICONVEVIG") == 0 )
         {
            AV36TFCliConveVig = localUtil.ctod( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV37TFCliConveVig_To = localUtil.ctod( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICONVEFONDOSEC") == 0 )
         {
            AV38TFCliConveFondoSec = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV39TFCliConveFondoSec_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICONVEFONDOMESES") == 0 )
         {
            AV40TFCliConveFondoMeses = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV41TFCliConveFondoMeses_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICONVEFONDOPRC") == 0 )
         {
            AV42TFCliConveFondoPrc = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV43TFCliConveFondoPrc_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICONVEFONDOREM_SEL") == 0 )
         {
            AV44TFCliConveFondoRem_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICONVEFONDONRE_SEL") == 0 )
         {
            AV45TFCliConveFondoNre_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICONVEFONDODES_SEL") == 0 )
         {
            AV46TFCliConveFondoDes_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV17MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV67GXV3 = (int)(AV67GXV3+1) ;
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
      this.aP0[0] = clientecct_fondocesewwexport.this.AV12Filename;
      this.aP1[0] = clientecct_fondocesewwexport.this.AV13ErrorMessage;
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
      AV52Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV36TFCliConveVig = GXutil.nullDate() ;
      AV37TFCliConveVig_To = GXutil.nullDate() ;
      AV42TFCliConveFondoPrc = DecimalUtil.ZERO ;
      AV43TFCliConveFondoPrc_To = DecimalUtil.ZERO ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV28ColumnsSelectorXML = "" ;
      AV25ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV27ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A1575CliConveVig = GXutil.nullDate() ;
      A2150CliConveFondoPrc = DecimalUtil.ZERO ;
      AV55Clientecct_fondocesewwds_1_tfcliconvevig = GXutil.nullDate() ;
      AV56Clientecct_fondocesewwds_2_tfcliconvevig_to = GXutil.nullDate() ;
      AV61Clientecct_fondocesewwds_7_tfcliconvefondoprc = DecimalUtil.ZERO ;
      AV62Clientecct_fondocesewwds_8_tfcliconvefondoprc_to = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P02FY2_A3CliCod = new int[1] ;
      P02FY2_A2153CliConveFondoDes = new boolean[] {false} ;
      P02FY2_A2152CliConveFondoNre = new boolean[] {false} ;
      P02FY2_A2151CliConveFondoRem = new boolean[] {false} ;
      P02FY2_A2150CliConveFondoPrc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02FY2_A2148CliConveFondoMeses = new short[1] ;
      P02FY2_A2147CliConveFondoSec = new short[1] ;
      P02FY2_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      P02FY2_A2154CliConveFondoRelSec = new int[1] ;
      P02FY2_A1564CliPaiConve = new short[1] ;
      P02FY2_A1565CliConvenio = new String[] {""} ;
      A1565CliConvenio = "" ;
      GXt_dtime6 = GXutil.resetTime( GXutil.nullDate() );
      AV24CliReDTChar = "" ;
      AV29UserCustomValue = "" ;
      GXt_char7 = "" ;
      GXv_char8 = new String[1] ;
      AV26ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector10 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV17MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.clientecct_fondocesewwexport__default(),
         new Object[] {
             new Object[] {
            P02FY2_A3CliCod, P02FY2_A2153CliConveFondoDes, P02FY2_A2152CliConveFondoNre, P02FY2_A2151CliConveFondoRem, P02FY2_A2150CliConveFondoPrc, P02FY2_A2148CliConveFondoMeses, P02FY2_A2147CliConveFondoSec, P02FY2_A1575CliConveVig, P02FY2_A2154CliConveFondoRelSec, P02FY2_A1564CliPaiConve,
            P02FY2_A1565CliConvenio
            }
         }
      );
      AV52Pgmname = "Clientecct_fondoceseWWExport" ;
      /* GeneXus formulas. */
      AV52Pgmname = "Clientecct_fondoceseWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV44TFCliConveFondoRem_Sel ;
   private byte AV45TFCliConveFondoNre_Sel ;
   private byte AV46TFCliConveFondoDes_Sel ;
   private byte AV63Clientecct_fondocesewwds_9_tfcliconvefondorem_sel ;
   private byte AV64Clientecct_fondocesewwds_10_tfcliconvefondonre_sel ;
   private byte AV65Clientecct_fondocesewwds_11_tfcliconvefondodes_sel ;
   private short AV38TFCliConveFondoSec ;
   private short AV39TFCliConveFondoSec_To ;
   private short AV40TFCliConveFondoMeses ;
   private short AV41TFCliConveFondoMeses_To ;
   private short GXv_int5[] ;
   private short A2147CliConveFondoSec ;
   private short A2148CliConveFondoMeses ;
   private short AV57Clientecct_fondocesewwds_3_tfcliconvefondosec ;
   private short AV58Clientecct_fondocesewwds_4_tfcliconvefondosec_to ;
   private short AV59Clientecct_fondocesewwds_5_tfcliconvefondomeses ;
   private short AV60Clientecct_fondocesewwds_6_tfcliconvefondomeses_to ;
   private short AV18OrderedBy ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV53GXV1 ;
   private int A3CliCod ;
   private int A2154CliConveFondoRelSec ;
   private int AV48CliCod ;
   private int AV66GXV2 ;
   private int AV67GXV3 ;
   private long AV33VisibleColumnCount ;
   private java.math.BigDecimal AV42TFCliConveFondoPrc ;
   private java.math.BigDecimal AV43TFCliConveFondoPrc_To ;
   private java.math.BigDecimal A2150CliConveFondoPrc ;
   private java.math.BigDecimal AV61Clientecct_fondocesewwds_7_tfcliconvefondoprc ;
   private java.math.BigDecimal AV62Clientecct_fondocesewwds_8_tfcliconvefondoprc_to ;
   private String AV52Pgmname ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String GXt_char7 ;
   private String GXv_char8[] ;
   private java.util.Date GXt_dtime6 ;
   private java.util.Date AV36TFCliConveVig ;
   private java.util.Date AV37TFCliConveVig_To ;
   private java.util.Date A1575CliConveVig ;
   private java.util.Date AV55Clientecct_fondocesewwds_1_tfcliconvevig ;
   private java.util.Date AV56Clientecct_fondocesewwds_2_tfcliconvevig_to ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean A2151CliConveFondoRem ;
   private boolean A2152CliConveFondoNre ;
   private boolean A2153CliConveFondoDes ;
   private boolean AV19OrderedDsc ;
   private String AV28ColumnsSelectorXML ;
   private String AV29UserCustomValue ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV24CliReDTChar ;
   private String AV17MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private int[] P02FY2_A3CliCod ;
   private boolean[] P02FY2_A2153CliConveFondoDes ;
   private boolean[] P02FY2_A2152CliConveFondoNre ;
   private boolean[] P02FY2_A2151CliConveFondoRem ;
   private java.math.BigDecimal[] P02FY2_A2150CliConveFondoPrc ;
   private short[] P02FY2_A2148CliConveFondoMeses ;
   private short[] P02FY2_A2147CliConveFondoSec ;
   private java.util.Date[] P02FY2_A1575CliConveVig ;
   private int[] P02FY2_A2154CliConveFondoRelSec ;
   private short[] P02FY2_A1564CliPaiConve ;
   private String[] P02FY2_A1565CliConvenio ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV25ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV26ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector10[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV27ColumnsSelector_Column ;
}

final  class clientecct_fondocesewwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02FY2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          java.util.Date AV55Clientecct_fondocesewwds_1_tfcliconvevig ,
                                          java.util.Date AV56Clientecct_fondocesewwds_2_tfcliconvevig_to ,
                                          short AV57Clientecct_fondocesewwds_3_tfcliconvefondosec ,
                                          short AV58Clientecct_fondocesewwds_4_tfcliconvefondosec_to ,
                                          short AV59Clientecct_fondocesewwds_5_tfcliconvefondomeses ,
                                          short AV60Clientecct_fondocesewwds_6_tfcliconvefondomeses_to ,
                                          java.math.BigDecimal AV61Clientecct_fondocesewwds_7_tfcliconvefondoprc ,
                                          java.math.BigDecimal AV62Clientecct_fondocesewwds_8_tfcliconvefondoprc_to ,
                                          byte AV63Clientecct_fondocesewwds_9_tfcliconvefondorem_sel ,
                                          byte AV64Clientecct_fondocesewwds_10_tfcliconvefondonre_sel ,
                                          byte AV65Clientecct_fondocesewwds_11_tfcliconvefondodes_sel ,
                                          java.util.Date A1575CliConveVig ,
                                          short A2147CliConveFondoSec ,
                                          short A2148CliConveFondoMeses ,
                                          java.math.BigDecimal A2150CliConveFondoPrc ,
                                          boolean A2151CliConveFondoRem ,
                                          boolean A2152CliConveFondoNre ,
                                          boolean A2153CliConveFondoDes ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          int AV48CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[9];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT CliCod, CliConveFondoDes, CliConveFondoNre, CliConveFondoRem, CliConveFondoPrc, CliConveFondoMeses, CliConveFondoSec, CliConveVig, CliConveFondoRelSec, CliPaiConve," ;
      scmdbuf += " CliConvenio FROM Clientecct_fondocese" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV55Clientecct_fondocesewwds_1_tfcliconvevig)) )
      {
         addWhere(sWhereString, "(CliConveVig >= ?)");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV56Clientecct_fondocesewwds_2_tfcliconvevig_to)) )
      {
         addWhere(sWhereString, "(CliConveVig <= ?)");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( ! (0==AV57Clientecct_fondocesewwds_3_tfcliconvefondosec) )
      {
         addWhere(sWhereString, "(CliConveFondoSec >= ?)");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( ! (0==AV58Clientecct_fondocesewwds_4_tfcliconvefondosec_to) )
      {
         addWhere(sWhereString, "(CliConveFondoSec <= ?)");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( ! (0==AV59Clientecct_fondocesewwds_5_tfcliconvefondomeses) )
      {
         addWhere(sWhereString, "(CliConveFondoMeses >= ?)");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( ! (0==AV60Clientecct_fondocesewwds_6_tfcliconvefondomeses_to) )
      {
         addWhere(sWhereString, "(CliConveFondoMeses <= ?)");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV61Clientecct_fondocesewwds_7_tfcliconvefondoprc)==0) )
      {
         addWhere(sWhereString, "(CliConveFondoPrc >= ?)");
      }
      else
      {
         GXv_int11[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV62Clientecct_fondocesewwds_8_tfcliconvefondoprc_to)==0) )
      {
         addWhere(sWhereString, "(CliConveFondoPrc <= ?)");
      }
      else
      {
         GXv_int11[8] = (byte)(1) ;
      }
      if ( AV63Clientecct_fondocesewwds_9_tfcliconvefondorem_sel == 1 )
      {
         addWhere(sWhereString, "(CliConveFondoRem = TRUE)");
      }
      if ( AV63Clientecct_fondocesewwds_9_tfcliconvefondorem_sel == 2 )
      {
         addWhere(sWhereString, "(CliConveFondoRem = FALSE)");
      }
      if ( AV64Clientecct_fondocesewwds_10_tfcliconvefondonre_sel == 1 )
      {
         addWhere(sWhereString, "(CliConveFondoNre = TRUE)");
      }
      if ( AV64Clientecct_fondocesewwds_10_tfcliconvefondonre_sel == 2 )
      {
         addWhere(sWhereString, "(CliConveFondoNre = FALSE)");
      }
      if ( AV65Clientecct_fondocesewwds_11_tfcliconvefondodes_sel == 1 )
      {
         addWhere(sWhereString, "(CliConveFondoDes = TRUE)");
      }
      if ( AV65Clientecct_fondocesewwds_11_tfcliconvefondodes_sel == 2 )
      {
         addWhere(sWhereString, "(CliConveFondoDes = FALSE)");
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
         scmdbuf += " ORDER BY CliConveFondoSec" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CliConveFondoSec DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CliConveFondoMeses" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CliConveFondoMeses DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CliConveFondoPrc" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CliConveFondoPrc DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CliConveFondoRem" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CliConveFondoRem DESC" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CliConveFondoNre" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CliConveFondoNre DESC" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CliConveFondoDes" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CliConveFondoDes DESC" ;
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
                  return conditional_P02FY2(context, remoteHandle, httpContext, (java.util.Date)dynConstraints[0] , (java.util.Date)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).shortValue() , (java.math.BigDecimal)dynConstraints[6] , (java.math.BigDecimal)dynConstraints[7] , ((Number) dynConstraints[8]).byteValue() , ((Number) dynConstraints[9]).byteValue() , ((Number) dynConstraints[10]).byteValue() , (java.util.Date)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).shortValue() , (java.math.BigDecimal)dynConstraints[14] , ((Boolean) dynConstraints[15]).booleanValue() , ((Boolean) dynConstraints[16]).booleanValue() , ((Boolean) dynConstraints[17]).booleanValue() , ((Number) dynConstraints[18]).shortValue() , ((Boolean) dynConstraints[19]).booleanValue() , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02FY2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(8);
               ((int[]) buf[8])[0] = rslt.getInt(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
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
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[10]);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[11]);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[15]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[16], 4);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[17], 4);
               }
               return;
      }
   }

}

