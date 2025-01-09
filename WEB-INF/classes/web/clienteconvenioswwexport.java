package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class clienteconvenioswwexport extends GXProcedure
{
   public clienteconvenioswwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( clienteconvenioswwexport.class ), "" );
   }

   public clienteconvenioswwexport( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      clienteconvenioswwexport.this.aP1 = new String[] {""};
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
      clienteconvenioswwexport.this.aP0 = aP0;
      clienteconvenioswwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClienteConvenios", GXv_boolean2) ;
      clienteconvenioswwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
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
      AV12Filename = "ClienteConveniosWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV40TFCliConvenio_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Código", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clienteconvenioswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV47i = 1 ;
         AV53GXV1 = 1 ;
         while ( AV53GXV1 <= AV40TFCliConvenio_Sels.size() )
         {
            AV41TFCliConvenio_Sel = (String)AV40TFCliConvenio_Sels.elementAt(-1+AV53GXV1) ;
            if ( AV47i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV41TFCliConvenio_Sel, GXv_char7) ;
            clienteconvenioswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV47i = (long)(AV47i+1) ;
            AV53GXV1 = (int)(AV53GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV39TFCliConvenio)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Código", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            clienteconvenioswwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV39TFCliConvenio, GXv_char7) ;
            clienteconvenioswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV44TFCliConvenioDescrip_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clienteconvenioswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV47i = 1 ;
         AV54GXV2 = 1 ;
         while ( AV54GXV2 <= AV44TFCliConvenioDescrip_Sels.size() )
         {
            AV45TFCliConvenioDescrip_Sel = (String)AV44TFCliConvenioDescrip_Sels.elementAt(-1+AV54GXV2) ;
            if ( AV47i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV45TFCliConvenioDescrip_Sel, GXv_char7) ;
            clienteconvenioswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV47i = (long)(AV47i+1) ;
            AV54GXV2 = (int)(AV54GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV43TFCliConvenioDescrip)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            clienteconvenioswwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV43TFCliConvenioDescrip, GXv_char7) ;
            clienteconvenioswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV46TFCliConveHab_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Habilitado", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clienteconvenioswwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV46TFCliConveHab_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV46TFCliConveHab_Sel == 2 )
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
      AV35VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("ClienteConveniosWWColumnsSelector"), "") != 0 )
      {
         AV30ColumnsSelectorXML = AV20Session.getValue("ClienteConveniosWWColumnsSelector") ;
         AV27ColumnsSelector.fromxml(AV30ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( (boolean)((AV24IsAuthorizedCliConveHab&&((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible())) );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV55GXV3 = 1 ;
      while ( AV55GXV3 <= AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV29ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV55GXV3));
         if ( AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV35VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV35VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV35VisibleColumnCount), 1, 1).setColor( 11 );
            AV35VisibleColumnCount = (long)(AV35VisibleColumnCount+1) ;
         }
         AV55GXV3 = (int)(AV55GXV3+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV57Clienteconvenioswwds_1_tfcliconvenio = AV39TFCliConvenio ;
      AV58Clienteconvenioswwds_2_tfcliconvenio_sels = AV40TFCliConvenio_Sels ;
      AV59Clienteconvenioswwds_3_tfcliconveniodescrip = AV43TFCliConvenioDescrip ;
      AV60Clienteconvenioswwds_4_tfcliconveniodescrip_sels = AV44TFCliConvenioDescrip_Sels ;
      AV61Clienteconvenioswwds_5_tfcliconvehab_sel = AV46TFCliConveHab_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1565CliConvenio ,
                                           AV58Clienteconvenioswwds_2_tfcliconvenio_sels ,
                                           A1567CliConvenioDescrip ,
                                           AV60Clienteconvenioswwds_4_tfcliconveniodescrip_sels ,
                                           Integer.valueOf(AV58Clienteconvenioswwds_2_tfcliconvenio_sels.size()) ,
                                           AV57Clienteconvenioswwds_1_tfcliconvenio ,
                                           Integer.valueOf(AV60Clienteconvenioswwds_4_tfcliconveniodescrip_sels.size()) ,
                                           AV59Clienteconvenioswwds_3_tfcliconveniodescrip ,
                                           Byte.valueOf(AV61Clienteconvenioswwds_5_tfcliconvehab_sel) ,
                                           Boolean.valueOf(A1639CliConveHab) ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Integer.valueOf(AV48CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN,
                                           TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV57Clienteconvenioswwds_1_tfcliconvenio = GXutil.padr( GXutil.rtrim( AV57Clienteconvenioswwds_1_tfcliconvenio), 20, "%") ;
      lV59Clienteconvenioswwds_3_tfcliconveniodescrip = GXutil.concat( GXutil.rtrim( AV59Clienteconvenioswwds_3_tfcliconveniodescrip), "%", "") ;
      /* Using cursor P02FF2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV48CliCod), lV57Clienteconvenioswwds_1_tfcliconvenio, lV59Clienteconvenioswwds_3_tfcliconveniodescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1564CliPaiConve = P02FF2_A1564CliPaiConve[0] ;
         A3CliCod = P02FF2_A3CliCod[0] ;
         A1639CliConveHab = P02FF2_A1639CliConveHab[0] ;
         A1567CliConvenioDescrip = P02FF2_A1567CliConvenioDescrip[0] ;
         A1565CliConvenio = P02FF2_A1565CliConvenio[0] ;
         A1567CliConvenioDescrip = P02FF2_A1567CliConvenioDescrip[0] ;
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
         AV35VisibleColumnCount = 0 ;
         AV62GXV4 = 1 ;
         while ( AV62GXV4 <= AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV29ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV27ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV62GXV4));
            if ( AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliConvenio") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1565CliConvenio, GXv_char7) ;
                  clienteconvenioswwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV35VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliConvenioDescrip") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1567CliConvenioDescrip, GXv_char7) ;
                  clienteconvenioswwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV35VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV29ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliConveHab") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV35VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1639CliConveHab) );
               }
               AV35VisibleColumnCount = (long)(AV35VisibleColumnCount+1) ;
            }
            AV62GXV4 = (int)(AV62GXV4+1) ;
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
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      GXt_boolean1 = AV24IsAuthorizedCliConveHab ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.getclienteconveniador(remoteHandle, context).execute( AV48CliCod, GXv_boolean2) ;
      clienteconvenioswwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV24IsAuthorizedCliConveHab = (boolean)((GXt_boolean1)) ;
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
      AV27ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "CliConvenio", "", "Código", true, "") ;
      AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "CliConvenioDescrip", "", "Descripción", true, "") ;
      AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      if ( new web.getclienteconveniador(remoteHandle, context).executeUdp( AV48CliCod) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "CliConveHab", "", "Habilitado", true, "") ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&VerSVG", "", "", true, "") ;
      AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&ModificarSVG", "", "", true, "") ;
      AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      if ( new web.getclienteconveniador(remoteHandle, context).executeUdp( AV48CliCod) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&EliminarSVG", "", "", true, "") ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      GXt_char6 = AV31UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "ClienteConveniosWWColumnsSelector", GXv_char7) ;
      clienteconvenioswwexport.this.GXt_char6 = GXv_char7[0] ;
      AV31UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV31UserCustomValue)==0) ) )
      {
         AV28ColumnsSelectorAux.fromxml(AV31UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector9[0] = AV27ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, GXv_SdtWWPColumnsSelector9) ;
         AV28ColumnsSelectorAux = GXv_SdtWWPColumnsSelector8[0] ;
         AV27ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
   }

   public void S211( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("ClienteConveniosWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ClienteConveniosWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("ClienteConveniosWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV63GXV5 = 1 ;
      while ( AV63GXV5 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV63GXV5));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICONVENIO") == 0 )
         {
            AV39TFCliConvenio = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICONVENIO_SEL") == 0 )
         {
            AV38TFCliConvenio_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV40TFCliConvenio_Sels.fromJSonString(AV38TFCliConvenio_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICONVENIODESCRIP") == 0 )
         {
            AV43TFCliConvenioDescrip = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICONVENIODESCRIP_SEL") == 0 )
         {
            AV42TFCliConvenioDescrip_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV44TFCliConvenioDescrip_Sels.fromJSonString(AV42TFCliConvenioDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICONVEHAB_SEL") == 0 )
         {
            AV46TFCliConveHab_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV17MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV63GXV5 = (int)(AV63GXV5+1) ;
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
      this.aP0[0] = clienteconvenioswwexport.this.AV12Filename;
      this.aP1[0] = clienteconvenioswwexport.this.AV13ErrorMessage;
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
      AV52Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV40TFCliConvenio_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV41TFCliConvenio_Sel = "" ;
      AV39TFCliConvenio = "" ;
      AV44TFCliConvenioDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV45TFCliConvenioDescrip_Sel = "" ;
      AV43TFCliConvenioDescrip = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV30ColumnsSelectorXML = "" ;
      AV27ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV29ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A1565CliConvenio = "" ;
      A1567CliConvenioDescrip = "" ;
      AV57Clienteconvenioswwds_1_tfcliconvenio = "" ;
      AV58Clienteconvenioswwds_2_tfcliconvenio_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV59Clienteconvenioswwds_3_tfcliconveniodescrip = "" ;
      AV60Clienteconvenioswwds_4_tfcliconveniodescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV57Clienteconvenioswwds_1_tfcliconvenio = "" ;
      lV59Clienteconvenioswwds_3_tfcliconveniodescrip = "" ;
      P02FF2_A1564CliPaiConve = new short[1] ;
      P02FF2_A3CliCod = new int[1] ;
      P02FF2_A1639CliConveHab = new boolean[] {false} ;
      P02FF2_A1567CliConvenioDescrip = new String[] {""} ;
      P02FF2_A1565CliConvenio = new String[] {""} ;
      GXv_boolean2 = new boolean[1] ;
      AV31UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV28ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV38TFCliConvenio_SelsJson = "" ;
      AV42TFCliConvenioDescrip_SelsJson = "" ;
      AV17MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.clienteconvenioswwexport__default(),
         new Object[] {
             new Object[] {
            P02FF2_A1564CliPaiConve, P02FF2_A3CliCod, P02FF2_A1639CliConveHab, P02FF2_A1567CliConvenioDescrip, P02FF2_A1565CliConvenio
            }
         }
      );
      AV52Pgmname = "ClienteConveniosWWExport" ;
      /* GeneXus formulas. */
      AV52Pgmname = "ClienteConveniosWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV46TFCliConveHab_Sel ;
   private byte AV61Clienteconvenioswwds_5_tfcliconvehab_sel ;
   private short GXv_int5[] ;
   private short AV18OrderedBy ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV53GXV1 ;
   private int AV54GXV2 ;
   private int AV55GXV3 ;
   private int AV58Clienteconvenioswwds_2_tfcliconvenio_sels_size ;
   private int AV60Clienteconvenioswwds_4_tfcliconveniodescrip_sels_size ;
   private int AV48CliCod ;
   private int A3CliCod ;
   private int AV62GXV4 ;
   private int AV63GXV5 ;
   private long AV47i ;
   private long AV35VisibleColumnCount ;
   private String AV52Pgmname ;
   private String AV41TFCliConvenio_Sel ;
   private String AV39TFCliConvenio ;
   private String A1565CliConvenio ;
   private String AV57Clienteconvenioswwds_1_tfcliconvenio ;
   private String scmdbuf ;
   private String lV57Clienteconvenioswwds_1_tfcliconvenio ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean returnInSub ;
   private boolean AV24IsAuthorizedCliConveHab ;
   private boolean A1639CliConveHab ;
   private boolean AV19OrderedDsc ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean Cond_result ;
   private String AV30ColumnsSelectorXML ;
   private String AV31UserCustomValue ;
   private String AV38TFCliConvenio_SelsJson ;
   private String AV42TFCliConvenioDescrip_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV45TFCliConvenioDescrip_Sel ;
   private String AV43TFCliConvenioDescrip ;
   private String A1567CliConvenioDescrip ;
   private String AV59Clienteconvenioswwds_3_tfcliconveniodescrip ;
   private String lV59Clienteconvenioswwds_3_tfcliconveniodescrip ;
   private String AV17MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV40TFCliConvenio_Sels ;
   private GXSimpleCollection<String> AV44TFCliConvenioDescrip_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private short[] P02FF2_A1564CliPaiConve ;
   private int[] P02FF2_A3CliCod ;
   private boolean[] P02FF2_A1639CliConveHab ;
   private String[] P02FF2_A1567CliConvenioDescrip ;
   private String[] P02FF2_A1565CliConvenio ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV58Clienteconvenioswwds_2_tfcliconvenio_sels ;
   private GXSimpleCollection<String> AV60Clienteconvenioswwds_4_tfcliconveniodescrip_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV27ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV28ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV29ColumnsSelector_Column ;
}

final  class clienteconvenioswwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02FF2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1565CliConvenio ,
                                          GXSimpleCollection<String> AV58Clienteconvenioswwds_2_tfcliconvenio_sels ,
                                          String A1567CliConvenioDescrip ,
                                          GXSimpleCollection<String> AV60Clienteconvenioswwds_4_tfcliconveniodescrip_sels ,
                                          int AV58Clienteconvenioswwds_2_tfcliconvenio_sels_size ,
                                          String AV57Clienteconvenioswwds_1_tfcliconvenio ,
                                          int AV60Clienteconvenioswwds_4_tfcliconveniodescrip_sels_size ,
                                          String AV59Clienteconvenioswwds_3_tfcliconveniodescrip ,
                                          byte AV61Clienteconvenioswwds_5_tfcliconvehab_sel ,
                                          boolean A1639CliConveHab ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          int AV48CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[3];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT T1.CliPaiConve AS CliPaiConve, T1.CliCod, T1.CliConveHab, T2.ConveDescri AS CliConvenioDescrip, T1.CliConvenio AS CliConvenio FROM (ClienteConvenios T1 INNER" ;
      scmdbuf += " JOIN Convenio T2 ON T2.PaiCod = T1.CliPaiConve AND T2.ConveCodigo = T1.CliConvenio)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      if ( ( AV58Clienteconvenioswwds_2_tfcliconvenio_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV57Clienteconvenioswwds_1_tfcliconvenio)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.CliConvenio) like LOWER(?))");
      }
      else
      {
         GXv_int10[1] = (byte)(1) ;
      }
      if ( AV58Clienteconvenioswwds_2_tfcliconvenio_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58Clienteconvenioswwds_2_tfcliconvenio_sels, "T1.CliConvenio IN (", ")")+")");
      }
      if ( ( AV60Clienteconvenioswwds_4_tfcliconveniodescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV59Clienteconvenioswwds_3_tfcliconveniodescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.ConveDescri) like LOWER(?))");
      }
      else
      {
         GXv_int10[2] = (byte)(1) ;
      }
      if ( AV60Clienteconvenioswwds_4_tfcliconveniodescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV60Clienteconvenioswwds_4_tfcliconveniodescrip_sels, "T2.ConveDescri IN (", ")")+")");
      }
      if ( AV61Clienteconvenioswwds_5_tfcliconvehab_sel == 1 )
      {
         addWhere(sWhereString, "(T1.CliConveHab = TRUE)");
      }
      if ( AV61Clienteconvenioswwds_5_tfcliconvehab_sel == 2 )
      {
         addWhere(sWhereString, "(T1.CliConveHab = FALSE)");
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.CliConvenio" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.CliConvenio DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.ConveDescri" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.ConveDescri DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.CliConveHab" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.CliConveHab DESC" ;
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
                  return conditional_P02FF2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).byteValue() , ((Boolean) dynConstraints[9]).booleanValue() , ((Number) dynConstraints[10]).shortValue() , ((Boolean) dynConstraints[11]).booleanValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02FF2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
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
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[4], 20);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[5], 400);
               }
               return;
      }
   }

}

