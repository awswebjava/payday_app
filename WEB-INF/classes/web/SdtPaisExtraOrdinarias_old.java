package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtPaisExtraOrdinarias_old extends GxUserType
{
   public SdtPaisExtraOrdinarias_old( )
   {
      this(  new ModelContext(SdtPaisExtraOrdinarias_old.class));
   }

   public SdtPaisExtraOrdinarias_old( ModelContext context )
   {
      super( context, "SdtPaisExtraOrdinarias_old");
   }

   public SdtPaisExtraOrdinarias_old( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle, context, "SdtPaisExtraOrdinarias_old");
   }

   public SdtPaisExtraOrdinarias_old( StructSdtPaisExtraOrdinarias_old struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiHsPDiaTipTra") )
            {
               gxTv_SdtPaisExtraOrdinarias_old_Paihspdiatiptra = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiHsPDiaDia") )
            {
               gxTv_SdtPaisExtraOrdinarias_old_Paihspdiadia = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiHsPDiaDesde") )
            {
               gxTv_SdtPaisExtraOrdinarias_old_Paihspdiadesde = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTarifaPDia") )
            {
               gxTv_SdtPaisExtraOrdinarias_old_Paitarifapdia = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTarifaPDRec") )
            {
               gxTv_SdtPaisExtraOrdinarias_old_Paitarifapdrec = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTarifaPDCri") )
            {
               gxTv_SdtPaisExtraOrdinarias_old_Paitarifapdcri = oReader.getValue() ;
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
         sName = "PaisExtraOrdinarias_old" ;
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
      oWriter.writeElement("PaiHsPDiaTipTra", gxTv_SdtPaisExtraOrdinarias_old_Paihspdiatiptra);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiHsPDiaDia", GXutil.trim( GXutil.str( gxTv_SdtPaisExtraOrdinarias_old_Paihspdiadia, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiHsPDiaDesde", gxTv_SdtPaisExtraOrdinarias_old_Paihspdiadesde);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiTarifaPDia", GXutil.trim( GXutil.strNoRound( gxTv_SdtPaisExtraOrdinarias_old_Paitarifapdia, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiTarifaPDRec", GXutil.trim( GXutil.strNoRound( gxTv_SdtPaisExtraOrdinarias_old_Paitarifapdrec, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiTarifaPDCri", gxTv_SdtPaisExtraOrdinarias_old_Paitarifapdcri);
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
      AddObjectProperty("PaiHsPDiaTipTra", gxTv_SdtPaisExtraOrdinarias_old_Paihspdiatiptra, false, false);
      AddObjectProperty("PaiHsPDiaDia", gxTv_SdtPaisExtraOrdinarias_old_Paihspdiadia, false, false);
      AddObjectProperty("PaiHsPDiaDesde", gxTv_SdtPaisExtraOrdinarias_old_Paihspdiadesde, false, false);
      AddObjectProperty("PaiTarifaPDia", gxTv_SdtPaisExtraOrdinarias_old_Paitarifapdia, false, false);
      AddObjectProperty("PaiTarifaPDRec", gxTv_SdtPaisExtraOrdinarias_old_Paitarifapdrec, false, false);
      AddObjectProperty("PaiTarifaPDCri", gxTv_SdtPaisExtraOrdinarias_old_Paitarifapdcri, false, false);
   }

   public String getgxTv_SdtPaisExtraOrdinarias_old_Paihspdiatiptra( )
   {
      return gxTv_SdtPaisExtraOrdinarias_old_Paihspdiatiptra ;
   }

   public void setgxTv_SdtPaisExtraOrdinarias_old_Paihspdiatiptra( String value )
   {
      gxTv_SdtPaisExtraOrdinarias_old_N = (byte)(0) ;
      gxTv_SdtPaisExtraOrdinarias_old_Paihspdiatiptra = value ;
   }

   public byte getgxTv_SdtPaisExtraOrdinarias_old_Paihspdiadia( )
   {
      return gxTv_SdtPaisExtraOrdinarias_old_Paihspdiadia ;
   }

   public void setgxTv_SdtPaisExtraOrdinarias_old_Paihspdiadia( byte value )
   {
      gxTv_SdtPaisExtraOrdinarias_old_N = (byte)(0) ;
      gxTv_SdtPaisExtraOrdinarias_old_Paihspdiadia = value ;
   }

   public String getgxTv_SdtPaisExtraOrdinarias_old_Paihspdiadesde( )
   {
      return gxTv_SdtPaisExtraOrdinarias_old_Paihspdiadesde ;
   }

   public void setgxTv_SdtPaisExtraOrdinarias_old_Paihspdiadesde( String value )
   {
      gxTv_SdtPaisExtraOrdinarias_old_N = (byte)(0) ;
      gxTv_SdtPaisExtraOrdinarias_old_Paihspdiadesde = value ;
   }

   public java.math.BigDecimal getgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdia( )
   {
      return gxTv_SdtPaisExtraOrdinarias_old_Paitarifapdia ;
   }

   public void setgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdia( java.math.BigDecimal value )
   {
      gxTv_SdtPaisExtraOrdinarias_old_N = (byte)(0) ;
      gxTv_SdtPaisExtraOrdinarias_old_Paitarifapdia = value ;
   }

   public java.math.BigDecimal getgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdrec( )
   {
      return gxTv_SdtPaisExtraOrdinarias_old_Paitarifapdrec ;
   }

   public void setgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdrec( java.math.BigDecimal value )
   {
      gxTv_SdtPaisExtraOrdinarias_old_N = (byte)(0) ;
      gxTv_SdtPaisExtraOrdinarias_old_Paitarifapdrec = value ;
   }

   public String getgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdcri( )
   {
      return gxTv_SdtPaisExtraOrdinarias_old_Paitarifapdcri ;
   }

   public void setgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdcri( String value )
   {
      gxTv_SdtPaisExtraOrdinarias_old_N = (byte)(0) ;
      gxTv_SdtPaisExtraOrdinarias_old_Paitarifapdcri = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtPaisExtraOrdinarias_old_Paihspdiatiptra = "" ;
      gxTv_SdtPaisExtraOrdinarias_old_N = (byte)(1) ;
      gxTv_SdtPaisExtraOrdinarias_old_Paihspdiadesde = "" ;
      gxTv_SdtPaisExtraOrdinarias_old_Paitarifapdia = DecimalUtil.ZERO ;
      gxTv_SdtPaisExtraOrdinarias_old_Paitarifapdrec = DecimalUtil.ZERO ;
      gxTv_SdtPaisExtraOrdinarias_old_Paitarifapdcri = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtPaisExtraOrdinarias_old_N ;
   }

   public web.SdtPaisExtraOrdinarias_old Clone( )
   {
      return (web.SdtPaisExtraOrdinarias_old)(clone()) ;
   }

   public void setStruct( web.StructSdtPaisExtraOrdinarias_old struct )
   {
      setgxTv_SdtPaisExtraOrdinarias_old_Paihspdiatiptra(struct.getPaihspdiatiptra());
      setgxTv_SdtPaisExtraOrdinarias_old_Paihspdiadia(struct.getPaihspdiadia());
      setgxTv_SdtPaisExtraOrdinarias_old_Paihspdiadesde(struct.getPaihspdiadesde());
      setgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdia(struct.getPaitarifapdia());
      setgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdrec(struct.getPaitarifapdrec());
      setgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdcri(struct.getPaitarifapdcri());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtPaisExtraOrdinarias_old getStruct( )
   {
      web.StructSdtPaisExtraOrdinarias_old struct = new web.StructSdtPaisExtraOrdinarias_old ();
      struct.setPaihspdiatiptra(getgxTv_SdtPaisExtraOrdinarias_old_Paihspdiatiptra());
      struct.setPaihspdiadia(getgxTv_SdtPaisExtraOrdinarias_old_Paihspdiadia());
      struct.setPaihspdiadesde(getgxTv_SdtPaisExtraOrdinarias_old_Paihspdiadesde());
      struct.setPaitarifapdia(getgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdia());
      struct.setPaitarifapdrec(getgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdrec());
      struct.setPaitarifapdcri(getgxTv_SdtPaisExtraOrdinarias_old_Paitarifapdcri());
      return struct ;
   }

   protected byte gxTv_SdtPaisExtraOrdinarias_old_N ;
   protected byte gxTv_SdtPaisExtraOrdinarias_old_Paihspdiadia ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_SdtPaisExtraOrdinarias_old_Paitarifapdia ;
   protected java.math.BigDecimal gxTv_SdtPaisExtraOrdinarias_old_Paitarifapdrec ;
   protected String gxTv_SdtPaisExtraOrdinarias_old_Paihspdiatiptra ;
   protected String gxTv_SdtPaisExtraOrdinarias_old_Paihspdiadesde ;
   protected String gxTv_SdtPaisExtraOrdinarias_old_Paitarifapdcri ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

