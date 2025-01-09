package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getconveniopordescrip extends GXProcedure
{
   public getconveniopordescrip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getconveniopordescrip.class ), "" );
   }

   public getconveniopordescrip( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              String aP2 ,
                              String aP3 ,
                              String[] aP4 )
   {
      getconveniopordescrip.this.aP5 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        String aP3 ,
                        String[] aP4 ,
                        boolean[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String[] aP4 ,
                             boolean[] aP5 )
   {
      getconveniopordescrip.this.AV11CliCod = aP0;
      getconveniopordescrip.this.AV13PaiCod = aP1;
      getconveniopordescrip.this.AV12SinCod = aP2;
      getconveniopordescrip.this.AV8ConveDescri = aP3;
      getconveniopordescrip.this.aP4 = aP4;
      getconveniopordescrip.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV16Pgmname, httpContext.getMessage( "&PaiCod", "")+GXutil.trim( GXutil.str( AV13PaiCod, 4, 0))+httpContext.getMessage( " &SinCod ", "")+AV12SinCod+httpContext.getMessage( " &ConveDescri ", "")+AV8ConveDescri) ;
      AV17GXLvl3 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV12SinCod ,
                                           A935ConveSinCod ,
                                           A687ConveDescriSinAc ,
                                           AV8ConveDescri ,
                                           Short.valueOf(AV13PaiCod) ,
                                           Short.valueOf(A46PaiCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P00M02 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV13PaiCod), AV8ConveDescri, AV12SinCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A687ConveDescriSinAc = P00M02_A687ConveDescriSinAc[0] ;
         A935ConveSinCod = P00M02_A935ConveSinCod[0] ;
         n935ConveSinCod = P00M02_n935ConveSinCod[0] ;
         A46PaiCod = P00M02_A46PaiCod[0] ;
         A9ConveCodigo = P00M02_A9ConveCodigo[0] ;
         AV17GXLvl3 = (byte)(1) ;
         AV10ConveCodigo = GXutil.trim( A9ConveCodigo) ;
         AV9existe = true ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV16Pgmname, httpContext.getMessage( "&ConveCodigo ", "")+AV10ConveCodigo) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV17GXLvl3 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV16Pgmname, httpContext.getMessage( "nonte", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getconveniopordescrip.this.AV10ConveCodigo;
      this.aP5[0] = getconveniopordescrip.this.AV9existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10ConveCodigo = "" ;
      AV16Pgmname = "" ;
      scmdbuf = "" ;
      A935ConveSinCod = "" ;
      A687ConveDescriSinAc = "" ;
      P00M02_A687ConveDescriSinAc = new String[] {""} ;
      P00M02_A935ConveSinCod = new String[] {""} ;
      P00M02_n935ConveSinCod = new boolean[] {false} ;
      P00M02_A46PaiCod = new short[1] ;
      P00M02_A9ConveCodigo = new String[] {""} ;
      A9ConveCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getconveniopordescrip__default(),
         new Object[] {
             new Object[] {
            P00M02_A687ConveDescriSinAc, P00M02_A935ConveSinCod, P00M02_n935ConveSinCod, P00M02_A46PaiCod, P00M02_A9ConveCodigo
            }
         }
      );
      AV16Pgmname = "getConvenioPorDescrip" ;
      /* GeneXus formulas. */
      AV16Pgmname = "getConvenioPorDescrip" ;
      Gx_err = (short)(0) ;
   }

   private byte AV17GXLvl3 ;
   private short AV13PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private String AV12SinCod ;
   private String AV10ConveCodigo ;
   private String AV16Pgmname ;
   private String scmdbuf ;
   private String A935ConveSinCod ;
   private String A9ConveCodigo ;
   private boolean AV9existe ;
   private boolean n935ConveSinCod ;
   private String AV8ConveDescri ;
   private String A687ConveDescriSinAc ;
   private boolean[] aP5 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P00M02_A687ConveDescriSinAc ;
   private String[] P00M02_A935ConveSinCod ;
   private boolean[] P00M02_n935ConveSinCod ;
   private short[] P00M02_A46PaiCod ;
   private String[] P00M02_A9ConveCodigo ;
}

final  class getconveniopordescrip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00M02( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SinCod ,
                                          String A935ConveSinCod ,
                                          String A687ConveDescriSinAc ,
                                          String AV8ConveDescri ,
                                          short AV13PaiCod ,
                                          short A46PaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[3];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT ConveDescriSinAc, ConveSinCod, PaiCod, ConveCodigo FROM Convenio" ;
      addWhere(sWhereString, "(PaiCod = ?)");
      addWhere(sWhereString, "(ConveDescriSinAc = ( ?))");
      if ( ! (GXutil.strcmp("", AV12SinCod)==0) )
      {
         addWhere(sWhereString, "(ConveSinCod = ( ?))");
      }
      else
      {
         GXv_int1[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY PaiCod" ;
      GXv_Object2[0] = scmdbuf ;
      GXv_Object2[1] = GXv_int1 ;
      return GXv_Object2 ;
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
                  return conditional_P00M02(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00M02", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
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
                  stmt.setShort(sIdx, ((Number) parms[3]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[4], 400);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[5], 20);
               }
               return;
      }
   }

}

