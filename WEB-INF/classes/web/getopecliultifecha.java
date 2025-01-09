package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getopecliultifecha extends GXProcedure
{
   public getopecliultifecha( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getopecliultifecha.class ), "" );
   }

   public getopecliultifecha( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           String aP1 ,
                           java.util.Date aP2 ,
                           java.util.Date[] aP3 )
   {
      getopecliultifecha.this.aP4 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        java.util.Date aP2 ,
                        java.util.Date[] aP3 ,
                        byte[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             java.util.Date aP2 ,
                             java.util.Date[] aP3 ,
                             byte[] aP4 )
   {
      getopecliultifecha.this.AV10CliCod = aP0;
      getopecliultifecha.this.AV8OpeCliId = aP1;
      getopecliultifecha.this.AV11OpeCliVig = aP2;
      getopecliultifecha.this.aP3 = aP3;
      getopecliultifecha.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV15parmCatVigencia)) )
      {
         AV16OpeCliVig_comienzo = localUtil.ymdtod( GXutil.year( AV11OpeCliVig), GXutil.month( AV11OpeCliVig), 1) ;
      }
      GXv_int1[0] = AV17VarFrecAct ;
      new web.getvarfrectact(remoteHandle, context).execute( AV10CliCod, AV8OpeCliId, GXv_int1) ;
      getopecliultifecha.this.AV17VarFrecAct = GXv_int1[0] ;
      AV20GXLvl7 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV11OpeCliVig ,
                                           A754OpeCliVig ,
                                           AV16OpeCliVig_comienzo ,
                                           Integer.valueOf(AV10CliCod) ,
                                           AV8OpeCliId ,
                                           Integer.valueOf(A3CliCod) ,
                                           A82OpeCliId } ,
                                           new int[]{
                                           TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING
                                           }
      });
      /* Using cursor P01TI2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), AV8OpeCliId, AV11OpeCliVig, AV16OpeCliVig_comienzo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A754OpeCliVig = P01TI2_A754OpeCliVig[0] ;
         A82OpeCliId = P01TI2_A82OpeCliId[0] ;
         A3CliCod = P01TI2_A3CliCod[0] ;
         AV20GXLvl7 = (byte)(1) ;
         AV13ult_OpeCliVig = A754OpeCliVig ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV20GXLvl7 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV21Pgmname, httpContext.getMessage( "none &CliCod ", "")+GXutil.trim( GXutil.str( AV10CliCod, 6, 0))+httpContext.getMessage( " &OpeCliId ", "")+AV8OpeCliId+httpContext.getMessage( " &OpeCliVig ", "")+localUtil.dtoc( AV11OpeCliVig, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getopecliultifecha.this.AV13ult_OpeCliVig;
      this.aP4[0] = getopecliultifecha.this.AV17VarFrecAct;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13ult_OpeCliVig = GXutil.nullDate() ;
      AV15parmCatVigencia = GXutil.nullDate() ;
      AV16OpeCliVig_comienzo = GXutil.nullDate() ;
      GXv_int1 = new byte[1] ;
      scmdbuf = "" ;
      A754OpeCliVig = GXutil.nullDate() ;
      A82OpeCliId = "" ;
      P01TI2_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      P01TI2_A82OpeCliId = new String[] {""} ;
      P01TI2_A3CliCod = new int[1] ;
      AV21Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getopecliultifecha__default(),
         new Object[] {
             new Object[] {
            P01TI2_A754OpeCliVig, P01TI2_A82OpeCliId, P01TI2_A3CliCod
            }
         }
      );
      AV21Pgmname = "getOpeCliUltiFecha" ;
      /* GeneXus formulas. */
      AV21Pgmname = "getOpeCliUltiFecha" ;
      Gx_err = (short)(0) ;
   }

   private byte AV17VarFrecAct ;
   private byte GXv_int1[] ;
   private byte AV20GXLvl7 ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private String AV8OpeCliId ;
   private String scmdbuf ;
   private String A82OpeCliId ;
   private String AV21Pgmname ;
   private java.util.Date AV11OpeCliVig ;
   private java.util.Date AV13ult_OpeCliVig ;
   private java.util.Date AV15parmCatVigencia ;
   private java.util.Date AV16OpeCliVig_comienzo ;
   private java.util.Date A754OpeCliVig ;
   private byte[] aP4 ;
   private java.util.Date[] aP3 ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P01TI2_A754OpeCliVig ;
   private String[] P01TI2_A82OpeCliId ;
   private int[] P01TI2_A3CliCod ;
}

final  class getopecliultifecha__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01TI2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          java.util.Date AV11OpeCliVig ,
                                          java.util.Date A754OpeCliVig ,
                                          java.util.Date AV16OpeCliVig_comienzo ,
                                          int AV10CliCod ,
                                          String AV8OpeCliId ,
                                          int A3CliCod ,
                                          String A82OpeCliId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int2 = new byte[4];
      Object[] GXv_Object3 = new Object[2];
      scmdbuf = "SELECT OpeCliVig, OpeCliId, CliCod FROM variable_valores" ;
      addWhere(sWhereString, "(CliCod = ? and OpeCliId = ( ?))");
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV11OpeCliVig)) )
      {
         addWhere(sWhereString, "(OpeCliVig <= ?)");
      }
      else
      {
         GXv_int2[2] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV11OpeCliVig)) )
      {
         addWhere(sWhereString, "(OpeCliVig >= ?)");
      }
      else
      {
         GXv_int2[3] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, OpeCliId, OpeCliVig DESC" ;
      GXv_Object3[0] = scmdbuf ;
      GXv_Object3[1] = GXv_int2 ;
      return GXv_Object3 ;
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
                  return conditional_P01TI2(context, remoteHandle, httpContext, (java.util.Date)dynConstraints[0] , (java.util.Date)dynConstraints[1] , (java.util.Date)dynConstraints[2] , ((Number) dynConstraints[3]).intValue() , (String)dynConstraints[4] , ((Number) dynConstraints[5]).intValue() , (String)dynConstraints[6] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01TI2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((int[]) buf[2])[0] = rslt.getInt(3);
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
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[5], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[6]);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[7]);
               }
               return;
      }
   }

}

