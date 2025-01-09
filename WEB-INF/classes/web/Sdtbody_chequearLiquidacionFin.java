package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtbody_chequearLiquidacionFin extends GxUserType
{
   public Sdtbody_chequearLiquidacionFin( )
   {
      this(  new ModelContext(Sdtbody_chequearLiquidacionFin.class));
   }

   public Sdtbody_chequearLiquidacionFin( ModelContext context )
   {
      super( context, "Sdtbody_chequearLiquidacionFin");
   }

   public Sdtbody_chequearLiquidacionFin( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle, context, "Sdtbody_chequearLiquidacionFin");
   }

   public Sdtbody_chequearLiquidacionFin( StructSdtbody_chequearLiquidacionFin struct )
   {
      this();
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod") )
            {
               gxTv_Sdtbody_chequearLiquidacionFin_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod") )
            {
               gxTv_Sdtbody_chequearLiquidacionFin_Empcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqNro") )
            {
               gxTv_Sdtbody_chequearLiquidacionFin_Liqnro = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "cantidadPorLote") )
            {
               gxTv_Sdtbody_chequearLiquidacionFin_Cantidadporlote = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "cantidadDeLotes") )
            {
               gxTv_Sdtbody_chequearLiquidacionFin_Cantidaddelotes = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "clientId") )
            {
               gxTv_Sdtbody_chequearLiquidacionFin_Clientid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "daemonUUID") )
            {
               gxTv_Sdtbody_chequearLiquidacionFin_Daemonuuid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "body_chequearLiquidacionFin" ;
      }
      if ( (GXutil.strcmp("", sNameSpace)==0) )
      {
         sNameSpace = "PayDay" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_Sdtbody_chequearLiquidacionFin_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpCod", GXutil.trim( GXutil.str( gxTv_Sdtbody_chequearLiquidacionFin_Empcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqNro", GXutil.trim( GXutil.str( gxTv_Sdtbody_chequearLiquidacionFin_Liqnro, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("cantidadPorLote", GXutil.trim( GXutil.str( gxTv_Sdtbody_chequearLiquidacionFin_Cantidadporlote, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("cantidadDeLotes", GXutil.trim( GXutil.str( gxTv_Sdtbody_chequearLiquidacionFin_Cantidaddelotes, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("clientId", gxTv_Sdtbody_chequearLiquidacionFin_Clientid);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("daemonUUID", gxTv_Sdtbody_chequearLiquidacionFin_Daemonuuid);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("CliCod", gxTv_Sdtbody_chequearLiquidacionFin_Clicod, false, false);
      AddObjectProperty("EmpCod", gxTv_Sdtbody_chequearLiquidacionFin_Empcod, false, false);
      AddObjectProperty("LiqNro", gxTv_Sdtbody_chequearLiquidacionFin_Liqnro, false, false);
      AddObjectProperty("cantidadPorLote", gxTv_Sdtbody_chequearLiquidacionFin_Cantidadporlote, false, false);
      AddObjectProperty("cantidadDeLotes", gxTv_Sdtbody_chequearLiquidacionFin_Cantidaddelotes, false, false);
      AddObjectProperty("clientId", gxTv_Sdtbody_chequearLiquidacionFin_Clientid, false, false);
      AddObjectProperty("daemonUUID", gxTv_Sdtbody_chequearLiquidacionFin_Daemonuuid, false, false);
   }

   public int getgxTv_Sdtbody_chequearLiquidacionFin_Clicod( )
   {
      return gxTv_Sdtbody_chequearLiquidacionFin_Clicod ;
   }

   public void setgxTv_Sdtbody_chequearLiquidacionFin_Clicod( int value )
   {
      gxTv_Sdtbody_chequearLiquidacionFin_N = (byte)(0) ;
      gxTv_Sdtbody_chequearLiquidacionFin_Clicod = value ;
   }

   public short getgxTv_Sdtbody_chequearLiquidacionFin_Empcod( )
   {
      return gxTv_Sdtbody_chequearLiquidacionFin_Empcod ;
   }

   public void setgxTv_Sdtbody_chequearLiquidacionFin_Empcod( short value )
   {
      gxTv_Sdtbody_chequearLiquidacionFin_N = (byte)(0) ;
      gxTv_Sdtbody_chequearLiquidacionFin_Empcod = value ;
   }

   public int getgxTv_Sdtbody_chequearLiquidacionFin_Liqnro( )
   {
      return gxTv_Sdtbody_chequearLiquidacionFin_Liqnro ;
   }

   public void setgxTv_Sdtbody_chequearLiquidacionFin_Liqnro( int value )
   {
      gxTv_Sdtbody_chequearLiquidacionFin_N = (byte)(0) ;
      gxTv_Sdtbody_chequearLiquidacionFin_Liqnro = value ;
   }

   public short getgxTv_Sdtbody_chequearLiquidacionFin_Cantidadporlote( )
   {
      return gxTv_Sdtbody_chequearLiquidacionFin_Cantidadporlote ;
   }

   public void setgxTv_Sdtbody_chequearLiquidacionFin_Cantidadporlote( short value )
   {
      gxTv_Sdtbody_chequearLiquidacionFin_N = (byte)(0) ;
      gxTv_Sdtbody_chequearLiquidacionFin_Cantidadporlote = value ;
   }

   public short getgxTv_Sdtbody_chequearLiquidacionFin_Cantidaddelotes( )
   {
      return gxTv_Sdtbody_chequearLiquidacionFin_Cantidaddelotes ;
   }

   public void setgxTv_Sdtbody_chequearLiquidacionFin_Cantidaddelotes( short value )
   {
      gxTv_Sdtbody_chequearLiquidacionFin_N = (byte)(0) ;
      gxTv_Sdtbody_chequearLiquidacionFin_Cantidaddelotes = value ;
   }

   public String getgxTv_Sdtbody_chequearLiquidacionFin_Clientid( )
   {
      return gxTv_Sdtbody_chequearLiquidacionFin_Clientid ;
   }

   public void setgxTv_Sdtbody_chequearLiquidacionFin_Clientid( String value )
   {
      gxTv_Sdtbody_chequearLiquidacionFin_N = (byte)(0) ;
      gxTv_Sdtbody_chequearLiquidacionFin_Clientid = value ;
   }

   public String getgxTv_Sdtbody_chequearLiquidacionFin_Daemonuuid( )
   {
      return gxTv_Sdtbody_chequearLiquidacionFin_Daemonuuid ;
   }

   public void setgxTv_Sdtbody_chequearLiquidacionFin_Daemonuuid( String value )
   {
      gxTv_Sdtbody_chequearLiquidacionFin_N = (byte)(0) ;
      gxTv_Sdtbody_chequearLiquidacionFin_Daemonuuid = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtbody_chequearLiquidacionFin_N = (byte)(1) ;
      gxTv_Sdtbody_chequearLiquidacionFin_Clientid = "" ;
      gxTv_Sdtbody_chequearLiquidacionFin_Daemonuuid = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtbody_chequearLiquidacionFin_N ;
   }

   public web.Sdtbody_chequearLiquidacionFin Clone( )
   {
      return (web.Sdtbody_chequearLiquidacionFin)(clone()) ;
   }

   public void setStruct( web.StructSdtbody_chequearLiquidacionFin struct )
   {
      setgxTv_Sdtbody_chequearLiquidacionFin_Clicod(struct.getClicod());
      setgxTv_Sdtbody_chequearLiquidacionFin_Empcod(struct.getEmpcod());
      setgxTv_Sdtbody_chequearLiquidacionFin_Liqnro(struct.getLiqnro());
      setgxTv_Sdtbody_chequearLiquidacionFin_Cantidadporlote(struct.getCantidadporlote());
      setgxTv_Sdtbody_chequearLiquidacionFin_Cantidaddelotes(struct.getCantidaddelotes());
      setgxTv_Sdtbody_chequearLiquidacionFin_Clientid(struct.getClientid());
      setgxTv_Sdtbody_chequearLiquidacionFin_Daemonuuid(struct.getDaemonuuid());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtbody_chequearLiquidacionFin getStruct( )
   {
      web.StructSdtbody_chequearLiquidacionFin struct = new web.StructSdtbody_chequearLiquidacionFin ();
      struct.setClicod(getgxTv_Sdtbody_chequearLiquidacionFin_Clicod());
      struct.setEmpcod(getgxTv_Sdtbody_chequearLiquidacionFin_Empcod());
      struct.setLiqnro(getgxTv_Sdtbody_chequearLiquidacionFin_Liqnro());
      struct.setCantidadporlote(getgxTv_Sdtbody_chequearLiquidacionFin_Cantidadporlote());
      struct.setCantidaddelotes(getgxTv_Sdtbody_chequearLiquidacionFin_Cantidaddelotes());
      struct.setClientid(getgxTv_Sdtbody_chequearLiquidacionFin_Clientid());
      struct.setDaemonuuid(getgxTv_Sdtbody_chequearLiquidacionFin_Daemonuuid());
      return struct ;
   }

   protected byte gxTv_Sdtbody_chequearLiquidacionFin_N ;
   protected short gxTv_Sdtbody_chequearLiquidacionFin_Empcod ;
   protected short gxTv_Sdtbody_chequearLiquidacionFin_Cantidadporlote ;
   protected short gxTv_Sdtbody_chequearLiquidacionFin_Cantidaddelotes ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_Sdtbody_chequearLiquidacionFin_Clicod ;
   protected int gxTv_Sdtbody_chequearLiquidacionFin_Liqnro ;
   protected String gxTv_Sdtbody_chequearLiquidacionFin_Daemonuuid ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtbody_chequearLiquidacionFin_Clientid ;
}

