package web.wwpbaseobjects ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_columnselector_updatecolumns extends GXProcedure
{
   public wwp_columnselector_updatecolumns( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_columnselector_updatecolumns.class ), "" );
   }

   public wwp_columnselector_updatecolumns( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public web.wwpbaseobjects.SdtWWPColumnsSelector executeUdp( web.wwpbaseobjects.SdtWWPColumnsSelector[] aP0 )
   {
      wwp_columnselector_updatecolumns.this.aP1 = new web.wwpbaseobjects.SdtWWPColumnsSelector[] {new web.wwpbaseobjects.SdtWWPColumnsSelector()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( web.wwpbaseobjects.SdtWWPColumnsSelector[] aP0 ,
                        web.wwpbaseobjects.SdtWWPColumnsSelector[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( web.wwpbaseobjects.SdtWWPColumnsSelector[] aP0 ,
                             web.wwpbaseobjects.SdtWWPColumnsSelector[] aP1 )
   {
      wwp_columnselector_updatecolumns.this.AV15OldColumnsSelector = aP0[0];
      this.aP0 = aP0;
      wwp_columnselector_updatecolumns.this.AV11ColumnsSelector = aP1[0];
      this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV17CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      wwp_columnselector_updatecolumns.this.GXt_int1 = GXv_int2[0] ;
      AV17CliCod = GXt_int1 ;
      AV20GXV1 = 1 ;
      while ( AV20GXV1 <= AV11ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV8Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV11ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV20GXV1));
         /* Execute user subroutine: 'ISCOLUMNVISIBLE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( AV13Found )
         {
            AV8Column.setgxTv_SdtWWPColumnsSelector_Column_Isvisible( AV14IsColumnVisible );
            AV8Column.setgxTv_SdtWWPColumnsSelector_Column_Fixed( AV9Fixed );
            AV8Column.setgxTv_SdtWWPColumnsSelector_Column_Order( AV16ColumnOrder );
         }
         AV20GXV1 = (int)(AV20GXV1+1) ;
      }
      AV12ColumnsSelectorAux = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV12ColumnsSelectorAux.fromJSonString(AV11ColumnsSelector.toJSonString(false, true), null);
      AV12ColumnsSelectorAux.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV16ColumnOrder = (short)(0) ;
      AV21GXV2 = 1 ;
      while ( AV21GXV2 <= AV12ColumnsSelectorAux.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV10ColumnAux = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV12ColumnsSelectorAux.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV21GXV2));
         AV22GXV3 = 1 ;
         while ( AV22GXV3 <= AV11ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV8Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV11ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV22GXV3));
            if ( GXutil.strcmp(AV8Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), AV10ColumnAux.getgxTv_SdtWWPColumnsSelector_Column_Columnname()) == 0 )
            {
               AV8Column.setgxTv_SdtWWPColumnsSelector_Column_Order( AV16ColumnOrder );
               if (true) break;
            }
            AV22GXV3 = (int)(AV22GXV3+1) ;
         }
         AV16ColumnOrder = (short)(AV16ColumnOrder+1) ;
         AV21GXV2 = (int)(AV21GXV2+1) ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'ISCOLUMNVISIBLE' Routine */
      returnInSub = false ;
      AV13Found = false ;
      AV23GXV4 = 1 ;
      while ( AV23GXV4 <= AV15OldColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV10ColumnAux = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV15OldColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV23GXV4));
         if ( GXutil.strcmp(AV8Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), AV10ColumnAux.getgxTv_SdtWWPColumnsSelector_Column_Columnname()) == 0 )
         {
            AV14IsColumnVisible = AV10ColumnAux.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ;
            AV9Fixed = AV10ColumnAux.getgxTv_SdtWWPColumnsSelector_Column_Fixed() ;
            AV16ColumnOrder = AV10ColumnAux.getgxTv_SdtWWPColumnsSelector_Column_Order() ;
            AV13Found = true ;
            if (true) break;
         }
         AV23GXV4 = (int)(AV23GXV4+1) ;
      }
   }

   protected void cleanup( )
   {
      this.aP0[0] = wwp_columnselector_updatecolumns.this.AV15OldColumnsSelector;
      this.aP1[0] = wwp_columnselector_updatecolumns.this.AV11ColumnsSelector;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_int2 = new int[1] ;
      AV8Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      AV9Fixed = "" ;
      AV12ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV10ColumnAux = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV16ColumnOrder ;
   private short Gx_err ;
   private int AV17CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int AV20GXV1 ;
   private int AV21GXV2 ;
   private int AV22GXV3 ;
   private int AV23GXV4 ;
   private boolean returnInSub ;
   private boolean AV13Found ;
   private boolean AV14IsColumnVisible ;
   private String AV9Fixed ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector[] aP1 ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector[] aP0 ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV15OldColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV11ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV12ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV8Column ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV10ColumnAux ;
}

