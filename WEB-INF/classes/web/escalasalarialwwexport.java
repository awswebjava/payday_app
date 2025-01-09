package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class escalasalarialwwexport extends GXProcedure
{
   public escalasalarialwwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( escalasalarialwwexport.class ), "" );
   }

   public escalasalarialwwexport( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      escalasalarialwwexport.this.aP1 = new String[] {""};
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
      escalasalarialwwexport.this.aP0 = aP0;
      escalasalarialwwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV53CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      escalasalarialwwexport.this.GXt_int1 = GXv_int2[0] ;
      AV53CliCod = GXt_int1 ;
      GXv_char3[0] = AV56ConveCodigo ;
      new web.getconvecodsesion(remoteHandle, context).execute( GXv_char3) ;
      escalasalarialwwexport.this.AV56ConveCodigo = GXv_char3[0] ;
      GXv_int4[0] = AV55PaiCod ;
      new web.clientegetpais(remoteHandle, context).execute( AV53CliCod, GXv_int4) ;
      escalasalarialwwexport.this.AV55PaiCod = GXv_int4[0] ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEscalaSalarial", GXv_boolean6) ;
      escalasalarialwwexport.this.GXt_boolean5 = GXv_boolean6[0] ;
      AV8IsAuthorized = GXt_boolean5 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV72Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "EscalaSalarialWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV38TFCatDescrip_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Categoría", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         escalasalarialwwexport.this.AV14CellRow = GXv_int4[0] ;
         AV52i = 1 ;
         AV73GXV1 = 1 ;
         while ( AV73GXV1 <= AV38TFCatDescrip_Sels.size() )
         {
            AV39TFCatDescrip_Sel = (String)AV38TFCatDescrip_Sels.elementAt(-1+AV73GXV1) ;
            if ( AV52i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char9 = "" ;
            GXv_char3[0] = GXt_char9 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV39TFCatDescrip_Sel, GXv_char3) ;
            escalasalarialwwexport.this.GXt_char9 = GXv_char3[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char9 );
            AV52i = (long)(AV52i+1) ;
            AV73GXV1 = (int)(AV73GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV37TFCatDescrip)==0) ) )
         {
            GXv_exceldoc8[0] = AV11ExcelDocument ;
            GXv_int4[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Categoría", "")) ;
            AV11ExcelDocument = GXv_exceldoc8[0] ;
            escalasalarialwwexport.this.AV14CellRow = GXv_int4[0] ;
            GXt_char9 = "" ;
            GXv_char3[0] = GXt_char9 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV37TFCatDescrip, GXv_char3) ;
            escalasalarialwwexport.this.GXt_char9 = GXv_char3[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char9 );
         }
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV41TFCatVigencia)) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV57TFCatVigencia_To)) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Vigencia desde", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         escalasalarialwwexport.this.AV14CellRow = GXv_int4[0] ;
         GXt_dtime10 = GXutil.resetTime( AV41TFCatVigencia );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( GXt_dtime10 );
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, false, GXv_int4, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         escalasalarialwwexport.this.AV14CellRow = GXv_int4[0] ;
         GXt_dtime10 = GXutil.resetTime( AV57TFCatVigencia_To );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setDate( GXt_dtime10 );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV58TFEscBasico)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV59TFEscBasico_To)==0) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Básico", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         escalasalarialwwexport.this.AV14CellRow = GXv_int4[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV58TFEscBasico)) );
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, false, GXv_int4, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         escalasalarialwwexport.this.AV14CellRow = GXv_int4[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV59TFEscBasico_To)) );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV60TFEscAdicional)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV61TFEscAdicional_To)==0) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Adicional", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         escalasalarialwwexport.this.AV14CellRow = GXv_int4[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV60TFEscAdicional)) );
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, false, GXv_int4, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         escalasalarialwwexport.this.AV14CellRow = GXv_int4[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV61TFEscAdicional_To)) );
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV33VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV21Session.getValue("EscalaSalarialWWColumnsSelector"), "") != 0 )
      {
         AV28ColumnsSelectorXML = AV21Session.getValue("EscalaSalarialWWColumnsSelector") ;
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
      AV27ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Columnname( "CliCod" );
      AV27ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Displayname( httpContext.getMessage( "Cod", "") );
      AV27ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Order( (short)(AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size()+1) );
      AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().add(AV27ColumnsSelector_Column, 0);
      AV27ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      AV27ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Isvisible( true );
      AV27ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Columnname( "CliPaiConve" );
      AV27ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Displayname( httpContext.getMessage( "Pai Conve", "") );
      AV27ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Order( (short)(AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size()+1) );
      AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().add(AV27ColumnsSelector_Column, 0);
      AV27ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      AV27ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Isvisible( true );
      AV27ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Columnname( "CliConvenio" );
      AV27ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Displayname( httpContext.getMessage( "Convenio", "") );
      AV27ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Order( (short)(AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size()+1) );
      AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().add(AV27ColumnsSelector_Column, 0);
      AV27ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      AV27ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Isvisible( true );
      AV27ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Columnname( "CatCodigo" );
      AV27ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Displayname( httpContext.getMessage( "Categoria", "") );
      AV27ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Order( (short)(AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size()+1) );
      AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().add(AV27ColumnsSelector_Column, 0);
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV74GXV2 = 1 ;
      while ( AV74GXV2 <= AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV27ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV74GXV2));
         if ( AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setColor( 11 );
            AV33VisibleColumnCount = (long)(AV33VisibleColumnCount+1) ;
         }
         AV74GXV2 = (int)(AV74GXV2+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV76Escalasalarialwwds_1_tfcatdescrip = AV37TFCatDescrip ;
      AV77Escalasalarialwwds_2_tfcatdescrip_sels = AV38TFCatDescrip_Sels ;
      AV78Escalasalarialwwds_3_tfcatvigencia = AV41TFCatVigencia ;
      AV79Escalasalarialwwds_4_tfcatvigencia_to = AV57TFCatVigencia_To ;
      AV80Escalasalarialwwds_5_tfescbasico = AV58TFEscBasico ;
      AV81Escalasalarialwwds_6_tfescbasico_to = AV59TFEscBasico_To ;
      AV82Escalasalarialwwds_7_tfescadicional = AV60TFEscAdicional ;
      AV83Escalasalarialwwds_8_tfescadicional_to = AV61TFEscAdicional_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A123CatDescrip ,
                                           AV77Escalasalarialwwds_2_tfcatdescrip_sels ,
                                           Integer.valueOf(AV77Escalasalarialwwds_2_tfcatdescrip_sels.size()) ,
                                           AV76Escalasalarialwwds_1_tfcatdescrip ,
                                           AV78Escalasalarialwwds_3_tfcatvigencia ,
                                           AV79Escalasalarialwwds_4_tfcatvigencia_to ,
                                           AV80Escalasalarialwwds_5_tfescbasico ,
                                           AV81Escalasalarialwwds_6_tfescbasico_to ,
                                           AV82Escalasalarialwwds_7_tfescadicional ,
                                           AV83Escalasalarialwwds_8_tfescadicional_to ,
                                           A907CatVigencia ,
                                           A1892EscBasico ,
                                           A1893EscAdicional ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Integer.valueOf(AV53CliCod) ,
                                           Short.valueOf(AV55PaiCod) ,
                                           AV56ConveCodigo ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1564CliPaiConve) ,
                                           A1565CliConvenio } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DATE,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING
                                           }
      });
      lV76Escalasalarialwwds_1_tfcatdescrip = GXutil.concat( GXutil.rtrim( AV76Escalasalarialwwds_1_tfcatdescrip), "%", "") ;
      /* Using cursor P01LK2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV53CliCod), Short.valueOf(AV55PaiCod), AV56ConveCodigo, lV76Escalasalarialwwds_1_tfcatdescrip, AV78Escalasalarialwwds_3_tfcatvigencia, AV79Escalasalarialwwds_4_tfcatvigencia_to, AV80Escalasalarialwwds_5_tfescbasico, AV81Escalasalarialwwds_6_tfescbasico_to, AV82Escalasalarialwwds_7_tfescadicional, AV83Escalasalarialwwds_8_tfescadicional_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1565CliConvenio = P01LK2_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01LK2_A1564CliPaiConve[0] ;
         A3CliCod = P01LK2_A3CliCod[0] ;
         A1893EscAdicional = P01LK2_A1893EscAdicional[0] ;
         A1892EscBasico = P01LK2_A1892EscBasico[0] ;
         A907CatVigencia = P01LK2_A907CatVigencia[0] ;
         A123CatDescrip = P01LK2_A123CatDescrip[0] ;
         A1891CatSalRelSec = P01LK2_A1891CatSalRelSec[0] ;
         n1891CatSalRelSec = P01LK2_n1891CatSalRelSec[0] ;
         A8CatCodigo = P01LK2_A8CatCodigo[0] ;
         A123CatDescrip = P01LK2_A123CatDescrip[0] ;
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
         AV84GXV3 = 1 ;
         while ( AV84GXV3 <= AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV27ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV84GXV3));
            if ( AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliCod") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setNumber( A3CliCod );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliPaiConve") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setNumber( A1564CliPaiConve );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliConvenio") == 0 )
               {
                  GXt_char9 = "" ;
                  GXv_char3[0] = GXt_char9 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1565CliConvenio, GXv_char3) ;
                  escalasalarialwwexport.this.GXt_char9 = GXv_char3[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char9 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CatCodigo") == 0 )
               {
                  GXt_char9 = "" ;
                  GXv_char3[0] = GXt_char9 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A8CatCodigo, GXv_char3) ;
                  escalasalarialwwexport.this.GXt_char9 = GXv_char3[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char9 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CatDescrip") == 0 )
               {
                  GXt_char9 = "" ;
                  GXv_char3[0] = GXt_char9 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A123CatDescrip, GXv_char3) ;
                  escalasalarialwwexport.this.GXt_char9 = GXv_char3[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char9 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CatVigencia") == 0 )
               {
                  GXt_dtime10 = GXutil.resetTime( A907CatVigencia );
                  AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setDate( GXt_dtime10 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EscBasico") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1892EscBasico)) );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EscAdicional") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1893EscAdicional)) );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "&CliReDTChar") == 0 )
               {
                  GXt_char9 = AV68CliReDTChar ;
                  GXv_char3[0] = GXt_char9 ;
                  new web.getreleasedtchar(remoteHandle, context).execute( A3CliCod, A1891CatSalRelSec, GXv_char3) ;
                  escalasalarialwwexport.this.GXt_char9 = GXv_char3[0] ;
                  AV68CliReDTChar = GXt_char9 ;
                  GXt_char9 = "" ;
                  GXv_char3[0] = GXt_char9 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV68CliReDTChar, GXv_char3) ;
                  escalasalarialwwexport.this.GXt_char9 = GXv_char3[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char9 );
               }
               AV33VisibleColumnCount = (long)(AV33VisibleColumnCount+1) ;
            }
            AV84GXV3 = (int)(AV84GXV3+1) ;
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
      GXv_SdtWWPColumnsSelector11[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, "CatDescrip", "", "Categoría", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      GXv_SdtWWPColumnsSelector11[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, "CatVigencia", "", "Vigencia desde", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      GXv_SdtWWPColumnsSelector11[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, "EscBasico", "", "Básico", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      GXv_SdtWWPColumnsSelector11[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, "EscAdicional", "", "Adicional", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      GXv_SdtWWPColumnsSelector11[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, "&VerSVG", "", "", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      GXv_SdtWWPColumnsSelector11[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, "&ModificarSVG", "", "", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      GXv_SdtWWPColumnsSelector11[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, "&EliminarSVG", "", "", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      GXv_SdtWWPColumnsSelector11[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, "&CliReDTChar", "", "Fecha/hora de liberación", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      GXt_char9 = AV29UserCustomValue ;
      GXv_char3[0] = GXt_char9 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "EscalaSalarialWWColumnsSelector", GXv_char3) ;
      escalasalarialwwexport.this.GXt_char9 = GXv_char3[0] ;
      AV29UserCustomValue = GXt_char9 ;
      if ( ! ( (GXutil.strcmp("", AV29UserCustomValue)==0) ) )
      {
         AV26ColumnsSelectorAux.fromxml(AV29UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector11[0] = AV26ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector12[0] = AV25ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, GXv_SdtWWPColumnsSelector12) ;
         AV26ColumnsSelectorAux = GXv_SdtWWPColumnsSelector11[0] ;
         AV25ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV21Session.getValue("EscalaSalarialWWGridState"), "") == 0 )
      {
         AV23GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "EscalaSalarialWWGridState"), null, null);
      }
      else
      {
         AV23GridState.fromxml(AV21Session.getValue("EscalaSalarialWWGridState"), null, null);
      }
      AV18OrderedBy = AV23GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV23GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV85GXV4 = 1 ;
      while ( AV85GXV4 <= AV23GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV24GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV23GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV85GXV4));
         if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCATDESCRIP") == 0 )
         {
            AV37TFCatDescrip = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCATDESCRIP_SEL") == 0 )
         {
            AV36TFCatDescrip_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV38TFCatDescrip_Sels.fromJSonString(AV36TFCatDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCATVIGENCIA") == 0 )
         {
            AV41TFCatVigencia = localUtil.ctod( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV57TFCatVigencia_To = localUtil.ctod( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESCBASICO") == 0 )
         {
            AV58TFEscBasico = CommonUtil.decimalVal( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV59TFEscBasico_To = CommonUtil.decimalVal( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESCADICIONAL") == 0 )
         {
            AV60TFEscAdicional = CommonUtil.decimalVal( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV61TFEscAdicional_To = CommonUtil.decimalVal( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV69MenuOpcCod = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV85GXV4 = (int)(AV85GXV4+1) ;
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
      this.aP0[0] = escalasalarialwwexport.this.AV12Filename;
      this.aP1[0] = escalasalarialwwexport.this.AV13ErrorMessage;
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
      AV56ConveCodigo = "" ;
      GXv_boolean6 = new boolean[1] ;
      AV72Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV38TFCatDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV39TFCatDescrip_Sel = "" ;
      AV37TFCatDescrip = "" ;
      AV41TFCatVigencia = GXutil.nullDate() ;
      AV57TFCatVigencia_To = GXutil.nullDate() ;
      AV58TFEscBasico = DecimalUtil.ZERO ;
      AV59TFEscBasico_To = DecimalUtil.ZERO ;
      AV60TFEscAdicional = DecimalUtil.ZERO ;
      AV61TFEscAdicional_To = DecimalUtil.ZERO ;
      GXv_exceldoc8 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int4 = new short[1] ;
      AV21Session = httpContext.getWebSession();
      AV28ColumnsSelectorXML = "" ;
      AV25ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV27ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A1565CliConvenio = "" ;
      A8CatCodigo = "" ;
      A123CatDescrip = "" ;
      A907CatVigencia = GXutil.nullDate() ;
      A1892EscBasico = DecimalUtil.ZERO ;
      A1893EscAdicional = DecimalUtil.ZERO ;
      AV76Escalasalarialwwds_1_tfcatdescrip = "" ;
      AV77Escalasalarialwwds_2_tfcatdescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV78Escalasalarialwwds_3_tfcatvigencia = GXutil.nullDate() ;
      AV79Escalasalarialwwds_4_tfcatvigencia_to = GXutil.nullDate() ;
      AV80Escalasalarialwwds_5_tfescbasico = DecimalUtil.ZERO ;
      AV81Escalasalarialwwds_6_tfescbasico_to = DecimalUtil.ZERO ;
      AV82Escalasalarialwwds_7_tfescadicional = DecimalUtil.ZERO ;
      AV83Escalasalarialwwds_8_tfescadicional_to = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      lV76Escalasalarialwwds_1_tfcatdescrip = "" ;
      P01LK2_A1565CliConvenio = new String[] {""} ;
      P01LK2_A1564CliPaiConve = new short[1] ;
      P01LK2_A3CliCod = new int[1] ;
      P01LK2_A1893EscAdicional = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01LK2_A1892EscBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01LK2_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      P01LK2_A123CatDescrip = new String[] {""} ;
      P01LK2_A1891CatSalRelSec = new int[1] ;
      P01LK2_n1891CatSalRelSec = new boolean[] {false} ;
      P01LK2_A8CatCodigo = new String[] {""} ;
      GXt_dtime10 = GXutil.resetTime( GXutil.nullDate() );
      AV68CliReDTChar = "" ;
      AV29UserCustomValue = "" ;
      GXt_char9 = "" ;
      GXv_char3 = new String[1] ;
      AV26ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector11 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector12 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV23GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV24GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV36TFCatDescrip_SelsJson = "" ;
      AV69MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.escalasalarialwwexport__default(),
         new Object[] {
             new Object[] {
            P01LK2_A1565CliConvenio, P01LK2_A1564CliPaiConve, P01LK2_A3CliCod, P01LK2_A1893EscAdicional, P01LK2_A1892EscBasico, P01LK2_A907CatVigencia, P01LK2_A123CatDescrip, P01LK2_A1891CatSalRelSec, P01LK2_n1891CatSalRelSec, P01LK2_A8CatCodigo
            }
         }
      );
      AV72Pgmname = "EscalaSalarialWWExport" ;
      /* GeneXus formulas. */
      AV72Pgmname = "EscalaSalarialWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short AV55PaiCod ;
   private short GXv_int4[] ;
   private short A1564CliPaiConve ;
   private short AV18OrderedBy ;
   private short Gx_err ;
   private int AV53CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV73GXV1 ;
   private int AV74GXV2 ;
   private int A3CliCod ;
   private int A1891CatSalRelSec ;
   private int AV77Escalasalarialwwds_2_tfcatdescrip_sels_size ;
   private int AV84GXV3 ;
   private int AV85GXV4 ;
   private long AV52i ;
   private long AV33VisibleColumnCount ;
   private java.math.BigDecimal AV58TFEscBasico ;
   private java.math.BigDecimal AV59TFEscBasico_To ;
   private java.math.BigDecimal AV60TFEscAdicional ;
   private java.math.BigDecimal AV61TFEscAdicional_To ;
   private java.math.BigDecimal A1892EscBasico ;
   private java.math.BigDecimal A1893EscAdicional ;
   private java.math.BigDecimal AV80Escalasalarialwwds_5_tfescbasico ;
   private java.math.BigDecimal AV81Escalasalarialwwds_6_tfescbasico_to ;
   private java.math.BigDecimal AV82Escalasalarialwwds_7_tfescadicional ;
   private java.math.BigDecimal AV83Escalasalarialwwds_8_tfescadicional_to ;
   private String AV56ConveCodigo ;
   private String AV72Pgmname ;
   private String A1565CliConvenio ;
   private String A8CatCodigo ;
   private String scmdbuf ;
   private String GXt_char9 ;
   private String GXv_char3[] ;
   private java.util.Date GXt_dtime10 ;
   private java.util.Date AV41TFCatVigencia ;
   private java.util.Date AV57TFCatVigencia_To ;
   private java.util.Date A907CatVigencia ;
   private java.util.Date AV78Escalasalarialwwds_3_tfcatvigencia ;
   private java.util.Date AV79Escalasalarialwwds_4_tfcatvigencia_to ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean AV19OrderedDsc ;
   private boolean n1891CatSalRelSec ;
   private String AV28ColumnsSelectorXML ;
   private String AV29UserCustomValue ;
   private String AV36TFCatDescrip_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV39TFCatDescrip_Sel ;
   private String AV37TFCatDescrip ;
   private String A123CatDescrip ;
   private String AV76Escalasalarialwwds_1_tfcatdescrip ;
   private String lV76Escalasalarialwwds_1_tfcatdescrip ;
   private String AV68CliReDTChar ;
   private String AV69MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV21Session ;
   private GXSimpleCollection<String> AV38TFCatDescrip_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] P01LK2_A1565CliConvenio ;
   private short[] P01LK2_A1564CliPaiConve ;
   private int[] P01LK2_A3CliCod ;
   private java.math.BigDecimal[] P01LK2_A1893EscAdicional ;
   private java.math.BigDecimal[] P01LK2_A1892EscBasico ;
   private java.util.Date[] P01LK2_A907CatVigencia ;
   private String[] P01LK2_A123CatDescrip ;
   private int[] P01LK2_A1891CatSalRelSec ;
   private boolean[] P01LK2_n1891CatSalRelSec ;
   private String[] P01LK2_A8CatCodigo ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc8[] ;
   private GXSimpleCollection<String> AV77Escalasalarialwwds_2_tfcatdescrip_sels ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV25ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV26ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector11[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector12[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV27ColumnsSelector_Column ;
   private web.wwpbaseobjects.SdtWWPGridState AV23GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV24GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
}

final  class escalasalarialwwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01LK2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A123CatDescrip ,
                                          GXSimpleCollection<String> AV77Escalasalarialwwds_2_tfcatdescrip_sels ,
                                          int AV77Escalasalarialwwds_2_tfcatdescrip_sels_size ,
                                          String AV76Escalasalarialwwds_1_tfcatdescrip ,
                                          java.util.Date AV78Escalasalarialwwds_3_tfcatvigencia ,
                                          java.util.Date AV79Escalasalarialwwds_4_tfcatvigencia_to ,
                                          java.math.BigDecimal AV80Escalasalarialwwds_5_tfescbasico ,
                                          java.math.BigDecimal AV81Escalasalarialwwds_6_tfescbasico_to ,
                                          java.math.BigDecimal AV82Escalasalarialwwds_7_tfescadicional ,
                                          java.math.BigDecimal AV83Escalasalarialwwds_8_tfescadicional_to ,
                                          java.util.Date A907CatVigencia ,
                                          java.math.BigDecimal A1892EscBasico ,
                                          java.math.BigDecimal A1893EscAdicional ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          int AV53CliCod ,
                                          short AV55PaiCod ,
                                          String AV56ConveCodigo ,
                                          int A3CliCod ,
                                          short A1564CliPaiConve ,
                                          String A1565CliConvenio )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int13 = new byte[10];
      Object[] GXv_Object14 = new Object[2];
      scmdbuf = "SELECT T1.CliConvenio, T1.CliPaiConve, T1.CliCod, T1.EscAdicional, T1.EscBasico, T1.CatVigencia, T2.CatDescrip, T1.CatSalRelSec, T1.CatCodigo FROM (Categoriavalores1" ;
      scmdbuf += " T1 INNER JOIN Categoria1 T2 ON T2.CliCod = T1.CliCod AND T2.CliPaiConve = T1.CliPaiConve AND T2.CliConvenio = T1.CliConvenio AND T2.CatCodigo = T1.CatCodigo)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.CliPaiConve = ? and T1.CliConvenio = ( ?))");
      if ( ( AV77Escalasalarialwwds_2_tfcatdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV76Escalasalarialwwds_1_tfcatdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.CatDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int13[3] = (byte)(1) ;
      }
      if ( AV77Escalasalarialwwds_2_tfcatdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV77Escalasalarialwwds_2_tfcatdescrip_sels, "T2.CatDescrip IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV78Escalasalarialwwds_3_tfcatvigencia)) )
      {
         addWhere(sWhereString, "(T1.CatVigencia >= ?)");
      }
      else
      {
         GXv_int13[4] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV79Escalasalarialwwds_4_tfcatvigencia_to)) )
      {
         addWhere(sWhereString, "(T1.CatVigencia <= ?)");
      }
      else
      {
         GXv_int13[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV80Escalasalarialwwds_5_tfescbasico)==0) )
      {
         addWhere(sWhereString, "(T1.EscBasico >= ?)");
      }
      else
      {
         GXv_int13[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV81Escalasalarialwwds_6_tfescbasico_to)==0) )
      {
         addWhere(sWhereString, "(T1.EscBasico <= ?)");
      }
      else
      {
         GXv_int13[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV82Escalasalarialwwds_7_tfescadicional)==0) )
      {
         addWhere(sWhereString, "(T1.EscAdicional >= ?)");
      }
      else
      {
         GXv_int13[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV83Escalasalarialwwds_8_tfescadicional_to)==0) )
      {
         addWhere(sWhereString, "(T1.EscAdicional <= ?)");
      }
      else
      {
         GXv_int13[9] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( AV18OrderedBy == 1 )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.CliPaiConve, T1.CliConvenio, T1.CatCodigo, T1.CatVigencia DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.CatDescrip" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.CatDescrip DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.CatVigencia" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.CatVigencia DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.EscBasico" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.EscBasico DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.EscAdicional" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.EscAdicional DESC" ;
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
                  return conditional_P01LK2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , (String)dynConstraints[3] , (java.util.Date)dynConstraints[4] , (java.util.Date)dynConstraints[5] , (java.math.BigDecimal)dynConstraints[6] , (java.math.BigDecimal)dynConstraints[7] , (java.math.BigDecimal)dynConstraints[8] , (java.math.BigDecimal)dynConstraints[9] , (java.util.Date)dynConstraints[10] , (java.math.BigDecimal)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , ((Number) dynConstraints[13]).shortValue() , ((Boolean) dynConstraints[14]).booleanValue() , ((Number) dynConstraints[15]).intValue() , ((Number) dynConstraints[16]).shortValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).shortValue() , (String)dynConstraints[20] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01LK2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getString(9, 40);
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
                  stmt.setVarchar(sIdx, (String)parms[13], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[14]);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[15]);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[16], 2);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[17], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[18], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 2);
               }
               return;
      }
   }

}

