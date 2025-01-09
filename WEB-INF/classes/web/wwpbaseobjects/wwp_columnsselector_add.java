package web.wwpbaseobjects ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_columnsselector_add extends GXProcedure
{
   public wwp_columnsselector_add( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_columnsselector_add.class ), "" );
   }

   public wwp_columnsselector_add( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( web.wwpbaseobjects.SdtWWPColumnsSelector[] aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 ,
                        boolean aP4 ,
                        String aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( web.wwpbaseobjects.SdtWWPColumnsSelector[] aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             boolean aP4 ,
                             String aP5 )
   {
      wwp_columnsselector_add.this.AV8ColumnsSelector = aP0[0];
      this.aP0 = aP0;
      wwp_columnsselector_add.this.AV9ColumnName = aP1;
      wwp_columnsselector_add.this.AV10Category = aP2;
      wwp_columnsselector_add.this.AV11DisplayName = aP3;
      wwp_columnsselector_add.this.AV13IsVisible = aP4;
      wwp_columnsselector_add.this.AV12Fixed = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV14Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      AV14Column.setgxTv_SdtWWPColumnsSelector_Column_Columnname( AV9ColumnName );
      AV14Column.setgxTv_SdtWWPColumnsSelector_Column_Displayname( AV11DisplayName );
      AV14Column.setgxTv_SdtWWPColumnsSelector_Column_Isvisible( AV13IsVisible );
      AV14Column.setgxTv_SdtWWPColumnsSelector_Column_Order( (short)(AV8ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size()+1) );
      AV14Column.setgxTv_SdtWWPColumnsSelector_Column_Category( AV10Category );
      AV8ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().add(AV14Column, 0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = wwp_columnsselector_add.this.AV8ColumnsSelector;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private boolean AV13IsVisible ;
   private String AV9ColumnName ;
   private String AV10Category ;
   private String AV11DisplayName ;
   private String AV12Fixed ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector[] aP0 ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV8ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV14Column ;
}

