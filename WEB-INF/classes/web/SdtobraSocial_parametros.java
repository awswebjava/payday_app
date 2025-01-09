package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtobraSocial_parametros extends GxUserType
{
   public SdtobraSocial_parametros( )
   {
      this(  new ModelContext(SdtobraSocial_parametros.class));
   }

   public SdtobraSocial_parametros( ModelContext context )
   {
      super( context, "SdtobraSocial_parametros");
   }

   public SdtobraSocial_parametros( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle, context, "SdtobraSocial_parametros");
   }

   public SdtobraSocial_parametros( StructSdtobraSocial_parametros struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "OsoPrcSuperaTope") )
            {
               gxTv_SdtobraSocial_parametros_Osoprcsuperatope = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OsoPrcHastaTope") )
            {
               gxTv_SdtobraSocial_parametros_Osoprchastatope = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OsoPrcAnssalSuperaTope") )
            {
               gxTv_SdtobraSocial_parametros_Osoprcanssalsuperatope = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OsoPrcAnssalHastaTope") )
            {
               gxTv_SdtobraSocial_parametros_Osoprcanssalhastatope = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OsoJerarquica") )
            {
               gxTv_SdtobraSocial_parametros_Osojerarquica = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
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
         sName = "obraSocial_parametros" ;
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
      oWriter.writeElement("OsoPrcSuperaTope", GXutil.trim( GXutil.strNoRound( gxTv_SdtobraSocial_parametros_Osoprcsuperatope, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("OsoPrcHastaTope", GXutil.trim( GXutil.strNoRound( gxTv_SdtobraSocial_parametros_Osoprchastatope, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("OsoPrcAnssalSuperaTope", GXutil.trim( GXutil.strNoRound( gxTv_SdtobraSocial_parametros_Osoprcanssalsuperatope, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("OsoPrcAnssalHastaTope", GXutil.trim( GXutil.strNoRound( gxTv_SdtobraSocial_parametros_Osoprcanssalhastatope, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("OsoJerarquica", GXutil.booltostr( gxTv_SdtobraSocial_parametros_Osojerarquica));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeEndElement();
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
      AddObjectProperty("OsoPrcSuperaTope", gxTv_SdtobraSocial_parametros_Osoprcsuperatope, false, false);
      AddObjectProperty("OsoPrcHastaTope", gxTv_SdtobraSocial_parametros_Osoprchastatope, false, false);
      AddObjectProperty("OsoPrcAnssalSuperaTope", gxTv_SdtobraSocial_parametros_Osoprcanssalsuperatope, false, false);
      AddObjectProperty("OsoPrcAnssalHastaTope", gxTv_SdtobraSocial_parametros_Osoprcanssalhastatope, false, false);
      AddObjectProperty("OsoJerarquica", gxTv_SdtobraSocial_parametros_Osojerarquica, false, false);
   }

   public java.math.BigDecimal getgxTv_SdtobraSocial_parametros_Osoprcsuperatope( )
   {
      return gxTv_SdtobraSocial_parametros_Osoprcsuperatope ;
   }

   public void setgxTv_SdtobraSocial_parametros_Osoprcsuperatope( java.math.BigDecimal value )
   {
      gxTv_SdtobraSocial_parametros_N = (byte)(0) ;
      gxTv_SdtobraSocial_parametros_Osoprcsuperatope = value ;
   }

   public java.math.BigDecimal getgxTv_SdtobraSocial_parametros_Osoprchastatope( )
   {
      return gxTv_SdtobraSocial_parametros_Osoprchastatope ;
   }

   public void setgxTv_SdtobraSocial_parametros_Osoprchastatope( java.math.BigDecimal value )
   {
      gxTv_SdtobraSocial_parametros_N = (byte)(0) ;
      gxTv_SdtobraSocial_parametros_Osoprchastatope = value ;
   }

   public java.math.BigDecimal getgxTv_SdtobraSocial_parametros_Osoprcanssalsuperatope( )
   {
      return gxTv_SdtobraSocial_parametros_Osoprcanssalsuperatope ;
   }

   public void setgxTv_SdtobraSocial_parametros_Osoprcanssalsuperatope( java.math.BigDecimal value )
   {
      gxTv_SdtobraSocial_parametros_N = (byte)(0) ;
      gxTv_SdtobraSocial_parametros_Osoprcanssalsuperatope = value ;
   }

   public java.math.BigDecimal getgxTv_SdtobraSocial_parametros_Osoprcanssalhastatope( )
   {
      return gxTv_SdtobraSocial_parametros_Osoprcanssalhastatope ;
   }

   public void setgxTv_SdtobraSocial_parametros_Osoprcanssalhastatope( java.math.BigDecimal value )
   {
      gxTv_SdtobraSocial_parametros_N = (byte)(0) ;
      gxTv_SdtobraSocial_parametros_Osoprcanssalhastatope = value ;
   }

   public boolean getgxTv_SdtobraSocial_parametros_Osojerarquica( )
   {
      return gxTv_SdtobraSocial_parametros_Osojerarquica ;
   }

   public void setgxTv_SdtobraSocial_parametros_Osojerarquica( boolean value )
   {
      gxTv_SdtobraSocial_parametros_N = (byte)(0) ;
      gxTv_SdtobraSocial_parametros_Osojerarquica = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtobraSocial_parametros_Osoprcsuperatope = DecimalUtil.ZERO ;
      gxTv_SdtobraSocial_parametros_N = (byte)(1) ;
      gxTv_SdtobraSocial_parametros_Osoprchastatope = DecimalUtil.ZERO ;
      gxTv_SdtobraSocial_parametros_Osoprcanssalsuperatope = DecimalUtil.ZERO ;
      gxTv_SdtobraSocial_parametros_Osoprcanssalhastatope = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtobraSocial_parametros_N ;
   }

   public web.SdtobraSocial_parametros Clone( )
   {
      return (web.SdtobraSocial_parametros)(clone()) ;
   }

   public void setStruct( web.StructSdtobraSocial_parametros struct )
   {
      setgxTv_SdtobraSocial_parametros_Osoprcsuperatope(struct.getOsoprcsuperatope());
      setgxTv_SdtobraSocial_parametros_Osoprchastatope(struct.getOsoprchastatope());
      setgxTv_SdtobraSocial_parametros_Osoprcanssalsuperatope(struct.getOsoprcanssalsuperatope());
      setgxTv_SdtobraSocial_parametros_Osoprcanssalhastatope(struct.getOsoprcanssalhastatope());
      setgxTv_SdtobraSocial_parametros_Osojerarquica(struct.getOsojerarquica());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtobraSocial_parametros getStruct( )
   {
      web.StructSdtobraSocial_parametros struct = new web.StructSdtobraSocial_parametros ();
      struct.setOsoprcsuperatope(getgxTv_SdtobraSocial_parametros_Osoprcsuperatope());
      struct.setOsoprchastatope(getgxTv_SdtobraSocial_parametros_Osoprchastatope());
      struct.setOsoprcanssalsuperatope(getgxTv_SdtobraSocial_parametros_Osoprcanssalsuperatope());
      struct.setOsoprcanssalhastatope(getgxTv_SdtobraSocial_parametros_Osoprcanssalhastatope());
      struct.setOsojerarquica(getgxTv_SdtobraSocial_parametros_Osojerarquica());
      return struct ;
   }

   protected byte gxTv_SdtobraSocial_parametros_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_SdtobraSocial_parametros_Osoprcsuperatope ;
   protected java.math.BigDecimal gxTv_SdtobraSocial_parametros_Osoprchastatope ;
   protected java.math.BigDecimal gxTv_SdtobraSocial_parametros_Osoprcanssalsuperatope ;
   protected java.math.BigDecimal gxTv_SdtobraSocial_parametros_Osoprcanssalhastatope ;
   protected String sTagName ;
   protected boolean gxTv_SdtobraSocial_parametros_Osojerarquica ;
   protected boolean readElement ;
   protected boolean formatError ;
}

