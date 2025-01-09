package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class clientecct_vacacioneswwexport extends GXProcedure
{
   public clientecct_vacacioneswwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( clientecct_vacacioneswwexport.class ), "" );
   }

   public clientecct_vacacioneswwexport( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      clientecct_vacacioneswwexport.this.aP1 = new String[] {""};
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
      clientecct_vacacioneswwexport.this.aP0 = aP0;
      clientecct_vacacioneswwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV44CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      clientecct_vacacioneswwexport.this.GXt_int1 = GXv_int2[0] ;
      AV44CliCod = GXt_int1 ;
      GXv_char3[0] = AV47ConveCodigo ;
      new web.getconvecodsesion(remoteHandle, context).execute( GXv_char3) ;
      clientecct_vacacioneswwexport.this.AV47ConveCodigo = GXv_char3[0] ;
      GXv_int4[0] = AV46PaiCod ;
      new web.clientegetpais(remoteHandle, context).execute( AV44CliCod, GXv_int4) ;
      clientecct_vacacioneswwexport.this.AV46PaiCod = GXv_int4[0] ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClienteCCT_vacaciones", GXv_boolean6) ;
      clientecct_vacacioneswwexport.this.GXt_boolean5 = GXv_boolean6[0] ;
      AV8IsAuthorized = GXt_boolean5 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV57Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "ClienteCCT_vacacionesWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
         clientecct_vacacioneswwexport.this.AV14CellRow = GXv_int4[0] ;
         GXt_dtime9 = GXutil.resetTime( AV35TFCliConveVig );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( GXt_dtime9 );
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, false, GXv_int4, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         clientecct_vacacioneswwexport.this.AV14CellRow = GXv_int4[0] ;
         GXt_dtime9 = GXutil.resetTime( AV36TFCliConveVig_To );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setDate( GXt_dtime9 );
      }
      if ( ! ( (0==AV37TFCliConveVacDesAnt) && (0==AV38TFCliConveVacDesAnt_To) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Años de antiguedad desde", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         clientecct_vacacioneswwexport.this.AV14CellRow = GXv_int4[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV37TFCliConveVacDesAnt );
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, false, GXv_int4, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         clientecct_vacacioneswwexport.this.AV14CellRow = GXv_int4[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV38TFCliConveVacDesAnt_To );
      }
      if ( ! ( (0==AV39TFCliConveVacHasAnt) && (0==AV40TFCliConveVacHasAnt_To) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Años de antiguedad hasta", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         clientecct_vacacioneswwexport.this.AV14CellRow = GXv_int4[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV39TFCliConveVacHasAnt );
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, false, GXv_int4, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         clientecct_vacacioneswwexport.this.AV14CellRow = GXv_int4[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV40TFCliConveVacHasAnt_To );
      }
      if ( ! ( (0==AV41TFCliConveVacDias) && (0==AV42TFCliConveVacDias_To) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Días de vacaciones", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         clientecct_vacacioneswwexport.this.AV14CellRow = GXv_int4[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV41TFCliConveVacDias );
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, false, GXv_int4, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         clientecct_vacacioneswwexport.this.AV14CellRow = GXv_int4[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV42TFCliConveVacDias_To );
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("ClienteCCT_vacacionesWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("ClienteCCT_vacacionesWWColumnsSelector") ;
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
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV58GXV1 = 1 ;
      while ( AV58GXV1 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV58GXV1));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV58GXV1 = (int)(AV58GXV1+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV60Clientecct_vacacioneswwds_1_tfcliconvevig = AV35TFCliConveVig ;
      AV61Clientecct_vacacioneswwds_2_tfcliconvevig_to = AV36TFCliConveVig_To ;
      AV62Clientecct_vacacioneswwds_3_tfcliconvevacdesant = AV37TFCliConveVacDesAnt ;
      AV63Clientecct_vacacioneswwds_4_tfcliconvevacdesant_to = AV38TFCliConveVacDesAnt_To ;
      AV64Clientecct_vacacioneswwds_5_tfcliconvevachasant = AV39TFCliConveVacHasAnt ;
      AV65Clientecct_vacacioneswwds_6_tfcliconvevachasant_to = AV40TFCliConveVacHasAnt_To ;
      AV66Clientecct_vacacioneswwds_7_tfcliconvevacdias = AV41TFCliConveVacDias ;
      AV67Clientecct_vacacioneswwds_8_tfcliconvevacdias_to = AV42TFCliConveVacDias_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV60Clientecct_vacacioneswwds_1_tfcliconvevig ,
                                           AV61Clientecct_vacacioneswwds_2_tfcliconvevig_to ,
                                           Byte.valueOf(AV62Clientecct_vacacioneswwds_3_tfcliconvevacdesant) ,
                                           Byte.valueOf(AV63Clientecct_vacacioneswwds_4_tfcliconvevacdesant_to) ,
                                           Byte.valueOf(AV64Clientecct_vacacioneswwds_5_tfcliconvevachasant) ,
                                           Byte.valueOf(AV65Clientecct_vacacioneswwds_6_tfcliconvevachasant_to) ,
                                           Byte.valueOf(AV66Clientecct_vacacioneswwds_7_tfcliconvevacdias) ,
                                           Byte.valueOf(AV67Clientecct_vacacioneswwds_8_tfcliconvevacdias_to) ,
                                           A1575CliConveVig ,
                                           Byte.valueOf(A1761CliConveVacDesAnt) ,
                                           Byte.valueOf(A1762CliConveVacHasAnt) ,
                                           Byte.valueOf(A1763CliConveVacDias) ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Integer.valueOf(AV44CliCod) ,
                                           Short.valueOf(AV46PaiCod) ,
                                           AV47ConveCodigo ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1564CliPaiConve) ,
                                           A1565CliConvenio } ,
                                           new int[]{
                                           TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.DATE, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING
                                           }
      });
      /* Using cursor P01LM2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV44CliCod), Short.valueOf(AV46PaiCod), AV47ConveCodigo, AV60Clientecct_vacacioneswwds_1_tfcliconvevig, AV61Clientecct_vacacioneswwds_2_tfcliconvevig_to, Byte.valueOf(AV62Clientecct_vacacioneswwds_3_tfcliconvevacdesant), Byte.valueOf(AV63Clientecct_vacacioneswwds_4_tfcliconvevacdesant_to), Byte.valueOf(AV64Clientecct_vacacioneswwds_5_tfcliconvevachasant), Byte.valueOf(AV65Clientecct_vacacioneswwds_6_tfcliconvevachasant_to), Byte.valueOf(AV66Clientecct_vacacioneswwds_7_tfcliconvevacdias), Byte.valueOf(AV67Clientecct_vacacioneswwds_8_tfcliconvevacdias_to)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1565CliConvenio = P01LM2_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01LM2_A1564CliPaiConve[0] ;
         A3CliCod = P01LM2_A3CliCod[0] ;
         A1763CliConveVacDias = P01LM2_A1763CliConveVacDias[0] ;
         A1762CliConveVacHasAnt = P01LM2_A1762CliConveVacHasAnt[0] ;
         A1761CliConveVacDesAnt = P01LM2_A1761CliConveVacDesAnt[0] ;
         A1575CliConveVig = P01LM2_A1575CliConveVig[0] ;
         A1902ConveVacRelSec = P01LM2_A1902ConveVacRelSec[0] ;
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
         AV68GXV2 = 1 ;
         while ( AV68GXV2 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV68GXV2));
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
                  clientecct_vacacioneswwexport.this.GXt_char10 = GXv_char3[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char10 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliConveVig") == 0 )
               {
                  GXt_dtime9 = GXutil.resetTime( A1575CliConveVig );
                  AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setDate( GXt_dtime9 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliConveVacDesAnt") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1761CliConveVacDesAnt );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliConveVacHasAnt") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1762CliConveVacHasAnt );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliConveVacDias") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1763CliConveVacDias );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "&CliReDTChar") == 0 )
               {
                  GXt_char10 = AV53CliReDTChar ;
                  GXv_char3[0] = GXt_char10 ;
                  new web.getreleasedtchar(remoteHandle, context).execute( A3CliCod, A1902ConveVacRelSec, GXv_char3) ;
                  clientecct_vacacioneswwexport.this.GXt_char10 = GXv_char3[0] ;
                  AV53CliReDTChar = GXt_char10 ;
                  GXt_char10 = "" ;
                  GXv_char3[0] = GXt_char10 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV53CliReDTChar, GXv_char3) ;
                  clientecct_vacacioneswwexport.this.GXt_char10 = GXv_char3[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char10 );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV68GXV2 = (int)(AV68GXV2+1) ;
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
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, "CliConveVacDesAnt", "", "Años de antiguedad desde", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      GXv_SdtWWPColumnsSelector11[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, "CliConveVacHasAnt", "", "Años de antiguedad hasta", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      GXv_SdtWWPColumnsSelector11[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, "CliConveVacDias", "", "Días de vacaciones", true, "") ;
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
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "ClienteCCT_vacacionesWWColumnsSelector", GXv_char3) ;
      clientecct_vacacioneswwexport.this.GXt_char10 = GXv_char3[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("ClienteCCT_vacacionesWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ClienteCCT_vacacionesWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("ClienteCCT_vacacionesWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV69GXV3 = 1 ;
      while ( AV69GXV3 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV69GXV3));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICONVEVIG") == 0 )
         {
            AV35TFCliConveVig = localUtil.ctod( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV36TFCliConveVig_To = localUtil.ctod( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICONVEVACDESANT") == 0 )
         {
            AV37TFCliConveVacDesAnt = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV38TFCliConveVacDesAnt_To = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICONVEVACHASANT") == 0 )
         {
            AV39TFCliConveVacHasAnt = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV40TFCliConveVacHasAnt_To = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICONVEVACDIAS") == 0 )
         {
            AV41TFCliConveVacDias = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV42TFCliConveVacDias_To = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV54MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV69GXV3 = (int)(AV69GXV3+1) ;
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
      this.aP0[0] = clientecct_vacacioneswwexport.this.AV12Filename;
      this.aP1[0] = clientecct_vacacioneswwexport.this.AV13ErrorMessage;
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
      AV47ConveCodigo = "" ;
      GXv_boolean6 = new boolean[1] ;
      AV57Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV35TFCliConveVig = GXutil.nullDate() ;
      AV36TFCliConveVig_To = GXutil.nullDate() ;
      GXv_exceldoc8 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int4 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A1565CliConvenio = "" ;
      A1575CliConveVig = GXutil.nullDate() ;
      AV60Clientecct_vacacioneswwds_1_tfcliconvevig = GXutil.nullDate() ;
      AV61Clientecct_vacacioneswwds_2_tfcliconvevig_to = GXutil.nullDate() ;
      scmdbuf = "" ;
      P01LM2_A1565CliConvenio = new String[] {""} ;
      P01LM2_A1564CliPaiConve = new short[1] ;
      P01LM2_A3CliCod = new int[1] ;
      P01LM2_A1763CliConveVacDias = new byte[1] ;
      P01LM2_A1762CliConveVacHasAnt = new byte[1] ;
      P01LM2_A1761CliConveVacDesAnt = new byte[1] ;
      P01LM2_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      P01LM2_A1902ConveVacRelSec = new int[1] ;
      GXt_dtime9 = GXutil.resetTime( GXutil.nullDate() );
      AV53CliReDTChar = "" ;
      AV28UserCustomValue = "" ;
      GXt_char10 = "" ;
      GXv_char3 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector11 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector12 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV54MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.clientecct_vacacioneswwexport__default(),
         new Object[] {
             new Object[] {
            P01LM2_A1565CliConvenio, P01LM2_A1564CliPaiConve, P01LM2_A3CliCod, P01LM2_A1763CliConveVacDias, P01LM2_A1762CliConveVacHasAnt, P01LM2_A1761CliConveVacDesAnt, P01LM2_A1575CliConveVig, P01LM2_A1902ConveVacRelSec
            }
         }
      );
      AV57Pgmname = "ClienteCCT_vacacionesWWExport" ;
      /* GeneXus formulas. */
      AV57Pgmname = "ClienteCCT_vacacionesWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV37TFCliConveVacDesAnt ;
   private byte AV38TFCliConveVacDesAnt_To ;
   private byte AV39TFCliConveVacHasAnt ;
   private byte AV40TFCliConveVacHasAnt_To ;
   private byte AV41TFCliConveVacDias ;
   private byte AV42TFCliConveVacDias_To ;
   private byte A1761CliConveVacDesAnt ;
   private byte A1762CliConveVacHasAnt ;
   private byte A1763CliConveVacDias ;
   private byte AV62Clientecct_vacacioneswwds_3_tfcliconvevacdesant ;
   private byte AV63Clientecct_vacacioneswwds_4_tfcliconvevacdesant_to ;
   private byte AV64Clientecct_vacacioneswwds_5_tfcliconvevachasant ;
   private byte AV65Clientecct_vacacioneswwds_6_tfcliconvevachasant_to ;
   private byte AV66Clientecct_vacacioneswwds_7_tfcliconvevacdias ;
   private byte AV67Clientecct_vacacioneswwds_8_tfcliconvevacdias_to ;
   private short AV46PaiCod ;
   private short GXv_int4[] ;
   private short A1564CliPaiConve ;
   private short AV18OrderedBy ;
   private short Gx_err ;
   private int AV44CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV58GXV1 ;
   private int A3CliCod ;
   private int A1902ConveVacRelSec ;
   private int AV68GXV2 ;
   private int AV69GXV3 ;
   private long AV32VisibleColumnCount ;
   private String AV47ConveCodigo ;
   private String AV57Pgmname ;
   private String A1565CliConvenio ;
   private String scmdbuf ;
   private String GXt_char10 ;
   private String GXv_char3[] ;
   private java.util.Date GXt_dtime9 ;
   private java.util.Date AV35TFCliConveVig ;
   private java.util.Date AV36TFCliConveVig_To ;
   private java.util.Date A1575CliConveVig ;
   private java.util.Date AV60Clientecct_vacacioneswwds_1_tfcliconvevig ;
   private java.util.Date AV61Clientecct_vacacioneswwds_2_tfcliconvevig_to ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean AV19OrderedDsc ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV53CliReDTChar ;
   private String AV54MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] P01LM2_A1565CliConvenio ;
   private short[] P01LM2_A1564CliPaiConve ;
   private int[] P01LM2_A3CliCod ;
   private byte[] P01LM2_A1763CliConveVacDias ;
   private byte[] P01LM2_A1762CliConveVacHasAnt ;
   private byte[] P01LM2_A1761CliConveVacDesAnt ;
   private java.util.Date[] P01LM2_A1575CliConveVig ;
   private int[] P01LM2_A1902ConveVacRelSec ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc8[] ;
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

final  class clientecct_vacacioneswwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01LM2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          java.util.Date AV60Clientecct_vacacioneswwds_1_tfcliconvevig ,
                                          java.util.Date AV61Clientecct_vacacioneswwds_2_tfcliconvevig_to ,
                                          byte AV62Clientecct_vacacioneswwds_3_tfcliconvevacdesant ,
                                          byte AV63Clientecct_vacacioneswwds_4_tfcliconvevacdesant_to ,
                                          byte AV64Clientecct_vacacioneswwds_5_tfcliconvevachasant ,
                                          byte AV65Clientecct_vacacioneswwds_6_tfcliconvevachasant_to ,
                                          byte AV66Clientecct_vacacioneswwds_7_tfcliconvevacdias ,
                                          byte AV67Clientecct_vacacioneswwds_8_tfcliconvevacdias_to ,
                                          java.util.Date A1575CliConveVig ,
                                          byte A1761CliConveVacDesAnt ,
                                          byte A1762CliConveVacHasAnt ,
                                          byte A1763CliConveVacDias ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          int AV44CliCod ,
                                          short AV46PaiCod ,
                                          String AV47ConveCodigo ,
                                          int A3CliCod ,
                                          short A1564CliPaiConve ,
                                          String A1565CliConvenio )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int13 = new byte[11];
      Object[] GXv_Object14 = new Object[2];
      scmdbuf = "SELECT CliConvenio, CliPaiConve, CliCod, CliConveVacDias, CliConveVacHasAnt, CliConveVacDesAnt, CliConveVig, ConveVacRelSec FROM ClienteConvenio_ParticularidadesVacacion" ;
      addWhere(sWhereString, "(CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?))");
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV60Clientecct_vacacioneswwds_1_tfcliconvevig)) )
      {
         addWhere(sWhereString, "(CliConveVig >= ?)");
      }
      else
      {
         GXv_int13[3] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV61Clientecct_vacacioneswwds_2_tfcliconvevig_to)) )
      {
         addWhere(sWhereString, "(CliConveVig <= ?)");
      }
      else
      {
         GXv_int13[4] = (byte)(1) ;
      }
      if ( ! (0==AV62Clientecct_vacacioneswwds_3_tfcliconvevacdesant) )
      {
         addWhere(sWhereString, "(CliConveVacDesAnt >= ?)");
      }
      else
      {
         GXv_int13[5] = (byte)(1) ;
      }
      if ( ! (0==AV63Clientecct_vacacioneswwds_4_tfcliconvevacdesant_to) )
      {
         addWhere(sWhereString, "(CliConveVacDesAnt <= ?)");
      }
      else
      {
         GXv_int13[6] = (byte)(1) ;
      }
      if ( ! (0==AV64Clientecct_vacacioneswwds_5_tfcliconvevachasant) )
      {
         addWhere(sWhereString, "(CliConveVacHasAnt >= ?)");
      }
      else
      {
         GXv_int13[7] = (byte)(1) ;
      }
      if ( ! (0==AV65Clientecct_vacacioneswwds_6_tfcliconvevachasant_to) )
      {
         addWhere(sWhereString, "(CliConveVacHasAnt <= ?)");
      }
      else
      {
         GXv_int13[8] = (byte)(1) ;
      }
      if ( ! (0==AV66Clientecct_vacacioneswwds_7_tfcliconvevacdias) )
      {
         addWhere(sWhereString, "(CliConveVacDias >= ?)");
      }
      else
      {
         GXv_int13[9] = (byte)(1) ;
      }
      if ( ! (0==AV67Clientecct_vacacioneswwds_8_tfcliconvevacdias_to) )
      {
         addWhere(sWhereString, "(CliConveVacDias <= ?)");
      }
      else
      {
         GXv_int13[10] = (byte)(1) ;
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
         scmdbuf += " ORDER BY CliConveVacDesAnt" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CliConveVacDesAnt DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CliConveVacHasAnt" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CliConveVacHasAnt DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CliConveVacDias" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CliConveVacDias DESC" ;
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
                  return conditional_P01LM2(context, remoteHandle, httpContext, (java.util.Date)dynConstraints[0] , (java.util.Date)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , ((Number) dynConstraints[3]).byteValue() , ((Number) dynConstraints[4]).byteValue() , ((Number) dynConstraints[5]).byteValue() , ((Number) dynConstraints[6]).byteValue() , ((Number) dynConstraints[7]).byteValue() , (java.util.Date)dynConstraints[8] , ((Number) dynConstraints[9]).byteValue() , ((Number) dynConstraints[10]).byteValue() , ((Number) dynConstraints[11]).byteValue() , ((Number) dynConstraints[12]).shortValue() , ((Boolean) dynConstraints[13]).booleanValue() , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).shortValue() , (String)dynConstraints[16] , ((Number) dynConstraints[17]).intValue() , ((Number) dynConstraints[18]).shortValue() , (String)dynConstraints[19] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01LM2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
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
                  stmt.setInt(sIdx, ((Number) parms[11]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[14]);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[15]);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[16]).byteValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[17]).byteValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[18]).byteValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[19]).byteValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[20]).byteValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[21]).byteValue());
               }
               return;
      }
   }

}

