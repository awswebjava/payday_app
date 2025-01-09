package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtpct_embargo_rango extends GxUserType
{
   public Sdtpct_embargo_rango( )
   {
      this(  new ModelContext(Sdtpct_embargo_rango.class));
   }

   public Sdtpct_embargo_rango( ModelContext context )
   {
      super( context, "Sdtpct_embargo_rango");
   }

   public Sdtpct_embargo_rango( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle, context, "Sdtpct_embargo_rango");
   }

   public Sdtpct_embargo_rango( StructSdtpct_embargo_rango struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "hastaRemuneracion") )
            {
               gxTv_Sdtpct_embargo_rango_Hastaremuneracion = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "alicuota") )
            {
               gxTv_Sdtpct_embargo_rango_Alicuota = DecimalUtil.stringToDec( oReader.getValue()) ;
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
         sName = "pct_embargo.rango" ;
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
      oWriter.writeElement("hastaRemuneracion", GXutil.trim( GXutil.strNoRound( gxTv_Sdtpct_embargo_rango_Hastaremuneracion, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("alicuota", GXutil.trim( GXutil.strNoRound( gxTv_Sdtpct_embargo_rango_Alicuota, 6, 4)));
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
      AddObjectProperty("hastaRemuneracion", gxTv_Sdtpct_embargo_rango_Hastaremuneracion, false, false);
      AddObjectProperty("alicuota", gxTv_Sdtpct_embargo_rango_Alicuota, false, false);
   }

   public java.math.BigDecimal getgxTv_Sdtpct_embargo_rango_Hastaremuneracion( )
   {
      return gxTv_Sdtpct_embargo_rango_Hastaremuneracion ;
   }

   public void setgxTv_Sdtpct_embargo_rango_Hastaremuneracion( java.math.BigDecimal value )
   {
      gxTv_Sdtpct_embargo_rango_N = (byte)(0) ;
      gxTv_Sdtpct_embargo_rango_Hastaremuneracion = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtpct_embargo_rango_Alicuota( )
   {
      return gxTv_Sdtpct_embargo_rango_Alicuota ;
   }

   public void setgxTv_Sdtpct_embargo_rango_Alicuota( java.math.BigDecimal value )
   {
      gxTv_Sdtpct_embargo_rango_N = (byte)(0) ;
      gxTv_Sdtpct_embargo_rango_Alicuota = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtpct_embargo_rango_Hastaremuneracion = DecimalUtil.ZERO ;
      gxTv_Sdtpct_embargo_rango_N = (byte)(1) ;
      gxTv_Sdtpct_embargo_rango_Alicuota = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtpct_embargo_rango_N ;
   }

   public web.Sdtpct_embargo_rango Clone( )
   {
      return (web.Sdtpct_embargo_rango)(clone()) ;
   }

   public void setStruct( web.StructSdtpct_embargo_rango struct )
   {
      setgxTv_Sdtpct_embargo_rango_Hastaremuneracion(struct.getHastaremuneracion());
      setgxTv_Sdtpct_embargo_rango_Alicuota(struct.getAlicuota());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtpct_embargo_rango getStruct( )
   {
      web.StructSdtpct_embargo_rango struct = new web.StructSdtpct_embargo_rango ();
      struct.setHastaremuneracion(getgxTv_Sdtpct_embargo_rango_Hastaremuneracion());
      struct.setAlicuota(getgxTv_Sdtpct_embargo_rango_Alicuota());
      return struct ;
   }

   protected byte gxTv_Sdtpct_embargo_rango_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_Sdtpct_embargo_rango_Hastaremuneracion ;
   protected java.math.BigDecimal gxTv_Sdtpct_embargo_rango_Alicuota ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

