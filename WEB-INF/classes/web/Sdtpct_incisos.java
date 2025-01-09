package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtpct_incisos extends GxUserType
{
   public Sdtpct_incisos( )
   {
      this(  new ModelContext(Sdtpct_incisos.class));
   }

   public Sdtpct_incisos( ModelContext context )
   {
      super( context, "Sdtpct_incisos");
   }

   public Sdtpct_incisos( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle, context, "Sdtpct_incisos");
   }

   public Sdtpct_incisos( StructSdtpct_incisos struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "A") )
            {
               gxTv_Sdtpct_incisos_A = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "B") )
            {
               gxTv_Sdtpct_incisos_B = DecimalUtil.stringToDec( oReader.getValue()) ;
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
         sName = "pct_incisos" ;
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
      oWriter.writeElement("A", GXutil.trim( GXutil.strNoRound( gxTv_Sdtpct_incisos_A, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("B", GXutil.trim( GXutil.strNoRound( gxTv_Sdtpct_incisos_B, 6, 4)));
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
      AddObjectProperty("A", gxTv_Sdtpct_incisos_A, false, false);
      AddObjectProperty("B", gxTv_Sdtpct_incisos_B, false, false);
   }

   public java.math.BigDecimal getgxTv_Sdtpct_incisos_A( )
   {
      return gxTv_Sdtpct_incisos_A ;
   }

   public void setgxTv_Sdtpct_incisos_A( java.math.BigDecimal value )
   {
      gxTv_Sdtpct_incisos_N = (byte)(0) ;
      gxTv_Sdtpct_incisos_A = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtpct_incisos_B( )
   {
      return gxTv_Sdtpct_incisos_B ;
   }

   public void setgxTv_Sdtpct_incisos_B( java.math.BigDecimal value )
   {
      gxTv_Sdtpct_incisos_N = (byte)(0) ;
      gxTv_Sdtpct_incisos_B = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtpct_incisos_A = DecimalUtil.ZERO ;
      gxTv_Sdtpct_incisos_N = (byte)(1) ;
      gxTv_Sdtpct_incisos_B = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtpct_incisos_N ;
   }

   public web.Sdtpct_incisos Clone( )
   {
      return (web.Sdtpct_incisos)(clone()) ;
   }

   public void setStruct( web.StructSdtpct_incisos struct )
   {
      setgxTv_Sdtpct_incisos_A(struct.getA());
      setgxTv_Sdtpct_incisos_B(struct.getB());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtpct_incisos getStruct( )
   {
      web.StructSdtpct_incisos struct = new web.StructSdtpct_incisos ();
      struct.setA(getgxTv_Sdtpct_incisos_A());
      struct.setB(getgxTv_Sdtpct_incisos_B());
      return struct ;
   }

   protected byte gxTv_Sdtpct_incisos_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_Sdtpct_incisos_A ;
   protected java.math.BigDecimal gxTv_Sdtpct_incisos_B ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

